package com.learning.twentyfour.phase2.binarysearch;

public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 13;

		System.out.println(searchMatrix(matrix, target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		int l = 0, r = m * n - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int x = mid / n;
			int y = mid % n;
			int currEle = matrix[x][y];
			if (currEle == target) {
				return true;
			} else if (target < currEle) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return false;
	}

}
