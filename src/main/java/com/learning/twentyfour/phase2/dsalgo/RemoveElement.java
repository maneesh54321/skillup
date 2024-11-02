package com.learning.twentyfour.phase2.dsalgo;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;

        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 1) {
            if(nums[0] == val) return 0;
            return 1;
        }
        int i = 0, index = 0;
        while (i < nums.length) {
            if(nums[i] != val) {
                nums[index++] = nums[i];
            }
            i++;
        }
        return index;
    }
}
