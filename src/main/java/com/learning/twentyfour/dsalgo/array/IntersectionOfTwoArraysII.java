package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }
        int[] out = new int[2000];
        int j = 0;
        int[] tmp1 = new int[1000];
        for (int i = 0; i < nums1.length; i++) {
            tmp1[nums1[i]] += 1;
        }
        int[] tmp2 = new int[1000];
        for (int i = 0; i < nums2.length; i++) {
            tmp2[nums2[i]] += 1;
        }

        for (int i = 0; i < tmp1.length; i++) {
            if(tmp1[i] > 0 && tmp2[i] > 0){
                int total = Math.min(tmp1[i], tmp2[i]);
                while (total-- > 0){
                    out[j++] = i;
                }
            }
        }
        int[] result = new int[j];
        for (int i = 0; i < j; i++) {
            result[i] = out[i];
        }
        return result;
    }
}
