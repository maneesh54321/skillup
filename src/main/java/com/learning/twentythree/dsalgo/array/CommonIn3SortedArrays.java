package com.learning.twentythree.dsalgo.array;

public class CommonIn3SortedArrays {

    public static void main(String[] args) {

    }

//    public static ArrayList<Integer> findCommonInArrays(int[] A, int[] B, int[] C, int n1, int n2, int n3){
////        int
//    }

    static int findMax(int[] A, int[] B, int[] C, int a, int b, int c, boolean amax, boolean bmax, boolean cmax){
        int maxIndex = -1;
        if(A[a] > B[b]){
            if(A[a] > C[c]){
                maxIndex = a;
                amax = true;
            }else {
                maxIndex = c;
            }
        } else {
            if(B[b] > C[c]){
                maxIndex = b;
            } else {
                maxIndex = c;
            }
        }
        if(A[maxIndex]<A[c]){
            maxIndex = c;
        }

        return maxIndex;
    }

    static boolean areEqual(int a, int b, int c){
        return a == b && b == c;
    }
}
