package com.learning.twentythree.dsalgo.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "baced";

        LongestCommonSubsequence main = new LongestCommonSubsequence();

        int[][] memo = new int[text1.length()][text2.length()];

        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        System.out.println(main.LCS(text1, text2, 0, 0, memo));
    }

    public int LCS(String text1, String text2, int i, int j, int[][] memo) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            System.out.println("Returning memoized value!!!");
            return memo[i][j];
        }

        System.out.println("Calculating!!!");
        int result;
        if (text1.charAt(i) == text2.charAt(j)) {
            result = 1 + LCS(text1, text2, i + 1, j + 1, memo);
        } else {
            result = Math.max(LCS(text1, text2, i, j + 1, memo), LCS(text1, text2, i + 1, j, memo));
        }
        memo[i][j] = result;
        return result;
    }
}
