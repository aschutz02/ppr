# 🗄️ Database Module – PPR Project

This module demonstrates the **ACID** properties of databases using **PostgreSQL (SQL)** and **MongoDB (NoSQL)**. It includes practical tests that simulate transactional behavior using **Testcontainers** to spin up isolated, containerized database instances during test execution.

---

## 📚 What is ACID?

ACID stands for:

- **Atomicity** – All operations in a transaction succeed or none do.
- **Consistency** – The database remains in a valid state before and after the transaction.
- **Isolation** – Transactions are executed independently and concurrently without interference.
- **Durability** – Once a transaction is committed, it remains persistent even in case of system failure.

ACID ensures **reliability, predictability, and integrity** in database transactions.

---

## 🆚 SQL vs NoSQL in Terms of ACID

| Feature             | SQL (PostgreSQL)                       | NoSQL (MongoDB)                                 |
|---------------------|-----------------------------------------|--------------------------------------------------|
| **ACID Support**     | Full ACID compliance (transactions, constraints, locks) | Partial ACID; full only for single-document transactions |
| **Schema**           | Fixed schema                           | Flexible, dynamic schema                         |
| **Scalability**      | Vertical (scale-up)                    | Horizontal (scale-out)                           |
| **Query Language**   | SQL                                    | JSON-like query syntax                           |
| **Best For**         | Complex queries, strict data integrity | High throughput, unstructured or semi-structured data |

### ✅ When to Use SQL (PostgreSQL)

- Applications requiring strong data consistency and integrity
- Complex relationships between entities (e.g., joins)
- Financial, banking, and enterprise systems
- When enforcing constraints and strict schemas is essential

### ✅ When to Use NoSQL (MongoDB)

- High volume, rapidly changing, or loosely structured data
- Applications that prioritize speed and flexibility over strong consistency
- Scenarios where schema evolution is frequent (e.g., product catalogs, user profiles)
- Real-time analytics and event logging

---

## 🧪 ACID Test Implementation

This module uses **Testcontainers** to launch real PostgreSQL and MongoDB containers during testing, ensuring isolated, reproducible environments.

### PostgreSQL

- Tests cover full ACID transaction behavior
- Demonstrates rollback, commit, etc.

### MongoDB

- Tests focus on single-document atomicity and durability
- Shows limitations of multi-document transactional support
