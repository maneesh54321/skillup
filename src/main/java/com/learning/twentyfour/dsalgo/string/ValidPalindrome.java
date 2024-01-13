package com.learning.twentyfour.dsalgo.string;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
//        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char left = s.charAt(i);
            if (left >= 'A' && left <= 'Z') {
                left = (char) (left + 32);
            } else if (left >= 'a' && left <= 'z' || (left >= '0' && left <= '9')) {

            } else {
                i++;
                continue;
            }
            char right = s.charAt(j);
            if (right >= 'A' && right <= 'Z') {
                right = (char) (right + 32);
            } else if ((right >= 'a' && right <= 'z') || (right >= '0' && right <= '9')) {

            } else {
                j--;
                continue;
            }
            if (left != right) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
