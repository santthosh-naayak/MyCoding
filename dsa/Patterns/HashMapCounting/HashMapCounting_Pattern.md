# Problem #16: Top K Frequent Elements

**Difficulty:** Medium
**Category:** Heap / Hashing
**Pattern:** Frequency Counting + Top K
**Optimal Technique:** HashMap + Bucket Sort
**Data Structures:** `HashMap<Integer, Integer>` + `List<Integer>[]`

---

# Problem Statement

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

The answer can be returned in any order.

## Example 1

```text
Input:

nums = [1, 1, 1, 2, 2, 3]

k = 2
```

```text
Output:

[1, 2]
```

## Explanation

Count how many times each number appears:

```text
NUMBER        FREQUENCY

1       →         3

2       →         2

3       →         1
```

The two most frequent elements are:

```text
1 → appears 3 times

2 → appears 2 times
```

Therefore:

```text
Answer = [1, 2]
```

---

# Example 2

```text
Input:

nums = [1]

k = 1
```

```text
Output:

[1]
```

There is only one number.

Therefore, the one most frequent element is:

```text
[1]
```

---

# Problem Classification

```text
PROBLEM
   │
   ▼
Problem #16: Top K Frequent Elements


DIFFICULTY
   │
   ▼
Medium


CATEGORY
   │
   ▼
Heap / Hashing


PATTERN
   │
   ▼
Frequency Counting
+
Top K


OPTIMAL TECHNIQUE
   │
   ▼
HashMap
+
Bucket Sort


DATA STRUCTURES
   │
   ▼
HashMap<Integer, Integer>
+
List<Integer>[]


CORE LOGIC
   │
   ▼
Count Frequencies
        +
Group Numbers by Frequency
        +
Collect K Most Frequent Elements
```

---

# Connection to Previous Problems

We are learning the problems pattern by pattern.

So far:

```text
Problem #1: Two Sum
        ↓
HashMap for LOOKUP


Problem #12: Group Anagrams
        ↓
HashMap for GROUPING


Problem #16: Top K Frequent Elements
        ↓
HashMap for COUNTING
```

This is an important progression.

---

## Problem #1: Two Sum

We stored:

```text
Number → Index
```

Example:

```text
2 → 0

7 → 1
```

The HashMap was used for:

```text
LOOKUP
```

The main question was:

```text
Have I already seen
the number I need?
```

---

## Problem #12: Group Anagrams

We stored:

```text
Signature → List of Words
```

Example:

```text
"aet" → ["eat", "tea", "ate"]

"ant" → ["tan", "nat"]
```

The HashMap was used for:

```text
GROUPING
```

The main question was:

```text
Which group does
this word belong to?
```

---

## Problem #16: Top K Frequent Elements

Now we store:

```text
Number → Frequency
```

Example:

```text
1 → 3

2 → 2

3 → 1
```

The HashMap is used for:

```text
COUNTING
```

The main question is:

```text
How many times does
each number appear?
```

---

# HashMap Learning Progression

```text
Problem #1: Two Sum

Number → Index

Purpose:
LOOKUP


        ↓


Problem #12: Group Anagrams

Signature → List of Words

Purpose:
GROUPING


        ↓


Problem #16: Top K Frequent Elements

Number → Frequency

Purpose:
COUNTING
```

The important lesson is:

```text
Same Data Structure

        ↓

Different Problems

        ↓

Different Purposes
```

---

# Topics and Subtopics Covered

```text
Top K Frequent Elements
          │
          ├── Arrays
          │
          ├── HashMap
          │     ├── Key
          │     ├── Value
          │     ├── put()
          │     ├── getOrDefault()
          │     └── entrySet()
          │
          ├── Frequency Counting
          │
          ├── Bucket Sort
          │
          ├── Array of Lists
          │     └── List<Integer>[]
          │
          ├── ArrayList
          │
          ├── Enhanced For Loop
          │
          ├── Reverse Traversal
          │
          ├── Top K Pattern
          │
          ├── Brute Force
          │
          ├── Sorting Approach
          │
          ├── Heap Approach
          │
          ├── Bucket Sort Approach
          │
          └── Big O Analysis
```

---

# First Understand: What Does `K` Mean?

You will see `K` in many interview problems.

For example:

```text
k = 1
```

means:

```text
Return the best 1 result.
```

If:

```text
k = 2
```

it means:

```text
Return the best 2 results.
```

If:

```text
k = 3
```

it means:

```text
Return the best 3 results.
```

Therefore:

```text
TOP K

means

Return the best K results
according to some condition.
```

In this problem, the condition is:

```text
FREQUENCY
```

Therefore:

```text
TOP K FREQUENT ELEMENTS

means

Return the K numbers
that appear most often.
```

---

# Real-World Example

Imagine a search engine wants to find the most common search queries.

Searches:

```text
Java

Python

Java

C++

Java

Python
```

Count the searches:

```text
Java    → 3

Python  → 2

C++     → 1
```

Suppose:

```text
k = 2
```

The two most frequent searches are:

```text
Java

Python
```

The process is:

```text
Raw Data
   ↓
Count Occurrences
   ↓
Find Highest Frequencies
   ↓
Return K Results
```

This is exactly the logic behind Top K Frequent Elements.

---

# Beginner Thinking

Given:

```text
nums = [1, 1, 1, 2, 2, 3]

k = 2
```

Ask:

```text
What do I need?
```

Answer:

```text
The 2 most frequent numbers.
```

Now ask:

```text
Before finding the most frequent numbers,
what information do I need?
```

Answer:

```text
I need to know how many times
each number appears.
```

Therefore:

```text
Top K Frequent Elements
          ↓
Need Frequencies
          ↓
Count Every Element
```

Now ask:

```text
Which data structure can store
a number and its frequency?
```

Answer:

```text
HashMap
```

Because a HashMap can store:

```text
Number → Frequency
```

Example:

```text
1 → 3

2 → 2

3 → 1
```

Therefore, the first stage of the solution is:

```text
FREQUENCY COUNTING
```

---

# Approach 1: Brute Force

The simplest approach is:

```text
Take One Number
       ↓
Search Entire Array
       ↓
Count Its Occurrences
```

For example:

```text
nums = [1, 1, 1, 2, 2, 3]
```

Take:

```text
1
```

Search the entire array:

```text
[1, 1, 1, 2, 2, 3]
 ↑  ↑  ↑
```

Count:

```text
1 appears 3 times
```

Next take:

```text
2
```

Search the entire array:

```text
[1, 1, 1, 2, 2, 3]
          ↑  ↑
```

Count:

```text
2 appears 2 times
```

Next:

```text
3
```

Search again.

Count:

```text
3 appears 1 time
```

The general logic is:

```text
For Every Number
        ↓
Search Entire Array
        ↓
Count Occurrences
```

---

# Why Is Brute Force Slow?

Suppose there are:

```text
n elements
```

For every number, we may search the entire array.

Therefore:

```text
n × n
```

which gives:

```text
O(n²)
```

The main problem is:

```text
REPEATED SEARCHING
```

We repeatedly scan the array to count the same information.

So we ask:

```text
Can I count each number
while traversing the array only once?
```

The answer is:

```text
YES
```

That gives us the first important pattern.

---

# Pattern 1: Frequency Counting

The core idea is:

```text
Visit Number
     ↓
Check Current Frequency
     ↓
Increase Frequency by 1
```

For example:

```text
nums = [1, 1, 1, 2, 2, 3]
```

Initially:

```text
frequencyMap = {}
```

---

## Visit First `1`

Current map:

```text
{}
```

The number `1` has not been seen before.

Store:

```text
1 → 1
```

Map:

```text
{
    1 → 1
}
```

---

## Visit Second `1`

Current frequency:

```text
1
```

Increase it:

```text
1 + 1 = 2
```

Map:

```text
{
    1 → 2
}
```

---

## Visit Third `1`

Current frequency:

```text
2
```

Increase:

```text
2 + 1 = 3
```

Map:

```text
{
    1 → 3
}
```

---

## Visit First `2`

The number `2` does not exist.

Start its frequency at:

```text
1
```

Map:

```text
{
    1 → 3,

    2 → 1
}
```

---

## Visit Second `2`

Current frequency:

```text
1
```

Increase:

```text
1 + 1 = 2
```

Map:

```text
{
    1 → 3,

    2 → 2
}
```

---

## Visit `3`

The number `3` does not exist.

Start:

```text
3 → 1
```

Final map:

```text
{
    1 → 3,

    2 → 2,

    3 → 1
}
```

---

# Frequency Counting Code

```java
Map<Integer, Integer> frequencyMap = new HashMap<>();

for (int number : nums) {

    frequencyMap.put(
        number,
        frequencyMap.getOrDefault(number, 0) + 1
    );
}
```

The most important line is:

```java
frequencyMap.put(
    number,
    frequencyMap.getOrDefault(number, 0) + 1
);
```

Human translation:

```text
Get the current frequency
        ↓
If the number does not exist,
use 0
        ↓
Add 1
        ↓
Store the updated frequency
```

---

# Understanding `getOrDefault()`

Consider:

```java
frequencyMap.getOrDefault(number, 0)
```

Human translation:

```text
Give me the current value
for this number.

If the number does not exist,
give me 0 instead.
```

Suppose:

```text
frequencyMap = {}
```

Current number:

```text
1
```

Execute:

```java
frequencyMap.getOrDefault(1, 0)
```

Since `1` does not exist:

```text
Result = 0
```

Then:

```text
0 + 1 = 1
```

Store:

```text
1 → 1
```

---

## Next Time We See `1`

Map:

```text
1 → 1
```

Execute:

```java
frequencyMap.getOrDefault(1, 0)
```

Now `1` exists.

Therefore:

```text
Result = 1
```

Then:

```text
1 + 1 = 2
```

Store:

```text
1 → 2
```

Therefore:

```java
frequencyMap.put(
    number,
    frequencyMap.getOrDefault(number, 0) + 1
);
```

simply means:

```text
Increase the frequency
of the current number by 1.
```

---

# After Frequency Counting

Now we have:

```text
NUMBER → FREQUENCY

1 → 3

2 → 2

3 → 1
```

But the problem is not finished.

We still need:

```text
The K most frequent numbers.
```

For:

```text
k = 2
```

we need:

```text
[1, 2]
```

Now we need a strategy for finding the highest frequencies.

There are several approaches.

---

# Different Approaches

The important approaches are:

```text
1. Brute Force

2. Sorting

3. Min Heap

4. Bucket Sort
```

Their general time complexities are:

| Approach    | Time Complexity                            |
| ----------- | ------------------------------------------ |
| Brute Force | O(n²) or worse depending on implementation |
| Sorting     | O(n log n)                                 |
| Min Heap    | O(n log k)                                 |
| Bucket Sort | O(n)                                       |

For the optimal solution, we use:

```text
HashMap
+
Bucket Sort
```

---

# Why Use Bucket Sort?

After frequency counting:

```text
NUMBER → FREQUENCY

1 → 3

2 → 2

3 → 1
```

Notice the relationship:

```text
Number → Frequency
```

What if we reverse it?

```text
Frequency → Numbers
```

Then:

```text
1 → [3]

2 → [2]

3 → [1]
```

This is the main idea behind the bucket approach.

---

# Understanding Buckets

Suppose:

```text
nums = [1, 1, 1, 2, 2, 3]
```

The array length is:

```text
6
```

What is the maximum possible frequency?

A number could appear at most:

```text
6 times
```

For example:

```text
[1, 1, 1, 1, 1, 1]
```

Therefore, possible frequencies are:

```text
0

1

2

3

4

5

6
```

So we create buckets:

```text
INDEX / FREQUENCY

0 → null

1 → null

2 → null

3 → null

4 → null

5 → null

6 → null
```

Then place numbers into buckets according to their frequencies.

Our frequency map is:

```text
1 → 3

2 → 2

3 → 1
```

Therefore:

```text
Bucket 1 → [3]

Bucket 2 → [2]

Bucket 3 → [1]
```

Visualize:

```text
BUCKET INDEX       NUMBERS

0              →   null

1              →   [3]

2              →   [2]

3              →   [1]

4              →   null

5              →   null

6              →   null
```

The index represents:

```text
FREQUENCY
```

The value represents:

```text
NUMBERS WITH THAT FREQUENCY
```

---

# Why Is the Bucket an Array of Lists?

We use:

```java
List<Integer>[] buckets
```

Why not:

```java
int[] buckets
```

Because multiple numbers can have the same frequency.

Consider:

```text
nums = [1, 1, 2, 2, 3]
```

Frequency map:

```text
1 → 2

2 → 2

3 → 1
```

Notice:

```text
1 and 2
```

both have frequency:

```text
2
```

Therefore:

```text
Bucket 2
```

must store:

```text
[1, 2]
```

One bucket may contain multiple numbers.

Therefore, every bucket needs a:

```java
List<Integer>
```

And because we have multiple buckets:

```java
List<Integer>[]
```

Human translation:

```text
Array
  ↓
where every position
  ↓
can contain a List of Integers
```

Visualize:

```text
ARRAY
│
├── Index 0 → null
│
├── Index 1 → [3]
│
├── Index 2 → [1, 2]
│
└── Index 3 → null
```

---

# Creating the Buckets

```java
List<Integer>[] buckets = new List[nums.length + 1];
```

Why:

```text
nums.length + 1
```

Suppose:

```text
nums.length = 6
```

Possible frequencies are:

```text
1 through 6
```

But Java array indices start at:

```text
0
```

Therefore, we need indices:

```text
0, 1, 2, 3, 4, 5, 6
```

That requires an array size of:

```text
7
```

Therefore:

```text
nums.length + 1
```

---

# Moving HashMap Data Into Buckets

We use:

```java
for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet())
```

The frequency map contains:

```text
1 → 3

2 → 2

3 → 1
```

Every entry contains:

```text
KEY
+
VALUE
```

For example:

```text
1 → 3
```

means:

```text
Key   = 1

Value = 3
```

Therefore:

```java
int number = entry.getKey();
```

gets:

```text
1
```

And:

```java
int frequency = entry.getValue();
```

gets:

```text
3
```

---

# Why Check for `null`?

```java
if (buckets[frequency] == null) {
    buckets[frequency] = new ArrayList<>();
}
```

Initially:

```text
buckets[3] = null
```

We cannot do:

```java
buckets[3].add(1);
```

because there is no list yet.

Therefore:

```text
Is Bucket Empty / null?
        ↓
YES
        ↓
Create New ArrayList
```

Then:

```java
buckets[frequency].add(number);
```

adds the number.

---

# Example of Filling the Buckets

Frequency map:

```text
1 → 3

2 → 2

3 → 1
```

First entry:

```text
number = 1

frequency = 3
```

Bucket `3` is `null`.

Create:

```text
buckets[3] = []
```

Add:

```text
buckets[3] = [1]
```

---

Second entry:

```text
number = 2

frequency = 2
```

Create:

```text
buckets[2] = []
```

Add:

```text
buckets[2] = [2]
```

---

Third entry:

```text
number = 3

frequency = 1
```

Create:

```text
buckets[1] = []
```

Add:

```text
buckets[1] = [3]
```

Final buckets:

```text
0 → null

1 → [3]

2 → [2]

3 → [1]

4 → null

5 → null

6 → null
```

---

# Why Traverse the Buckets Backwards?

We want:

```text
MOST FREQUENT ELEMENTS
```

Higher bucket index means:

```text
HIGHER FREQUENCY
```

Example:

```text
Bucket 1 → appeared 1 time

Bucket 2 → appeared 2 times

Bucket 3 → appeared 3 times
```

Therefore, we start from the end.

```text
Highest Frequency
       ↓
Lower Frequency
       ↓
Lower Frequency
```

Code:

```java
for (
    int frequency = buckets.length - 1;
    frequency >= 0;
    frequency--
)
```

This is called:

```text
REVERSE TRAVERSAL
```

---

# Creating the Result Array

```java
int[] result = new int[k];
```

Suppose:

```text
k = 2
```

Then:

```text
result = [0, 0]
```

We need exactly:

```text
2 answers
```

Therefore, the result array size is:

```text
k
```

---

# Why Do We Need `index`?

```java
int index = 0;
```

The variable `index` tells us:

```text
Where should I place
the next answer?
```

Initially:

```text
result = [0, 0]
          ↑
        index 0
```

After adding the first answer:

```text
result = [1, 0]
             ↑
           index 1
```

After adding the second answer:

```text
result = [1, 2]
```

Now:

```text
index == k
```

Therefore, we have collected enough answers.

---

# Collecting the Top K Elements

```java
if (buckets[frequency] != null) {

    for (int number : buckets[frequency]) {

        result[index] = number;

        index++;

        if (index == k) {
            return result;
        }
    }
}
```

Human translation:

```text
Does This Bucket Contain Numbers?
            ↓
YES
            ↓
Visit Every Number in Bucket
            ↓
Add Number to Result
            ↓
Increase Result Index
            ↓
Collected K Numbers?
        /           \
      YES            NO
       ↓              ↓
     Return         Continue
```

---

# Complete Java Solution

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int number : nums) {

            frequencyMap.put(
                number,
                frequencyMap.getOrDefault(number, 0) + 1
            );
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            int number = entry.getKey();

            int frequency = entry.getValue();

            if (buckets[frequency] == null) {

                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(number);
        }

        int[] result = new int[k];

        int index = 0;

        for (
            int frequency = buckets.length - 1;
            frequency >= 0;
            frequency--
        ) {

            if (buckets[frequency] != null) {

                for (int number : buckets[frequency]) {

                    result[index] = number;

                    index++;

                    if (index == k) {

                        return result;
                    }
                }
            }
        }

        return result;
    }
}
```

---

# Complete Dry Run

Input:

```text
nums = [1, 1, 1, 2, 2, 3]

k = 2
```

## Step 1: Count Frequencies

Start:

```text
{}
```

Process `1`:

```text
1 → 1
```

Process `1`:

```text
1 → 2
```

Process `1`:

```text
1 → 3
```

Process `2`:

```text
1 → 3

2 → 1
```

Process `2`:

```text
1 → 3

2 → 2
```

Process `3`:

```text
1 → 3

2 → 2

3 → 1
```

Final:

```text
frequencyMap = {

    1 → 3,

    2 → 2,

    3 → 1
}
```

---

## Step 2: Create Buckets

```text
0 → null

1 → [3]

2 → [2]

3 → [1]

4 → null

5 → null

6 → null
```

---

## Step 3: Create Result

```text
result = [0, 0]

index = 0
```

---

## Step 4: Traverse Backwards

Start from:

```text
frequency = 6
```

Bucket:

```text
null
```

Continue.

Frequency:

```text
5
```

Bucket:

```text
null
```

Continue.

Frequency:

```text
4
```

Bucket:

```text
null
```

Continue.

Frequency:

```text
3
```

Bucket:

```text
[1]
```

Add:

```text
result = [1, 0]
```

Increase:

```text
index = 1
```

Check:

```text
index == k?

1 == 2?

NO
```

Continue.

Frequency:

```text
2
```

Bucket:

```text
[2]
```

Add:

```text
result = [1, 2]
```

Increase:

```text
index = 2
```

Check:

```text
index == k?

2 == 2?

YES
```

Return:

```text
[1, 2]
```

---

# Time Complexity

Let:

```text
n = number of elements
```

## Step 1: Frequency Counting

We visit every element once.

```text
O(n)
```

## Step 2: Fill Buckets

We visit every unique number.

At most, there can be `n` unique numbers.

```text
O(n)
```

## Step 3: Reverse Traversal

We traverse the bucket array.

Its size is:

```text
n + 1
```

Therefore:

```text
O(n)
```

Total:

```text
O(n)
+
O(n)
+
O(n)
```

Big O removes constants.

Therefore:

```text
O(n)
```

---

# Space Complexity

We use:

```text
Frequency HashMap

+

Bucket Array

+

Result Array
```

The HashMap can store up to:

```text
n elements
```

The buckets can also store up to:

```text
n elements
```

Therefore:

```text
Space Complexity = O(n)
```

---

# Complexity Summary

| Approach    | Time Complexity |                Space Complexity |
| ----------- | --------------: | ------------------------------: |
| Brute Force |  O(n²) or worse |       Depends on implementation |
| Sorting     |      O(n log n) |                            O(n) |
| Min Heap    |      O(n log k) | O(n) for the map plus O(k) heap |
| Bucket Sort |            O(n) |                            O(n) |

---

# Why Is Bucket Sort the Optimal Approach?

The problem gives us an important constraint:

```text
Maximum Frequency
≤
Array Length
```

Therefore, we can use frequency as an array index.

```text
Frequency
    ↓
Bucket Index
```

This allows us to avoid sorting frequencies.

Instead of:

```text
Count
   ↓
Sort
   ↓
Find Top K
```

we use:

```text
Count
   ↓
Place Into Frequency Buckets
   ↓
Traverse Backwards
   ↓
Find Top K
```

This reduces the time complexity from:

```text
O(n log n)
```

to:

```text
O(n)
```

---

# Pattern Recognition

When you see phrases like:

```text
Most Frequent

Least Frequent

Top K

K Most Common

Highest Frequency

Most Popular
```

think:

```text
Do I need to count occurrences?
        ↓
YES
        ↓
HashMap Frequency Counting
```

Then ask:

```text
How do I find the Top K?
        ↓
Heap?
        ↓
Bucket Sort?
```

The general pattern is:

```text
Raw Data
   ↓
Frequency Counting
   ↓
Number → Frequency
   ↓
Organize by Frequency
   ↓
Find Top K
```

---

# Interview Explanation

The brute-force approach would repeatedly scan the array to count the occurrences of each number, which causes repeated work.

Instead, I first use a HashMap to count the frequency of every number in `O(n)` time.

The HashMap stores:

```text
Number → Frequency
```

Next, I create a bucket array where the index represents a frequency and each position stores a list of numbers having that frequency.

This reverses the relationship:

```text
Number → Frequency
```

into:

```text
Frequency → Numbers
```

Since a number can appear at most `n` times, the bucket array has a size of `n + 1`.

Finally, I traverse the buckets from the highest frequency to the lowest frequency and collect numbers until I have found `k` elements.

The overall time complexity is `O(n)` and the space complexity is `O(n)`.

---

# Short Interview Revision Notes

```text
PROBLEM:

Problem #16:
Top K Frequent Elements


DIFFICULTY:

Medium


CATEGORY:

Heap / Hashing


PATTERN:

Frequency Counting
+
Top K


OPTIMAL TECHNIQUE:

HashMap
+
Bucket Sort


DATA STRUCTURES:

HashMap<Integer, Integer>

+

List<Integer>[]


PROBLEM:

Return the K numbers
that appear most frequently.


WHAT DOES K MEAN?

Return the best K results
according to some condition.


BRUTE FORCE:

For Every Number
       ↓
Search Entire Array
       ↓
Count Occurrences


PROBLEM WITH BRUTE FORCE:

Repeated Searching


FIRST OPTIMIZATION:

Count frequencies
in one traversal.


HASHMAP:

Number → Frequency


EXAMPLE:

1 → 3

2 → 2

3 → 1


FREQUENCY COUNTING:

frequencyMap.put(
    number,
    frequencyMap.getOrDefault(number, 0) + 1
);


getOrDefault():

If Number Exists
        ↓
Return Current Frequency

If Number Does Not Exist
        ↓
Return 0


AFTER COUNTING:

Need to find
K highest frequencies.


OPTIMAL IDEA:

Use Bucket Sort.


BUCKET RELATIONSHIP:

Frequency → Numbers


EXAMPLE:

1 → [3]

2 → [2]

3 → [1]


WHY ARRAY OF LISTS?

Multiple numbers can have
the same frequency.


WHY nums.length + 1?

Maximum frequency
can be nums.length.


WHY REVERSE TRAVERSAL?

Highest bucket index
=
Highest frequency.


ALGORITHM:

Count Frequencies
        ↓
Create Buckets
        ↓
Place Numbers Into Buckets
        ↓
Traverse Buckets Backwards
        ↓
Collect K Elements
        ↓
Return Result


TIME COMPLEXITY:

O(n)


WHY?

Frequency Counting:
O(n)

Fill Buckets:
O(n)

Reverse Traversal:
O(n)

Total:

O(n)


SPACE COMPLEXITY:

O(n)


CONNECTION TO PREVIOUS PROBLEMS:

Problem #1: Two Sum

HashMap for LOOKUP


Problem #12: Group Anagrams

HashMap for GROUPING


Problem #16: Top K Frequent Elements

HashMap for COUNTING


MAIN INTERVIEW LESSON:

When a problem asks for
the most frequent items,

first count the frequencies.

Then choose the correct strategy
for finding the Top K results.

For this problem:

HashMap
+
Bucket Sort
=
O(n)
```

---

# Final Pattern Summary

```text
Problem #1: Two Sum

Pattern:
HashMap Lookup

Core Question:
Have I seen what I need?

HashMap:
Number → Index


        ↓


Problem #12: Group Anagrams

Pattern:
HashMap Grouping

Core Question:
Which group does this item belong to?

HashMap:
Signature → List of Words


        ↓


Problem #16: Top K Frequent Elements

Pattern:
Frequency Counting + Top K

Core Question:
How often does each item appear,
and which K items appear most often?

HashMap:
Number → Frequency

Then:

Frequency → Numbers

using Bucket Sort.
```
