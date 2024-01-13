package com.learning.twentythree.dsalgo.array;

public class MinInRotateSortedArray {
    public static void main(String[] args) {
//        System.out.println(findMin(new int[]{4 ,5 ,1 ,2 ,3}, 5));
//        System.out.println(findMin(new int[]{10, 20, 30, 40, 50, 5, 7}, 7));
//        System.out.println(findMin(new int[]{1, 2, 3, 4, 5, 6, 7}, 7));
        System.out.println(findMin(new int[]{335,359,383,392,422,437,448,465,468,479,492,501,539,605,668,704,706,717,719,725,727,772,812,828,870,895,896,903,913,943,962,963,996,36,146,154,170,282,293,300,323,334}, 42));
    }

    static int findMin(int[] arr, int n) {
        return binarySearch(arr, 0, n - 1);
    }

    private static int binarySearch(int[] arr, int low, int high) {

//        If there is only one element left OR low -> high is already sorted
        if(low == high || arr[low] < arr[high]){
            return arr[low];
        }

        int mid = low + (high-low)/2;
//        check if mid+1 is minimum element
        if (mid < high && arr[mid+1] < arr[mid]) {
            return arr[mid+1];
        }
//        check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return arr[mid];
        }

//        if mid -> r is sorted then go left else right.
        if(arr[mid] < arr[high]){
            return binarySearch(arr, low, mid);
        } else
            return binarySearch(arr, mid+1, high);
    }
}
