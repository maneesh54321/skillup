package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        rotateArray(arr, 8);
//        int[] arr = new int[]{-1,-100,3,99};
//        rotateArray(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArray(int[] arr, int k){
        if(arr.length == 0 || k == 0)
            return;
        if(k > arr.length){
            k = k - arr.length;
        }
        int blockSize = findGCD(arr.length, k);
        for (int i = 1; i <= k / blockSize; i++) {
            int[] tmp = new int[blockSize];
            for (int j = 0; j < blockSize; j++) {
                tmp[j] = arr[j + arr.length - blockSize];
            }
            for (int j = 1; j < arr.length / blockSize; j++) {
                int blockStart = arr.length - j * blockSize;
                for (int l = blockStart; l < blockStart + blockSize; l++) {
                    arr[l] = arr[l-blockSize];
                }
            }
            for (int j = 0; j < blockSize; j++) {
                arr[j] = tmp[j];
            }
        }
    }

    public static int findGCD(int x, int y){
        int remainder = x%y;
        while(remainder != 0) {
            y = remainder;
            remainder = x % y;
        }
        return y;
    }
}
