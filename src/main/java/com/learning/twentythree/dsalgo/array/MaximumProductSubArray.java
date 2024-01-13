package com.learning.twentythree.dsalgo.array;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{ 6, -3, -10, 0, 2 }, 5));
    }

    // Function to find maximum product subarray
    static long maxProduct(int[] arr, int n) {
        long localMaxima = arr[0];
        long localMinima = arr[0];
        long result = localMaxima;
        for (int i = 1; i < n; i++) {
            if(arr[i]<0){
                long tmp = localMaxima;
                localMaxima = localMinima;
                localMinima = tmp;
            }
            localMaxima = Math.max(arr[i], arr[i] * localMaxima);
            localMinima = Math.min(arr[i], arr[i] * localMinima);

            result = Math.max(result, localMaxima);
        }
        return result;
    }
}
