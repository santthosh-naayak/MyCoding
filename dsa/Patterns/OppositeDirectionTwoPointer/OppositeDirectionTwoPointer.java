package dsa.Patterns.OppositeDirectionTwoPointer;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
 
Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104 
*/
public class OppositeDirectionTwoPointer {
    public int containerWithMostWater(int[] height) {
        // Start the left pointer at the beginning.
        int left = 0;
        // Start the right pointer at the end.
        int right = height.length - 1;
        // Store the maximum area found.
        int maxArea = 0;
        // Continue until both pointers meet.
        while (left < right) {
            // Calculate the distance between the two lines.
            int width = right - left;
            // Calculate the area using the shorter line as the height.
            int currentArea = width * Math.min(height[left], height[right]);
            // Update the maximum area found.
            maxArea = Math.max(maxArea, currentArea);
            // Move the shorter line inward to find a potentially larger area.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        OppositeDirectionTwoPointer oppositeDirectionTwoPointer = new OppositeDirectionTwoPointer();
        int result1 = oppositeDirectionTwoPointer.containerWithMostWater(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        System.out.println(result1);
        int result2 = oppositeDirectionTwoPointer.containerWithMostWater(new int[] { 1, 1 });
        System.out.println(result2);
    }
}
