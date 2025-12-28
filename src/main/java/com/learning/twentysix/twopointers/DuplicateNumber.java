package com.learning.twentysix.twopointers;

public class DuplicateNumber {
	public static int findDuplicate(int[] nums) {
		if (nums.length ==  2) return nums[0];

		int slow = nums[0];
		int fast = nums[nums[0]];

		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		int curr = nums[0];

		while (curr != slow){
			slow = nums[slow];
			curr = nums[curr];
		}

		return curr;
	}
}
