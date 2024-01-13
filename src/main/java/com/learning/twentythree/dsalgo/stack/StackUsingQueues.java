package com.learning.twentythree.dsalgo.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingQueues {

    Deque<Integer> queue;

    public StackUsingQueues() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        if(!queue.isEmpty()){
            int lengthToMove = queue.size()-1;
            while (lengthToMove>0){
                lengthToMove--;
                queue.offer(queue.remove());
            }
            return queue.remove();
        }
        return -1;
    }

    public int top() {
        if(!queue.isEmpty()){
            int lengthToMove = queue.size()-1;
            while (lengthToMove>0){
                lengthToMove--;
                queue.offer(queue.remove());
            }
            int result = queue.remove();
            queue.offer(result);
            return result;
        }
        return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
