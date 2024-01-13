package com.learning.twentythree.dsalgo.array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithEqualZeroAndOne {
    public static void main(String[] args) {
        System.out.println(countSubarrWithEqualZeroAndOne(new int[]{1,0,0,1,0,1,1}, 7));
        System.out.println(countSubarrWithEqualZeroAndOne_1(new int[]{1,0,0,1,0,1,1}, 7));
    }

    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        int cumulativeSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cumulativeSum += (arr[i] == 0) ? -1 : 1;
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1){
                count += (entry.getValue() * (entry.getValue()-1))/2;
            }
        }

        count += map.getOrDefault(0, 0);
        return count;
    }

    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne_1(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int cumulativeSum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            cumulativeSum += (arr[i] == 0) ? -1 : 1;
            count += map.getOrDefault(cumulativeSum, 0);
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }
        return count;
    }
}
