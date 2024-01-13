package com.learning.twentythree.dsalgo.queue;


import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingStacks {

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.push(1);
        queue.pop();
    }

    Deque<Integer> enqueueStack;

    Deque<Integer> dequeueStack;

    public QueueUsingStacks() {
        enqueueStack = new LinkedList<>();
        dequeueStack = new LinkedList<>();
    }

    public void push(int x) {
        enqueueStack.push(x);
    }

    public int pop() {
        peek();
        return dequeueStack.pop();
    }

    public int peek() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek();
    }

    public boolean empty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
}

