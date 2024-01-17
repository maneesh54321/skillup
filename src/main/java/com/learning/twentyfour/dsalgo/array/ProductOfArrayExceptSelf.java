package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
//        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int currProduct = 1;
        result[0] = currProduct;
        for (int i = 1; i < nums.length; i++) {
            currProduct = currProduct * nums[i-1];
            result[i] = currProduct;
        }
        currProduct = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            currProduct = currProduct * nums[i+1];
            result[i] = currProduct * result[i];
        }
        return result;
    }
}
