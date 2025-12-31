package com.learning.twentysix.slidingwindow;

import java.util.ArrayDeque;

public class FruitsInBasket {

    public static void main(String[] args) {
        // int[] fruits = {2, 3, 2, 1, 3, 2, 1};

        int[] fruits = {0,1,2,2};

        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {

        var stack1 = new ArrayDeque<Integer>();
        var stack2 = new ArrayDeque<Integer>();

        stack1.push(fruits[0]);
        int maxFruits = 1;

        int left = 0;
        int right = 1;

        while (right < fruits.length) {
            int currFruit = fruits[right];

            if (stack1.isEmpty() || stack1.peek() == currFruit) {
                stack1.push(currFruit);
            } else if (stack2.isEmpty() || stack2.peek() == currFruit) {
                stack2.push(currFruit);
            } else {
                // start moving left pointer until one stack is empty
                while (!stack1.isEmpty() && !stack2.isEmpty()) {
                    var fruitToRemove = fruits[left];
                    if (stack1.peek() == fruitToRemove) {
                        stack1.pop();
                    } else {
                        stack2.pop();
                    }
                    left++;
                }
                if (stack1.isEmpty()) {
                    stack1.push(currFruit);
                } else {
                    stack2.push(currFruit);
                }
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }

        return maxFruits;
    }
}
