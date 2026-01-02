package com.learning.twentysix.slidingwindow;

import java.util.HashSet;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 1 || k == 0) return false;
        if (k >= nums.length) k = nums.length - 1;
        var freqMap = new HashSet<Integer>();
        int left = 0;
        int right = k;
        for (int i=left; i <= right; i++) {
            if(!freqMap.add(nums[i])) return true;
        }
        right++;
        while(right < nums.length){
            freqMap.remove(nums[left]);
            left++;
            if(!freqMap.add(nums[right])) return true;
            right++;
        }
        return false;
    }
}
