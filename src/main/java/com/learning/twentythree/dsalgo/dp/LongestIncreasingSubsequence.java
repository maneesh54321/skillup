package com.learning.twentythree.dsalgo.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence main = new LongestIncreasingSubsequence();

        int[] arr = new int[]{5, 2, 8, 6, 3, 6, 9, 5};
        System.out.println(main.longestIncSubsequence(arr));
    }

    public int longestIncSubsequence(int[] arr) {
        int max = 0;
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            max = Math.max(LIS_recur(arr, i, memo), max);
        }
        return max;
    }

    public int LIS_recur(int[] arr, int k, int[] memo) {
        if (memo[k] != -1) {
            System.out.println("returning memoized result!!");
            return memo[k];
        }
        System.out.println("calculating!!");
        int result;
        if (k == 0) {
            result = 1;
        } else {
            int max = 0;
            int i = k - 1;
            while (i >= 0) {
                if (arr[i] < arr[k])
                    max = Math.max(LIS_recur(arr, i, memo), max);
                i--;
            }
            result = 1 + max;
        }
        memo[k] = result;
        return result;
    }
}
