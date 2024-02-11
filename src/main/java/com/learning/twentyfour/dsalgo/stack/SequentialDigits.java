package com.learning.twentyfour.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SequentialDigits {

	public static void main(String[] args) {
//		System.out.println(sequentialDigits(100, 300));
//		System.out.println(sequentialDigits(1000, 13000));
		System.out.println(sequentialDigits(10, 1000000000));
	}

	public static List<Integer> sequentialDigits(int low, int high) {
		int digitCountLow = countDigits(low);
		int digitCountHigh = countDigits(high);
		Deque<Integer> stack = new ArrayDeque<>();
		Deque<Integer> tempStack = new ArrayDeque<>();
		List<Integer> result = new ArrayList<>();
		if(digitCountLow == 1){
			result.add(0);
		}
		for (int i = digitCountLow; i <= digitCountHigh; i++) {
			int num = 0;
			for (int j = 9; j > 0; j--) {
				stack.push(j);
			}
			while(true) {
				int k = i;
				num = 0;
				int multiplier = 10;
				while (k > 0) {
					if (stack.isEmpty()) {
						num = Integer.MAX_VALUE;
						break;
					}
					int digit = stack.pop();
					num = num * multiplier + digit;
					tempStack.push(digit);
					k--;
				}
				while (!tempStack.isEmpty()) {
					stack.push(tempStack.pop());
				}
				if (num >= low && num <= high) {
					result.add(num);
				} else if (num > high) {
					break;
				}
				stack.pop();
			}
			stack.clear();
		}
		return result;
	}

	private static int countDigits(int num) {
		int count = 1;
		while (num / 10 != 0) {
			count++;
			num /= 10;
		}
		return count;
	}
}
