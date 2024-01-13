package com.learning.twentythree.dsalgo.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] answers = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int index = stack.pop();
                answers[index] = i-index;
            }
            stack.push(i);
        }

        return answers;
    }
}
