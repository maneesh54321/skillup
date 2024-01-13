package com.learning.twentythree.dsalgo.array;

import java.util.Arrays;

public class MinimizeTheHeights {
    public static void main(String[] args) {
//        System.out.println(getMinDiff(new int[]{1, 5, 8, 10}, 4, 2));
//        System.out.println(getMinDiff(new int[]{3, 9, 12, 16, 20}, 5, 3));
        System.out.println(getMinDiff(new int[]{2,6,3,4,7,2,10,3,2,1}, 10, 5));
    }

    static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int max_diff_allowed = arr[n-1] - arr[0];
        int i=0, j= n-1;
        int min_height = Integer.MAX_VALUE;
        int max_height = Integer.MIN_VALUE;
        while(i<j){
            min_height = Math.min(Math.min(arr[i]+k, arr[j]-k), min_height);
            max_height = Math.max(Math.max(arr[i]+k, arr[j]-k), max_height);
            i++;
            j--;
        }
        if(i==j){
            int ifInc_max_height = Math.max(arr[i]+k, max_height);
            int ifDec_min_height = Math.min(arr[i]-k, min_height);

            if(min_height> ifDec_min_height && max_height < ifInc_max_height){
                if((min_height - ifDec_min_height) > (ifInc_max_height - max_height)){
                    max_height = ifInc_max_height;
                } else {
                    min_height = ifDec_min_height;
                }
            }
        }
        return Math.min((max_height - min_height), max_diff_allowed);
    }
}
