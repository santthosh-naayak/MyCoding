# 🚀 MyCoding - Data Structures & Algorithms in Java

# 📚 Doubly Linked List

A **Doubly Linked List (DLL)** is a linear data structure where each node contains **three parts**:

* Data (Value)
* Pointer to the **next** node
* Pointer to the **previous** node

Unlike a Singly Linked List, where traversal is only possible in one direction, a Doubly Linked List allows traversal in **both forward and backward directions**.

---

# 🧠 Why Do We Need a Doubly Linked List?

In a Singly Linked List, each node only knows about the **next** node.

```text
10 → 20 → 30 → 40 → null
```

Suppose you're at node **30**.

You can easily move to **40**, but you **cannot move back to 20** because there is no pointer to the previous node.

A Doubly Linked List solves this problem by storing an additional **previous** pointer.

---

# 🖼 Structure of a Doubly Linked List

```text
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

Each node points to:

* The next node
* The previous node

This enables traversal in both directions.

---

# 📦 Structure of a Node

Each node contains:

```text
+---------+---------+---------+
| Previous|  Value  |  Next   |
+---------+---------+---------+
```

For example,

```text
           +------+------+------+
null  ←    | null | 10 |  •  |   → 20
           +------+------+------+

           +------+------+------+
10    ←    |  •   | 20 |  •  |   → 30
           +------+------+------+

           +------+------+------+
20    ←    |  •   | 30 | null |
           +------+------+------+
```

---

# 📌 Class Variables

A Doubly Linked List maintains three important variables.

```java
private Node head;
private Node tail;
private int length;
```

| Variable | Description                      |
| -------- | -------------------------------- |
| `head`   | Points to the first node         |
| `tail`   | Points to the last node          |
| `length` | Stores the total number of nodes |

---

# 📦 Node Class

Each node stores:

* An integer value
* A pointer to the next node
* A pointer to the previous node

```java
class Node {

    int value;
    Node next;
    Node prev;

    Node(int value) {
        this.value = value;
    }

}
```

---

# 🏗 Doubly Linked List Constructor

When the first node is created:

* Head points to the new node.
* Tail points to the same node.
* Length becomes 1.

```java
public DoublyLinkedList(int value) {

    Node newNode = new Node(value);

    head = newNode;
    tail = newNode;
    length = 1;
}
```

Initially

```text
Head
 ↓

null ← 10 → null

 ↑
Tail
```

---

# 🔄 Forward Traversal

Starting from the **head**, move using the **next** pointer.

```text
Head

↓

10 ⇄ 20 ⇄ 30 ⇄ 40

↓

null
```

Traversal Order

```text
10 → 20 → 30 → 40
```

---

# 🔙 Backward Traversal

Starting from the **tail**, move using the **previous** pointer.

```text
Head

↓

10 ⇄ 20 ⇄ 30 ⇄ 40

                     ↑

                   Tail
```

Traversal Order

```text
40 → 30 → 20 → 10
```

---

# ⚖️ Singly vs Doubly Linked List

| Feature                    | Singly Linked List | Doubly Linked List |
| -------------------------- | ------------------ | ------------------ |
| Number of Pointers         | 1                  | 2                  |
| Forward Traversal          | ✅ Yes              | ✅ Yes              |
| Backward Traversal         | ❌ No               | ✅ Yes              |
| Memory Usage               | Less               | More               |
| Insert/Delete at Both Ends | More Complex       | Easier             |
| Reverse Traversal          | Not Possible       | Possible           |

---

# ✅ Advantages

* Bidirectional traversal.
* Easier insertion and deletion.
* Efficient removal of a node when its reference is known.
* Useful for browser history, undo/redo functionality, and navigation systems.
* Simplifies many Linked List operations.

---

# ❌ Disadvantages

* Requires extra memory for the previous pointer.
* More pointer updates during insertion and deletion.
* Slightly more complex implementation than a Singly Linked List.

---

# 🌍 Real-World Applications

Doubly Linked Lists are commonly used in:

* 🌐 Browser Back and Forward Navigation
* ↩️ Undo / Redo Operations
* 🎵 Music and Video Playlists
* 📖 Image Galleries
* 📑 Document Editors
* 💾 LRU (Least Recently Used) Cache
* 🖥 Operating System Navigation
* 📚 Deque (Double Ended Queue)

---

# 📊 Time Complexity

| Operation       | Time Complexity |
| --------------- | --------------- |
| Access by Index | O(n)            |
| Search          | O(n)            |
| Append          | O(1)            |
| Remove Last     | O(1)            |
| Prepend         | O(1)            |
| Remove First    | O(1)            |
| Insert          | O(n)            |
| Delete          | O(n)            |

---

# 🎯 Upcoming Topics

In the next sections, we'll implement the following Doubly Linked List operations step by step:

* Create Node
* Constructor
* Append
* Remove Last
* Prepend
* Remove First
* Get by Index
* Set Value
* Insert
* Remove
* Swap First & Last
* Reverse
* Palindrome Check
* Pair Swap
* Reverse Between
* Interview Questions

---

# 🎓 Key Takeaways

* A Doubly Linked List stores **data**, **next**, and **previous** pointers.
* It allows traversal in both forward and backward directions.
* It requires more memory than a Singly Linked List.
* Insertion and deletion are easier because every node knows both its previous and next neighbors.
* Doubly Linked Lists are widely used in real-world applications such as browser history, undo/redo systems, and LRU caches.

---

