package com.learning.twentyfour.phase2.dsalgo;

import java.util.Arrays;

public class RemoveDuplicatesSortedArrII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        System.out.println(removeDuplicates(nums));

        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int index = 0;
        int currFreq = 0;
        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            if(curr == prev) {
                currFreq++;
                if(currFreq > 2) continue;
                nums[index++] = curr;
            } else {
                nums[index++] = curr;
                currFreq = 1;
                prev = curr;
            }
        }

        return index;
    }
}
