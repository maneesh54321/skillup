package com.learning.twentythree.dsalgo.string;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("leetcode"));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int r = i;
            int l = i;
            boolean isOddPalindrome = true;
            boolean isEvenPalindrome = true;
            while(l >=0 && r < s.length() && (isEvenPalindrome || isOddPalindrome)){
                if(r+1 < s.length()){
                    if(isEvenPalindrome && s.charAt(l) == s.charAt(r+1)){
                        count++;
                    } else {
                        isEvenPalindrome = false;
                    }
                }
                if(isOddPalindrome && s.charAt(l) == s.charAt(r)){
                    count++;
                } else {
                    isOddPalindrome = false;
                }
                r++;
                l--;
            }
        }
        return count;
    }
}
