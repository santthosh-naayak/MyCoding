# Course Schedule II

## Problem #6 — Course Schedule II

**Difficulty:** Medium
**Category:** Graph / Topological Sort
**Pattern:** BFS + Topological Sort
**Algorithm:** Kahn’s Algorithm
**Main Data Structures:** Adjacency List, Indegree Array, Queue

---

# Problem

There are `numCourses` Courses labeled from:

```text
0 to numCourses - 1
```

You are given a `prerequisites` array where:

```text
prerequisites[i] = [course, prerequisite]
```

This means the prerequisite Course must be completed before taking the Course.

For example:

```text
[1, 0]
```

means:

```text
Complete Course 0 first

        ↓

Then take Course 1
```

As a Directed Graph:

```text
0 → 1
```

The goal is to return a valid order in which all Courses can be completed.

If multiple valid orders exist, return any one of them.

If completing all Courses is impossible because of a Cycle, return an empty array.

---

# Example

```text
Input:

numCourses = 4

prerequisites = [
    [1, 0],
    [2, 0],
    [3, 1],
    [3, 2]
]
```

The prerequisite relationships are:

```text
0 → 1

0 → 2

1 → 3

2 → 3
```

Graph:

```text
        0
       / \
      ↓   ↓
      1   2
       \ /
        ↓
        3
```

Valid answers include:

```text
[0, 1, 2, 3]
```

or:

```text
[0, 2, 1, 3]
```

Both are correct because Course `0` comes before Courses `1` and `2`, and both Courses `1` and `2` come before Course `3`.

---

# What Are We Trying to Return?

We need to return:

> A valid ordering where every prerequisite Course appears before the Course that depends on it.

For example:

```text
0 → 1
```

means:

```text
Course 0 must appear before Course 1
```

This type of dependency ordering problem is solved using:

```text
TOPOLOGICAL SORT
```

---

# Pattern Recognition

The main clues are:

```text
Courses

+

Prerequisites

+

Dependencies

+

Return a Valid Order
```

These clues should make us think:

```text
DIRECTED GRAPH

        ↓

TOPOLOGICAL SORT
```

The specific technique used is:

```text
KAHN'S ALGORITHM

=

BFS + QUEUE + INDEGREE
```

---

# Real-World Example

Imagine a software project:

```text
Task 0 = Create Database

Task 1 = Create Backend

Task 2 = Create Data Service

Task 3 = Launch Application
```

Dependencies:

```text
Database → Backend

Database → Data Service

Backend → Launch

Data Service → Launch
```

Graph:

```text
        Database
        /      \
       ↓        ↓
   Backend   Data Service
       \        /
        ↓      ↓
         Launch
```

We cannot launch the application before completing the Backend and Data Service.

Similarly, Course Schedule II requires us to complete prerequisite Courses before dependent Courses.

---

# Step 1: Convert the Problem Into a Graph

Each Course becomes a:

```text
NODE
```

Each prerequisite relationship becomes a:

```text
DIRECTED EDGE
```

For:

```text
[1, 0]
```

the format is:

```text
[course, prerequisite]
```

Therefore:

```text
course = 1

prerequisite = 0
```

The Graph direction is:

```text
prerequisite → course
```

Therefore:

```text
0 → 1
```

### Memory Rule

```text
[course, prerequisite]

        ↓

prerequisite → course
```

---

# What Is a Directed Graph?

A Directed Graph contains connections that have a specific direction.

For example:

```text
0 → 1
```

means Course `0` leads to Course `1`.

It does not automatically mean:

```text
1 → 0
```

Course Schedule uses a Directed Graph because prerequisite relationships have a specific order.

---

# Understanding `int[][] prerequisites`

Suppose:

```java
int[][] prerequisites = {
    {1, 0},
    {2, 0},
    {3, 1},
    {3, 2}
};
```

Conceptually:

```text
[
    [1, 0],
    [2, 0],
    [3, 1],
    [3, 2]
]
```

The complete variable:

```java
int[][] prerequisites
```

means:

```text
Array of int[] Arrays
```

Therefore:

```java
prerequisites[0]
```

returns:

```text
[1, 0]
```

which is an:

```java
int[]
```

### Memory Rule

```text
int[][]

↓

Array containing Arrays


int[]

↓

One Array


int

↓

One Value
```

---

# Reading Every Prerequisite

We use:

```java
for (int[] prerequisite : prerequisites)
```

Suppose:

```text
prerequisites = [
    [1, 0],
    [2, 0],
    [3, 1],
    [3, 2]
]
```

The loop gives us:

```text
First  → [1, 0]

Second → [2, 0]

Third  → [3, 1]

Fourth → [3, 2]
```

Therefore:

```java
for (int[] prerequisite : prerequisites)
```

means:

> Give me every prerequisite relationship one at a time.

---

# What Is an Adjacency List?

An Adjacency List stores:

> For each Node, which other Nodes are directly connected to it?

For this Graph:

```text
        0
       / \
      ↓   ↓
      1   2
       \ /
        ↓
        3
```

the Adjacency List is:

```text
0 → [1, 2]

1 → [3]

2 → [3]

3 → []
```

For Course Schedule:

> The Adjacency List stores which Courses depend on each Course.

### Memory Rule

```text
graph

↓

WHO DEPENDS ON ME?
```

---

# Why Do We Use `List<List<Integer>>`?

Start from the inside:

```text
Integer

↓

One Course
```

```text
List<Integer>

↓

Neighbors of One Course
```

```text
List<List<Integer>>

↓

Neighbor Lists of Every Course
```

Example:

```text
[
    [1, 2],
    [3],
    [3],
    []
]
```

---

# Creating the Empty Graph

We create:

```java
List<List<Integer>> graph = new ArrayList<>();
```

Initially:

```text
graph = []
```

Suppose:

```text
numCourses = 4
```

We create one empty List for every Course:

```java
for (int course = 0; course < numCourses; course++) {
    graph.add(new ArrayList<>());
}
```

Now:

```text
graph = [
    [],
    [],
    [],
    []
]
```

The indexes represent Courses:

```text
Index 0 → Course 0

Index 1 → Course 1

Index 2 → Course 2

Index 3 → Course 3
```

---

# Understanding `graph.get(prerequisiteCourse).add(course)`

Suppose:

```text
prerequisite = [1, 0]
```

Then:

```text
course = 1

prerequisiteCourse = 0
```

The code:

```java
graph.get(prerequisiteCourse).add(course);
```

becomes:

```java
graph.get(0).add(1);
```

First:

```java
graph.get(0)
```

means:

```text
Go to the inner List at index 0
```

Initially:

```text
graph = [
    [],
    [],
    [],
    []
]
```

Therefore:

```java
graph.get(0)
```

returns:

```text
[]
```

Then:

```java
.add(1)
```

adds Course `1` into that List.

The Graph becomes:

```text
[
    [1],
    [],
    [],
    []
]
```

After processing all prerequisites:

```text
[
    [1, 2],
    [3],
    [3],
    []
]
```

### Memory Rule

```text
graph.get(prerequisiteCourse).add(course)

↓

Go to the prerequisite Course's List

↓

Add the Course that depends on it
```

---

# What Is Indegree?

Indegree means:

> The number of incoming Edges to a Node.

For Course Schedule, think:

> How many prerequisites is this Course still waiting for?

For our example:

```text
Course 0 → Indegree 0

Course 1 → Indegree 1

Course 2 → Indegree 1

Course 3 → Indegree 2
```

Therefore:

```text
indegree = [0, 1, 1, 2]
```

### Memory Rule

```text
indegree

↓

HOW MANY PREREQUISITES
AM I STILL WAITING FOR?
```

---

# Creating the Indegree Array

```java
int[] indegree = new int[numCourses];
```

Suppose:

```text
numCourses = 4
```

Java automatically creates:

```text
[0, 0, 0, 0]
```

Every element of a newly created Java `int[]` has the default value `0`.

---

# Calculating Indegree

We use:

```java
indegree[course]++;
```

Suppose:

```text
[1, 0]
```

Then:

```text
course = 1
```

Therefore:

```java
indegree[1]++;
```

Before:

```text
[0, 0, 0, 0]
```

After:

```text
[0, 1, 0, 0]
```

After processing all prerequisites:

```text
[0, 1, 1, 2]
```

---

# Graph vs Indegree

The Graph answers:

```text
WHO DEPENDS ON ME?
```

Example:

```text
graph.get(0)

↓

[1, 2]
```

Courses `1` and `2` depend on Course `0`.

The Indegree array answers:

```text
HOW MANY PREREQUISITES
AM I WAITING FOR?
```

Example:

```text
indegree[3] = 2
```

Course `3` is waiting for two prerequisites.

---

# What Is BFS?

**BFS means Breadth-First Search.**

BFS is a technique used to process Nodes in a Graph or Tree.

The simple idea is:

> Process what is available now, then process what becomes available next.

BFS mainly uses a:

```text
QUEUE
```

because a Queue follows:

```text
FIFO

First In → First Out
```

The basic BFS flow is:

```text
Add Starting Node to Queue

        ↓

While Queue Is Not Empty

        ↓

Remove One Node

        ↓

Process It

        ↓

Visit Its Neighbors

        ↓

Add Eligible Neighbors to Queue

        ↓

Repeat
```

### Simple BFS Code Pattern

```java
Queue<Integer> queue = new LinkedList<>();

queue.offer(start);

while (!queue.isEmpty()) {

    int current = queue.poll();

    for (int neighbor : graph.get(current)) {

        if (neighborIsEligible) {
            queue.offer(neighbor);
        }
    }
}
```

### Memory Rule

```text
BFS

=

QUEUE

+

PROCESS CURRENT NODE

+

VISIT NEIGHBORS

+

ADD ELIGIBLE NEIGHBORS

+

REPEAT
```

---

# How Is BFS Used in Course Schedule II?

Normal BFS starts with a starting Node.

Course Schedule BFS starts with:

```text
ALL COURSES WITH INDEGREE 0
```

Why?

Because:

```text
Indegree 0

↓

No Remaining Prerequisites

↓

Course Is Ready
```

The Course Schedule BFS flow is:

```text
Find Indegree-0 Courses

        ↓

Add Them to Queue

        ↓

Remove One Ready Course

        ↓

Save It in Result

        ↓

Visit Courses That Depend on It

        ↓

Decrease Their Indegree

        ↓

Did Any Indegree Become 0?

        ↓

Add Those Courses to Queue

        ↓

Repeat
```

### Normal BFS vs Course Schedule BFS

```text
NORMAL BFS

Start with Node

↓

Queue

↓

Remove Node

↓

Visit Neighbors

↓

Add Unvisited Neighbors

↓

Repeat
```

```text
COURSE SCHEDULE BFS

Start with Indegree-0 Courses

↓

Queue

↓

Remove Ready Course

↓

Visit Dependent Courses

↓

Decrease Their Indegree

↓

Add Newly Ready Courses

↓

Repeat
```

### Most Important Difference

> Normal BFS often adds unvisited Neighbors to the Queue.

> Kahn’s Algorithm adds a Neighbor only when its Indegree becomes `0`.

---

# What Is Topological Sort?

Topological Sort is:

> An ordering of Nodes where every dependency appears before the Node that depends on it.

Suppose:

```text
A → B
```

Then `A` must appear before `B`.

For Course Schedule:

```text
0 → 1
```

Course `0` must appear before Course `1`.

For:

```text
        0
       / \
      ↓   ↓
      1   2
       \ /
        ↓
        3
```

Valid Topological Orders include:

```text
[0, 1, 2, 3]
```

and:

```text
[0, 2, 1, 3]
```

There can be multiple valid answers.

---

# What Is Kahn's Algorithm?

Kahn’s Algorithm performs Topological Sort using:

```text
BFS

+

QUEUE

+

INDEGREE
```

The strategy is:

```text
Find Courses With Indegree 0

        ↓

Add Them to Queue

        ↓

Process One Course

        ↓

Save It in Result

        ↓

Check Dependent Courses

        ↓

Reduce Their Indegree

        ↓

Did Any Indegree Become 0?

        ↓

Add That Course to Queue

        ↓

Repeat
```

---

# Why Do We Use a Queue?

The Queue stores:

> Courses that are currently ready to be processed.

Initially:

```text
queue = [0]
```

After completing Course `0`:

```text
queue = [1, 2]
```

After processing Course `1`:

```text
queue = [2]
```

After processing Course `2`:

```text
queue = [3]
```

### Memory Rule

```text
Queue

↓

WHICH COURSES
ARE READY RIGHT NOW?
```

---

# Creating the Queue

```java
Queue<Integer> queue = new LinkedList<>();
```

Initially:

```text
queue = []
```

We check every Course:

```java
for (int course = 0; course < numCourses; course++) {

    if (indegree[course] == 0) {
        queue.offer(course);
    }
}
```

Given:

```text
indegree = [0, 1, 1, 2]
```

only Course `0` has Indegree `0`.

Therefore:

```text
queue = [0]
```

---

# Queue Operations

Add to Queue:

```java
queue.offer(course);
```

Remove from Queue:

```java
queue.poll();
```

### Memory Rule

```text
offer()

↓

ADD
```

```text
poll()

↓

REMOVE
```

---

# Creating the Result Array

```java
int[] order = new int[numCourses];
```

For four Courses:

```text
order = [_, _, _, _]
```

This stores the final Topological Order.

---

# Why Do We Need `index`?

```java
int index = 0;
```

The `index` tells us:

```text
Where should the next Course be stored?
```

and:

```text
How many Courses have been processed?
```

Therefore:

```text
index == numCourses
```

means:

```text
ALL COURSES WERE PROCESSED
```

---

# Starting BFS

```java
while (!queue.isEmpty())
```

means:

> Continue processing while ready Courses exist.

---

# Removing the Current Course

```java
int currentCourse = queue.poll();
```

Suppose:

```text
queue = [0]
```

Then:

```text
currentCourse = 0
```

Human meaning:

> Take one ready Course and process it.

---

# Saving the Course

```java
order[index] = currentCourse;
index++;
```

Suppose:

```text
currentCourse = 0

index = 0
```

Then:

```text
order = [0, _, _, _]

index = 1
```

---

# Visiting the Neighbors

```java
for (int neighbor : graph.get(currentCourse))
```

Suppose:

```text
currentCourse = 0
```

Then:

```java
graph.get(0)
```

returns:

```text
[1, 2]
```

Human meaning:

> Check every Course that depends on the Course we just completed.

---

# Why Do We Decrease Indegree?

```java
indegree[neighbor]--;
```

Suppose:

```text
0 → 1
```

Course `1` initially has:

```text
indegree[1] = 1
```

After completing Course `0`:

```text
1 → 0
```

Human meaning:

> One prerequisite of Course `1` has now been completed.

### Memory Rule

```text
indegree[neighbor]--

↓

ONE PREREQUISITE
HAS BEEN COMPLETED
```

---

# When Do We Add a Neighbor to the Queue?

```java
if (indegree[neighbor] == 0) {
    queue.offer(neighbor);
}
```

If:

```text
indegree = 0
```

then:

```text
No Prerequisites Remain

↓

Course Is Ready

↓

Add to Queue
```

---

# Complete Dry Run

Initial state:

```text
graph = [
    [1, 2],
    [3],
    [3],
    []
]

indegree = [0, 1, 1, 2]

queue = [0]

order = [_, _, _, _]

index = 0
```

## Process Course 0

```text
Poll 0

↓

order = [0, _, _, _]

↓

index = 1

↓

Neighbors = [1, 2]

↓

indegree[1]: 1 → 0

↓

Add 1 to Queue

↓

indegree[2]: 1 → 0

↓

Add 2 to Queue
```

Current state:

```text
queue = [1, 2]

order = [0, _, _, _]

indegree = [0, 0, 0, 2]
```

## Process Course 1

```text
Poll 1

↓

order = [0, 1, _, _]

↓

index = 2

↓

Neighbor = 3

↓

indegree[3]: 2 → 1
```

Course `3` is not ready yet.

## Process Course 2

```text
Poll 2

↓

order = [0, 1, 2, _]

↓

index = 3

↓

Neighbor = 3

↓

indegree[3]: 1 → 0

↓

Add 3 to Queue
```

## Process Course 3

```text
Poll 3

↓

order = [0, 1, 2, 3]

↓

index = 4
```

Queue becomes empty.

BFS ends.

---

# Cycle Detection

After BFS:

```java
if (index == numCourses) {
    return order;
}
```

If:

```text
index == numCourses
```

then all Courses were successfully processed.

Otherwise:

```text
Some Courses Could Not Be Processed

↓

Cycle Exists
```

Return:

```java
return new int[] {};
```

---

# Why Does a Cycle Cause Failure?

Consider:

```text
0 → 1

1 → 0
```

Course `0` waits for Course `1`.

Course `1` waits for Course `0`.

Indegree:

```text
[1, 1]
```

There is no Course with:

```text
indegree = 0
```

Therefore:

```text
queue = []
```

BFS cannot process all Courses.

So:

```text
index != numCourses
```

and we return:

```text
[]
```

---

# Optimal Java Solution

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Store the courses that become available after completing each prerequisite course
        List<List<Integer>> graph = new ArrayList<>();

        // Create an empty neighbor list for every course
        for (int course = 0; course < numCourses; course++) {
            graph.add(new ArrayList<>());
        }

        // Track how many prerequisites each course is still waiting for
        int[] indegree = new int[numCourses];

        // Build the directed graph and count the prerequisites of each course
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            // Connect the prerequisite course to the course that depends on it
            graph.get(prerequisiteCourse).add(course);

            // Count one more prerequisite for the dependent course
            indegree[course]++;
        }

        // Store the final valid course completion order
        int[] order = new int[numCourses];

        // Track the next result position and number of processed courses
        int index = 0;

        // Store all courses that are currently ready to be completed
        Queue<Integer> queue = new LinkedList<>();

        // Add every course with no remaining prerequisites to the queue
        for (int course = 0; course < numCourses; course++) {

            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        // Process all ready courses using BFS
        while (!queue.isEmpty()) {

            // Remove the next course with no remaining prerequisites
            int currentCourse = queue.poll();

            // Add the completed course to the final topological order
            order[index] = currentCourse;

            // Move to the next result position and count the processed course
            index++;

            // Check every course that depends on the completed course
            for (int neighbor : graph.get(currentCourse)) {

                // Mark one prerequisite of the dependent course as completed
                indegree[neighbor]--;

                // Add the course when all of its prerequisites are completed
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Return the order only if every course was successfully processed
        if (index == numCourses) {
            return order;
        }

        // Return an empty array when a cycle prevents course completion
        return new int[] {};
    }
}
```

---

# Time Complexity

Let:

```text
V = Number of Courses

E = Number of Prerequisite Relationships
```

Every Course is processed once.

Every prerequisite relationship is processed once.

Therefore:

```text
Time Complexity = O(V + E)
```

For this problem:

```text
O(numCourses + prerequisites.length)
```

---

# Space Complexity

We use:

```text
Adjacency List

+

Indegree Array

+

Queue

+

Result Array
```

Therefore:

```text
Space Complexity = O(V + E)
```

---

# Pattern Recognition

Think of this pattern when the problem contains:

```text
Dependencies

Prerequisites

Task Ordering

Course Ordering

Build Ordering

Job Scheduling

Compilation Dependencies

Package Dependencies
```

The recognition flow is:

```text
DEPENDENCIES

        ↓

DIRECTED GRAPH

        ↓

NEED VALID ORDER?

        ↓

TOPOLOGICAL SORT

        ↓

BFS APPROACH?

        ↓

KAHN'S ALGORITHM

        ↓

ADJACENCY LIST + INDEGREE + QUEUE
```

---

# Complete Algorithm Flow

```text
COURSES + PREREQUISITES

        ↓

BUILD DIRECTED GRAPH

        ↓

CREATE ADJACENCY LIST

        ↓

CALCULATE INDEGREE

        ↓

FIND INDEGREE-0 COURSES

        ↓

ADD THEM TO QUEUE

        ↓

START BFS

        ↓

POLL ONE READY COURSE

        ↓

SAVE IT IN RESULT

        ↓

GET ITS NEIGHBORS

        ↓

DECREASE NEIGHBOR INDEGREE

        ↓

DID INDEGREE BECOME 0?

        ↓

YES → ADD TO QUEUE

        ↓

REPEAT BFS

        ↓

QUEUE EMPTY

        ↓

DID WE PROCESS ALL COURSES?

        ↓

YES → RETURN ORDER

NO → CYCLE EXISTS → RETURN []
```

---

# Quick Revision

```text
Pattern:

BFS + Topological Sort
```

```text
Algorithm:

Kahn's Algorithm
```

```text
BFS:

Use a Queue to process what is available now,
then process what becomes available next
```

```text
Graph:

Who depends on me?
```

```text
Indegree:

How many prerequisites am I waiting for?
```

```text
Indegree 0:

Course is ready
```

```text
Queue:

Which Courses are ready right now?
```

```text
indegree[neighbor]--:

One prerequisite has been completed
```

```text
index == numCourses:

All Courses were processed
```

```text
index < numCourses:

A Cycle exists
```

---

# Final 6-Line Summary

1. Use **Topological Sort with BFS (Kahn’s Algorithm)** because Courses have dependencies and we need a valid ordering.
2. Build an **Adjacency List** to store which Courses depend on each Course.
3. Build an **Indegree array** to count how many prerequisites each Course is still waiting for.
4. Add all Courses with `indegree = 0` to a **Queue** because BFS processes Courses that are currently ready.
5. Process one Course at a time, decrease the Indegree of its dependent Courses, and add newly ready Courses to the Queue.
6. Return the order if all Courses were processed; otherwise return an empty array because a **Cycle exists**.

# One-Line Memory Rule

> **Build who depends on whom → count what each Course is waiting for → Queue all ready Courses → BFS to process and unlock more Courses → return the order if everyone was processed.**
