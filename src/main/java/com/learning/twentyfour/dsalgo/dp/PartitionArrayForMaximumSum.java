package com.learning.twentyfour.dsalgo.dp;

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        System.out.println(maxSumAfterPartitioning(arr, 3));
//        int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
//        System.out.println(maxSumAfterPartitioning(arr, 4));
//        int[] arr = {1};
//        System.out.println(maxSumAfterPartitioning(arr, 1));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] memo = new int[arr.length];
        return maxSumAfterPartitioning(arr, k, 0, memo);
    }

    public static int maxSumAfterPartitioning(int[] arr, int k, int start, int[] memo) {
        if(start >= arr.length){
            return 0;
        }
        if(memo[start] > 0){
            return memo[start];
        }
        int max = 0;
        int maxInPartition = 0;
        for (int i = start; i < start + k && i < arr.length; i++) {
            maxInPartition = Math.max(maxInPartition, arr[i]);
            max = Math.max(max, maxInPartition*(i - start + 1) + maxSumAfterPartitioning(arr, k, i + 1, memo));
        }
        memo[start] = max;
        return max;
    }
}
