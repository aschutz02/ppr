# 📦 PPR

**PPR** is a modular project consisting of three independent modules that demonstrate practical concepts in databases, algorithm analysis, and cloud deployment using AWS. It is organized into the following modules:

- [`database`](./database): Demonstrates the ACID properties in SQL and NoSQL databases.
- [`algorithms`](./algorithms): Implements and benchmarks classic algorithms.
- [`aws`](./aws): A Spring application containerized with Docker and deployed to AWS.

---

## 🗂 Project Structure

ppr/
├── database/
├── algorithms/
└── aws/

---

## 📁 Modules Overview

### 1. `database/` – ACID Property Demonstration

This module showcases the **ACID** (Atomicity, Consistency, Isolation, Durability) properties of database transactions using:

- **PostgreSQL (SQL)** – A traditional relational database.
- **MongoDB (NoSQL)** – A document-oriented NoSQL database.

> Includes unit tests that demonstrate transaction behavior and data integrity under different scenarios.

---

### 2. `algorithms/` – Algorithm Implementations & Benchmarks

Implements the following algorithms with performance testing:

- **Searching**:
    - Binary Search
- **Sorting**:
    - Bubble Sort
    - Merge Sort
    - QuickSort
    - Selection Sort
- **Others**:
    - Fibonacci Sequence (recursive and iterative)
    - Permutations

> Includes test cases and performance benchmarks (execution time, complexity analysis) to compare algorithm efficiency.

---

### 3. `aws/` – Spring App Deployed on AWS

A full-featured **Spring Boot** application that includes:

- RESTful APIs
- Docker containerization
- AWS deployment support (EC2)

> Environment-aware and ready for production deployment with cloud integration.

---

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Docker
- Maven

---

## 🧪 Running Tests

From the root of each module:

```bash
# For database module
cd database
./mvnw test

# For algorithms module
cd ../algorithms
./mvnw test
