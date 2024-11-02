package com.learning.twentyfour.phase2.dsalgo;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
//		var s = "abcabcbb";
//		var s = "bbbbb";
		var s = "tmmzuxt";

		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s.length() <=1) return s.length();
		int max = 0;

		int startIdx = 0;

		var map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.getOrDefault(c, -1) >= startIdx) {
				startIdx = map.get(c) + 1;
				map.put(c, i);
			} else {
				map.put(c, i);
				max = Math.max(max, i - startIdx + 1);
			}
		}

		return max;
	}

}
