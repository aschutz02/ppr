package com.sigma.ppr.database;

import org.junit.jupiter.api.*;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.*;
import com.mongodb.client.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AcidSupportTest {

    PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16");
    MongoDBContainer mongo = new MongoDBContainer("mongo:7");

    Connection sqlConnection;
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;

    @BeforeAll
    void setUp() throws Exception {
        postgres.start();
        mongo.start();

        sqlConnection = DriverManager.getConnection(
                postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());

        try (Statement stmt = sqlConnection.createStatement()) {
            stmt.execute("CREATE TABLE accounts (id SERIAL PRIMARY KEY, name VARCHAR(100), balance INT)");
        }

        mongoClient = MongoClients.create(mongo.getReplicaSetUrl());
        mongoDatabase = mongoClient.getDatabase("test");
    }

    @AfterAll
    void tearDown() throws Exception {
        sqlConnection.close();
        mongoClient.close();
        postgres.stop();
        mongo.stop();
    }

    @Test
    void should_test_transaction_rollback_in_SQL() throws Exception {
        // given manual transaction
        sqlConnection.setAutoCommit(false);

        // when insert operation is triggered
        try (PreparedStatement insert = sqlConnection.prepareStatement(
                "INSERT INTO accounts(name, balance) VALUES (?, ?)")) {

            insert.setString(1, "Alice");
            insert.setInt(2, 100);
            insert.executeUpdate();

            // and simulates failure
            if (true) throw new RuntimeException("Transaction error");

            insert.setString(1, "Bob");
            insert.setInt(2, 200);
            insert.executeUpdate();

            sqlConnection.commit();
        } catch (Exception e) {
            // rollback transaction
            sqlConnection.rollback();
        }

        // then no record on DB
        try (Statement stmt = sqlConnection.createStatement();
             // should return 0, proving that nothing was persisted.
             var result = stmt.executeQuery("SELECT COUNT(*) FROM accounts")) {

            result.next();
            int count = result.getInt(1);
            assertEquals(0, count);
        }
    }

    @Test
    void should_test_no_transaction_support_in_mongo() {
        // given create collection
        var collection = mongoDatabase.getCollection("accounts");

        collection.drop();

        // when insert operation is triggered
        try {
            collection.insertOne(new org.bson.Document("name", "Alice").append("balance", 100));
            // simulates failure (no explicit transaction)
            if (true) throw new RuntimeException("Error after insertion");

            collection.insertOne(new org.bson.Document("name", "Bob").append("balance", 200));
        } catch (Exception e) {
            // no rollback
        }

        // then 1 record should be on DB
        long count = collection.countDocuments();
        assertEquals(1, count);
    }
}

