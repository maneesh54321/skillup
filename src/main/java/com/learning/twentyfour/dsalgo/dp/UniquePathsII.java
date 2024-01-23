package com.learning.twentyfour.dsalgo.dp;

public class UniquePathsII {

    public static void main(String[] args) {

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        if(m==1 && n==1){
            return 1;
        }
        int[][] count = new int[m][n];
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, count, m, n);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y, int[][] count, int m, int n) {
        if((x+1 == m-1 && y == n-1) || (x == m-1 && y+1 == n-1)){
            return 1;
        }
        if(count[x][y] > 0){
            return count[x][y];
        }
        int down = 0;
        if(x+1 < m && obstacleGrid[x+1][y] != 1 ){
            down = uniquePathsWithObstacles(obstacleGrid, x+1, y, count, m, n);
        }
        int right = 0;
        if(y+1 < n && obstacleGrid[x][y+1] != 1){
            right = uniquePathsWithObstacles(obstacleGrid, x, y+1, count, m, n);
        }
        count[x][y] = down + right;
        return down + right;
    }
}
