package com.learning.twentyfour.phase2.dsalgo;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};

		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 1) return strs[0];

		Arrays.sort(strs);

		String firstString = strs[0];
		String lastString = strs[strs.length-1];

		int i;
		for (i = 0; i < firstString.length() && i < lastString.length(); i++) {
			if(firstString.charAt(i) != lastString.charAt(i)) break;
		}

		return firstString.substring(0, i);
	}
}
