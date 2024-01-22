package com.learning.twentyfour.dsalgo.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubArrayMinimums {

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,4};
//        int[] arr = new int[]{11,81,94,43,3};
//        int[] arr = new int[]{71, 55, 82, 55};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int mod = 1000000007;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nextSmallerLeft = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Integer currNum = arr[i];
            if (!stack.isEmpty()) {
                Integer top = stack.peek();
                while (currNum < arr[top]) {
                    stack.pop();
                    if (stack.isEmpty())
                        break;
                    top = stack.peek();
                }
            }
            if (stack.isEmpty()) {
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        int[] nextSmallerRight = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            Integer currNum = arr[i];
            if (!stack.isEmpty()) {
                Integer top = stack.peek();
                while (currNum <= arr[top]) {
                    stack.pop();
                    if (stack.isEmpty())
                        break;
                    top = stack.peek();
                }
            }
            if (stack.isEmpty()) {
                nextSmallerRight[i] = arr.length;
            } else {
                nextSmallerRight[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int leftSmallerIndex = nextSmallerLeft[i];
            int rightSmallerIndex = nextSmallerRight[i];
            int count = ((i - leftSmallerIndex) * (rightSmallerIndex - i)) % mod;
            sum += (count * arr[i]) % mod;
            sum %= mod;
        }
        return sum;
    }
}
