package com.learning.twentythree.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {

    static class StockPrice {
        int day;
        int price;

        public StockPrice(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }

    Deque<StockPrice> stack;

    int currentDay = 0;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int result = 1;
        if (currentDay > 0) {
            while (!stack.isEmpty() && stack.peek().price <= price) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result = currentDay + 1;
            } else {
                result = currentDay - stack.peek().day;
            }
        }
        stack.push(new StockPrice(currentDay, price));
        currentDay++;
        return result;
    }
}
