package com.learning.twentythree.dsalgo.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle main = new PascalTriangle();
        System.out.println(main.getRow(6));
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        var row1 = new ArrayList<Integer>();
        row1.add(1);
        result.add(row1);
        if (numRows == 1)
            return result;
        for (int i = 1; i < numRows; i++) {
            var row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 0; j < i - 1; j++) {
                row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        var result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int prev = 0;
            for (int j = 0; j < i; j++) {
                int curr = result.get(j);
                result.set(j, prev + curr);
                prev = curr;
            }
            result.add(1);
        }

        return result;
    }
}
