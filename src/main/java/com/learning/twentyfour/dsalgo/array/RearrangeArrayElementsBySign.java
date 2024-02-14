package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {

	public static void main(String[] args) {
//		int[] nums = {3,1,-2,-5,2,-4};
		int[] nums = {-1,1};
		System.out.println(Arrays.toString(new RearrangeArrayElementsBySign().rearrangeArray(nums)));
	}

	public int[] rearrangeArray(int[] nums) {
		int[] tmp = new int[nums.length];
		int j = 0, k = 1;
		for (int num : nums) {
			if (num >= 0) {
				tmp[j] = num;
				j += 2;
			} else {
				tmp[k] = num;
				k += 2;
			}
		}
		return tmp;
	}
}
