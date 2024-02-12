package com.learning.twentyfour.dsalgo.dp;

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
//        int[] arr = {1,15,7,9,2,5,10};
//        System.out.println(maxSumAfterPartitioning(arr, 3));
//        System.out.println(maxSumAfterPartitioningIterative(arr, 3));
        int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
        System.out.println(maxSumAfterPartitioning(arr, 4));
        System.out.println(maxSumAfterPartitioningIterative(arr, 4));
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

    public static int maxSumAfterPartitioningIterative(int[] arr, int k){
        int[] memo = new int[arr.length+1];
        memo[arr.length] = 0;
        for (int i = arr.length-1; i >= 0 ; i--) {
            int max = 0;
            int partitionMax = arr[i];
            for (int j = i; j < i + k && j < arr.length; j++) {
                partitionMax = Math.max(partitionMax, arr[j]);
                max = Math.max(max, (j-i + 1) * partitionMax + memo[j+1]);
            }
            memo[i] = max;
        }
        return memo[0];
    }
}
