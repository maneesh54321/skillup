package com.learning.twentyfour.dsalgo.dp;

public class UniquePathsII {

    public static void main(String[] args) {

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
            return 0;
        }
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        if(obstacleGrid.length==1 && obstacleGrid[0].length==1){
            return 1;
        }
        int[][] count = new int[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, count);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y, int[][] count) {
        if((x+1 == obstacleGrid.length-1 && y == obstacleGrid[0].length-1) || (x == obstacleGrid.length-1 && y+1 == obstacleGrid[0].length-1)){
            return 1;
        }
        if(count[x][y] > 0){
            return count[x][y];
        }
        int down = 0;
        if(x+1 < obstacleGrid.length && obstacleGrid[x+1][y] != 1 ){
            down = uniquePathsWithObstacles(obstacleGrid, x+1, y, count);
        }
        int right = 0;
        if(y+1 < obstacleGrid[0].length && obstacleGrid[x][y+1] != 1){
            right = uniquePathsWithObstacles(obstacleGrid, x, y+1, count);
        }
        count[x][y] = down + right;
        return down + right;
    }
}
