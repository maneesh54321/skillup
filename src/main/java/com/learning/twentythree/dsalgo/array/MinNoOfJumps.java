package com.learning.twentythree.dsalgo.array;

public class MinNoOfJumps {
    public static void main(String[] args) {
//        System.out.println(minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
//        System.out.println(minJumps(new int[]{1, 4, 3, 2, 6, 7}));
        System.out.println(minJumps(new int[]{1, 2, 0, 0, 0}));
    }

    static int minJumps(int[] arr){
        int currMaxJump = arr[0], currMax = 0, jumps = 0;
        if(currMaxJump == 0){
            if(arr.length>1){
                return -1;
            }
            return 0;
        }
        for (int i = 1; i < arr.length; i++) {
            currMaxJump--;
            currMax--;
            if(currMaxJump < 0){
                currMaxJump = currMax;
                jumps++;
                currMax = 0;
            } else {
                currMax = Math.max(currMax, arr[i]);
                if(currMaxJump == 0 && arr[i] == 0 && currMax == 0){
                    return -1;
                }
            }
        }
        if(currMax > 0){
            jumps++;
        }
        return jumps;
    }
}
