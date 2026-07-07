package dsa.Patterns.HashMapLookUp;

import java.util.Arrays;

public class Main {
    /*
     * Given an array of integers `nums` and an integer `target`, return *indices of
     * the two numbers such that they add up to `target`* .
     * 
     * You may assume that each input would have ***exactly* one solution** , and
     * you may not use the *same* element twice.
     * 
     * You can return the answer in any order.
     */
    public static void main(String[] args) {
        HashMapLookUp myHashMapLookUp1 = new HashMapLookUp(new int[] { 1, 2, 3, 4 }, 3);
        int result1[] = myHashMapLookUp1.twoSum();
        System.out.println(Arrays.toString(result1));
        HashMapLookUp myHashMapLookUp2 = new HashMapLookUp(new int[] { 1, 2, 3, 4 }, 5);
        int result2[] = myHashMapLookUp2.twoSum();
        System.out.println(Arrays.toString(result2));
        HashMapLookUp myHashMapLookUp3 = new HashMapLookUp(new int[] { 1, 2, 3, 4 }, 6);
        int result3[] = myHashMapLookUp3.twoSum();
        System.out.println(Arrays.toString(result3));
    }
}
