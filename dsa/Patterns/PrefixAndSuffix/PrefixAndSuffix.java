package dsa.Patterns.PrefixAndSuffix;

import java.util.Arrays;

/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0] 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.) */
public class PrefixAndSuffix {
    public int[] productOfArrayExceptSelf(int[] nums) {
        // Prefix: Store the product of all elements to the left of each index.
        int answer[] = new int[nums.length];
        answer[0] = 1;
        // Build prefix products from left to right.
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        // Track the product of all elements to the right.
        int suffix = 1;
        // Multiply each prefix product by its suffix product.
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            // Update the suffix before moving to the next index.
            suffix = suffix * nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        PrefixAndSuffix prefixAndSuffix = new PrefixAndSuffix();
        int[] result1 = prefixAndSuffix.productOfArrayExceptSelf(new int[] { 1, 2, 3, 4 });
        System.out.println(Arrays.toString(result1));
        int[] result2 = prefixAndSuffix.productOfArrayExceptSelf(new int[] { -1, 1, 0, -3, 3 });
        System.out.println(Arrays.toString(result2));
        int[] result3 = prefixAndSuffix.productOfArrayExceptSelf(new int[] { 1 });
        System.out.println(Arrays.toString(result3));
    }
}
