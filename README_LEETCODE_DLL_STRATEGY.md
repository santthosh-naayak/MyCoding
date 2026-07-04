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

