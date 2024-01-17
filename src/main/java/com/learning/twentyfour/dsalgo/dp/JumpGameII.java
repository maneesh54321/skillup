package com.learning.twentyfour.dsalgo.dp;

public class JumpGameII {

    public static void main(String[] args) {
//		int[] nums = {2,3,1,1,4};
//		int[] nums = {2,3,0,1,4};
//        int[] nums = {1, 1, 1, 1};
        int[] nums = {10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(minJump(nums));
    }

    public static int minJump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int currMaxJump = nums[0];
        if (currMaxJump >= nums.length - 1) {
            return 1;
        }
        int maxStep = -1;
        int maxStepIdx = 0;
        int i = 1;
        int jumpCount = 0;
        while (i < nums.length) {
            if (currMaxJump == 0) {
                currMaxJump = maxStep;
                maxStep = -1;
                i = maxStepIdx + 1;
                jumpCount++;
                if (maxStepIdx + currMaxJump >= nums.length - 1) {
                    jumpCount++;
                    break;
                }
            }
            currMaxJump--;
            if (nums[i] >= maxStep - (i - maxStepIdx)) {
                maxStep = nums[i];
                maxStepIdx = i;
            }
            i++;
        }
        return jumpCount;
    }

//	public static int jump(int[] nums){
//		if(nums.length <= 1){
//			return 0;
//		}
//		int[] memo = new int[10000];
//		return jump(nums, 0, memo);
//	}
//
//	public static int jump(int[] nums, int start, int[] memo){
//		int curr = nums[start];
//		if(memo[start] > 0){
//			return memo[start];
//		}
//		if(start + curr >= nums.length-1){
//			memo[start] = 1;
//			return 1;
//		}
//		int minJump = Integer.MAX_VALUE;
//		for(int i = start + curr; i > start; i--){
//			int reqMinJump = 1 + jump(nums, i, memo);
//			if( reqMinJump > 0){
//				minJump = Math.min(minJump, reqMinJump);
//			}
//		}
//		memo[start] = minJump;
//		return minJump;
//	}
}
