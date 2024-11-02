package com.learning.twentyfour.phase2.dsalgo.dp;

import java.util.Arrays;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int[] minJumpCache = new int[nums.length];

        Arrays.fill(minJumpCache, -1);

        minJumpCache[0] = 0;

        return jump(nums, minJumpCache, nums.length - 1);
    }

    public static int jump(int[] nums, int[] minJumpCache, int idx) {
        if (minJumpCache[idx] != -1) return minJumpCache[idx];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < idx; i++) {
            if (i + nums[i] >= idx) {
                min = Math.min(min, jump(nums, minJumpCache, i));
            }
        }

        minJumpCache[idx] = 1 + min;

        return minJumpCache[idx];
    }
}
