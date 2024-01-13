package com.learning.twentythree.dsalgo.array;

import com.learning.twentythree.dsalgo.Utils.IOUtils;

public class MergeSort {

    public static void main(String[] args) {
        int[] inputArr = new int[]{1, 5, 3, 2};
        mergeSortArr(inputArr, 0, inputArr.length-1);

        IOUtils.printIntArray(inputArr);
    }

    public static void mergeSortArr(int[] arr, int start, int end){
        if(end-start > 0) {
            int midIndex = start + (end-start)/2;
            mergeSortArr(arr, start, midIndex);
            mergeSortArr(arr, midIndex+1, end);
            merge(arr, start, midIndex, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {

        int[] leftArr = new int[(mid-start) + 1];
        int[] rightArr = new int[end-mid];

        for (int i = start, j=0; i <= mid; i++, j++) {
            leftArr[j] = arr[i];
        }

        for (int i = mid+1, j=0; i <= end; i++, j++) {
            rightArr[j] = arr[i];
        }

        int al = leftArr.length, a = 0;
        int bl = rightArr.length, b = 0;
        int i = start;
        while(a < al && b < bl){
            if(leftArr[a] <= rightArr [b]){
                arr[i] = leftArr[a];
                a++;
            } else {
                arr[i] = rightArr[b];
                b++;
            }
            i++;
        }
        if(a==al) {
            while (b < bl) {
                arr[i] = rightArr[b];
                b++;
                i++;
            }
        } else {
            while (a < al) {
                arr[i] = leftArr[a];
                a++;
                i++;
            }
        }
    }
}
