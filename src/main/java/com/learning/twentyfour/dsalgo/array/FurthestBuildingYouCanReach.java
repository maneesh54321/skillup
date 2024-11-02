package com.learning.twentyfour.dsalgo.array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

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
		for (int i = n-1; i >= 1; i--) {
			Set<Integer> set = new HashSet<>();
			if(ladders > 0) {
				set = findNMax(heights, i, ladders);
			}
			int j = 1;
			int currLadders = ladders;
			int currBricks = bricks;
			while (j <= n){
				if(j > i){
					return i;
				}
				if(heights[j] > 0) {
					if(currLadders > 0 && set.contains(heights[j])){
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

	private Set<Integer> findNMax(int[] nums, int limit, int n){
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);
		int i = 0;
		while (i <= limit){
			if(minHeap.size() < n){
				minHeap.add(nums[i]);
			} else if(minHeap.size() == n && minHeap.peek() < nums[i]){
				minHeap.remove();
				minHeap.add(nums[i]);
			}
			i++;
		}
		Set<Integer> result = new HashSet<>();
		while (!minHeap.isEmpty()){
			result.add(minHeap.remove());
		}
		return result;
	}
}
