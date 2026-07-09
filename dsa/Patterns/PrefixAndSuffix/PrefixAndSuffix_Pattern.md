# Problem #19: Product of Array Except Self

**Difficulty:** Medium
**Category:** Arrays / Prefix
**Pattern:** Prefix + Suffix
**Technique:** Precomputation
**Optimal Approach:** Prefix Products + Suffix Product
**Time Complexity:** `O(n)`
**Extra Space Complexity:** `O(1)` excluding the output array

---

# Problem Statement

Given an integer array `nums`, return an array `answer` such that:

```text
answer[i]
```

is equal to the product of all the elements of `nums` except `nums[i]`.

The solution must run in `O(n)` time and must not use division.

---

# Example 1

```text
Input:

nums = [1, 2, 3, 4]
```

```text
Output:

[24, 12, 8, 6]
```

## Explanation

For index `0`:

```text
Current Number:

1

Exclude 1:

2 × 3 × 4

=

24
```

Therefore:

```text
answer[0] = 24
```

For index `1`:

```text
Current Number:

2

Exclude 2:

1 × 3 × 4

=

12
```

Therefore:

```text
answer[1] = 12
```

For index `2`:

```text
Current Number:

3

Exclude 3:

1 × 2 × 4

=

8
```

Therefore:

```text
answer[2] = 8
```

For index `3`:

```text
Current Number:

4

Exclude 4:

1 × 2 × 3

=

6
```

Therefore:

```text
answer[3] = 6
```

Final result:

```text
[24, 12, 8, 6]
```

---

# Problem Classification

```text
PROBLEM
   │
   ▼
Problem #19:
Product of Array Except Self


DIFFICULTY
   │
   ▼
Medium


CATEGORY
   │
   ▼
Arrays / Prefix


PATTERN
   │
   ▼
Prefix + Suffix


TECHNIQUE
   │
   ▼
Precomputation


OPTIMAL APPROACH
   │
   ▼
Store Prefix Products
in Output Array

+

Use One Variable
for Suffix Product


CORE LOGIC
   │
   ▼
Product Before Current

×

Product After Current

=

Product Except Current
```

---

# Connection to Previous Problems

We are learning problems pattern by pattern.

So far:

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
Prefix
+
Suffix
+
Precomputation
```

The important progression is:

```text
Two Sum
   ↓
Avoid Repeated Searching


Group Anagrams
   ↓
Avoid Repeated Comparison


Top K Frequent Elements
   ↓
Avoid Repeated Counting


Product of Array Except Self
   ↓
Avoid Repeated Calculation
```

The larger interview lesson is:

```text
BRUTE FORCE
     ↓
Find Repeated Work
     ↓
Ask How to Avoid It
     ↓
Choose the Correct
Data Structure or Pattern
     ↓
OPTIMIZE
```

---

# Topics and Subtopics Covered

```text
Product of Array Except Self
              │
              ├── Arrays
              │
              ├── Array Traversal
              │
              ├── Nested Loops
              │
              ├── Sequential Loops
              │
              ├── Conditions
              │     └── Skip Current Index
              │
              ├── Precomputation
              │
              ├── Prefix
              │
              │     └── Left Product
              │
              ├── Suffix
              │
              │     └── Right Product
              │
              ├── Forward Traversal
              │
              ├── Reverse Traversal
              │
              ├── In-Place Optimization
              │
              ├── Auxiliary Space
              │
              └── Big O Analysis
```

---

# Beginner Thinking

Given:

```text
nums = [1, 2, 3, 4]
```

We need:

```text
answer = [24, 12, 8, 6]
```

The first question is:

```text
What do I need
for every position?
```

For index `0`:

```text
Everything Except nums[0]
```

For index `1`:

```text
Everything Except nums[1]
```

For index `2`:

```text
Everything Except nums[2]
```

For index `3`:

```text
Everything Except nums[3]
```

The simplest idea is:

```text
Choose One Position
        ↓
Visit Every Number
        ↓
Is This the Current Position?
       /                  \
     YES                   NO
      ↓                     ↓
    SKIP                 MULTIPLY
```

This gives us the brute-force approach.

---

# Approach 1: Brute Force

For every position:

```text
Choose Current Index
        ↓
Visit Entire Array
        ↓
Skip Current Index
        ↓
Multiply Everything Else
        ↓
Store Answer
```

Example:

```text
nums = [1, 2, 3, 4]
```

For:

```text
i = 0
```

Calculate:

```text
2 × 3 × 4

=

24
```

For:

```text
i = 1
```

Calculate:

```text
1 × 3 × 4

=

12
```

For:

```text
i = 2
```

Calculate:

```text
1 × 2 × 4

=

8
```

For:

```text
i = 3
```

Calculate:

```text
1 × 2 × 3

=

6
```

Final result:

```text
[24, 12, 8, 6]
```

---

# Brute-Force Java Code

```java
class Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int product = 1;

            for (int j = 0; j < nums.length; j++) {

                if (i != j) {

                    product = product * nums[j];
                }
            }

            answer[i] = product;
        }

        return answer;
    }
}
```

---

# Understanding the Outer Loop

```java
for (int i = 0; i < nums.length; i++)
```

The outer loop chooses:

```text
Which answer position
am I currently calculating?
```

For:

```text
nums = [1, 2, 3, 4]
```

The outer loop runs:

```text
i = 0

i = 1

i = 2

i = 3
```

Therefore:

```text
OUTER LOOP
     ↓
Choose Current Position
```

---

# Understanding the Inner Loop

```java
for (int j = 0; j < nums.length; j++)
```

The inner loop visits every number.

Therefore:

```text
INNER LOOP
     ↓
Visit Every Element
     ↓
Calculate Product
```

---

# Why Do We Need the Condition?

```java
if (i != j)
```

Suppose:

```text
i = 2
```

The current element is:

```text
nums[2] = 3
```

The inner loop visits:

```text
j = 0

j = 1

j = 2

j = 3
```

We need:

```text
j = 0 → Multiply 1

j = 1 → Multiply 2

j = 2 → Skip 3

j = 3 → Multiply 4
```

Therefore:

```java
if (i != j)
```

means:

```text
Is This NOT
the Current Position?
        ↓
YES
        ↓
Multiply
```

The current position must be excluded.

---

# Why Is Brute Force `O(n²)`?

The outer loop runs:

```text
n times
```

For every outer-loop iteration, the inner loop also runs:

```text
n times
```

Therefore:

```text
n × n
```

equals:

```text
O(n²)
```

Visualize:

```text
OUTER LOOP
    ↓
   O(n)

     ×

INNER LOOP
    ↓
   O(n)

     =

   O(n²)
```

---

# What Is the Problem With Brute Force?

Look at the calculations:

```text
Index 0:

2 × 3 × 4


Index 1:

1 × 3 × 4


Index 2:

1 × 2 × 4


Index 3:

1 × 2 × 3
```

Notice that many calculations are repeated.

For example:

```text
1 × 2
```

is useful for multiple positions.

Also:

```text
3 × 4
```

is useful for multiple positions.

Therefore, the main problem is:

```text
REPEATED CALCULATION
```

So we ask:

```text
Can I calculate useful information once
and reuse it later?
```

The answer is:

```text
YES
```

This leads us to:

```text
PRECOMPUTATION
```

---

# What Is Precomputation?

Precomputation means:

```text
Calculate Information Once
        ↓
Store or Maintain It
        ↓
Reuse It Later
        ↓
Avoid Repeated Work
```

For this problem, instead of repeatedly calculating products, we calculate:

```text
Product Before Current Position

and

Product After Current Position
```

This gives us the:

```text
PREFIX + SUFFIX PATTERN
```

---

# Most Important Observation

For every index:

```text
answer[i]
```

we need:

```text
Product of Everything
Before Current Position

×

Product of Everything
After Current Position
```

Therefore:

```text
ANSWER

=

LEFT PRODUCT

×

RIGHT PRODUCT
```

Or:

```text
answer[i]

=

product before i

×

product after i
```

This is the heart of the entire problem.

---

# Visual Understanding

Consider:

```text
nums = [1, 2, 3, 4]
```

Suppose the current position is:

```text
nums[2] = 3
```

Visualize:

```text
[  1, 2  ]    [ 3 ]    [  4  ]

    LEFT      CURRENT     RIGHT
```

We must exclude:

```text
CURRENT
```

Therefore:

```text
LEFT PRODUCT

=

1 × 2

=

2
```

And:

```text
RIGHT PRODUCT

=

4
```

Then:

```text
ANSWER

=

LEFT × RIGHT

=

2 × 4

=

8
```

Therefore:

```text
answer[2] = 8
```

---

# Pattern: Prefix + Suffix

The reusable pattern is:

```text
CURRENT POSITION
       │
       ▼

[ EVERYTHING BEFORE ]

          ×

[ EVERYTHING AFTER ]

          │
          ▼

        ANSWER
```

The core formula is:

```text
answer[i]

=

prefix[i]

×

suffix[i]
```

---

# What Is a Prefix?

A prefix means:

```text
Information accumulated
from the beginning
toward the current position.
```

For this problem:

```text
PREFIX

=

Product of Everything
Before Current Position
```

Consider:

```text
nums = [1, 2, 3, 4]
```

For index `0`:

```text
Nothing Before 1

Product = 1
```

For index `1`:

```text
Before 2:

1

Product = 1
```

For index `2`:

```text
Before 3:

1 × 2

Product = 2
```

For index `3`:

```text
Before 4:

1 × 2 × 3

Product = 6
```

Therefore:

```text
PREFIX PRODUCTS

[1, 1, 2, 6]
```

---

# Why Does the First Prefix Start With `1`?

For index `0`, there is nothing on the left.

Therefore:

```text
Product of Nothing
```

is represented by:

```text
1
```

Why?

Because `1` is the identity value for multiplication.

```text
1 × Number

=

Number
```

Examples:

```text
1 × 5 = 5

1 × 10 = 10

1 × 100 = 100
```

Therefore:

```java
answer[0] = 1;
```

---

# What Is a Suffix?

A suffix means:

```text
Information accumulated
from the end
toward the current position.
```

For this problem:

```text
SUFFIX

=

Product of Everything
After Current Position
```

Consider:

```text
nums = [1, 2, 3, 4]
```

For index `0`:

```text
After 1:

2 × 3 × 4

=

24
```

For index `1`:

```text
After 2:

3 × 4

=

12
```

For index `2`:

```text
After 3:

4

=

4
```

For index `3`:

```text
Nothing After 4

Product = 1
```

Therefore:

```text
SUFFIX PRODUCTS

[24, 12, 4, 1]
```

---

# Combining Prefix and Suffix

Now:

```text
INDEX

       0    1    2    3


NUMS

       1    2    3    4


PREFIX

       1    1    2    6


SUFFIX

      24   12    4    1
```

Multiply prefix and suffix.

For index `0`:

```text
1 × 24

=

24
```

For index `1`:

```text
1 × 12

=

12
```

For index `2`:

```text
2 × 4

=

8
```

For index `3`:

```text
6 × 1

=

6
```

Final answer:

```text
[24, 12, 8, 6]
```

---

# Approach 2: Prefix and Suffix Arrays

One optimized approach is to create:

```java
int[] prefix;
```

and:

```java
int[] suffix;
```

Then calculate:

```text
answer[i]

=

prefix[i]

×

suffix[i]
```

This gives:

```text
Time Complexity:

O(n)
```

But we use additional arrays.

Therefore:

```text
Extra Space:

O(n)
```

We can optimize the space further.

---

# Optimal Approach

Instead of creating separate:

```text
prefix array

and

suffix array
```

we use:

```text
OUTPUT ARRAY
```

to store the prefix products.

Then we use:

```text
ONE VARIABLE
```

to maintain the suffix product.

The strategy is:

```text
PASS 1
   ↓
LEFT → RIGHT
   ↓
Store Prefix Products
Inside Answer Array


PASS 2
   ↓
RIGHT → LEFT
   ↓
Maintain Suffix Product
Using One Variable


FINAL
   ↓
Prefix × Suffix
```

---

# Optimal Java Solution

```java
class Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        answer[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int suffix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            answer[i] = answer[i] * suffix;

            suffix = suffix * nums[i];
        }

        return answer;
    }
}
```

---

# Complete Algorithm

```text
START
  ↓
Create Answer Array
  ↓
Set answer[0] = 1
  ↓
Traverse Left → Right
  ↓
Calculate Product Before Current
  ↓
Store Prefix Product in Answer
  ↓
Create suffix = 1
  ↓
Traverse Right → Left
  ↓
Multiply Answer by Current Suffix
  ↓
Update Suffix
  ↓
Continue Until Beginning
  ↓
Return Answer
```

---

# Understanding the First Pass

Code:

```java
answer[0] = 1;

for (int i = 1; i < nums.length; i++) {

    answer[i] = answer[i - 1] * nums[i - 1];
}
```

The purpose of this loop is:

```text
For Every Position

Store the Product of Everything
Before the Current Position
```

Given:

```text
nums = [1, 2, 3, 4]
```

Initially:

```text
answer = [1, 0, 0, 0]
```

---

# First Pass Dry Run

## Iteration 1

```text
i = 1
```

Code:

```java
answer[i] = answer[i - 1] * nums[i - 1];
```

Substitute `i = 1`:

```text
answer[1]

=

answer[0]

×

nums[0]
```

Values:

```text
1 × 1
```

Result:

```text
1
```

Answer array:

```text
[1, 1, 0, 0]
```

---

## Iteration 2

```text
i = 2
```

Substitute:

```text
answer[2]

=

answer[1]

×

nums[1]
```

Values:

```text
1 × 2
```

Result:

```text
2
```

Answer:

```text
[1, 1, 2, 0]
```

---

## Iteration 3

```text
i = 3
```

Substitute:

```text
answer[3]

=

answer[2]

×

nums[2]
```

Values:

```text
2 × 3
```

Result:

```text
6
```

Answer:

```text
[1, 1, 2, 6]
```

After the first pass:

```text
answer = [1, 1, 2, 6]
```

This means:

```text
INDEX 0:

Product Before Index 0

=

1


INDEX 1:

Product Before Index 1

=

1


INDEX 2:

Product Before Index 2

=

1 × 2

=

2


INDEX 3:

Product Before Index 3

=

1 × 2 × 3

=

6
```

---

# Why Does This Formula Work?

The formula is:

```java
answer[i] = answer[i - 1] * nums[i - 1];
```

This is one of the most important lines in the problem.

Suppose:

```text
i = 3
```

We want:

```text
Product of Everything
Before Index 3
```

The array is:

```text
[1, 2, 3, 4]
          ↑
        index 3
```

Everything before index `3` is:

```text
1 × 2 × 3
```

We already know:

```text
answer[2]
```

contains:

```text
Product Before Index 2
```

which is:

```text
1 × 2
```

Now multiply:

```text
answer[2]

×

nums[2]
```

Therefore:

```text
(1 × 2) × 3

=

1 × 2 × 3
```

So:

```java
answer[i - 1]
```

means:

```text
Product Already Calculated
Before Previous Position
```

And:

```java
nums[i - 1]
```

means:

```text
Previous Number
```

Together:

```text
Previous Prefix Product

×

Previous Number

=

Current Prefix Product
```

This is the core prefix logic.

---

# Understanding the Second Pass

After the first pass:

```text
answer = [1, 1, 2, 6]
```

Now create:

```java
int suffix = 1;
```

The purpose of `suffix` is:

```text
Maintain the Product
of Everything
After the Current Position
```

Then:

```java
for (int i = nums.length - 1; i >= 0; i--)
```

This traverses:

```text
RIGHT → LEFT
```

For every position:

```java
answer[i] = answer[i] * suffix;
```

Then:

```java
suffix = suffix * nums[i];
```

---

# Second Pass Dry Run

After the prefix pass:

```text
answer = [1, 1, 2, 6]
```

Start:

```text
suffix = 1
```

---

## Iteration 1

```text
i = 3
```

Current:

```text
nums[3] = 4
```

Current answer:

```text
answer[3] = 6
```

Current suffix:

```text
1
```

Calculate:

```text
answer[3]

=

6 × 1

=

6
```

Then update:

```text
suffix

=

1 × 4

=

4
```

Current state:

```text
answer = [1, 1, 2, 6]

suffix = 4
```

---

## Iteration 2

```text
i = 2
```

Current:

```text
answer[2] = 2
```

Current suffix:

```text
4
```

Calculate:

```text
answer[2]

=

2 × 4

=

8
```

Update:

```text
suffix

=

4 × 3

=

12
```

Current state:

```text
answer = [1, 1, 8, 6]

suffix = 12
```

---

## Iteration 3

```text
i = 1
```

Current:

```text
answer[1] = 1
```

Current suffix:

```text
12
```

Calculate:

```text
answer[1]

=

1 × 12

=

12
```

Update:

```text
suffix

=

12 × 2

=

24
```

Current state:

```text
answer = [1, 12, 8, 6]

suffix = 24
```

---

## Iteration 4

```text
i = 0
```

Current:

```text
answer[0] = 1
```

Current suffix:

```text
24
```

Calculate:

```text
answer[0]

=

1 × 24

=

24
```

Update:

```text
suffix

=

24 × 1

=

24
```

Final answer:

```text
[24, 12, 8, 6]
```

---

# Why Do We Update `suffix` After Calculating `answer[i]`?

This is extremely important.

Suppose:

```text
i = 2
```

Current number:

```text
nums[2] = 3
```

Before processing index `2`:

```text
suffix = 4
```

That represents:

```text
Everything After 3
```

This is exactly what we need.

Therefore, first:

```java
answer[i] = answer[i] * suffix;
```

Then:

```java
suffix = suffix * nums[i];
```

The order is:

```text
USE CURRENT SUFFIX
        ↓
CALCULATE ANSWER
        ↓
ADD CURRENT NUMBER
TO SUFFIX
```

Why?

Because the current number must be excluded from its own answer.

If we updated `suffix` first:

```text
suffix = suffix × nums[i]
```

then the suffix would include the current number.

That would break the rule:

```text
PRODUCT EXCEPT SELF
```

Therefore:

```text
CALCULATE FIRST

UPDATE SECOND
```

---

# Why Do We Traverse Twice?

First traversal:

```text
LEFT → RIGHT
```

Purpose:

```text
Calculate Everything
Before Current Position
```

Second traversal:

```text
RIGHT → LEFT
```

Purpose:

```text
Calculate Everything
After Current Position
```

Therefore:

```text
FIRST PASS

BEFORE ME


SECOND PASS

AFTER ME


COMBINE

EVERYTHING EXCEPT ME
```

---

# Why Are Two Loops Still `O(n)`?

First loop:

```text
O(n)
```

Second loop:

```text
O(n)
```

They are sequential loops.

Therefore:

```text
O(n) + O(n)
```

equals:

```text
O(2n)
```

Big O removes constants.

Therefore:

```text
O(n)
```

Remember:

```text
SEQUENTIAL LOOPS

O(n) + O(n)

=

O(n)
```

But:

```text
NESTED LOOPS

O(n) × O(n)

=

O(n²)
```

---

# Time Complexity

## First Pass

```text
O(n)
```

## Second Pass

```text
O(n)
```

Total:

```text
O(n) + O(n)
```

which becomes:

```text
O(2n)
```

Big O removes constants.

Therefore:

```text
Time Complexity:

O(n)
```

---

# Space Complexity

We create:

```java
int[] answer
```

But the problem requires us to return the output array.

Therefore, interview complexity analysis usually excludes the output array from auxiliary space.

Apart from the answer array, we only create:

```java
int suffix
```

One integer uses constant extra space.

Therefore:

```text
Extra Space Complexity:

O(1)
```

If the output array is counted:

```text
Total Space Complexity:

O(n)
```

---

# Brute Force vs Optimal Approach

| Approach                  | Strategy                                           | Time Complexity |             Extra Space |
| ------------------------- | -------------------------------------------------- | --------------: | ----------------------: |
| Brute Force               | Recalculate product for every position             |         `O(n²)` | `O(1)` excluding output |
| Prefix + Suffix Arrays    | Store separate left and right products             |          `O(n)` |                  `O(n)` |
| Optimized Prefix + Suffix | Store prefix in output and use one suffix variable |          `O(n)` | `O(1)` excluding output |

---

# Pattern Recognition

When you see problems involving:

```text
Everything Before Current

Everything After Current

Everything Except Current

Repeated Left Calculations

Repeated Right Calculations

Range Products

Range Sums
```

ask:

```text
Am I repeatedly calculating
information from the left?
        ↓
YES


Am I repeatedly calculating
information from the right?
        ↓
YES


Can I calculate it once
and reuse it?
        ↓
YES


THINK:

PREFIX + SUFFIX
```

---

# Interview Explanation

The brute-force solution calculates the product of all other elements for every index, which requires nested loops and takes `O(n²)` time.

The repeated work can be avoided by observing that the answer for every position is the product of everything before that position multiplied by the product of everything after that position.

First, I traverse from left to right and store the prefix product directly in the output array.

Then, I traverse from right to left while maintaining a suffix product in one variable.

At every index, I multiply the prefix product already stored in the output array by the current suffix product.

After calculating the answer for the current index, I update the suffix to include the current number.

This order is important because the current element must not be included in its own answer.

The algorithm uses two sequential traversals, so the time complexity is `O(n)`.

The auxiliary space complexity is `O(1)` when the required output array is excluded.

---

# Short Interview Revision Notes

```text
PROBLEM:

Problem #19:
Product of Array Except Self


DIFFICULTY:

Medium


CATEGORY:

Arrays / Prefix


PATTERN:

Prefix + Suffix


TECHNIQUE:

Precomputation


PROBLEM:

For every position,
return the product
of all other elements.


BRUTE FORCE:

For Every Position
        ↓
Visit Every Number
        ↓
Skip Current Position
        ↓
Multiply Everything Else


BRUTE FORCE TIME:

O(n²)


PROBLEM WITH BRUTE FORCE:

Repeated Calculation


OPTIMIZATION QUESTION:

Can I calculate useful information
once and reuse it?


ANSWER:

YES


TECHNIQUE:

Precomputation


CORE OBSERVATION:

Everything Except Current

=

Everything Before Current

×

Everything After Current


PREFIX:

Product of Everything
Before Current Position


SUFFIX:

Product of Everything
After Current Position


CORE FORMULA:

answer[i]

=

prefix

×

suffix


FIRST PASS:

LEFT → RIGHT

Store Prefix Products
Inside Answer Array


PREFIX FORMULA:

answer[i]

=

answer[i - 1]

×

nums[i - 1]


WHY?

Previous Prefix

×

Previous Number

=

Current Prefix


SECOND PASS:

RIGHT → LEFT

Maintain Suffix Product
Using One Variable


SECOND PASS FORMULA:

answer[i]

=

answer[i]

×

suffix


THEN:

suffix

=

suffix

×

nums[i]


IMPORTANT ORDER:

Calculate Answer First

Then Update Suffix


WHY?

Current Element
Must Be Excluded


WHY TWO LOOPS?

First Loop:

Everything Before Me


Second Loop:

Everything After Me


SEQUENTIAL LOOPS:

O(n) + O(n)

=

O(n)


NESTED LOOPS:

O(n) × O(n)

=

O(n²)


TIME COMPLEXITY:

O(n)


EXTRA SPACE:

O(1)

excluding output array


CONNECTION TO PREVIOUS PROBLEMS:

Problem #1: Two Sum

Avoid Repeated Searching


Problem #12: Group Anagrams

Avoid Repeated Comparison


Problem #16: Top K Frequent Elements

Avoid Repeated Counting


Problem #19:
Product of Array Except Self

Avoid Repeated Calculation


MAIN INTERVIEW LESSON:

When the answer for every position
depends on information before it
and information after it,

think:

PREFIX + SUFFIX


MOST IMPORTANT SENTENCE:

Everything Except Me

=

Everything Before Me

×

Everything After Me
```

---

# Final Pattern Summary

```text
Problem #1: Two Sum

Problem:
Repeated Searching

Pattern:
HashMap Lookup


        ↓


Problem #12: Group Anagrams

Problem:
Repeated Comparison

Pattern:
Canonical Representation
+
HashMap Grouping


        ↓


Problem #16: Top K Frequent Elements

Problem:
Repeated Counting

Pattern:
Frequency Counting
+
Bucket Sort


        ↓


Problem #19:
Product of Array Except Self

Problem:
Repeated Calculation

Pattern:
Prefix
+
Suffix
+
Precomputation
```
