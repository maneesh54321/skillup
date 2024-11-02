package com.learning.twentyfour.phase2.dsalgo;

import java.util.Arrays;

public class RemoveDuplicatesSortedArr {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        System.out.println(removeDuplicates(nums));

        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {

        int index = 0;

        int prev = -200;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if(curr == prev) continue;
            nums[index++] = curr;
            prev = curr;
        }

        return index;
    }
}
