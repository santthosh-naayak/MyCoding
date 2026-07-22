# 🏝️ Number of Islands (LeetCode 200)

> **Pattern:** Graph + DFS (Flood Fill)  
> **Difficulty:** Medium  
> **Language:** Java

---

# 📌 Problem Statement

Given a 2D grid of `'1'` (Land) and `'0'` (Water), return the number of islands.

An island is formed by connecting adjacent lands **horizontally or vertically**.

---

# 🧠 Intuition

Whenever you find a new piece of land (`'1'`), you've discovered a **new island**.

Now explore all connected land cells and mark them as visited so they aren't counted again.

Repeat until every cell has been visited.

---

# 💡 Real World Analogy

Imagine a satellite image of Earth.

- 🟩 Land = Island
- 🟦 Water = Ocean

When a helicopter lands on one island, it can walk to every connected land.

After surveying the entire island, it moves to find another unvisited island.

---

# 🔍 Brute Force

For every land cell:

- Search the entire grid repeatedly.
- Count connected land every time.

❌ Lots of repeated work.

---

# ⚡ Optimal Idea

Visit every cell only once.

Whenever you find an unvisited land:

1. Increase island count.
2. Visit every connected land using DFS.
3. Mark visited land as water (`'0'`).

---

# 🌐 Grid → Graph

Think of the grid as a graph.

```text
Grid

1 1 0
0 1 0
1 0 1

↓

Graph

Each Cell = Node

Adjacent Cells = Edge
```

---

# 📍 Why DFS?

DFS explores one complete island before moving to the next.

```text
Found Land

↓

Go Deep

↓

Visit Connected Cells

↓

Return

↓

Continue Searching
```

---

# 🔄 Algorithm

```
Traverse entire grid

If cell == '1'

    Island++

    DFS(row, col)

Return Island Count
```

---

# ☕ Java Solution

```java
class Solution {

    public int numIslands(char[][] grid) {

        int islands = 0;

        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1') {

                    islands++;

                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == '0') {

            return;
        }

        grid[row][col] = '0';

        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }
}
```

---

# 🧪 Dry Run

```text
Grid

1 1 0
0 1 0
1 0 1
```

Start scanning

```
(0,0)

Island = 1

DFS visits

(0,0)
(0,1)
(1,1)

Mark all as 0
```

Grid becomes

```text
0 0 0
0 0 0
1 0 1
```

Continue scanning

```
Find (2,0)

Island = 2

DFS
```

Continue

```
Find (2,2)

Island = 3
```

Answer

```
3 Islands
```

---

# ⏱️ Complexity

**Time**

```
O(R × C)
```

Every cell is visited once.

**Space**

```
O(R × C)
```

Worst case recursion stack.

---

# 🧠 Pattern Recognition

Whenever you see:

- Island
- Connected Region
- Cluster
- Flood Fill
- Maze
- Grid
- Adjacent Cells

Think immediately:

```text
GRID

↓

GRAPH

↓

DFS / BFS

↓

VISITED
```

---

# ⚠️ Common Mistakes

❌ Forgetting to mark visited cells.

❌ Visiting diagonal cells.

❌ Counting every land cell instead of every island.

❌ Missing boundary checks.

---

# 🎯 Interview Tips

The interviewer wants to hear:

- Grid can be treated as a graph.
- Every cell is a node.
- Adjacent land cells are connected.
- DFS explores one complete island.
- Mark visited cells to avoid duplicate counting.
- Visit each cell only once.

---

# 🌍 Real World Applications

- Google Maps (Connected Regions)
- Image Processing (Flood Fill)
- Medical Image Segmentation
- Forest Fire Simulation
- Social Network Connected Groups
- Computer Vision

---

# 🔗 Similar Problems

- Max Area of Island
- Surrounded Regions
- Rotting Oranges
- Pacific Atlantic Water Flow
- Number of Provinces
- Word Search
- Find the Safest Path in a Grid

---

# 📝 Revision Notes

✔ Grid → Graph

✔ Cell → Node

✔ Adjacent Cells → Edge

✔ Connected Land → Island

✔ DFS explores one island completely

✔ Mark visited to avoid recounting

✔ Count only the first land cell of each island

✔ Time Complexity → O(R × C)

---

# 🚀 Key Takeaways

- Treat every grid problem as a graph problem.
- Count islands only when you first discover unvisited land.
- DFS/BFS visits every connected land cell.
- Mark visited cells immediately.
- Every cell is processed only once.
- Pattern to remember:

```text
Grid
   ↓
Graph
   ↓
DFS / BFS
   ↓
Visited
   ↓
Count Components
```

> **Mental Rule:**  
> **If the problem mentions Grid + Connected Cells + Islands/Regions → Think Graph + DFS/BFS.**