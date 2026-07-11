# Problem #8: Trapping Rain Water

**Difficulty:** Hard
**Category:** Two Pointers / Stack
**Pattern Learned:** Opposite-Direction Two Pointers
**Related Concepts:** Arrays, Prefix/Suffix Thinking, Greedy Processing
**Optimal Time Complexity:** `O(n)`
**Optimal Space Complexity:** `O(1)`

---

# Problem Statement

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, calculate how much rainwater can be trapped after raining.

---

# Example

```text
Input:

height = [0,1,0,2,1,0,1,3,2,1,2,1]
```

```text
Output:

6
```

---

# What Are We Trying to Return?

We are trying to return:

> The total amount of rainwater trapped above all the bars.

For the example:

```text
height = [0,1,0,2,1,0,1,3,2,1,2,1]
```

the water trapped above each position is:

| Index | Wall Height | Water Above It |
| ----: | ----------: | -------------: |
|     0 |           0 |              0 |
|     1 |           1 |              0 |
|     2 |           0 |              1 |
|     3 |           2 |              0 |
|     4 |           1 |              1 |
|     5 |           0 |              2 |
|     6 |           1 |              1 |
|     7 |           3 |              0 |
|     8 |           2 |              0 |
|     9 |           1 |              1 |
|    10 |           2 |              0 |
|    11 |           1 |              0 |

Add all the trapped water:

```text
0 + 0 + 1 + 0 + 1 + 2 + 1 + 0 + 0 + 1 + 0 + 0

=

6
```

Therefore:

```text
Answer = 6
```

---

# Problem Classification

```text
PROBLEM

Problem #8:
Trapping Rain Water


        ↓


DIFFICULTY

Hard


        ↓


CATEGORY

Two Pointers / Stack


        ↓


PATTERN LEARNED

Opposite-Direction
Two Pointers


        ↓


CORE STRATEGY

Start at Both Ends

        ↓

Track Maximum Boundary
Seen From Both Sides

        ↓

Process the Shorter Side

        ↓

Update Maximum Boundary

OR

Calculate Trapped Water

        ↓

Move Pointer Inward

        ↓

Return Total Water
```

---

# Connection to Previously Learned Problems

This problem combines ideas from two previous problems.

```text
Problem #19:
Product of Array Except Self

        ↓

Prefix / Suffix Thinking

        ↓

Information From the Left

+

Information From the Right
```

and:

```text
Problem #15:
Container With Most Water

        ↓

Opposite-Direction
Two Pointers

        ↓

Start at Both Ends

        ↓

Make a Decision Based
on the Limiting Side
```

Together:

```text
PREFIX / SUFFIX THINKING

        +

OPPOSITE-DIRECTION
TWO POINTERS

        ↓

Problem #8:
Trapping Rain Water
```

---

# Topics and Subtopics Covered

```text
Trapping Rain Water
        │
        ├── Arrays
        │
        ├── Array Indices
        │
        ├── Water Level
        │
        ├── Boundary Heights
        │
        ├── Left Maximum
        │
        ├── Right Maximum
        │
        ├── Prefix Thinking
        │
        ├── Suffix Thinking
        │
        ├── Brute Force
        │
        ├── Prefix / Suffix Arrays
        │
        ├── Two Pointers
        │     ├── Left Pointer
        │     └── Right Pointer
        │
        ├── Opposite-Direction Pointers
        │
        ├── Running Maximum
        │
        ├── Accumulator
        │
        ├── while Loop
        │
        ├── Nested if / else
        │
        ├── Eliminating Repeated Work
        │
        ├── Greedy Processing
        │
        └── Big O Analysis
```

---

# First Understand the Problem

Given:

```text
height = [0,1,0,2,1,0,1,3,2,1,2,1]
```

Each number represents the height of one wall.

```text
Index:

 0  1  2  3  4  5  6  7  8  9 10 11


Height:

 0  1  0  2  1  0  1  3  2  1  2  1
```

After raining, water may remain above some of the shorter walls.

The question is:

```text
How Much Water
Can Stay Above
Every Position?
```

Then:

```text
Add All Trapped Water
```

Finally:

```text
Return the Total
```

---

# Is This an Area Problem?

In a geometric sense, the trapped water forms an area.

However, unlike:

```text
Problem #15:
Container With Most Water
```

we do not calculate:

```text
Width × Height
```

for one large rectangle.

Instead, every bar has width `1`.

Therefore, we calculate the water depth above each individual position and add all those unit-width water columns together.

```text
Container With Most Water

Choose Two Lines

        ↓

Calculate One Maximum Area


Trapping Rain Water

Check Every Position

        ↓

Calculate Water Above It

        ↓

Add Everything Together
```

---

# The Most Important Formula

For every position:

```text
Water Above Current Position

=

min(
    Tallest Wall on Left,
    Tallest Wall on Right
)

-

Current Wall Height
```

Mathematically:

```text
water[i]

=

min(leftMax, rightMax)

-

height[i]
```

This formula is the foundation of the entire problem.

---

# Why Do We Need a Wall on Both Sides?

Imagine:

```text
█

█

█
```

There is only one tall wall.

Can water stay beside it?

No.

The water flows away.

Now imagine:

```text
█           █

█           █

█           █
```

There are boundaries on both sides.

Now water can stay between them.

Therefore, trapped water requires:

```text
LEFT BOUNDARY

+

RIGHT BOUNDARY
```

---

# Why Do We Take the Smaller Boundary?

Suppose:

```text
Left Tallest Wall  = 2

Right Tallest Wall = 5
```

Can the water level reach `5`?

No.

The water would spill over the wall of height `2`.

Therefore:

```text
Water Level

=

min(2, 5)

=

2
```

The shorter boundary determines the maximum possible water level.

This is why:

```text
min(leftMax, rightMax)
```

is used.

---

# Why Do We Subtract the Current Wall Height?

Suppose:

```text
Water Level = 4

Current Wall Height = 2
```

The current wall already occupies `2` units of vertical space.

Therefore, the remaining space available for water is:

```text
4 - 2

=

2
```

So:

```text
Water Above Current Wall

=

Water Level

-

Current Wall Height
```

---

# Manual Calculation

Consider index `5`.

```text
height[5] = 0
```

Tallest wall on the left:

```text
leftMax = 2
```

Tallest wall on the right:

```text
rightMax = 3
```

Find the water level:

```text
min(2, 3)

=

2
```

Subtract the current wall:

```text
2 - 0

=

2
```

Therefore:

```text
Index 5

Water = 2 Units
```

---

# Water Calculation for Every Position

| Index | Height | Left Max | Right Max | Calculation    | Water |
| ----: | -----: | -------: | --------: | -------------- | ----: |
|     0 |      0 |        0 |         3 | `min(0,3) - 0` |     0 |
|     1 |      1 |        1 |         3 | `min(1,3) - 1` |     0 |
|     2 |      0 |        1 |         3 | `min(1,3) - 0` |     1 |
|     3 |      2 |        2 |         3 | `min(2,3) - 2` |     0 |
|     4 |      1 |        2 |         3 | `min(2,3) - 1` |     1 |
|     5 |      0 |        2 |         3 | `min(2,3) - 0` |     2 |
|     6 |      1 |        2 |         3 | `min(2,3) - 1` |     1 |
|     7 |      3 |        3 |         3 | `min(3,3) - 3` |     0 |
|     8 |      2 |        3 |         2 | `min(3,2) - 2` |     0 |
|     9 |      1 |        3 |         2 | `min(3,2) - 1` |     1 |
|    10 |      2 |        3 |         2 | `min(3,2) - 2` |     0 |
|    11 |      1 |        3 |         1 | `min(3,1) - 1` |     0 |

Total:

```text
1 + 1 + 2 + 1 + 1

=

6
```

---

# Approach 1: Brute Force

The most direct approach is:

```text
For Every Position

        ↓

Search the Entire Left Side

        ↓

Find Tallest Left Wall

        ↓

Search the Entire Right Side

        ↓

Find Tallest Right Wall

        ↓

Calculate Water

        ↓

Repeat
```

---

# Brute-Force Java Solution

```java
public int trappingRainWater(int[] height) {

    int totalWater = 0;

    for (int i = 0; i < height.length; i++) {

        int leftMax = 0;
        int rightMax = 0;

        for (int left = 0; left <= i; left++) {
            leftMax = Math.max(leftMax, height[left]);
        }

        for (int right = i; right < height.length; right++) {
            rightMax = Math.max(rightMax, height[right]);
        }

        totalWater +=
                Math.min(leftMax, rightMax) - height[i];
    }

    return totalWater;
}
```

---

# Why Is Brute Force `O(n²)`?

The outer loop processes:

```text
n Positions
```

For every position, we search:

```text
Left Side

+

Right Side
```

Each search may take approximately:

```text
O(n)
```

Therefore:

```text
O(n) × O(n)

=

O(n²)
```

---

# What Is the Repeated Work?

Suppose we calculate `leftMax` for index `5`.

Then we move to index `6`.

The brute-force solution searches the left side again.

Then for index `7`, it searches again.

Therefore:

```text
Same Information

Is Calculated

Again

And Again

And Again
```

The optimization question is:

```text
Can We Remember
the Maximum Heights
Instead of Searching Again?
```

Answer:

```text
YES
```

---

# Approach 2: Prefix and Suffix Arrays

We can precompute:

```text
Maximum Height
Seen From the Left
```

for every position.

And:

```text
Maximum Height
Seen From the Right
```

for every position.

For the input:

```text
height =

[0,1,0,2,1,0,1,3,2,1,2,1]
```

The left maximum array is:

```text
leftMax =

[0,1,1,2,2,2,2,3,3,3,3,3]
```

The right maximum array is:

```text
rightMax =

[3,3,3,3,3,3,3,3,2,2,2,1]
```

Then:

```text
water[i]

=

min(leftMax[i], rightMax[i])

-

height[i]
```

---

# Prefix / Suffix Java Solution

```java
public int trappingRainWater(int[] height) {

    int n = height.length;

    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    leftMax[0] = height[0];

    for (int i = 1; i < n; i++) {
        leftMax[i] =
                Math.max(leftMax[i - 1], height[i]);
    }

    rightMax[n - 1] = height[n - 1];

    for (int i = n - 2; i >= 0; i--) {
        rightMax[i] =
                Math.max(rightMax[i + 1], height[i]);
    }

    int totalWater = 0;

    for (int i = 0; i < n; i++) {
        totalWater +=
                Math.min(leftMax[i], rightMax[i])
                - height[i];
    }

    return totalWater;
}
```

---

# Prefix / Suffix Complexity

We traverse the array three times.

```text
Build leftMax

O(n)


Build rightMax

O(n)


Calculate Water

O(n)
```

Therefore:

```text
O(n) + O(n) + O(n)

=

O(3n)

=

O(n)
```

However, we create two additional arrays:

```text
leftMax[]

rightMax[]
```

Each contains `n` elements.

Therefore:

```text
Space Complexity = O(n)
```

---

# Can We Optimize the Space?

Yes.

The Prefix/Suffix solution stores:

```text
leftMax for Every Position

+

rightMax for Every Position
```

But do we really need to store every value?

No.

We only need:

```text
Maximum Seen So Far
From the Left

+

Maximum Seen So Far
From the Right
```

Therefore, we replace:

```text
leftMax[]

rightMax[]
```

with:

```text
leftMax

rightMax
```

This gives us the optimal Two Pointers solution.

---

# Approach 3: Optimal Two Pointers

We create:

```text
leftIndex

rightIndex

leftMax

rightMax

trapRainWater
```

The pointers begin at opposite ends:

```text
LEFT                               RIGHT

 ↓                                   ↓

[0,1,0,2,1,0,1,3,2,1,2,1]
```

Then:

```text
Compare Current Left Height

with

Current Right Height
```

Process the shorter side.

---

# Why Do We Process the Shorter Side?

The trapped water is controlled by:

```text
min(leftMax, rightMax)
```

Therefore, the smaller boundary is the limiting side.

If:

```text
height[leftIndex]
<=
height[rightIndex]
```

we process the left side.

Otherwise:

```text
Process the Right Side
```

This allows us to safely calculate one side at a time while moving inward.

---

# Optimal Java Solution

```java
public int trappingRainWater(int[] height) {

    // Stores the total amount of trapped rainwater
    int trapRainWater = 0;

    // Track the maximum wall heights seen from both sides
    int leftMax = 0;
    int rightMax = 0;

    // Initialize two pointers at opposite ends of the array
    int leftIndex = 0;
    int rightIndex = height.length - 1;

    // Process each position until the two pointers meet
    while (leftIndex < rightIndex) {

        // Process the side with the shorter current boundary
        if (height[leftIndex] <= height[rightIndex]) {

            // Update the maximum left boundary if a taller wall is found
            if (height[leftIndex] >= leftMax) {
                leftMax = height[leftIndex];

            } else {

                // Add the water trapped above the current left wall
                trapRainWater += leftMax - height[leftIndex];
            }

            // Move the left pointer inward
            leftIndex++;

        } else {

            // Update the maximum right boundary if a taller wall is found
            if (height[rightIndex] >= rightMax) {
                rightMax = height[rightIndex];

            } else {

                // Add the water trapped above the current right wall
                trapRainWater += rightMax - height[rightIndex];
            }

            // Move the right pointer inward
            rightIndex--;
        }
    }

    // Return the total trapped rainwater
    return trapRainWater;
}
```

---

# Understanding Every Variable

## `trapRainWater`

```java
int trapRainWater = 0;
```

Purpose:

```text
Store the Total Amount
of Water Found So Far
```

This is an accumulator.

Example:

```text
0
↓
+1
↓
1
↓
+1
↓
2
↓
+2
↓
4
↓
+1
↓
5
↓
+1
↓
6
```

---

## `leftMax`

```java
int leftMax = 0;
```

Purpose:

```text
Remember the Tallest Wall
Seen So Far From the Left
```

---

## `rightMax`

```java
int rightMax = 0;
```

Purpose:

```text
Remember the Tallest Wall
Seen So Far From the Right
```

---

## `leftIndex`

```java
int leftIndex = 0;
```

Purpose:

```text
Point to the Current Position
Being Checked From the Left
```

---

## `rightIndex`

```java
int rightIndex = height.length - 1;
```

Purpose:

```text
Point to the Current Position
Being Checked From the Right
```

---

# Why `height.length - 1`?

Suppose:

```text
height.length = 12
```

The indices are:

```text
0 1 2 3 4 5 6 7 8 9 10 11
```

Therefore:

```text
Last Index

=

12 - 1

=

11
```

---

# Understanding the `while` Loop

```java
while (leftIndex < rightIndex)
```

Human translation:

```text
Continue Processing

Until

The Two Pointers Meet
```

The pointers move:

```text
LEFT → → → →


← ← ← ← RIGHT
```

Eventually:

```text
leftIndex == rightIndex
```

At that point, processing is complete.

---

# Understanding the Outer `if`

```java
if (height[leftIndex] <= height[rightIndex])
```

This answers:

```text
WHICH SIDE
SHOULD I PROCESS?
```

If:

```text
Left Current Height
<=
Right Current Height
```

then:

```text
Process Left Side
```

Otherwise:

```text
Process Right Side
```

Remember:

```text
OUTER IF

=

CHOOSE THE SIDE
```

---

# Understanding the Inner Left `if`

```java
if (height[leftIndex] >= leftMax)
```

This answers:

```text
WHAT SHOULD I DO
WITH THE CURRENT LEFT WALL?
```

There are two possibilities.

### Possibility 1: New Maximum

```text
Current Wall >= leftMax
```

Then:

```text
Update leftMax
```

Code:

```java
leftMax = height[leftIndex];
```

### Possibility 2: Current Wall Is Lower

```text
Current Wall < leftMax
```

Then:

```text
Water Can Exist Above It
```

Calculate:

```text
leftMax - currentHeight
```

Code:

```java
trapRainWater += leftMax - height[leftIndex];
```

Remember:

```text
INNER IF

=

UPDATE MAXIMUM

OR

CALCULATE WATER
```

---

# Understanding the Left-Side Code Flow

```java
if (height[leftIndex] <= height[rightIndex]) {

    if (height[leftIndex] >= leftMax) {
        leftMax = height[leftIndex];
    } else {
        trapRainWater += leftMax - height[leftIndex];
    }

    leftIndex++;
}
```

Human translation:

```text
Can I Process the Left Side?
        ↓
YES
        ↓
Look at Current Left Wall
        ↓
Is It a New Maximum?
      /           \
    YES            NO
     ↓              ↓
Update          Calculate
leftMax           Water
      \           /
       \         /
        leftIndex++
```

---

# Understanding the Right-Side Code Flow

```java
else {

    if (height[rightIndex] >= rightMax) {
        rightMax = height[rightIndex];
    } else {
        trapRainWater += rightMax - height[rightIndex];
    }

    rightIndex--;
}
```

Human translation:

```text
Process the Right Side
        ↓
Look at Current Right Wall
        ↓
Is It a New Maximum?
      /           \
    YES            NO
     ↓              ↓
Update          Calculate
rightMax          Water
      \           /
       \         /
       rightIndex--
```

---

# Why Do We Move the Pointer After Processing?

Left:

```java
leftIndex++;
```

Right:

```java
rightIndex--;
```

The current position has already been completely processed.

We either:

```text
Updated the Maximum
```

or:

```text
Calculated Its Water
```

Therefore, there is no reason to process that position again.

Move inward.

---

# Complete Code Flow

```text
START
  ↓
trapRainWater = 0
  ↓
leftMax = 0
  ↓
rightMax = 0
  ↓
leftIndex = 0
  ↓
rightIndex = Last Index
  ↓
Are Pointers Still Apart?
  ↓
YES
  ↓
Compare Current Heights
  ↓
Which Side Is Shorter?
       /         \
     LEFT        RIGHT
       ↓           ↓
New Left Max?   New Right Max?
    /    \         /    \
  YES    NO      YES    NO
   ↓      ↓       ↓      ↓
Update  Water   Update  Water
   ↓      ↓       ↓      ↓
 leftIndex++   rightIndex--
       \           /
        \         /
          REPEAT
            ↓
      POINTERS MEET
            ↓
    RETURN TOTAL WATER
```

---

# Dry Run

Input:

```text
height = [0,1,0,2,1,0,1,3,2,1,2,1]
```

Initial values:

```text
leftIndex = 0

rightIndex = 11

leftMax = 0

rightMax = 0

trapRainWater = 0
```

| Step | Left | Right | Side Processed | Current Height | Maximum | Water Added | Total Water |
| ---: | ---: | ----: | -------------- | -------------: | ------: | ----------: | ----------: |
|    1 |    0 |    11 | Left           |              0 |       0 |           0 |           0 |
|    2 |    1 |    11 | Left           |              1 |       1 |           0 |           0 |
|    3 |    2 |    11 | Left           |              0 |       1 |           1 |           1 |
|    4 |    3 |    11 | Right          |              1 |       1 |           0 |           1 |
|    5 |    3 |    10 | Left           |              2 |       2 |           0 |           1 |
|    6 |    4 |    10 | Left           |              1 |       2 |           1 |           2 |
|    7 |    5 |    10 | Left           |              0 |       2 |           2 |           4 |
|    8 |    6 |    10 | Left           |              1 |       2 |           1 |           5 |
|    9 |    7 |    10 | Right          |              2 |       2 |           0 |           5 |
|   10 |    7 |     9 | Right          |              1 |       2 |           1 |           6 |
|   11 |    7 |     8 | Right          |              2 |       2 |           0 |           6 |

Finally:

```text
leftIndex = 7

rightIndex = 7
```

Condition:

```text
leftIndex < rightIndex

7 < 7

FALSE
```

Stop.

Return:

```text
6
```

---

# Connection Between Manual Formula and Optimal Code

Manual formula:

```text
water[i]

=

min(leftMax, rightMax)

-

height[i]
```

Example index `5`:

```text
leftMax = 2

rightMax = 3

height[5] = 0
```

Therefore:

```text
min(2, 3) - 0

=

2
```

In the optimal code, the current left side is the side that can be processed.

Therefore:

```java
trapRainWater += leftMax - height[leftIndex];
```

becomes:

```text
trapRainWater += 2 - 0
```

So:

```text
2 Units of Water Are Added
```

This is the connection between the mathematical formula and the Two Pointers implementation.

---

# Why Is the Optimal Solution `O(n)`?

At every iteration:

```text
One Pointer Moves
```

Either:

```java
leftIndex++;
```

or:

```java
rightIndex--;
```

The pointers only move inward.

They never move backward.

Therefore, every position is processed at most once.

```text
Time Complexity

=

O(n)
```

---

# Why Is the Space Complexity `O(1)`?

We only create:

```text
trapRainWater

leftMax

rightMax

leftIndex

rightIndex
```

The number of variables remains constant regardless of input size.

Therefore:

```text
Space Complexity

=

O(1)
```

---

# Brute Force vs Prefix/Suffix vs Two Pointers

| Approach      | Strategy                                 |    Time |  Space |
| ------------- | ---------------------------------------- | ------: | -----: |
| Brute Force   | Search left and right for every position | `O(n²)` | `O(1)` |
| Prefix/Suffix | Precompute maximum boundaries            |  `O(n)` | `O(n)` |
| Two Pointers  | Maintain running maximums from both ends |  `O(n)` | `O(1)` |

---

# Why Are Nested Conditions Used?

The code contains:

```text
OUTER IF
```

and:

```text
INNER IF
```

They solve two completely different decisions.

```text
OUTER IF

Which Side Should I Process?


        ↓


INNER IF

What Should I Do
With the Wall
on That Side?
```

More clearly:

```text
OUTER IF

Left or Right?


        ↓


INNER IF

New Maximum or Water?
```

This is the cleanest way to understand the nested conditions.

---

# Pattern Recognition

When you see a problem involving:

```text
Information From the Left

+

Information From the Right

+

Repeated Searching

+

Maximum Boundaries

+

Processing From Both Ends
```

ask:

```text
Can I Maintain
Running Information
From Both Sides?
        ↓
YES


Can Two Pointers
Move Toward Each Other?
        ↓
YES


Can I Safely Process
One Side at a Time?
        ↓
YES


THINK:

OPPOSITE-DIRECTION
TWO POINTERS
```

---

# Interview Explanation

The brute-force approach calculates the tallest wall on the left and right for every position, resulting in `O(n²)` time.

The amount of water above a position is determined by the smaller of the maximum heights on its left and right, minus the current wall height.

A Prefix/Suffix approach can precompute these maximum heights in `O(n)` time, but it requires `O(n)` additional space.

To optimize the space, I use two pointers starting at opposite ends of the array and maintain `leftMax` and `rightMax`, which represent the tallest walls seen so far from each direction.

At every iteration, I process the side with the shorter current boundary. If the current wall is greater than or equal to the maximum seen from that side, I update the maximum. Otherwise, the difference between the maximum boundary and the current wall height is trapped water, so I add it to the total.

After processing a position, I move that pointer inward.

Since one pointer moves during every iteration and each position is processed at most once, the time complexity is `O(n)`.

Only a fixed number of variables are used, so the space complexity is `O(1)`.

---

# Short Interview Revision Notes

```text
PROBLEM:

Problem #8
Trapping Rain Water


DIFFICULTY:

Hard


CATEGORY:

Two Pointers / Stack


PATTERN LEARNED:

Opposite-Direction
Two Pointers


RETURN:

Total Amount of
Trapped Rainwater


WATER AT ONE POSITION:

min(leftMax, rightMax)

-

currentHeight


WHY MINIMUM?

The Shorter Boundary
Limits the Water Level


WHY SUBTRACT HEIGHT?

The Current Wall
Already Occupies Space


BRUTE FORCE:

For Every Position

Search Left Maximum

+

Search Right Maximum


TIME:

O(n²)


REPEATED WORK:

Searching the Same
Left and Right Areas
Again and Again


FIRST OPTIMIZATION:

Prefix / Suffix Arrays


TIME:

O(n)


SPACE:

O(n)


FINAL OPTIMIZATION:

Two Pointers


VARIABLES:

leftIndex

rightIndex

leftMax

rightMax

trapRainWater


OUTER IF:

Which Side
Should I Process?


INNER IF:

New Maximum

OR

Calculate Water?


LEFT PROCESSING:

Current Left Wall
        ↓
New Maximum?
   /         \
 YES          NO
  ↓            ↓
Update      Add Water
leftMax
        ↓
leftIndex++


RIGHT PROCESSING:

Current Right Wall
        ↓
New Maximum?
   /         \
 YES          NO
  ↓            ↓
Update      Add Water
rightMax
        ↓
rightIndex--


CORE FLOW:

Start at Both Ends
        ↓
Compare Current Heights
        ↓
Process Shorter Side
        ↓
New Maximum?
   /          \
 YES           NO
  ↓             ↓
Update Max    Add Water
        ↓
Move Pointer
        ↓
Repeat


TIME COMPLEXITY:

O(n)


SPACE COMPLEXITY:

O(1)


MOST IMPORTANT FORMULA:

Water

=

min(leftMax, rightMax)

-

currentHeight


MOST IMPORTANT CODE IDEA:

Outer If
=
Choose Side


Inner If
=
Update Maximum
or
Calculate Water


MAIN INTERVIEW LESSON:

Do not repeatedly search
for information that can
be maintained while traversing.


ONE-LINE MEMORY RULE:

Process the shorter side,
update its maximum if needed;
otherwise, add the gap
between the maximum and
the current wall as water.
```

---

# Final Pattern Summary

```text
Problem #1:
Two Sum

        ↓

HashMap Lookup


Problem #12:
Group Anagrams

        ↓

HashMap Grouping


Problem #16:
Top K Frequent Elements

        ↓

Frequency Counting
+
Bucket Sort


Problem #19:
Product of Array Except Self

        ↓

Prefix
+
Suffix


Problem #7:
Longest Substring Without
Repeating Characters

        ↓

Variable-Size Sliding Window
+
Same-Direction Two Pointers


Problem #15:
Container With Most Water

        ↓

Opposite-Direction
Two Pointers
+
Eliminate Impossible Pairs


Problem #8:
Trapping Rain Water

        ↓

Prefix / Suffix Thinking
+
Running Maximum Boundaries
+
Opposite-Direction Two Pointers
```

---

# Final Takeaway

```text
For Every Position:

How High Can Water Rise?

        ↓

Shorter Maximum Boundary


How Much Space
Does the Wall Occupy?

        ↓

Current Height


Therefore:

Trapped Water

=

Boundary Height

-

Current Wall Height
```

The most important progression to remember is:

```text
BRUTE FORCE

Repeatedly Search
Left and Right Maximums

        ↓

PREFIX / SUFFIX

Precompute All Maximums

        ↓

TWO POINTERS

Maintain Only the Maximums
Needed While Moving Inward

        ↓

O(n) TIME

O(1) SPACE
```
