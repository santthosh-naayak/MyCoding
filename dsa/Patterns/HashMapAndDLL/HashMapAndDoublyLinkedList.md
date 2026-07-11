# Problem #4: LRU Cache

**Difficulty:** Medium
**Category:** Design / Linked List
**Pattern:** HashMap + Doubly Linked List
**Primary Strategy:** Combine Fast Lookup + Fast Order Management
**Time Complexity:** `O(1)` average for `get()` and `put()`
**Space Complexity:** `O(capacity)`

---

# Problem Statement

Design a data structure that follows the **Least Recently Used (LRU)** cache policy.

The cache has a fixed capacity and supports two operations:

```java
get(key)
```

and:

```java
put(key, value)
```

The required average time complexity is:

```text
get() → O(1)

put() → O(1)
```

When the cache exceeds its capacity, remove the **Least Recently Used** item.

---

# 1. What is a Cache?

A cache is a small, fast storage area used to keep frequently or recently accessed data.

Without a cache:

```text
REQUEST DATA

      ↓

GO TO SLOWER STORAGE

      ↓

LOAD DATA

      ↓

RETURN DATA
```

With a cache:

```text
REQUEST DATA

      ↓

IS DATA IN CACHE?

    /             \

  YES              NO

   ↓                ↓

RETURN FAST      LOAD FROM
                 SLOW STORAGE

                     ↓

                STORE IN CACHE

                     ↓

                  RETURN
```

The important point is:

```text
CACHE

↓

FAST STORAGE

BUT

LIMITED CAPACITY
```

Because the capacity is limited, we need a rule to decide what to remove.

That rule is called an:

```text
EVICTION POLICY
```

LRU is one such eviction policy.

---

# 2. What Does LRU Mean?

LRU means:

```text
Least Recently Used
```

It means:

> Remove the item that has not been accessed for the longest time.

Suppose:

```text
LRU                         MRU

A        ↔        B        ↔        C
```

Here:

```text
A = Least Recently Used

C = Most Recently Used
```

If the cache is full and we insert:

```text
D
```

remove:

```text
A
```

Result:

```text
LRU                         MRU

B        ↔        C        ↔        D
```

---

# 3. Important LRU Rule

LRU does not mean:

```text
Remove Smallest Value
```

It does not mean:

```text
Remove Largest Value
```

It also does not necessarily mean:

```text
Remove First Inserted Value
```

It means:

```text
REMOVE THE ITEM

THAT HAS NOT BEEN ACCESSED

FOR THE LONGEST TIME
```

---

# 4. Accessing an Item Changes Its Position

Suppose:

```text
LRU                         MRU

A        ↔        B        ↔        C
```

Now access:

```text
A
```

Because `A` was just used, it becomes MRU.

Before:

```text
A ↔ B ↔ C

↑       ↑

LRU     MRU
```

After accessing `A`:

```text
B ↔ C ↔ A

↑       ↑

LRU     MRU
```

Therefore, every successful access must update the usage order.

---

# 5. What Are We Trying to Build?

Suppose:

```java
LRUCache cache = new LRUCache(2);
```

This means:

```text
CAPACITY = 2
```

The cache can hold at most:

```text
2 KEY-VALUE PAIRS
```

We need:

```text
get(key)

and

put(key, value)
```

Both operations should run in average:

```text
O(1)
```

---

# 6. Understanding `get()`

Suppose:

```text
CACHE

1 → 100

2 → 200
```

Call:

```java
get(1);
```

Return:

```text
100
```

But `get()` must do more than return the value.

Because key `1` was just accessed, it becomes MRU.

Before:

```text
LRU              MRU

1        ↔        2
```

After:

```text
LRU              MRU

2        ↔        1
```

Therefore:

```text
get(key)

      ↓

DOES KEY EXIST?

    /            \

  NO              YES

   ↓                ↓

RETURN -1       FIND NODE

                    ↓

              MOVE TO MRU

                    ↓

               RETURN VALUE
```

---

# 7. Understanding `put()`

Suppose:

```text
capacity = 2
```

Call:

```java
put(1, 100);
```

Cache:

```text
1
```

Then:

```java
put(2, 200);
```

Cache:

```text
LRU              MRU

1        ↔        2
```

Now:

```java
put(3, 300);
```

The cache becomes larger than capacity.

Therefore:

```text
REMOVE LRU
```

Remove:

```text
1
```

Final:

```text
LRU              MRU

2        ↔        3
```

---

# 8. Real-World Example: Recently Viewed Photos

Imagine a photo application.

Thousands of photos may exist in slower storage, but only a limited number can remain in fast memory.

Suppose:

```text
CACHE CAPACITY = 2 PHOTOS
```

In our LRU Cache:

```text
key

↓

Photo ID
```

```text
value

↓

Photo Data
```

```text
capacity

↓

Maximum Photos Allowed
in Fast Memory
```

```text
get(key)

↓

Open a Cached Photo
```

```text
put(key, value)

↓

Store a Photo in Cache
```

Suppose the user opens Photo 101.

```java
put(101, 1000);
```

Cache:

```text
HEAD ↔ 101 ↔ TAIL
```

Then Photo 202:

```java
put(202, 2000);
```

Cache:

```text
HEAD ↔ 101 ↔ 202 ↔ TAIL

        LRU   MRU
```

Now the user opens Photo 101 again:

```java
get(101);
```

Because Photo 101 was recently accessed:

```text
HEAD ↔ 202 ↔ 101 ↔ TAIL

        LRU   MRU
```

Now the user opens Photo 303:

```java
put(303, 3000);
```

Temporarily:

```text
HEAD ↔ 202 ↔ 101 ↔ 303 ↔ TAIL
```

But:

```text
size = 3

capacity = 2
```

Therefore remove:

```text
202
```

Final:

```text
HEAD ↔ 101 ↔ 303 ↔ TAIL

        LRU   MRU
```

This is the exact real-world behavior represented by the LRU Cache algorithm.

---

# 9. Brute-Force Thinking

A beginner might use:

```text
ArrayList
```

Suppose:

```text
[A, B, C, D]
```

Access:

```text
C
```

We need to:

```text
FIND C

↓

REMOVE C

↓

ADD C AT END
```

Result:

```text
[A, B, D, C]
```

The logic works.

But finding `C` can take:

```text
O(n)
```

Removing from the middle of an array-based list can also require shifting elements.

Therefore:

```text
get() → O(n)
```

This does not satisfy the required:

```text
O(1)
```

---

# 10. Why HashMap Alone Is Not Enough

A HashMap gives:

```text
FAST LOOKUP

↓

O(1) Average
```

Example:

```text
1 → 100

2 → 200

3 → 300
```

We can quickly find:

```text
get(2)
```

But when the cache becomes full, we need to answer:

```text
WHICH ITEM IS
LEAST RECENTLY USED?
```

A normal HashMap alone does not efficiently maintain our required:

```text
LRU ↔ ... ↔ MRU
```

usage ordering.

Therefore:

```text
HASHMAP

FAST LOOKUP?

YES


FAST CUSTOM LRU ORDER MANAGEMENT?

NO
```

---

# 11. Why Linked List Alone Is Not Enough

Suppose:

```text
A ↔ B ↔ C ↔ D
```

A Doubly Linked List can efficiently:

```text
REMOVE NODE

↓

O(1)
```

```text
ADD NODE

↓

O(1)
```

```text
MOVE NODE

↓

O(1)
```

provided we already have the node reference.

But finding:

```text
C
```

may require:

```text
A

↓

B

↓

C
```

Therefore:

```text
LOOKUP

↓

O(n)
```

So:

```text
DOUBLY LINKED LIST

FAST ORDER MANAGEMENT?

YES


FAST LOOKUP BY KEY?

NO
```

---

# 12. Why Combine HashMap + Doubly Linked List?

The HashMap provides:

```text
FIND NODE

↓

O(1) Average
```

The Doubly Linked List provides:

```text
REMOVE NODE

↓

O(1)
```

```text
ADD NODE

↓

O(1)
```

```text
MOVE NODE

↓

O(1)
```

Therefore:

```text
HASHMAP

+

DOUBLY LINKED LIST

↓

LRU CACHE
```

Memory rule:

```text
HASHMAP

↓

WHERE IS THE NODE?
```

```text
DOUBLY LINKED LIST

↓

HOW RECENTLY WAS
THE NODE USED?
```

---

# 13. Complete Architecture

The HashMap stores:

```text
KEY → NODE REFERENCE
```

Example:

```text
1 → Node 1

2 → Node 2

3 → Node 3
```

The Doubly Linked List stores:

```text
LRU                                      MRU

Node 1       ↔       Node 2       ↔       Node 3
```

Together:

```text
HASHMAP

1 ───────→ Node 1
2 ───────→ Node 2
3 ───────→ Node 3


              +


DOUBLY LINKED LIST

HEAD ↔ Node 1 ↔ Node 2 ↔ Node 3 ↔ TAIL

         LRU                   MRU
```

---

# 14. Why Use a Doubly Linked List?

Suppose:

```text
A ↔ B ↔ C
```

Remove:

```text
B
```

Because `B` knows:

```text
B.prev = A

B.next = C
```

we can directly connect:

```text
A ↔ C
```

Code:

```java
node.prev.next = node.next;
node.next.prev = node.prev;
```

Time:

```text
O(1)
```

A Singly Linked List cannot directly move backward to the previous node.

That is why LRU Cache uses a Doubly Linked List.

---

# 15. Why Use Dummy Head and Tail Nodes?

Our structure is:

```text
HEAD ↔ REAL NODES ↔ TAIL
```

For example:

```text
HEAD ↔ A ↔ B ↔ C ↔ TAIL
```

We decide:

```text
head.next

↓

LRU
```

and:

```text
tail.prev

↓

MRU
```

Without dummy nodes, we would need many special checks:

```text
Is the list empty?

Are we removing the head?

Are we removing the tail?

Is there only one node?
```

Dummy nodes simplify these operations.

Every real node always has:

```text
A PREVIOUS NODE

and

A NEXT NODE
```

---

# 16. Understanding the Node Class

```java
private class Node {

    int key;
    int value;

    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
```

Each Node stores:

```text
KEY

VALUE

PREVIOUS NODE REFERENCE

NEXT NODE REFERENCE
```

Visually:

```text
┌──────────────────────┐
│        NODE          │
├──────────────────────┤
│ key                  │
│ value                │
│ prev                  │
│ next                  │
└──────────────────────┘
```

---

# 17. Why Does Node Store the Key?

The HashMap already has the key, so why does the Node also need it?

Because when removing the LRU node:

```java
Node leastRecentlyUsed = head.next;
```

we need to remove the same entry from the HashMap:

```java
cache.remove(leastRecentlyUsed.key);
```

Therefore the Node needs to remember:

```text
ITS OWN KEY
```

---

# 18. Understanding the HashMap

```java
private Map<Integer, Node> cache;
```

Break it down:

```text
Map<Integer, Node>

↓

KEY → NODE
```

Example:

```text
1 → Node [1,100]

2 → Node [2,200]
```

We do not use:

```java
Map<Integer, Integer>
```

because we need the exact Node reference to move or remove it from the Doubly Linked List.

Therefore:

```text
HashMap

↓

KEY → EXACT DLL NODE
```

---

# 19. Complete Optimal Java Solution

```java
import java.util.HashMap;
import java.util.Map;

class LRUCache {

    // Store one cache entry and its DLL connections
    private class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Map each key directly to its DLL node for O(1) average lookup
    private Map<Integer, Node> cache;

    // Store the maximum number of cache entries allowed
    private int capacity;

    // Dummy nodes simplify DLL insertion and removal
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        // Store the maximum cache capacity
        this.capacity = capacity;

        // Create the HashMap for fast key-to-node lookup
        cache = new HashMap<>();

        // Create dummy boundary nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        // Connect the empty Doubly Linked List
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        // Return -1 when the requested key is not cached
        if (!cache.containsKey(key)) {
            return -1;
        }

        // Find the exact node using the HashMap
        Node node = cache.get(key);

        // Remove the accessed node from its current position
        removeNode(node);

        // Move the accessed node to the MRU position
        addToEnd(node);

        // Return the cached value
        return node.value;
    }

    public void put(int key, int value) {

        // Remove the old node if the key already exists
        if (cache.containsKey(key)) {

            Node existingNode = cache.get(key);

            removeNode(existingNode);

            cache.remove(key);
        }

        // Create a new node for the key-value pair
        Node newNode = new Node(key, value);

        // Store the key-to-node mapping
        cache.put(key, newNode);

        // Add the new node at the MRU position
        addToEnd(newNode);

        // Evict the LRU node when capacity is exceeded
        if (cache.size() > capacity) {

            // The first real node is the LRU node
            Node leastRecentlyUsed = head.next;

            // Remove the LRU node from the DLL
            removeNode(leastRecentlyUsed);

            // Remove the same node from the HashMap
            cache.remove(leastRecentlyUsed.key);
        }
    }

    private void removeNode(Node node) {

        // Connect the previous node directly to the next node
        node.prev.next = node.next;

        // Connect the next node directly back to the previous node
        node.next.prev = node.prev;
    }

    private void addToEnd(Node node) {

        // Make the current MRU node the new node's previous node
        node.prev = tail.prev;

        // Make the dummy tail the new node's next node
        node.next = tail;

        // Connect the previous MRU node to the new node
        tail.prev.next = node;

        // Make the new node the MRU node
        tail.prev = node;
    }
}
```

---

# 20. Understanding `removeNode()`

Code:

```java
private void removeNode(Node node) {

    node.prev.next = node.next;

    node.next.prev = node.prev;
}
```

Suppose:

```text
A ↔ B ↔ C
```

Remove:

```text
B
```

We know:

```text
B.prev = A

B.next = C
```

First:

```java
node.prev.next = node.next;
```

Substitute:

```text
B.prev.next = B.next
```

Therefore:

```text
A.next = C
```

Then:

```java
node.next.prev = node.prev;
```

Substitute:

```text
B.next.prev = B.prev
```

Therefore:

```text
C.prev = A
```

Final:

```text
A ↔ C
```

Memory rule:

```text
REMOVE NODE

↓

CONNECT PREVIOUS TO NEXT

↓

CONNECT NEXT BACK TO PREVIOUS
```

---

# 21. Understanding `addToEnd()`

The end of our list represents:

```text
MRU
```

Suppose:

```text
HEAD ↔ A ↔ B ↔ TAIL
```

Add:

```text
C
```

Expected:

```text
HEAD ↔ A ↔ B ↔ C ↔ TAIL
```

Code:

```java
node.prev = tail.prev;
```

Meaning:

```text
C.prev = B
```

Then:

```java
node.next = tail;
```

Meaning:

```text
C.next = TAIL
```

Then:

```java
tail.prev.next = node;
```

Because:

```text
tail.prev = B
```

this means:

```text
B.next = C
```

Finally:

```java
tail.prev = node;
```

Meaning:

```text
TAIL.prev = C
```

Final:

```text
HEAD ↔ A ↔ B ↔ C ↔ TAIL
```

---

# 22. Understanding `get()`

Code:

```java
public int get(int key) {

    if (!cache.containsKey(key)) {
        return -1;
    }

    Node node = cache.get(key);

    removeNode(node);

    addToEnd(node);

    return node.value;
}
```

Complete flow:

```text
get(key)

↓

DOES KEY EXIST?

   /           \

 NO             YES

 ↓               ↓

RETURN -1     GET NODE

                 ↓

            REMOVE NODE

                 ↓

             ADD TO MRU

                 ↓

            RETURN VALUE
```

Why remove and add again?

Because accessing a node makes it:

```text
MOST RECENTLY USED
```

---

# 23. Understanding `put()`

Complete flow:

```text
put(key, value)

↓

DOES KEY EXIST?

    /            \

  YES             NO

   ↓               ↓

REMOVE OLD      CONTINUE

   ↓

REMOVE FROM MAP

        ↓

CREATE NEW NODE

        ↓

ADD TO HASHMAP

        ↓

ADD AS MRU

        ↓

SIZE > CAPACITY?

    /           \

  YES            NO

   ↓               ↓

REMOVE LRU       DONE

   ↓

REMOVE LRU
FROM HASHMAP
```

---

# 24. Complete Dry Run

Capacity:

```text
2
```

Create:

```java
LRUCache cache = new LRUCache(2);
```

Initial DLL:

```text
HEAD ↔ TAIL
```

Initial HashMap:

```text
{}
```

---

## `put(1, 100)`

Create:

```text
Node 1
```

HashMap:

```text
1 → Node 1
```

DLL:

```text
HEAD ↔ 1 ↔ TAIL
```

---

## `put(2, 200)`

HashMap:

```text
1 → Node 1

2 → Node 2
```

DLL:

```text
HEAD ↔ 1 ↔ 2 ↔ TAIL

        LRU   MRU
```

---

## `get(1)`

HashMap finds:

```text
Node 1
```

Remove Node 1:

```text
HEAD ↔ 2 ↔ TAIL
```

Add Node 1 as MRU:

```text
HEAD ↔ 2 ↔ 1 ↔ TAIL

        LRU   MRU
```

Return:

```text
100
```

---

## `put(3, 300)`

Add Node 3:

```text
HEAD ↔ 2 ↔ 1 ↔ 3 ↔ TAIL
```

Now:

```text
size = 3

capacity = 2
```

Therefore:

```text
size > capacity
```

Remove:

```text
head.next
```

which is:

```text
Node 2
```

Final DLL:

```text
HEAD ↔ 1 ↔ 3 ↔ TAIL

        LRU   MRU
```

Final HashMap:

```text
1 → Node 1

3 → Node 3
```

---

## `get(2)`

Check HashMap.

Key `2` does not exist.

Return:

```text
-1
```

---

# 25. Big O Analysis

## `get()`

HashMap lookup:

```text
O(1) Average
```

Remove Node:

```text
O(1)
```

Add Node:

```text
O(1)
```

Therefore:

```text
O(1) + O(1) + O(1)

=

O(1)
```

Final:

```text
get() = O(1) Average
```

---

## `put()`

HashMap lookup:

```text
O(1) Average
```

Possible Node removal:

```text
O(1)
```

HashMap insertion:

```text
O(1) Average
```

DLL insertion:

```text
O(1)
```

Possible LRU eviction:

```text
O(1)
```

Therefore:

```text
put() = O(1) Average
```

---

## Space Complexity

We store at most:

```text
capacity
```

real cache nodes.

The HashMap also contains at most:

```text
capacity
```

entries.

Therefore:

```text
Space Complexity = O(capacity)
```

---

# 26. Pattern Recognition

When a problem requires:

```text
FAST LOOKUP

+

FAST INSERTION

+

FAST REMOVAL

+

MAINTAINING USAGE ORDER
```

think:

```text
HASHMAP

+

DOUBLY LINKED LIST
```

Especially when the problem mentions:

```text
CACHE

RECENTLY USED

LEAST RECENTLY USED

MOST RECENTLY USED

EVICTION

FIXED CAPACITY
```

think:

```text
LRU CACHE PATTERN
```

---

# 27. Google Interview Explanation

A brute-force approach could use an ArrayList or Linked List to maintain usage order, but finding a key would require `O(n)` time.

A HashMap provides average `O(1)` lookup, but it does not efficiently maintain the required LRU-to-MRU ordering by itself.

A Doubly Linked List provides `O(1)` insertion and removal when we already have the node reference, but searching for an arbitrary key takes `O(n)`.

Therefore, I combine a HashMap with a Doubly Linked List.

The HashMap stores:

```text
key → Node reference
```

allowing average `O(1)` lookup.

The Doubly Linked List maintains:

```text
LRU ↔ ... ↔ MRU
```

ordering.

I use dummy head and tail nodes so that:

```text
head.next = LRU

tail.prev = MRU
```

When `get(key)` succeeds, I find the node using the HashMap, remove it from its current DLL position, move it to the MRU position, and return its value.

When `put(key, value)` is called, I handle an existing key if necessary, insert the new entry at the MRU position, and if the cache exceeds capacity, remove `head.next`, which is the LRU node, from both the Doubly Linked List and the HashMap.

This gives:

```text
get() → O(1) Average

put() → O(1) Average

Space → O(capacity)
```

---

# 28. Short Interview Revision Notes

```text
PROBLEM:

Problem #4
LRU Cache


DIFFICULTY:

Medium


CATEGORY:

Design / Linked List


PATTERN:

HashMap
+
Doubly Linked List


LRU:

Least Recently Used


MRU:

Most Recently Used


REQUIREMENT:

get() → O(1) Average

put() → O(1) Average


BRUTE FORCE:

ArrayList / Linked List


PROBLEM:

Lookup → O(n)


HASHMAP STRENGTH:

Fast Lookup


HASHMAP WEAKNESS:

Does Not Efficiently Maintain
Custom LRU ↔ MRU Order Alone


DLL STRENGTH:

Fast Insert

Fast Remove

Fast Move


DLL WEAKNESS:

Lookup → O(n)


SOLUTION:

HashMap + DLL


HASHMAP STORES:

Key → Node Reference


DLL STORES:

Usage Order


LIST STRUCTURE:

HEAD ↔ LRU ↔ ... ↔ MRU ↔ TAIL


LRU NODE:

head.next


MRU NODE:

tail.prev


GET:

Find Node

↓

Remove From Current Position

↓

Move To MRU

↓

Return Value


PUT:

Handle Existing Key

↓

Create New Node

↓

Add To HashMap

↓

Add As MRU

↓

If Over Capacity

↓

Remove LRU From DLL

↓

Remove LRU From HashMap


REMOVE NODE:

node.prev.next = node.next

node.next.prev = node.prev


ADD AS MRU:

node.prev = tail.prev

node.next = tail

tail.prev.next = node

tail.prev = node


TIME:

get() → O(1) Average

put() → O(1) Average


SPACE:

O(capacity)
```

---

# Final Pattern Summary

Our pattern-wise progress:

```text
Problem #1: Two Sum

↓

HashMap Lookup


Problem #12: Group Anagrams

↓

HashMap Grouping


Problem #16: Top K Frequent Elements

↓

Frequency Counting
+
Bucket Sort


Problem #19: Product of Array Except Self

↓

Prefix / Suffix


Problem #7:
Longest Substring Without Repeating Characters

↓

Sliding Window


Problem #15:
Container With Most Water

↓

Opposite-Direction Two Pointers


Problem #8:
Trapping Rain Water

↓

Two Pointers
+
Running Maximum Boundaries


Problem #3:
Merge Intervals

↓

Sort
+
Compare
+
Merge


Problem #4:
LRU Cache

↓

HashMap
+
Doubly Linked List
```

---

# Final Takeaway

```text
LRU CACHE REQUIREMENTS

        ↓

FIND ANY KEY FAST

        ↓

HASHMAP


        +


MAINTAIN USAGE ORDER

        ↓

DOUBLY LINKED LIST


        ↓


HASHMAP + DLL


        ↓


HEAD ↔ LRU ↔ ... ↔ MRU ↔ TAIL


        ↓


get()

Find
→ Remove
→ Move to MRU
→ Return


        ↓


put()

Handle Existing Key
→ Create Node
→ Add to Map
→ Add as MRU
→ Evict LRU if Needed


        ↓


get() = O(1) Average

put() = O(1) Average
```

The most important lesson from **Problem #4: LRU Cache** is:

> **When one data structure cannot satisfy every performance requirement, combine data structures whose strengths cover each other's weaknesses.**

The core pattern to remember is:

```text
HASHMAP

"WHERE IS THE NODE?"

+

DOUBLY LINKED LIST

"HOW RECENTLY WAS THE NODE USED?"

=

LRU CACHE
```
