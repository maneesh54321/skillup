package com.learning.twentyfour.phase2.dsalgo;

public class MajorityElement {

    public static void main(String[] args) {

//        int[] nums = {3,2,3};
        int[] nums = {2,2,1,1,1,2,2};

        System.out.println(majorityElement(nums));

    }

    public static int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        int count = 1;
        int currNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num == currNum) {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                currNum = num;
                count = 1;
            }
        }

        return currNum;
    }
}
