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

    // Trapping Rain Water
    /*
     * Given n non-negative integers representing an elevation map where the width
     * of each bar is 1, compute how much water it can trap after raining.
     * 
     * Example 1:
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map is represented by array
     * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
     * are being trapped.
     * 
     * Example 2:
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     * 
     * Constraints:
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     */
    public int trappingRainWater(int[] height) {
        int trapRainWater = 0;
        int leftMax = 0;
        int rightMax = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        // We should run the while loop till leftIndex < rightIndex
        while (leftIndex < rightIndex) {
            // Check if we can process left side safely else check for right side
            if (height[leftIndex] <= height[rightIndex]) {
                // Check if current left wall is tallest or reassign the left wall max height
                if (height[leftIndex] >= leftMax) {
                    leftMax = height[leftIndex];
                } else {
                    // Calculate the water above it (Add the water trapped above the current left
                    // wall)
                    trapRainWater += leftMax - height[leftIndex];
                }
                // We will check for next left index (Move left Pointer inward)
                leftIndex++;
            } else {
                // Check if current right wall is tallest or reassign the right wall max height
                if (height[rightIndex] >= rightMax) {
                    rightMax = height[rightIndex];
                } else {
                    // Add the water trapped above the current right wall
                    trapRainWater += rightMax - height[rightIndex];
                }
                // We will check for the next right index (Move right pointer inward)
                rightIndex--;
            }
        }
        return trapRainWater;
    }

    public static void main(String[] args) {
        OppositeDirectionTwoPointer oppositeDirectionTwoPointer = new OppositeDirectionTwoPointer();

        // Container with Most Water
        System.out.println("Container with most water");
        int result1 = oppositeDirectionTwoPointer.containerWithMostWater(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        System.out.println(result1);
        int result2 = oppositeDirectionTwoPointer.containerWithMostWater(new int[] { 1, 1 });
        System.out.println(result2);

        // Trapping Rain Water
        System.out.println("Trapping Rain Water");
        int result3 = oppositeDirectionTwoPointer.trappingRainWater(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        System.out.println(result3);
        int result4 = oppositeDirectionTwoPointer.trappingRainWater(new int[] { 4, 2, 0, 3, 2, 5 });
        System.out.println(result4);
    }
}
