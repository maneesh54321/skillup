package com.learning.twentyfour.phase2.dsalgo;

public class ValidPalindrome {

    public static void main(String[] args) {
//        var s = "A man, a plan, a canal: Panama";
//        var s = "race a car";
        var s = "0P";

        System.out.println(isPalindrome(s));
//        System.out.println((int)'A' );
//        System.out.println((int)'a');
    }

    public static boolean isPalindrome(String s) {

        var n = s.length();

        int l = 0, r = n - 1;

        while (l < r) {
            char c1 = s.charAt(l);
            if (!isAlphaNumeric(c1)) {
                l++;
                continue;
            }
            char c2 = s.charAt(r);
            if (!isAlphaNumeric(c2)) {
                r--;
                continue;
            }
            if (toLowerCase(c1) != toLowerCase(c2)) return false;
            l++;
            r--;
        }

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    private static char toLowerCase(char c) {
        return c >= 'A' && c <= 'Z' ? (char) ('a' - 'A' + c) : c;
    }
}
