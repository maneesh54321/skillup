package com.learning.twentyfour.dsalgo.array;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        printMatrix(matrix);
        System.out.println("");
        rotateMatrix(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("");
    }

    public static void rotateMatrix(int[][] mat){
        int layers = mat.length/2;
        for (int i = 0; i < layers; i++) {
            rotateLayer(mat, i);
        }
    }

    private static void rotateLayer(int[][] mat, int layer) {
        int[] top = new int[mat.length];
        for (int i = layer; i < mat.length - layer; i++) {
            top[i] = mat[layer][i];
        }
        // move left to top
        for (int i = layer; i < mat.length - layer; i++) {
            int idx = mat.length - 1  - i;
            mat[layer][idx] = mat[i][layer];
        }
        // move bottom to left
        for (int i = layer; i < mat.length - layer; i++) {
            mat[i][layer] = mat[mat.length - 1 - layer][i];
        }
        // move right to bottom
        for (int i = layer; i < mat.length - layer; i++) {
            int idx = mat.length - 1 - i;
            mat[mat.length - 1 - layer][i] = mat[idx][mat.length - 1 - layer];
        }
        // move top to right
        for (int i = layer; i < mat.length - layer; i++) {
            mat[i][mat.length - 1 -layer] = top[i];
        }
    }
}
