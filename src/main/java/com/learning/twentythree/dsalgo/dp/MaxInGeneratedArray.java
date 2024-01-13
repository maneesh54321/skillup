package com.learning.twentythree.dsalgo.dp;

public class MaxInGeneratedArray {

    public static void main(String[] args) {
        MaxInGeneratedArray main = new MaxInGeneratedArray();
        System.out.println(main.generateArr(7));
    }

    public int generateArr(int n){
        int[] memo = new int[n+1];
        int max = Integer.MIN_VALUE;
        for (int j = 0; j <= n; j++) {
            if(j==0 || j==1){
                memo[j] = j;
            } else {
                if(j%2 == 0){
                    memo[j] = memo[j/2]; // memoized value
                } else {
                    memo[j] = memo[j/2]+ memo[j/2+1]; //memoized values
                }
            }
            max = Math.max(max, memo[j]);
        }

        return max;
    }
}
