package com.learning.twentythree.dsalgo.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack1 = new MinStack();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        minStack1.getMin();
        minStack1.pop();
        minStack1.top();
        minStack1.getMin();
    }

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
    }

    public void push(int x) {
        this.stack.push(x);
        if(minStack.isEmpty()){
            this.minStack.push(x);
        } else {
            this.minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        } else {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        } else {
            return stack.peek();
        }
    }

    public int getMin() {
        if(minStack.isEmpty()){
            return -1;
        } else {
            return minStack.peek();
        }
    }
}
