package com.learning.twentythree.dsalgo.string;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        byte[] sb = s.getBytes();
        int n = sb.length;
        int maxLen = Integer.MIN_VALUE;
        int left = -1;
        int right = -1;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            boolean hasOddPalindrome = true;
            boolean hasEvenPalindrome = true;
            while (l >= 0 && r < n && (hasEvenPalindrome || hasOddPalindrome)) {
                if(hasEvenPalindrome){
                    if(r+1 < n && sb[l] == sb[r+1]){
                        if((r-l+2) > maxLen){
                            left = l;
                            right = r+1;
                            maxLen = r-l+2;
                        }
                    } else {
                        hasEvenPalindrome = false;
                    }
                }
                if(hasOddPalindrome){
                    if(sb[l] == sb[r]){
                        if((r-l+1) > maxLen){
                            left = l;
                            right = r;
                            maxLen = r-l+1;
                        }
                    } else {
                        hasOddPalindrome = false;
                    }
                }
                l--;
                r++;
            }
        }
        return s.substring(left, right+1);
    }

}
