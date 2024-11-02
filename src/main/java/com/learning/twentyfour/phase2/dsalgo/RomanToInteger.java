package com.learning.twentyfour.phase2.dsalgo;

import java.util.ArrayDeque;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
//		var s = "LVIII";
		var s = "MCMXCIV";

		System.out.println(romanToInt(s));
	}

	public static int romanToInt(String s) {

		var map = Map.of(
				'I', 1,
				'V', 5,
				'X', 10,
				'L', 50,
				'C', 100,
				'D', 500,
				'M', 1000
		);

		var stack = new ArrayDeque<Character>();

		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}

		int sum = 0;

		while (!stack.isEmpty()) {
			var c1 = stack.pop();
			var curr = map.get(c1);
			if(!stack.isEmpty()) {
				var c2 = stack.peek();
				var nextVal = map.get(c2);
				if( nextVal < curr) {
					curr -= nextVal;
					stack.pop();
				}
			}
			sum += curr;
		}

		return sum;
	}

}
