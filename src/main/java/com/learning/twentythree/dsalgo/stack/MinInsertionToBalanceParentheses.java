package com.learning.twentythree.dsalgo.stack;

public class MinInsertionToBalanceParentheses {

    public static void main(String[] args) {
        MinInsertionToBalanceParentheses main = new MinInsertionToBalanceParentheses();

//        System.out.println(main.minInsertions("(()))"));
//        System.out.println(main.minInsertions("())"));
//        System.out.println(main.minInsertions("))())("));
        System.out.println(main.minInsertions("()()()()()("));
    }

    public int minInsertions(String s) {
        int oCount = 0, cCount = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                if(cCount > 0){
                    if(oCount == 0){
                        result +=2;
                    } else if (oCount > 0) {
                        result++;
                        oCount--;
                    }
                    cCount = 0;
                }
                oCount++;
            } else {
                cCount++;
                if(cCount == 2){
                    if(oCount > 0){
                        oCount--;
                    } else {
                        result++;
                    }
                    cCount = 0;
                }
            }
        }

        if(cCount > 0){
            if(oCount > 0){
                oCount--;
                result++;
            } else {
                result += 2;
            }
        }

        return result + 2*oCount;
    }
}
