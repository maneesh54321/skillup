package com.learning.twentythree.dsalgo.stack;

import com.learning.twentythree.dsalgo.Utils.IOUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

    public static void main(String[] args) {
        NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
        IOUtils.printIntArray(nextGreaterElementI.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length == 1) {
            return new int[]{-1};
        }
        Map<Integer, Integer> map =  new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        int[] answers = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            answers[i] = map.get(nums1[i]);
        }
        return answers;
    }
}
