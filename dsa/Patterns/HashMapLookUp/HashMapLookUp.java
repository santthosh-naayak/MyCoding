package dsa.Patterns.HashMapLookUp;

import java.util.HashMap;

public class HashMapLookUp {
    int[] nums;
    int target;

    public HashMapLookUp(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public int[] twoSum() {
        HashMap<Integer, Integer> myHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (myHashMap.containsKey(complement)) {
                return new int[] { myHashMap.get(complement), i };
            }
            myHashMap.put(nums[i], i);
        }
        return new int[] {};
    }
}
