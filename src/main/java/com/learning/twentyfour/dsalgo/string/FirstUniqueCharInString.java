package com.learning.twentyfour.dsalgo.string;

public class FirstUniqueCharInString {
    public static void main(String[] args) {
//        String s = "leetcode";
        String s = "loveleetcode";
        System.out.println(firstUniqueChar(s));
    }

    public static int firstUniqueChar(String s) {
        if(s == null || s.isEmpty()){
            return -1;
        }
        if(s.length() == 1){
            return 0;
        }

        char[] tmp = new char[26];
        for (int i = 0; i < s.length(); i++) {
            tmp[s.charAt(i)-97]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(tmp[s.charAt(i)-97] == 1){
                return i;
            }
        }
        return -1;
    }
}
