package com.learning.twentysix.slidingwindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        var s = "AAACBBBAABAB";
        System.out.println(longestRepeatingCharacterReplacement(s, 2));
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {

        if (s.length() <= 1) {
            return s.length();
        }

        var freqMap = new HashMap<Character, Integer>();

        int maxFreqChar = 1;
        freqMap.put(s.charAt(0), 1);

        int maxWindowSize = 1;

        int left = 0;
        int right = 1;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            maxFreqChar = Math.max(maxFreqChar, freqMap.get(rightChar));
            if (right - left + 1 - maxFreqChar > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }
            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
            right++;
        }

        return maxWindowSize;
    }
}
