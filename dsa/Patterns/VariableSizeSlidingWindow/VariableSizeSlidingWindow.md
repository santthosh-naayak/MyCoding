# Problem #7: Longest Substring Without Repeating Characters

**Difficulty:** Medium
**Category:** Sliding Window
**Pattern:** Variable-Size Sliding Window
**Technique:** Two Pointers + HashSet
**Data Structure:** `HashSet<Character>`
**Time Complexity:** `O(n)`
**Space Complexity:** `O(n)`

---

# Problem Statement

Given a string `s`, find the length of the longest substring without repeating characters.

---

# Example 1

```text
Input:

s = "abcabcbb"
```

```text
Output:

3
```

## Explanation

The longest substring without repeating characters is:

```text
"abc"
```

Its length is:

```text
3
```

Other valid substrings with the same length are:

```text
"bca"

"cab"
```

Therefore:

```text
Answer = 3
```

---

# Example 2

```text
Input:

s = "bbbbb"
```

```text
Output:

1
```

The longest substring without repeating characters is:

```text
"b"
```

Therefore:

```text
Answer = 1
```

---

# Example 3

```text
Input:

s = "pwwkew"
```

```text
Output:

3
```

The longest valid substring is:

```text
"wke"
```

Its length is:

```text
3
```

Notice:

```text
"pwke"
```

is not a substring because the characters are not continuous.

---

# Problem Classification

```text
PROBLEM
   │
   ▼
Problem #7:
Longest Substring Without
Repeating Characters


DIFFICULTY
   │
   ▼
Medium


CATEGORY
   │
   ▼
Sliding Window


PATTERN
   │
   ▼
Variable-Size Sliding Window


TECHNIQUE
   │
   ▼
Two Pointers
+
HashSet


DATA STRUCTURE
   │
   ▼
HashSet<Character>


CORE LOGIC
   │
   ▼
Expand Right
        ↓
Duplicate Found?
        ↓
Shrink Left
        ↓
Window Valid Again
        ↓
Update Maximum Length
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
Sliding Window
+
HashSet
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
Longest Substring Without Repeating Characters
                    │
                    ├── Strings
                    │
                    ├── Characters
                    │
                    ├── Substrings
                    │
                    ├── Continuous Ranges
                    │
                    ├── Sliding Window
                    │     ├── Fixed-Size Window
                    │     └── Variable-Size Window
                    │
                    ├── Two Pointers
                    │     ├── Left Pointer
                    │     └── Right Pointer
                    │
                    ├── HashSet
                    │     ├── add()
                    │     ├── remove()
                    │     └── contains()
                    │
                    ├── for Loop
                    │
                    ├── while Loop
                    │
                    ├── Conditions
                    │
                    ├── Window Expansion
                    │
                    ├── Window Shrinking
                    │
                    ├── Inclusive Range Length
                    │
                    ├── Math.max()
                    │
                    ├── Brute Force
                    │
                    └── Big O Analysis
```

---

# First Understand: What Is a Substring?

A substring is:

```text
A continuous part
of a string.
```

Consider:

```text
"abcde"
```

Valid substrings include:

```text
"a"

"ab"

"abc"

"bcd"

"cde"
```

But:

```text
"ace"
```

is not a substring.

Why?

Because:

```text
a  b  c  d  e

↑     ↑     ↑

a     c     e
```

The characters are not continuous.

Therefore:

```text
SUBSTRING

=

CONTINUOUS CHARACTERS
```

Remember:

```text
Substring
    ↓
Continuous


Subsequence
    ↓
Does Not Need to Be Continuous
```

---

# Real-World Example

Imagine a security system processing a continuous stream of ID cards:

```text
A → B → C → A → D
```

The system wants to find:

```text
The longest continuous sequence
without a repeated ID.
```

Start:

```text
[A]
```

Valid.

Add `B`:

```text
[A, B]
```

Valid.

Add `C`:

```text
[A, B, C]
```

Valid.

Add another `A`:

```text
[A, B, C, A]
```

Invalid.

Why?

Because:

```text
A
```

appears twice.

Do we need to throw everything away?

No.

Remove characters from the beginning until the duplicate disappears.

```text
[A, B, C, A]
 ↑
REMOVE
```

Now:

```text
[B, C, A]
```

is valid again.

This is the basic logic behind:

```text
SLIDING WINDOW
```

---

# Beginner Thinking

Given:

```text
s = "abcabcbb"
```

Ask:

```text
What do I need?
```

Answer:

```text
The longest continuous substring
without duplicate characters.
```

Now ask:

```text
What is the simplest solution?
```

One natural idea is:

```text
Generate Every Substring
        ↓
Check for Duplicates
        ↓
Keep Maximum Length
```

This gives us the brute-force approach.

---

# Approach 1: Brute Force

For every possible starting position:

```text
Choose Start
     ↓
Choose End
     ↓
Create Substring
     ↓
Check for Duplicates
     ↓
Valid?
  /       \
YES        NO
 ↓          ↓
Update     Continue
Maximum
```

Consider:

```text
s = "abc"
```

Possible substrings are:

```text
"a"

"ab"

"abc"

"b"

"bc"

"c"
```

For every substring, check:

```text
Does any character repeat?
```

Then keep the longest valid substring.

---

# Brute-Force Thinking

Start from index `0`.

Generate:

```text
"a"

"ab"

"abc"

"abca"

"abcab"

...
```

Then start from index `1`.

Generate:

```text
"b"

"bc"

"bca"

"bcab"

...
```

Then continue for every starting position.

The problem is:

```text
REPEATED WORK
```

We repeatedly generate and check overlapping substrings.

---

# Why Is Brute Force Slow?

Suppose the string length is:

```text
n
```

There can be approximately:

```text
O(n²)
```

substrings.

If checking every substring for duplicates requires another traversal, the total complexity can become:

```text
O(n³)
```

The deeper problem is:

```text
We repeatedly check
information that we
already calculated.
```

So we ask:

```text
Can I maintain information
about the current substring
instead of checking everything again?
```

The answer is:

```text
YES
```

This gives us:

```text
SLIDING WINDOW
```

---

# What Is a Window?

Consider:

```text
s = "abcabcbb"
```

Suppose:

```text
left = 0

right = 2
```

Then:

```text
INDEX

0   1   2   3   4   5   6   7

a   b   c   a   b   c   b   b

↑       ↑
L       R
```

The characters between:

```text
left
```

and:

```text
right
```

form our current:

```text
WINDOW
```

Therefore:

```text
WINDOW

=

Continuous Range
Between Left and Right
```

---

# What Is Sliding Window?

Instead of repeatedly creating new substrings, we maintain one current range.

The window can:

```text
EXPAND
```

or:

```text
SHRINK
```

Example:

```text
[a]

[a b]

[a b c]

[a b c a]
```

Now a duplicate appears.

Shrink:

```text
[b c a]
```

Continue expanding:

```text
[b c a b]
```

Duplicate again.

Shrink:

```text
[c a b]
```

The window moves across the string.

Therefore:

```text
SLIDING WINDOW
```

---

# Types of Sliding Window

There are two common types:

```text
SLIDING WINDOW
       │
       ├── Fixed-Size Window
       │
       └── Variable-Size Window
```

---

# Fixed-Size Sliding Window

The window always has the same size.

Example:

```text
Find the maximum sum
of every 3 consecutive numbers.
```

Array:

```text
[1, 2, 3, 4, 5]
```

Windows:

```text
[1, 2, 3]

   [2, 3, 4]

      [3, 4, 5]
```

The window size is always:

```text
3
```

Therefore:

```text
FIXED-SIZE SLIDING WINDOW
```

---

# Variable-Size Sliding Window

The window grows and shrinks depending on a condition.

For this problem:

```text
NO DUPLICATE
      ↓
EXPAND WINDOW


DUPLICATE FOUND
      ↓
SHRINK WINDOW
```

The size changes dynamically.

Therefore:

```text
Problem #7

=

Variable-Size Sliding Window
```

---

# The Most Important Observation

Consider:

```text
s = "abcabcbb"
```

Start:

```text
[]
```

Add `a`:

```text
[a]
```

Valid.

Add `b`:

```text
[a, b]
```

Valid.

Add `c`:

```text
[a, b, c]
```

Valid.

Add another `a`:

```text
[a, b, c, a]
```

Invalid.

The key question is:

```text
Do we need to start
everything again?
```

Answer:

```text
NO
```

We only need to remove characters from the left until the duplicate disappears.

```text
[a, b, c, a]

 ↑

REMOVE
```

Now:

```text
[b, c, a]
```

is valid.

This is the main optimization.

---

# The Two Pointers

We use:

```text
left
```

and:

```text
right
```

The `right` pointer is responsible for:

```text
EXPANDING THE WINDOW
```

The `left` pointer is responsible for:

```text
SHRINKING THE WINDOW
```

Remember:

```text
RIGHT POINTER
      ↓
EXPAND


LEFT POINTER
      ↓
SHRINK
```

The general movement is:

```text
left  → → → → →

right → → → → →
```

Both pointers only move forward.

---

# Why Do We Need a HashSet?

We need to answer:

```text
Does the current character
already exist inside the window?
```

Suppose:

```text
Current Window:

[a, b, c]
```

Next character:

```text
a
```

We need to quickly ask:

```text
Does 'a' already exist?
```

A `HashSet` is useful because it stores unique values.

Example:

```text
HashSet:

{a, b, c}
```

Then:

```java
window.contains('a')
```

returns:

```text
true
```

Therefore:

```text
HashSet
    ↓
Tracks Characters
Inside Current Window
```

---

# Why HashSet Instead of HashMap?

In this solution, we only need to know:

```text
Does this character exist?
```

We do not need:

```text
Character → Index
```

We also do not need:

```text
Character → Frequency
```

Therefore:

```java
HashSet<Character>
```

is enough.

Remember:

```text
Need Key → Value
        ↓
HashMap


Need Unique Values
or Existence Checking
        ↓
HashSet
```

---

# Optimal Algorithm

```text
START
  ↓
Create Empty HashSet
  ↓
left = 0
  ↓
maxLength = 0
  ↓
Move Right Across String
  ↓
Get Current Character
  ↓
Does Character Already Exist?
       /              \
     YES               NO
      ↓                 │
Remove Character        │
at Left                 │
      ↓                 │
Move Left               │
      ↓                 │
Check Again             │
      └────────┬────────┘
               ↓
Add Current Character
               ↓
Calculate Window Length
               ↓
Update Maximum Length
               ↓
Continue
               ↓
Return Maximum
```

---

# Optimal Java Solution

```java
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> window = new HashSet<>();

        int left = 0;

        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char currentCharacter = s.charAt(right);

            while (window.contains(currentCharacter)) {

                window.remove(s.charAt(left));

                left++;
            }

            window.add(currentCharacter);

            int currentLength = right - left + 1;

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
```

---

# Complete Code Flow

```text
CREATE HASHSET
       ↓
left = 0
       ↓
maxLength = 0
       ↓
FOR EACH RIGHT POSITION
       ↓
GET CURRENT CHARACTER
       ↓
WHILE DUPLICATE EXISTS
       ↓
REMOVE LEFT CHARACTER
       ↓
MOVE LEFT
       ↓
ADD CURRENT CHARACTER
       ↓
CALCULATE WINDOW LENGTH
       ↓
UPDATE MAXIMUM
       ↓
RETURN MAXIMUM
```

---

# Understanding the HashSet

Code:

```java
Set<Character> window = new HashSet<>();
```

Human translation:

```text
Create a container
that stores the characters
currently inside my window.
```

Initially:

```text
window = {}
```

As the right pointer moves:

```text
window = {a}
```

Then:

```text
window = {a, b}
```

Then:

```text
window = {a, b, c}
```

When a duplicate appears, we remove characters from the set as the left pointer moves.

---

# Understanding `left`

Code:

```java
int left = 0;
```

The `left` pointer tells us:

```text
Where does my current
window begin?
```

Initially:

```text
a   b   c   a   b   c   b   b

↑
left
```

As duplicates appear, `left` moves forward.

```text
a   b   c   a   b   c   b   b

    ↑
   left
```

Therefore:

```text
LEFT
  ↓
Controls Where
the Window Starts
```

---

# Understanding `maxLength`

Code:

```java
int maxLength = 0;
```

The purpose is:

```text
Remember the longest
valid window found so far.
```

Example:

```text
Current Window Length = 1

maxLength = 1
```

Later:

```text
Current Window Length = 2

maxLength = 2
```

Later:

```text
Current Window Length = 3

maxLength = 3
```

If another window has length `2`:

```text
maxLength
```

remains:

```text
3
```

---

# Understanding the `for` Loop

Code:

```java
for (int right = 0; right < s.length(); right++)
```

The `right` pointer visits every character.

For:

```text
s = "abcabcbb"
```

it moves:

```text
right = 0

right = 1

right = 2

right = 3

right = 4

right = 5

right = 6

right = 7
```

The purpose is:

```text
RIGHT POINTER
      ↓
EXPAND THE WINDOW
```

Every iteration asks:

```text
Can I include
this new character
inside my window?
```

---

# Understanding `charAt()`

Code:

```java
char currentCharacter = s.charAt(right);
```

Suppose:

```text
s = "abc"
```

Then:

```text
s.charAt(0) → 'a'

s.charAt(1) → 'b'

s.charAt(2) → 'c'
```

Therefore:

```java
s.charAt(right)
```

means:

```text
Give me the character
at the current right position.
```

---

# Understanding the `while` Loop

Code:

```java
while (window.contains(currentCharacter))
```

Human translation:

```text
While the current character
already exists inside my window,
keep shrinking the window.
```

The logic is:

```text
DUPLICATE EXISTS?
       ↓
YES
       ↓
REMOVE LEFT CHARACTER
       ↓
MOVE LEFT
       ↓
DUPLICATE STILL EXISTS?
       ↓
CHECK AGAIN
```

---

# Why Do We Use `while` Instead of `if`?

This is one of the most important concepts in this problem.

An `if` condition means:

```text
Check Once
```

A `while` loop means:

```text
Keep Repeating
Until the Condition
Becomes False
```

Our requirement is:

```text
Keep Removing Characters
Until the Duplicate Disappears
```

Therefore:

```java
while
```

is the correct logic.

Remember:

```text
IF

Check Once


WHILE

Keep Repeating
While Condition Is True
```

The sliding-window rule is:

```text
WHILE WINDOW IS INVALID
        ↓
KEEP SHRINKING
```

---

# Understanding `window.remove()`

Code:

```java
window.remove(s.charAt(left));
```

Suppose:

```text
window = {a, b, c}
```

and:

```text
left = 0
```

Then:

```java
s.charAt(left)
```

is:

```text
'a'
```

Therefore:

```java
window.remove(s.charAt(left));
```

becomes:

```text
Remove 'a'
from the HashSet.
```

Now:

```text
window = {b, c}
```

---

# Understanding `left++`

Code:

```java
left++;
```

Human translation:

```text
Move the beginning
of the window
one position forward.
```

Before:

```text
a   b   c   a

↑
left
```

After:

```text
a   b   c   a

    ↑
   left
```

Therefore:

```text
REMOVE LEFT CHARACTER
        ↓
MOVE LEFT POINTER
```

These two operations work together.

---

# Why Remove First and Then Move `left`?

Code:

```java
window.remove(s.charAt(left));

left++;
```

Suppose:

```text
left = 0
```

The character at index `0` must leave the window.

Therefore:

```text
FIRST

Remove the Character
at Current Left Position


THEN

Move Left
to the Next Position
```

If we moved `left` first, we could remove the wrong character.

---

# Understanding `window.add()`

Code:

```java
window.add(currentCharacter);
```

Before adding the current character, the `while` loop guarantees:

```text
The Duplicate Has Been Removed
```

Therefore, the current character can safely enter the window.

The order is:

```text
DUPLICATE FOUND
       ↓
SHRINK WINDOW
       ↓
WINDOW VALID AGAIN
       ↓
ADD CURRENT CHARACTER
```

---

# Understanding Window Length

Code:

```java
int currentLength = right - left + 1;
```

Why:

```text
right - left + 1
```

Consider:

```text
INDEX

0   1   2

a   b   c

↑       ↑
L       R
```

Here:

```text
left = 0

right = 2
```

If we calculate:

```text
right - left
```

we get:

```text
2 - 0 = 2
```

But the window contains:

```text
3 characters
```

Therefore:

```text
right - left + 1
```

gives:

```text
2 - 0 + 1

=

3
```

Remember:

```text
INCLUSIVE RANGE LENGTH

=

END - START + 1
```

---

# Understanding `Math.max()`

Code:

```java
maxLength = Math.max(maxLength, currentLength);
```

Suppose:

```text
maxLength = 3
```

and:

```text
currentLength = 2
```

Then:

```java
Math.max(3, 2)
```

returns:

```text
3
```

Suppose later:

```text
maxLength = 3
```

and:

```text
currentLength = 4
```

Then:

```java
Math.max(3, 4)
```

returns:

```text
4
```

Human translation:

```text
Compare:

Best Answer So Far

with

Current Window Length


Keep the Larger One
```

---

# Complete Dry Run

Input:

```text
s = "abcabcbb"
```

Initially:

```text
window = {}

left = 0

maxLength = 0
```

---

## Iteration 1

```text
right = 0

currentCharacter = 'a'
```

Check:

```text
Does 'a' exist?
```

No.

Add:

```text
window = {a}
```

Calculate:

```text
currentLength

=

0 - 0 + 1

=

1
```

Update:

```text
maxLength = 1
```

---

## Iteration 2

```text
right = 1

currentCharacter = 'b'
```

Duplicate?

```text
NO
```

Add:

```text
window = {a, b}
```

Calculate:

```text
currentLength

=

1 - 0 + 1

=

2
```

Update:

```text
maxLength = 2
```

---

## Iteration 3

```text
right = 2

currentCharacter = 'c'
```

Duplicate?

```text
NO
```

Add:

```text
window = {a, b, c}
```

Calculate:

```text
currentLength

=

2 - 0 + 1

=

3
```

Update:

```text
maxLength = 3
```

---

## Iteration 4

```text
right = 3

currentCharacter = 'a'
```

Current window:

```text
{a, b, c}
```

Duplicate?

```text
YES
```

Remove:

```text
s.charAt(left)

=

'a'
```

Window:

```text
{b, c}
```

Move:

```text
left = 1
```

Check again:

```text
Does 'a' exist?
```

No.

Add:

```text
window = {b, c, a}
```

Calculate:

```text
currentLength

=

3 - 1 + 1

=

3
```

Maximum remains:

```text
3
```

---

## Iteration 5

```text
right = 4

currentCharacter = 'b'
```

Current window:

```text
{b, c, a}
```

Duplicate?

```text
YES
```

Remove:

```text
'b'
```

Move:

```text
left = 2
```

Add current `b`.

Window:

```text
{c, a, b}
```

Length:

```text
4 - 2 + 1

=

3
```

Maximum:

```text
3
```

---

## Iteration 6

```text
right = 5

currentCharacter = 'c'
```

Duplicate?

```text
YES
```

Remove:

```text
'c'
```

Move:

```text
left = 3
```

Add current `c`.

Window:

```text
{a, b, c}
```

Length:

```text
5 - 3 + 1

=

3
```

Maximum:

```text
3
```

---

## Iteration 7

```text
right = 6

currentCharacter = 'b'
```

Duplicate?

```text
YES
```

Current window:

```text
[a, b, c]
```

Remove left:

```text
'a'
```

Move:

```text
left = 4
```

Window:

```text
{b, c}
```

Check again.

Does `b` still exist?

```text
YES
```

This is exactly why we use:

```java
while
```

instead of:

```java
if
```

Remove:

```text
'b'
```

Move:

```text
left = 5
```

Window:

```text
{c}
```

Check again.

Does `b` exist?

```text
NO
```

Add:

```text
'b'
```

Window:

```text
{c, b}
```

Length:

```text
6 - 5 + 1

=

2
```

Maximum remains:

```text
3
```

---

## Iteration 8

```text
right = 7

currentCharacter = 'b'
```

Duplicate?

```text
YES
```

Remove left:

```text
'c'
```

Move:

```text
left = 6
```

Does `b` still exist?

```text
YES
```

Remove:

```text
'b'
```

Move:

```text
left = 7
```

Add current `b`.

Window:

```text
{b}
```

Length:

```text
7 - 7 + 1

=

1
```

Maximum remains:

```text
3
```

Return:

```text
3
```

---

# Why Is the Time Complexity `O(n)`?

At first glance, we have:

```text
for loop

+

while loop
```

You may think:

```text
O(n²)
```

But this is not a normal nested-loop situation.

The `right` pointer moves only forward.

```text
→ → → → → → → →
```

The `left` pointer also moves only forward.

```text
→ → → → → → → →
```

Every character:

```text
Enters the Window
At Most Once
```

and:

```text
Leaves the Window
At Most Once
```

Therefore, the total number of operations is approximately:

```text
n + n
```

which is:

```text
2n
```

Big O removes constants.

Therefore:

```text
O(2n)

=

O(n)
```

This is a very important sliding-window complexity rule.

---

# Why Is This Not `O(n²)`?

Compare the movement.

## Normal Nested Loops

```text
For Every i

    Visit Every j
```

This gives:

```text
n × n

=

O(n²)
```

But here:

```text
RIGHT
   ↓
Only Moves Forward


LEFT
   ↓
Only Moves Forward
```

The left pointer does not restart from `0` for every right pointer.

Therefore:

```text
TOTAL POINTER MOVEMENTS

≤

2n
```

So:

```text
O(n)
```

---

# Space Complexity

The HashSet stores characters from the current window.

In the worst case:

```text
"abcdef..."
```

every character may be unique.

Therefore, the HashSet can store up to:

```text
n characters
```

So:

```text
Space Complexity:

O(n)
```

More precisely:

```text
O(min(n, character set size))
```

But for beginner interview preparation:

```text
O(n)
```

is sufficient.

---

# Brute Force vs Optimal Approach

| Approach                 | Strategy                                            | Time Complexity |          Space Complexity |
| ------------------------ | --------------------------------------------------- | --------------: | ------------------------: |
| Brute Force              | Generate substrings and repeatedly check duplicates |   Up to `O(n³)` | Depends on implementation |
| Sliding Window + HashSet | Maintain the current valid substring                |          `O(n)` |                    `O(n)` |

---

# Pattern Recognition

When you see phrases like:

```text
Longest Substring

Shortest Substring

Longest Subarray

Smallest Subarray

Continuous Elements

Consecutive Elements

Without Repeating

At Most K

Minimum Window
```

ask:

```text
Is the problem asking about
a CONTINUOUS range?
        ↓
YES


Can I maintain information
about the current range?
        ↓
YES


Can I expand and shrink
the range?
        ↓
YES


THINK:

SLIDING WINDOW
```

---

# General Variable-Size Sliding Window Template

```java
int left = 0;

for (int right = 0; right < size; right++) {

    // Add current element to window

    while (windowIsInvalid) {

        // Remove left element

        left++;
    }

    // Update answer
}
```

Human translation:

```text
MOVE RIGHT
     ↓
EXPAND WINDOW
     ↓
WINDOW INVALID?
     ↓
SHRINK FROM LEFT
     ↓
WINDOW VALID AGAIN
     ↓
UPDATE ANSWER
```

This template will be useful for many future problems.

---

# Connection to Future Problem #23

Later, we will solve:

```text
Problem #23:
Minimum Window Substring
```

The connection is:

```text
Problem #7:
Longest Substring Without
Repeating Characters
        ↓
Basic Variable-Size
Sliding Window
        ↓
HashSet
        ↓
Simple Valid / Invalid Condition


Problem #23:
Minimum Window Substring
        ↓
Advanced Variable-Size
Sliding Window
        ↓
HashMaps
        ↓
Complex Valid / Invalid Condition
```

Therefore:

```text
Problem #7
        ↓
Build Sliding Window Foundation
        ↓
Problem #23
```

---

# Interview Explanation

The brute-force approach generates multiple substrings and repeatedly checks them for duplicate characters, which causes repeated work.

Instead, I use a variable-size sliding window with two pointers.

The right pointer expands the window by adding new characters.

A HashSet stores the unique characters currently inside the window.

If the current character already exists in the HashSet, the window becomes invalid.

I then move the left pointer forward and remove characters from the HashSet until the duplicate disappears.

Once the window becomes valid again, I add the current character and calculate the current window length using:

```text
right - left + 1
```

I keep track of the maximum length found.

Both pointers only move forward, and every character enters and leaves the window at most once.

Therefore, the time complexity is `O(n)` and the space complexity is `O(n)`.

---

# Short Interview Revision Notes

```text
PROBLEM:

Problem #7:
Longest Substring Without
Repeating Characters


DIFFICULTY:

Medium


CATEGORY:

Sliding Window


PATTERN:

Variable-Size Sliding Window


TECHNIQUE:

Two Pointers
+
HashSet


PROBLEM:

Find the longest continuous
substring without duplicates.


IMPORTANT:

Substring
=
Continuous


BRUTE FORCE:

Generate Every Substring
        ↓
Check for Duplicates
        ↓
Keep Maximum


PROBLEM WITH BRUTE FORCE:

Repeated Substring Checking


OPTIMIZATION:

Maintain One Current Window


WINDOW:

Continuous Range Between
Left and Right


RIGHT POINTER:

Expand Window


LEFT POINTER:

Shrink Window


HASHSET:

Tracks Unique Characters
Inside Current Window


WHY HASHSET?

Need Fast Existence Checking


CORE LOGIC:

Expand Right
        ↓
Duplicate Found?
        ↓
Shrink Left
        ↓
Window Valid Again
        ↓
Add Current Character
        ↓
Calculate Length
        ↓
Update Maximum


WHY WHILE?

Keep Shrinking
Until Window Becomes Valid


WHY NOT IF?

IF Checks Once

WHILE Repeats Until
Condition Becomes False


WINDOW LENGTH:

right - left + 1


WHY +1?

Both Left and Right
Are Included


TIME COMPLEXITY:

O(n)


WHY?

Every Character Enters
the Window At Most Once

and

Every Character Leaves
the Window At Most Once


SPACE COMPLEXITY:

O(n)


GENERAL TEMPLATE:

for right
    ↓
add element
    ↓
while invalid
    ↓
remove left
    ↓
move left
    ↓
update answer


CONNECTION TO FUTURE PROBLEM:

Problem #7

Basic Sliding Window

        ↓

Problem #23

Advanced Sliding Window


MAIN INTERVIEW LESSON:

When a problem asks about
a continuous range,

and the range can grow
and shrink based on a condition,

think:

SLIDING WINDOW


MOST IMPORTANT SENTENCE:

Expand the right pointer
while exploring new elements.

When the window becomes invalid,
move the left pointer
until it becomes valid again.
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


Problem #16:
Top K Frequent Elements

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


        ↓


Problem #7:
Longest Substring Without
Repeating Characters

Problem:
Repeated Substring Checking

Pattern:
Variable-Size Sliding Window
+
Two Pointers
+
HashSet
```
