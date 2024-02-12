package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class IOUtils {
    public static void printArray(int[] inputArr){
        System.out.printf(Arrays.toString(inputArr));
    }

    public static void printArray(String[] inputArr){
        System.out.printf(Arrays.toString(inputArr));
    }

    public static void printArray(int[] inputArr, int k){
        for (int i = 0; i <= k; i++) {
            System.out.print(inputArr[i] + " ");
        }
        System.out.println();
    }
}
