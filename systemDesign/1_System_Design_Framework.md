# 🏗️ System Design Framework

System Design is the process of deciding **how different components of a software system should work together** to satisfy business requirements and handle users efficiently.

When solving a System Design problem, it is important to follow a structured framework instead of immediately drawing architecture diagrams.

The general framework is:

```text
1. Requirements
        ↓
2. Capacity Estimation
        ↓
3. API Design
        ↓
4. High-Level Design
        ↓
5. Deep Dive
```

---

# 1. Deciding Requirements

The first step in System Design is understanding:

> **What are we actually building?**

Before thinking about databases, servers, caches, or architecture, we must clearly understand the requirements.

Requirements are mainly divided into two categories:

```text
Requirements
    |
    ├── Functional Requirements
    |
    └── Non-Functional Requirements
```

## Functional Requirements

Functional Requirements describe:

> **What should the system do?**

These are the features provided by the system.

For example, imagine we are designing a URL Shortener.

Functional Requirements could be:

* Users can submit a long URL.
* The system generates a short URL.
* Users can open the short URL.
* The system redirects users to the original URL.
* Users can optionally set an expiration date.

Another example is designing a messaging application.

Functional Requirements could be:

* Users can send messages.
* Users can receive messages.
* Users can create groups.
* Users can send images and videos.

Therefore:

```text
Functional Requirements
        =
What features should the system provide?
```

---

## Non-Functional Requirements

Non-Functional Requirements describe:

> **How well should the system perform?**

They describe the quality and behavior of the system.

Important Non-Functional Requirements include:

### Availability

The system should remain accessible to users.

Example:

```text
User sends request
        ↓
Server is available
        ↓
User receives response
```

A highly available system should continue working even when some servers fail.

---

### Eventual Consistency

In distributed systems, all servers may not receive updated data immediately.

However, after some time, all servers should eventually contain the same data.

Example:

```text
User updates profile
        ↓
Server A receives update
        ↓
Server B receives update slightly later
        ↓
Eventually all servers have the same data
```

This is called:

> **Eventual Consistency**

---

### Latency

Latency represents:

> **How much time does the system take to respond?**

Example:

```text
User Request
      ↓
    Server
      ↓
User Response
```

If the response takes:

```text
50 milliseconds
```

then the latency is approximately:

```text
50 ms
```

Lower latency generally means a faster user experience.

---

### Scalability

Scalability represents:

> **Can the system handle increasing numbers of users and requests?**

Example:

```text
Today

1 Million Users
        ↓
System Works
```

Later:

```text
100 Million Users
        ↓
Can the system still work efficiently?
```

If yes, the system is scalable.

---

### Extensibility

Extensibility represents:

> **How easily can new features be added to the system?**

Example:

A messaging application currently supports:

```text
Text Messages
```

Later, developers want to add:

```text
Images
Videos
Voice Messages
Video Calls
```

A well-designed system should allow these features to be added without completely redesigning the existing architecture.

---

### Usability

Usability represents:

> **How easy is the system for users to understand and use?**

A system should provide a simple and efficient user experience.

---

# 2. Capacity Estimation

After understanding the requirements, the next step is estimating the size of the system.

The main question is:

> **How much infrastructure will our system need?**

We can use the following framework:

```text
DAU / MAU
    ↓
Throughput
    ↓
Storage
    ↓
Memory
    ↓
Network / Bandwidth
```

---

## DAU / MAU

### DAU

DAU means:

> **Daily Active Users**

It represents the number of unique users who use the system every day.

Example:

```text
10 Million Daily Active Users
```

---

### MAU

MAU means:

> **Monthly Active Users**

It represents the number of unique users who use the system every month.

Example:

```text
100 Million Monthly Active Users
```

DAU and MAU help us estimate how large our system needs to be.

---

## Throughput

Throughput represents:

> **How many requests can our system process per second?**

This is commonly measured using:

```text
Requests Per Second
```

or:

```text
RPS
```

Example:

Suppose we have:

```text
1,000,000 requests per day
```

There are:

```text
86,400 seconds in one day
```

Therefore:

```text
1,000,000 / 86,400
```

gives us the approximate average Requests Per Second.

However, real systems must also consider:

```text
Peak Traffic
```

because users do not send requests evenly throughout the entire day.

---

## Storage

Storage estimation answers:

> **How much data will our system need to store?**

For example:

```text
Number of Users
        ×
Data Generated Per User
        ×
Retention Period
```

Suppose:

```text
1 Million Users

Each User Generates 1 MB Data Per Day
```

Then:

```text
1 Million × 1 MB
        =
Approximately 1 TB Per Day
```

Storage estimation helps us decide:

* Database size
* Number of database servers
* Data partitioning strategy
* Backup requirements

---

## Memory

Memory estimation answers:

> **How much RAM will our system require?**

Memory is especially important when designing:

* Caches
* Application servers
* In-memory databases

For example:

```text
Frequently Accessed Data
        ↓
Stored in Cache
        ↓
Requires Memory
```

Therefore, we need to estimate how much frequently accessed data should be stored in memory.

---

## Network / Bandwidth

Bandwidth estimation answers:

> **How much data enters and leaves our system?**

This is generally divided into:

```text
Incoming Data
        =
Ingress

Outgoing Data
        =
Egress
```

For example:

```text
Users Upload Videos
        ↓
Incoming Network Traffic

Users Watch Videos
        ↓
Outgoing Network Traffic
```

Bandwidth estimation is especially important for systems such as:

* YouTube
* Netflix
* Instagram
* Cloud Storage

---

# 3. API Design

After understanding the requirements and estimating capacity, the next step is designing the APIs.

API Design is extremely important because APIs define:

> **How clients communicate with our system.**

An API generally contains:

```text
Endpoint
    +
Request Body
    +
Response
```

---

## Endpoint

An Endpoint can be thought of as:

> **A door to a specific functionality inside the system.**

Example:

```text
POST /users
```

This endpoint could be used to create a new user.

Another example:

```text
GET /users/{userId}
```

This endpoint could retrieve information about a particular user.

---

## Request Body

The Request Body contains:

> **The input data sent to the system.**

Example:

```json
{
    "name": "John",
    "email": "john@example.com"
}
```

The client sends this information to the server.

---

## Response

The Response contains:

> **The output returned by the server after processing the request.**

Example:

```json
{
    "userId": 123,
    "name": "John",
    "email": "john@example.com"
}
```

The complete API flow looks like:

```text
Client
    ↓
API Request
    ↓
Endpoint
    ↓
Server Processes Request
    ↓
Response
    ↓
Client
```

---

## Why Design APIs Before the Database and Architecture?

API Design acts as a contract between:

```text
Client
    ↕
Backend System
```

It helps developers understand:

* What operations the system supports.
* What input data is required.
* What output data is returned.
* How different services communicate.

Therefore, APIs provide a guideline before designing:

```text
Database
High-Level Architecture
Services
Caching
Communication Between Components
```

---

# 4. High-Level Design

Only after completing:

```text
Requirements
        ↓
Capacity Estimation
        ↓
API Design
```

should we proceed to the High-Level Design.

High-Level Design answers:

> **What are the major components of our system, and how do they communicate?**

This is where we start drawing architecture diagrams.

A simple architecture could look like:

```text
                Users
                  ↓
                Client
                  ↓
             API Gateway
                  ↓
            Load Balancer
                  ↓
          Application Servers
             ↙          ↘
          Cache        Database
```

The purpose of the High-Level Design is to make sure that our architecture satisfies all Functional Requirements.

For every Functional Requirement, we should be able to explain:

```text
How does the request enter the system?

        ↓

Which service processes the request?

        ↓

Where is the data stored?

        ↓

How is the response returned?
```

For example:

```text
User Sends Request
        ↓
API Gateway
        ↓
Load Balancer
        ↓
Application Server
        ↓
Cache / Database
        ↓
Application Server
        ↓
User Receives Response
```

---

# 5. Deep Dive

After creating the High-Level Design, we select important components and explore them in greater detail.

This stage is called:

> **Deep Dive**

The Deep Dive can include:

```text
Database Selection

Database Modeling

Caching

Load Balancing

Database Replication

Database Sharding

Message Queues

Consistency

Availability

Failure Handling

Scaling
```

---

## Database Selection

We decide which type of database is suitable for our system.

For example:

```text
SQL
```

or:

```text
NoSQL
```

The decision depends on:

* Data structure
* Query patterns
* Scalability requirements
* Consistency requirements

---

## Database Modeling

Database Modeling answers:

> **How should our data be structured?**

Example:

```text
User

user_id
name
email
created_at
```

We identify:

* Tables
* Collections
* Relationships
* Primary Keys
* Indexes

---

## Caching

Caching helps improve performance by storing frequently accessed data in fast memory.

Without Cache:

```text
User
  ↓
Server
  ↓
Database
  ↓
Server
  ↓
User
```

With Cache:

```text
User
  ↓
Server
  ↓
Cache

If Data Exists
  ↓
Return Immediately
```

This can significantly reduce:

```text
Database Load

and

Latency
```

---

# Complete System Design Framework

The entire process can be visualized as:

```text
                    SYSTEM DESIGN
                          |
                          ↓
              1. DECIDE REQUIREMENTS
                    ↙           ↘
            Functional      Non-Functional
                                |
              Availability, Latency,
              Scalability, Consistency
                          |
                          ↓
               2. CAPACITY ESTIMATION
                          |
              DAU / MAU
              Throughput
              Storage
              Memory
              Network / Bandwidth
                          |
                          ↓
                    3. API DESIGN
                          |
                   Endpoint
                   Request Body
                   Response
                          |
                          ↓
                4. HIGH-LEVEL DESIGN
                          |
                     Client
                        ↓
                   API Gateway
                        ↓
                  Load Balancer
                        ↓
                Application Servers
                    ↙        ↘
                 Cache     Database
                          |
                          ↓
                     5. DEEP DIVE
                          |
                Database Selection
                Database Modeling
                Caching
                Replication
                Sharding
                Message Queues
                Failure Handling
```

---

# Simple Framework to Remember

Whenever solving a System Design problem, remember:

```text
WHAT?
 ↓
HOW BIG?
 ↓
HOW DO CLIENTS COMMUNICATE?
 ↓
WHAT ARE THE MAIN COMPONENTS?
 ↓
HOW DO IMPORTANT COMPONENTS WORK INTERNALLY?
```

Which maps to:

```text
WHAT?
    =
Requirements

HOW BIG?
    =
Capacity Estimation

HOW DO CLIENTS COMMUNICATE?
    =
API Design

WHAT ARE THE MAIN COMPONENTS?
    =
High-Level Design

HOW DO IMPORTANT COMPONENTS WORK INTERNALLY?
    =
Deep Dive
```

---

# Final System Design Interview Framework

```text
1. REQUIREMENTS
   ├── Functional Requirements
   └── Non-Functional Requirements

2. CAPACITY ESTIMATION
   ├── DAU / MAU
   ├── Throughput
   ├── Storage
   ├── Memory
   └── Network / Bandwidth

3. API DESIGN
   ├── Endpoint
   ├── Request Body
   └── Response

4. HIGH-LEVEL DESIGN
   ├── Client
   ├── API Gateway
   ├── Load Balancer
   ├── Application Servers
   ├── Cache
   └── Database

5. DEEP DIVE
   ├── Database Selection
   ├── Database Modeling
   ├── Caching
   ├── Replication
   ├── Sharding
   ├── Message Queues
   ├── Consistency
   ├── Availability
   ├── Failure Handling
   └── Scaling
```

The most important rule is:

> **Do not immediately start drawing boxes and arrows.**

First understand **what the system needs to do**, then estimate **how large the system is**, define **how clients communicate with it**, create the **high-level architecture**, and finally **deep dive into the most important components**.
