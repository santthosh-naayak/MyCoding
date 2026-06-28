# 🚀 MyCoding - Data Structures & Algorithms in Java

Welcome to **MyCoding**! 👋

This repository contains my complete journey of learning **Data Structures & Algorithms (DSA)** in **Java**. The goal is to master DSA concepts from scratch, understand how things work internally, and prepare for coding interviews at top product-based companies.

---

# 📚 Topics Covered

## ✅ LeetCode Strategies

This section contains common problem-solving patterns that frequently appear in coding interviews. Instead of memorizing solutions, learning these strategies helps you identify the correct approach for different problems.

---

# 🐢🐇 Strategy 1: Find Middle Node (Slow & Fast Pointer)

## 📖 Problem

Given the head of a singly linked list, find and return the **middle node**.

If the linked list has an **even number of nodes**, return the **second middle node**.

---

## 💡 Approach

Use the **Slow and Fast Pointer Technique**, also known as **Floyd's Tortoise and Hare Algorithm**.

The idea is simple:

* Move the **slow pointer** one step at a time.
* Move the **fast pointer** two steps at a time.
* When the fast pointer reaches the end of the list, the slow pointer will be exactly at the middle.

This approach allows us to find the middle node in a **single traversal** without first counting the total number of nodes.

---

## 🖼 Visualization

### Example 1 (Odd Number of Nodes)

```
Head

↓

10 → 20 → 30 → 40 → 50 → null
```

Movement

```
Step 1

Slow → 20
Fast → 30

-------------------

Step 2

Slow → 30
Fast → 50

-------------------

Step 3

Fast reaches null

Slow is at 30 ✅
```

Middle Node

```
30
```

---

### Example 2 (Even Number of Nodes)

```
Head

↓

10 → 20 → 30 → 40 → 50 → 60 → null
```

Movement

```
Step 1

Slow → 20
Fast → 30

-------------------

Step 2

Slow → 30
Fast → 50

-------------------

Step 3

Slow → 40
Fast → null
```

Returned Middle Node

```
40
```

Notice that for an even-length list, the algorithm returns the **second middle node**, which matches the requirement of many LeetCode problems.

---

## 💻 Java Solution

```java
public Node findMiddleNode() {

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}
```

---

## ⚙️ Algorithm

1. Initialize both **slow** and **fast** pointers at the head.
2. Move **slow** one node at a time.
3. Move **fast** two nodes at a time.
4. Continue until **fast** reaches the end of the linked list.
5. Return the **slow** pointer.

---

## ⏱ Time Complexity

```
O(n)
```

The linked list is traversed only once.

---

## 💾 Space Complexity

```
O(1)
```

Only two pointers are used regardless of the size of the linked list.

---

## 🎯 Why This Approach?

Instead of:

1. Counting the total number of nodes.
2. Traversing again to reach the middle.

which requires **two traversals**, the Slow & Fast Pointer approach finds the middle in **one traversal**, making it more efficient and elegant.

---

## 📌 Interview Tip

Whenever you hear questions like:

* Find the middle node
* Split a linked list into two halves
* Check if a linked list is a palindrome
* Detect a cycle
* Find the starting point of a cycle

Think about the **Slow & Fast Pointer Technique** first. It is one of the most common Linked List patterns asked in coding interviews.

---

# 🚀 MyCoding - Data Structures & Algorithms in Java

# 🔗 Strategy 2: Detect Loop (Has Loop)

One of the most frequently asked Linked List interview questions is to determine whether a linked list contains a **cycle (loop)**.

This problem is commonly asked in coding interviews because it tests your understanding of **Linked Lists**, **Pointers**, and the **Two Pointer Technique**.

---

# 📖 Problem Statement

Write a method called **`hasLoop()`** that detects whether a singly linked list contains a cycle.

A cycle exists when one of the nodes points back to a previous node instead of pointing to `null`.

Instead of ending like a normal linked list, the nodes continue to repeat forever.

---

# 💡 Example of a Normal Linked List

```
Head

↓

10 → 20 → 30 → 40 → null
```

There is **no loop**.

Output

```
false
```

---

# 💡 Example of a Linked List with a Loop

```
Head

↓

10 → 20 → 30 → 40
      ↑          |
      |__________|
```

Node **40** points back to **20**, creating a cycle.

Output

```
true
```

---

# 🎯 Constraints

* Do not use additional data structures like:

  * Array
  * ArrayList
  * HashSet
  * HashMap
* Traverse the linked list only once.
* Do not modify the existing linked list.
* Extra Space Allowed: **O(1)**

---

# 🐢🐇 Recommended Approach

## Floyd's Cycle Detection Algorithm

Also known as the **Tortoise and Hare Algorithm**.

This algorithm uses two pointers:

* **Slow Pointer** → Moves one node at a time.
* **Fast Pointer** → Moves two nodes at a time.

If the linked list contains a loop, the fast pointer will eventually catch up with the slow pointer.

If there is no loop, the fast pointer will eventually reach `null`.

---

# ⚙️ Algorithm

1. Initialize both pointers at the head.
2. Move **slow** one step.
3. Move **fast** two steps.
4. If both pointers meet, return `true`.
5. If the fast pointer reaches `null`, return `false`.

---

# 🖼 Visualization

## Example Without Loop

```
Head

↓

10 → 20 → 30 → 40 → null
```

Movement

```
Step 1

Slow → 20

Fast → 30

------------------

Step 2

Slow → 30

Fast → null
```

Since the fast pointer reached the end of the list,

```
Return false
```

---

## Example With Loop

```
Head

↓

10 → 20 → 30 → 40
      ↑          |
      |__________|
```

Movement

```
Initial

Slow = 10

Fast = 10

------------------

Step 1

Slow = 20

Fast = 30

------------------

Step 2

Slow = 30

Fast = 20

------------------

Step 3

Slow = 40

Fast = 40
```

Both pointers meet.

```
Return true
```

---

# 💻 Java Solution

```java
public boolean hasLoop() {

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            return true;
        }

    }

    return false;
}
```

---

# ⏱ Time Complexity

```
O(n)
```

Only one traversal of the linked list is required.

---

# 💾 Space Complexity

```
O(1)
```

Only two pointers are used.

---

# ✅ Why This Algorithm?

A brute-force approach would require storing visited nodes in a collection like a `HashSet`, which takes extra memory.

Floyd's Algorithm is more efficient because:

* Uses constant extra space.
* Traverses the list only once.
* Does not modify the linked list.
* Works for loops of any size.

---

# 📌 Interview Tip

Whenever an interviewer asks questions like:

* Does this linked list contain a cycle?
* Detect a loop in a linked list.
* Find whether a node repeats.
* Can you solve it without extra memory?

The expected solution is almost always **Floyd's Cycle Detection Algorithm (Slow & Fast Pointer Technique)**.

---

# 📊 Complexity Summary

| Operation        | Complexity |
| ---------------- | ---------- |
| Time Complexity  | **O(n)**   |
| Space Complexity | **O(1)**   |

---

# 🎓 Key Takeaways

* A loop occurs when a node points back to a previous node instead of `null`.
* Use two pointers:

  * Slow → Moves one node.
  * Fast → Moves two nodes.
* If the pointers meet, a loop exists.
* If the fast pointer reaches `null`, there is no loop.
* This is one of the most important Linked List interview questions and demonstrates the power of the **Two Pointer Technique**.

---
