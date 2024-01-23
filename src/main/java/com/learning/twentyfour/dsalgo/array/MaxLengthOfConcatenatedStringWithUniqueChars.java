package com.learning.twentyfour.dsalgo.array;

import java.util.List;

public class MaxLengthOfConcatenatedStringWithUniqueChars {
    public static void main(String[] args) {
        List<String> input = List.of("un", "iq", "ue");
        System.out.println(maxLength(input, 0, ""));
//        int x = 0x00000000000000000000000001 << ('y' - 'a');
//        int y = 0x00000000000000000000000001 << ('x' - 'a');
//        System.out.println(x & y);
    }

    public static int maxLength(List<String> arr, int start, String currString) {
        if (start >= arr.size()) {
            return 0;
        }
        boolean includeCurrent = true;
        int x = 0;
        for (int i = 0; i < currString.length(); i++) {
            x |= (0x00000000000000000000000001 << (currString.charAt(i) - 'a'));
        }
        String curr = arr.get(start);
        for (int i = 0; i < curr.length(); i++) {
            if ((x | (0x00000000000000000000000001 << (curr.charAt(i) - 'a'))) == x) {
                includeCurrent = false;
                break;
            }
        }
        if (includeCurrent) {
            return Math.max(curr.length() + maxLength(arr, start + 1, currString + curr), maxLength(arr, start + 1, currString));
        } else {
            return maxLength(arr, start + 1, currString);
        }
    }
}
