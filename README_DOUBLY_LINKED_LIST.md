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
# ➖ removeLast()

The **`removeLast()`** method removes the **last node (tail)** from the Doubly Linked List and returns the removed node.

Unlike a Singly Linked List, a Doubly Linked List can remove the last node in **O(1)** time because each node has a **previous (`prev`) pointer**, allowing direct access to the second-last node.

---

## 💻 Java Solution

```java
public Node removeLast() {
    if (length == 0)
        return null;

    Node temp = tail;

    if (length == 1) {
        head = null;
        tail = null;
    } else {
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    length--;

    return temp;
}
```

---

# 📖 Code Explanation

### Step 1: Check if the List is Empty

```java
if (length == 0)
    return null;
```

If the linked list is empty, there is no node to remove, so return `null`.

---

### Step 2: Store the Current Tail

```java
Node temp = tail;
```

Store the current tail in a temporary variable.

This allows us to:

* Return the removed node.
* Safely update the `tail` pointer without losing the last node.

Example

```text
Head

↓

null ← 10 ⇄ 20 ⇄ 30 → null

                   ↑
                 Tail
                  ↑
                 temp
```

---

### Step 3: Check if There is Only One Node

```java
if (length == 1)
```

If the list contains only one node, removing it makes the linked list empty.

```java
head = null;
tail = null;
```

Result

```text
Head = null

Tail = null
```

---

### Step 4: Move Tail to the Previous Node

```java
tail = tail.prev;
```

Move the tail pointer one step backward.

Before

```text
Head

↓

10 ⇄ 20 ⇄ 30

             ↑
           Tail
```

After

```text
Head

↓

10 ⇄ 20 ⇄ 30

        ↑
      Tail
```

The new tail is now **20**.

---

### Step 5: Remove the Forward Link

```java
tail.next = null;
```

Disconnect the new tail from the removed node.

Before

```text
20 ⇄ 30
```

After

```text
20 → null

30
```

Now **20** becomes the last node.

---

### Step 6: Remove the Backward Link

```java
temp.prev = null;
```

Disconnect the removed node from the linked list.

Before

```text
20 ⇄ 30
```

After

```text
20 → null

null ← 30
```

Now the removed node is completely isolated.

---

### Step 7: Decrease the Length

```java
length--;
```

Reduce the total number of nodes by one.

---

### Step 8: Return the Removed Node

```java
return temp;
```

Return the node that was removed from the linked list.

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
removeLast();
```

Execution

### Store Tail

```text
temp → 30
```

↓

### Move Tail Backward

```text
Tail → 20
```

↓

### Remove Forward Link

```text
20.next = null
```

↓

### Remove Backward Link

```text
30.prev = null
```

Final List

```text
Head

↓

null ← 10 ⇄ 20 → null

              ↑
            Tail
```

Returned Node

```text
null ← 30 → null
```

---

# ❓ Why Do We Store `temp = tail`?

After moving the tail pointer, we would lose the reference to the original last node.

Using `temp` allows us to:

* Return the removed node.
* Disconnect it safely.

---

# ❓ Why Do We Move `tail = tail.prev`?

Since every node knows its previous node, we can directly move the tail to the second-last node.

This is why removing the last node in a Doubly Linked List is much faster than in a Singly Linked List.

---

# ❓ Why Do We Set `tail.next = null`?

The new tail should always point to `null`.

Otherwise, it would still reference the removed node, leaving the list incorrectly connected.

---

# ❓ Why Do We Set `temp.prev = null`?

This completely detaches the removed node from the linked list.

The returned node becomes an independent node with no connection to the original list.

---

# ⏱ Time Complexity

```text
Time Complexity : O(1)
```

Since we already maintain a **tail pointer** and every node has a **prev** pointer, no traversal is required.

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only one temporary pointer is used.

---

# 🎓 Key Takeaways

* If the list is empty, return `null`.
* Store the current tail before updating it.
* If only one node exists, make both `head` and `tail` `null`.
* Otherwise, move the tail to the previous node.
* Remove both forward and backward links.
* Decrease the length.
* Return the removed node.
* The `prev` pointer allows removing the last node in **constant time**, which is a major advantage of a Doubly Linked List.

---

## 📌 Interview Tip

**Question:** Why is `removeLast()` **O(1)** in a Doubly Linked List but **O(n)** in a Singly Linked List?

**Answer:**

* In a **Singly Linked List**, you must traverse from the head to find the second-last node because nodes only know their `next` node.
* In a **Doubly Linked List**, the tail already knows its previous node through the `prev` pointer, so the tail can move backward directly without any traversal.

This is one of the biggest advantages of using a Doubly Linked List over a Singly Linked List.
------------------

# ⬅ prepend()

The **`prepend()`** method adds a new node to the **beginning** of the Doubly Linked List.

Unlike a Singly Linked List, we must update **both the `next` and `prev` pointers** to maintain the bidirectional links between nodes.

---

## 💻 Java Solution

```java
public void prepend(int value) {
    Node newNode = new Node(value);

    if(length == 0) {
        head = newNode;
        tail = newNode;
    } else {
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    length++;
}
```

---

# 📖 Code Explanation

### Step 1: Create a New Node

```java
Node newNode = new Node(value);
```

Creates a new node with the given value.

Initially, the new node has no connections.

```text
null ← newNode → null
```

---

### Step 2: Check if the List is Empty

```java
if(length == 0)
```

Checks whether the Doubly Linked List is empty.

If it is, the new node becomes both the **head** and the **tail**.

```java
head = newNode;
tail = newNode;
```

Result

```text
Head
 ↓

null ← 10 → null

 ↑
Tail
```

Since there is only one node, both `next` and `prev` are `null`.

---

### Step 3: Point the New Node to the Current Head

```java
newNode.next = head;
```

Connects the new node to the existing head.

Before

```text
Head

↓

null ← 10 ⇄ 20 ⇄ 30 → null
```

After

```text
newNode → 10 ⇄ 20 ⇄ 30
```

At this stage, only the forward connection has been created.

---

### Step 4: Point the Current Head Back to the New Node

```java
head.prev = newNode;
```

Creates the backward connection.

Before

```text
newNode → 10
```

After

```text
newNode ⇄ 10
```

Now both nodes are connected in both directions.

---

### Step 5: Move the Head Pointer

```java
head = newNode;
```

Updates the head so it points to the newly inserted node.

Before

```text
Head

↓

10
```

After

```text
Head

↓

5
```

The new node is now the first node of the linked list.

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
prepend(5);
```

Execution

### Create a New Node

```text
null ← 5 → null
```

↓

### Connect New Node to Current Head

```text
5 → 10
```

↓

### Connect Current Head Back to New Node

```text
5 ⇄ 10
```

↓

### Move Head

```text
Head

↓

5
```

Final List

```text
Head

↓

null ← 5 ⇄ 10 ⇄ 20 ⇄ 30 → null

                        ↑
                      Tail
```

---

# ❓ Why Do We Need `newNode.next = head`?

Without this line, the new node would never connect to the existing linked list.

It would remain an isolated node.

---

# ❓ Why Do We Need `head.prev = newNode`?

This creates the backward connection.

Without it, you could move from **5 → 10**, but you couldn't move back from **10 → 5**, breaking backward traversal.

---

# ❓ Why Do We Need `head = newNode`?

The head should always point to the first node.

If we don't update it, the linked list will still think the old first node is the head.

---

# ⏱ Time Complexity

```text
Time Complexity : O(1)
```

The node is inserted at the beginning without traversing the linked list.

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only one new node is created.

---

# 🎓 Key Takeaways

* Create a new node.
* If the list is empty, make it both the head and the tail.
* Otherwise, connect the new node to the current head.
* Connect the current head back to the new node.
* Move the head pointer to the new node.
* Increase the length.
* Both the `next` and `prev` pointers must be updated to maintain the Doubly Linked List.

---

## 📌 Interview Tip

**Question:** Why is `prepend()` **O(1)** in a Doubly Linked List?

**Answer:**

Because the **head** pointer already points to the first node. We simply:

1. Connect the new node to the current head.
2. Connect the current head back to the new node.
3. Update the head pointer.

No traversal is required, making the operation run in **constant time (O(1))**.
