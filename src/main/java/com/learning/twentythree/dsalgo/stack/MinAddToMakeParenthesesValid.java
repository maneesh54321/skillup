package com.learning.twentythree.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinAddToMakeParenthesesValid {
    public static void main(String[] args) {
        MinAddToMakeParenthesesValid main = new MinAddToMakeParenthesesValid();
        System.out.println(main.minAddToMakeValid("()))(("));
        System.out.println(main.minAddToMakeValid_stack("()))(("));
    }

    public int minAddToMakeValid(String s) {
        int result = 0;
        int oCount = 0;
        int cCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                oCount++;
            } else {
                if (oCount > 0)
                    oCount--;
                else
                    result++;
            }
        }
        return result+oCount;
    }

    public int minAddToMakeValid_stack(String s) {
        int result = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty())
                    result++;
                else
                    stack.pop();
            }
        }
        return result+stack.size();
    }
}
