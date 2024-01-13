package com.learning.twentythree.dsalgo.array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubsequence {
    public static void main(String[] args) {
        System.out.println(findLongestConseqSubseq(new int[]{2,6,1,9,4,5,3}, 7));
//        System.out.println(findLongestConseqSubseq(new int[]{1, 2, 3, 4, 5}, 5));
    }

    //Function to return length of longest subsequence of consecutive integers.
    static int findLongestConseqSubseq(int arr[], int N) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if(min>arr[i]){
                min = arr[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
            set.add(arr[i]);
        }
        int maxCount = 1;
        int currentCount = 1;
        for (int i = min+1; i <= max; i++) {
            if(set.contains(i)){
                currentCount++;
            } else {
                currentCount = 0;
            }
            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;
    }
}
