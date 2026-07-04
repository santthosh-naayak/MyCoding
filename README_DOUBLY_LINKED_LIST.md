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
-----------------------------

# ➖ removeFirst()

The **`removeFirst()`** method removes the **first node (head)** from the Doubly Linked List and returns the removed node.

Unlike a Singly Linked List, we must update **both the `head` pointer** and the **`prev` pointer** of the new head to maintain the bidirectional links.

---

## 💻 Java Solution

```java
public Node removeFirst() {
    if(length == 0) return null;

    Node temp = head;

    if(length == 1) {
        head = null;
        tail = null;
    } else {
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    length--;

    return temp;
}
```

---

# 📖 Code Explanation

### Step 1: Check if the List is Empty

```java
if(length == 0)
    return null;
```

Checks whether the linked list is empty.

If there are no nodes, there is nothing to remove, so return `null`.

---

### Step 2: Store the Current Head

```java
Node temp = head;
```

Store the current head in a temporary variable.

This allows us to:

* Return the removed node.
* Safely move the head pointer without losing the original first node.

Example

```text
Head

↓

null ← 10 ⇄ 20 ⇄ 30 → null

                   ↑
                 Tail

temp
 ↓
10
```

---

### Step 3: Check if There is Only One Node

```java
if(length == 1)
```

If the linked list contains only one node, removing it makes the list empty.

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

### Step 4: Move Head to the Next Node

```java
head = head.next;
```

Move the head pointer to the second node.

Before

```text
Head

↓

10 ⇄ 20 ⇄ 30
```

After

```text
Head

↓

20 ⇄ 30
```

The new head is now **20**.

---

### Step 5: Remove the Backward Link

```java
head.prev = null;
```

The first node in a Doubly Linked List should never have a previous node.

This line removes the backward connection from the new head to the old head.

Before

```text
null ← 10 ⇄ 20
           ↑
         prev
```

After

```text
20.prev = null
```

Now **20** becomes the first node.

---

### Step 6: Remove the Forward Link

```java
temp.next = null;
```

Disconnect the removed node from the linked list.

Before

```text
10 ⇄ 20
```

After

```text
10 → null

20
```

The removed node is now completely isolated.

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

Return the node that was removed from the beginning of the linked list.

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
removeFirst();
```

Execution

### Store Head

```text
temp → 10
```

↓

### Move Head

```text
Head → 20
```

↓

### Remove Backward Link

```text
20.prev = null
```

↓

### Remove Forward Link

```text
10.next = null
```

Final List

```text
Head

↓

null ← 20 ⇄ 30 → null

              ↑
            Tail
```

Returned Node

```text
null ← 10 → null
```

---

# ❓ Why Do We Store `temp = head`?

After moving the head pointer, we would lose access to the original first node.

Using `temp` allows us to:

* Return the removed node.
* Disconnect it safely.

---

# ❓ Why Do We Move `head = head.next`?

The second node becomes the new first node after removing the old head.

---

# ❓ Why Do We Set `head.prev = null`?

The head node should never have a previous node.

Without this line, the new head would still point back to the removed node, leaving an incorrect backward connection.

---

# ❓ Why Do We Set `temp.next = null`?

This completely detaches the removed node from the linked list.

The returned node becomes an independent node.

---

# ⏱ Time Complexity

```text
Time Complexity : O(1)
```

The head pointer gives direct access to the first node, so no traversal is required.

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only one temporary pointer is used.

---

# 🎓 Key Takeaways

* If the list is empty, return `null`.
* Store the current head before updating it.
* If only one node exists, make both `head` and `tail` `null`.
* Otherwise, move the head to the next node.
* Remove the new head's `prev` pointer.
* Disconnect the removed node by setting its `next` pointer to `null`.
* Decrease the length.
* Return the removed node.
* Updating both `head` and `prev` ensures the Doubly Linked List remains correctly connected.

---

## 📌 Interview Tip

**Question:** Why do we need both `head.prev = null` and `temp.next = null`?

**Answer:**

* `head.prev = null` updates the new head so it no longer points to the removed node.
* `temp.next = null` completely detaches the removed node from the linked list.

Both steps ensure the removed node is fully disconnected and the remaining linked list maintains valid forward and backward links.
--------------------
# 🎯 get(index)

The **`get()`** method returns the node located at a specific index in the Doubly Linked List.

Unlike a Singly Linked List, a Doubly Linked List can traverse in **both directions**.

Therefore:

* If the index is in the **first half**, start searching from the `head`.
* If the index is in the **second half**, start searching from the `tail`.

This reduces unnecessary traversal.

---

## 💻 Java Solution

```java
public Node get(int index) {
    if (index < 0 || index >= length) return null;

    Node temp = head;

    if (index < length / 2) {
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
    } else {
        temp = tail;

        for (int i = length - 1; i > index; i--) {
            temp = temp.prev;
        }
    }

    return temp;
}
```

---

# 📖 Code Explanation

### Step 1: Check if the Index is Valid

```java
if (index < 0 || index >= length) return null;
```

Checks whether the requested index exists in the Doubly Linked List.

An index is invalid when:

```text
index < 0
```

or

```text
index >= length
```

For example, suppose:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40

length = 4
```

Valid indexes are:

```text
0, 1, 2, 3
```

Invalid indexes include:

```text
-1, 4, 5, 6...
```

If the index is invalid, return `null`.

---

### Step 2: Create a Temporary Pointer

```java
Node temp = head;
```

Creates a temporary pointer used to traverse the Doubly Linked List.

Initially:

```text
temp

 ↓

10 ⇄ 20 ⇄ 30 ⇄ 40
```

The `temp` pointer will move through the list until it reaches the requested index.

---

### Step 3: Check Which Side is Closer

```java
if (index < length / 2)
```

Checks whether the requested index is located in the first half or second half of the list.

If the index is in the first half:

```text
Start from Head
```

Otherwise:

```text
Start from Tail
```

---

# 🖼 Example

Suppose we have:

```text
Index

  0      1      2      3      4      5

 10  ⇄  20  ⇄  30  ⇄  40  ⇄  50  ⇄  60

 ↑                                     ↑
Head                                  Tail
```

Length:

```text
6
```

Half:

```text
length / 2

6 / 2 = 3
```

Therefore:

```text
Index 0 → Start from Head

Index 1 → Start from Head

Index 2 → Start from Head

Index 3 → Start from Tail

Index 4 → Start from Tail

Index 5 → Start from Tail
```

This avoids unnecessary traversal.

---

# ➡️ Case 1: Index is in the First Half

```java
if (index < length / 2)
```

If the requested index is closer to the head, traverse forward.

```java
for (int i = 0; i < index; i++) {
    temp = temp.next;
}
```

---

## Example

Suppose:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ 50 ⇄ 60
```

Call:

```java
get(2);
```

Since:

```text
2 < 3
```

Start from the head.

Initially:

```text
temp → 10
```

First Iteration:

```text
temp = temp.next;

temp → 20
```

Second Iteration:

```text
temp = temp.next;

temp → 30
```

Return:

```text
30
```

---

# ⬅️ Case 2: Index is in the Second Half

```java
else
```

If the requested index is closer to the tail, start searching from the tail.

First:

```java
temp = tail;
```

Now `temp` points to the last node.

```text
10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ 50 ⇄ 60

                              ↑
                             temp
```

---

### Traverse Backward

```java
for (int i = length - 1; i > index; i--) {
    temp = temp.prev;
}
```

Move backward using the `prev` pointer until the requested index is reached.

---

## Example

Suppose:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ 50 ⇄ 60
```

Call:

```java
get(4);
```

Since:

```text
4 >= 3
```

Start from the tail.

Initially:

```text
temp → 60
```

The tail is at index:

```text
length - 1

6 - 1 = 5
```

First Iteration:

```text
i = 5
```

Since:

```text
5 > 4
```

Move backward:

```java
temp = temp.prev;
```

Now:

```text
temp → 50
```

`50` is at index `4`.

The loop stops.

Return:

```text
50
```

---

# ❓ Why Use `length / 2`?

```java
if (index < length / 2)
```

This determines which end of the Doubly Linked List is closer to the requested index.

For example:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ 50 ⇄ 60
```

Suppose we want:

```java
get(5);
```

If we start from the head:

```text
10 → 20 → 30 → 40 → 50 → 60
```

We need **5 movements**.

But if we start from the tail:

```text
60
```

We need **0 movements**.

Therefore, starting from the nearest end makes the traversal more efficient.

---

# ❓ Why Do We Use `temp.next`?

```java
temp = temp.next;
```

When starting from the head, we need to move forward through the Doubly Linked List.

The `next` pointer gives us access to the next node.

```text
10 → 20 → 30
```

---

# ❓ Why Do We Use `temp.prev`?

```java
temp = temp.prev;
```

When starting from the tail, we need to move backward through the Doubly Linked List.

The `prev` pointer gives us access to the previous node.

```text
30 ← 40 ← 50
```

---

# ❓ Why Does the Backward Loop Start at `length - 1`?

```java
for (int i = length - 1; i > index; i--)
```

Because the tail is located at the last index.

For a list with:

```text
length = 6
```

The indexes are:

```text
0  1  2  3  4  5
```

Therefore:

```text
tail index = length - 1

tail index = 6 - 1

tail index = 5
```

That's why the loop starts at:

```java
length - 1
```

---

# ❓ Why Do We Use `i > index`?

The loop should continue only until `temp` reaches the requested index.

For example:

```text
length = 6

index = 3
```

Start:

```text
i = 5
```

First Movement:

```text
i = 5

5 > 3

Move backward
```

Second Movement:

```text
i = 4

4 > 3

Move backward
```

Now `temp` has reached index `3`.

The loop stops.

---

# 🖼 Complete Example

Linked List:

```text
Index

  0      1      2      3      4      5

 10  ⇄  20  ⇄  30  ⇄  40  ⇄  50  ⇄  60

 ↑                                     ↑
Head                                  Tail
```

---

### `get(1)`

```text
1 < 3
```

Start from Head:

```text
10 → 20
```

Return:

```text
20
```

---

### `get(4)`

```text
4 >= 3
```

Start from Tail:

```text
60 ← 50
```

Return:

```text
50
```

---

### `get(6)`

```text
6 >= length
```

Return:

```text
null
```

---

# ⏱ Time Complexity

```text
Time Complexity : O(n)
```

In Big O notation, the worst-case time complexity is still **O(n)**.

However, because we start from the closest end, we traverse at most approximately half of the list:

```text
O(n / 2)
```

After dropping constants:

```text
O(n)
```

So the official Big O complexity remains:

```text
O(n)
```

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only one temporary pointer is used.

---

# 🎓 Key Takeaways

* First, check whether the index is valid.
* A Doubly Linked List allows traversal from both directions.
* Start from the `head` when the index is in the first half.
* Start from the `tail` when the index is in the second half.
* Use `next` to move forward.
* Use `prev` to move backward.
* `length / 2` helps determine which end is closer.
* The worst-case time complexity remains **O(n)**.
* The space complexity is **O(1)**.

---

## 📌 Interview Tip

**Question:** What is the advantage of implementing `get()` in a Doubly Linked List compared with a Singly Linked List?

**Answer:**

In a Singly Linked List, traversal must always begin from the head because nodes only contain a `next` pointer.

In a Doubly Linked List, traversal can begin from either the head or the tail. By checking whether the requested index is in the first or second half of the list, we can start from the closer end and reduce the number of node movements.
---------------
# ✏️ set(index, value)

The **`set()`** method updates the value of an existing node at a specific index in the Doubly Linked List.

Instead of writing the traversal logic again, the method uses the existing **`get()`** method to find the node.

If the node exists, its value is updated and the method returns `true`.

If the index is invalid, the method returns `false`.

---

## 💻 Java Solution

```java
public boolean set(int index, int value) {
    Node temp = get(index);

    if(temp != null) {
        temp.value = value;
        return true;
    }

    return false;
}
```

---

# 📖 Code Explanation

### Step 1: Get the Node at the Given Index

```java
Node temp = get(index);
```

Calls the existing **`get()`** method to find the node at the specified index.

For example:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Call:

```java
set(2, 50);
```

The method first executes:

```java
get(2);
```

The `get()` method returns:

```text
temp → 30
```

---

### Step 2: Check if the Node Exists

```java
if(temp != null)
```

Checks whether the `get()` method successfully found a node.

If the index is valid:

```text
temp → Node
```

If the index is invalid:

```text
temp → null
```

---

### Step 3: Update the Node Value

```java
temp.value = value;
```

Changes the value stored inside the node.

Before:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Call:

```java
set(2, 50);
```

The node at index `2` is:

```text
30
```

Update:

```text
30 → 50
```

After:

```text
10 ⇄ 20 ⇄ 50 ⇄ 40
```

Only the value is changed.

The `next` and `prev` pointers remain unchanged.

---

### Step 4: Return `true`

```java
return true;
```

If the value was successfully updated, return `true`.

Example:

```java
set(2, 50);
```

Returns:

```text
true
```

---

### Step 5: Return `false`

```java
return false;
```

If the index is invalid, `get(index)` returns `null`.

Therefore, the value cannot be updated.

Example:

```text
10 ⇄ 20 ⇄ 30
```

Call:

```java
set(5, 100);
```

Since index `5` does not exist:

```java
get(5);
```

Returns:

```text
null
```

Therefore:

```text
return false;
```

---

# 🖼 Complete Example

Initial List:

```text
Index

 0      1      2      3

10  ⇄  20  ⇄  30  ⇄  40
```

Call:

```java
set(2, 100);
```

---

### Find the Node

```java
Node temp = get(2);
```

Result:

```text
temp

 ↓

30
```

---

### Check the Node

```java
if(temp != null)
```

Result:

```text
true
```

---

### Update the Value

```java
temp.value = 100;
```

Result:

```text
10 ⇄ 20 ⇄ 100 ⇄ 40
```

---

### Return

```text
true
```

---

# ⚠️ Invalid Index Example

Initial List:

```text
10 ⇄ 20 ⇄ 30
```

Call:

```java
set(5, 100);
```

Execution:

```text
get(5)

↓

null
```

Since:

```text
temp == null
```

The `if` block is skipped.

Return:

```text
false
```

The linked list remains unchanged.

---

# ❓ Why Do We Use `get(index)`?

```java
Node temp = get(index);
```

We already created a method that knows how to find a node efficiently.

Instead of writing the traversal logic again, we reuse the existing `get()` method.

This makes the code:

* Shorter
* Cleaner
* Easier to understand
* Easier to maintain
* Avoids duplicate code

---

# ❓ Why Do We Check `temp != null`?

```java
if(temp != null)
```

If the index is invalid, the `get()` method returns `null`.

Trying to execute:

```java
temp.value = value;
```

when `temp` is `null` would cause a:

```text
NullPointerException
```

Therefore, we first check whether the node exists.

---

# ❓ Why Return a Boolean?

The method returns:

```text
true
```

when the value was successfully updated.

It returns:

```text
false
```

when the index is invalid.

This allows the caller to know whether the operation succeeded.

---

# ❓ Are We Changing the Node or the Pointer?

This line:

```java
temp.value = value;
```

changes only the **value stored inside the node**.

It does not change:

```text
next
```

or:

```text
prev
```

Therefore, the structure of the Doubly Linked List remains unchanged.

Before:

```text
10 ⇄ 20 ⇄ 30
```

After:

```text
10 ⇄ 50 ⇄ 30
```

The connections between nodes remain exactly the same.

---

# ⏱ Time Complexity

```text
Time Complexity : O(n)
```

The `set()` method itself performs a constant-time value update.

However, it calls:

```java
get(index);
```

The `get()` method may need to traverse the linked list.

Therefore, the overall time complexity is:

```text
O(n)
```

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only one temporary pointer is used.

No additional data structures are created.

---

# 📊 Complexity Summary

| Operation               | Complexity |
| ----------------------- | ---------- |
| Find Node using `get()` | O(n)       |
| Update Value            | O(1)       |
| Overall Time Complexity | **O(n)**   |
| Space Complexity        | **O(1)**   |

---

# 🎓 Key Takeaways

* Use `get(index)` to find the required node.
* Check whether the returned node is `null`.
* Update the node's value if it exists.
* Return `true` when the update succeeds.
* Return `false` when the index is invalid.
* The `next` and `prev` pointers are not modified.
* Reusing `get()` avoids duplicate traversal code.
* The overall time complexity is **O(n)** because finding the node may require traversal.

---

## 📌 Interview Tip

**Question:** Why is `set()` O(n) when updating a value is O(1)?

**Answer:**

Updating the value itself is an **O(1)** operation:

```java
temp.value = value;
```

However, before updating the value, we must first locate the node using:

```java
get(index);
```

Finding the node can require traversing the Doubly Linked List, which takes **O(n)** time in the worst case.

Therefore:

```text
O(n) + O(1)

↓

O(n)
```

So the overall time complexity of `set()` is **O(n)**.
------------------------------
# ➕ insert(index, value)

The **`insert()`** method adds a new node at a specific index in the Doubly Linked List.

Depending on the index:

* If the index is `0`, use `prepend()`.
* If the index is equal to `length`, use `append()`.
* Otherwise, insert the new node between two existing nodes.

Since this is a Doubly Linked List, both the `next` and `prev` pointers must be updated correctly.

---

## 💻 Java Solution

```java
public boolean insert(int index, int value) {
    if(index < 0 || index > length) return false;

    if(index == 0) {
        prepend(value);
        return true;
    }

    if(index == length) {
        append(value);
        return true;
    }

    Node newNode = new Node(value);
    Node before = get(index - 1);
    Node after = before.next;

    newNode.prev = before;
    newNode.next = after;
    before.next = newNode;
    after.prev = newNode;

    length++;

    return true;
}
```

---

# 📖 Code Explanation

### Step 1: Check if the Index is Valid

```java
if(index < 0 || index > length) return false;
```

Checks whether the given index is valid.

For example, suppose:

```text
10 ⇄ 20 ⇄ 30

length = 3
```

Valid insertion indexes are:

```text
0, 1, 2, 3
```

Index `3` is valid because inserting at index `length` means adding the node at the end.

Invalid indexes include:

```text
-1, 4, 5...
```

If the index is invalid, return `false`.

---

### Step 2: Check if Inserting at the Beginning

```java
if(index == 0) {
    prepend(value);
    return true;
}
```

If the index is `0`, the new node should be added at the beginning of the list.

Instead of writing the insertion logic again, we reuse the existing `prepend()` method.

Example:

```text
10 ⇄ 20 ⇄ 30
```

Call:

```java
insert(0, 5);
```

The method calls:

```java
prepend(5);
```

Result:

```text
5 ⇄ 10 ⇄ 20 ⇄ 30
```

Then return `true`.

---

### Step 3: Check if Inserting at the End

```java
if(index == length) {
    append(value);
    return true;
}
```

If the index is equal to the length, the new node should be added at the end of the list.

Instead of writing the insertion logic again, we reuse the existing `append()` method.

Example:

```text
10 ⇄ 20 ⇄ 30

length = 3
```

Call:

```java
insert(3, 40);
```

The method calls:

```java
append(40);
```

Result:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Then return `true`.

---

# 🔗 Inserting Between Two Nodes

If the index is neither `0` nor `length`, the new node must be inserted between two existing nodes.

Example:

```text
Index

 0      1      2      3

10  ⇄  20  ⇄  30  ⇄  40
```

Call:

```java
insert(2, 25);
```

We want:

```text
10 ⇄ 20 ⇄ 25 ⇄ 30 ⇄ 40
```

The new node must be inserted between:

```text
20 ⇄ 30
```

---

### Step 4: Create a New Node

```java
Node newNode = new Node(value);
```

Creates a new node containing the given value.

Initially:

```text
null ← 25 → null
```

The new node is not yet connected to the Doubly Linked List.

---

### Step 5: Find the Node Before the Insertion Position

```java
Node before = get(index - 1);
```

Gets the node immediately before the insertion index.

Example:

```java
insert(2, 25);
```

We need to insert at index:

```text
2
```

Therefore:

```text
index - 1 = 1
```

The method calls:

```java
get(1);
```

Result:

```text
before → 20
```

---

### Step 6: Store the Node After the Insertion Position

```java
Node after = before.next;
```

Gets the node that currently comes after `before`.

Before insertion:

```text
20 ⇄ 30
```

Therefore:

```text
before → 20

after → 30
```

Now we know exactly where the new node should be inserted.

```text
before       newNode       after

  20            25           30
```

---

# 🔥 Updating the Four Pointers

This is the most important part of inserting a node into a Doubly Linked List.

We need to create four connections.

Before:

```text
before ⇄ after

  20   ⇄   30
```

New Node:

```text
25
```

After:

```text
before ⇄ newNode ⇄ after

  20   ⇄   25    ⇄   30
```

---

### Step 7: Connect the New Node Backward

```java
newNode.prev = before;
```

Makes the new node's `prev` pointer point to the node before it.

```text
20 ← 25
```

Now:

```text
25.prev → 20
```

---

### Step 8: Connect the New Node Forward

```java
newNode.next = after;
```

Makes the new node's `next` pointer point to the node after it.

```text
25 → 30
```

Now:

```text
25.next → 30
```

At this stage:

```text
20 ← 25 → 30
```

The new node knows both of its neighbors.

---

### Step 9: Connect the Previous Node to the New Node

```java
before.next = newNode;
```

Changes the `next` pointer of the previous node.

Before:

```text
20.next → 30
```

After:

```text
20.next → 25
```

Now:

```text
20 → 25 → 30
```

---

### Step 10: Connect the Next Node Back to the New Node

```java
after.prev = newNode;
```

Changes the `prev` pointer of the next node.

Before:

```text
30.prev → 20
```

After:

```text
30.prev → 25
```

Now all four connections are complete.

```text
20 ⇄ 25 ⇄ 30
```

---

### Step 11: Increase the Length

```java
length++;
```

A new node has been added, so increase the total number of nodes by one.

---

### Step 12: Return `true`

```java
return true;
```

Returns `true` because the new node was successfully inserted.

---

# 🖼 Complete Example

Initial List:

```text
Index

 0      1      2      3

10  ⇄  20  ⇄  30  ⇄  40
```

Call:

```java
insert(2, 25);
```

---

### Find `before`

```text
before = get(1)

before → 20
```

---

### Find `after`

```text
after = before.next

after → 30
```

---

### Create New Node

```text
newNode → 25
```

---

### Current Situation

```text
before       newNode       after

  20            25           30
```

---

### Connect New Node Backward

```java
newNode.prev = before;
```

```text
20 ← 25
```

---

### Connect New Node Forward

```java
newNode.next = after;
```

```text
20 ← 25 → 30
```

---

### Connect Before to New Node

```java
before.next = newNode;
```

```text
20 ⇄ 25 → 30
```

---

### Connect After Back to New Node

```java
after.prev = newNode;
```

```text
20 ⇄ 25 ⇄ 30
```

---

### Final List

```text
10 ⇄ 20 ⇄ 25 ⇄ 30 ⇄ 40
```

---

# 🧠 Easy Way to Remember the Four Pointer Changes

Think about the new node first:

```java
newNode.prev = before;
newNode.next = after;
```

Then update the surrounding nodes:

```java
before.next = newNode;
after.prev = newNode;
```

So the pattern is:

```text
Connect New Node to Neighbors

↓

Connect Neighbors to New Node
```

Or simply remember:

```text
New Node:

prev → before
next → after


Neighbors:

before.next → newNode
after.prev  → newNode
```

---

# ❓ Why Do We Use `get(index - 1)`?

We need the node immediately before the insertion position.

Example:

```java
insert(2, 25);
```

The new node should be placed at index `2`.

Therefore, the previous node is at:

```text
2 - 1 = 1
```

So we use:

```java
get(index - 1);
```

---

# ❓ Why Do We Store `after = before.next`?

Once we know the previous node, its `next` pointer gives us the node after the insertion position.

```java
Node after = before.next;
```

Now we have:

```text
before

↓

20 ⇄ 30

     ↑

   after
```

This makes reconnecting all the pointers easier to understand.

---

# ❓ Why Do We Need Four Pointer Updates?

Because a Doubly Linked List has connections in both directions.

For:

```text
20 ⇄ 25 ⇄ 30
```

We need:

```text
25.prev → 20

25.next → 30

20.next → 25

30.prev → 25
```

If even one of these connections is missing, the Doubly Linked List may become incorrectly connected.

---

# ⏱ Time Complexity

```text
Time Complexity : O(n)
```

For insertion at the beginning:

```text
O(1)
```

For insertion at the end:

```text
O(1)
```

For insertion in the middle, we use:

```java
get(index - 1);
```

The `get()` method may require traversal.

Therefore, the overall worst-case time complexity is:

```text
O(n)
```

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only a few pointer variables and one new node are used.

---

# 📊 Complexity Summary

| Operation           | Complexity |
| ------------------- | ---------- |
| Insert at Beginning | O(1)       |
| Insert at End       | O(1)       |
| Insert in Middle    | O(n)       |
| Overall Worst Case  | **O(n)**   |
| Space Complexity    | **O(1)**   |

---

# 🎓 Key Takeaways

* First, validate the index.
* Use `prepend()` when inserting at index `0`.
* Use `append()` when inserting at index `length`.
* Use `get(index - 1)` to find the node before the insertion position.
* Store the node after the insertion position.
* Connect the new node to both neighboring nodes.
* Connect both neighboring nodes back to the new node.
* Increase the length.
* Return `true` when the insertion succeeds.
* Inserting into a Doubly Linked List requires correctly updating both `next` and `prev` pointers.

---

## 📌 Interview Tip

A very common interview question is:

**How many pointer connections must be updated when inserting a node in the middle of a Doubly Linked List?**

The answer is **four**:

```java
newNode.prev = before;
newNode.next = after;
before.next = newNode;
after.prev = newNode;
```

The easiest way to remember them is:

```text
First:

Connect New Node → Neighbors

Then:

Connect Neighbors → New Node
```
----------------------------------------------------------------
# ❌ remove(index)

The **`remove()`** method removes a node from a specific index in the Doubly Linked List and returns the removed node.

Depending on the index:

* If the index is `0`, use `removeFirst()`.
* If the index is `length - 1`, use `removeLast()`.
* Otherwise, remove the node from the middle by updating the `next` and `prev` pointers.

---

## 💻 Java Solution

```java
public Node remove(int index) {
    if(index < 0 || index >= length) return null;

    if(index == 0) return removeFirst();

    if(index == length - 1) return removeLast();

    Node temp = get(index);

    temp.next.prev = temp.prev;
    temp.prev.next = temp.next;

    temp.next = null;
    temp.prev = null;

    length--;

    return temp;
}
```

---

# 📖 Code Explanation

### Step 1: Check if the Index is Valid

```java
if(index < 0 || index >= length) return null;
```

Checks whether the requested index exists in the Doubly Linked List.

For example:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40

length = 4
```

Valid indexes are:

```text
0, 1, 2, 3
```

Invalid indexes include:

```text
-1, 4, 5...
```

If the index is invalid, return `null`.

---

### Step 2: Check if Removing the First Node

```java
if(index == 0) return removeFirst();
```

If the index is `0`, the first node needs to be removed.

Instead of writing the removal logic again, reuse the existing `removeFirst()` method.

Example:

```text
10 ⇄ 20 ⇄ 30
```

Call:

```java
remove(0);
```

The method executes:

```java
removeFirst();
```

Result:

```text
20 ⇄ 30
```

Removed Node:

```text
10
```

---

### Step 3: Check if Removing the Last Node

```java
if(index == length - 1) return removeLast();
```

If the index is the last index, use the existing `removeLast()` method.

Example:

```text
10 ⇄ 20 ⇄ 30

length = 3
```

The last index is:

```text
length - 1

3 - 1 = 2
```

Call:

```java
remove(2);
```

The method executes:

```java
removeLast();
```

Result:

```text
10 ⇄ 20
```

Removed Node:

```text
30
```

---

# 🔗 Removing a Node from the Middle

If the index is neither `0` nor `length - 1`, the node must be removed from the middle.

Example:

```text
Index

 0      1      2      3

10  ⇄  20  ⇄  30  ⇄  40
```

Call:

```java
remove(2);
```

We need to remove:

```text
30
```

Expected Result:

```text
10 ⇄ 20 ⇄ 40
```

---

### Step 4: Get the Node to Remove

```java
Node temp = get(index);
```

Uses the existing `get()` method to find the node at the requested index.

Example:

```java
remove(2);
```

The method calls:

```java
get(2);
```

Result:

```text
temp → 30
```

Now:

```text
temp.prev → 20

temp      → 30

temp.next → 40
```

Visualization:

```text
temp.prev       temp       temp.next

    20     ⇄     30     ⇄     40
```

---

# 🔥 Updating the Pointers

This is the most important part of the `remove()` method.

Before:

```text
20 ⇄ 30 ⇄ 40
```

We want to remove:

```text
30
```

After:

```text
20 ⇄ 40
```

Therefore, the nodes before and after `temp` must be connected directly.

---

### Step 5: Connect the Next Node Back to the Previous Node

```java
temp.next.prev = temp.prev;
```

Let's break this line down.

We know:

```text
temp → 30
```

Therefore:

```text
temp.next → 40
```

And:

```text
temp.prev → 20
```

So:

```java
temp.next.prev = temp.prev;
```

means:

```text
40.prev = 20
```

Before:

```text
40.prev → 30
```

After:

```text
40.prev → 20
```

Visualization:

```text
20 ← 40
```

This fixes the **backward connection**.

---

### Step 6: Connect the Previous Node Forward to the Next Node

```java
temp.prev.next = temp.next;
```

Again:

```text
temp.prev → 20

temp.next → 40
```

Therefore:

```java
temp.prev.next = temp.next;
```

means:

```text
20.next = 40
```

Before:

```text
20.next → 30
```

After:

```text
20.next → 40
```

Visualization:

```text
20 → 40
```

This fixes the **forward connection**.

---

# 🖼 After Updating Both Connections

Before:

```text
20 ⇄ 30 ⇄ 40
```

After:

```text
20 ⇄ 40
```

But the removed node `30` still has its own pointers:

```text
30.prev → 20

30.next → 40
```

Therefore, we still need to disconnect it completely.

---

### Step 7: Remove the Forward Connection from the Removed Node

```java
temp.next = null;
```

Disconnects the removed node from the next node.

Before:

```text
30.next → 40
```

After:

```text
30.next → null
```

---

### Step 8: Remove the Backward Connection from the Removed Node

```java
temp.prev = null;
```

Disconnects the removed node from the previous node.

Before:

```text
30.prev → 20
```

After:

```text
30.prev → null
```

Now the removed node is completely isolated.

```text
null ← 30 → null
```

---

### Step 9: Decrease the Length

```java
length--;
```

A node has been removed, so decrease the total number of nodes by one.

---

### Step 10: Return the Removed Node

```java
return temp;
```

Returns the node that was removed from the Doubly Linked List.

---

# 🖼 Complete Example

Initial List:

```text
Index

 0      1      2      3

10  ⇄  20  ⇄  30  ⇄  40
```

Call:

```java
remove(2);
```

---

### Get the Node

```java
Node temp = get(2);
```

Result:

```text
temp → 30
```

Current Situation:

```text
temp.prev       temp       temp.next

    20     ⇄     30     ⇄     40
```

---

### Fix the Backward Connection

```java
temp.next.prev = temp.prev;
```

Which means:

```text
40.prev = 20
```

---

### Fix the Forward Connection

```java
temp.prev.next = temp.next;
```

Which means:

```text
20.next = 40
```

Now:

```text
20 ⇄ 40
```

---

### Disconnect the Removed Node

```java
temp.next = null;
temp.prev = null;
```

Removed Node:

```text
null ← 30 → null
```

---

### Final List

```text
10 ⇄ 20 ⇄ 40
```

Returned Node:

```text
30
```

---

# 🧠 Easy Way to Remember the Pointer Changes

Suppose:

```text
Before ⇄ Temp ⇄ After
```

We want:

```text
Before ⇄ After
```

First, connect `After` backward to `Before`:

```java
temp.next.prev = temp.prev;
```

Then connect `Before` forward to `After`:

```java
temp.prev.next = temp.next;
```

Finally, disconnect `Temp`:

```java
temp.next = null;
temp.prev = null;
```

So the pattern is:

```text
Connect Neighbors

↓

Disconnect Removed Node
```

---

# ❓ Why Do We Use `get(index)`?

```java
Node temp = get(index);
```

We need to find the node that should be removed.

Instead of writing the traversal logic again, we reuse the existing `get()` method.

This makes the code:

* Shorter
* Cleaner
* Easier to maintain
* Avoids duplicate traversal logic

---

# ❓ Why Do We Use `temp.next.prev = temp.prev`?

This changes the backward pointer of the node after `temp`.

Example:

```text
20 ⇄ 30 ⇄ 40
```

If `temp` is `30`:

```text
temp.next = 40

temp.prev = 20
```

Therefore:

```java
temp.next.prev = temp.prev;
```

means:

```text
40.prev = 20
```

---

# ❓ Why Do We Use `temp.prev.next = temp.next`?

This changes the forward pointer of the node before `temp`.

If:

```text
temp.prev = 20

temp.next = 40
```

Then:

```java
temp.prev.next = temp.next;
```

means:

```text
20.next = 40
```

---

# ❓ Why Do We Set Both Pointers to `null`?

```java
temp.next = null;
temp.prev = null;
```

Even after connecting the neighboring nodes, the removed node still contains references to the original list.

Setting both pointers to `null` completely isolates the removed node.

Before:

```text
20 ← 30 → 40
```

After:

```text
null ← 30 → null
```

---

# ⏱ Time Complexity

```text
Time Complexity : O(n)
```

Removing the node itself requires only constant-time pointer updates:

```text
O(1)
```

However, the method first calls:

```java
get(index);
```

Finding the node may require traversal.

Therefore, the overall worst-case time complexity is:

```text
O(n)
```

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only one temporary pointer is used.

No additional data structures are created.

---

# 📊 Complexity Summary

| Operation          | Complexity |
| ------------------ | ---------- |
| Remove First       | O(1)       |
| Remove Last        | O(1)       |
| Find Middle Node   | O(n)       |
| Pointer Updates    | O(1)       |
| Overall Worst Case | **O(n)**   |
| Space Complexity   | **O(1)**   |

---

# 🎓 Key Takeaways

* First, validate the index.
* Use `removeFirst()` when removing index `0`.
* Use `removeLast()` when removing index `length - 1`.
* Use `get(index)` to find a middle node.
* Connect the next node backward to the previous node.
* Connect the previous node forward to the next node.
* Disconnect both pointers of the removed node.
* Decrease the length.
* Return the removed node.
* Removing a middle node requires updating both forward and backward connections.

---

## 📌 Interview Tip

A common interview question is:

**How do you remove a middle node from a Doubly Linked List?**

The easiest way to remember is:

```text
Before ⇄ Temp ⇄ After

↓

Connect Before and After

↓

Before ⇄ After

↓

Disconnect Temp
```

The four important pointer operations are:

```java
temp.next.prev = temp.prev;
temp.prev.next = temp.next;

temp.next = null;
temp.prev = null;
```

Remember it as:

```text
First: Connect the neighbors.

Then: Disconnect the removed node.
```
---------------------------------