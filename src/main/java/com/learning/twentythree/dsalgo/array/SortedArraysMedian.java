package com.learning.twentythree.dsalgo.array;

import java.util.PriorityQueue;

public class SortedArraysMedian {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> prq = new PriorityQueue<>();
        for(int i=0; i<nums1.length; i++){
            prq.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            prq.add(nums2[i]);
        }

        int medianIndex = (nums1.length+nums2.length)/2;
        if (!((nums1.length+nums2.length)%2 == 0)){
            medianIndex++;
        }
        for(int i=1; i<medianIndex; i++){
            prq.remove();
        }
        if ((nums1.length+nums2.length)%2 == 0){
            return ((double)prq.remove()+(double) prq.remove())/2;
        } else {
            return prq.remove();
        }
    }
}
