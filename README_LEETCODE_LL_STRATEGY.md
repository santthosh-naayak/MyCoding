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

# 🚀 MyCoding - Data Structures & Algorithms in Java

# 🔗 Strategy 3: Find Kth Node From End

Finding the **k-th node from the end** is one of the most common Linked List interview questions. It tests your understanding of **pointer manipulation**, **single-pass traversal**, and the **Two Pointer Technique**.

---

# 📖 Problem Statement

Implement a method called **`findKthFromEnd(int k)`** that returns the **k-th node from the end** of a singly linked list.

The linked list **does not store its length**, so you cannot use a size property.

The solution must traverse the linked list **only once**.

---

# 📌 Rules

The value of **k** is **1-based**.

* `k = 1` → Returns the last node (Tail)
* `k = 2` → Returns the second-last node
* `k = list length` → Returns the Head
* `k <= 0` → Returns `null`
* `k > list length` → Returns `null`

---

# 💡 Example

Given the linked list:

```id="eflqgg"
Head

↓

1 → 2 → 3 → 4 → 5 → null
```

| k | Returned Node |
| - | ------------- |
| 1 | 5             |
| 2 | 4             |
| 3 | 3             |
| 4 | 2             |
| 5 | 1             |
| 6 | null          |
| 0 | null          |

---

# 🎯 Constraints

* Traverse the linked list only once.
* Do not calculate the length beforehand.
* Do not use arrays or additional data structures.
* Extra space should remain constant.

---

# 🐢🐇 Recommended Approach

## Two Pointer Technique

Use two pointers:

* **Fast Pointer**
* **Slow Pointer**

### Step 1

Move the **fast pointer** `k` nodes ahead.

### Step 2

Now move **both pointers together**, one node at a time.

### Step 3

When the **fast pointer reaches the end**, the **slow pointer** will be exactly at the **k-th node from the end**.

This approach completes the task in **one traversal**.

---

# 🖼 Visualization

## Example

Find the **2nd node from the end**

```id="bifbup"
Head

↓

1 → 2 → 3 → 4 → 5 → null
```

Move the **fast pointer** two steps ahead.

```id="s1w9el"
Slow

↓

1 → 2 → 3 → 4 → 5

          ↑
         Fast
```

Now move both pointers together.

---

### Step 1

```id="06nj0q"
Slow → 2

Fast → 4
```

---

### Step 2

```id="awdy0m"
Slow → 3

Fast → 5
```

---

### Step 3

```id="eyyq3z"
Slow → 4

Fast → null
```

The fast pointer reached the end.

Therefore,

```id="udkm3h"
Return Node 4
```

---

# 💻 Java Solution

```java
public Node findKthFromEnd(int k) {

    if (k <= 0) {
        return null;
    }

    Node slow = head;
    Node fast = head;

    for (int i = 0; i < k; i++) {

        if (fast == null) {
            return null;
        }

        fast = fast.next;
    }

    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow;
}
```

---

# ⚙️ Algorithm

1. If `k <= 0`, return `null`.
2. Initialize **slow** and **fast** pointers at the head.
3. Move the **fast pointer** ahead by `k` nodes.
4. If the fast pointer becomes `null` before completing `k` steps, return `null`.
5. Move both pointers one step at a time.
6. When the fast pointer reaches `null`, return the slow pointer.

---

# 📊 Dry Run

Suppose

```id="9qldaf"
1 → 2 → 3 → 4 → 5
```

Find

```id="0bpw9i"
k = 2
```

Initial

```id="p2lq2o"
Slow = 1

Fast = 1
```

Move Fast 2 Steps

```id="oq2w6r"
Slow = 1

Fast = 3
```

Move Both

```id="d5mj08"
Slow = 2

Fast = 4
```

↓

```id="7y6n9r"
Slow = 3

Fast = 5
```

↓

```id="c5kdwn"
Slow = 4

Fast = null
```

Result

```id="br5znx"
Node 4
```

---

# ⚠️ Edge Cases

### Empty List

```id="4a4m7z"
Head = null
```

Returns

```id="t11llv"
null
```

---

### k = 0

```id="f7i5yz"
findKthFromEnd(0)
```

Returns

```id="o84qbe"
null
```

---

### k < 0

```id="nbzc1r"
findKthFromEnd(-3)
```

Returns

```id="8nk6qt"
null
```

---

### k Greater Than List Length

```id="hjvnsb"
1 → 2 → 3
```

```id="3smgof"
findKthFromEnd(5)
```

Returns

```id="yqjlwm"
null
```

---

### k Equals List Length

```id="a6wzng"
1 → 2 → 3 → 4 → 5
```

```id="89t3mr"
findKthFromEnd(5)
```

Returns

```id="30zq3z"
Head (Node 1)
```

---

# ⏱ Time Complexity

```id="cqvdfo"
O(n)
```

Only one traversal of the linked list is performed.

---

# 💾 Space Complexity

```id="i2q9q4"
O(1)
```

Only two pointers are used.

---

# ✅ Why This Approach?

A simple approach would be:

1. Traverse the list to calculate its length.
2. Traverse again to locate the required node.

This requires **two traversals**.

Using the **Two Pointer Technique**, we complete the task in **one traversal**, making it more efficient and interview-friendly.

---

# 📌 Interview Tip

Whenever you hear questions like:

* Find the k-th node from the end.
* Remove the N-th node from the end.
* Find the last k-th element.
* Solve it without knowing the length.
* Can you do it in one pass?

Think of the **Two Pointer Technique**.

This is one of the most frequently asked Linked List patterns in coding interviews.

---

# 📊 Complexity Summary

| Operation        | Complexity |
| ---------------- | ---------- |
| Time Complexity  | **O(n)**   |
| Space Complexity | **O(1)**   |

---

# 🎓 Key Takeaways

* The linked list length is unknown.
* Use **Fast** and **Slow** pointers.
* Move the fast pointer `k` nodes ahead.
* Move both pointers together until the fast pointer reaches the end.
* The slow pointer will be pointing to the **k-th node from the end**.
* This solution uses only one traversal and constant extra space.

---
# 🚀 MyCoding - Data Structures & Algorithms in Java

# 🧠 Strategy 4: Remove Duplicates

Removing duplicate values from a Linked List is a common interview question that tests your understanding of **Linked Lists**, **pointer manipulation**, and **HashSet optimization**.

This problem can be solved using two different approaches:

* **Using a HashSet** (Optimal)
* **Without Using Extra Space** (Brute Force)

---

# 📖 Problem Statement

You are given a singly linked list containing integer values. Some of these values may appear more than once.

Your task is to implement the **`removeDuplicates()`** method that removes all duplicate values **in-place**, while preserving the order of the first occurrence of each value.

> **Note:** This Linked List implementation does **not** maintain a `tail` pointer, making the implementation simpler.

---

# 📌 Requirements

* Modify the existing linked list.
* Do not create a new linked list.
* Preserve the order of unique elements.
* Remove only duplicate occurrences.

---

# 💡 Example

Input

```text
Head

↓

1 → 2 → 3 → 1 → 4 → 2 → 5 → null
```

Output

```text
Head

↓

1 → 2 → 3 → 4 → 5 → null
```

---

# 🎯 Approach 1: Using HashSet (Optimal)

A **HashSet** stores all unique values encountered while traversing the linked list.

For each node:

* If the value already exists in the HashSet, remove the node.
* Otherwise, add the value to the HashSet and continue.

This avoids repeatedly searching the list.

---

# 🖼 Visualization

Initial List

```text
1 → 2 → 3 → 1 → 4 → 2 → 5
```

HashSet Progress

```text
Visit 1

Set = {1}
```

↓

```text
Visit 2

Set = {1,2}
```

↓

```text
Visit 3

Set = {1,2,3}
```

↓

```text
Visit 1

Already Exists ❌

Remove Node
```

↓

```text
Visit 4

Set = {1,2,3,4}
```

↓

```text
Visit 2

Already Exists ❌

Remove Node
```

↓

```text
Visit 5

Set = {1,2,3,4,5}
```

Final List

```text
1 → 2 → 3 → 4 → 5
```

---

# 💻 Java Solution (Using HashSet)

```java
public void removeDuplicates() {

    HashSet<Integer> set = new HashSet<>();

    Node previous = null;
    Node current = head;

    while (current != null) {

        if (set.contains(current.value)) {

            previous.next = current.next;

        } else {

            set.add(current.value);
            previous = current;

        }

        current = current.next;
    }

}
```

---

# ⚙️ Algorithm

1. Create an empty HashSet.
2. Traverse the linked list.
3. If the current value is already present:

   * Remove the node.
4. Otherwise:

   * Store the value in the HashSet.
   * Move the previous pointer.
5. Continue until the end of the list.

---

# ⏱ Time Complexity

```text
O(n)
```

Each node is visited only once.

---

# 💾 Space Complexity

```text
O(n)
```

The HashSet stores all unique values.

---

# 🎯 Approach 2: Without Using Extra Space

If additional data structures are not allowed, compare every node with all remaining nodes.

Whenever a duplicate is found, remove it.

Although this approach does not use extra memory, it requires nested traversal.

---

# 🖼 Visualization

```text
1 → 2 → 3 → 1 → 4 → 2 → 5
```

Outer Loop

```text
Current = 1
```

Inner Loop removes

```text
Duplicate 1
```

---

Outer Loop

```text
Current = 2
```

Inner Loop removes

```text
Duplicate 2
```

Final List

```text
1 → 2 → 3 → 4 → 5
```

---

# 💻 Java Solution (Without HashSet)

```java
public void removeDuplicates() {

    Node current = head;

    while (current != null) {

        Node runner = current;

        while (runner.next != null) {

            if (runner.next.value == current.value) {

                runner.next = runner.next.next;

            } else {

                runner = runner.next;

            }

        }

        current = current.next;

    }

}
```

---

# ⚙️ Algorithm

1. Start with the first node.
2. Compare it with every remaining node.
3. Remove duplicate nodes.
4. Move to the next unique node.
5. Repeat until the list ends.

---

# ⚠️ Edge Cases

### Empty List

```text
Head → null
```

Output

```text
null
```

---

### Single Node

```text
5
```

Output

```text
5
```

---

### No Duplicates

```text
1 → 2 → 3 → 4
```

Output

```text
1 → 2 → 3 → 4
```

---

### All Elements Same

```text
7 → 7 → 7 → 7
```

Output

```text
7
```

---

### Consecutive Duplicates

```text
1 → 1 → 2 → 2 → 3 → 3
```

Output

```text
1 → 2 → 3
```

---

# 📊 Complexity Comparison

| Approach        | Time      | Space    |
| --------------- | --------- | -------- |
| Using HashSet   | **O(n)**  | **O(n)** |
| Without HashSet | **O(n²)** | **O(1)** |

---

# 📌 Interview Tip

Whenever an interviewer asks questions like:

* Remove duplicate values.
* Keep only unique elements.
* Remove repeated nodes.
* Can you solve it without extra space?
* Can you optimize using a HashSet?

Think about these two approaches:

1. **HashSet** → Best Time Complexity (**O(n)**)
2. **Runner Technique** → No Extra Space (**O(n²)**)

Interviewers often ask for both solutions to evaluate your understanding of **time-space trade-offs**.

---

# 🎓 Key Takeaways

* Duplicate values should be removed **in-place**.
* The order of unique elements must remain unchanged.
* **HashSet** provides an optimal **O(n)** solution.
* Without extra space, the **Runner Technique** solves the problem in **O(n²)**.
* This is one of the classic Linked List interview questions for understanding optimization and pointer manipulation.

---
# 🚀 MyCoding - Data Structures & Algorithms in Java

# 🧠 Strategy 5: Binary to Decimal

Converting a binary number stored in a **Linked List** into its decimal equivalent is a common interview problem. It helps reinforce concepts of **Linked Lists**, **binary numbers**, and **iterative computation**.

---

# 📖 Problem Statement

You are given a singly linked list where each node contains either **0** or **1**, representing a binary number.

Your task is to implement the **`binaryToDecimal()`** method that converts this binary number into its decimal equivalent.

Each node represents one binary digit, with the **head** containing the **most significant bit (MSB)**.

---

# 📌 Method Signature

```java
public int binaryToDecimal()
```

---

# 💡 How Binary to Decimal Conversion Works

In a binary number:

* The rightmost digit represents **2⁰**
* The next digit represents **2¹**
* Then **2²**
* Then **2³**
* ...and so on.

Instead of calculating powers of 2 manually, we can use a much simpler approach.

For every binary digit:

1. Multiply the current decimal value by **2**.
2. Add the current binary digit.

This efficiently builds the decimal number while traversing the linked list only once.

---

# 🖼 Visualization

## Example 1

Binary Number

```text
1 → 0 → 1
```

Represents

```text
101₂
```

Decimal Value

```text
5
```

---

## Step-by-Step Execution

Initialize

```text
num = 0
```

Visit First Node

```text
num = 0 × 2 + 1

num = 1
```

↓

Visit Second Node

```text
num = 1 × 2 + 0

num = 2
```

↓

Visit Third Node

```text
num = 2 × 2 + 1

num = 5
```

Return

```text
5
```

---

# 🖼 Another Example

Binary Linked List

```text
Head

↓

1 → 1 → 0 → 1
```

Represents

```text
1101₂
```

Calculation

```text
num = 0

↓

0 × 2 + 1 = 1

↓

1 × 2 + 1 = 3

↓

3 × 2 + 0 = 6

↓

6 × 2 + 1 = 13
```

Return

```text
13
```

---

# 💻 Java Solution

```java
public int binaryToDecimal() {

    int num = 0;

    Node current = head;

    while (current != null) {

        num = num * 2 + current.value;

        current = current.next;

    }

    return num;
}
```

---

# ⚙️ Algorithm

1. Initialize `num` to **0**.
2. Start from the head of the linked list.
3. For every node:

   * Multiply `num` by **2**.
   * Add the current node's value.
4. Move to the next node.
5. Continue until the end of the linked list.
6. Return `num`.

---

# 📊 Dry Run

Suppose the linked list is

```text
1 → 0 → 1 → 1
```

Initial

```text
num = 0
```

Node = 1

```text
num = 0 × 2 + 1 = 1
```

↓

Node = 0

```text
num = 1 × 2 + 0 = 2
```

↓

Node = 1

```text
num = 2 × 2 + 1 = 5
```

↓

Node = 1

```text
num = 5 × 2 + 1 = 11
```

Result

```text
1011₂ = 11₁₀
```

---

# ⚠️ Edge Cases

### Empty Linked List

```text
Head → null
```

Returns

```text
0
```

---

### Single Node (0)

```text
0
```

Returns

```text
0
```

---

### Single Node (1)

```text
1
```

Returns

```text
1
```

---

### All Zeros

```text
0 → 0 → 0 → 0
```

Returns

```text
0
```

---

### All Ones

```text
1 → 1 → 1
```

Calculation

```text
111₂ = 7₁₀
```

Returns

```text
7
```

---

# ⏱ Time Complexity

```text
O(n)
```

Each node is visited exactly once.

---

# 💾 Space Complexity

```text
O(1)
```

Only one integer variable and one pointer are used.

---

# 📌 Why This Approach?

A beginner might try to:

* Count the total number of nodes.
* Calculate powers of **2** for every position.
* Sum each value separately.

While this works, it is more complicated.

The formula:

```text
num = num × 2 + current.value
```

is simpler, more efficient, and naturally simulates how binary numbers are built.

---

# 📊 Complexity Summary

| Operation        | Complexity |
| ---------------- | ---------- |
| Time Complexity  | **O(n)**   |
| Space Complexity | **O(1)**   |

---

# 📌 Interview Tip

Whenever an interviewer asks questions like:

* Convert Binary Linked List to Integer.
* Convert Binary Number to Decimal.
* Evaluate a Binary Linked List.
* Interpret a Linked List as a Binary Number.

Think about this formula:

```text
num = num × 2 + current.value
```

It is the most efficient solution and avoids unnecessary calculations using powers of 2.

---

# 🎓 Key Takeaways

* Each node represents a binary digit (**0** or **1**).
* Traverse the linked list only once.
* Multiply the current decimal value by **2** before processing the next digit.
* Add the current binary digit to the result.
* The algorithm runs in **O(n)** time with **O(1)** extra space.

---
# 🚀 MyCoding - Data Structures & Algorithms in Java

# 🧠 Strategy 6: Partition List

> ⚠️ **Advanced Interview Question**

This is one of the more challenging Linked List interview problems. Unlike previous questions, this problem requires careful manipulation of node pointers while preserving the original order of nodes.

A good approach is to draw the linked list on paper and trace each pointer movement before implementing the solution.

---

# 📖 Problem Statement

You are given a singly linked list **without a tail pointer** and an integer **x**.

Rearrange the linked list so that:

* All nodes with values **less than x** appear before nodes with values **greater than or equal to x**.
* The **relative order** of nodes in both partitions remains unchanged.
* The linked list must be modified **in-place**.

---

# 📌 Method Signature

```java
public void partitionList(int x)
```

---

# 🎯 Constraints

* Traverse the linked list at most **once**.
* Do not create a new linked list.
* Do not modify node values.
* Only change the **next** pointers.
* Preserve the relative order of nodes.

---

# 💡 Example 1

Input

```text
Linked List

3 → 8 → 5 → 10 → 2 → 1

x = 5
```

Partition

```text
Less than 5

3 → 2 → 1
```

```text
Greater than or Equal to 5

8 → 5 → 10
```

Output

```text
3 → 2 → 1 → 8 → 5 → 10
```

---

# 💡 Example 2

Input

```text
Linked List

1 → 4 → 3 → 2 → 5 → 2

x = 3
```

Partition

```text
Less than 3

1 → 2 → 2
```

```text
Greater than or Equal to 3

4 → 3 → 5
```

Output

```text
1 → 2 → 2 → 4 → 3 → 5
```

---

# ❓ Why Not Just Swap Values?

Many beginners think of swapping node values.

Example

```text
3 → 8 → 5 → 10 → 2 → 1
```

Swap values

```text
3 → 2 → 1 → 10 → 8 → 5
```

This is **incorrect** because:

* The problem explicitly states **do not modify node values**.
* The relative order must remain unchanged.

Correct order

```text
8 → 5 → 10
```

Incorrect after swapping

```text
10 → 8 → 5
```

Therefore, we must move **nodes**, not values.

---

# 💡 Recommended Approach

The easiest solution is to build **two separate chains** while traversing the list.

* One chain for values **less than x**.
* Another chain for values **greater than or equal to x**.

Finally, connect both chains.

---

# 🖼 Visualization

Original List

```text
3 → 8 → 5 → 10 → 2 → 1
```

Create Two Chains

Less List

```text
3 → 2 → 1
```

Greater List

```text
8 → 5 → 10
```

Connect Them

```text
3 → 2 → 1 → 8 → 5 → 10
```

Done!

---

# ❓ Why Use Dummy Nodes?

Without dummy nodes, inserting the very first node into each partition requires special handling.

Dummy nodes eliminate these edge cases by always giving us a valid starting point.

Initially

```text
lessDummy → null

greaterDummy → null
```

As nodes are processed

```text
lessDummy → 3 → 2 → 1

greaterDummy → 8 → 5 → 10
```

Finally

```text
3 → 2 → 1 → 8 → 5 → 10
```

Dummy nodes themselves are discarded.

---

# 💻 Java Solution

```java
public void partitionList(int x) {

    if (head == null) {
        return;
    }

    Node dummy1 = new Node(0);
    Node dummy2 = new Node(0);

    Node prev1 = dummy1;
    Node prev2 = dummy2;
    Node current = head;

    while (current != null) {

        if (current.value < x) {
            prev1.next = current;
            prev1 = current;
        } else {
            prev2.next = current;
            prev2 = current;
        }

        current = current.next;
    }

    prev2.next = null;
    prev1.next = dummy2.next;

    head = dummy1.next;
}
```

---

# ⚙️ Algorithm

1. If the list is empty, return.
2. Create two dummy nodes.
3. Traverse the linked list once.
4. If the current value is less than `x`, attach it to the first list.
5. Otherwise, attach it to the second list.
6. Terminate the second list.
7. Connect the first list with the second list.
8. Update the head.

---

# 📊 Dry Run

Input

```text
3 → 8 → 5 → 10 → 2 → 1

x = 5
```

After processing

Less List

```text
3 → 2 → 1
```

Greater List

```text
8 → 5 → 10
```

Merge

```text
3 → 2 → 1 → 8 → 5 → 10
```

Return

```text
Updated Linked List
```

---

# ⚠️ Edge Cases

### Empty List

```text
Head → null
```

Output

```text
null
```

---

### All Nodes Less Than x

Input

```text
1 → 2 → 3

x = 5
```

Output

```text
1 → 2 → 3
```

---

### All Nodes Greater Than or Equal to x

Input

```text
8 → 9 → 10

x = 5
```

Output

```text
8 → 9 → 10
```

---

### Duplicate Values

Input

```text
2 → 5 → 2 → 5 → 1
```

Output

```text
2 → 2 → 1 → 5 → 5
```

Relative order is preserved.

---

### x Not Present

Input

```text
1 → 7 → 4 → 8

x = 5
```

Output

```text
1 → 4 → 7 → 8
```

---

# ⏱ Time Complexity

```text
O(n)
```

Each node is visited exactly once.

---

# 💾 Space Complexity

```text
O(1)
```

Only a few pointer variables are used. The dummy nodes are constant extra space and do not depend on the size of the input.

---

# 📊 Complexity Summary

| Operation        | Complexity |
| ---------------- | ---------- |
| Time Complexity  | **O(n)**   |
| Space Complexity | **O(1)**   |

---

# 📌 Interview Tip

Whenever you hear questions like:

* Partition a Linked List.
* Separate nodes based on a pivot.
* Rearrange nodes without changing values.
* Preserve the relative order.
* Solve in one traversal.

Think about maintaining **two linked lists (or chains)** using **dummy nodes**, then joining them at the end.

This pattern appears in several Linked List interview problems.

---

# 🎓 Key Takeaways

* Never swap node values unless the problem explicitly allows it.
* Rearrange **nodes**, not data.
* Dummy nodes simplify pointer manipulation.
* Build two separate chains while traversing.
* Connect the chains after traversal.
* Preserve the original order within each partition.
* This is a classic Linked List interview problem that demonstrates pointer manipulation and in-place list reordering.

---


