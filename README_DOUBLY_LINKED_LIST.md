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
# ➕ append()

The **`append()`** method adds a new node to the **end** of the Doubly Linked List.

Unlike a Singly Linked List, a Doubly Linked List requires updating **both the `next` and `prev` pointers** to maintain bidirectional connections between nodes.

---

## 💻 Java Solution

```java
public void append(int value) {
    Node newNode = new Node(value);

    if (length == 0) {
        head = newNode;
        tail = newNode;
    } else {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    length++;
}
```

---

## 📖 Code Explanation

### Step 1: Create a New Node

```java
Node newNode = new Node(value);
```

Creates a new node containing the given value.

Initially, the new node has no connections.

```text
null ← newNode → null
```

---

### Step 2: Check if the List is Empty

```java
if (length == 0)
```

If the linked list has no nodes, the newly created node becomes both the **head** and the **tail**.

```java
head = newNode;
tail = newNode;
```

Result:

```text
Head
 ↓

null ← 10 → null

 ↑
Tail
```

Since there is only one node, both `next` and `prev` remain `null`.

---

### Step 3: Connect the Current Tail to the New Node

```java
tail.next = newNode;
```

If the list already contains nodes, the current tail's `next` pointer is updated to point to the new node.

Before:

```text
Head

↓

null ← 10 ⇄ 20 ⇄ 30 → null

                   ↑
                 Tail
```

After:

```text
Head

↓

null ← 10 ⇄ 20 ⇄ 30 → 40
```

At this stage, only the forward connection has been established.

---

### Step 4: Connect the New Node Back to the Previous Tail

```java
newNode.prev = tail;
```

Updates the new node's `prev` pointer to point back to the previous tail.

Result:

```text
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

Now the nodes are connected in both directions.

---

### Step 5: Move the Tail Pointer

```java
tail = newNode;
```

Updates the `tail` reference so it points to the newly added node.

Before:

```text
Tail

↓

30
```

After:

```text
Tail

↓

40
```

The new node is now the last node of the linked list.

---

### Step 6: Increase the Length

```java
length++;
```

Increments the total number of nodes in the linked list.

---

# 🖼 Complete Example

Initial List

```text
Head

↓

null ← 10 ⇄ 20 ⇄ 30 → null

                   ↑
                 Tail
```

Call

```java
append(40);
```

Execution

1. Create a new node.

```text
null ← 40 → null
```

2. Connect the current tail to the new node.

```text
30.next → 40
```

3. Connect the new node back to the previous tail.

```text
40.prev → 30
```

4. Move the tail pointer to the new node.

Final List

```text
Head

↓

null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null

                         ↑
                       Tail
```

---

# ❓ Why Do We Need `tail.next = newNode`?

Without this line, the previous tail would never point to the new node, and the new node would remain disconnected from the linked list.

---

# ❓ Why Do We Need `newNode.prev = tail`?

This line creates the backward connection. Without it, backward traversal would not be possible because the new node would not know which node comes before it.

---

# ❓ Why Do We Need `tail = newNode`?

The `tail` variable should always point to the last node in the list.

If we don't update it, future append operations would still treat the old tail as the last node, resulting in an incorrect linked list.

---

# ⏱ Time Complexity

```text
Time Complexity : O(1)
```

Since we already maintain a tail pointer, appending a node does not require traversing the list.

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only one new node is created regardless of the size of the linked list.

---

# 🎓 Key Takeaways

* Create a new node with the given value.
* If the list is empty, the new node becomes both the head and the tail.
* Otherwise, connect the current tail to the new node using the `next` pointer.
* Connect the new node back to the previous tail using the `prev` pointer.
* Move the `tail` reference to the new node.
* Increment the length of the linked list.
* Always update both `next` and `prev` pointers to maintain the Doubly Linked List structure.

---

## 📌 Interview Tip

**Question:** What is the difference between appending in a Singly Linked List and a Doubly Linked List?

**Answer:**

* In a **Singly Linked List**, only the `next` pointer of the current tail is updated.
* In a **Doubly Linked List**, both the current tail's `next` pointer and the new node's `prev` pointer must be updated before moving the `tail` reference.

This is one of the fundamental differences between the two data structures and is a common interview question.

--------------------------------