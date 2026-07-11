# Problem #3: Merge Intervals

**Difficulty:** Medium
**Category:** Intervals / Sorting
**Pattern Learned:** Sort → Compare → Merge
**Primary Technique:** Sorting + Greedy Merging
**Time Complexity:** `O(n log n)`
**Space Complexity:** `O(n)` for the output list

---

# Problem Statement

Given an array of intervals where:

```text
intervals[i] = [start, end]
```

merge all overlapping intervals and return an array of non-overlapping intervals.

---

# Example

```text
Input:

intervals = [[1,3], [2,6], [8,10], [15,18]]
```

Output:

```text
[[1,6], [8,10], [15,18]]
```

Why?

```text
[1,3]

and

[2,6]
```

overlap.

Therefore:

```text
[1,3] + [2,6]

        ↓

[1,6]
```

The other intervals do not overlap.

Final result:

```text
[[1,6], [8,10], [15,18]]
```

---

# Problem Classification

```text
PROBLEM

Problem #3:
Merge Intervals


        ↓


DIFFICULTY

Medium


        ↓


CATEGORY

Intervals / Sorting


        ↓


PATTERN

Sort

↓

Compare

↓

Merge
```

---

# Topics and Subtopics Covered

```text
Merge Intervals
        │
        ├── Arrays
        │
        ├── 2D Arrays
        │
        ├── int[][]
        │
        ├── Intervals
        │
        ├── Start and End Values
        │
        ├── Sorting
        │
        ├── Arrays.sort()
        │
        ├── Comparator
        │
        ├── Lambda Expressions
        │
        ├── Integer.compare()
        │
        ├── ArrayList
        │
        ├── List<int[]>
        │
        ├── Overlap Detection
        │
        ├── Math.max()
        │
        ├── Greedy Merging
        │
        ├── for Loop
        │
        ├── if / else
        │
        └── Big O Analysis
```

---

# 1. What is an Interval?

An interval represents a range.

Example:

```text
[1,3]
```

means:

```text
Start = 1

End = 3
```

General structure:

```text
[start, end]
```

Therefore:

```text
interval[0] = START

interval[1] = END
```

Example:

```java
int[] interval = {1, 3};
```

Then:

```text
interval[0] = 1

interval[1] = 3
```

---

# 2. What is `int[][]`?

The input is:

```java
int[][] intervals = {
    {1, 3},
    {2, 6},
    {8, 10},
    {15, 18}
};
```

Remember:

```text
int[]

=

Array of Integers
```

Therefore:

```text
int[][]

=

Array of int[] Arrays
```

Visually:

```text
intervals
    │
    ├── [1,3]
    ├── [2,6]
    ├── [8,10]
    └── [15,18]
```

Accessing intervals:

```text
intervals[0] = [1,3]

intervals[1] = [2,6]

intervals[2] = [8,10]

intervals[3] = [15,18]
```

Accessing values:

```text
intervals[0][0] = 1

intervals[0][1] = 3
```

Memory rule:

```text
intervals[i][0]

=

START


intervals[i][1]

=

END
```

---

# 3. What Does Overlapping Mean?

Consider:

```text
[1,3]

[2,6]
```

The first interval ends at:

```text
3
```

The next interval starts at:

```text
2
```

Check:

```text
2 <= 3
```

True.

Therefore:

```text
OVERLAP
```

The condition is:

```text
nextStart <= currentEnd
```

In Java:

```java
if (nextInterval[0] <= currentInterval[1])
```

---

# 4. What Are We Trying to Return?

Input:

```text
[[1,3], [2,6], [8,10], [15,18]]
```

Merge:

```text
[1,3] + [2,6]

↓

[1,6]
```

Keep:

```text
[8,10]
```

Keep:

```text
[15,18]
```

Return:

```text
[[1,6], [8,10], [15,18]]
```

The goal is:

```text
INPUT INTERVALS

        ↓

FIND OVERLAPS

        ↓

MERGE OVERLAPS

        ↓

RETURN NON-OVERLAPPING
MERGED INTERVALS
```

---

# 5. Real-World Example

Imagine calendar meetings.

```text
Meeting 1:

1 PM → 3 PM


Meeting 2:

2 PM → 6 PM
```

These meetings overlap.

Instead of storing:

```text
[1,3]

[2,6]
```

we can represent the complete occupied time as:

```text
[1,6]
```

The same pattern appears in:

```text
Calendar Scheduling

Meeting Times

Booking Systems

CPU Scheduling

Network Activity

Log Processing

Resource Allocation
```

---

# 6. Brute-Force Thinking

A beginner approach could be:

```text
Take One Interval

        ↓

Compare With Every Other Interval

        ↓

Find Overlap

        ↓

Merge

        ↓

Compare Again
```

Conceptually:

```java
for (int i = 0; i < intervals.length; i++) {

    for (int j = i + 1; j < intervals.length; j++) {

        // Compare intervals
    }
}
```

The outer loop selects one interval.

The inner loop compares it with remaining intervals.

This can lead toward:

```text
O(n²)
```

comparisons.

It also becomes complicated because after merging intervals, the newly merged interval may need to be compared again.

---

# 7. Why Sorting Helps

Consider:

```text
[[8,10], [1,3], [15,18], [2,6]]
```

The overlapping intervals:

```text
[1,3]

and

[2,6]
```

are far apart.

Sort by starting value.

Before:

```text
[[8,10], [1,3], [15,18], [2,6]]
```

After:

```text
[[1,3], [2,6], [8,10], [15,18]]
```

Now potentially overlapping intervals are next to each other.

Therefore:

```text
UNSORTED

Any Interval Could
Overlap With Another

        ↓

SORT BY START

        ↓

POTENTIAL OVERLAPS
BECOME NEIGHBORS

        ↓

COMPARE CURRENT
WITH NEXT
```

This is the main insight of the problem.

---

# 8. Sorting the Intervals

Code:

```java
Arrays.sort(
    intervals,
    (a, b) -> Integer.compare(a[0], b[0])
);
```

Human meaning:

```text
SORT INTERVALS

        ↓

TAKE TWO INTERVALS

a and b

        ↓

COMPARE THEIR
START VALUES

a[0] and b[0]

        ↓

SMALLEST START FIRST
```

Example:

```text
a = [8,10]

b = [1,3]
```

Then:

```text
a[0] = 8

b[0] = 1
```

Java compares:

```java
Integer.compare(8, 1)
```

Since `8` is greater than `1`:

```text
[8,10]
```

should come after:

```text
[1,3]
```

---

# 9. Understanding the Lambda Expression

```java
(a, b) -> Integer.compare(a[0], b[0])
```

Break it down:

```text
(a, b)

↓

Take Two Intervals


->

↓

Apply This Rule


Integer.compare(a[0], b[0])

↓

Compare Their Start Values
```

Human translation:

> Take two intervals and sort them according to their starting values.

---

# 10. Why `Integer.compare()`?

```java
Integer.compare(a[0], b[0])
```

returns:

```text
Negative

↓

a Comes Before b
```

```text
Zero

↓

Equal Sorting Position
```

```text
Positive

↓

a Comes After b
```

Therefore:

```java
Integer.compare(a[0], b[0])
```

sorts by starting values in ascending order.

---

# 11. How Do We Detect Overlap?

After sorting:

```text
Current = [1,3]

Next = [2,6]
```

Check:

```text
nextStart <= currentEnd
```

Substitute:

```text
2 <= 3
```

True.

Therefore:

```text
OVERLAP
```

Code:

```java
if (nextInterval[0] <= currentInterval[1])
```

Memory rule:

```text
NEXT START

<=

CURRENT END

↓

OVERLAP
```

---

# 12. Why Is Sorting Important for the Overlap Condition?

Normally, checking overlap between arbitrary intervals can require more logic.

But sorting gives us:

```text
currentStart <= nextStart
```

Therefore, we only need to ask:

```text
Does the Next Interval Start
Before the Current Interval Ends?
```

Condition:

```text
nextStart <= currentEnd
```

Sorting simplifies the problem.

---

# 13. How Does Merging Work?

Consider:

```text
Current = [1,3]

Next = [2,6]
```

They overlap.

The merged start remains:

```text
1
```

The merged end should be the furthest ending value.

Therefore:

```text
max(3,6)

=

6
```

Merged result:

```text
[1,6]
```

Code:

```java
currentInterval[1] =
    Math.max(
        currentInterval[1],
        nextInterval[1]
    );
```

---

# 14. Why Is `Math.max()` Needed?

Consider:

```text
Current = [1,10]

Next = [2,6]
```

They overlap.

If we simply write:

```text
currentEnd = nextEnd
```

we get:

```text
[1,6]
```

which is wrong.

The current interval already extends to `10`.

Therefore:

```text
Math.max(10,6)

=

10
```

Correct result:

```text
[1,10]
```

Memory rule:

```text
OVERLAP

        ↓

KEEP CURRENT START

        ↓

CHOOSE FURTHEST END

        ↓

Math.max(currentEnd, nextEnd)
```

---

# 15. Why Use `ArrayList`?

We do not know how many intervals will remain after merging.

Example:

```text
4 Input Intervals

↓

Could Become

1 Interval

2 Intervals

3 Intervals

or

4 Intervals
```

Arrays have fixed sizes.

An `ArrayList` can grow dynamically.

Therefore:

```java
List<int[]> mergedIntervals = new ArrayList<>();
```

is used.

---

# 16. Understanding `List<int[]>`

```text
int[]

=

One Integer Array

=

One Interval
```

Therefore:

```text
List<int[]>

=

A List Containing
Multiple Intervals
```

Visually:

```text
mergedIntervals
        │
        ├── [1,6]
        ├── [8,10]
        └── [15,18]
```

Memory rule:

```text
List<Integer>[]

=

ARRAY OF LISTS


List<int[]>

=

LIST OF ARRAYS
```

---

# 17. Optimal Java Solution

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[][] merge(int[][] intervals) {

        // Sort intervals by their starting values
        Arrays.sort(
            intervals,
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Store completed merged intervals dynamically
        List<int[]> mergedIntervals = new ArrayList<>();

        // Start with the first interval as the current interval
        int[] currentInterval = intervals[0];

        // Compare the current interval with every remaining interval
        for (int i = 1; i < intervals.length; i++) {

            // Get the next interval
            int[] nextInterval = intervals[i];

            // Check whether the current and next intervals overlap
            if (nextInterval[0] <= currentInterval[1]) {

                // Extend the current interval to the furthest ending point
                currentInterval[1] =
                    Math.max(
                        currentInterval[1],
                        nextInterval[1]
                    );

            } else {

                // Save the completed current interval
                mergedIntervals.add(currentInterval);

                // Start processing a new interval
                currentInterval = nextInterval;
            }
        }

        // Add the final current interval
        mergedIntervals.add(currentInterval);

        // Convert the result list to int[][] and return it
        return mergedIntervals.toArray(
            new int[mergedIntervals.size()][]
        );
    }
}
```

---

# 18. Complete Code Flow

```text
START

        ↓

RECEIVE int[][] intervals

        ↓

SORT BY START VALUE

        ↓

CREATE EMPTY ARRAYLIST

        ↓

FIRST INTERVAL
BECOMES CURRENT

        ↓

START LOOP
FROM SECOND INTERVAL

        ↓

GET NEXT INTERVAL

        ↓

CHECK:

nextStart <= currentEnd?

       /                \

     YES                 NO

      ↓                   ↓

  OVERLAP             NO OVERLAP

      ↓                   ↓

UPDATE CURRENT END     ADD CURRENT
WITH Math.max()        TO RESULT

                          ↓

                     NEXT BECOMES
                     NEW CURRENT

       \                  /

        \                /

             CONTINUE

                ↓

           LOOP FINISHES

                ↓

       ADD FINAL CURRENT

                ↓

       CONVERT List<int[]>

                ↓

             int[][]

                ↓

             RETURN
```

---

# 19. Complete Dry Run

Input:

```text
[[1,3], [2,6], [8,10], [15,18]]
```

After sorting:

```text
[[1,3], [2,6], [8,10], [15,18]]
```

Initialize:

```text
mergedIntervals = []

currentInterval = [1,3]
```

## Iteration 1

```text
Current:

[1,3]


Next:

[2,6]
```

Check:

```text
nextStart <= currentEnd

2 <= 3

TRUE
```

Therefore:

```text
OVERLAP
```

Merge:

```text
currentEnd =
Math.max(3,6)

=

6
```

Current becomes:

```text
[1,6]
```

Result list:

```text
[]
```

We do not add `[1,6]` yet because future intervals may also overlap.

---

## Iteration 2

Current:

```text
[1,6]
```

Next:

```text
[8,10]
```

Check:

```text
8 <= 6
```

False.

Therefore:

```text
NO OVERLAP
```

Add current:

```text
mergedIntervals = [[1,6]]
```

Make next the new current:

```text
currentInterval = [8,10]
```

---

## Iteration 3

Current:

```text
[8,10]
```

Next:

```text
[15,18]
```

Check:

```text
15 <= 10
```

False.

Add current:

```text
mergedIntervals =
[
    [1,6],
    [8,10]
]
```

Make next the new current:

```text
currentInterval = [15,18]
```

---

## Loop Ends

The final current interval has not yet been added.

Therefore:

```java
mergedIntervals.add(currentInterval);
```

Result:

```text
[
    [1,6],
    [8,10],
    [15,18]
]
```

Return:

```text
[[1,6], [8,10], [15,18]]
```

---

# 20. Why Do We Add the Final Interval Outside the Loop?

Inside the loop, we add `currentInterval` only when we find:

```text
NO OVERLAP
```

But the final current interval has no next interval.

Therefore, the loop finishes before it can be added.

So:

```java
mergedIntervals.add(currentInterval);
```

must happen after the loop.

---

# 21. Why Does the Loop Start at `1`?

Before the loop:

```java
int[] currentInterval = intervals[0];
```

We already selected:

```text
Index 0
```

as the current interval.

Therefore, the first interval we need to compare is:

```text
Index 1
```

So:

```java
for (int i = 1; i < intervals.length; i++)
```

starts from `1`.

---

# 22. Big O Analysis

## Sorting

```java
Arrays.sort(intervals, comparator);
```

Sorting takes:

```text
O(n log n)
```

---

## Traversing the Intervals

The `for` loop visits each interval once.

```text
O(n)
```

---

## Total Time Complexity

```text
O(n log n)

+

O(n)
```

The dominant term is:

```text
O(n log n)
```

Therefore:

```text
Time Complexity = O(n log n)
```

---

# 23. Space Complexity

The result list may store up to `n` intervals.

Therefore:

```text
Space Complexity = O(n)
```

Important interview note:

The exact auxiliary-space analysis can depend on whether output storage and the sorting implementation's internal space are counted. For the common solution explanation, the dynamic result can contain up to `n` intervals.

---

# 24. Why Is This Greedy-Style Processing?

After sorting, we maintain one current merged interval.

For every next interval:

```text
OVERLAP?

        ↓

YES

        ↓

MERGE IMMEDIATELY
```

Otherwise:

```text
NO OVERLAP

        ↓

FINALIZE CURRENT

        ↓

START NEW CURRENT
```

We make the best safe decision based on the current sorted interval and never need to revisit finalized intervals.

However, the primary pattern should be remembered as:

```text
Intervals + Sorting

↓

Sort → Compare → Merge
```

---

# 25. Pattern Recognition

When you see:

```text
Ranges

Time Periods

Start and End Values

Bookings

Meetings

Schedules

Overlapping Segments
```

ask:

```text
Are the intervals sorted?

        ↓

NO

        ↓

SORT BY START


        ↓


KEEP ONE CURRENT INTERVAL


        ↓


COMPARE WITH NEXT


        ↓


nextStart <= currentEnd?

        ↓

YES → MERGE

NO → SAVE CURRENT
```

Think:

```text
MERGE INTERVALS PATTERN
```

---

# 26. Interview Explanation

A brute-force approach could compare every interval with every other interval, leading toward `O(n²)` comparisons and complicated repeated merging.

To optimize the problem, I first sort all intervals by their starting values. This ensures that potentially overlapping intervals appear next to each other.

I maintain one `currentInterval` and compare it with each `nextInterval`.

If:

```text
nextStart <= currentEnd
```

the intervals overlap, so I extend the current interval's ending value using:

```text
Math.max(currentEnd, nextEnd)
```

If they do not overlap, the current interval is complete, so I add it to the result and make the next interval the new current interval.

After processing all intervals, I add the final current interval.

Sorting takes `O(n log n)` time, and the traversal takes `O(n)` time, giving an overall time complexity of `O(n log n)`.

---

# 27. Short Interview Revision Notes

```text
PROBLEM:

Problem #3
Merge Intervals


DIFFICULTY:

Medium


CATEGORY:

Intervals / Sorting


PATTERN:

Sort
→
Compare
→
Merge


INPUT:

int[][]


ONE INTERVAL:

int[]


INTERVAL STRUCTURE:

[start, end]


START:

interval[0]


END:

interval[1]


BRUTE FORCE:

Compare Intervals
Repeatedly


TIME:

Toward O(n²)


OPTIMIZATION:

Sort By Start


WHY SORT?

Potentially Overlapping
Intervals Become Neighbors


SORTING CODE:

Arrays.sort(
    intervals,
    (a, b) ->
        Integer.compare(a[0], b[0])
);


OVERLAP CONDITION:

nextStart <= currentEnd


JAVA:

nextInterval[0]
<=
currentInterval[1]


IF OVERLAP:

MERGE


HOW TO MERGE:

Keep Current Start

+

Choose Furthest End


JAVA:

currentInterval[1] =
Math.max(
    currentInterval[1],
    nextInterval[1]
);


IF NO OVERLAP:

Save Current

+

Next Becomes
New Current


WHY ARRAYLIST?

Final Output Size
Is Unknown


RESULT TYPE WHILE PROCESSING:

List<int[]>


RETURN TYPE:

int[][]


WHY LOOP STARTS AT 1?

Index 0 Is Already
the Current Interval


WHY ADD AFTER LOOP?

Final Current Interval
Has No Next Interval
to Trigger Its Addition


TIME COMPLEXITY:

O(n log n)


SPACE COMPLEXITY:

O(n)


CORE FLOW:

Sort
↓
Current = First
↓
Compare With Next
↓
Overlap?
 /      \
Yes      No
 ↓        ↓
Merge    Save Current
          ↓
         Next = Current
↓
Continue
↓
Add Final Current
↓
Return


ONE-LINE MEMORY RULE:

Sort intervals by start,
merge when the next start
is less than or equal to
the current end; otherwise,
save the current interval
and start a new one.
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

Prefix / Suffix


Problem #7:
Longest Substring Without
Repeating Characters

↓

Sliding Window


Problem #15:
Container With Most Water

↓

Opposite-Direction
Two Pointers


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
```

---

# Final Takeaway

```text
UNSORTED INTERVALS

        ↓

SORT BY START

        ↓

KEEP CURRENT INTERVAL

        ↓

COMPARE WITH NEXT

        ↓

nextStart <= currentEnd?

       /              \

     YES               NO

      ↓                 ↓

    MERGE          SAVE CURRENT

      ↓                 ↓

EXTEND END         NEXT BECOMES
WITH Math.max()    NEW CURRENT

        ↓

      CONTINUE

        ↓

ADD FINAL CURRENT

        ↓

RETURN RESULT
```

The most important lesson from **Problem #3: Merge Intervals** is:

> **Sorting can transform a problem where every element may need to be compared with every other element into a structured one-pass process.**

The core pattern to remember is:

```text
SORT → COMPARE → MERGE
```
