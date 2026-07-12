# Problem #5: Validate Binary Search Tree

## DSA Interview Preparation — Pattern-Wise Learning

| No. | Problem                     | Difficulty | Category    | Pattern                                |
| --- | --------------------------- | ---------- | ----------- | -------------------------------------- |
| 5   | Validate Binary Search Tree | Medium     | Trees / BST | DFS + Recursion + Valid Range / Bounds |

---

We are learning problems in a way that helps us understand:

```text
DATA STRUCTURE

        ↓

CORE CONCEPT

        ↓

PATTERN

        ↓

ALGORITHM / STRATEGY

        ↓

WHY THE STRATEGY WORKS

        ↓

JAVA IMPLEMENTATION

        ↓

TIME & SPACE COMPLEXITY

        ↓

PATTERN RECOGNITION

        ↓

INTERVIEW EXPLANATION
```

For this problem:

```text
PROBLEM #5

Validate Binary Search Tree

        ↓

DATA STRUCTURE

Tree / Binary Tree / BST

        ↓

TRAVERSAL STRATEGY

DFS

        ↓

IMPLEMENTATION TECHNIQUE

Recursion

        ↓

CORE PROBLEM

A Node must follow rules
created by all its ancestors

        ↓

STRATEGY

Carry Valid Minimum
and Maximum Bounds

        ↓

PATTERN

DFS + Recursion + Valid Range / Bounds

        ↓

OPTIMAL COMPLEXITY

O(n) Time
O(h) Space
```

---

# Complete Learning Flow Followed

We learned this problem in the following order:

```text
1. What is a Tree?

        ↓

2. What is a Binary Tree?

        ↓

3. Understand TreeNode

        ↓

4. What are root, parent, child, leaf, and subtree?

        ↓

5. What is a Binary Search Tree (BST)?

        ↓

6. What are we trying to return?

        ↓

7. Real-world example

        ↓

8. Brute-force thinking

        ↓

9. Common wrong approach:
   checking only immediate left and right children

        ↓

10. Why that approach fails

        ↓

11. Understand the Valid Range / Bounds idea

        ↓

12. Why the left subtree gets an upper bound

        ↓

13. Why the right subtree gets a lower bound

        ↓

14. What is DFS?

        ↓

15. What is recursion?

        ↓

16. Why recursion fits Trees naturally

        ↓

17. Understand the recursive call stack

        ↓

18. Base case:
    why null returns true

        ↓

19. Invalid condition:
    why value <= min or value >= max returns false

        ↓

20. Optimal Java solution

        ↓

21. Explain every line and every condition

        ↓

22. Complete dry run

        ↓

23. Big O analysis

        ↓

24. Pattern recognition

        ↓

25. Google interview explanation
```

---

# 1. Problem Statement

Given the root of a Binary Tree, determine whether it is a valid Binary Search Tree.

A valid BST follows these rules:

1. Every Node in the left subtree must have a value strictly smaller than the current Node.
2. Every Node in the right subtree must have a value strictly greater than the current Node.
3. The left and right subtrees must also be valid Binary Search Trees.

---

# Example 1

```text
Input:

root = [2,1,3]
```

Tree:

```text
        2
       / \
      1   3
```

Output:

```text
true
```

Why?

```text
1 < 2 < 3
```

The entire Tree follows the BST rules.

---

# Example 2

```text
Input:

root = [5,1,4,null,null,3,6]
```

Tree:

```text
        5
       / \
      1   4
         / \
        3   6
```

Output:

```text
false
```

Why?

Node `4` is inside the right subtree of `5`.

Therefore:

```text
4 > 5
```

must be true.

But:

```text
4 < 5
```

Therefore, the Tree is not a valid BST.

---

# 2. What Are We Trying to Return?

The method is:

```java
public boolean isValidBST(TreeNode root)
```

The return type is:

```text
boolean
```

Therefore, we return:

```text
true
```

if the entire Tree is a valid BST.

Otherwise:

```text
false
```

The computer must answer one question:

```text
DOES EVERY NODE
IN THE ENTIRE TREE
FOLLOW THE BST RULES?

        ↓

YES → true

NO → false
```

If even one Node violates the rule:

```text
return false
```

---

# 3. What Is a Tree?

A Tree is a collection of Nodes connected in a hierarchical structure.

A Linked List grows in one direction:

```text
10 → 20 → 30 → 40
```

A Tree can branch:

```text
              10
             /  \
            5    20
           / \   / \
          2   7 15  30
```

The main idea is:

```text
TREE

=

NODES CONNECTED
IN A HIERARCHICAL STRUCTURE
```

---

# 4. What Is a Binary Tree?

The word:

```text
Binary
```

means:

```text
Two
```

A Binary Tree is a Tree where each Node can have at most two children.

They are called:

```text
LEFT CHILD

and

RIGHT CHILD
```

A Node can have:

```text
0 Children

1 Child

or

2 Children
```

Example:

```text
        10
       /  \
      5    20
```

---

# 5. Understanding TreeNode

LeetCode provides:

```java
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;
}
```

A TreeNode contains:

```text
VALUE

+

LEFT CHILD REFERENCE

+

RIGHT CHILD REFERENCE
```

Example:

```text
        10
       /  \
      5    20
```

Node `10` contains:

```text
val   = 10

left  = Node 5

right = Node 20
```

---

# Connection With Linked List

A Linked List Node:

```java
class Node {

    int value;

    Node next;
}
```

Contains:

```text
VALUE

+

NEXT REFERENCE
```

A TreeNode:

```java
class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;
}
```

Contains:

```text
VALUE

+

LEFT REFERENCE

+

RIGHT REFERENCE
```

Therefore:

```text
LINKED LIST

Node → One Direction


BINARY TREE

Node → Two Possible Directions
```

---

# 6. Important Tree Terminology

Consider:

```text
              10
             /  \
            5    20
           / \   / \
          2   7 15  30
```

## Root

The topmost Node.

```text
10
```

is the Root.

---

## Parent

A Node that has children.

```text
10
```

is the Parent of:

```text
5 and 20
```

---

## Child

A Node connected below another Node.

```text
5
```

is the left child of `10`.

```text
20
```

is the right child of `10`.

---

## Leaf Node

A Node with no children.

In the above Tree:

```text
2

7

15

30
```

are Leaf Nodes.

For a Leaf Node:

```text
left = null

right = null
```

---

## Subtree

A smaller Tree inside a larger Tree.

For example:

```text
        5
       / \
      2   7
```

is the left subtree of `10`.

This concept is extremely important for Validate BST.

---

# 7. What Is a Binary Search Tree?

A Binary Search Tree is a Binary Tree with an additional ordering rule.

The simplified rule is:

```text
LEFT

<

NODE

<

RIGHT
```

But the complete rule is:

```text
EVERY NODE
IN THE LEFT SUBTREE

<

CURRENT NODE

<

EVERY NODE
IN THE RIGHT SUBTREE
```

This is the most important difference.

---

# 8. Real-World Example — Warehouse Package Sorting

Imagine packages are organized based on their Package ID.

Rule:

```text
SMALLER PACKAGE ID

↓

GO LEFT


LARGER PACKAGE ID

↓

GO RIGHT
```

Suppose:

```text
        50
       /  \
      30   70
```

Now Package `40` arrives.

First:

```text
40 < 50
```

Go left.

Then:

```text
40 > 30
```

Go right.

Result:

```text
        50
       /  \
      30   70
        \
         40
```

Package `40` must satisfy:

```text
40 > 30
```

because it is right of `30`.

But it must also satisfy:

```text
40 < 50
```

because it is still inside the left subtree of `50`.

Therefore:

```text
30 < 40 < 50
```

The Node must remember all important restrictions created by its ancestors.

This leads to:

```text
VALID RANGE / BOUNDS
```

---

# 9. Brute-Force Thinking

One possible approach is:

For every Node:

```text
FIND MAXIMUM VALUE
IN LEFT SUBTREE

        ↓

CHECK:

LEFT MAX < CURRENT NODE

        ↓

FIND MINIMUM VALUE
IN RIGHT SUBTREE

        ↓

CHECK:

CURRENT NODE < RIGHT MIN

        ↓

REPEAT FOR EVERY NODE
```

This can work.

However, the same Nodes may be visited repeatedly.

In the worst case:

```text
O(n²)
```

Time Complexity.

---

# 10. Common Wrong Approach

A beginner may check only the immediate children:

```java
if (root.left != null && root.left.val >= root.val) {
    return false;
}

if (root.right != null && root.right.val <= root.val) {
    return false;
}
```

Then recursively check the children.

This approach is incorrect.

---

# 11. Why Does the Immediate-Child Approach Fail?

Consider:

```text
        10
       /  \
      5    15
          /  \
         6    20
```

Immediate comparisons:

```text
5 < 10

Correct
```

```text
15 > 10

Correct
```

```text
6 < 15

Correct
```

```text
20 > 15

Correct
```

Everything appears correct.

But Node `6` is inside:

```text
RIGHT SUBTREE OF 10
```

Therefore:

```text
6 > 10
```

must also be true.

It is not.

Therefore:

```text
INVALID BST
```

The problem is:

```text
CHECKING ONLY THE PARENT

↓

FORGETS ANCESTOR RULES
```

---

# 12. Core Problem

We need to answer:

```text
HOW CAN A NODE REMEMBER
THE RULES CREATED
BY ALL ITS ANCESTORS?
```

Answer:

```text
VALID RANGE / BOUNDS
```

---

# 13. What Are Bounds?

A Bound is simply a limit.

Example:

```text
Age must be between:

18 and 60
```

Then:

```text
Minimum Bound = 18

Maximum Bound = 60
```

Valid Range:

```text
18 < Age < 60
```

For every Tree Node:

```text
min < node.val < max
```

must be true.

---

# 14. Root's Initial Bounds

The Root has no ancestors.

Therefore, initially:

```text
MIN = -∞

MAX = +∞
```

So:

```text
-∞ < ROOT < +∞
```

In Java:

```java
validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
```

---

# 15. Why Going Left Updates the Maximum Bound

Consider:

```text
        10
       /
      5
```

The Root starts with:

```text
(-∞, +∞)
```

Go left.

Everything must now be smaller than `10`.

New Range:

```text
(-∞, 10)
```

Therefore:

```text
GO LEFT

↓

KEEP MIN

↓

UPDATE MAX
```

Code:

```java
validate(node.left, min, node.val)
```

---

# 16. Why Going Right Updates the Minimum Bound

Consider:

```text
10
  \
   20
```

Root Range:

```text
(-∞, +∞)
```

Go right.

Everything must now be greater than `10`.

New Range:

```text
(10, +∞)
```

Therefore:

```text
GO RIGHT

↓

UPDATE MIN

↓

KEEP MAX
```

Code:

```java
validate(node.right, node.val, max)
```

---

# 17. What Is DFS?

DFS means:

```text
Depth-First Search
```

DFS goes as deep as possible into one path before returning.

Example:

```text
        10
       /  \
      5    15
     / \
    2   7
```

Conceptual traversal:

```text
10

↓

5

↓

2

↓

null

↓

BACK

↓

null

↓

BACK

↓

7

↓

...

↓

BACK TO 10

↓

15
```

The idea is:

```text
GO DEEP

↓

GO DEEPER

↓

REACH THE END

↓

COME BACK

↓

TRY ANOTHER PATH
```

---

# 18. Why Do We Use DFS?

We need to visit every Node.

For every Node:

```text
CHECK CURRENT NODE

↓

GO TO LEFT SUBTREE

↓

GO TO RIGHT SUBTREE
```

DFS naturally allows us to travel through the entire Tree.

---

# 19. What Is Recursion?

Recursion means:

```text
A METHOD CALLS ITSELF
```

Our method:

```java
validate()
```

calls:

```java
validate(node.left, ...)
```

and:

```java
validate(node.right, ...)
```

Therefore:

```text
validate()

↓

calls validate()

↓

which calls validate()

↓

which calls validate()
```

This is Recursion.

---

# 20. Why Does Recursion Fit Trees?

A Tree contains:

```text
CURRENT NODE

+

LEFT SUBTREE

+

RIGHT SUBTREE
```

The left subtree is itself another Tree.

The right subtree is also another Tree.

Therefore:

```text
VALIDATE BIG TREE

↓

VALIDATE CURRENT NODE

↓

VALIDATE SMALLER LEFT TREE

↓

VALIDATE SMALLER RIGHT TREE
```

The same logic is repeated on smaller Trees.

That is exactly what recursion is useful for.

---

# 21. Understanding the Recursive Call Stack

Consider:

```text
        10
       /
      5
     /
    2
```

Calls:

```text
validate(10)

↓

validate(5)

↓

validate(2)

↓

validate(null)
```

The Call Stack remembers:

```text
validate(10)

WAITING FOR

validate(5)


validate(5)

WAITING FOR

validate(2)


validate(2)

WAITING FOR

validate(null)
```

When:

```text
validate(null)
```

returns:

```text
true
```

the computer returns to:

```text
validate(2)
```

Then:

```text
validate(5)
```

Then:

```text
validate(10)
```

The Call Stack remembers where each recursive call must return.

---

# 22. Base Case

Every recursive algorithm needs a stopping condition.

Our Base Case:

```java
if (node == null) {
    return true;
}
```

Eventually DFS moves beyond a Leaf Node.

Example:

```text
        5
```

Node `5` has:

```text
left = null

right = null
```

Eventually:

```java
validate(node.left, ...)
```

becomes:

```java
validate(null, ...)
```

An empty path contains no invalid BST Node.

Therefore:

```java
return true;
```

This also prevents:

```java
node.val
```

from being accessed when `node` is `null`.

---

# 23. Invalid Condition

The valid rule is:

```text
min < node.val < max
```

Therefore, a Node is invalid when:

```text
node.val <= min
```

OR:

```text
node.val >= max
```

Code:

```java
if (node.val <= min || node.val >= max) {
    return false;
}
```

---

# 24. Why `||`?

The operator:

```java
||
```

means:

```text
OR
```

The Node is invalid if:

```text
TOO SMALL
```

OR:

```text
TOO LARGE
```

Therefore:

```java
node.val <= min || node.val >= max
```

---

# 25. Why `<=` and `>=`?

The problem requires:

```text
STRICTLY LESS

and

STRICTLY GREATER
```

Duplicates are not allowed.

Example:

```text
        10
       /
      10
```

This is invalid.

Therefore, equality must also return:

```text
false
```

---

# 26. Why Use `long`?

The Tree Node stores:

```java
int val;
```

The constraints allow:

```text
Integer.MIN_VALUE

to

Integer.MAX_VALUE
```

If the Root itself contains:

```text
Integer.MIN_VALUE
```

and we also use:

```text
Integer.MIN_VALUE
```

as the minimum bound, then:

```java
node.val <= min
```

would incorrectly return:

```text
true
```

Therefore, we use a larger data type:

```java
long
```

with:

```java
Long.MIN_VALUE

Long.MAX_VALUE
```

---

# 27. Optimal Strategy

The optimal strategy is:

```text
START AT ROOT

↓

GIVE ROOT WIDEST RANGE

(-∞, +∞)

↓

CHECK CURRENT NODE

↓

IS NODE OUTSIDE RANGE?

YES → FALSE

NO → CONTINUE

↓

GO LEFT

KEEP MIN
UPDATE MAX

↓

GO RIGHT

UPDATE MIN
KEEP MAX

↓

BOTH SUBTREES MUST BE VALID
```

---

# 28. Optimal Java Solution

```java
class Solution {

    public boolean isValidBST(TreeNode root) {

        // Start validating the root with the widest possible range
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {

        // A null node does not violate the BST rules
        if (node == null) {
            return true;
        }

        // Return false if the current node is outside its valid range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left: keep min and update max | Right: update min and keep max
        return validate(node.left, min, node.val)
                && validate(node.right, node.val, max);
    }
}
```

---

# 29. Complete Code Flow

```text
isValidBST(root)

↓

validate(root, -∞, +∞)

↓

IS NODE NULL?

YES

↓

RETURN TRUE


NO

↓

IS NODE OUTSIDE RANGE?

YES

↓

RETURN FALSE


NO

↓

VALIDATE LEFT SUBTREE

(min, current value)

↓

AND

↓

VALIDATE RIGHT SUBTREE

(current value, max)

↓

BOTH VALID?

YES → TRUE

NO → FALSE
```

---

# 30. Complete Dry Run — Invalid BST

Consider:

```text
        10
       /  \
      5    15
          /  \
         6    20
```

Start:

```text
validate(10, -∞, +∞)
```

Valid.

Go left:

```text
validate(5, -∞, 10)
```

Valid.

Go right:

```text
validate(15, 10, +∞)
```

Valid.

Now go left from `15`:

```text
validate(6, 10, 15)
```

Check:

```text
10 < 6 < 15
```

False.

Code checks:

```text
6 <= 10 || 6 >= 15
```

Result:

```text
true || false

=

true
```

Therefore:

```text
return false
```

The `false` travels back through recursion.

Final result:

```text
false
```

---

# 31. Understanding `&&`

Code:

```java
validate(node.left, min, node.val)
&&
validate(node.right, node.val, max)
```

For the complete Tree to be valid:

```text
LEFT SUBTREE

MUST BE VALID

AND

RIGHT SUBTREE

MUST BE VALID
```

Therefore:

```text
true && true

=

true
```

Any other combination returns:

```text
false
```

---

# 32. Short-Circuit Evaluation

Java evaluates `&&` from left to right.

Suppose:

```text
LEFT SUBTREE = false
```

Then:

```text
false && anything
```

must always be:

```text
false
```

Therefore, Java does not need to evaluate the right side.

This is called:

```text
SHORT-CIRCUIT EVALUATION
```

---

# 33. Big O Analysis

## Time Complexity

```text
O(n)
```

Why?

Every Node is visited at most once.

For every Node:

```text
CHECK NULL

CHECK MINIMUM

CHECK MAXIMUM

MAKE RECURSIVE CALLS
```

This is constant work per Node.

Therefore:

```text
n Nodes × O(1)

=

O(n)
```

---

## Space Complexity

```text
O(h)
```

where:

```text
h = Height of the Tree
```

Why?

Because recursion uses the Call Stack.

For a balanced Tree:

```text
O(log n)
```

For a completely skewed Tree:

```text
O(n)
```

Therefore, worst-case Space Complexity:

```text
O(n)
```

---

# 34. Approaches Comparison

| Approach                 | Strategy                                   | Correct? | Time Complexity  |
| ------------------------ | ------------------------------------------ | -------- | ---------------- |
| Immediate Child Check    | Compare only Parent with Children          | No       | —                |
| Brute Force              | Find Left Max and Right Min for Every Node | Yes      | O(n²) worst case |
| DFS + Recursion + Bounds | Carry Valid Range Through Tree             | Yes      | O(n)             |

---

# 35. Pattern Recognition

The complete pattern is:

```text
DFS

+

RECURSION

+

VALID RANGE / BOUNDS
```

Each part has a different job.

```text
DFS

↓

HOW DO WE VISIT
EVERY NODE?
```

```text
RECURSION

↓

HOW DO WE APPLY
THE SAME LOGIC
TO SMALLER SUBTREES?
```

```text
BOUNDS

↓

HOW DO WE REMEMBER
ANCESTOR RESTRICTIONS?
```

Together:

```text
DFS

↓

VISIT EVERY NODE


        +


RECURSION

↓

REPEAT THE LOGIC
ON SMALLER TREES


        +


BOUNDS

↓

CARRY ANCESTOR RULES


        =


VALIDATE BST
```

---

# 36. How to Recognize This Pattern in Future Problems

Think about this strategy when:

```text
THE INPUT IS A TREE

        ↓

YOU NEED TO VISIT
EVERY NODE

        ↓

A CHILD'S VALIDITY
DEPENDS ON INFORMATION
FROM ITS ANCESTORS

        ↓

YOU NEED TO PASS
UPDATED INFORMATION
FROM PARENT TO CHILD
```

General pattern:

```text
PROCESS CURRENT NODE

↓

PASS UPDATED INFORMATION
TO LEFT CHILD

↓

PASS UPDATED INFORMATION
TO RIGHT CHILD

↓

COMBINE RESULTS
```

---

# 37. Google Interview Explanation

A concise interview explanation:

> Checking only immediate left and right children is insufficient because a descendant can satisfy its parent's condition while violating a restriction created by an ancestor.
>
> I use DFS with recursion and carry a valid minimum and maximum range for every Node.
>
> The Root starts with the widest possible range. When moving left, the current Node's value becomes the new upper bound. When moving right, the current Node's value becomes the new lower bound.
>
> If a Node falls outside its valid range, I return false. A null Node returns true because it contains no violation. Both subtrees must be valid.
>
> Every Node is visited once, giving O(n) Time Complexity. The recursive Call Stack uses O(h) Space, where h is the height of the Tree.

---

# 38. Complete Problem-Solving Journey

```text
UNDERSTAND TREE

↓

UNDERSTAND BINARY TREE

↓

UNDERSTAND TREENODE

↓

UNDERSTAND ROOT / PARENT /
CHILD / LEAF / SUBTREE

↓

UNDERSTAND BST RULES

↓

UNDERSTAND WHAT TO RETURN

↓

THINK OF REAL-WORLD EXAMPLE

↓

TRY BRUTE FORCE

↓

IDENTIFY O(n²) PROBLEM

↓

TRY IMMEDIATE CHILD CHECK

↓

REALIZE IT IS INCORRECT

↓

WHY?

↓

DESCENDANTS CAN VIOLATE
ANCESTOR RULES

↓

NEED TO REMEMBER
ANCESTOR RESTRICTIONS

↓

USE VALID RANGE / BOUNDS

↓

NEED TO VISIT EVERY NODE

↓

USE DFS

↓

NEED TO APPLY SAME LOGIC
TO SMALLER SUBTREES

↓

USE RECURSION

↓

NEED TO STOP RECURSION

↓

BASE CASE:

node == null → true

↓

NEED TO DETECT VIOLATION

↓

node.val <= min
OR
node.val >= max

↓

GO LEFT

KEEP MIN
UPDATE MAX

↓

GO RIGHT

UPDATE MIN
KEEP MAX

↓

BOTH SIDES MUST BE VALID

↓

O(n) TIME

O(h) SPACE
```

---

# 39. Final Revision Memory Rule

```text
PROBLEM

Validate Binary Search Tree


        ↓


PATTERN

DFS + Recursion + Valid Range / Bounds


        ↓


WHY DFS?

Visit Every Node


        ↓


WHY RECURSION?

A Tree Contains
Smaller Subtrees


        ↓


WHY BOUNDS?

Remember Ancestor Rules


        ↓


ROOT

(-∞, +∞)


        ↓


INVALID CONDITION

node.val <= min

OR

node.val >= max


        ↓


GO LEFT

KEEP MIN

UPDATE MAX


        ↓


GO RIGHT

UPDATE MIN

KEEP MAX


        ↓


BASE CASE

null → true


        ↓


COMBINE RESULTS

LEFT && RIGHT


        ↓


TIME

O(n)


        ↓


SPACE

O(h)

Worst Case: O(n)
```

---

# Final One-Line Understanding

> **Use DFS and recursion to visit every Node while carrying minimum and maximum bounds so that each Node follows not only its Parent's rule but all restrictions created by its ancestors.**
