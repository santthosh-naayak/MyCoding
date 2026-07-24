# 📘 README – Merge K Sorted Lists

## Difficulty

**Hard**

---

# 🎯 Pattern Used

* Heap
* Priority Queue (Min Heap)
* Linked List
* K-Way Merge

---

# 🏗 Data Structures Used

* **Priority Queue (Min Heap)** → Always retrieves the smallest available node.
* **Linked List** → Stores the input and output efficiently.
* **Dummy Node** → Simplifies building the merged linked list.
* **Current Pointer** → Tracks the end of the merged list.

---

# ⚙️ Algorithms Used

### Priority Queue (Min Heap)

Always keeps the smallest current node at the top.

---

### K-Way Merge

Merge multiple already sorted linked lists into one sorted linked list.

---

# 🎯 Goal

Merge

```text
K Sorted Linked Lists

↓

One Sorted Linked List
```

while maintaining ascending order.

---

# 🌍 Real World Problem

Imagine **three supermarket checkout counters**.

```text
Counter A

1 → 4 → 5

Counter B

1 → 3 → 4

Counter C

2 → 6
```

Customers in each counter are already standing in sorted order.

Your job is to create **one final queue**.

Every time,

look only at the **first customer** from every counter.

Take the smallest one.

Repeat until every customer has joined the final queue.

---

# ☁ Google / Real Product Example

Google Search indexes are split across multiple servers.

Each server returns its search results already sorted.

Google merges these sorted results into one final ranked result.

Conceptually:

```text
Server 1

↓

Server 2

↓

Server 3

↓

Merge

↓

Final Search Results
```

This is the same K-way merge pattern.

---

# 🧠 Core Idea

Every linked list is already sorted.

Therefore,

only the **head node** of each linked list can be the next smallest element.

Store those head nodes inside a Min Heap.

Example:

```text
1 → 4 → 5

1 → 3 → 4

2 → 6
```

Heap initially contains

```text
1

1

2
```

Remove the smallest,

then insert the next node from that same linked list.

Repeat until the heap becomes empty.

---

# 💻 Computer Thinking

Computer does not see

```text
Linked Lists
```

Computer sees

```text
Current Heads

↓

Priority Queue

↓

Smallest Node

↓

Merged List

↓

Next Node

↓

Repeat
```

---

# 👨 Human Thinking

Humans think

```text
Compare the first number of every list.

↓

Take the smallest.

↓

Move that list forward.

↓

Repeat.
```

Computer thinks

```text
Heap

↓

poll()

↓

Append

↓

offer(next)

↓

Repeat
```

---

# 🚀 Algorithm

### Step 1

Create a Min Heap.

---

### Step 2

Insert the head node of every linked list.

```text
Only one node per list.
```

---

### Step 3

Remove the smallest node.

```text
poll()
```

---

### Step 4

Attach it to the merged linked list.

---

### Step 5

If that node has another node,

insert

```text
smallest.next
```

into the heap.

---

### Step 6

Repeat until the heap becomes empty.

Return the merged linked list.

---

# 🔄 Algorithm Flow

```text
K Sorted Lists

↓

Insert Heads into Heap

↓

Remove Smallest Node

↓

Append to Answer

↓

Insert Next Node
(from same list)

↓

Heap Empty?

↓

No

↓

Repeat

↓

Merged Linked List
```

---

# 🧠 Mental Recognition

Whenever you hear

* Merge K Sorted Lists
* Merge Multiple Sorted Arrays
* Merge Sorted Streams
* Merge Sorted Files
* Continuously find the smallest element

Immediately think

```text
Multiple Sorted Sources

↓

Priority Queue

↓

Min Heap

↓

Merge
```

---

# ❓Why Priority Queue?

Because every iteration needs

```text
Smallest Element
```

Without Heap

```text
Scan every list

↓

O(K)
```

With Heap

```text
poll()

↓

O(log K)
```

Much faster.

---

# ❓Why Insert Only Head Nodes?

Example

```text
1 → 4 → 5
```

Since

```text
1 < 4 < 5
```

there is no reason to compare

```text
4

or

5
```

until

```text
1
```

has already been used.

Only one candidate from each list is needed.

---

# ❓Why Remove the Smallest Node?

Suppose Heap contains

```text
1

1

2
```

The next node of the merged list **must** be

```text
1
```

So we remove it.

Think of it like

```text
To-do List

↓

Finish Task

↓

Remove Task

↓

Move to Next Task
```

---

# ❓Why Insert `smallest.next`?

Suppose we removed

```text
1 → 4 → 5
```

Now

```text
4
```

becomes the next candidate from that linked list.

So we insert

```text
4
```

into the heap.

---

# ❓Why Dummy Node?

Without Dummy Node

First insertion needs special handling.

With Dummy Node

Every insertion becomes

```java
current.next = smallest;
current = current.next;
```

No special cases.

Cleaner code.

---

# 📊 Complexity

### Time Complexity

```text
O(N log K)
```

Where

* **N** = Total number of nodes
* **K** = Number of linked lists

---

### Space Complexity

```text
O(K)
```

Heap stores at most one node from each linked list.

---

# 💼 Google Interview Explanation (30 Seconds)

> Every linked list is already sorted, so only the head of each list can be the next smallest candidate. I insert those head nodes into a Min Heap. I repeatedly remove the smallest node, append it to the answer, and insert the next node from that same linked list into the heap. This keeps only one candidate from each list in the heap at any time, resulting in **O(N log K)** time and **O(K)** space.

---

# ⭐ 10 Things to Remember

1. Every linked list is already sorted.
2. Only the head node can be the next smallest candidate.
3. Heap always gives the smallest node.
4. Insert only one node per list into the heap.
5. After removing a node, insert its next node.
6. Heap size is at most K.
7. Dummy node simplifies linked list construction.
8. Current pointer always points to the last merged node.
9. Every node enters the heap exactly once.
10. This is a classic K-Way Merge problem.

---

# 🧠 Mental Recognition Checklist

✅ Multiple Sorted Lists

↓

✅ Need Smallest Repeatedly

↓

✅ Heap

↓

✅ Priority Queue

↓

✅ Dummy Node

↓

✅ Current Pointer

↓

✅ K-Way Merge

---

# 🌟 One-Line Memory Trick

```text
K Sorted Lists

↓

Current Heads

↓

Min Heap

↓

Smallest Node

↓

Insert Next

↓

Merged List
```

---

# 🔗 Related Problems

* Merge Two Sorted Lists
* Merge Sorted Arrays
* Kth Largest Element in an Array
* Top K Frequent Elements
* Find Median from Data Stream
* Smallest Range Covering Elements from K Lists
* External Merge Sort

---

# 🎯 Why Google Uses This Pattern

Google systems constantly merge sorted data coming from multiple machines.

Examples:

* Search result aggregation
* Distributed log merging
* External file sorting
* BigQuery data processing
* Event stream merging
* Index merging

The Min Heap allows Google to efficiently process the next smallest item from many sorted sources without scanning them repeatedly.

---

# 📝 Revision Summary

```text
K Sorted Lists

↓

Current Heads

↓

Priority Queue

↓

Remove Smallest

↓

Append to Answer

↓

Insert Next Node

↓

Repeat

↓

Merged Sorted List
```