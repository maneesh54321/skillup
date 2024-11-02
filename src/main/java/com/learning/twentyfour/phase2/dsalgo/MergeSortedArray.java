package com.learning.twentyfour.phase2.dsalgo;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
//		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;

		merge(nums1, m, nums2, n);

		System.out.println(Arrays.toString(nums1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if(nums2.length == 0) return;
		int a = 0;
		int b = 0;

		int[] tmp = new int[m+n];

		int count = 0;

		while (a < m && b < n) {
			if (nums1[a] < nums2[b]) {
				tmp[count] = nums1[a++];
			} else {
				tmp[count] = nums2[b++];
			}
			count++;
		}

		if(a < m) {
			while (a < m) {
				tmp[count++] = nums1[a++];
			}
		} else {
			while (b < n) {
				tmp[count++] = nums2[b++];
			}
		}

		System.arraycopy(tmp, 0, nums1, 0, m+n);
	}
}
