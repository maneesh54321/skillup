package com.learning.twentyfour.dsalgo.array;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubstring {

  public static void main(String[] args) {
    String s = "abcabcbb";
//    String s = "pwwkew";
//    String s = "bbbbb";
    System.out.println(lengthOfLongestSubstring(s));
  }

  public static int lengthOfLongestSubstring(String s) {
    if(s == null || s.isEmpty()){
      return 0;
    }
    if(s.length() == 1){
      return 1;
    }
    Map<Character, Integer> map = new HashMap<>();
    int startIdx = 0;
    int maxLen = 0;
    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      if(map.containsKey(curr)){
        if(map.get(curr) < startIdx){
          map.put(curr, i);
        } else {
          startIdx = map.get(curr) + 1;
        }
      }
      map.put(curr, i);
      maxLen = Math.max(maxLen, i - startIdx + 1);
    }
    return maxLen;
  }
}
