package com.learning.twentyfour.dsalgo.array;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,2,2,1,5}));
//        System.out.println(1^2);
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
