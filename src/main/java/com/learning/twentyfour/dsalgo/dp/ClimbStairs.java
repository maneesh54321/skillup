package com.learning.twentyfour.dsalgo.dp;

public class ClimbStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
		System.out.println(climbStairs(36));
	}

	public static int climbStairs(int n) {
		int nums[] = new int[46];
		nums[n-1] = 1;
		return climbStairs(n, 0, nums);
	}

	public static int climbStairs(int n, int start, int[] nums){
		if(nums[start] > 0){
			return nums[start];
		}
		if(n - start == 2){
			nums[start] = 2;
			return 2;
		}
		int oneStep = climbStairs(n, start + 1, nums);
		int twoStep = climbStairs(n, start + 2, nums);
		nums[start] = oneStep + twoStep;
		return oneStep + twoStep;
	}

}
