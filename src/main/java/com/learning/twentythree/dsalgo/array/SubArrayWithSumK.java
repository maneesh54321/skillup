package com.learning.twentythree.dsalgo.array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumK {
    public static void main(String[] args) {
        System.out.println(findSubArraySum(new int[]{10 , 2, -2, -20, 10}, 5, -10));
        System.out.println(findSubArraySum(new int[]{9, 4, 20, 3, 10, 5}, 5, 33));
    }

    static int findSubArraySum(int arr[], int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cumulativeSum = 0;
        int count = 0;
        map.put(0,1);
        for (int i = 0; i <n; i++) {
            cumulativeSum += arr[i];
            count += map.getOrDefault(cumulativeSum-k, 0);
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }
        return count;
    }
}
