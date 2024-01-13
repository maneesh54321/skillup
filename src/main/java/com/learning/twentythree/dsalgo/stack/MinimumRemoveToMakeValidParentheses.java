package com.learning.twentythree.dsalgo.stack;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses main = new MinimumRemoveToMakeValidParentheses();
        System.out.println(main.minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    public String minRemoveToMakeValid(String s) {
        char[] arr  = new char[s.length()];
        int oCount = 0;
        for(int i=0; i<arr.length; i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(oCount>0){
                    arr[i] = c;
                    oCount--;
                } else {
                    arr[i] = ' ';
                }
            } else {
                arr[i] = c;
                if(c == '('){
                    oCount++;
                }
            }
        }
        int i = arr.length-1;
        while(oCount > 0){
            if(arr[i] == '('){
                arr[i] = ' ';
                oCount--;
            }
            i--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
