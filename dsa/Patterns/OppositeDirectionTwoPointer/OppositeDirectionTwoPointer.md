# Problem #15: Container With Most Water

**Difficulty:** Medium
**Category:** Two Pointers
**Pattern:** Opposite-Direction Two Pointers
**Core Strategy:** Start Wide → Move the Limiting Pointer
**Time Complexity:** `O(n)`
**Space Complexity:** `O(1)`

---

# Problem Statement

You are given an integer array `height`.

Each element represents the height of a vertical line.

Find two lines that, together with the x-axis, form a container that can hold the maximum amount of water.

Return the maximum amount of water the container can store.

---

# Example

```text
Input:

height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
```

```text
Output:

49
```

## Explanation

The maximum area is created using the lines at:

```text
index 1

and

index 8
```

Their heights are:

```text
8 and 7
```

The width is:

```text
8 - 1

=

7
```

The container height is determined by the shorter line:

```text
min(8, 7)

=

7
```

Therefore:

```text
AREA

=

WIDTH × HEIGHT

=

7 × 7

=

49
```

So:

```text
Answer = 49
```

---

# Problem Classification

```text
PROBLEM
   │
   ▼
Problem #15:
Container With Most Water


DIFFICULTY
   │
   ▼
Medium


CATEGORY
   │
   ▼
Two Pointers


PATTERN
   │
   ▼
Opposite-Direction
Two Pointers


CORE STRATEGY
   │
   ▼
Start With Maximum Width
        ↓
Calculate Area
        ↓
Find Limiting Side
        ↓
Move Shorter Pointer


OPTIMAL APPROACH
   │
   ▼
Two Pointers


CORE LOGIC
   │
   ▼
Start Wide
        ↓
Calculate
        ↓
Move Limiting Side
        ↓
Repeat
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


Longest Substring Without
Repeating Characters
   ↓
Avoid Repeated Substring Checking


Container With Most Water
   ↓
Avoid Checking Every Pair
```

The larger interview lesson is:

```text
BRUTE FORCE
     ↓
Find Repeated or
Unnecessary Work
     ↓
Ask How to Eliminate It
     ↓
Choose the Correct Pattern
     ↓
OPTIMIZE
```

---

# Topics and Subtopics Covered

```text
Container With Most Water
              │
              ├── Arrays
              │
              ├── Array Indices
              │
              ├── Pair Selection
              │
              ├── Nested Loops
              │
              ├── Two Pointers
              │     ├── Left Pointer
              │     └── Right Pointer
              │
              ├── Opposite-Direction Pointers
              │
              ├── Width Calculation
              │
              ├── Height Calculation
              │
              ├── Area Calculation
              │
              ├── Math.min()
              │
              ├── Math.max()
              │
              ├── while Loop
              │
              ├── if / else Conditions
              │
              ├── Greedy Decision
              │
              ├── Eliminating Possibilities
              │
              ├── Brute Force
              │
              └── Big O Analysis
```

---

# Beginner Thinking

Given:

```text
height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
```

Ask:

```text
What do I need?
```

Answer:

```text
Find two lines
that create the largest container.
```

Now ask:

```text
What determines
the container's area?
```

Answer:

```text
WIDTH

×

HEIGHT
```

Therefore:

```text
AREA

=

WIDTH × HEIGHT
```

This is the foundation of the problem.

---

# Real-World Example

Imagine two walls.

```text
WALL A                      WALL B

  |                            |
  |                            |
  |                            |
  |                            |
  |                            |
  |____________________________|
```

The amount of water between the walls depends on:

```text
1. Distance Between the Walls

2. Height of the Shorter Wall
```

Even if one wall is extremely tall:

```text
|
|
|
|
|                 |
|                 |
|_________________|
```

the water cannot rise above the shorter wall.

Otherwise, the water spills over.

Therefore:

```text
CONTAINER CAPACITY

=

DISTANCE

×

SHORTER WALL
```

This becomes:

```text
AREA

=

WIDTH

×

MINIMUM HEIGHT
```

---

# Understanding the Area Formula

Suppose:

```text
left = 1

right = 8
```

The heights are:

```text
height[left] = 8

height[right] = 7
```

The area formula is:

```text
AREA

=

WIDTH

×

CONTAINER HEIGHT
```

---

# How Do We Calculate Width?

The left index is:

```text
1
```

The right index is:

```text
8
```

Therefore:

```text
width

=

right - left

=

8 - 1

=

7
```

In code:

```java
int width = right - left;
```

Remember:

```text
WIDTH

=

DISTANCE BETWEEN POINTERS
```

---

# How Do We Calculate Container Height?

The two heights are:

```text
8 and 7
```

Can the water height be `8`?

No.

Why?

Because the right wall has height:

```text
7
```

The water would spill over the shorter wall.

Therefore:

```text
CONTAINER HEIGHT

=

SHORTER OF THE TWO LINES
```

In code:

```java
int containerHeight =
        Math.min(height[left], height[right]);
```

For:

```text
8 and 7
```

we get:

```text
Math.min(8, 7)

=

7
```

Remember:

```text
CONTAINER HEIGHT

=

MINIMUM HEIGHT
```

---

# Calculating the Area

Now:

```text
WIDTH = 7

HEIGHT = 7
```

Therefore:

```text
AREA

=

7 × 7

=

49
```

In code:

```java
int currentArea = width * containerHeight;
```

The complete formula is:

```text
AREA

=

(right - left)

×

min(height[left], height[right])
```

In Java:

```java
int currentArea =
        (right - left)
        * Math.min(height[left], height[right]);
```

This is the most important formula in the problem.

---

# Approach 1: Brute Force

The simplest idea is:

```text
Try Every Possible Pair
```

For every line:

```text
Choose First Line
        ↓
Choose Every Possible
Second Line
        ↓
Calculate Width
        ↓
Find Shorter Height
        ↓
Calculate Area
        ↓
Update Maximum
```

Consider:

```text
[1, 8, 6, 2]
```

Start with index `0`.

Compare it with:

```text
index 1

index 2

index 3
```

Then choose index `1`.

Compare it with:

```text
index 2

index 3
```

Then choose index `2`.

Compare it with:

```text
index 3
```

Therefore:

```text
TRY EVERY POSSIBLE PAIR
```

---

# Brute-Force Java Solution

```java
class Solution {

    public int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {

                int width = j - i;

                int containerHeight =
                        Math.min(height[i], height[j]);

                int currentArea =
                        width * containerHeight;

                maxArea =
                        Math.max(maxArea, currentArea);
            }
        }

        return maxArea;
    }
}
```

---

# Understanding the Outer Loop

Code:

```java
for (int i = 0; i < height.length; i++)
```

The outer loop chooses:

```text
FIRST LINE
```

For:

```text
[1, 8, 6, 2]
```

the outer loop chooses:

```text
index 0

index 1

index 2

index 3
```

Therefore:

```text
OUTER LOOP
     ↓
Choose First Line
```

---

# Understanding the Inner Loop

Code:

```java
for (int j = i + 1; j < height.length; j++)
```

The inner loop chooses:

```text
SECOND LINE
```

Why:

```text
j = i + 1
```

instead of:

```text
j = 0
```

Because we do not need to compare a line with itself.

We also do not need to repeat pairs.

For example:

```text
index 0 + index 1
```

is the same pair as:

```text
index 1 + index 0
```

Therefore:

```text
j = i + 1
```

avoids unnecessary work.

---

# Why Is Brute Force `O(n²)`?

The outer loop runs approximately:

```text
n times
```

For every outer-loop iteration, the inner loop may also run approximately:

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

The problem is:

```text
TRYING EVERY POSSIBLE PAIR
```

Suppose the array contains:

```text
100,000 elements
```

Trying every possible pair would require an enormous number of calculations.

So we ask:

```text
Can I logically eliminate
some possibilities
without checking them?
```

The answer is:

```text
YES
```

This leads us to:

```text
TWO POINTERS
```

---

# What Is the Two Pointers Pattern?

The Two Pointers pattern uses two positions to explore the input efficiently.

For this problem:

```text
LEFT                         RIGHT

 ↓                             ↓

[1, 8, 6, 2, 5, 4, 8, 3, 7]
```

One pointer starts at:

```text
BEGINNING
```

The other starts at:

```text
END
```

Then they move:

```text
LEFT  → → → →

RIGHT ← ← ← ←
```

toward each other.

Therefore, this pattern is called:

```text
OPPOSITE-DIRECTION
TWO POINTERS
```

---

# Why Start at Opposite Ends?

Initially:

```java
int left = 0;

int right = height.length - 1;
```

This gives us:

```text
THE MAXIMUM POSSIBLE WIDTH
```

Remember:

```text
AREA

=

WIDTH × HEIGHT
```

Starting at opposite ends gives the largest possible width.

Then we gradually reduce the width while searching for better heights.

The strategy is:

```text
START WITH
MAXIMUM WIDTH
       ↓
CALCULATE AREA
       ↓
REMOVE THE LIMITING SIDE
       ↓
SEARCH FOR A BETTER HEIGHT
```

---

# The Most Important Question

After calculating the current area:

```text
Which pointer should move?
```

Suppose:

```text
LEFT HEIGHT = 1

RIGHT HEIGHT = 7
```

Should we move the taller line?

Or should we move the shorter line?

The answer is:

```text
MOVE THE SHORTER LINE
```

This is the heart of the entire problem.

---

# Why Move the Shorter Pointer?

Suppose:

```text
LEFT HEIGHT = 1

RIGHT HEIGHT = 7
```

The container height is:

```text
min(1, 7)

=

1
```

Therefore:

```text
THE LEFT SIDE
IS LIMITING THE AREA
```

Now suppose we move the taller right pointer.

The width becomes smaller.

But the left height remains:

```text
1
```

Therefore:

```text
WIDTH DECREASES

and

HEIGHT CANNOT IMPROVE
```

There is no possibility of finding a larger area while keeping the shorter line.

So moving the taller pointer cannot help.

---

# What Happens If We Move the Shorter Pointer?

Current:

```text
[1, 8, 6, 2, 5, 4, 8, 3, 7]

 ↑                           ↑

LEFT                       RIGHT
```

The left height is:

```text
1
```

Move the left pointer:

```text
[1, 8, 6, 2, 5, 4, 8, 3, 7]

    ↑                        ↑

  LEFT                     RIGHT
```

Now the left height becomes:

```text
8
```

Yes, the width decreased.

But the limiting height improved:

```text
1 → 8
```

Therefore, there is a possibility of finding a larger area.

This is why:

```text
MOVE THE SHORTER POINTER
```

---

# Core Decision Logic

```text
CALCULATE AREA
       ↓
COMPARE BOTH HEIGHTS
       ↓
WHICH SIDE IS SHORTER?
      /              \
    LEFT             RIGHT
      ↓                ↓
   left++           right--
```

In Java:

```java
if (height[left] < height[right]) {

    left++;

} else {

    right--;
}
```

---

# Why Do We Need `if / else`?

The computer needs to make a decision:

```text
Which pointer
should move?
```

The rule is:

```text
IF LEFT IS SHORTER
        ↓
MOVE LEFT


OTHERWISE
        ↓
MOVE RIGHT
```

Therefore:

```java
if (height[left] < height[right]) {

    left++;

} else {

    right--;
}
```

Human translation:

```text
Find the wall
limiting the container.

Remove that limitation.

Search for a potentially
better wall.
```

---

# Optimal Approach

The strategy is:

```text
PLACE LEFT AT BEGINNING
        ↓
PLACE RIGHT AT END
        ↓
WHILE LEFT < RIGHT
        ↓
CALCULATE WIDTH
        ↓
FIND SHORTER HEIGHT
        ↓
CALCULATE CURRENT AREA
        ↓
UPDATE MAXIMUM AREA
        ↓
MOVE SHORTER POINTER
        ↓
REPEAT
        ↓
RETURN MAXIMUM AREA
```

---

# Optimal Java Solution

```java
class Solution {

    public int maxArea(int[] height) {

        int left = 0;

        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            int width = right - left;

            int containerHeight =
                    Math.min(height[left], height[right]);

            int currentArea =
                    width * containerHeight;

            maxArea =
                    Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {

                left++;

            } else {

                right--;
            }
        }

        return maxArea;
    }
}
```

---

# Complete Algorithm

```text
START
  ↓
left = 0
  ↓
right = Last Index
  ↓
maxArea = 0
  ↓
Are Left and Right Different?
  ↓
YES
  ↓
Calculate Width
  ↓
Find Shorter Height
  ↓
Calculate Area
  ↓
Update Maximum
  ↓
Move Shorter Pointer
  ↓
Repeat
  ↓
left == right
  ↓
STOP
  ↓
Return Maximum
```

---

# Understanding `left`

Code:

```java
int left = 0;
```

Human translation:

```text
Place one pointer
at the beginning
of the array.
```

Visualize:

```text
[1, 8, 6, 2, 5, 4, 8, 3, 7]

 ↑

left
```

The left pointer can move:

```text
→ → → → →
```

using:

```java
left++;
```

---

# Understanding `right`

Code:

```java
int right = height.length - 1;
```

Why:

```text
height.length - 1
```

Suppose the array contains:

```text
9 elements
```

Then:

```text
height.length = 9
```

But array indices are:

```text
0 1 2 3 4 5 6 7 8
```

Therefore, the last index is:

```text
9 - 1

=

8
```

So:

```java
height.length - 1
```

gives us the last valid index.

---

# Understanding `maxArea`

Code:

```java
int maxArea = 0;
```

The purpose is:

```text
Remember the largest area
found so far.
```

Example:

```text
Current Area = 8

maxArea = 8
```

Later:

```text
Current Area = 49

maxArea = 49
```

Later:

```text
Current Area = 18

maxArea remains 49
```

Therefore:

```text
maxArea
    ↓
BEST ANSWER FOUND SO FAR
```

---

# Understanding the `while` Loop

Code:

```java
while (left < right)
```

Human translation:

```text
Keep checking containers
while two different lines exist.
```

Initially:

```text
LEFT                         RIGHT

 ↓                             ↓

[1, 8, 6, 2, 5, 4, 8, 3, 7]
```

The pointers move:

```text
LEFT  → → → →

RIGHT ← ← ← ←
```

Eventually:

```text
left == right
```

Now both pointers are on the same line.

Can one line create a container?

```text
NO
```

Therefore, stop.

That is why we use:

```java
while (left < right)
```

---

# Understanding Width Calculation

Code:

```java
int width = right - left;
```

Suppose:

```text
left = 1

right = 8
```

Then:

```text
width

=

8 - 1

=

7
```

Human translation:

```text
Calculate the distance
between the two lines.
```

---

# Understanding `Math.min()`

Code:

```java
int containerHeight =
        Math.min(height[left], height[right]);
```

Suppose:

```text
height[left] = 8

height[right] = 7
```

Then:

```text
Math.min(8, 7)

=

7
```

Why minimum?

Because:

```text
THE SHORTER WALL
LIMITS THE WATER HEIGHT
```

Therefore:

```text
CONTAINER HEIGHT

=

MINIMUM OF BOTH HEIGHTS
```

---

# Understanding Area Calculation

Code:

```java
int currentArea =
        width * containerHeight;
```

Suppose:

```text
width = 7

containerHeight = 7
```

Then:

```text
currentArea

=

7 × 7

=

49
```

---

# Understanding `Math.max()`

Code:

```java
maxArea = Math.max(maxArea, currentArea);
```

Suppose:

```text
maxArea = 8

currentArea = 49
```

Then:

```text
Math.max(8, 49)

=

49
```

So:

```text
maxArea = 49
```

Human translation:

```text
Compare:

Best Area Found So Far

with

Current Area


Keep the Larger One
```

---

# Understanding Pointer Movement

Code:

```java
if (height[left] < height[right]) {

    left++;

} else {

    right--;
}
```

Suppose:

```text
height[left] = 1

height[right] = 7
```

Condition:

```text
1 < 7
```

is:

```text
true
```

Therefore:

```java
left++;
```

Suppose:

```text
height[left] = 8

height[right] = 7
```

Condition:

```text
8 < 7
```

is:

```text
false
```

Therefore:

```java
right--;
```

The rule is:

```text
MOVE THE SHORTER POINTER
```

---

# Complete Dry Run

Input:

```text
height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
```

Initially:

```text
left = 0

right = 8

maxArea = 0
```

---

## Iteration 1

Pointers:

```text
left = 0

right = 8
```

Heights:

```text
height[left] = 1

height[right] = 7
```

Width:

```text
8 - 0

=

8
```

Container height:

```text
min(1, 7)

=

1
```

Area:

```text
8 × 1

=

8
```

Update:

```text
maxArea = 8
```

Compare heights:

```text
1 < 7
```

Therefore:

```text
left++
```

New:

```text
left = 1
```

---

## Iteration 2

Pointers:

```text
left = 1

right = 8
```

Heights:

```text
8 and 7
```

Width:

```text
8 - 1

=

7
```

Container height:

```text
min(8, 7)

=

7
```

Area:

```text
7 × 7

=

49
```

Update:

```text
maxArea = 49
```

Compare:

```text
8 < 7
```

False.

Therefore:

```text
right--
```

New:

```text
right = 7
```

---

## Iteration 3

Pointers:

```text
left = 1

right = 7
```

Heights:

```text
8 and 3
```

Width:

```text
7 - 1

=

6
```

Container height:

```text
min(8, 3)

=

3
```

Area:

```text
6 × 3

=

18
```

Maximum remains:

```text
49
```

Right is shorter.

Therefore:

```text
right--
```

---

## Iteration 4

Pointers:

```text
left = 1

right = 6
```

Heights:

```text
8 and 8
```

Width:

```text
6 - 1

=

5
```

Container height:

```text
min(8, 8)

=

8
```

Area:

```text
5 × 8

=

40
```

Maximum remains:

```text
49
```

The heights are equal.

The `else` executes:

```java
right--;
```

---

## Iteration 5

Pointers:

```text
left = 1

right = 5
```

Heights:

```text
8 and 4
```

Width:

```text
5 - 1

=

4
```

Height:

```text
min(8, 4)

=

4
```

Area:

```text
4 × 4

=

16
```

Maximum:

```text
49
```

Move:

```text
right--
```

---

## Iteration 6

Pointers:

```text
left = 1

right = 4
```

Heights:

```text
8 and 5
```

Width:

```text
4 - 1

=

3
```

Height:

```text
5
```

Area:

```text
3 × 5

=

15
```

Maximum:

```text
49
```

Move:

```text
right--
```

---

## Iteration 7

Pointers:

```text
left = 1

right = 3
```

Heights:

```text
8 and 2
```

Width:

```text
3 - 1

=

2
```

Height:

```text
2
```

Area:

```text
2 × 2

=

4
```

Maximum:

```text
49
```

Move:

```text
right--
```

---

## Iteration 8

Pointers:

```text
left = 1

right = 2
```

Heights:

```text
8 and 6
```

Width:

```text
2 - 1

=

1
```

Height:

```text
6
```

Area:

```text
1 × 6

=

6
```

Maximum:

```text
49
```

Move:

```text
right--
```

Now:

```text
left = 1

right = 1
```

Condition:

```java
left < right
```

is false.

Stop.

Return:

```text
49
```

---

# Why Is the Optimal Solution `O(n)`?

Initially:

```text
LEFT                         RIGHT
```

At every iteration:

```text
ONE POINTER MOVES
```

Either:

```java
left++;
```

or:

```java
right--;
```

The pointers only move toward each other.

They never move backward.

Therefore, the number of iterations is proportional to:

```text
n
```

So:

```text
Time Complexity:

O(n)
```

---

# Why Is the Space Complexity `O(1)`?

We only create a fixed number of variables:

```text
left

right

maxArea

width

containerHeight

currentArea
```

The number of variables does not increase when the input becomes larger.

Therefore:

```text
Space Complexity:

O(1)
```

---

# Brute Force vs Optimal Approach

| Approach     | Strategy                                 | Time Complexity | Space Complexity |
| ------------ | ---------------------------------------- | --------------: | ---------------: |
| Brute Force  | Try every possible pair                  |         `O(n²)` |           `O(1)` |
| Two Pointers | Start wide and move the limiting pointer |          `O(n)` |           `O(1)` |

---

# Why Is This a Greedy Decision?

At every step, we make a local decision:

```text
MOVE THE SHORTER POINTER
```

Why?

Because the shorter line limits the current area.

We do not know exactly which pair will produce the final answer.

But we know:

```text
Keeping the shorter line

+

Reducing the width

=

Cannot improve the area
```

Therefore, we safely eliminate that shorter line and search for a better one.

This is a greedy-style decision.

---

# Pattern Recognition

When you see problems involving:

```text
Pairs

Comparing Two Ends

Maximum or Minimum Pair

Eliminating Choices

Start and End

Moving Based on a Condition

Sorted Arrays

Palindrome Checking
```

ask:

```text
Can I place one pointer
at each end?
        ↓
YES


Can I eliminate one possibility
based on a logical condition?
        ↓
YES


Do the pointers move
toward each other?
        ↓
YES


THINK:

OPPOSITE-DIRECTION
TWO POINTERS
```

---

# Connection to Problem #7

In:

```text
Problem #7:
Longest Substring Without
Repeating Characters
```

we used:

```text
SAME-DIRECTION TWO POINTERS
```

Visualize:

```text
LEFT  → → → → →

RIGHT → → → → →
```

The purpose was:

```text
Maintain a Valid Window
```

In:

```text
Problem #15:
Container With Most Water
```

we use:

```text
OPPOSITE-DIRECTION TWO POINTERS
```

Visualize:

```text
LEFT  → → →

← ← ← RIGHT
```

The purpose is:

```text
Eliminate Impossible Choices
```

Therefore:

```text
TWO POINTERS
      │
      ├── Same Direction
      │
      │       ↓
      │   Sliding Window
      │
      │   Problem #7
      │
      └── Opposite Direction
              ↓
          Start at Ends
              ↓
          Eliminate Choices
              ↓
          Problem #15
```

---

# Interview Explanation

The brute-force approach checks every possible pair of lines, which takes `O(n²)` time.

To optimize the solution, I use two pointers.

I place the left pointer at the beginning and the right pointer at the end, which gives the maximum possible initial width.

For every pair, I calculate the area using the distance between the pointers multiplied by the shorter of the two heights.

After calculating the area, I move the pointer with the shorter height.

The shorter line limits the current container height. If I moved the taller pointer instead, the width would decrease while the limiting shorter height remained the same, so the area could not improve.

Moving the shorter pointer gives us the only possibility of finding a taller limiting line that may compensate for the reduced width.

At every iteration, one pointer moves toward the other, so the time complexity is `O(n)`.

Only a fixed number of variables are used, so the space complexity is `O(1)`.

---

# Short Interview Revision Notes

```text
PROBLEM:

Problem #15:
Container With Most Water


DIFFICULTY:

Medium


CATEGORY:

Two Pointers


PATTERN:

Opposite-Direction
Two Pointers


PROBLEM:

Choose two lines
that create the
maximum container area.


BRUTE FORCE:

Try Every Pair
        ↓
Calculate Width
        ↓
Find Shorter Height
        ↓
Calculate Area
        ↓
Update Maximum


BRUTE FORCE TIME:

O(n²)


PROBLEM WITH BRUTE FORCE:

Checking Every Possible Pair


OPTIMIZATION QUESTION:

Can I logically eliminate
some possibilities?


ANSWER:

YES


PATTERN:

Two Pointers


LEFT:

Starts at Beginning


RIGHT:

Starts at End


WHY START AT ENDS?

Maximum Possible Width


AREA FORMULA:

Area

=

Width

×

Container Height


WIDTH:

right - left


CONTAINER HEIGHT:

min(
    height[left],
    height[right]
)


WHY MINIMUM?

Shorter Wall
Limits Water Height


CORE QUESTION:

Which Pointer Should Move?


ANSWER:

Move the Shorter Pointer


WHY?

Shorter Height
Limits Current Area


IF WE MOVE TALLER POINTER:

Width Decreases

+

Limiting Height
Does Not Improve


RESULT:

Area Cannot Improve


IF WE MOVE SHORTER POINTER:

Width Decreases

BUT

Limiting Height
May Improve


THEREFORE:

Move Shorter Pointer


CORE LOGIC:

Start Wide
        ↓
Calculate Area
        ↓
Update Maximum
        ↓
Move Limiting Side
        ↓
Repeat


WHILE CONDITION:

left < right


WHY?

Need Two Different Lines
to Create a Container


IF / ELSE:

IF Left Is Shorter
        ↓
left++


ELSE
        ↓
right--


TIME COMPLEXITY:

O(n)


WHY?

One Pointer Moves
Every Iteration

Pointers Only Move
Toward Each Other


SPACE COMPLEXITY:

O(1)


CONNECTION:

Problem #7

Same-Direction Two Pointers

        ↓

Maintain a Window


Problem #15

Opposite-Direction Two Pointers

        ↓

Eliminate Choices


MAIN INTERVIEW LESSON:

When brute force tries
every possible pair,

ask whether two pointers
can eliminate impossible choices.


MOST IMPORTANT SENTENCE:

Start with the maximum width,
calculate the area,
and move the shorter pointer
because the shorter line
is limiting the container height.
```

---

# Final Pattern Summary

```text
Problem #1: Two Sum

Pattern:
HashMap Lookup


        ↓


Problem #12: Group Anagrams

Pattern:
Canonical Representation
+
HashMap Grouping


        ↓


Problem #16:
Top K Frequent Elements

Pattern:
Frequency Counting
+
Bucket Sort


        ↓


Problem #19:
Product of Array Except Self

Pattern:
Prefix
+
Suffix


        ↓


Problem #7:
Longest Substring Without
Repeating Characters

Pattern:
Variable-Size Sliding Window
+
Same-Direction Two Pointers
+
HashSet


        ↓


Problem #15:
Container With Most Water

Pattern:
Opposite-Direction
Two Pointers


CORE EVOLUTION:

Remember Information
        ↓
Group Information
        ↓
Count Information
        ↓
Precompute Information
        ↓
Maintain a Continuous Window
        ↓
Eliminate Impossible Pairs
```
