package com.learning.twentysix.slidingwindow;

import java.util.HashMap;

public class NonRepeatingSize3Substrings {
    public int countGoodSubstrings(String s) {
        if(s.length() < 3) return 0;
        int left = 0, right = 2 , count = 0;
        var map = new HashMap<Character, Integer>();
        for(int i = 0; i < 3; i++){
            var curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        if(map.size() == 3) count++;
        right++;
        while(right < s.length()) {
            var leftChar = s.charAt(left);
            map.put(leftChar, map.get(leftChar) - 1);
            if(map.get(leftChar) == 0) map.remove(leftChar);
            left++;
            var rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            if(map.size() == 3) count++;
            right++;
        }

        return count;
    }
}
