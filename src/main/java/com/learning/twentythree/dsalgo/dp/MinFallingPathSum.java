package com.learning.twentythree.dsalgo.dp;

import java.util.Arrays;

public class MinFallingPathSum {

    public static void main(String[] args) {
        MinFallingPathSum main = new MinFallingPathSum();
        int[][] grid = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(main.minFallingPathSum(grid));
    }

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        for (int k = 0; k < matrix[matrix.length - 1].length; k++) {
            min = Math.min(minFallingPathSum(matrix, matrix.length - 1, k, memo), min);
        }
        return min;
    }

    public int minFallingPathSum(int[][] matrix, int i, int j, int[][] memo) {
        int result;
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        } else {
            if (i == 0) {
                result = matrix[i][j];
            } else {
                if (j == 0) {
                    result = matrix[i][j] + Math.min(minFallingPathSum(matrix, i - 1, j, memo), minFallingPathSum(matrix, i - 1, j + 1, memo));
                } else if (j == matrix[0].length - 1) {
                    result = matrix[i][j] + Math.min(minFallingPathSum(matrix, i - 1, j - 1, memo), minFallingPathSum(matrix, i - 1, j, memo));
                } else {
                    result = matrix[i][j] + Math.min(Math.min(minFallingPathSum(matrix, i - 1, j - 1, memo), minFallingPathSum(matrix, i - 1, j, memo)), minFallingPathSum(matrix, i - 1, j + 1, memo));
                }
            }
            memo[i][j] = result;
        }
        return result;
    }
}
