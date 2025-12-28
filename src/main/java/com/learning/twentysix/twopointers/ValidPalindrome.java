package com.learning.twentysix.twopointers;

public class ValidPalindrome {

	public static void main(String[] args) {

	}

	public static boolean isPalindrome(String s) {
		if(s.length() == 1) return true;

		int l = 0, r = s.length() - 1;

		while(l < r) {
			if (!Character.isLetterOrDigit(s.charAt(l))) {
				l++;
			} else if (!Character.isLetterOrDigit(s.charAt(r))) {
				r--;
			} else {
				if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
			}
		}
		return true;
	}
}
