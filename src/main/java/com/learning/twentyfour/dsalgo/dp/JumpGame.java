package com.learning.twentyfour.dsalgo.dp;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
//		int[] nums = {3,2,1,0,4};
		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums) {
		Map<Integer, Boolean> memo = new HashMap<>();
		return canJump(nums, nums.length-1, memo);
	}

	public static boolean canJump(int[] nums, int pos, Map<Integer, Boolean> memo) {
		if(pos == 0){
			return true;
		}
		if(memo.containsKey(pos)){
			return memo.get(pos);
		}
		for (int i = 0; i < pos; i++) {
			if(i+nums[i] >= pos){
				if(canJump(nums, i, memo)){
					memo.put(i, true);
					return true;
				}
			}
		}
		memo.put(pos, false);
		return false;
	}
}
