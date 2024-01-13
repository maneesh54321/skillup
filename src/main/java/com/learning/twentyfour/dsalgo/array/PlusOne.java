package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
//        int[] digits = new int[]{1,2,3};
//        int[] digits = new int[]{4,3,2,1};
        int[] digits = new int[]{9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    private static int[] plusOne(int[] digits) {
        int carryOver = 1;
        for (int i = digits.length-1; i>=0; i--) {
            int sum = digits[i] + carryOver;
            digits[i] = sum % 10;
            carryOver = sum/10;
            if(carryOver == 0){
                return digits;
            }
        }
        if(carryOver > 0){
            int[] result = new int[digits.length+1];
            for (int i = 0; i < digits.length; i++) {
                result[i+1] = digits[i];
            }
            result[0] = carryOver;
            return result;
        }
        return new int[0];
    }
}
