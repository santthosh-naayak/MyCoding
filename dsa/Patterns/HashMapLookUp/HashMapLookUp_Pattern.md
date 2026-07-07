

Given an array of integers `nums` and an integer `target`, return  *indices of the two numbers such that they add up to `target`* .

You may assume that each input would have  ***exactly* one solution** , and you may not use the *same* element twice.

You can return the answer in any order.


Problem: Two Sum

Category:
Arrays & Hashing

Pattern:
Hash Map Lookup / Seen-So-Far

Core Technique:
Complement

Core Logic:
needed = target - current

Strategy:
For each number:

1. Calculate what number is needed.
2. Check whether we have already seen it.
3. If yes → return the answer.
4. If no → store the current number.

---

PROBLEM:
Two Sum

CATEGORY:
Arrays & Hashing

PATTERN:
Hash Map Lookup / Seen-So-Far

TECHNIQUE:
Complement

DATA STRUCTURE:
HashMap

CORE FORMULA:
complement = target - current

BRUTE FORCE:

Choose first number
        ↓
Compare with remaining numbers
        ↓
Nested Loops

TIME:
O(n²)

SPACE:
O(1)

PROBLEM WITH BRUTE FORCE:

Repeated searching.

OPTIMAL IDEA:

Instead of searching repeatedly,
remember previously seen numbers.

ALGORITHM:

Visit Current
      ↓
Calculate Complement
      ↓
Check HashMap
      ↓
Found?
  /        
YES         NO
 ↓           ↓
Return     Store Current

HASHMAP:

Number → Index

WHY HASHMAP?

O(1) average lookup.

WHY CHECK BEFORE STORE?

Avoid using the same array element twice.

TIME:

O(n) average

SPACE:

O(n)

MAIN INTERVIEW LESSON:

When brute force repeatedly searches
for information, ask whether you can
store that information and look it up
quickly later.


# Code : java

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}