package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class RemoveDupesFromSortedArrII {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3};
//		int[] nums = {0,0,1,1,1,1,2,3,3};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		int prev = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			int curr = nums[i];
			if (curr == prev) {
				count++;
				if (count > 2) {
					nums[i] = Integer.MIN_VALUE;
				}
			} else {
				count = 1;
			}
			prev = curr;
		}
		int j = 1;
		while (j < nums.length && nums[j] != Integer.MIN_VALUE) {
			j++;
		}
		if (j != nums.length) {
			for (int i = j + 1; i < nums.length; i++) {
				if (nums[i] == Integer.MIN_VALUE) {
					continue;
				}
				nums[j++] = nums[i];
			}
		}
		return j;
	}
}
