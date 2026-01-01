package com.learning.twentysix.leetcode.daily;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int remainder = 1;
        for(int i = digits.length-1; i>=0; i--) {
            int sum = digits[i] + remainder;
            digits[i] = sum % 10;
            remainder = sum/10;
        }
        if(remainder>0) {
            int[] res = new int[digits.length + 1];
            res[0] = remainder;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }
}