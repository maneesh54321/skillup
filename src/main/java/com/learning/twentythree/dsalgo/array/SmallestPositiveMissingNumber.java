package com.learning.twentythree.dsalgo.array;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
//        System.out.println(missingNumber(new int[]{1,2,3,4,5}, 5));
//        System.out.println(missingNumber(new int[]{0,-10,1,3,-20}, 5));
//        System.out.println(missingNumber(new int[]{28, 7, -36, 21, -21, -50, 9, -32}, 8));
        System.out.println(missingNumber(new int[]{-47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43, -50, -16, 14, -26}, 85));
    }

    static int missingNumber(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] < 0 || arr[i] > size) {
                arr[i] = 0;
            }
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0)
                continue;
            int elem = 0;
            if (arr[i] < 0) {
                elem = (arr[i] % size) * -1;
            } else {
                elem = arr[i];
            }
            int index = elem % size;
            if (arr[index] < 0) {
                continue;
            }
            arr[index] = -1 * arr[index] - size;
        }

        for (int i = 1; i < size; i++) {
            if (arr[i] / size == 0) {
                return i;
            }
        }
        if (arr[0] / size == 0)
            return size;
        return size + 1;
    }
}
