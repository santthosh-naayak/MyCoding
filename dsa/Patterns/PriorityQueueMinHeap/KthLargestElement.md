# **Difficulty:** Medium

**Pattern:** Heap (Priority Queue)

**LeetCode:** https://leetcode.com/problems/kth-largest-element-in-an-array/

---

# Problem

Given an integer array `nums` and an integer `k`, return the **kth largest** element in the array.

> Note: It is the kth largest element in the sorted order, **not** the kth distinct element.

---

# Example

### Input

```text
nums = [3,2,1,5,6,4]
k = 2
```

### Output

```text
5
```

---

# Intuition

The first idea is to sort the array and return the kth largest element.

```text
3 2 1 5 6 4

↓

1 2 3 4 5 6

↓

2nd Largest = 5
```

This works, but sorting the entire array is unnecessary because we only need the **Top K** elements.

---

# Human Thinking

Imagine a school has **10,000 students**.

The principal asks:

> "Who are the Top 3 students?"

Would you rank all 10,000 students?

No.

You only maintain the **Top 3** while checking every student's marks.

Whenever a better student appears:

- Add them to the Top 3.
- Remove the weakest student.

This is exactly what a **Min Heap** does.

---

# Real World Example

### 🏆 YouTube Trending Videos

Millions of videos exist.

You only display:

```text
Top 10 Trending Videos
```

Whenever a new video becomes popular:

- Compare it with the current Top 10.
- If it deserves a place, remove the least popular video.
- Otherwise ignore it.

You never sort every video every second.

---

# Pattern Recognition

Whenever you see:

- Top K
- Kth Largest
- Kth Smallest
- Highest K
- Lowest K
- Best K

Think:

```text
Priority Queue (Heap)
```

---

# Why Min Heap?

Suppose:

```text
k = 3
```

Current Top 3 numbers:

```text
6
5
3
```

A new number arrives:

```text
4
```

Should 4 enter?

Yes.

Who should leave?

```text
3
```

The **smallest** among the Top 3.

A **Min Heap** always keeps the smallest element at the top, making it easy to remove.

---

# Algorithm

### Step 1

Create a Min Heap.

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
```

---

### Step 2

Visit every number.

---

### Step 3

Insert the current number into the heap.

---

### Step 4

If heap size becomes greater than `k`, remove the smallest element.

```java
if(minHeap.size() > k){
    minHeap.poll();
}
```

This ensures the heap always contains only the **Top K** largest numbers.

---

### Step 5

After processing every number:

The heap contains exactly the **Top K Largest Elements**.

The smallest among them is the answer.

Return:

```java
minHeap.peek();
```

---

# Code

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Maintain a Min Heap containing the K largest numbers seen so far
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Process each number
        for (int number : nums) {

            // Add current number to the heap
            minHeap.offer(number);

            // Remove the smallest number if heap size exceeds K
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The smallest element in the heap is the Kth largest element
        return minHeap.peek();
    }
}
```

---

# Dry Run

### Input

```text
nums = [3,2,1,5,6,4]
k = 2
```

| Number | Heap    | Action                             |
| ------ | ------- | ---------------------------------- |
| 3      | [3]     | Add                                |
| 2      | [2,3]   | Add                                |
| 1      | [1,2,3] | Remove 1                           |
| 5      | [2,3,5] | Remove 2                           |
| 6      | [3,5,6] | Remove 3                           |
| 4      | [4,6,5] | Remove 4? No, after adding [4,5,6] |

Final Heap:

```text
5
6
```

Answer:

```text
5
```

---

# Complexity

### Time Complexity

```text
O(n log k)
```

- Visit every element once → `O(n)`
- Heap insertion/removal → `O(log k)`

---

### Space Complexity

```text
O(k)
```

The heap stores at most `k` elements.

---

# Why Not Other Data Structures?

## Sorting

✅ Works

❌ Sorts the entire array unnecessarily.

Time:

```text
O(n log n)
```

---

## HashMap

❌ Not useful.

HashMap is for:

- Key → Value mapping
- Frequency counting
- Fast lookup

It cannot maintain the Top K elements.

---

## HashSet

❌ Not suitable.

Reasons:

- Removes duplicates
- No ordering
- Cannot determine kth largest

---

## Queue

❌ Not suitable.

Queue removes elements based on **arrival order (FIFO)**.

This problem requires removing the **smallest element**, not the oldest.

---

## Priority Queue (Min Heap)

✅ Best choice.

Reasons:

- Quickly removes the smallest element.
- Keeps only Top K elements.
- Efficient for streaming data.

---

# Google Interview Follow-up Questions

- Why did you choose a Min Heap instead of sorting?
- Why not use a Max Heap?
- Why is the heap size limited to K?
- Why does removing the smallest element work?
- How would you solve this using Quickselect?
- What if the array contains duplicates?
- What if the input is continuously arriving (stream)?

---

# Common Mistakes

❌ Using HashSet

❌ Comparing only adjacent elements

❌ Forgetting duplicates count

❌ Using `PriorityQueue` thinking it is a Max Heap

❌ Returning `poll()` before processing all elements

---

# Mental Recognition

```text
Question

↓

Top K ?

↓

Kth Largest ?

↓

Need only K numbers ?

↓

Don't sort everything

↓

Keep only Top K

↓

Priority Queue (Min Heap)
```

---

# Real Engineering Use Cases

- YouTube Top 10 Trending Videos
- Google Search Top Results
- Amazon Best Sellers
- Leaderboards
- Highest CPU Usage Servers
- Most Active Users
- Top Selling Products
- Recommendation Systems
- Top K Search Queries

---

# Key Takeaways

- Sorting is correct but not optimal.
- We only care about the Top K elements.
- A Min Heap efficiently maintains the Top K numbers.
- The heap size never exceeds K.
- The smallest element in the heap is the Kth largest number.
- Java's `PriorityQueue` is a Min Heap by default.

---

# Revision Summary

```text
Pattern
Heap (Priority Queue)

Recognition
Top K
Kth Largest
Kth Smallest

Data Structure
Min Heap

Algorithm

Create Min Heap
        ↓
Scan every number
        ↓
Insert into heap
        ↓
Heap size > K ?
        ↓
Remove smallest
        ↓
Heap contains Top K
        ↓
Return heap.peek()

Time Complexity
O(n log k)

Space Complexity
O(k)
```
