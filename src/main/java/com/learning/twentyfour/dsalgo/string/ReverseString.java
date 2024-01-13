package com.learning.twentyfour.dsalgo.string;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
//        char[] s = "hello".toCharArray();
        char[] s = "hannah".toCharArray();
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int i = 0, j = s.length-1;

        while( i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
