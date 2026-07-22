# 🌳 Serialize and Deserialize Binary Tree

## 📌 Problem Statement

Design an algorithm to convert a binary tree into a string (**Serialization**) and reconstruct the exact same binary tree back from that string (**Deserialization**).

The serialization format is your choice, but it must satisfy:

```text
deserialize(serialize(tree)) = Original Tree
```

---

# 🎯 Pattern Used

* Tree Traversal
* Depth First Search (DFS)
* Preorder Traversal
* Recursion
* Design Pattern (Encode → Decode)

---

# 🏗️ Data Structures Used

* **Binary Tree** → Represents the hierarchical data.
* **Queue** → Reads serialized values in the same order during deserialization.
* **StringBuilder / StringBuffer** → Efficiently builds the serialized string.
* **String Array** → Stores values after splitting the serialized string.

---

# ⚙️ Algorithms Used

### 1. Preorder Traversal

```text
Root
↓
Left
↓
Right
```

Used to serialize the tree.

---

### 2. Recursive Tree Construction

Uses recursion to rebuild the original tree.

---

### 3. Queue (FIFO)

Processes serialized values in exactly the same order they were stored.

---

# 💡 Core Technique

```text
Tree

↓

Preorder DFS

↓

Store Every Node

+

Store Every Null Child

↓

Serialized String

↓

Split into Values

↓

Queue

↓

Recursive Reconstruction

↓

Original Tree
```

---

# 🧠 Mental Recognition

Whenever you hear:

* Serialize Tree
* Deserialize Tree
* Encode Tree
* Decode Tree
* Save Tree
* Restore Tree
* Transfer Tree over Network

Immediately think:

```text
Tree

↓

Need Exact Structure?

↓

Store Null Nodes

↓

Preorder DFS

↓

String

↓

Queue

↓

Recursive Reconstruction
```

---

# 🌍 Real-World Example

Imagine sending your family tree to another country.

If you only send people's names, nobody knows the parent-child relationships.

Instead, you also indicate where children are missing.

Only then can someone rebuild the exact same family tree.

Serialization works in exactly the same way.

---

# ☁️ Google / Backend Example

Large distributed systems frequently serialize objects before:

* Sending data between microservices
* Storing objects in databases
* Saving application state
* Sending messages through Kafka or RabbitMQ
* Caching objects in Redis

The receiver later deserializes the data back into the original object.

---

# 💻 Java Concepts Used

* Classes
* Objects
* Inner Classes
* Method Overloading
* Recursion
* Queue
* LinkedList
* StringBuilder / StringBuffer
* Integer.parseInt()
* String.split()
* DFS
* Tree Traversal

---

# 🎯 Interview Recognition

If an interviewer says:

> "Convert a tree into a transferable format."

or

> "Save a tree and rebuild it later."

Immediately think:

```text
DFS

↓

Preorder

↓

Null Markers

↓

Queue

↓

Recursion
```
