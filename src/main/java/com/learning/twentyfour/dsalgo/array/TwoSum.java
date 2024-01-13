package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if(map.containsKey(k)){
                return new int[]{i, map.get(k)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
