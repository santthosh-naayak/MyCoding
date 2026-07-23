# 📘 README – Word Ladder

## Difficulty

**Hard**

---

# 🎯 Pattern Used

* Graph
* Breadth First Search (BFS)
* Shortest Path in an Unweighted Graph
* String Manipulation
* Hashing

---

# 🏗 Data Structures Used

* **Queue** → Perform Breadth First Search level by level.
* **HashSet** → Fast lookup and removal of dictionary words.
* **Character Array (`char[]`)** → Efficiently modify one character at a time.
* **String** → Represents each word as a graph node.

---

# ⚙️ Algorithms Used

### Breadth First Search (BFS)

Used to find the **shortest transformation sequence**.

---

### Graph Traversal

Every valid word is treated as a graph node.

Changing one letter creates an edge between two words.

---

### Hashing

HashSet provides:

* O(1) search
* O(1) removal

which makes BFS efficient.

---

# 🎯 Goal

Find the **minimum number of transformations** required to convert:

```text
beginWord

↓

endWord
```

where:

* Only one character can change at a time.
* Every intermediate word must exist in the dictionary.

---

# 🌍 Real World Problem

Imagine GPS navigation.

You are in:

```text
Home
```

Need to reach:

```text
Office
```

Roads connect locations.

GPS always chooses the **shortest route**.

Word Ladder is exactly the same problem.

Instead of cities...

We have words.

Instead of roads...

Changing one letter creates a connection.

---

# ☁ Google / Real Product Example

Suppose Google Search receives a misspelled query.

```text
googel
```

↓

```text
google
```

or

```text
aplpe

↓

apple
```

Google explores nearby valid words until it finds the intended word.

This is conceptually similar to traversing a graph of words.

---

# 🧠 Core Idea

Treat every word as a graph node.

Example:

```text
hit

↓

hot

↓

dot

↓

dog

↓

cog
```

Every one-letter transformation becomes an edge.

Now the problem becomes:

```text
Find the shortest path in an unweighted graph.
```

The best algorithm for this is:

```text
Breadth First Search (BFS)
```

---

# 💻 Computer Thinking

Computer does not see:

```text
Words
```

Computer sees:

```text
Nodes

↓

Edges

↓

Graph

↓

Shortest Path
```

---

# 👨 Human Thinking

Humans think:

```text
Change one letter.

↓

See if it becomes a valid word.

↓

Repeat until destination.
```

Computer thinks:

```text
Current Word

↓

Generate all neighbors

↓

Visit each once

↓

Repeat level by level
```

---

# 🚀 Algorithm

### Step 1

Store every dictionary word inside a HashSet.

```text
Fast lookup

↓

Fast removal
```

---

### Step 2

Start BFS from:

```text
beginWord
```

---

### Step 3

Remove one word from the queue.

---

### Step 4

Try changing every character.

```text
hit

↓

ait

bit

cit

...

zit
```

---

### Step 5

If the new word exists in the dictionary:

* Add it to the queue.
* Remove it from the dictionary.

Removing immediately marks it as visited.

---

### Step 6

If

```text
newWord == endWord
```

return

```text
level + 1
```

because we've found the shortest path.

---

# 🔄 Algorithm Flow

```text
Begin Word

↓

Queue

↓

Take Current Word

↓

Change One Letter

↓

Valid Dictionary Word?

↓

Yes

↓

Add to Queue

↓

Remove from Dictionary

↓

Continue BFS

↓

Found End Word

↓

Return Level
```

---

# 🧠 Mental Recognition

Whenever you hear:

* Word Transformation
* Dictionary
* One Letter Change
* Minimum Steps
* Shortest Sequence
* Fewest Operations

Immediately think:

```text
Words

↓

Graph

↓

Shortest Path

↓

BFS

↓

Queue

↓

HashSet
```

---

# ❓Why BFS?

Because every transformation has the same cost.

```text
One Letter Change

=

One Step
```

Whenever every edge has equal weight,

BFS always finds the shortest path.

---

# ❓Why Queue?

Queue processes words:

```text
First In

↓

First Out
```

which naturally explores:

```text
Level 1

↓

Level 2

↓

Level 3
```

The first time we reach the destination,

it is guaranteed to be the shortest path.

---

# ❓Why HashSet?

Without HashSet

Searching:

```text
O(n)
```

With HashSet

Searching:

```text
O(1)
```

Removing visited words also becomes:

```text
O(1)
```

---

# ❓Why Remove Words Immediately?

Suppose

```text
hot
```

is visited.

If we don't remove it,

another word may discover it again.

Result:

```text
Duplicate processing

↓

Infinite loops

↓

Slower BFS
```

Removing immediately marks it as visited.

---

# 📊 Complexity

### Time Complexity

```text
O(N × L × 26)
```

Where:

* **N** = Number of words
* **L** = Length of each word
* **26** = Every lowercase English letter

---

### Space Complexity

```text
O(N)
```

Used by:

* HashSet
* Queue

---

# 💼 Google Interview Explanation (30 Seconds)

> Every word is treated as a graph node. Two words are connected if they differ by exactly one character. Since every transformation has equal cost, BFS guarantees the shortest transformation sequence. A HashSet provides constant-time lookup and also acts as the visited set by removing words once they are explored.

---

# ⭐ 10 Things to Remember

1. Think of words as graph nodes.
2. One letter change creates an edge.
3. Need minimum transformations.
4. Equal edge weight means BFS.
5. Queue performs level-order traversal.
6. HashSet provides O(1) lookup.
7. Remove words immediately after visiting.
8. Each BFS level represents one transformation.
9. First time reaching the end word is the shortest path.
10. Character array allows efficient letter replacement.

---

# 🧠 Mental Recognition Checklist

✅ Words

↓

✅ Dictionary

↓

✅ One Character Change

↓

✅ Minimum Steps

↓

✅ Graph

↓

✅ BFS

↓

✅ Queue

↓

✅ HashSet

---

# 🌟 One-Line Memory Trick

```text
Words

↓

Graph

↓

BFS

↓

Queue

↓

HashSet

↓

Shortest Transformation
```

---

# 🔗 Related Problems

* Number of Islands (Graph Traversal)
* Course Schedule II (Topological Graph)
* Clone Graph
* Open the Lock
* Minimum Genetic Mutation
* Bus Routes
* Shortest Path in Binary Matrix

---

# 🎯 Why Google Uses This Pattern

Google products frequently search for the shortest path through connected data.

Examples:

* Search query correction
* Spell checking
* Auto-complete
* Knowledge graph traversal
* Network routing
* Service dependency graphs

Understanding BFS on implicit graphs is an important interview pattern because the graph is often **not explicitly given**—you generate neighbors on the fly, just like this problem.

---

# 📝 Revision Summary

```text
Words

↓

Graph

↓

One Letter Difference

↓

Shortest Path

↓

BFS

↓

Queue

↓

HashSet

↓

Visited by Removal

↓

Shortest Transformation Sequence
```
