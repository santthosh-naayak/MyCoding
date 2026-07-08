package dsa.Patterns.HashMapCounting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:
Input: nums = [1], k = 1
Output: [1]
Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 
Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size. */
public class HashMapCounting {
    public int[] topKCounts(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // Make HashMap for number and frequency
        for (int number : nums) {
            // if exists count increment by +1 , if does not exist default count is 0
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }
        // Make buckets of frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            int number = entry.getKey();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(number);
        }
        // Traverse and return, as we need top K, traverse backwards of bucket
        int result[] = new int[k];
        int index = 0;
        for (int frequency = buckets.length - 1; frequency > 0; frequency--) {
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

    public static void main(String[] args) {
        HashMapCounting myHashMapCounting = new HashMapCounting();
        int[] result1 = myHashMapCounting.topKCounts(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
        System.out.println(Arrays.toString(result1));
        int[] result2 = myHashMapCounting.topKCounts(new int[] { 1 }, 1);
        System.out.println(Arrays.toString(result2));
        int[] result3 = myHashMapCounting.topKCounts(new int[] { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 }, 2);
        System.out.println(Arrays.toString(result3));
    }
}
