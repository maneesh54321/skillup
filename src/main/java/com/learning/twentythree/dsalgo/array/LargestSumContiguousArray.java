package com.learning.twentythree.dsalgo.array;

public class LargestSumContiguousArray {
    public static void main(String[] args) {
//        System.out.println(maxSubarraySum(new int[]{1,2,3,-2,5}, 5));
        System.out.println(maxSubarraySum(new int[]{-47,43,94,-94,-93,-59,31,-86}, 8));
    }

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.

//    KADANE Algorithm
    static long maxSubarraySum(int arr[], int n){

        int currSum = arr[0];
        int currMaxSum = currSum;
        for (int i = 1; i <n; i++) {
            if(currSum<0){
                currSum = arr[i];
            } else {
                currSum += arr[i];
            }
            if(currSum > currMaxSum){
                currMaxSum = currSum;
            }
        }
        return currMaxSum;

    }
}
