package com.learning.twentythree.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc"));
    }
    public String removeDuplicateLetters(String s) {
        boolean[] taken = new boolean[26];

        int[] lastOccurrence = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>(26);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(taken[c - 'a']){
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                char top = stack.pop();
                taken[top -'a'] = false;
            }
            stack.push(c);
            taken[c - 'a'] = true;
        }

        StringBuilder sb  = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
