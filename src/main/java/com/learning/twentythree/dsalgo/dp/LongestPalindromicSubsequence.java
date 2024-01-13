package com.learning.twentythree.dsalgo.dp;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        LongestPalindromicSubsequence main = new LongestPalindromicSubsequence();

        System.out.println(main.longestPalindromeSubseq("bbbab", 0, 4));
    }

    public int longestPalindromeSubseq(String s, int l, int r) {
        if (r < l) {
            return 0;
        } else if (r == l) {
            return 1;
        } else {
            if (s.charAt(l) == s.charAt(r)) {
                return 2 + longestPalindromeSubseq(s, ++l, --r);
            } else {
                return Math.max(
                        Math.max(
                                longestPalindromeSubseq(s, l + 1, r),
                                longestPalindromeSubseq(s, l, r - 1)
                        ),
                        longestPalindromeSubseq(s, l + 1, r - 1)
                );
            }
        }
    }
}
