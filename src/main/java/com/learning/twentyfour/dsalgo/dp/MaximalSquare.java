package com.learning.twentyfour.dsalgo.dp;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        maximalSquare(matrix);
    }

    public static int maximalSquare(char[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] mat = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            mat[0][j] = matrix[0][j]-'0';
            if(mat[0][j] == 1){
                max = 1;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            mat[i][0] = matrix[i][0]-'0';
            if(mat[i][0] == 1){
                max = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0'){
                    continue;
                }
                mat[i][j] = 1 + Math.min(mat[i-1][j], Math.min(mat[i][j-1], mat[i-1][j-1]));
                max = Math.max(max, mat[i][j]);
            }
        }
        return max*max;
    }
}
