package com.learning.twentyfour.phase2.dsalgo;

import java.util.ArrayDeque;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2,0,0};

        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        var stack = new ArrayDeque<Integer>();

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != 0) stack.push(i);
            else {
                while (!stack.isEmpty()) {
                    int idx = stack.peek();
                    if (idx + nums[idx] >= i + 1) break;
                    else stack.pop();
                }
                if(stack.isEmpty()) return false;
            }
        }

        return true;
    }

//    public static boolean canJump(int[] nums, int idx) {
//        if (idx == 0) return true;
//
//        boolean canJump = false;
//        for (int i = 0; i < idx; i++) {
//            if (i + nums[i] >= idx && canJump(nums, i)) {
//                canJump = true;
//                break;
//            }
//
//        }
//
//        return canJump;
//    }
}
