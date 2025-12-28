package com.learning.twentysix.twopointers;


public class CircularArrayLoop {

	public static void main(String[] args) {
//		int[] nums = {5, 4, -2, -1, 3};
		int[] nums = {-4737,-4455};

		System.out.println(circularArrayLoop(nums));
	}

	public static boolean circularArrayLoop(int[] nums) {

		// Replace this placeholder return statement with your code
		for(int i = 0; i < nums.length; i++) {
			if(hasValidCycle(nums, i)) return true;
		}
		return false;
	}

	public static boolean hasValidCycle(int[] nums, int startIdx){
		int slow = startIdx;
		int fast = startIdx;
		do {
			int newSlow = move(nums, slow);
			if(nums[slow]*nums[newSlow] < 0) {
				// cycle has just one element
				return false;
			} else slow = newSlow;

			fast = move(nums, fast);
			fast = move(nums, fast);
		} while(slow != fast);

		// cycle is present
		int start = slow;

		// check if there is only one element in the cycle
		int next = move(nums, slow);
		return start != next;
	}

	public static int move(int[] nums, int fromIdx) {
		int steps = nums[fromIdx] % nums.length;

		if (steps < 0) {
			// going backward
			if (fromIdx + steps < 0) {
				return nums.length + (fromIdx + steps);
			} else return fromIdx + steps;
		} else {
			// going forward
			if (fromIdx + steps >= nums.length) {
				return (fromIdx + steps) - nums.length;
			} else return fromIdx + steps;
		}
	}
}
