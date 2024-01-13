package com.learning.twentythree.dsalgo.stack;

public class ReverseSubstringBWEachParenthesis {
    public static void main(String[] args) {
//        System.out.println(reverseParentheses("(abcd)"));
//        System.out.println(reverseParentheses("(u(love)i)"));
        "Maneesh Singh".chars().forEach(System.out::println);
    }

    public static String reverseParentheses(String s) {
        return reverseParentheses(s, 0).toString();
    }

    public static StringBuilder reverseParentheses(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = k; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                StringBuilder result = reverseParentheses(s, i+1);
                sb.append(result);
                i += result.length()+1;
            } else if(s.charAt(i) == ')'){
                break;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.reverse();
    }
}
