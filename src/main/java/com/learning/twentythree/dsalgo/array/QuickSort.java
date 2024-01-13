package com.learning.twentythree.dsalgo.array;

import com.learning.twentythree.dsalgo.Utils.IOUtils;

public class QuickSort {
    public static void main(String[] args) {
        int[] inputArr = new int[]{6,9,3,2,5,7,8,1,4};
        quickSort(inputArr, 0, 8);
        IOUtils.printIntArray(inputArr);
    }

    //Function to sort an array using quick sort algorithm.
    public static void quickSort(int[] arr, int low, int high)
    {
        if(low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high)
    {
        // your code here
        int pivot = arr[high];
        int l = low;
        int r = high-1;
        boolean lStuck = false, rStuck = false;
        while(true) {
            if (!lStuck) {
                if (arr[l] >= pivot || l >= high) {
                    lStuck = true;
                } else {
                    l++;
                }
            } else if (!rStuck) {
                if (arr[r] <= pivot || r <= l) {
                    rStuck = true;
                } else {
                    r--;
                }
            } else {
                if(l==r){
                    swap(arr, l, high);
                    return l;
                } else if(l<r){
                    swap(arr, l, r);
                }
                if (l > r) {
                    return high;
                } else {
                    lStuck = false;
                    rStuck = false;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
