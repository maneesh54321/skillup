package com.learning.twentyfour.phase2.dsalgo;

public class IsSubsequence {

    public static void main(String[] args) {
//        String s = "abc", t = "ahbgdc";
        String s = "axc", t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) return true;

        if(t.isEmpty()) return false;

        if(s.length() > t.length()) return false;

        if(s.length() == t.length()) return s.equals(t);

        int si = 0;

        for (int i = 0; i < t.length(); i++) {
            if(si == s.length()) return true;
            char tc = t.charAt(i);
            char sc = s.charAt(si);

            if(tc == sc) si++;

        }

        if(si == s.length()) return true;

        return false;
    }
}
