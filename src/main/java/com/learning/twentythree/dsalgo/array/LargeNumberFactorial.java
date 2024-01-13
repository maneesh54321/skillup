package com.learning.twentythree.dsalgo.array;

import java.util.ArrayList;

public class LargeNumberFactorial {
    public static void main(String[] args) {
        ArrayList<Integer> list = factorial(50);
        list.forEach(System.out::print);
    }

    static ArrayList<Integer> factorial(int N) {
        ArrayList<Integer> digits = new ArrayList<>();
        digits.add(1);
        int x = 2, carryForward = 0, res;
        while (x <= N) {
            for (int i = digits.size() - 1; i >= 0; i--) {
                res = digits.get(i) * x + carryForward;
                digits.set(i, res % 10);
                carryForward = res / 10;
            }

            while (carryForward!=0)
            {
                digits.add(0, carryForward%10);
                carryForward = carryForward / 10;
            }
            x++;
        }
        return digits;
    }
}
