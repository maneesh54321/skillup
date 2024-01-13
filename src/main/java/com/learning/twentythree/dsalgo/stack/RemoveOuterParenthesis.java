package com.learning.twentythree.dsalgo.stack;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveOuterParenthesis {

    public String removeOuterParentheses(String s) {
        Deque<Character> stack = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                stack.push('(');
                sb.append('(');
            } else {
                if(stack.size()>1)
                    sb.append(s.charAt(i));
                stack.pop();
            }
        }

        return sb.toString();
    }

    public String removeOuterParentheses1(String s) {
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            if(count == 0){
                count++;
            } else if (s.charAt(i) == '(') {
                count++;
                sb.append('(');
            } else {
                if(count>1)
                    sb.append(s.charAt(i));
                count--;
            }
        }

        return sb.toString();
    }
}
