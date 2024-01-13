package com.learning.twentythree.dsalgo.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpan {

    public int[] stockSpan(int[] stockPrices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answers = new int[stockPrices.length];
        stack.push(0);
        answers[0] = 1;
        for (int i = 1; i < stockPrices.length; i++) {
            while (!stack.isEmpty() && stockPrices[stack.peek()] <= stockPrices[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answers[i] = i + 1;
            } else {
                answers[i] = i - stack.peek();
            }
            stack.push(i);
        }

        return answers;
    }
}
