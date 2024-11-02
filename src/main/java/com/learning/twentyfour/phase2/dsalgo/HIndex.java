package com.learning.twentyfour.phase2.dsalgo;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
//        int[] citations = {1,3,1};

        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= i+1) {
                return i+1;
            }
        }
        return 0;
    }
}
