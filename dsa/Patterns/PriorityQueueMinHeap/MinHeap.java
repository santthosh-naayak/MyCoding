package dsa.Patterns.PriorityQueueMinHeap;

import java.util.PriorityQueue;

/*Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104 */
public class MinHeap {
    public int findKthLargest(int[] nums, int k) {
        // Create a priority Queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Read all numbers and offer to heap
        for (int number : nums) {
            minHeap.offer(number);
            // If the size of the priorityQueue is greater than the k, remove that
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // in PriorityQueue top elment is the Kth Largest
        return minHeap.peek();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        int result1 = minHeap.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2);
        System.out.println(result1);
        int result2 = minHeap.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4);
        System.out.println(result2);
    }
}
