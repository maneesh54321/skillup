package com.learning.twentythree.dsalgo.stack;

public class RemoveAllAdjacentDuplicates {

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            int lastIndex = sb.length()-1;
            if(!sb.isEmpty() && sb.charAt(lastIndex) == s.charAt(i)){
                sb.deleteCharAt(lastIndex);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
