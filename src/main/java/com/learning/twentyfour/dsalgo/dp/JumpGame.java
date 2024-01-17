package com.learning.twentyfour.dsalgo.dp;

public class JumpGame {

	public static void main(String[] args) {
//		int[] nums = {2,3,1,1,4};
		int[] nums = {3,2,1,0,4};
		System.out.println(canJump(nums));
	}

//	public static boolean canJump(int[] nums) {
//		Set<Integer> memo = new HashSet<>();
//		return canJump(nums, nums.length-1, memo);
//	}
//
//	public static boolean canJump(int[] nums, int pos, Set<Integer> memo) {
//		if(pos == 0){
//			return true;
//		}
//		if(memo.contains(pos)){
//			return true;
//		}
//		for (int i = 0; i < pos; i++) {
//			if(i+nums[i] >= pos){
//				if(canJump(nums, i, memo)){
//					return true;
//				}
//			}
//		}
//		memo.add(pos);
//		return false;
//	}

//	public static boolean canJump(int[] nums){
//		int[] memo = new int[10000];
//		return canJump(nums, 0, memo);
//	}
//
//	public static boolean canJump(int[] nums, int start, int[] memo){
//		int curr = nums[start];
//		if(memo[start] == 1){
//			return false;
//		}
//		if(start + curr >= nums.length-1){
//			return true;
//		}
//		for(int i=start+1; i <= start + curr; i++){
//			if(canJump(nums, i, memo)){
//				return true;
//			}
//		}
//		memo[start] = 1;
//		return false;
//	}

	public static boolean canJump(int[] nums){
		int gas = 1;
		for (int i = 0; i < nums.length; i++) {
			gas--;
			if(gas < 0){
				return false;
			}
			if(nums[i] > gas){
				gas = nums[i];
			}
		}
		return true;
	}
}
