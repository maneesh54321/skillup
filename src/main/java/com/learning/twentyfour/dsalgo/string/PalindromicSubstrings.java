package com.learning.twentyfour.dsalgo.string;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaaaa"));
	}

	public static int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			int r = i;
			int l = i;
			while(l >=0 && r < s.length()){
				if(r+1 < s.length()){
					if(isPalindrome(s, l, r+1)){
						count++;
					}
				}
				if(s.charAt(l) == s.charAt(r)){
					count++;
				} else {
					break;
				}
				r++;
				l--;
			}
		}
		return count;
	}

	public static boolean isPalindrome(String s, int l, int r){
		if(l==r){
			return true;
		}
		while (l < r){
			if (s.charAt(l) != s.charAt(r)){
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
