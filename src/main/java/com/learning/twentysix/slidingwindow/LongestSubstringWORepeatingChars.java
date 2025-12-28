package com.learning.twentysix.slidingwindow;

import java.util.HashSet;

public class LongestSubstringWORepeatingChars {

	public static void main(String[] args) {

	}

	public static int findLongestSubstring(String str) {

		var windowCharSet = new HashSet<Character>();

		int left = 0, right = 0;

		int maxLen = 0;

		while (right < str.length()) {
			char curr = str.charAt(right);

			if (windowCharSet.contains(curr)) {
				while (str.charAt(left) != curr) {
					windowCharSet.remove(str.charAt(left));
					left++;
				}
				left++;
			} else {
				windowCharSet.add(curr);
			}
			maxLen = Math.max(maxLen, windowCharSet.size());
			right++;
		}

		// Replace this placeholder return statement with your code
		return maxLen;
	}
}
