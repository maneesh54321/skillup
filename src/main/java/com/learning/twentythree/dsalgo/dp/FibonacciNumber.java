package com.learning.twentythree.dsalgo.dp;

public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber main = new FibonacciNumber();

        System.out.println(main.fib(5));
    }

    public int fib(int n) {
        int[] memo = new int[n+1];
        for (int i = 1; i < memo.length; i++) {
            memo[i] = -1;
        }
        return fibonacci(n, memo);
    }

    public int fibonacci(int n, int[] memo){
        if(memo[n] != -1){
            System.out.println("Returning memoized value!!!");
            return memo[n];
        }
        System.out.println("Calculating value!!!");
        int result;
        if(n==1 || n == 2){
            result = 1;
        } else {
            result =  fibonacci(n-1, memo) + fibonacci(n-2, memo);
        }
        memo[n] = result;
        return result;
    }
}
