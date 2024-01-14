package com.learning.twentyfour.dsalgo.basic;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(36, 24));
    }

    public static int gcd(int x, int y){
        int remainder = x%y;
        while(remainder != 0) {
            y = remainder;
            remainder = x % y;
        }
        return y;
    }
}
