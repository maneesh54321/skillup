package com.learning.twentyfour.phase2.dsalgo;

import java.util.Arrays;

public class TwoSumIISortedArray {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if(sum == target) {
                return new int[] {l+1, r+1};
            }
            if(sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }
}
