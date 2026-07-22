package dsa.Patterns.BinarySearchAndPartition;

/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106 */
public class BinarySearchAndPartition {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always perform the Binary Search on Smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // Lengths of each array
        int smallArrayLength = nums1.length;
        int bigArrayLength = nums2.length;

        int low = 0; // partitionStart
        int high = smallArrayLength; // partitionEnd
        while (low <= high) {
            // partition in small array
            int partitionNums1 = (low + high) / 2;
            // partion in Bigger array
            int partitionNums2 = (smallArrayLength + bigArrayLength + 1) / 2 - partitionNums1;
            // Largest element on Left of Small Array
            int leftMaxNums1 = (partitionNums1 == 0) ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
            // Smallest element on Right of Small Array
            int rightMinNums1 = (partitionNums1 == smallArrayLength) ? Integer.MAX_VALUE : nums1[partitionNums1];
            // Largest element on Left of Bigger Array
            int leftMaxNums2 = (partitionNums2 == 0) ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];
            // Smallest element on Right of Bigger Array
            int rightMinNums2 = (partitionNums2 == bigArrayLength) ? Integer.MAX_VALUE : nums2[partitionNums2];

            // If Correct Partition Found
            if (leftMaxNums1 <= rightMinNums2 && leftMaxNums2 <= rightMinNums1) {
                // If total number of elements is odd
                if ((smallArrayLength + bigArrayLength) % 2 == 1) {
                    return Math.max(leftMaxNums1, leftMaxNums2);
                } else {
                    return (Math.max(leftMaxNums1, leftMaxNums2) + Math.min(rightMinNums1, rightMinNums2)) / 2.0;
                }

            } else if (leftMaxNums1 > rightMinNums2) {
                high = partitionNums1 - 1;
            } else {
                low = partitionNums1 + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        BinarySearchAndPartition binarySearchAndPartition = new BinarySearchAndPartition();
        double result1 = binarySearchAndPartition.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 });
        System.out.println(result1);
        double result2 = binarySearchAndPartition.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 });
        System.out.println(result2);
    }
}
