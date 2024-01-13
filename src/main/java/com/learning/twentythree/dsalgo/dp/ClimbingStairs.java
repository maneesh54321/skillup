package com.learning.twentythree.dsalgo.dp;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs main = new ClimbingStairs();
        int n = 10;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println(main.climbStairs(n, memo));
    }

    public int climbStairs(int n, int[] memo) {
        if(n < 0){
            return 0;
        }
        if(memo[n] != -1){
            System.out.println("Returning memoized result!!");
            return memo[n];
        } else {
            System.out.println("calculating!!");
            int result;
            if (n == 0) {
                result=  0;
            } else if (n == 1) {
                result = 1;
            } else if (n == 2) {
                result = 2;
            } else {
                result = climbStairs(n - 2, memo) + climbStairs(n - 1, memo);
            }
            memo[n] = result;

            return result;
        }
    }
}
