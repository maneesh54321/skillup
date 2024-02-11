package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class DivideArrayIntoArrayWithMaxKDiff {

	public static void main(String[] args) {
		int[] nums = {1,3,3,2,7,3};
		Arrays.stream(divideArray(nums, 3)).forEach(arr -> System.out.println(Arrays.toString(arr)));
	}

	public static int[][] divideArray(int[] nums, int k) {
		if(nums.length == 0 || nums.length % 3 !=0)
			return new int[][]{};
		int[][] result = new int[nums.length/3][3];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		int[] freqs = new int[max+1];
		for(int i = 0; i < nums.length; i++){
			freqs[nums[i]]++;
		}
		int resIdx = 0;
		int eachResIdx = 0;
		for(int i = 1; i <= max; i++){
			while(freqs[i] > 0){
				if(eachResIdx == 3) {
					if(Math.abs(result[resIdx][eachResIdx-1] - result[resIdx][eachResIdx-3]) > k){
						return new int[][]{};
					}
					resIdx++;
					eachResIdx = 0;
				}
				result[resIdx][eachResIdx++] = i;
				freqs[i]--;
			}
		}
		if(Math.abs(result[resIdx][eachResIdx-1] - result[resIdx][eachResIdx-3]) > k){
			return new int[][]{};
		}
		return result;
	}

}
