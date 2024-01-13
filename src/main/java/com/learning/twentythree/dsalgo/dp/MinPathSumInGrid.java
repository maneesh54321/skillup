package com.learning.twentythree.dsalgo.dp;

import java.util.Arrays;

public class MinPathSumInGrid {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPathSumInGrid main = new MinPathSumInGrid();

        System.out.println(main.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return minPathSum(grid, grid.length-1, grid[0].length-1, memo);
    }

    public int minPathSum(int[][] grid, int i, int j, int[][] memo) {
        if(memo[i][j] != -1){
            System.out.println("Returning memoized value!!");
            return memo[i][j];
        }
        System.out.println("Calculating...");
        int result;
        if(i==0 && j==0){
            result = grid[i][j];
        } else {
            if(i==0){
                result = minPathSum(grid, i, j-1, memo) + grid[i][j];
            } else if (j == 0) {
                result = minPathSum(grid, i-1, j, memo) + grid[i][j];
            } else {
                result = grid[i][j] + Math.min(minPathSum(grid, i-1, j, memo), minPathSum(grid, i, j-1, memo));
            }
        }
        memo[i][j] = result;
        return result;
    }
}
