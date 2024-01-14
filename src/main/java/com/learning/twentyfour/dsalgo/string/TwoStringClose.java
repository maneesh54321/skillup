package com.learning.twentyfour.dsalgo.string;

import java.util.*;

public class TwoStringClose {

    public static void main(String[] args) {
//        String word1 = "abc";
//        String word2 = "bca";
        String word1 = "cabbba";
        String word2 = "abbccc";
        System.out.println(closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            freq1.put(word1.charAt(i), freq1.getOrDefault(word1.charAt(i), 0)+1);
        }
        for (int i = 0; i < word2.length(); i++) {
            freq2.put(word2.charAt(i), freq2.getOrDefault(word2.charAt(i), 0)+1);
        }
        Collection<Integer> charCount1 = freq1.values();
        Integer[] arr1 = charCount1.toArray(new Integer[0]);
        Arrays.sort(arr1);
        Integer[] arr2 = freq2.values().toArray(new Integer[0]);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if(!Objects.equals(arr1[i], arr2[i])){
                return false;
            }
        }
        return true;
    }
}
