package com.learning.twentyfour.dsalgo.dp;

public class JumpGameII {

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
//		int[] nums = {3,2,1,0,4};
		System.out.println(jump(nums));
	}

	public static int jump(int[] nums){
		if(nums.length <= 1){
			return 0;
		}
		int[] memo = new int[10000];
		return jump(nums, 0, memo);
	}

	public static int jump(int[] nums, int start, int[] memo){
		int curr = nums[start];
		if(memo[start] > 0){
			return memo[start];
		}
		if(start + curr >= nums.length-1){
			return 1;
		}
		int minJump = Integer.MAX_VALUE;
		for(int i=start + curr; i > start; i--){
			int reqMinJump = 1 + jump(nums, i, memo);
			if( reqMinJump > 0){
				minJump = Math.min(minJump, reqMinJump);
			}
		}
		memo[start] = minJump;
		return minJump;
	}
}
