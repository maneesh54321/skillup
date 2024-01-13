package com.learning.twentythree.dsalgo.string;

public class BackSpaceStringCompare {

    public static void main(String[] args) {
        System.out.println(new BackSpaceStringCompare().backspaceCompare("ab#c", "ad#c"));
    }

    public boolean backspaceCompare(String s, String t) {
        StringBuilder sbs = new StringBuilder();
        StringBuilder sbt = new StringBuilder();

        int numOfDelete = 0;
        for(int i = s.length()-1; i >=0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                numOfDelete++;
            } else if(numOfDelete>0){
                numOfDelete--;
            } else {
                sbs.append(c);
            }
        }
        numOfDelete = 0;
        for(int i = t.length()-1; i >= 0; i--){
            char c = t.charAt(i);
            if (c == '#') {
                numOfDelete++;
            } else if(numOfDelete>0){
                numOfDelete--;
            } else {
                sbt.append(c);
            }
        }

        return sbs.toString().equals(sbt.toString());
    }
}
