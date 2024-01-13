package com.learning.twentythree.dsalgo.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ClumsyFactorial {
    public static void main(String[] args) {
        ClumsyFactorial clumsyFactorial = new ClumsyFactorial();
//        System.out.println(clumsyFactorial.clumsy(10));
        System.out.println(clumsyFactorial.clumsy(4));
    }

    public int clumsy(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            if (j % 4 == 0) {
                stack.push(i);
                j++;
            } else if (j % 4 == 1) {
                stack.push(stack.pop()*i);
                j++;
            } else if (j % 4 == 2) {
                list.add(stack.pop()/i);
                j++;
            } else if (j % 4 == 3) {
                list.add(i);
                j++;
            }
        }

        if(!stack.isEmpty()){
            list.add(stack.pop());
        }

        int result = list.get(0);
        for (int i = 1; i <list.size(); i++) {
            if(i%2==0){
                result = result - list.get(i);
            } else {
                result += list.get(i);
            }
        }

        return result;
    }
}
