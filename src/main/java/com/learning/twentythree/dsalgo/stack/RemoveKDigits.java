package com.learning.twentythree.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKdigits("1432219", 3));
        System.out.println(removeKDigits.removeKdigits("10200", 1));
        System.out.println(removeKDigits.removeKdigits("11", 2));
        System.out.println(removeKDigits.removeKdigits("112", 1));
        System.out.println(removeKDigits.removeKdigits("1234567890", 9));
    }

    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i < num.length()) {
            int currentNum = Character.getNumericValue(num.charAt(i++));
            while (k > 0 && !stack.isEmpty() && stack.peek() > currentNum) {
                stack.pop();
                k--;
            }
            stack.push(currentNum);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        boolean trailingZeroes = true;
        while (!stack.isEmpty()) {
            int ele = stack.pollLast();
            if(!trailingZeroes){
                result.append(ele);
            } else if(ele != 0){
                trailingZeroes = false;
                result.append(ele);
            }
        }
        return result.isEmpty() ? "0" : result.toString();
    }
}
