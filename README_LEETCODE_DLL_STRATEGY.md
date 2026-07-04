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

