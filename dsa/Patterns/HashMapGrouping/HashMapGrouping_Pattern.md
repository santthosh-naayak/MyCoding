# Problem #12: Group Anagrams

**Difficulty:** Medium
**Category:** Hashing / Strings
**Pattern:** HashMap Grouping
**Technique:** Canonical Representation
**Data Structure:** `HashMap<String, List<String>>`

---

## Problem Statement

Given an array of strings `strs`, group all the anagrams together.

An **anagram** is a word formed by rearranging the characters of another word while using all the original characters exactly once.

### Example

```text
Input:

["eat", "tea", "tan", "ate", "nat", "bat"]
```

```text
Output:

[
    ["eat", "tea", "ate"],
    ["tan", "nat"],
    ["bat"]
]
```

The order of the groups does not matter.

---

# Problem Classification

```text
PROBLEM
   │
   ▼
Problem #12: Group Anagrams


CATEGORY
   │
   ▼
Hashing / Strings


PATTERN
   │
   ▼
HashMap Grouping


TECHNIQUE
   │
   ▼
Canonical Representation


DATA STRUCTURE
   │
   ▼
HashMap<String, List<String>>


CORE LOGIC
   │
   ▼
Same Signature
=
Same Group
```

---

# Connection to Previous Problem

## Problem #1: Two Sum

In Two Sum, we used a HashMap for **lookup**.

```text
Number → Index
```

Example:

```text
2 → 0
7 → 1
```

The main question was:

```text
Have I already seen
the number I need?
```

---

## Problem #12: Group Anagrams

Now, we use a HashMap for **grouping**.

```text
Signature → List of Words
```

Example:

```text
"aet" → ["eat", "tea", "ate"]

"ant" → ["tan", "nat"]

"abt" → ["bat"]
```

The main question is:

```text
Which group does
this word belong to?
```

Therefore, our HashMap knowledge progresses like this:

```text
Problem #1: Two Sum
        ↓
HashMap Lookup


Problem #12: Group Anagrams
        ↓
HashMap Grouping
```

---

# What Is an Anagram?

Two words are anagrams when they contain the same characters with the same frequencies, but possibly in a different order.

Example:

```text
eat

tea

ate
```

Characters:

```text
eat → e, a, t

tea → t, e, a

ate → a, t, e
```

The character order is different, but the characters and their frequencies are the same.

Therefore:

```text
eat
tea
ate
```

belong to the same anagram group.

Another example:

```text
tan
nat
```

Characters:

```text
tan → t, a, n

nat → n, a, t
```

Therefore, they are also anagrams.

---

# Topics and Subtopics Covered

```text
Group Anagrams
       │
       ├── Arrays
       │     └── Array of Strings
       │
       ├── Strings
       │     ├── Characters
       │     └── String Conversion
       │
       ├── Character Arrays
       │     └── char[]
       │
       ├── Sorting
       │     └── Arrays.sort()
       │
       ├── HashMap
       │     ├── Key
       │     ├── Value
       │     ├── containsKey()
       │     ├── put()
       │     ├── get()
       │     └── values()
       │
       ├── ArrayList
       │     └── add()
       │
       ├── Enhanced For Loop
       │
       ├── HashMap Grouping Pattern
       │
       ├── Canonical Representation
       │
       └── Big O Analysis
```

---

# Beginner Thinking

Given:

```text
["eat", "tea", "tan", "ate", "nat", "bat"]
```

First ask:

```text
What do I need to do?
```

Answer:

```text
Group words that are anagrams.
```

Next ask:

```text
How can I identify whether
two words are anagrams?
```

The first natural solution is:

```text
Take one word
      ↓
Compare it with other words
      ↓
Check whether they are anagrams
```

This leads to the brute-force approach.

---

# Brute-Force Approach

Take:

```text
"eat"
```

Compare it with:

```text
"tea"
```

They are anagrams.

Put them in the same group.

Then compare:

```text
"eat"
```

with:

```text
"tan"
```

They are not anagrams.

Continue.

The general process is:

```text
Choose One Word
        ↓
Compare With Other Words
        ↓
Are They Anagrams?
       /          \
     YES           NO
      ↓             ↓
Same Group       Continue
```

---

# Problem With Brute Force

Suppose there are `n` words.

For every word, we may need to compare it with many other words.

```text
Word 1
  ↓
Compare With Other Words


Word 2
  ↓
Compare With Other Words


Word 3
  ↓
Compare With Other Words
```

This creates approximately quadratic pair comparisons.

```text
O(n²)
```

Additionally, checking whether each pair is an anagram requires extra work.

The main problem is:

```text
REPEATED COMPARISON
```

So we ask the optimization question:

```text
Instead of comparing every word
with every other word,

can we directly determine
which group a word belongs to?
```

The answer is yes.

---

# Optimization Thinking

Consider:

```text
eat
tea
ate
```

Sort the characters of every word.

```text
eat → aet

tea → aet

ate → aet
```

Notice:

```text
eat ───┐
       │
tea ───┼──→ aet
       │
ate ───┘
```

Every anagram produces the same sorted string.

Therefore:

```text
SAME SORTED STRING
        =
SAME ANAGRAM GROUP
```

Now, instead of comparing every word with every other word, we can:

```text
Take Word
    ↓
Sort Characters
    ↓
Create Common Identity
    ↓
Use Identity to Find Group
```

---

# Pattern: HashMap Grouping

The reusable pattern is:

```text
Visit Item
    ↓
Create Group Identity
    ↓
Use Identity as HashMap Key
    ↓
Find Correct Group
    ↓
Add Item to Group
```

For Group Anagrams:

```text
Visit Word
    ↓
Create Anagram Signature
    ↓
Use Signature as HashMap Key
    ↓
Find Correct Anagram Group
    ↓
Add Word
```

---

# Technique: Canonical Representation

A canonical representation means:

```text
Convert different-looking but
logically equivalent items

into

one common standard form.
```

Example:

```text
eat → aet

tea → aet

ate → aet
```

The words are different.

But their common representation is:

```text
aet
```

Therefore:

```text
"aet"
```

becomes the HashMap key.

This common representation is also called a:

```text
Signature
```

---

# Why Use a HashMap?

We need to store:

```text
Signature → Group of Words
```

Example:

```text
"aet" → ["eat", "tea", "ate"]

"ant" → ["tan", "nat"]

"abt" → ["bat"]
```

A HashMap stores:

```text
KEY → VALUE
```

Therefore:

```text
KEY

Sorted String / Signature


VALUE

List of Original Words
```

So we use:

```java
HashMap<String, List<String>>
```

---

# HashMap Structure

```text
KEY                 VALUE

"aet"    →    ["eat", "tea", "ate"]

"ant"    →    ["tan", "nat"]

"abt"    →    ["bat"]
```

The key identifies the group.

The value contains all words belonging to that group.

---

# Optimal Algorithm

```text
START
  ↓
Create Empty HashMap
  ↓
Visit Every Word
  ↓
Convert Word to char[]
  ↓
Sort Characters
  ↓
Convert char[] Back to String
  ↓
Use Sorted String as Key
  ↓
Does Group Exist?
   /           \
 NO             YES
 ↓               ↓
Create Group     │
 ↓               │
 └──────┬────────┘
        ↓
     Add Word
        ↓
   Continue Loop
        ↓
Return All Groups
```

---

# Java Solution

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] characters = word.toCharArray();

            Arrays.sort(characters);

            String key = new String(characters);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
```

---

# Code Explanation

## Method Declaration

```java
public List<List<String>> groupAnagrams(String[] strs)
```

The input is:

```java
String[] strs
```

This means:

```text
Array of Strings
```

Example:

```text
["eat", "tea", "tan"]
```

The return type is:

```java
List<List<String>>
```

Understand it from inside to outside.

```java
List<String>
```

means one group of strings.

Example:

```text
["eat", "tea", "ate"]
```

But we have multiple groups.

```text
["eat", "tea", "ate"]

["tan", "nat"]

["bat"]
```

Therefore, we need:

```java
List<List<String>>
```

Visualize it as:

```text
OUTER LIST
│
├── INNER LIST
│      ↓
│   ["eat", "tea", "ate"]
│
├── INNER LIST
│      ↓
│   ["tan", "nat"]
│
└── INNER LIST
       ↓
    ["bat"]
```

---

# Creating the HashMap

```java
Map<String, List<String>> map = new HashMap<>();
```

The key is:

```java
String
```

It stores the sorted signature.

Example:

```text
"aet"
```

The value is:

```java
List<String>
```

It stores the original words.

Example:

```text
["eat", "tea", "ate"]
```

Therefore:

```text
String → List<String>
```

means:

```text
Signature → Group of Words
```

---

# Enhanced For Loop

```java
for (String word : strs)
```

This loop visits every word in the input array.

Suppose:

```text
strs = ["eat", "tea", "tan"]
```

The loop works like:

```text
Iteration 1

word = "eat"


Iteration 2

word = "tea"


Iteration 3

word = "tan"
```

The same process must be performed on every word:

```text
Take Word
   ↓
Create Signature
   ↓
Find Group
   ↓
Add Word
```

Therefore, we need a loop.

---

# Why Use an Enhanced For Loop?

We use:

```java
for (String word : strs)
```

instead of:

```java
for (int i = 0; i < strs.length; i++)
```

because we do not need the index.

In Two Sum, we needed the indices.

Therefore, we used:

```java
for (int i = 0; ...)
```

In Group Anagrams, we only need each word.

Therefore:

```java
for (String word : strs)
```

is simpler.

Remember:

```text
DO I NEED THE INDEX?
       /       \
     YES        NO
      ↓          ↓
Normal For    Enhanced
Loop          For Loop
```

---

# Convert String to Character Array

```java
char[] characters = word.toCharArray();
```

Suppose:

```text
word = "tea"
```

A Java String cannot be directly sorted using `Arrays.sort()`.

Therefore, convert:

```text
"tea"
```

into:

```text
['t', 'e', 'a']
```

Now the word is stored as:

```java
char[]
```

---

# Sort the Characters

```java
Arrays.sort(characters);
```

Before sorting:

```text
['t', 'e', 'a']
```

After sorting:

```text
['a', 'e', 't']
```

Therefore:

```text
tea → aet
```

Similarly:

```text
eat → aet

ate → aet
```

All anagrams now produce the same representation.

---

# Convert Character Array Back to String

```java
String key = new String(characters);
```

After sorting, we have:

```text
['a', 'e', 't']
```

We convert it into:

```text
"aet"
```

Now `"aet"` can be used as the HashMap key.

```text
"aet" → ["eat", "tea", "ate"]
```

---

# Check Whether the Group Exists

```java
if (!map.containsKey(key))
```

Human translation:

```text
Does this group NOT exist?
```

The `!` operator means:

```text
NOT
```

Suppose:

```text
key = "aet"
```

And:

```text
map = {}
```

Then:

```java
map.containsKey("aet")
```

returns:

```text
false
```

Therefore:

```java
!map.containsKey("aet")
```

becomes:

```text
!false
```

which means:

```text
true
```

So we create a new group.

---

# Create a New Group

```java
map.put(key, new ArrayList<>());
```

Suppose:

```text
key = "aet"
```

This creates:

```text
"aet" → []
```

The empty ArrayList will store words belonging to this group.

---

# Add the Word to the Group

```java
map.get(key).add(word);
```

Understand this in two steps.

First:

```java
map.get(key)
```

gets the group.

Suppose:

```text
key = "aet"
```

The HashMap contains:

```text
"aet" → ["eat", "tea"]
```

Therefore:

```java
map.get("aet")
```

returns:

```text
["eat", "tea"]
```

Next:

```java
.add(word)
```

Suppose:

```text
word = "ate"
```

Then:

```text
["eat", "tea"]
```

becomes:

```text
["eat", "tea", "ate"]
```

Therefore:

```java
map.get(key).add(word);
```

means:

```text
Find the correct group
        ↓
Add the current word
```

---

# Why Is `add()` Outside the `if` Condition?

The code is:

```java
if (!map.containsKey(key)) {
    map.put(key, new ArrayList<>());
}

map.get(key).add(word);
```

There are two situations.

## Situation 1: Group Does Not Exist

```text
Create Group
     ↓
Add Word
```

## Situation 2: Group Already Exists

```text
Add Word
```

Therefore:

```text
              Group Exists?
               /         \
             NO           YES
              ↓             ↓
        Create Group        │
              ↓             │
              └──────┬──────┘
                     ↓
                  Add Word
```

The word must always be added.

Therefore, `add()` is outside the `if`.

---

# Return the Result

```java
return new ArrayList<>(map.values());
```

Suppose the HashMap contains:

```text
"aet" → ["eat", "tea", "ate"]

"ant" → ["tan", "nat"]

"abt" → ["bat"]
```

We do not need the keys.

We only need the groups.

Therefore:

```java
map.values()
```

returns:

```text
["eat", "tea", "ate"]

["tan", "nat"]

["bat"]
```

Then:

```java
new ArrayList<>(map.values())
```

converts those values into the required:

```java
List<List<String>>
```

---

# Complete Dry Run

Input:

```text
["eat", "tea", "tan"]
```

Initially:

```text
map = {}
```

## Iteration 1

```text
word = "eat"
```

Convert:

```text
['e', 'a', 't']
```

Sort:

```text
['a', 'e', 't']
```

Create key:

```text
"aet"
```

Does `"aet"` exist?

```text
NO
```

Create group:

```text
"aet" → []
```

Add word:

```text
"aet" → ["eat"]
```

Current HashMap:

```text
{
    "aet" → ["eat"]
}
```

---

## Iteration 2

```text
word = "tea"
```

Convert:

```text
['t', 'e', 'a']
```

Sort:

```text
['a', 'e', 't']
```

Create key:

```text
"aet"
```

Does `"aet"` exist?

```text
YES
```

Do not create a new group.

Add word:

```text
"aet" → ["eat", "tea"]
```

Current HashMap:

```text
{
    "aet" → ["eat", "tea"]
}
```

---

## Iteration 3

```text
word = "tan"
```

Convert:

```text
['t', 'a', 'n']
```

Sort:

```text
['a', 'n', 't']
```

Create key:

```text
"ant"
```

Does `"ant"` exist?

```text
NO
```

Create group:

```text
"ant" → []
```

Add word:

```text
"ant" → ["tan"]
```

Final HashMap:

```text
{
    "aet" → ["eat", "tea"],

    "ant" → ["tan"]
}
```

Return:

```text
[
    ["eat", "tea"],

    ["tan"]
]
```

---

# Time Complexity

Let:

```text
n = number of words

k = maximum length of a word
```

We visit every word.

```text
O(n)
```

For each word, we sort its characters.

Sorting takes:

```text
O(k log k)
```

Therefore:

```text
n × k log k
```

Final time complexity:

```text
O(n × k log k)
```

The important reasoning is:

```text
OUTER LOOP
    ↓
O(n)


WORK INSIDE LOOP
    ↓
Sorting
    ↓
O(k log k)


TOTAL
    ↓
O(n × k log k)
```

---

# Space Complexity

The HashMap stores the words in groups.

We also create sorted signatures and character arrays.

The overall space complexity is commonly expressed as:

```text
O(n × k)
```

where:

```text
n = number of words

k = maximum word length
```

---

# Brute Force vs Optimal Approach

| Approach          | Strategy                                  | Time                                  |
| ----------------- | ----------------------------------------- | ------------------------------------- |
| Brute Force       | Compare words with other words            | Expensive due to repeated comparisons |
| HashMap + Sorting | Create signature and directly group words | O(n × k log k)                        |

The main optimization is:

```text
BRUTE FORCE

Take Word
    ↓
Compare With Other Words
    ↓
Repeated Comparisons


OPTIMAL

Take Word
    ↓
Create Standard Identity
    ↓
Use Identity as HashMap Key
    ↓
Directly Find Correct Group
```

---

# Pattern Recognition

When you see problems containing phrases like:

```text
Group similar items

Categorize items

Collect matching items

Organize by common property

Put equivalent items together
```

Ask:

```text
Can I create a common identity
for similar items?
        ↓
YES
        ↓
Can I use that identity
as a HashMap key?
        ↓
YES
        ↓
HashMap Grouping Pattern
```

The general reusable structure is:

```text
HashMap<Key, List<Items>>
```

---

# Interview Explanation

The brute-force approach would repeatedly compare strings to determine whether they are anagrams.

Instead, we can create a canonical representation for each word by sorting its characters.

All anagrams produce the same sorted string.

For example:

```text
eat → aet

tea → aet

ate → aet
```

Therefore, we use the sorted string as a HashMap key and store all original words with the same key inside a list.

After processing every word, we return all the values from the HashMap.

If `n` is the number of words and `k` is the maximum word length, the time complexity is `O(n × k log k)` because we sort every word.

The space complexity is `O(n × k)` for storing the grouped words and signatures.

---

# Short Interview Revision Notes

```text
PROBLEM:
Problem #12: Group Anagrams


DIFFICULTY:
Medium


CATEGORY:
Hashing / Strings


PATTERN:
HashMap Grouping


TECHNIQUE:
Canonical Representation


DATA STRUCTURE:
HashMap<String, List<String>>


PROBLEM:

Group words that are anagrams.


ANAGRAM:

Same characters

+

Same frequencies

+

Different order allowed


BRUTE FORCE:

Take one word
      ↓
Compare with other words
      ↓
Repeated comparisons


PROBLEM WITH BRUTE FORCE:

Repeatedly checking whether
words are anagrams.


OPTIMAL IDEA:

Create one common identity
for all anagrams.


TECHNIQUE:

Sort the characters.


EXAMPLE:

eat → aet

tea → aet

ate → aet


CORE LOGIC:

Same Signature
=
Same Group


HASHMAP:

Signature → List of Words


EXAMPLE:

"aet" → ["eat", "tea", "ate"]

"ant" → ["tan", "nat"]

"abt" → ["bat"]


ALGORITHM:

Visit Word
    ↓
Convert to char[]
    ↓
Sort Characters
    ↓
Convert to String Key
    ↓
Does Group Exist?
   /            \
 NO              YES
 ↓                ↓
Create Group      │
 ↓                │
 └───────┬────────┘
         ↓
      Add Word


WHY HASHMAP?

Quickly find the correct group.


WHY SORT?

All anagrams become
the same standard representation.


TIME COMPLEXITY:

O(n × k log k)


WHY?

n words

×

sorting each word O(k log k)


SPACE COMPLEXITY:

O(n × k)


CONNECTION TO PREVIOUS PROBLEM:

Problem #1: Two Sum

HashMap for LOOKUP


Problem #12: Group Anagrams

HashMap for GROUPING


MAIN INTERVIEW LESSON:

When you need to group similar items,
create a common representation for them
and use that representation as a HashMap key.
```
