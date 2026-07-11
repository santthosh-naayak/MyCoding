package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given an array arr[] containing 2*n+2 positive numbers, out of which 2*n numbers exist in pairs whereas only
two numbers occur exactly once and are distinct.
Find the other two numbers. Return the answer in increasing order

Example 1: Single Unique element
Input: arr[] = [1,2,3,2,1]
Output: 3
Explanation: 3 occur exactly once

Example 2: Double Unique element
Input: arr[] = [1,2,3,2,1,4]
Output: [3, 4]
Explanation: 3 and 4 occur exactly once

Example 3: Multiple Unique element
Input: arr[] = [1, 3, 2, 1, 4, 5, 2, 1]
Output: [3, 4, 5]
Explanation: 3 and 4 occur exactly once
*/
public class UniqueNumber {
    /*
     * Using concept XOR operator -> Similar elements will cancel out
     * example:
     * A ^ A = 0; XOR with same element will result same element
     * 0 ^ A = A; XOR with 0 will return that element
     */

    // Method 1: if the input has only one unique number
    public int[] findUniqueNumber(int[] nums) {
        int uniqueNumber = 0;
        for (int number : nums) {
            uniqueNumber ^= number;
        }
        return new int[] { uniqueNumber };
    }

    // Method 2: If the input has two unique values
    public int[] findTwoUniqueNumber(int[] nums) {
        // XOR all numbers so duplicate numbers cancel
        int xorResult = 0;
        for (int numbers : nums) {
            xorResult ^= numbers;
        }
        // Find the rightmost bit where the two unique numbers differ.
        int distinguishingBit = xorResult & -xorResult;
        int firstUnique = 0;
        int secondUnique = 0;
        // seperate two numbers into two groups and XOR each group
        for (int number : nums) {
            if ((number & distinguishingBit) == 0) {
                firstUnique ^= number;
            } else {
                secondUnique ^= number;
            }
        }

        return new int[] { firstUnique, secondUnique };
    }

    /*
     * Method 3: If the input has more than two unique values, XOR approach is not
     * enough, we will go with HashMap
     */
    public List<Integer> findMultipleUniqueNumbers(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // Store each number and count how many times it appears.
        for (int number : nums) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }
        // Create buckets where index represents frequency.
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            // Create the bucket only when it is needed.
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            // Add the number to its corresponding frequency bucket.
            buckets[frequency].add(number);
        }
        // Bucket 1 contains all numbers that appear exactly once.
        return buckets[1];
    }

    public static void main(String[] args) {
        UniqueNumber uniqueNumber = new UniqueNumber();
        int[] singleUniqueNumber = uniqueNumber.findUniqueNumber(new int[] { 1, 2, 3, 2, 1 });
        System.out.println(Arrays.toString(singleUniqueNumber));
        int[] twoUniqueNumber = uniqueNumber.findTwoUniqueNumber(new int[] { 1, 2, 3, 2, 1, 4 });
        System.out.println(Arrays.toString(twoUniqueNumber));
        List<Integer> multipleUniqueNumbers = uniqueNumber
                .findMultipleUniqueNumbers(new int[] { 1, 3, 2, 1, 4, 5, 2, 1 });
        System.out.println(multipleUniqueNumbers);
    }
}
