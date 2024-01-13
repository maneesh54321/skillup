package com.learning.twentythree.dsalgo.tree.leetcode;

import com.learning.twentythree.dsalgo.tree.BinaryTreeNode;

public class RootToLeafBinaryNumbersSum {

    public static void main(String[] args) {

    }

    public int sumRootToLeaf(BinaryTreeNode root) {
        int[] path = new int[1000];
        int idx = 0;
        return sum(root, path, idx);
    }

    private int sum(BinaryTreeNode root, int[] path, int idx) {
        path[idx++] = root.data;
        if (root.left == null && root.right == null) {
            return calcBinaryNum(root, path, idx);
        } else {
            int right = 0;
            int left = 0;

            if(root.left != null){
                left = sum(root.left, path, idx);
            }
            if(root.right != null){
                right = sum(root.right, path, idx);
            }
            return left + right;
        }
    }

    private int calcBinaryNum(BinaryTreeNode root, int[] path, int idx) {
        int num = 0;
        int two = 1;
        for (int i = 0; i < idx; i++) {
            num += path[idx-i-1] * two;
            two *= 2;
        }
        return num;
    }
}
