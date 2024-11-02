package com.learning.twentyfour.phase2.dsalgo;

import java.util.Arrays;

public class FindIndexOfFirstOccurence {

	public static void main(String[] args) {
//		String haystack = "sadbutsad", needle = "sad";
//		String haystack = haystack = "leetcode", needle = "leeto";
		String haystack = haystack = "mississippi", needle = "issip";

		System.out.println(strStr(haystack, needle));
	}

	public static int strStr(String haystack, String needle) {
		int[] lps = buildLPS(needle);

		int j = 0;
		int i = 0;

		while (i < haystack.length()) {
			if(haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				if(j == 0) {
					i++;
				} else {
					j = lps[j-1];
				}
			}

			if(j == needle.length()) {
				return i - needle.length();
			}
		}

		return -1;
	}

	private static int[] buildLPS(String pattern) {
		int[] lps = new int[pattern.length()];

		int pLps = 0;
		lps[pLps] = 0;

		int i = 1;

		while ( i < pattern.length()) {
			if(pattern.charAt(i) == pattern.charAt(pLps)) {
				lps[i] = pLps + 1;
				i++;
				pLps++;
			} else {
				if(pLps == 0) {
					lps[i++] = 0;
				} else {
					pLps = lps[pLps-1];
				}
			}
		}

		return lps;
	}

}
