package com.learning.twentyfour.dsalgo.string;

public class ValidAnagram {

    public static void main(String[] args) {
//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        System.out.println(validAnagram(s, t));
    }

    private static boolean validAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] store = new int[26];
        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int freq = store[t.charAt(i) - 'a'];
            if(freq == 0){
                return false;
            }
            store[t.charAt(i) - 'a'] = freq - 1;
        }
        return true;
    }
}
