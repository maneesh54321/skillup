package com.learning.twentyfour.phase2.dsalgo;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int target = 11;
//		int[] nums = {2, 3, 1, 2, 4, 3};
//		int[] nums = {1,4,4};
		int[] nums = {1,1,1,1,1,1,1,1};

		System.out.println(minSubArrayLen(target, nums));
	}

	public static int minSubArrayLen(int target, int[] nums) {
		if (nums.length == 1) {
			if (target <= nums[0]) {
				return 1;
			}
			return 0;
		}

		int l = 0, r = 1;

		int currSum = nums[0];

		int minLen = Integer.MAX_VALUE;

		while (l <= r) {
			while (r < nums.length && currSum < target) {
				currSum += nums[r++];
			}
			if (currSum < target) {
				break;
			}
			minLen = Math.min(minLen, r - l);
			currSum -= nums[l];
			l++;
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;

	}
}
