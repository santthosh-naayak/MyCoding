package practice;

import java.util.Arrays;

public class ArraySorting {
    // Normal Araay Sorting (Generally in ascending order)
    public int[] normalSort(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    // Normal Araay Sorting (descending order)
    public int[] normalSortDescending(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
            left++;
            right--;
            /*
             * Example [a,b]
             * a = a ^ b;
             * b = a ^ b
             * => (a ^ b) ^ b
             * => a ^ (b ^ b)
             * => a ^ 0 => a
             * Hence b = a
             * a = a ^ b => (a ^ b) ^ a {as in the above step b = a}
             * => (a ^ a) ^ b
             * => 0 ^ b
             * => b
             * Hence final [b, a] swapped
             */
        }
        return nums;
    }

    // Sort intervals by start value (Generally in ascending order)
    public int[][] sortByStartValue(int[][] intervals) {
        // Sorting by start value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        return intervals;
    }

    // Sort intervals by end value (Generally in ascending order)
    public int[][] sortByEndValue(int[][] intervals) {
        // Sorting by end value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        return intervals;
    }

    // Sort intervals by start value (In descending order)
    public int[][] sortByStartValueDescending(int[][] intervals) {
        // Sorting by start value in descending
        Arrays.sort(intervals, (a, b) -> Integer.compare(b[0], a[0]));
        return intervals;
    }

    public static void main(String[] args) {
        ArraySorting arraySorting = new ArraySorting();
        System.out.println("Normal Sort");
        int[] result1 = arraySorting.normalSort(new int[] { 3, 4, 1, 2, 8, 10 });
        System.out.println(Arrays.toString(result1));
        System.out.println("Normal Sort Descending");
        int[] result2 = arraySorting.normalSortDescending(new int[] { 3, 4, 1, 2, 8, 10 });
        System.out.println(Arrays.toString(result2));
        System.out.println("Sort by start value");
        int[][] result3 = arraySorting
                .sortByStartValue(new int[][] { { 1, 2 }, { 2, 7 }, { 5, 10 }, { 11, 15 }, { 16, 19 } });
        System.out.println(Arrays.deepToString(result3));
        System.out.println("Sort by end value");
        int[][] result4 = arraySorting
                .sortByEndValue(new int[][] { { 1, 2 }, { 2, 10 }, { 5, 10 }, { 11, 6 }, { 16, 19 } });
        System.out.println(Arrays.deepToString(result4));
        System.out.println("Sort by start value in descending order");
        int[][] result5 = arraySorting
                .sortByStartValueDescending(new int[][] { { 1, 2 }, { 2, 7 }, { 5, 10 }, { 11, 15 }, { 16, 19 } });
        System.out.println(Arrays.deepToString(result5));

    }
}
