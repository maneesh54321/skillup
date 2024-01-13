package com.learning.twentythree.dsalgo.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxDepthParentheses {

    public int maxDepth(String s) {
        Deque<Character> stack = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                stack.push(c);
                result = Math.max(stack.size(), result);
            } else if(c == ')') {
                if(stack.isEmpty()){
                    return 0;
                } else {
                    stack.pop();
                }
            }
        }

        return result;
    }
}
