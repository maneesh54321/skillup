package com.learning.twentythree.dsalgo.array;

import java.util.Arrays;

public class TripletSumInArray {
    public static void main(String[] args) {
        System.out.println(find3Numbers(new int[]{1, 4, 45, 6, 10, 8}, 6, 13));
    }

    //Function to find if there exists a triplet in the
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) {

        Arrays.sort(A);

        for (int i = n-1; i >= 2; i--) {
            int r = i-1;
            int l = 0;
            int requiredSum = X - A[i];
            while(l<r){
                if(A[l] + A[r] == requiredSum){
                    return true;
                } else if (A[l] + A[r] > requiredSum) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return false;

    }
}
