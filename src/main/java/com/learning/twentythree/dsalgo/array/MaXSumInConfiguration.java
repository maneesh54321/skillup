package com.learning.twentythree.dsalgo.array;

public class MaXSumInConfiguration {
    public static void main(String[] args) {
        System.out.println(max_sum(new int[]{8,3,1,2}, 4));
    }

    static int max_sum(int arr[], int n) {
        int cumulativeSum = 0;
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            cumulativeSum += arr[i];
            currentSum += arr[i]*i;
        }

        int maxSum = currentSum;

        for (int i = 0; i < n; i++) {
            currentSum = (currentSum - (cumulativeSum - arr[i])) + arr[i]*(n-1);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
