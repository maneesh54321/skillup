package com.learning.twentythree.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class NearestSmallerElement {
    public static void main(String[] args) {
        NearestSmallerElement main = new NearestSmallerElement();

//        System.out.println(main.prevSmaller(List.of(4, 5, 2, 10, 8)));
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < A.size(); i++) {
            Integer currentEle = A.get(i);
            while (!stack.isEmpty()) {
                if(stack.peek() > currentEle){
                    stack.pop();
                } else {
                    break;
                }
            }
            if(stack.isEmpty()) {
                A.set(i, -1);
            } else {
                A.set(i, stack.peek());
            }
            stack.push(currentEle);
        }

        return A;
    }
}
