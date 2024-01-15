package com.learning.twentyfour.dsalgo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,0,0,0};
        int[] nums = {1,-1,-1,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int prevFixedNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int fixedNum = nums[i];
            if(fixedNum == prevFixedNum){
                continue;
            }
            if(fixedNum > 0){
                break;
            }
            int reqSum = -fixedNum;
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y) {
                int a = nums[x];
                int b = nums[y];
                if (a+b < reqSum) {
                    x++;
                } else if( a+b > reqSum){
                    y--;
                } else {
                    List<Integer> grp = List.of(fixedNum, a, b);
                    result.add(grp);
                    while (x < y && nums[++x] == a){

                    }
                    while (x < y && nums[--y] == b){

                    }
                }
            }
            prevFixedNum = fixedNum;
        }
        return result;
    }
}
