package com.learning.twentythree.dsalgo.stack;

import java.util.Deque;
import java.util.LinkedList;

public class RedundantBraces {

    public static void main(String[] args) {
        RedundantBraces main = new RedundantBraces();
//        System.out.println(main.braces("((a+b))"));
//        System.out.println(main.braces("(a+(a+b))"));
        System.out.println(main.braces("((h-(c-(h-(z-(v-(f-(r-(k-(m-(l-(n-(o-(z-(j-(k))))))))))))))))"));
    }

    public int braces(String A) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            switch (c) {
                case ')':
                    char top = stack.peek();
                    if (top == '(') {
                        return 1;
                    } else {
                        while (stack.peek()!='('){
                            stack.pop();
                        }
                        stack.pop();
                    }
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                    stack.push(c);
                    break;
                default:
                    continue;

            }
        }
        return 0;
    }
}
