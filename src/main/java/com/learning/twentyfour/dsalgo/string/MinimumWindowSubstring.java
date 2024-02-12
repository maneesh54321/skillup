package com.learning.twentyfour.dsalgo.string;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(minWindow("a", "a"));
//        System.out.println(minWindow("ab", "a"));
//        System.out.println(minWindow("aab", "aab"));
//        System.out.println(minWindow("cabefgecdaecf", "cae"));
//        System.out.println(minWindow("aa", "aa"));
//        System.out.println(minWindow("a", "b"));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> currWindowExtraFreq = new HashMap<>();
        Map<Character, Integer> requiredFreq = new HashMap<>();
        int requiredCount = 0;
        for (char c : t.toCharArray()) {
            requiredFreq.put(c, requiredFreq.getOrDefault(c, 0) + 1);
            requiredCount++;
            currWindowExtraFreq.put(c, 0);
        }
        int left = 0;
        while (left < s.length()) {
            char currChar = s.charAt(left);
            if (requiredFreq.containsKey(currChar)) {
                requiredFreq.put(currChar, requiredFreq.get(currChar) - 1);
                requiredCount--;
                break;
            }
            left++;
        }
        if(left >= s.length()){
            return "";
        }
        if(requiredCount == 0) {
            return s.charAt(left) + "";
        }
        int right = left + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        int leftBest = -1;
        int rightBest = -1;
        int minWindow = Integer.MAX_VALUE;
        while (left < s.length() && right < s.length()){
            if(requiredCount == 0) {
                if(right - left < minWindow){
                    leftBest = left;
                    rightBest = right;
                    minWindow = right - left;
                }
                char leftChar = s.charAt(left);
                requiredFreq.put(leftChar, requiredFreq.get(leftChar) + 1);
                requiredCount++;
                if(queue.isEmpty()){
                    left = right;
                    right++;
                } else {
                    left = queue.remove();
                    if(currWindowExtraFreq.get(leftChar) >= requiredFreq.get(leftChar)) {
                        requiredFreq.put(leftChar, requiredFreq.get(leftChar) - 1);
                        requiredCount--;
                        currWindowExtraFreq.put(leftChar, currWindowExtraFreq.get(leftChar)-1);
                    } else {
                        right++;
                    }
                }
            } else {
                char currChar = s.charAt(right);
                if(requiredFreq.containsKey(currChar)){
                    queue.add(right);
                    if(requiredFreq.get(currChar) > 0) {
                        requiredFreq.put(currChar, requiredFreq.get(currChar) - 1);
                        requiredCount--;
                        if(requiredCount == 0){
                            continue;
                        }
                    } else {
                        currWindowExtraFreq.put(currChar, currWindowExtraFreq.getOrDefault(currChar, 0) + 1);
                    }
                }
                right++;
            }
        }
        if(leftBest == -1 || rightBest == -1){
            return "";
        }
        return s.substring(leftBest, rightBest+1);
    }

    public String minWindow1(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n)
            return "";
        int[] tf = new int[52];
        int[] sf = new int[52];
        int uniq = 0;
        for (byte k : t.getBytes()) {
            int ind;
            if (k >= 'A' && k <= 'Z') {
                ind = k - 'A';
            } else {
                ind = k - 'a' + 26;
            }
            if (tf[ind] == 0) {
                uniq += 1;
            }
            tf[ind] += 1;
        }
        int st = 0, en = 0, cuniq = 0, mn = Integer.MAX_VALUE, first = -1, last = -1;
        while (en < n) {
            int ind;
            char k = s.charAt(en);
            if (k >= 'A' && k <= 'Z') {
                ind = k - 'A';
            } else {
                ind = k - 'a' + 26;
            }
            sf[ind] += 1;
            if (sf[ind] == tf[ind]) {
                cuniq += 1;
            }
            if (cuniq == uniq) {
                if (mn > (en - st + 1)) {
                    mn = en - st + 1;
                    last = en;
                    first = st;
                }
                while (st <= en) {
                    k = s.charAt(st);
                    if (k >= 'A' && k <= 'Z') {
                        ind = k - 'A';
                    } else {
                        ind = k - 'a' + 26;
                    }
                    if (tf[ind] == 0)
                        st += 1;
                    else {
                        if (cuniq == uniq) {
                            if (mn > (en - st + 1)) {
                                last = en;
                                first = st;
                                mn = en - st + 1;
                            }
                        }
                        if (cuniq < uniq)
                            break;
                        sf[ind] -= 1;
                        if (tf[ind] > sf[ind]) {
                            cuniq -= 1;
                        }
                        st += 1;
                    }
                }
            }
            en += 1;
        }
        if (first == -1)
            return "";
        else
            return s.substring(first, last + 1);
    }
}
