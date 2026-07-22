# 📘 README - Binary Search Partition Pattern (Median of Two Sorted Arrays)

## 🎯 Problem

**LeetCode #4 - Median of Two Sorted Arrays**

* **Difficulty:** Hard
* **Pattern:** Binary Search + Partition
* **Time Complexity:** `O(log(min(m, n)))`
* **Space Complexity:** `O(1)`

---

# 📌 Real World Problem

Imagine two sorted queues of people.

```
Queue A
10 20 30

Queue B
15 25 35 45
```

You need to divide everyone into:

* Left Half → Smaller values
* Right Half → Larger values

❌ You are **not allowed to merge** the queues.

Your job is to find the **median** directly.

---

# 🧠 Core Idea

We are **NOT searching for the median value.**

We are searching for the **Correct Partition (Wall).**

---

# 🧱 What is a Partition?

A partition is simply a **wall** placed between elements.

Example:

```
Array = [1, 3, 8]

|1 3 8
1|3 8
1 3|8
1 3 8|
```

**Important**

For an array with **n elements**

```
Possible Partitions = n + 1
```

---

# 🎯 partitionX & partitionY

They are **NOT elements.**

They are **wall positions.**

Example

```
partitionX = 2

1 3 | 8
```

means

> Place the wall after the first **2 elements**.

Similarly

```
partitionY = 2

7 9 | 10 11
```

---

# 🤔 Why Partition?

Although

```
Array1
1 100

Array2
2 3
```

Both arrays are sorted individually,

Combined order becomes

```
1 2 3 100
```

So

```
Last of Array1
```

and

```
First of Array2
```

are **NOT always the middle elements.**

Therefore,

we must determine

> **How many elements should come from Array1 and Array2 so that together they form the smallest half of the merged array.**

---

# 💡 Binary Search Thinking

Normal Binary Search

```
Searching for a Number
```

Median Problem

```
Searching for a Partition Position
```

Search Space

```
|1 3 8

1|3 8

1 3|8

1 3 8|
```

Binary Search moves among these possible walls.

---

# 📌 Why Binary Search?

Binary Search means

> **Repeatedly eliminate half of the possible answers.**

It is **NOT limited to searching numbers.**

It can search for

* Index
* Position
* Partition
* Capacity
* Speed
* Time
* Answer

---

# 🧠 How partitionY is Calculated

Left side must contain

```
Half of total elements.
```

Suppose

```
Left side needs = 4 elements
```

If

```
partitionX = 2
```

then

```
partitionY = 2
```

Formula

```java
partitionY = LeftSize - partitionX;
```

Meaning

> Whatever Array1 doesn't contribute,
> Array2 contributes.

---

# 📌 Boundary Values

Every partition creates four values.

```
Array1

1 3 | 8

leftMaxX = 3
rightMinX = 8
```

```
Array2

7 9 |10 11

leftMaxY = 9
rightMinY =10
```

We only compare these **4 values** because both arrays are already sorted internally.

---

# ✅ Correct Partition

Correct partition means

```
Largest Left ≤ Smallest Right
```

Code

```java
leftMaxX <= rightMinY

&&

leftMaxY <= rightMinX
```

Human Meaning

> Every value on the left is smaller than every value on the right.

---

# ❌ Wrong Partition

### Case 1

```
leftMaxX > rightMinY
```

Meaning

Array1 contributed **too many** elements.

Wall is too far right.

Move Left

```java
high = partitionX - 1;
```

---

### Case 2

Otherwise

```
leftMaxY > rightMinX
```

Meaning

Array1 contributed **too few** elements.

Wall is too far left.

Move Right

```java
low = partitionX + 1;
```

---

# 🎯 Where is Binary Search Happening?

Here

```java
partitionX = (low + high) / 2;
```

We are **NOT binary searching values.**

We are binary searching

```
Possible Wall Positions.
```

---

# 📌 Median Calculation

### Odd Elements

Median =

```
Largest value on Left
```

```java
Math.max(leftMaxX, leftMaxY)
```

---

### Even Elements

Median =

```
Largest Left

+

Smallest Right

-----------------

2
```

```java
(Math.max(leftMaxX,leftMaxY)
+
Math.min(rightMinX,rightMinY))
/2.0;
```

---

# 🌍 Real-Life Examples

### 📚 Library

Searching for a book

↓

Go to middle shelf

↓

Discard half the shelves

↓

Repeat

---

### 🎂 Guess My Age

Range

```
1 - 100
```

Guess

```
50
```

Too High?

↓

Search Left

Too Low?

↓

Search Right

---

### ☕ Coffee Sweetness

Sweetness

```
1 - 100
```

Too Sweet?

↓

Lower

Too Bitter?

↓

Increase

Binary Search reduces possibilities.

---

### 👥 Two Queues

Two sorted queues.

Need left group = smallest half.

Cannot merge.

Use partitions to decide

* How many from Queue A
* How many from Queue B

---

# 🔍 Pattern Recognition

Whenever you hear

* Two Sorted Arrays
* Median
* O(log n)
* Don't Merge
* Constant Space

Immediately think

```
Binary Search on Partition
```

---

# 💼 Google Interview Answer

> Instead of merging both sorted arrays, I binary search the smaller array to find the correct partition. The partition divides both arrays into a left half and a right half. I verify that the left half contains the smaller elements by comparing only the four boundary values. Once the partition is correct, I compute the median directly from those boundary values.

---

# 🧠 Mental Model

```
Two Sorted Arrays
        │
        ▼
Binary Search on Smaller Array
        │
        ▼
Guess a Wall (Partition)
        │
        ▼
Automatically Calculate Other Wall
        │
        ▼
Compare Four Boundary Values
        │
        ▼
Correct Partition?
     /          \
   Yes          No
    │            │
    ▼            ▼
Return Median   Move Wall
```

---

# 🚀 Mental Recognition Checklist

Whenever you solve a Binary Search problem, ask yourself:

1. What is the search space?
2. What does the middle represent?
3. How do I know the middle is correct?
4. What condition tells me to move left?
5. What condition tells me to move right?
6. Can I eliminate half the search space?

If the answer is **YES**, Binary Search is likely the right approach.

---

# ⭐ 10 Things to Remember

1. Binary Search searches an **ordered search space**, not just arrays.
2. Here, the search space is **partition positions**.
3. A partition is a **wall**, not an element.
4. An array of **n elements** has **n+1 partition positions**.
5. Always binary search the **smaller array**.
6. `partitionY` is calculated automatically.
7. Only **4 boundary values** decide whether the partition is correct.
8. If `leftMaxX > rightMinY`, move the wall **left**.
9. Otherwise, move the wall **right**.
10. The median always comes from the **boundary values around the correct partition**.

---

# 🌟 One-Line Memory Trick

> **Binary Search is not searching for the median. It is searching for the perfect wall that divides two sorted arrays into the smallest half and the largest half.**

---

# 🏆 Final Takeaway

**Algorithm Flow**

```
Two Sorted Arrays
        │
        ▼
Choose Smaller Array
        │
        ▼
Binary Search on Wall Positions
        │
        ▼
Compute Second Wall
        │
        ▼
Check Four Boundary Values
        │
        ▼
Correct Wall?
     │
     ├── Yes → Return Median
     │
     └── No
          │
          ├── Too Many from Array1 → Move Left
          │
          └── Too Few from Array1 → Move Right
```

> **Think of yourself as finding the perfect wall—not the median itself. Once the wall is correct, the median is already waiting at the boundary.**
