# 🚀 MyCoding - Data Structures & Algorithms in Java

# 🧠 Strategy 1: Palindrome Checker

> ⭐ **Doubly Linked List Interview Question**

The **Palindrome Checker** problem determines whether the values in a Doubly Linked List read the same **forward and backward**.

A Doubly Linked List is especially suitable for this problem because every node contains:

* A `next` pointer to move forward.
* A `prev` pointer to move backward.

By using two pointers—one starting at the `head` and another starting at the `tail`—we can compare values from both ends of the list.

---

# 📖 Problem Statement

Write a method called **`isPalindrome()`** that determines whether a Doubly Linked List is a palindrome.

A palindrome reads the same forward and backward.

For example:

```text
1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

Forward:

```text
1 → 2 → 3 → 2 → 1
```

Backward:

```text
1 → 2 → 3 → 2 → 1
```

Since both directions produce the same sequence, the list is a palindrome.

The method should return:

```text
true
```

if the Doubly Linked List is a palindrome.

Otherwise, return:

```text
false
```

---

# 📌 Method Signature

```java
public boolean isPalindrome()
```

---

# 💡 Example 1

### Input

```text
1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

### Output

```text
true
```

### Reason

The list reads the same in both directions.

```text
Forward  : 1 → 2 → 3 → 2 → 1

Backward : 1 → 2 → 3 → 2 → 1
```

Therefore, the Doubly Linked List is a palindrome.

---

# 💡 Example 2

### Input

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

### Output

```text
false
```

### Reason

Compare the first and last values:

```text
1 != 5
```

Since the values are different, the list is not a palindrome.

---

# 💡 Example 3

### Input

```text
1 ⇄ 2 ⇄ 2 ⇄ 1
```

### Output

```text
true
```

This is an even-length palindrome.

---

# 💡 Recommended Approach

Use the **Two-Pointer Technique**.

Create two pointers:

```text
forward
```

and:

```text
backward
```

The `forward` pointer starts at the `head`.

```text
forward = head
```

The `backward` pointer starts at the `tail`.

```text
backward = tail
```

Compare the values at both pointers.

After every comparison:

```text
forward → Move Forward
```

and:

```text
backward → Move Backward
```

Continue until the pointers reach the middle of the list.

---

# 🖼 Visualization

Consider:

```text
1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

Initially:

```text
forward
   ↓

   1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1

                       ↑
                    backward
```

Compare:

```text
1 == 1
```

Move both pointers:

```text
     forward
        ↓

1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1

              ↑
           backward
```

Compare:

```text
2 == 2
```

Move both pointers again:

```text
          forward
             ↓

1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1

             ↑
          backward
```

Both pointers have reached the middle.

The list is a palindrome.

Return:

```text
true
```

---

# 💻 Java Solution

```java
public boolean isPalindrome() {

    Node forward = head;
    Node backward = tail;

    for (int i = 0; i < length / 2; i++) {

        if (forward.value != backward.value) {
            return false;
        }

        forward = forward.next;
        backward = backward.prev;
    }

    return true;
}
```

---

# ⚙️ Algorithm

1. Create a `forward` pointer and initialize it to the `head`.
2. Create a `backward` pointer and initialize it to the `tail`.
3. Compare the values of both pointers.
4. If the values are different, return `false`.
5. Move `forward` one node forward using `next`.
6. Move `backward` one node backward using `prev`.
7. Continue until half of the linked list has been checked.
8. If no mismatching values are found, return `true`.

---

# 📖 Code Explanation

### Step 1: Create the Forward Pointer

```java
Node forward = head;
```

Creates a pointer that starts at the beginning of the Doubly Linked List.

```text
forward
   ↓

   1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

---

### Step 2: Create the Backward Pointer

```java
Node backward = tail;
```

Creates another pointer that starts at the end of the Doubly Linked List.

```text
                       backward
                          ↓

1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

Now we have pointers at both ends.

```text
forward                 backward

   ↓                        ↓

   1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

---

### Step 3: Traverse Half of the List

```java
for (int i = 0; i < length / 2; i++)
```

We only need to check half of the linked list.

Why?

Because we're comparing nodes from both ends simultaneously.

For example:

```text
1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

First comparison:

```text
1 == 1
```

Second comparison:

```text
2 == 2
```

The middle node does not need to be compared with anything else.

Therefore:

```text
length / 2
```

comparisons are enough.

---

### Step 4: Compare the Values

```java
if (forward.value != backward.value) {
    return false;
}
```

Compare the values from both ends.

For example:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

First comparison:

```text
1 != 5
```

The list cannot be a palindrome.

Therefore, immediately return:

```text
false
```

There is no need to check the remaining nodes.

---

### Step 5: Move the Forward Pointer

```java
forward = forward.next;
```

Moves the `forward` pointer one position toward the middle.

```text
Before:

forward
   ↓

   1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

After:

```text
     forward
        ↓

1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

---

### Step 6: Move the Backward Pointer

```java
backward = backward.prev;
```

Moves the `backward` pointer one position toward the middle.

```text
Before:

                       backward
                          ↓

1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

After:

```text
              backward
                 ↓

1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

---

### Step 7: Return `true`

```java
return true;
```

If all compared values are equal, the Doubly Linked List is a palindrome.

Therefore, return:

```text
true
```

---

# 📊 Dry Run

Consider:

```text
1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

Length:

```text
5
```

Number of comparisons:

```text
length / 2

5 / 2 = 2
```

---

### Iteration 1

```text
forward.value = 1

backward.value = 1
```

Compare:

```text
1 == 1
```

Move pointers:

```text
forward → 2

backward → 2
```

---

### Iteration 2

```text
forward.value = 2

backward.value = 2
```

Compare:

```text
2 == 2
```

Move pointers.

Loop ends.

Return:

```text
true
```

---

# ⚠️ Edge Cases

### Empty List

```text
null
```

Result:

```text
true
```

An empty list can be considered a palindrome because there are no mismatching values.

---

### Single Node

```text
1
```

Result:

```text
true
```

A single value reads the same forward and backward.

---

### Two Equal Nodes

```text
1 ⇄ 1
```

Result:

```text
true
```

---

### Two Different Nodes

```text
1 ⇄ 2
```

Result:

```text
false
```

---

### Odd-Length Palindrome

```text
1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

Result:

```text
true
```

---

### Even-Length Palindrome

```text
1 ⇄ 2 ⇄ 2 ⇄ 1
```

Result:

```text
true
```

---

# ❓ Why Use Two Pointers?

A palindrome requires comparing:

```text
First ↔ Last

Second ↔ Second Last

Third ↔ Third Last
```

A Doubly Linked List allows this naturally because:

```text
head → next → next
```

moves forward, while:

```text
tail → prev → prev
```

moves backward.

Therefore, two pointers are the most efficient and natural solution.

---

# ❓ Why Only Traverse `length / 2`?

Suppose:

```text
1 ⇄ 2 ⇄ 3 ⇄ 2 ⇄ 1
```

We compare:

```text
1 ↔ 1

2 ↔ 2
```

The middle node:

```text
3
```

does not need comparison.

Similarly, for:

```text
1 ⇄ 2 ⇄ 2 ⇄ 1
```

We compare:

```text
1 ↔ 1

2 ↔ 2
```

After checking half of the list, every required pair has already been compared.

---

# ⏱ Time Complexity

```text
Time Complexity : O(n)
```

Only half of the linked list is traversed:

```text
O(n / 2)
```

After dropping constants in Big O notation:

```text
O(n)
```

Therefore, the final time complexity is:

```text
O(n)
```

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only two pointer variables are used:

```text
forward

backward
```

No additional data structures are required.

---

# 📊 Complexity Summary

| Operation               | Complexity |
| ----------------------- | ---------- |
| Compare Nodes           | O(n)       |
| Extra Space             | O(1)       |
| Overall Time Complexity | **O(n)**   |
| Space Complexity        | **O(1)**   |

---

# 🎓 Key Takeaways

* Use two pointers to check whether the Doubly Linked List is a palindrome.
* Start one pointer at the `head`.
* Start the other pointer at the `tail`.
* Compare values from both ends.
* Move the pointers toward the middle.
* Return `false` immediately when a mismatch is found.
* Only half of the linked list needs to be checked.
* The solution runs in **O(n)** time and **O(1)** extra space.
* The `prev` pointer makes palindrome checking especially convenient in a Doubly Linked List.

---

## 📌 Interview Tip

Whenever you hear questions like:

* Check whether a Doubly Linked List is a palindrome.
* Compare values from both ends.
* Read a list forward and backward.
* Solve without using additional data structures.

Think about:

```text
Two-Pointer Technique
```

Use:

```text
Head Pointer → Move Forward

Tail Pointer → Move Backward
```

The key pattern is:

```text
Compare

↓

Move Inward

↓

Compare

↓

Move Inward

↓

Reach the Middle
```

This gives an efficient **O(n) time and O(1) space** solution.

---
# 🚀 MyCoding - Data Structures & Algorithms in Java

# 🧠 Strategy 2: Reverse Doubly Linked List

> ⭐ **Doubly Linked List Interview Question**

The **Reverse Doubly Linked List** problem requires reversing the order of all nodes by manipulating the `next` and `prev` pointers.

The node values must **not** be swapped.

Instead, we reverse the direction of the pointers of every node and finally update the `head` and `tail`.

---

# 📖 Problem Statement

Implement a method called **`reverse()`** that reverses the order of nodes in a Doubly Linked List.

The method should modify the existing linked list **in-place**.

For example:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

After calling:

```java
reverse();
```

The list becomes:

```text
5 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 1
```

The method should reverse the nodes by changing their pointers, not by swapping the values stored inside them.

---

# 📌 Method Signature

```java
public void reverse()
```

---

# 🎯 Constraints

* The Doubly Linked List may be empty.
* The list may contain only one node.
* The list may contain multiple nodes.
* Do not swap node values.
* Reverse the list by changing the `next` and `prev` pointers.
* Modify the existing linked list in-place.

---

# 💡 Example

## Before Reverse

```text
Head
 ↓

1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5

                 ↑
                Tail
```

Properties:

```text
Head   : 1

Tail   : 5

Length : 5
```

Call:

```java
reverse();
```

## After Reverse

```text
Head
 ↓

5 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 1

                 ↑
                Tail
```

Properties:

```text
Head   : 5

Tail   : 1

Length : 5
```

---

# ❓ Why Not Swap Values?

A beginner approach might swap the values inside the nodes.

For example:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Swap:

```text
1 ↔ 5

2 ↔ 4
```

Result:

```text
5 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 1
```

Although the values appear reversed, the actual nodes have not changed positions.

The problem specifically requires us to manipulate the node pointers.

Therefore, we must reverse:

```text
next
```

and:

```text
prev
```

for every node.

---

# 💡 Recommended Approach

Traverse the Doubly Linked List one node at a time.

For every node:

1. Store the current node's `next` pointer.
2. Swap the node's `next` and `prev` pointers.
3. Move to the next node from the original list.
4. Continue until all nodes are processed.
5. Swap the `head` and `tail`.

---

# 🖼 Main Idea

Original Node Connections:

```text
Previous ← Current → Next
```

Each node contains:

```text
current.prev → Previous

current.next → Next
```

After reversing the pointers:

```text
Previous ← Current → Next
```

becomes:

```text
Previous ← Current → Next
         next     prev
```

In simpler terms:

```text
Old next becomes new prev.

Old prev becomes new next.
```

This operation is performed for every node.

---

# 💻 Java Solution

```java
public void reverse() {

    Node current = head;
    Node temp = null;

    while (current != null) {

        temp = current.prev;
        current.prev = current.next;
        current.next = temp;

        current = current.prev;
    }

    temp = head;
    head = tail;
    tail = temp;
}
```

---

# ⚙️ Algorithm

1. Set `current` to the head.
2. Create a temporary pointer.
3. Traverse every node.
4. Store the current node's `prev` pointer.
5. Set the current node's `prev` pointer to its `next`.
6. Set the current node's `next` pointer to the stored previous pointer.
7. Move `current` forward through the original list.
8. Continue until `current` becomes `null`.
9. Swap the `head` and `tail`.

---

# 📖 Code Explanation

### Step 1: Start from the Head

```java
Node current = head;
```

Creates a pointer called `current` and initializes it to the first node.

Example:

```text
current
   ↓

   1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

The `current` pointer will traverse every node in the Doubly Linked List.

---

### Step 2: Create a Temporary Pointer

```java
Node temp = null;
```

Creates a temporary pointer.

This pointer is used while swapping the `next` and `prev` references of each node.

---

### Step 3: Traverse the Entire List

```java
while (current != null)
```

Continue processing nodes until `current` reaches the end of the list.

---

### Step 4: Store the Previous Pointer

```java
temp = current.prev;
```

Temporarily stores the current node's `prev` pointer.

We need to save this reference because the pointers are about to be changed.

---

### Step 5: Reverse the `prev` Pointer

```java
current.prev = current.next;
```

The current node's `prev` pointer now points to what was originally its next node.

For example:

```text
1 ⇄ 2 ⇄ 3
```

If `current` is `2`:

Before:

```text
2.prev → 1

2.next → 3
```

After:

```java
current.prev = current.next;
```

We get:

```text
2.prev → 3
```

---

### Step 6: Reverse the `next` Pointer

```java
current.next = temp;
```

The current node's `next` pointer now points to what was originally its previous node.

Since:

```text
temp → Original Previous Node
```

we assign:

```text
current.next → Original Previous Node
```

For node `2`:

```text
2.next → 1
```

Now the pointers of node `2` are reversed.

Before:

```text
1 ← 2 → 3

prev     next
```

After:

```text
1 ← 2 → 3

next     prev
```

---

# 🔥 Most Important Part

After swapping the pointers:

```java
current.prev = current.next;
current.next = temp;
```

the meaning of `next` and `prev` has changed.

The original:

```text
current.next
```

is now stored in:

```text
current.prev
```

That is why the next line is:

```java
current = current.prev;
```

and **not**:

```java
current = current.next;
```

---

### Step 7: Move to the Next Original Node

```java
current = current.prev;
```

This line can initially look confusing.

Normally, to move forward we use:

```java
current = current.next;
```

But we just swapped the pointers.

The original `next` pointer is now stored inside:

```text
current.prev
```

Therefore:

```java
current = current.prev;
```

moves us to the next node from the **original list**.

---

### Step 8: Swap Head and Tail

After reversing every node:

```java
temp = head;
head = tail;
tail = temp;
```

The original head should become the new tail.

The original tail should become the new head.

Before:

```text
Head → 1

Tail → 5
```

After:

```text
Head → 5

Tail → 1
```

---

# 📊 Dry Run

Consider:

```text
1 ⇄ 2 ⇄ 3
```

Initially:

```text
Head → 1

Tail → 3

current → 1
```

---

## Iteration 1

Current:

```text
1
```

Store:

```java
temp = current.prev;
```

Since node `1` is the head:

```text
temp = null
```

Reverse `prev`:

```java
current.prev = current.next;
```

Now:

```text
1.prev → 2
```

Reverse `next`:

```java
current.next = temp;
```

Now:

```text
1.next → null
```

Move:

```java
current = current.prev;
```

Now:

```text
current → 2
```

---

## Iteration 2

Current:

```text
2
```

Store:

```text
temp → 1
```

Reverse `prev`:

```text
2.prev → 3
```

Reverse `next`:

```text
2.next → 1
```

Move:

```text
current → 3
```

---

## Iteration 3

Current:

```text
3
```

Store:

```text
temp → 2
```

Reverse `prev`:

```text
3.prev → null
```

Reverse `next`:

```text
3.next → 2
```

Move:

```text
current → null
```

Loop ends.

---

# 🔄 Swap Head and Tail

Before:

```text
Head → 1

Tail → 3
```

Execute:

```java
temp = head;
head = tail;
tail = temp;
```

After:

```text
Head → 3

Tail → 1
```

Final List:

```text
3 ⇄ 2 ⇄ 1
```

---

# 🧠 Easy Way to Remember the Logic

For every node:

```text
Save Previous

↓

Swap Previous and Next

↓

Move Using the New Previous Pointer
```

Code:

```java
temp = current.prev;

current.prev = current.next;

current.next = temp;

current = current.prev;
```

Finally:

```text
Swap Head and Tail
```

---

# ⚠️ Edge Cases

## Empty List

Input:

```text
null
```

The loop does not execute.

The list remains empty.

---

## Single Node

Input:

```text
1
```

After reversing:

```text
1
```

The list remains unchanged.

---

## Two Nodes

Input:

```text
1 ⇄ 2
```

Output:

```text
2 ⇄ 1
```

---

## Multiple Nodes

Input:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Output:

```text
5 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 1
```

---

# ⏱ Time Complexity

```text
Time Complexity : O(n)
```

Every node is visited exactly once.

Therefore:

```text
O(n)
```

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only two pointer variables are used:

```text
current

temp
```

No additional data structures are created.

---

# 📊 Complexity Summary

| Operation                    | Complexity |
| ---------------------------- | ---------- |
| Traverse All Nodes           | O(n)       |
| Reverse Each Node's Pointers | O(1)       |
| Swap Head and Tail           | O(1)       |
| Overall Time Complexity      | **O(n)**   |
| Space Complexity             | **O(1)**   |

---

# 🎓 Key Takeaways

* Do not swap node values.
* Reverse the actual node connections.
* Every node has two pointers that must be reversed.
* The original `next` becomes the new `prev`.
* The original `prev` becomes the new `next`.
* After swapping pointers, move using `current.prev`.
* Finally, swap the `head` and `tail`.
* The list is reversed in-place.
* The solution runs in **O(n)** time and **O(1)** extra space.

---

## 📌 Interview Tip

The most important question an interviewer may ask is:

**Why do we use this line?**

```java
current = current.prev;
```

instead of:

```java
current = current.next;
```

**Answer:**

Because the `next` and `prev` pointers have already been swapped.

After:

```java
current.prev = current.next;
current.next = temp;
```

the original next node is now stored in:

```text
current.prev
```

Therefore, to continue traversing the original list, we must use:

```java
current = current.prev;
```

The easiest pattern to remember is:

```text
For Every Node:

Swap next and prev

↓

Move using the swapped prev

↓

Repeat

↓

Swap head and tail
```

---
# 🚀 MyCoding - Data Structures & Algorithms in Java

# 🧠 Strategy 3: Partition List

> ⭐ **Doubly Linked List Interview Question**

The **Partition List** problem requires rearranging the nodes of a Doubly Linked List around a given value `x`.

All nodes with values:

```text
value < x
```

must appear before nodes with values:

```text
value >= x
```

The relative order of nodes inside each partition must remain unchanged.

The existing nodes must be reused by changing their `next` and `prev` pointers.

---

# 📖 Problem Statement

Write a method called **`partitionList()`** that rearranges a Doubly Linked List so that:

* Nodes with values less than `x` come first.
* Nodes with values greater than or equal to `x` come afterward.
* The original relative order inside each group is preserved.
* The existing nodes are rearranged.
* Both `next` and `prev` pointers must remain correct.

---

# 📌 Method Signature

```java
public void partitionList(int x)
```

---

# 💡 Example 1

### Input

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1

x = 5
```

Nodes less than `5`:

```text
3, 2, 1
```

Nodes greater than or equal to `5`:

```text
8, 5, 10
```

### Output

```text
3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10
```

Notice that the relative order is preserved.

For the first partition:

```text
3 → 2 → 1
```

For the second partition:

```text
8 → 5 → 10
```

---

# 💡 Example 2

### Input

```text
1 ⇄ 2 ⇄ 3

x = 5
```

Every node is less than `5`.

Therefore, the list remains:

```text
1 ⇄ 2 ⇄ 3
```

---

# 💡 Example 3

### Input

```text
6 ⇄ 7 ⇄ 8

x = 5
```

Every node is greater than or equal to `5`.

Therefore, the list remains:

```text
6 ⇄ 7 ⇄ 8
```

---

# 🎯 Main Challenge

Consider:

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1
```

We cannot simply move values around.

We must rearrange the actual nodes.

The desired result is:

```text
3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10
```

To solve this efficiently, we create two temporary chains:

```text
Less Partition
```

and:

```text
Greater Partition
```

The first chain stores nodes where:

```text
value < x
```

The second chain stores nodes where:

```text
value >= x
```

After processing every node, we connect the two chains.

---

# 💡 Recommended Approach

Use:

* Two dummy nodes.
* Two pointers to build the partitions.
* One pointer to traverse the original list.

The pointers are:

```text
dummy1
prev1

dummy2
prev2

current
```

The first chain stores:

```text
value < x
```

The second chain stores:

```text
value >= x
```

---

# 🖼 Main Idea

Original List:

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1
```

After traversal:

```text
Less Partition

dummy1 ⇄ 3 ⇄ 2 ⇄ 1
```

And:

```text
Greater Partition

dummy2 ⇄ 8 ⇄ 5 ⇄ 10
```

Finally:

```text
3 ⇄ 2 ⇄ 1
        ⇅
8 ⇄ 5 ⇄ 10
```

Result:

```text
3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10
```

---

# 💻 Java Solution

```java
public void partitionList(int x) {

    if (head == null) return;

    Node dummy1 = new Node(0);
    Node dummy2 = new Node(0);

    Node prev1 = dummy1;
    Node prev2 = dummy2;

    Node current = head;

    while (current != null) {

        Node nextNode = current.next;

        current.next = null;
        current.prev = null;

        if (current.value < x) {

            prev1.next = current;
            current.prev = prev1;
            prev1 = current;

        } else {

            prev2.next = current;
            current.prev = prev2;
            prev2 = current;
        }

        current = nextNode;
    }

    if (dummy1.next == null) {

        head = dummy2.next;
        head.prev = null;
        tail = prev2;

    } else {

        head = dummy1.next;
        head.prev = null;

        prev1.next = dummy2.next;

        if (dummy2.next != null) {
            dummy2.next.prev = prev1;
        }

        tail = (dummy2.next == null) ? prev1 : prev2;
    }
}
```

---

# ⚙️ Algorithm

1. Check whether the list is empty.
2. Create two dummy nodes.
3. Create a pointer for the end of each partition.
4. Start traversing from the head.
5. Save the next node before changing any pointers.
6. Disconnect the current node.
7. If the current value is less than `x`, add it to the first partition.
8. Otherwise, add it to the second partition.
9. Move to the saved next node.
10. Continue until every node is processed.
11. Connect the two partitions.
12. Update the head.
13. Update the tail.
14. Remove dummy-node connections from the final list.

---

# 📖 Code Explanation

## Step 1: Handle an Empty List

```java
if (head == null) return;
```

If the Doubly Linked List is empty, there is nothing to partition.

Therefore, immediately return.

---

## Step 2: Create Two Dummy Nodes

```java
Node dummy1 = new Node(0);
Node dummy2 = new Node(0);
```

The first dummy node represents the beginning of the:

```text
Less Partition
```

The second dummy node represents the beginning of the:

```text
Greater Partition
```

Initially:

```text
dummy1
```

and:

```text
dummy2
```

are separate.

---

# ❓ Why Use Dummy Nodes?

Without dummy nodes, we would need special logic for inserting the first node into each partition.

For example:

```text
Is this the first node?

Is the partition empty?

Should this become the partition head?
```

Dummy nodes remove these special cases.

Every node can simply be added after the current partition pointer.

---

## Step 3: Create Partition Pointers

```java
Node prev1 = dummy1;
Node prev2 = dummy2;
```

`prev1` always points to the last node of the less partition.

`prev2` always points to the last node of the greater partition.

Initially:

```text
prev1
  ↓

dummy1
```

and:

```text
prev2
  ↓

dummy2
```

---

## Step 4: Start Traversing the Original List

```java
Node current = head;
```

The `current` pointer starts at the first node.

Example:

```text
current
   ↓

3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1
```

---

## Step 5: Traverse Every Node

```java
while (current != null)
```

Continue processing nodes until the end of the original list is reached.

---

# 🔥 Step 6: Save the Next Node

```java
Node nextNode = current.next;
```

This is one of the most important lines in the solution.

We are about to change:

```text
current.next
```

Therefore, we must first save the next node.

Example:

```text
current
   ↓

3 ⇄ 8 ⇄ 5
```

Save:

```text
nextNode → 8
```

Now we can safely modify the pointers of node `3`.

---

# ❓ Why Do We Need `nextNode`?

Suppose we immediately execute:

```java
current.next = null;
```

Then:

```text
3 → null
```

We would lose access to:

```text
8 ⇄ 5 ⇄ 10...
```

Therefore, first:

```java
Node nextNode = current.next;
```

Then modify the pointers.

---

## Step 7: Disconnect the Current Node

```java
current.next = null;
current.prev = null;
```

Before:

```text
Previous ⇄ Current ⇄ Next
```

After:

```text
Previous

Current

Next
```

The current node is now isolated.

This makes it safer and easier to add the node to one of the two partitions.

---

# 🔀 Step 8: Check the Node Value

```java
if (current.value < x)
```

If the value is less than `x`, add the node to the first partition.

Otherwise, add it to the second partition.

---

# 🟢 Adding to the Less Partition

```java
prev1.next = current;
current.prev = prev1;
prev1 = current;
```

Suppose:

```text
Less Partition:

dummy1 ⇄ 3
```

And:

```text
current → 2
```

First:

```java
prev1.next = current;
```

Creates the forward connection:

```text
3 → 2
```

Then:

```java
current.prev = prev1;
```

Creates the backward connection:

```text
3 ← 2
```

Together:

```text
3 ⇄ 2
```

Finally:

```java
prev1 = current;
```

moves the partition pointer.

Now:

```text
dummy1 ⇄ 3 ⇄ 2
                 ↑
               prev1
```

---

# 🔴 Adding to the Greater Partition

```java
prev2.next = current;
current.prev = prev2;
prev2 = current;
```

The exact same process happens for values greater than or equal to `x`.

Example:

```text
Greater Partition:

dummy2 ⇄ 8 ⇄ 5
```

If:

```text
current → 10
```

After adding:

```text
dummy2 ⇄ 8 ⇄ 5 ⇄ 10
                         ↑
                       prev2
```

---

## Step 9: Move to the Next Original Node

```java
current = nextNode;
```

Earlier, we saved:

```java
Node nextNode = current.next;
```

Now we use that saved reference to continue traversing the original list.

---

# 📊 Complete Traversal Example

Original:

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1

x = 5
```

Process `3`:

```text
Less    : 3

Greater :
```

Process `8`:

```text
Less    : 3

Greater : 8
```

Process `5`:

```text
Less    : 3

Greater : 8 ⇄ 5
```

Process `10`:

```text
Less    : 3

Greater : 8 ⇄ 5 ⇄ 10
```

Process `2`:

```text
Less    : 3 ⇄ 2

Greater : 8 ⇄ 5 ⇄ 10
```

Process `1`:

```text
Less    : 3 ⇄ 2 ⇄ 1

Greater : 8 ⇄ 5 ⇄ 10
```

Now connect the partitions.

---

# 🔗 Connecting the Two Partitions

After traversal:

```text
dummy1 ⇄ 3 ⇄ 2 ⇄ 1
```

and:

```text
dummy2 ⇄ 8 ⇄ 5 ⇄ 10
```

We need:

```text
3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10
```

---

## Step 10: Handle an Empty Less Partition

```java
if (dummy1.next == null)
```

This means there were no values less than `x`.

Example:

```text
6 ⇄ 7 ⇄ 8

x = 5
```

The less partition is empty.

Therefore:

```java
head = dummy2.next;
head.prev = null;
tail = prev2;
```

The greater partition becomes the entire list.

---

## Step 11: Set the New Head

```java
head = dummy1.next;
head.prev = null;
```

The first real node after `dummy1` becomes the new head.

Example:

```text
dummy1 ⇄ 3 ⇄ 2 ⇄ 1
```

Therefore:

```text
head → 3
```

Since the head should not have a previous node:

```java
head.prev = null;
```

---

## Step 12: Connect the Partitions

```java
prev1.next = dummy2.next;
```

`prev1` points to the last node of the less partition.

```text
3 ⇄ 2 ⇄ 1
        ↑
      prev1
```

`dummy2.next` points to the first real node of the greater partition.

```text
dummy2 ⇄ 8 ⇄ 5 ⇄ 10
         ↑
    dummy2.next
```

Connect them:

```text
1 → 8
```

---

## Step 13: Create the Backward Connection

```java
if (dummy2.next != null) {
    dummy2.next.prev = prev1;
}
```

The forward connection was:

```text
1 → 8
```

Now create the backward connection:

```text
1 ← 8
```

Together:

```text
1 ⇄ 8
```

The two partitions are now correctly connected.

---

## Step 14: Update the Tail

```java
tail = (dummy2.next == null) ? prev1 : prev2;
```

If the greater partition is empty:

```text
tail = prev1
```

Otherwise:

```text
tail = prev2
```

This ensures that the tail always points to the last real node.

---

# 🖼 Complete Dry Run

Input:

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1

x = 5
```

Initial:

```text
Less:

dummy1


Greater:

dummy2
```

Process `3`:

```text
Less:

dummy1 ⇄ 3
```

Process `8`:

```text
Greater:

dummy2 ⇄ 8
```

Process `5`:

```text
Greater:

dummy2 ⇄ 8 ⇄ 5
```

Process `10`:

```text
Greater:

dummy2 ⇄ 8 ⇄ 5 ⇄ 10
```

Process `2`:

```text
Less:

dummy1 ⇄ 3 ⇄ 2
```

Process `1`:

```text
Less:

dummy1 ⇄ 3 ⇄ 2 ⇄ 1
```

Final temporary chains:

```text
dummy1 ⇄ 3 ⇄ 2 ⇄ 1

dummy2 ⇄ 8 ⇄ 5 ⇄ 10
```

Connect:

```text
3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10
```

Update:

```text
Head → 3

Tail → 10
```

Final Result:

```text
Head
 ↓

3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10

                         ↑
                        Tail
```

---

# 🧠 Easy Way to Remember the Logic

The entire solution can be remembered as:

```text
Create Two Chains

↓

Save Next Node

↓

Disconnect Current Node

↓

Check Value

↓

Add to Less or Greater Chain

↓

Move to Saved Next Node

↓

Connect Both Chains

↓

Update Head and Tail
```

---

# ❓ Why Are Two Partitions Used?

We need to preserve the relative order of nodes.

For:

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1
```

The less values appear as:

```text
3, 2, 1
```

They must remain:

```text
3 ⇄ 2 ⇄ 1
```

The greater values appear as:

```text
8, 5, 10
```

They must remain:

```text
8 ⇄ 5 ⇄ 10
```

Building two chains while traversing from left to right naturally preserves this order.

---

# ❓ Why Not Create Two New Linked Lists?

The problem requires rearranging the existing nodes.

We should not create replacement nodes for every value.

The dummy nodes are only temporary helper nodes.

The original nodes are reused and relinked.

---

# ❓ Why Do We Update Both `next` and `prev`?

Because this is a Doubly Linked List.

For a valid connection:

```text
A ⇄ B
```

we need:

```text
A.next = B
```

and:

```text
B.prev = A
```

Updating only one side would break the Doubly Linked List structure.

---

# ⏱ Time Complexity

```text
Time Complexity : O(n)
```

Every node is visited exactly once.

Connecting the partitions takes constant time.

Therefore:

```text
O(n) + O(1)

↓

O(n)
```

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only a fixed number of pointer variables and two dummy nodes are used.

No additional list, array, set, or map is created.

---

# 📊 Complexity Summary

| Operation               | Complexity |
| ----------------------- | ---------- |
| Traverse All Nodes      | O(n)       |
| Add Node to Partition   | O(1)       |
| Connect Partitions      | O(1)       |
| Overall Time Complexity | **O(n)**   |
| Space Complexity        | **O(1)**   |

---

# 🎓 Key Takeaways

* Create two temporary chains.
* One chain stores values less than `x`.
* The other stores values greater than or equal to `x`.
* Use dummy nodes to simplify partition construction.
* Save the next node before changing pointers.
* Disconnect the current node before adding it to a partition.
* Update both `next` and `prev` pointers.
* Preserve the original relative order.
* Connect both partitions after traversal.
* Correctly update the `head` and `tail`.
* The solution runs in **O(n)** time and **O(1)** extra space.

---

## 📌 Interview Tip

The most important pattern in this problem is:

```text
Save → Disconnect → Partition → Reconnect
```

In code:

```java
Node nextNode = current.next;

current.next = null;
current.prev = null;
```

Then:

```text
Add Current Node to Correct Partition
```

Finally:

```text
Connect Less Partition ⇄ Greater Partition
```

Whenever a Linked List problem asks you to:

* rearrange nodes,
* preserve relative order,
* divide nodes based on a condition,

think about creating **temporary chains with dummy nodes**.

The core strategy is:

```text
Original List

↓

Divide Into Two Chains

↓

Preserve Relative Order

↓

Connect Both Chains

↓

Update Head and Tail
```

---
# 🚀 MyCoding - Data Structures & Algorithms in Java

# 🧠 Strategy 3: Partition List

> ⭐ **Doubly Linked List Interview Question**

The **Partition List** problem requires rearranging the nodes of a Doubly Linked List around a given value `x`.

All nodes with values:

```text
value < x
```

must appear before nodes with values:

```text
value >= x
```

The relative order of nodes inside each partition must remain unchanged.

The existing nodes must be reused by changing their `next` and `prev` pointers.

---

# 📖 Problem Statement

Write a method called **`partitionList()`** that rearranges a Doubly Linked List so that:

* Nodes with values less than `x` come first.
* Nodes with values greater than or equal to `x` come afterward.
* The original relative order inside each group is preserved.
* The existing nodes are rearranged.
* Both `next` and `prev` pointers must remain correct.

---

# 📌 Method Signature

```java
public void partitionList(int x)
```

---

# 💡 Example 1

### Input

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1

x = 5
```

Nodes less than `5`:

```text
3, 2, 1
```

Nodes greater than or equal to `5`:

```text
8, 5, 10
```

### Output

```text
3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10
```

Notice that the relative order is preserved.

For the first partition:

```text
3 → 2 → 1
```

For the second partition:

```text
8 → 5 → 10
```

---

# 💡 Example 2

### Input

```text
1 ⇄ 2 ⇄ 3

x = 5
```

Every node is less than `5`.

Therefore, the list remains:

```text
1 ⇄ 2 ⇄ 3
```

---

# 💡 Example 3

### Input

```text
6 ⇄ 7 ⇄ 8

x = 5
```

Every node is greater than or equal to `5`.

Therefore, the list remains:

```text
6 ⇄ 7 ⇄ 8
```

---

# 🎯 Main Challenge

Consider:

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1
```

We cannot simply move values around.

We must rearrange the actual nodes.

The desired result is:

```text
3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10
```

To solve this efficiently, we create two temporary chains:

```text
Less Partition
```

and:

```text
Greater Partition
```

The first chain stores nodes where:

```text
value < x
```

The second chain stores nodes where:

```text
value >= x
```

After processing every node, we connect the two chains.

---

# 💡 Recommended Approach

Use:

* Two dummy nodes.
* Two pointers to build the partitions.
* One pointer to traverse the original list.

The pointers are:

```text
dummy1
prev1

dummy2
prev2

current
```

The first chain stores:

```text
value < x
```

The second chain stores:

```text
value >= x
```

---

# 🖼 Main Idea

Original List:

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1
```

After traversal:

```text
Less Partition

dummy1 ⇄ 3 ⇄ 2 ⇄ 1
```

And:

```text
Greater Partition

dummy2 ⇄ 8 ⇄ 5 ⇄ 10
```

Finally:

```text
3 ⇄ 2 ⇄ 1
        ⇅
8 ⇄ 5 ⇄ 10
```

Result:

```text
3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10
```

---

# 💻 Java Solution

```java
public void partitionList(int x) {

    if (head == null) return;

    Node dummy1 = new Node(0);
    Node dummy2 = new Node(0);

    Node prev1 = dummy1;
    Node prev2 = dummy2;

    Node current = head;

    while (current != null) {

        Node nextNode = current.next;

        current.next = null;
        current.prev = null;

        if (current.value < x) {

            prev1.next = current;
            current.prev = prev1;
            prev1 = current;

        } else {

            prev2.next = current;
            current.prev = prev2;
            prev2 = current;
        }

        current = nextNode;
    }

    if (dummy1.next == null) {

        head = dummy2.next;
        head.prev = null;
        tail = prev2;

    } else {

        head = dummy1.next;
        head.prev = null;

        prev1.next = dummy2.next;

        if (dummy2.next != null) {
            dummy2.next.prev = prev1;
        }

        tail = (dummy2.next == null) ? prev1 : prev2;
    }
}
```

---

# ⚙️ Algorithm

1. Check whether the list is empty.
2. Create two dummy nodes.
3. Create a pointer for the end of each partition.
4. Start traversing from the head.
5. Save the next node before changing any pointers.
6. Disconnect the current node.
7. If the current value is less than `x`, add it to the first partition.
8. Otherwise, add it to the second partition.
9. Move to the saved next node.
10. Continue until every node is processed.
11. Connect the two partitions.
12. Update the head.
13. Update the tail.
14. Remove dummy-node connections from the final list.

---

# 📖 Code Explanation

## Step 1: Handle an Empty List

```java
if (head == null) return;
```

If the Doubly Linked List is empty, there is nothing to partition.

Therefore, immediately return.

---

## Step 2: Create Two Dummy Nodes

```java
Node dummy1 = new Node(0);
Node dummy2 = new Node(0);
```

The first dummy node represents the beginning of the:

```text
Less Partition
```

The second dummy node represents the beginning of the:

```text
Greater Partition
```

Initially:

```text
dummy1
```

and:

```text
dummy2
```

are separate.

---

# ❓ Why Use Dummy Nodes?

Without dummy nodes, we would need special logic for inserting the first node into each partition.

For example:

```text
Is this the first node?

Is the partition empty?

Should this become the partition head?
```

Dummy nodes remove these special cases.

Every node can simply be added after the current partition pointer.

---

## Step 3: Create Partition Pointers

```java
Node prev1 = dummy1;
Node prev2 = dummy2;
```

`prev1` always points to the last node of the less partition.

`prev2` always points to the last node of the greater partition.

Initially:

```text
prev1
  ↓

dummy1
```

and:

```text
prev2
  ↓

dummy2
```

---

## Step 4: Start Traversing the Original List

```java
Node current = head;
```

The `current` pointer starts at the first node.

Example:

```text
current
   ↓

3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1
```

---

## Step 5: Traverse Every Node

```java
while (current != null)
```

Continue processing nodes until the end of the original list is reached.

---

# 🔥 Step 6: Save the Next Node

```java
Node nextNode = current.next;
```

This is one of the most important lines in the solution.

We are about to change:

```text
current.next
```

Therefore, we must first save the next node.

Example:

```text
current
   ↓

3 ⇄ 8 ⇄ 5
```

Save:

```text
nextNode → 8
```

Now we can safely modify the pointers of node `3`.

---

# ❓ Why Do We Need `nextNode`?

Suppose we immediately execute:

```java
current.next = null;
```

Then:

```text
3 → null
```

We would lose access to:

```text
8 ⇄ 5 ⇄ 10...
```

Therefore, first:

```java
Node nextNode = current.next;
```

Then modify the pointers.

---

## Step 7: Disconnect the Current Node

```java
current.next = null;
current.prev = null;
```

Before:

```text
Previous ⇄ Current ⇄ Next
```

After:

```text
Previous

Current

Next
```

The current node is now isolated.

This makes it safer and easier to add the node to one of the two partitions.

---

# 🔀 Step 8: Check the Node Value

```java
if (current.value < x)
```

If the value is less than `x`, add the node to the first partition.

Otherwise, add it to the second partition.

---

# 🟢 Adding to the Less Partition

```java
prev1.next = current;
current.prev = prev1;
prev1 = current;
```

Suppose:

```text
Less Partition:

dummy1 ⇄ 3
```

And:

```text
current → 2
```

First:

```java
prev1.next = current;
```

Creates the forward connection:

```text
3 → 2
```

Then:

```java
current.prev = prev1;
```

Creates the backward connection:

```text
3 ← 2
```

Together:

```text
3 ⇄ 2
```

Finally:

```java
prev1 = current;
```

moves the partition pointer.

Now:

```text
dummy1 ⇄ 3 ⇄ 2
                 ↑
               prev1
```

---

# 🔴 Adding to the Greater Partition

```java
prev2.next = current;
current.prev = prev2;
prev2 = current;
```

The exact same process happens for values greater than or equal to `x`.

Example:

```text
Greater Partition:

dummy2 ⇄ 8 ⇄ 5
```

If:

```text
current → 10
```

After adding:

```text
dummy2 ⇄ 8 ⇄ 5 ⇄ 10
                         ↑
                       prev2
```

---

## Step 9: Move to the Next Original Node

```java
current = nextNode;
```

Earlier, we saved:

```java
Node nextNode = current.next;
```

Now we use that saved reference to continue traversing the original list.

---

# 📊 Complete Traversal Example

Original:

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1

x = 5
```

Process `3`:

```text
Less    : 3

Greater :
```

Process `8`:

```text
Less    : 3

Greater : 8
```

Process `5`:

```text
Less    : 3

Greater : 8 ⇄ 5
```

Process `10`:

```text
Less    : 3

Greater : 8 ⇄ 5 ⇄ 10
```

Process `2`:

```text
Less    : 3 ⇄ 2

Greater : 8 ⇄ 5 ⇄ 10
```

Process `1`:

```text
Less    : 3 ⇄ 2 ⇄ 1

Greater : 8 ⇄ 5 ⇄ 10
```

Now connect the partitions.

---

# 🔗 Connecting the Two Partitions

After traversal:

```text
dummy1 ⇄ 3 ⇄ 2 ⇄ 1
```

and:

```text
dummy2 ⇄ 8 ⇄ 5 ⇄ 10
```

We need:

```text
3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10
```

---

## Step 10: Handle an Empty Less Partition

```java
if (dummy1.next == null)
```

This means there were no values less than `x`.

Example:

```text
6 ⇄ 7 ⇄ 8

x = 5
```

The less partition is empty.

Therefore:

```java
head = dummy2.next;
head.prev = null;
tail = prev2;
```

The greater partition becomes the entire list.

---

## Step 11: Set the New Head

```java
head = dummy1.next;
head.prev = null;
```

The first real node after `dummy1` becomes the new head.

Example:

```text
dummy1 ⇄ 3 ⇄ 2 ⇄ 1
```

Therefore:

```text
head → 3
```

Since the head should not have a previous node:

```java
head.prev = null;
```

---

## Step 12: Connect the Partitions

```java
prev1.next = dummy2.next;
```

`prev1` points to the last node of the less partition.

```text
3 ⇄ 2 ⇄ 1
        ↑
      prev1
```

`dummy2.next` points to the first real node of the greater partition.

```text
dummy2 ⇄ 8 ⇄ 5 ⇄ 10
         ↑
    dummy2.next
```

Connect them:

```text
1 → 8
```

---

## Step 13: Create the Backward Connection

```java
if (dummy2.next != null) {
    dummy2.next.prev = prev1;
}
```

The forward connection was:

```text
1 → 8
```

Now create the backward connection:

```text
1 ← 8
```

Together:

```text
1 ⇄ 8
```

The two partitions are now correctly connected.

---

## Step 14: Update the Tail

```java
tail = (dummy2.next == null) ? prev1 : prev2;
```

If the greater partition is empty:

```text
tail = prev1
```

Otherwise:

```text
tail = prev2
```

This ensures that the tail always points to the last real node.

---

# 🖼 Complete Dry Run

Input:

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1

x = 5
```

Initial:

```text
Less:

dummy1


Greater:

dummy2
```

Process `3`:

```text
Less:

dummy1 ⇄ 3
```

Process `8`:

```text
Greater:

dummy2 ⇄ 8
```

Process `5`:

```text
Greater:

dummy2 ⇄ 8 ⇄ 5
```

Process `10`:

```text
Greater:

dummy2 ⇄ 8 ⇄ 5 ⇄ 10
```

Process `2`:

```text
Less:

dummy1 ⇄ 3 ⇄ 2
```

Process `1`:

```text
Less:

dummy1 ⇄ 3 ⇄ 2 ⇄ 1
```

Final temporary chains:

```text
dummy1 ⇄ 3 ⇄ 2 ⇄ 1

dummy2 ⇄ 8 ⇄ 5 ⇄ 10
```

Connect:

```text
3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10
```

Update:

```text
Head → 3

Tail → 10
```

Final Result:

```text
Head
 ↓

3 ⇄ 2 ⇄ 1 ⇄ 8 ⇄ 5 ⇄ 10

                         ↑
                        Tail
```

---

# 🧠 Easy Way to Remember the Logic

The entire solution can be remembered as:

```text
Create Two Chains

↓

Save Next Node

↓

Disconnect Current Node

↓

Check Value

↓

Add to Less or Greater Chain

↓

Move to Saved Next Node

↓

Connect Both Chains

↓

Update Head and Tail
```

---

# ❓ Why Are Two Partitions Used?

We need to preserve the relative order of nodes.

For:

```text
3 ⇄ 8 ⇄ 5 ⇄ 10 ⇄ 2 ⇄ 1
```

The less values appear as:

```text
3, 2, 1
```

They must remain:

```text
3 ⇄ 2 ⇄ 1
```

The greater values appear as:

```text
8, 5, 10
```

They must remain:

```text
8 ⇄ 5 ⇄ 10
```

Building two chains while traversing from left to right naturally preserves this order.

---

# ❓ Why Not Create Two New Linked Lists?

The problem requires rearranging the existing nodes.

We should not create replacement nodes for every value.

The dummy nodes are only temporary helper nodes.

The original nodes are reused and relinked.

---

# ❓ Why Do We Update Both `next` and `prev`?

Because this is a Doubly Linked List.

For a valid connection:

```text
A ⇄ B
```

we need:

```text
A.next = B
```

and:

```text
B.prev = A
```

Updating only one side would break the Doubly Linked List structure.

---

# ⏱ Time Complexity

```text
Time Complexity : O(n)
```

Every node is visited exactly once.

Connecting the partitions takes constant time.

Therefore:

```text
O(n) + O(1)

↓

O(n)
```

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only a fixed number of pointer variables and two dummy nodes are used.

No additional list, array, set, or map is created.

---

# 📊 Complexity Summary

| Operation               | Complexity |
| ----------------------- | ---------- |
| Traverse All Nodes      | O(n)       |
| Add Node to Partition   | O(1)       |
| Connect Partitions      | O(1)       |
| Overall Time Complexity | **O(n)**   |
| Space Complexity        | **O(1)**   |

---

# 🎓 Key Takeaways

* Create two temporary chains.
* One chain stores values less than `x`.
* The other stores values greater than or equal to `x`.
* Use dummy nodes to simplify partition construction.
* Save the next node before changing pointers.
* Disconnect the current node before adding it to a partition.
* Update both `next` and `prev` pointers.
* Preserve the original relative order.
* Connect both partitions after traversal.
* Correctly update the `head` and `tail`.
* The solution runs in **O(n)** time and **O(1)** extra space.

---

## 📌 Interview Tip

The most important pattern in this problem is:

```text
Save → Disconnect → Partition → Reconnect
```

In code:

```java
Node nextNode = current.next;

current.next = null;
current.prev = null;
```

Then:

```text
Add Current Node to Correct Partition
```

Finally:

```text
Connect Less Partition ⇄ Greater Partition
```

Whenever a Linked List problem asks you to:

* rearrange nodes,
* preserve relative order,
* divide nodes based on a condition,

think about creating **temporary chains with dummy nodes**.

The core strategy is:

```text
Original List

↓

Divide Into Two Chains

↓

Preserve Relative Order

↓

Connect Both Chains

↓

Update Head and Tail
```

---

# 🚀 MyCoding - Data Structures & Algorithms in Java

# 🧠 Strategy 4: Reverse Between

> ⭐ **Doubly Linked List Interview Question**

The **Reverse Between** problem requires reversing only a specific portion of a Doubly Linked List.

The method receives two indexes:

```text
startIndex
endIndex
```

The nodes between these indexes, including both the starting and ending nodes, must be reversed.

The original Doubly Linked List must be modified **in-place** by changing the `next` and `prev` pointers.

The values stored inside the nodes must not be swapped.

---

# 📖 Problem Statement

Write a method that reverses the nodes of a Doubly Linked List between two given indexes:

```text
startIndex
```

and:

```text
endIndex
```

Both indexes are **zero-based**.

For example:

```text
Index

 0      1      2      3      4

 1  ⇄   2  ⇄   3  ⇄   4  ⇄   5
```

Call:

```java
reverseBetween(1, 3);
```

The nodes between indexes `1` and `3` are:

```text
2 ⇄ 3 ⇄ 4
```

Reverse them:

```text
4 ⇄ 3 ⇄ 2
```

Final Result:

```text
1 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 5
```

---

# 📌 Method Signature

```java
public void reverseBetween(int startIndex, int endIndex)
```

---

# 🎯 Constraints

* `startIndex` and `endIndex` are zero-based.
* The Doubly Linked List may be empty.
* The list may contain only one node.
* If `startIndex == endIndex`, no changes should occur.
* The existing nodes must be reused.
* Do not swap node values.
* Modify the original list in-place.
* Both `next` and `prev` pointers must remain correct.

---

# 💡 Example 1

### Input

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Call:

```java
reverseBetween(1, 3);
```

Reverse:

```text
2 ⇄ 3 ⇄ 4
```

Result:

```text
1 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 5
```

---

# 💡 Example 2

### Input

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Call:

```java
reverseBetween(0, 4);
```

The entire list is reversed.

Result:

```text
5 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 1
```

---

# 💡 Example 3

### Input

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Call:

```java
reverseBetween(2, 2);
```

Since:

```text
startIndex == endIndex
```

no reversal is required.

Result:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

---

# 🎯 Main Challenge

Consider:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Call:

```java
reverseBetween(1, 3);
```

We need to identify four important positions:

```text
Before Start

Start

End

After End
```

For this example:

```text
Before Start → 1

Start        → 2

End          → 4

After End    → 5
```

Visualization:

```text
beforeStart    startNode         endNode    afterEnd

     ↓             ↓                ↓           ↓

     1      ⇄      2   ⇄   3   ⇄   4     ⇄     5
```

We reverse:

```text
2 ⇄ 3 ⇄ 4
```

Then reconnect:

```text
1 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 5
```

---

# 💡 Recommended Approach

The solution can be divided into three main parts:

```text
1. Find the start of the section.

2. Reverse the pointers inside the section.

3. Reconnect the reversed section with the remaining list.
```

---

# 💻 Java Solution

```java
public void reverseBetween(int startIndex, int endIndex) {

    if (head == null || startIndex == endIndex) {
        return;
    }

    Node current = get(startIndex);
    Node beforeStart = current.prev;
    Node startNode = current;

    for (int i = 0; i <= endIndex - startIndex; i++) {

        Node nextNode = current.next;

        current.next = current.prev;
        current.prev = nextNode;

        current = nextNode;
    }

    Node endNode = startNode.prev;
    Node afterEnd = current;

    if (beforeStart != null) {
        beforeStart.next = endNode;
    } else {
        head = endNode;
    }

    endNode.prev = beforeStart;

    startNode.next = afterEnd;

    if (afterEnd != null) {
        afterEnd.prev = startNode;
    } else {
        tail = startNode;
    }
}
```

---

# ⚙️ Algorithm

1. Check whether the list is empty.
2. Check whether `startIndex` and `endIndex` are equal.
3. Find the node at `startIndex`.
4. Store the node before the reversal section.
5. Store the original starting node.
6. Traverse from `startIndex` to `endIndex`.
7. Save the next node before modifying pointers.
8. Swap the `next` and `prev` pointers of the current node.
9. Move to the saved next node.
10. Find the new first node of the reversed section.
11. Store the node after the reversed section.
12. Connect the left side to the reversed section.
13. Connect the reversed section to the right side.
14. Update `head` or `tail` when necessary.

---

# 📖 Code Explanation

## Step 1: Handle Simple Cases

```java
if (head == null || startIndex == endIndex) {
    return;
}
```

If the list is empty:

```text
null
```

there is nothing to reverse.

Also, if:

```text
startIndex == endIndex
```

only one node is selected.

Reversing one node does not change the list.

Therefore, return immediately.

---

## Step 2: Find the Starting Node

```java
Node current = get(startIndex);
```

Use the existing `get()` method to find the node where the reversal should begin.

Example:

```text
Index

 0      1      2      3      4

 1  ⇄   2  ⇄   3  ⇄   4  ⇄   5
```

Call:

```java
reverseBetween(1, 3);
```

Then:

```text
current → 2
```

---

## Step 3: Store the Node Before the Reversal

```java
Node beforeStart = current.prev;
```

The node before `current` must be saved.

Example:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Since:

```text
current → 2
```

we get:

```text
beforeStart → 1
```

Why save it?

Because after reversing the section, we need to reconnect the left side of the list.

---

## Step 4: Store the Original Starting Node

```java
Node startNode = current;
```

Save the original first node of the section.

Example:

```text
startNode → 2
```

After reversing:

```text
2 ⇄ 3 ⇄ 4
```

becomes:

```text
4 ⇄ 3 ⇄ 2
```

Notice that the original starting node:

```text
2
```

becomes the last node of the reversed section.

Therefore, we save it in `startNode`.

---

# 🔥 Reversing the Selected Section

```java
for (int i = 0; i <= endIndex - startIndex; i++)
```

This loop processes every node from `startIndex` through `endIndex`.

For example:

```text
startIndex = 1

endIndex = 3
```

Number of nodes:

```text
endIndex - startIndex + 1

3 - 1 + 1

= 3
```

The loop condition:

```text
i <= endIndex - startIndex
```

runs exactly three times.

---

## Step 5: Save the Next Node

```java
Node nextNode = current.next;
```

Before changing the pointers, save the next node.

This is extremely important.

Suppose:

```text
current → 2
```

Then:

```text
nextNode → 3
```

We are about to change:

```text
current.next
```

Without saving the next node first, we could lose the remaining part of the list.

---

## Step 6: Reverse the `next` Pointer

```java
current.next = current.prev;
```

The current node's `next` pointer now points to its original previous node.

Suppose:

```text
1 ⇄ 2 ⇄ 3
```

and:

```text
current → 2
```

Before:

```text
2.next → 3
```

After:

```text
2.next → 1
```

---

## Step 7: Reverse the `prev` Pointer

```java
current.prev = nextNode;
```

The current node's `prev` pointer now points to its original next node.

Before:

```text
2.prev → 1
```

After:

```text
2.prev → 3
```

Therefore:

```text
Original:

1 ← 2 → 3

After Swapping:

1 ← 2 → 3

    next prev
```

In simpler terms:

```text
Old next becomes new prev.

Old prev becomes new next.
```

---

## Step 8: Move to the Next Original Node

```java
current = nextNode;
```

Earlier, we saved:

```java
Node nextNode = current.next;
```

before changing the pointers.

Now we use that saved reference to continue traversing the original list.

---

# 📊 Reversal Dry Run

Original:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Reverse:

```text
Index 1 through Index 3
```

---

## Iteration 1

Current:

```text
2
```

Save:

```text
nextNode → 3
```

Reverse pointers:

```text
2.next → 1

2.prev → 3
```

Move:

```text
current → 3
```

---

## Iteration 2

Current:

```text
3
```

Save:

```text
nextNode → 4
```

Reverse pointers:

```text
3.next → 2

3.prev → 4
```

Move:

```text
current → 4
```

---

## Iteration 3

Current:

```text
4
```

Save:

```text
nextNode → 5
```

Reverse pointers:

```text
4.next → 3

4.prev → 5
```

Move:

```text
current → 5
```

Loop ends.

---

# 🔗 Reconnecting the Reversed Section

After the loop, we need to reconnect the reversed portion with the remaining list.

The reversed section is:

```text
4 ⇄ 3 ⇄ 2
```

The surrounding nodes are:

```text
1
```

and:

```text
5
```

We need:

```text
1 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 5
```

---

## Step 9: Find the New Beginning of the Reversed Section

```java
Node endNode = startNode.prev;
```

This line can initially look confusing.

Remember:

```text
startNode → 2
```

After reversal, node `2` becomes the last node of the reversed section.

Its `prev` pointer now points to:

```text
3
```

Wait—so why would `startNode.prev` be the new beginning?

This is exactly where pointer tracking becomes tricky.

With the reversal loop shown above, after processing the full section, the safer and clearer approach is to track the final processed node directly rather than deriving it afterward.

A clearer implementation is shown below.

---

# ✅ Clearer Java Solution

```java
public void reverseBetween(int startIndex, int endIndex) {

    if (head == null || startIndex == endIndex) {
        return;
    }

    Node current = get(startIndex);

    Node beforeStart = current.prev;
    Node startNode = current;
    Node endNode = null;

    for (int i = 0; i <= endIndex - startIndex; i++) {

        Node nextNode = current.next;

        current.next = current.prev;
        current.prev = nextNode;

        endNode = current;
        current = nextNode;
    }

    Node afterEnd = current;

    if (beforeStart != null) {
        beforeStart.next = endNode;
    } else {
        head = endNode;
    }

    endNode.prev = beforeStart;

    startNode.next = afterEnd;

    if (afterEnd != null) {
        afterEnd.prev = startNode;
    } else {
        tail = startNode;
    }
}
```

This version explicitly stores:

```text
endNode
```

during traversal.

After the final iteration:

```text
endNode
```

points to the new first node of the reversed section.

---

# 🧠 Four Important Pointers

The easiest way to understand this problem is to remember four nodes:

```text
beforeStart

startNode

endNode

afterEnd
```

Before reversal:

```text
beforeStart ⇄ startNode ⇄ ... ⇄ endNode ⇄ afterEnd
```

Example:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Pointers:

```text
beforeStart → 1

startNode   → 2

endNode     → 4

afterEnd    → 5
```

After reversing the middle section:

```text
1 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 5
```

Now:

```text
beforeStart → 1

endNode     → 4

startNode   → 2

afterEnd    → 5
```

---

# 🔗 Left-Side Reconnection

```java
if (beforeStart != null) {
    beforeStart.next = endNode;
} else {
    head = endNode;
}
```

If a node exists before the reversed section:

```text
beforeStart → 1
```

connect it to:

```text
endNode → 4
```

Result:

```text
1 → 4
```

If there is no node before the reversed section, it means the reversal started at index `0`.

Therefore:

```java
head = endNode;
```

---

## Fix the New Beginning's `prev`

```java
endNode.prev = beforeStart;
```

Creates the backward connection.

For example:

```text
1 ← 4
```

Together:

```text
1 ⇄ 4
```

If the reversal starts at the head:

```text
beforeStart = null
```

Therefore:

```text
endNode.prev = null
```

which correctly makes `endNode` the new head.

---

# 🔗 Right-Side Reconnection

```java
startNode.next = afterEnd;
```

Remember that the original starting node becomes the last node of the reversed section.

Example:

```text
startNode → 2
```

The node after the reversed section is:

```text
afterEnd → 5
```

Connect:

```text
2 → 5
```

---

## Fix the Right-Side `prev`

```java
if (afterEnd != null) {
    afterEnd.prev = startNode;
} else {
    tail = startNode;
}
```

If a node exists after the reversed section:

```text
afterEnd → 5
```

connect it backward:

```text
5.prev → 2
```

Together:

```text
2 ⇄ 5
```

If there is no node after the reversed section, the reversal reached the end of the list.

Therefore:

```java
tail = startNode;
```

---

# 🖼 Complete Dry Run

Input:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Call:

```java
reverseBetween(1, 3);
```

Initially:

```text
beforeStart → 1

startNode → 2

current → 2
```

---

### Reverse Node 2

```text
nextNode → 3

2.next → 1

2.prev → 3

endNode → 2

current → 3
```

---

### Reverse Node 3

```text
nextNode → 4

3.next → 2

3.prev → 4

endNode → 3

current → 4
```

---

### Reverse Node 4

```text
nextNode → 5

4.next → 3

4.prev → 5

endNode → 4

current → 5
```

Loop ends.

Now:

```text
beforeStart → 1

endNode → 4

startNode → 2

afterEnd → 5
```

Reconnect:

```text
1 ⇄ 4
```

and:

```text
2 ⇄ 5
```

Final Result:

```text
1 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 5
```

---

# ⚠️ Edge Cases

## Empty List

```text
null
```

No changes occur.

---

## Single Node

```text
1
```

Call:

```java
reverseBetween(0, 0);
```

No changes occur.

---

## Same Start and End Index

```text
1 ⇄ 2 ⇄ 3
```

Call:

```java
reverseBetween(1, 1);
```

Result:

```text
1 ⇄ 2 ⇄ 3
```

---

## Reverse from Head

Input:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Call:

```java
reverseBetween(0, 2);
```

Result:

```text
3 ⇄ 2 ⇄ 1 ⇄ 4 ⇄ 5
```

The `head` must be updated.

---

## Reverse Through Tail

Input:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Call:

```java
reverseBetween(2, 4);
```

Result:

```text
1 ⇄ 2 ⇄ 5 ⇄ 4 ⇄ 3
```

The `tail` must be updated.

---

## Reverse Entire List

Input:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

Call:

```java
reverseBetween(0, 4);
```

Result:

```text
5 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 1
```

Both `head` and `tail` must be updated.

---

# ❓ Why Save `nextNode`?

```java
Node nextNode = current.next;
```

Because we are about to change:

```text
current.next
```

Without saving the original next node, we could lose access to the remaining nodes.

The pattern is:

```text
Save Next

↓

Change Pointers

↓

Move to Saved Next
```

---

# ❓ Why Do We Need `beforeStart`?

After reversing the selected section, we need to reconnect it to the left side of the list.

Example:

```text
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5
```

When reversing:

```text
2 ⇄ 3 ⇄ 4
```

we must remember:

```text
beforeStart → 1
```

so we can later create:

```text
1 ⇄ 4
```

---

# ❓ Why Do We Need `startNode`?

The original starting node becomes the last node of the reversed section.

Before:

```text
2 ⇄ 3 ⇄ 4
```

After:

```text
4 ⇄ 3 ⇄ 2
```

Therefore:

```text
startNode → 2
```

must later connect to:

```text
afterEnd → 5
```

---

# ❓ Why Do We Need `endNode`?

The original ending node becomes the first node of the reversed section.

Before:

```text
2 ⇄ 3 ⇄ 4
```

After:

```text
4 ⇄ 3 ⇄ 2
```

Therefore:

```text
endNode → 4
```

must connect to:

```text
beforeStart → 1
```

---

# ⏱ Time Complexity

```text
Time Complexity : O(n)
```

The `get(startIndex)` method may require traversal.

The selected portion is then traversed once.

Therefore:

```text
O(n) + O(n)

↓

O(n)
```

The overall time complexity is:

```text
O(n)
```

---

# 💾 Space Complexity

```text
Space Complexity : O(1)
```

Only a fixed number of pointer variables are used.

No arrays, lists, sets, maps, or other additional data structures are created.

---

# 📊 Complexity Summary

| Operation               | Complexity |
| ----------------------- | ---------- |
| Find Starting Node      | O(n)       |
| Reverse Selected Nodes  | O(n)       |
| Reconnect Left Side     | O(1)       |
| Reconnect Right Side    | O(1)       |
| Overall Time Complexity | **O(n)**   |
| Space Complexity        | **O(1)**   |

---

# 🎓 Key Takeaways

* Reverse only the nodes between `startIndex` and `endIndex`.
* Do not swap node values.
* Modify the list in-place.
* Save the next node before changing pointers.
* Reverse both `next` and `prev` pointers.
* Keep track of the node before the reversed section.
* Keep track of the original starting node.
* Keep track of the final reversed node.
* Keep track of the node after the reversed section.
* Reconnect both sides after reversal.
* Update `head` when reversing from index `0`.
* Update `tail` when reversing through the last index.
* The solution runs in **O(n)** time and **O(1)** extra space.

---

## 📌 Interview Tip

The easiest way to solve **Reverse Between** is to divide the problem into three stages:

```text
Find

↓

Reverse

↓

Reconnect
```

Remember these four important pointers:

```text
beforeStart

startNode

endNode

afterEnd
```

Before:

```text
beforeStart ⇄ startNode ⇄ ... ⇄ endNode ⇄ afterEnd
```

After:

```text
beforeStart ⇄ endNode ⇄ ... ⇄ startNode ⇄ afterEnd
```

The core pattern is:

```text
Save Next Node

↓

Reverse next and prev

↓

Move Forward Using Saved Node

↓

Reconnect Left Side

↓

Reconnect Right Side

↓

Update Head or Tail if Needed
```

---


