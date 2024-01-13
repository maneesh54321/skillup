package com.learning.twentythree.dsalgo.array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumZero {
    public static void main(String[] args) {
        System.out.println(findsum(new int[]{4, 2,-3, 1, 6}, 5));
    }

    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int cumulativeSum = 0;
        for (int i = 0; i < n; i++) {
            cumulativeSum += arr[i];
            if(cumulativeSum == 0){
                return true;
            }
            if(map.containsKey(cumulativeSum)){
                return true;
            } else {
                map.put(cumulativeSum, 1);
            }
        }
        return false;
    }
}
