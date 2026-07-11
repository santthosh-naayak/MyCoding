package dsa.Patterns.SortCompareMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Example 3:
Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 
Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104 */
public class SortCompareMerge {
    public int[][] mergedIntervals(int[][] intervals) {
        // Sort intervals by start value so potential overlaps become adjacent
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Start with the first interval as the current interval to process
        int[] currentInterval = intervals[0];
        // Store completed merged intervals dynamically since the result size is unknown
        List<int[]> mergedIntervals = new ArrayList<>();
        // Process each remaining interval starting from the second interval
        for (int i = 1; i < intervals.length; i++) {
            // Get the next interval to compare with the current interval
            int[] nextInterval = intervals[i];
            // If the next interval starts before the current interval ends, they overlap
            if (nextInterval[0] <= currentInterval[1]) {
                // Merge by extending the current interval to the furthest ending point
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // Save the completed current interval when there is no overlap
                mergedIntervals.add(currentInterval);
                // Make the next interval the new current interval
                currentInterval = nextInterval;
            }
        }
        // Add the final current interval that remains after the loop ends
        mergedIntervals.add(currentInterval);
        // Convert the dynamic result list to the required int[][] return type
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        SortCompareMerge sortCompareMerge = new SortCompareMerge();
        int[][] result1 = sortCompareMerge.mergedIntervals(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } });
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = sortCompareMerge.mergedIntervals(new int[][] { { 1, 4 }, { 4, 5 } });
        System.out.println(Arrays.deepToString(result2));
        int[][] result3 = sortCompareMerge.mergedIntervals(new int[][] { { 4, 7 }, { 1, 4 } });
        System.out.println(Arrays.deepToString(result3));
    }
}
