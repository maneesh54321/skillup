package com.learning.twentysix.twopointers;

public class SortColors {

	public static int[] sortColors(int[] colors) {
		if (colors.length == 1) {
			return colors;
		}
		int l = 0, r = colors.length - 1, curr = 0;

		while (curr < r) {
			if(colors[curr] == 0) {
				swap(l, curr, colors);
				l++;
				curr++;
			} else if (colors[curr] == 2) {
				swap(curr, r, colors);
				r--;
			} else {
				curr++;
			}
		}
		return colors;
	}

	private static void swap(int l, int r, int[] colors) {
		int tmp = colors[l];
		colors[l] = colors[r];
		colors[r] = tmp;
	}

}
