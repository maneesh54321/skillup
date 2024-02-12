package com.learning.twentyfour.dsalgo.dp;

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n){
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n ; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                int square = j*j;
                min = Math.min(min, 1 + memo[i-square]);
            }
            memo[i] = min;
        }
        return memo[n];
    }
}
