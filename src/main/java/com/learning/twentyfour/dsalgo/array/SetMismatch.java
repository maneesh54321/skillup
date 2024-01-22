package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class SetMismatch {

    public static void main(String[] args) {
//        int[] nums = {1,2,2,4};
        int[] nums = {1,1};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int dupeNum = 0;
        int missingNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if(currNum < 0) {
                currNum *= -1;
            }
            int idx = currNum - 1;
            if(nums[idx] < 0){
                dupeNum = currNum;
            } else {
                nums[idx] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                missingNum = i+1;
                break;
            }
        }
        return new int[]{dupeNum,missingNum};
    }
}
