package com.learning.twentyfour.phase2.dsalgo;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {

//		int[] nums = {1,2,3,4};
//
		int[] nums = {-1,1,0,-3,3};

		System.out.println(Arrays.toString(productExceptSelf(nums)));

	}

	public static int[] productExceptSelf(int[] nums) {
		int zeroCount = 0;
		int product = 1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) zeroCount++;
			else product *= nums[i];
		}

		if(zeroCount > 1) {
			Arrays.fill(nums, 0);
			return nums;
		}

		for (int i = 0; i < nums.length; i++) {
			if(zeroCount == 1) {
				if(nums[i] != 0 )	nums[i] = 0;
				else nums[i] = product;
			} else {
				nums[i] = product / nums[i];
			}
		}

		return nums;
	}

}
