package com.learning.twentythree.dsalgo.stack;

public class ParenthesesStringCanBeValid {

    public static void main(String[] args) {
//        ParenthesesStringCanBeValid main = new ParenthesesStringCanBeValid();
//        System.out.println(main.canBeValid("))()))", "010100"));
//        System.out.println(main.canBeValid("((()(()()))()((()()))))()((()(()","10111100100101001110100010001001"));
        "Maneesh Singh".chars().mapToObj(String::valueOf).forEach(System.out::println);

//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println((char)bytes[i]);
//        }
//        Stream.of(bytes).forEach(System.out::print);
    }

    public boolean canBeValid(String s, String locked) {
        if (s == null || s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }
        int scb = 0, fb = 0, sob = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char lock = locked.charAt(i);
            if(lock == '0'){
                fb++;
            } else if(c == '('){
                sob++;
            } else {
                scb++;
            }
            if(scb > sob+fb){
                return false;
            }
        }

        scb = 0;
        sob = 0;
        fb = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            char lock = locked.charAt(i);
            if(lock == '0'){
                fb++;
            } else if(c == '('){
                sob++;
            } else {
                scb++;
            }
            if(sob > scb+fb){
                return false;
            }
        }

        return true;
    }
}
