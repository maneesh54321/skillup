package com.learning.twentyfour.dsalgo.dp;

import java.util.Arrays;
import java.util.List;

public class GridJump {
	public static int getMinimumMoves(List<List<Integer>> maze, int k) {
		// Write your code here
		int[][] memo = new int[maze.size()][maze.get(0).size()];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		return getMinimumMoves(maze, k, 0, 0, memo);
	}

	public static int getMinimumMoves(List<List<Integer>> maze, int k, int i, int j, int[][] memo) {
		if(i < 0 || i >= maze.size()
				|| j < 0 || j >= maze.get(0).size()){
			return Integer.MAX_VALUE;
		}
		if(i == maze.size()-1 && j == maze.get(0).size()-1){
			return 0;
		}
		if(memo[i][j] >=0){
			return memo[i][j];
		}
		// Write your code here
		int m1 = Integer.MAX_VALUE;
		int m2 = Integer.MAX_VALUE;
		int m3 = Integer.MAX_VALUE;
		int m4 = Integer.MAX_VALUE;
		for (int l = 1; l <= k; l++) {
			if(i + l < maze.size() && maze.get(i+l).get(j) != 1) {
				int moves = getMinimumMoves(maze, k, i + l, j, memo);
				if(moves != Integer.MAX_VALUE){
					m1 = Math.min(m1, moves);
				}
			}
			if(j + l < maze.get(0).size() && maze.get(i).get(j+l) != 1) {
				int moves = getMinimumMoves(maze, k, i, j+l, memo);
				if(moves != Integer.MAX_VALUE){
					m2 = Math.min(m2, moves);
				}
			}
			if(i - l >= 0 && maze.get(i-l).get(j) != 1){
				int moves = getMinimumMoves(maze, k, i-l, j, memo);
				if(moves != Integer.MAX_VALUE){
					m3 = Math.min(m3, moves);
				}
			}
			if(j - l >= 0 && maze.get(i).get(j-l) != 1){
				int moves = getMinimumMoves(maze, k, i, j-l, memo);
				if(moves != Integer.MAX_VALUE){
					m4 = Math.min(m4, moves);
				}
			}
		}
		int minMoves = 1 + Math.min(m1, Math.min(m2, Math.min(m3, m4)));
		memo[i][j] = minMoves;
		return minMoves;
	}
}

