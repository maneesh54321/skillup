package com.learning.twentythree.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        SimplifyDirectoryPath simplifyDirectoryPath = new SimplifyDirectoryPath();
        System.out.println(simplifyDirectoryPath.simplifyPath("/home/"));
        System.out.println(simplifyDirectoryPath.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyDirectoryPath.simplifyPath("/../"));
    }

    public String simplifyPath(String A) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            switch (c) {
                case '/':
                    while (i + 1 < A.length()) {
                        if (A.charAt(i + 1) == '/') {
                            i++;
                        } else {
                            break;
                        }
                    }
                    break;
                case '.':
                    if ((i + 1) < A.length()) {
                        if (A.charAt(i + 1) == '.' && !stack.isEmpty()) {
                            stack.pop();
                            i++;
                        }
                    }
                    break;
                default:
                    StringBuilder directory = new StringBuilder();
                    directory.append(c);
                    while (i + 1 < A.length()) {
                        char next = A.charAt(i + 1);
                        if (next != '/') {
                            directory.append(next);
                            i++;
                        } else {
                            break;
                        }
                    }
                    stack.push(directory.toString());
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        Deque<String> stack2 = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!stack2.isEmpty()) {
            sb.append("/").append(stack2.pop());
        }
        return sb.toString();
    }
}
