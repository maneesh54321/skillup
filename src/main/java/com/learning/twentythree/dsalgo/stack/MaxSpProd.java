package com.learning.twentythree.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Objects;

public class MaxSpProd {
    public static void main(String[] args) {

    }

    public int maxSpecialProduct(ArrayList<Integer> A) {
        Deque<Integer> decStack = new ArrayDeque<>();
        long max = 0;
        for (int i = 0; i < A.size(); i++) {
            while (!decStack.isEmpty() && A.get(decStack.peek()) < A.get(i)) {
                int pop = decStack.pop();
                long num2;
                while(!decStack.isEmpty() && Objects.equals(A.get(pop), A.get(decStack.peek()))){
                    decStack.pop();
                }
                if(decStack.isEmpty()){
                    num2 = 0;
                } else {
                    num2 = decStack.peek();
                }
                max = Math.max(max, (i*num2));
            }
            decStack.push(i);
        }
        return (int)(max%1000000007);
    }
}
