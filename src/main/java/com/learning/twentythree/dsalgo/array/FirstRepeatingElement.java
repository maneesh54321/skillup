package com.learning.twentythree.dsalgo.array;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {

    public static void main(String[] args) {
        System.out.println(firstRepeated(new int[]{1, 5, 3, 4, 3, 5, 6}, 7));
    }

    public static int firstRepeated(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for (int i = 0; i < n; i++) {
            if(map.get(arr[i])>1){
                return i+1;
            }
        }
        return -1;
    }
}
