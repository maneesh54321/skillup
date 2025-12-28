package com.learning.twentyfour.phase2.binarysearch;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
//		int target = 5;
		int target = 7;

		System.out.println(searchInsert(nums, target));
	}

	public static int searchInsert(int[] nums, int target) {
		int l = 0, r = nums.length - 1;

		while (l < r) {
			int m = l + (r - l) / 2;
			int midEle = nums[m];
			if(midEle == target) return m;
			else if (target < midEle) {
				r = m - 1;
			} else {
				l = m +1;
			}
		}

		int currEle = nums[l];
		if(currEle < target) return l + 1;
		else return l;
	}

}
