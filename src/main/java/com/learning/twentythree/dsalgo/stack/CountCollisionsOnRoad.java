package com.learning.twentythree.dsalgo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountCollisionsOnRoad {
    public static void main(String[] args) {
        CountCollisionsOnRoad countCollisionsOnRoad = new CountCollisionsOnRoad();
//        System.out.println(countCollisionsOnRoad.countCollisions("RLRSLL"));
//        System.out.println(countCollisionsOnRoad.countCollisions("LLRR"));
        System.out.println(countCollisionsOnRoad.countCollisions_1("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }

    public int countCollisions(String directions) {
        int result = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < directions.length(); i++) {
            char curr = directions.charAt(i);
            if (stack.isEmpty()) {
                stack.push(curr);
            } else {
                while (!stack.isEmpty()) {
                    char top = stack.peek();
                    if (top == 'R' && curr == 'S') {
                        result++;
                        stack.pop();
                    } else if (top == 'R' && curr == 'L') {
                        result += 2;
                        stack.pop();
                        curr = 'S';
                    } else if (top == 'S' && curr == 'L') {
                        result++;
                        stack.pop();
                        curr = 'S';
                    } else {
                        break;
                    }
                }
                stack.push(curr);
            }
        }
        return result;
    }

    public int countCollisions_1(String directions) {
        int result = 0;
        int j = 0;
        while (j < directions.length() && directions.charAt(j) == 'L') {
            j++;
        }
        int k = directions.length()-1;
        while (k >=0 && directions.charAt(k) == 'R') {
            k--;
        }
        for(int it = j;it<=k;it++){
            if(directions.charAt(it) != 'S'){
                result++;
            }
        }
        return result;
    }
}
