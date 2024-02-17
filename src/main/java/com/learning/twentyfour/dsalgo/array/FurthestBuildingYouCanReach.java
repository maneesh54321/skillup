package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class FurthestBuildingYouCanReach {

	public static void main(String[] args) {
		System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
		System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(new int[]{14,3,19,3}, 17, 0));
		System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
	}

	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		int n = heights.length;
		if(n == 1){
			return 0;
		}
		int prev = heights[0];
		heights[0] = 0;
		for (int i = 1; i < n; i++) {
			if(heights[i] > prev){
				int diff = heights[i] - prev;
				prev = heights[i];
				heights[i] = diff;
			} else {
				prev = heights[i];
				heights[i] = 0;
			}
		}
		Integer[] max = new Integer[n];
		for (int i = 0; i < n; i++) {
			max[i] = heights[i];
		}
		Arrays.sort(max);
		int maxStartIdx = n-1;
		int prevTargetHeight = Integer.MAX_VALUE;
		for (int i = n-1; i >= 1; i--) {
			if(max[maxStartIdx] == prevTargetHeight){
				maxStartIdx -=1 ;
			}
			prevTargetHeight = heights[i];
			int j = 1;
			int currLadders = ladders;
			int currBricks = bricks;
			while (j <= n && (currLadders > 0 || currBricks > 0)){
				if(j > i){
					return i;
				}
				if(heights[j] > 0) {
					if(useLadder(heights[j], max, maxStartIdx, currLadders)){
						currLadders--;
					} else if (currBricks >= heights[j]) {
						currBricks -= heights[j];
					} else {
						break;
					}
				}
				j++;
			}
		}
		return 0;
	}

	private boolean useLadder(int height, Integer[] max, int maxStartIdx, int currLadders) {
		while (currLadders > 0 && maxStartIdx >= 0){
			if(max[maxStartIdx] == height) return true;
			currLadders--;
			maxStartIdx--;
		}
		return false;
	}
}
