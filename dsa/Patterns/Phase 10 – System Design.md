# 📘 Phase 10 – System Design

> **"Data Structures solve coding problems. System Design solves real-world engineering problems at scale."**

This phase brings together everything you've learned so far.

You'll learn how to design systems that can serve **millions or even billions of users** while remaining scalable, reliable, secure, and maintainable.

Instead of memorizing architectures, this phase teaches **how to think like a System Designer** by understanding **the problem first**, then choosing the right technologies.

---

# 🎯 Learning Objective

By the end of this phase, you should understand:

* How to approach a System Design interview.
* How to gather functional and non-functional requirements.
* How to estimate system capacity.
* How to choose the right architecture.
* How to identify bottlenecks.
* How to scale applications.
* How Google designs systems for billions of users.

---

# 🌍 Evolution of System Design

Every design component solves a scalability problem.

```text
Simple Application
        │
        ▼
Millions of Users
        │
        ▼
Requirements
        │
        ▼
Capacity Estimation
        │
        ▼
API Design
        │
        ▼
Database Design
        │
        ▼
Load Balancer
        │
        ▼
Cache
        │
        ▼
Message Queue
        │
        ▼
Microservices
        │
        ▼
Monitoring
        │
        ▼
Highly Scalable System
```

> **Remember:** Good System Design is choosing the right trade-offs, not the most technologies.

---

# 📚 Topics Covered

* System Design Framework
* Functional Requirements
* Non-Functional Requirements
* Capacity Estimation
* API Design
* Database Design
* High-Level Design
* Load Balancer
* Cache
* CDN
* Message Queue
* Microservices
* Monitoring & Logging
* Trade-offs

---

# 📝 Functional Requirements

### 📌 Why?

Before building anything, understand **what the system should do**.

### 🌍 Real-Life Example

Building a food delivery app.

Users should:

* Login
* Order food
* Track orders
* Make payments

These are Functional Requirements.

### 🏗 Problem Solved

Defines system features.

### ☁ Google Example

Google Drive

* Upload files
* Download files
* Share files

### 💻 Java / Backend

Backend APIs implement Functional Requirements.

### 🧠 DSA Connection

❌ None

Requirement gathering.

### ⚡ One-Line Interview Answer

Functional Requirements describe what the system should do.

---

# ⚡ Non-Functional Requirements

### 📌 Why?

Knowing features isn't enough.

We must know how well they should work.

### 🌍 Real-Life Example

Restaurant requirements:

* Fast service
* Clean environment
* Reliable staff

These don't describe features.

They describe quality.

### 🏗 Problem Solved

Defines system quality.

### Examples

* Scalability
* Availability
* Reliability
* Security
* Latency
* Fault Tolerance

### ☁ Google Example

Google Search returns results within milliseconds.

### 💻 Java / Backend

Performance tuning.

### 🧠 DSA Connection

❌ None

Architecture concept.

### ⚡ One-Line Interview Answer

Non-Functional Requirements describe how well the system should perform.

---

# 📊 Capacity Estimation

### 📌 Why?

Before building infrastructure, estimate traffic.

### 🌍 Real-Life Example

Before opening a cinema,

estimate:

* Visitors
* Parking
* Seats

### 🏗 Problem Solved

Infrastructure planning.

### ☁ Google Example

Estimate requests, storage, bandwidth, servers.

### 💻 Java / Backend

DAU

MAU

QPS

Storage estimation.

### 🧠 DSA Connection

❌ None

Planning concept.

### ⚡ One-Line Interview Answer

Capacity Estimation predicts infrastructure requirements before building the system.

---

# 🌐 API Design

### 📌 Why?

Clients need a standard way to communicate.

### 🌍 Real-Life Example

Restaurant menu.

### 🏗 Problem Solved

Communication between clients and backend.

### ☁ Google Example

Google Maps API.

### 💻 Java / Backend

REST APIs

gRPC

### 🧠 DSA Connection

🧠 Direct

HashMap (Routing)

### ⚡ One-Line Interview Answer

API Design defines how applications communicate.

---

# 🗄 Database Design

### 📌 Why?

Applications need efficient storage.

### 🌍 Real-Life Example

Library organization.

### 🏗 Problem Solved

Efficient storage.

### ☁ Google Example

Spanner

Bigtable

### 💻 Java / Backend

SQL

NoSQL

### 🧠 DSA Connection

🧠 Direct

Trees

HashMap

Indexes

### ⚡ One-Line Interview Answer

Database Design organizes data for efficient storage and retrieval.

---

# ⚖ Load Balancer

### 📌 Why?

One server cannot handle all traffic.

### 🌍 Real-Life Example

Traffic police directing vehicles.

### 🏗 Problem Solved

Traffic distribution.

### ☁ Google Example

Google Cloud Load Balancer.

### 💻 Java / Backend

NGINX

### 🧠 DSA Connection

🧠 Direct

Routing

HashMap

### ⚡ One-Line Interview Answer

A Load Balancer distributes requests across multiple servers.

---

# ⚡ Cache

### 📌 Why?

Repeated database queries are expensive.

### 🌍 Real-Life Example

Keeping frequently used books on your study table.

### 🏗 Problem Solved

Reduce latency.

### ☁ Google Example

Google Search cache.

YouTube cache.

### 💻 Java / Backend

Redis

### 🧠 DSA Connection

🧠 Direct

HashMap

LRU Cache

### ⚡ One-Line Interview Answer

A Cache stores frequently accessed data for faster retrieval.

---

# 📬 Message Queue

### 📌 Why?

Background tasks should not block users.

### 🌍 Real-Life Example

Courier office processing parcels later.

### 🏗 Problem Solved

Asynchronous processing.

### ☁ Google Example

Pub/Sub

### 💻 Java / Backend

Kafka

RabbitMQ

### 🧠 DSA Connection

🧠 Direct

Queue

### ⚡ One-Line Interview Answer

A Message Queue enables asynchronous task processing.

---

# 🧩 Microservices

### 📌 Why?

Large systems become difficult to maintain.

### 🌍 Real-Life Example

Separate departments in a company.

### 🏗 Problem Solved

Independent deployment.

Independent scaling.

### ☁ Google Example

Search

Gmail

Maps

### 💻 Java / Backend

Spring Boot Microservices.

### 🧠 DSA Connection

🔄 Indirect

Graph

### ⚡ One-Line Interview Answer

Microservices divide a large application into smaller independent services.

---

# 📈 Monitoring & Logging

### 📌 Why?

You can't fix problems you cannot see.

### 🌍 Real-Life Example

A car dashboard showing fuel level and engine warnings.

### 🏗 Problem Solved

Detect failures.

Analyze issues.

Measure performance.

### ☁ Google Example

Cloud Monitoring

Cloud Logging

### 💻 Java / Backend

Prometheus

Grafana

ELK

### 🧠 DSA Connection

❌ None

Observability concept.

### ⚡ One-Line Interview Answer

Monitoring and Logging help detect, analyze, and troubleshoot production systems.

---

# ⚖ Trade-offs

### 📌 Why?

Every design decision has advantages and disadvantages.

### 🌍 Real-Life Example

Buying a sports car gives speed but less luggage space.

Buying an SUV gives space but lower speed.

### 🏗 Problem Solved

Choosing the right architecture.

### ☁ Google Example

CAP Theorem decisions.

### 💻 Java / Backend

Consistency vs Availability.

### 🧠 DSA Connection

❌ None

Engineering decision-making.

### ⚡ One-Line Interview Answer

System Design is about choosing the best trade-offs for the given requirements.

---

# 🧠 DSA Connections

| System Design Concept       | DSA Connection                 | Why?                      |
| --------------------------- | ------------------------------ | ------------------------- |
| Functional Requirements     | ❌ None                         | Requirement gathering.    |
| Non-Functional Requirements | ❌ None                         | Quality attributes.       |
| Capacity Estimation         | ❌ None                         | Infrastructure planning.  |
| API Design                  | 🧠 Direct – HashMap            | Endpoint routing.         |
| Database Design             | 🧠 Direct – Trees, HashMap     | Indexes and lookups.      |
| Load Balancer               | 🧠 Direct – HashMap            | Routing requests.         |
| Cache                       | 🧠 Direct – HashMap, LRU Cache | Fast retrieval.           |
| Message Queue               | 🧠 Direct – Queue              | FIFO processing.          |
| Microservices               | 🔄 Indirect – Graph            | Service dependency graph. |
| Monitoring                  | ❌ None                         | Observability.            |
| Trade-offs                  | ❌ None                         | Architecture decisions.   |

---

# ☁ Google Products Connection

| Product       | System Design Concepts Used                 |
| ------------- | ------------------------------------------- |
| Google Search | Cache, Load Balancer, Distributed Databases |
| Gmail         | Pub/Sub, Queue, Replication                 |
| YouTube       | CDN, Cache, Queue                           |
| Google Maps   | Graph Services, Cache                       |
| Google Drive  | Replication, Microservices                  |
| Google Cloud  | Every concept in this phase                 |

---

# 🎤 Most Asked Interview Questions

* How do you start a System Design interview?
* Functional vs Non-Functional Requirements?
* How do you estimate capacity?
* SQL vs NoSQL?
* Why use a Cache?
* Why use a Load Balancer?
* Why use a Message Queue?
* Monolith vs Microservices?
* How do you scale a system?
* What trade-offs would you make?

---

# 🚀 Phase 10 Summary

Need to build a scalable system.

↓

Gather Requirements.

↓

Estimate Capacity.

↓

Design APIs.

↓

Design Database.

↓

Distribute Traffic.

↓

Load Balancer.

↓

Reduce Database Load.

↓

Cache.

↓

Handle Background Tasks.

↓

Message Queue.

↓

Independent Services.

↓

Microservices.

↓

Observe System Health.

↓

Monitoring & Logging.

↓

Choose the Right Trade-offs.

↓

Scalable System.

---

# 🎯 Interview Mindset

| If you hear...                 | Think...                    |
| ------------------------------ | --------------------------- |
| "What should the system do?"   | Functional Requirements     |
| "How fast should it be?"       | Non-Functional Requirements |
| "Millions of users"            | Capacity Estimation         |
| "Public interface"             | API Design                  |
| "Store data"                   | Database Design             |
| "One server overloaded"        | Load Balancer               |
| "Repeated queries"             | Cache                       |
| "Background task"              | Message Queue               |
| "Independent deployment"       | Microservices               |
| "Production issue"             | Monitoring                  |
| "Choose between two solutions" | Trade-offs                  |

---

# 🔗 Next Phase

## 📘 Phase 11 – Google Engineering Practices

You'll learn how Google engineers build, review, deploy, monitor, and maintain software in production.

Topics include:

* Design Reviews
* Code Reviews
* Version Control
* CI/CD
* Testing
* Feature Flags
* Canary Deployments
* Monitoring
* Logging
* Site Reliability Engineering (SRE)

This phase explains **how professional software engineering teams build reliable software**, not just how they write code.
