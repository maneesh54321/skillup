package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i < nums.length){
            nums[i] = 0;
            i++;
        }
    }
}
