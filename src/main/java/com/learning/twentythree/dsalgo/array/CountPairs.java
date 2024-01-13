package com.learning.twentythree.dsalgo.array;

import java.util.HashMap;
import java.util.Map;

public class CountPairs {
    public static void main(String[] args) {
        System.out.println(getPairsCount(new int[]{1, 5, 7, 1}, 4, 6));
    }

    static int getPairsCount(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += map.getOrDefault(k-arr[i], 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        return count;
    }
}
