package com.learning.twentythree.dsalgo.array;

import com.learning.twentythree.dsalgo.Utils.IOUtils;

public class KthSmallest {
    public static void main(String[] args) {
//        printKthSmallest(new int[]{8, 3, 5, 7, 6, 1, 4, 2}, 7, 8);
        printKthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3, 6);
    }

    static void printKthSmallest(int[] inputArr, int k, int n){
        kthSmallest(inputArr, 0, n-1, k);
        System.out.println(inputArr[k-1]);
    }

    static void kthSmallest(int[] inputArr, int start, int end, int k){
        int pivot = inputArr[end];
        int pivotIndex = partition(inputArr, start, end, pivot);
        if(k-1 > pivotIndex){
            kthSmallest(inputArr, pivotIndex+1, end, k);
        } else if(k-1 < pivotIndex){
            kthSmallest(inputArr, start, pivotIndex-1, k);
        }
    }

    static int partition(int[] inputArr, int start, int end, int pivot){
        int j = start;
        for (int i = start; i <= end; i++) {
            if(inputArr[i] <= pivot){
                IOUtils.swap(i, j, inputArr);
                j++;
            }
        }
        return j-1;
    }


}
