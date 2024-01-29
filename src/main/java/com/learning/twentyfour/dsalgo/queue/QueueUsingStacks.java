package com.learning.twentyfour.dsalgo.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStacks {
	Deque<Integer> stack1;
	Deque<Integer> stack2;

	public QueueUsingStacks() {
		this.stack1 = new ArrayDeque<>();
		this.stack2 = new ArrayDeque<>();
	}

	public void push(int x) {
		stack1.push(x);
	}

	public int pop() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		Integer result = stack2.pop();
		while (!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		return result;
	}

	public int peek() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		Integer result = stack2.peek();
		while (!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		return result;
	}

	public boolean empty() {
		return stack1.isEmpty();
	}
}
