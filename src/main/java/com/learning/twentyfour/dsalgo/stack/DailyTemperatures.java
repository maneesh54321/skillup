package com.learning.twentyfour.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

	public static void main(String[] args) {
		int[] temperatures = {73,74,75,71,69,72,76,73};
		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		Deque<Integer> stack = new ArrayDeque<>();
		int[] result = new int[temperatures.length];
		for (int i = temperatures.length-1; i >= 0; i--) {
			int temperature = temperatures[i];
			while (stack.peek() != null && temperatures[stack.peek()] <= temperature){
				stack.pop();
			}
			if(stack.peek() == null){
				result[i] = 0;
			} else {
				result[i] = stack.peek() - i;
			}
			stack.push(i);
		}
		return result;
	}
}
