# 🚀 DSA Learning Journey (Google Interview Preparation)

> **Goal:** Master the most important Data Structures & Algorithms patterns by solving 35 carefully selected LeetCode problems. The focus is on understanding **patterns**, **strategies**, **problem-solving intuition**, and **interview thinking**, rather than memorizing solutions.

---

# 📖 About This Repository

This repository documents my journey of preparing for Software Engineering interviews at **Google** and other top product-based companies.

For every problem, I aim to understand:

* ✅ Intuition
* ✅ Brute Force Solution
* ✅ Optimal Solution
* ✅ Pattern Recognition
* ✅ Strategy Used
* ✅ Real-world Analogy
* ✅ Time & Space Complexity
* ✅ Java Implementation
* ✅ Line-by-Line Explanation
* ✅ Dry Run
* ✅ Interview Tips

The objective is to become a better problem solver, not just solve individual questions.

---

# 📊 Progress

| Completed | Remaining |  Total |
| :-------: | :-------: | :----: |
|  **17** ✅ |  **19** ⏳ | **35** |

```text
Progress

█████████████████□□□□□□□□

17 / 35 Problems Completed
```

---

# 🗺️ Pattern Roadmap

```text
Arrays & Hashing
        │
        ▼
Sliding Window
        │
        ▼
Two Pointers
        │
        ▼
Intervals
        │
        ▼
Design
        │
        ▼
Trees (DFS)
        │
        ▼
Graphs (BFS)
        │
        ▼
Heap
        │
        ▼
Binary Search
        │
        ▼
Dynamic Programming
        │
        ▼
Backtracking
        │
        ▼
Trie
        │
        ▼
Union Find (DSU)
        │
        ▼
Monotonic Stack
        │
        ▼
Shortest Path Algorithms
```

---

# 📚 Learning Journey

|  ✔  | Learning Order | Original # | LC # | Problem                                        | Pattern                     | Core Strategy                        |
| :-: | :------------: | :--------: | :--: | ---------------------------------------------- | --------------------------- | ------------------------------------ |
|  ✅  |        1       |      1     |   1  | Two Sum                                        | Arrays + HashMap            | Complement Lookup                    |
|  ✅  |        2       |     12     |  49  | Group Anagrams                                 | Hashing                     | Sort Characters → HashMap            |
|  ✅  |        3       |     16     |  347 | Top K Frequent Elements                        | Heap + Hashing              | Frequency Count + Bucket Sort        |
|  ✅  |        4       |     19     |  238 | Product of Array Except Self                   | Prefix & Suffix             | Prefix × Suffix Products             |
|  ✅  |        5       |      7     |   3  | Longest Substring Without Repeating Characters | Sliding Window              | Expand → Shrink Window               |
|  ✅  |        6       |     15     |  11  | Container With Most Water                      | Two Pointers                | Move Smaller Pointer                 |
|  ✅  |        7       |      8     |  42  | Trapping Rain Water                            | Two Pointers                | LeftMax & RightMax                   |
|  ✅  |        8       |      3     |  56  | Merge Intervals                                | Intervals + Sorting         | Sort → Merge                         |
|  ✅  |        9       |      4     |  146 | LRU Cache                                      | Design                      | HashMap + Doubly Linked List         |
|  ✅  |       10       |      5     |  98  | Validate Binary Search Tree                    | DFS                         | Valid Range (Min / Max)              |
|  ✅  |       11       |      6     |  210 | Course Schedule II                             | BFS + Topological Sort      | Kahn's Algorithm                     |
|  ✅  |       12       |      2     |  200 | Number of Islands                              | DFS + Graph                 | DFS Flood Fill                       |
|  ✅  |       13       |      9     |  297 | Serialize & Deserialize Binary Tree            | Trees + DFS                 | DFS Serialization                    |
|  ✅  |       14       |     10     |  215 | Kth Largest Element in an Array                | Heap                        | Min Heap / Quickselect               |
|  ✅  |       15       |     11     |   4  | Median of Two Sorted Arrays                    | Binary Search               | Partition Binary Search              |
|  ✅  |       16       |     13     |  127 | Word Ladder                                    | BFS                         | Level-by-Level BFS                   |
|  ✅  |       17       |     14     |  23  | Merge K Sorted Lists                           | Heap + Linked List          | Min Heap Merge                       |
|  ⏳  |       18       |     17     |  322 | Coin Change                                    | Dynamic Programming         | Bottom-Up DP                         |
|  ⏳  |       19       |     18     |  33  | Search in Rotated Sorted Array                 | Binary Search               | Find Sorted Half                     |
|  ⏳  |       20       |     20     |  102 | Binary Tree Level Order Traversal              | BFS (Tree)                  | Queue Level Traversal                |
|  ⏳  |       21       |     21     |  39  | Combination Sum                                | Backtracking                | Choose → Explore → Backtrack         |
|  ⏳  |       22       |     22     |  72  | Edit Distance                                  | Dynamic Programming         | DP State Transition                  |
|  ⏳  |       23       |     23     |  76  | Minimum Window Substring                       | Sliding Window              | Frequency Window                     |
|  ⏳  |       24       |     24     |  208 | Implement Trie                                 | Trie                        | Prefix Tree                          |
|  ⏳  |       25       |     25     |  721 | Accounts Merge                                 | Union Find (DSU)            | Union by Parent                      |
|  ⏳  |       26       |     26     |  239 | Sliding Window Maximum                         | Monotonic Queue             | Decreasing Deque                     |
|  ⏳  |       27       |     27     |  218 | Skyline Problem                                | Sweep Line + Heap           | Sweep Line                           |
|  ⏳  |       28       |     28     |  84  | Largest Rectangle in Histogram                 | Monotonic Stack             | Increasing Stack                     |
|  ⏳  |       29       |     29     |  212 | Word Search II                                 | Trie + DFS                  | Trie Backtracking                    |
|  ⏳  |       30       |     30     |  994 | Rotting Oranges                                | Multi-Source BFS            | BFS from All Sources                 |
|  ⏳  |       31       |     31     | 1192 | Critical Connections in a Network              | Tarjan's Algorithm          | Discovery Time + Low Link            |
|  ⏳  |       32       |     32     |  417 | Pacific Atlantic Water Flow                    | DFS / BFS                   | Reverse Traversal                    |
|  ⏳  |       33       |     33     |  743 | Network Delay Time                             | Dijkstra                    | Min Heap Shortest Path               |
|  ⏳  |       34       |     34     |  739 | Daily Temperatures                             | Monotonic Stack             | Next Greater Element                 |
|  ⏳  |       35       |     35     | 2812 | Find the Safest Path in a Grid                 | Multi-Source BFS + Dijkstra | Multi-Source BFS + Modified Dijkstra |

---

# 🧠 Pattern Recognition Cheatsheet

| If the problem mentions...      | Think About...               |
| ------------------------------- | ---------------------------- |
| Fast lookup                     | HashMap                      |
| Find complement                 | HashMap                      |
| Group similar items             | HashMap                      |
| Count frequency                 | HashMap + Bucket Sort / Heap |
| Continuous substring/subarray   | Sliding Window               |
| Start and end pointers          | Two Pointers                 |
| Overlapping intervals           | Sort + Merge                 |
| Tree traversal                  | DFS / BFS                    |
| Dependencies / Prerequisites    | Topological Sort             |
| K Largest / Smallest            | Heap                         |
| Sorted array search             | Binary Search                |
| Minimum operations              | Dynamic Programming          |
| Try all possibilities           | Backtracking                 |
| Prefix search                   | Trie                         |
| Merge connected components      | Union Find                   |
| Previous / Next Greater Element | Monotonic Stack              |
| Sliding window maximum          | Monotonic Queue              |
| Shortest path                   | Dijkstra                     |
| Critical edge / Bridge          | Tarjan's Algorithm           |

---

# 📁 Repository Structure

```text
DSA/
│
├── Arrays & Hashing/
├── Sliding Window/
├── Two Pointers/
├── Intervals/
├── Linked List/
├── Trees/
├── Graphs/
├── Heap/
├── Binary Search/
├── Dynamic Programming/
├── Backtracking/
├── Trie/
├── Union Find/
├── Monotonic Stack/
├── Shortest Path/
│
└── README.md
```

---

# 📌 Problem Template

Every problem in this repository follows the same structure:

* Problem Statement
* Intuition
* Brute Force Approach
* Optimal Approach
* Pattern Recognition
* Real-world Analogy
* Java Solution
* Line-by-Line Explanation
* Dry Run
* Time Complexity
* Space Complexity
* Interview Tips

---

# 🎯 End Goal

By completing these 35 problems, I aim to build strong intuition for the most common interview patterns and confidently solve unseen problems by recognizing the underlying strategy rather than relying on memorized solutions.

> **Learn the pattern. Understand the strategy. Solve any variation.**


# 🏆 Patterns Mastered

| Pattern | Status |
|---------|--------|
| Arrays | ✅ |
| HashMap | ✅ |
| Hashing | ✅ |
| Prefix & Suffix | ✅ |
| Sliding Window | ✅ |
| Two Pointers | ✅ |
| Intervals | ✅ |
| Linked List Design | ✅ |
| Tree DFS | ✅ |
| Graph BFS / Topological Sort | ✅ |
| Heap (Priority Queue) | ✅ |
| Binary Search | ✅  |
| Dynamic Programming | ⏳ |
| Trie | ⏳ |
| Backtracking | ⏳ |
| Union Find | ⏳ |
| Monotonic Stack | ⏳ |
| Dijkstra | ⏳ |
