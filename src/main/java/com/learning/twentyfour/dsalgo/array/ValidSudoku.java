package com.learning.twentyfour.dsalgo.array;

public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println((int)'0');
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidColumn(board, i)) {
                return false;
            }
            if (!isValidRow(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                if(!isValidThreeCrossThreeSudoku(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidColumn(char[][] board, int column) {
        int[] oneToNine = new int[10];
        for (int i = 0; i < 9; i++) {
            if(board[i][column] != '.')
                oneToNine[board[i][column]-'0']++;

        }
        for (int i = 0; i < oneToNine.length; i++) {
            if (oneToNine[i] > 1)
                return false;
        }
        return true;
    }

    public static boolean isValidRow(char[][] board, int row) {
        int[] oneToNine = new int[10];
        for (int i = 0; i < 9; i++) {
            if(board[row][i] != '.')
                oneToNine[board[row][i]-'0']++;
        }
        for (int i = 0; i < oneToNine.length; i++) {
            if (oneToNine[i] > 1)
                return false;
        }
        return true;
    }

    public static boolean isValidThreeCrossThreeSudoku(char[][] board, int x, int y) {
        int[] oneToNine = new int[10];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if(board[i][j] != '.')
                    oneToNine[board[i][j]-'0']++;
            }
        }
        for (int i = 0; i < oneToNine.length; i++) {
            if (oneToNine[i] > 1)
                return false;
        }
        return true;
    }
}
