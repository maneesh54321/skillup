package com.learning.twentythree.dsalgo.tree;

public class AVLTreeNode {
    int data;
    int height;
    AVLTreeNode left, right;

    public AVLTreeNode(int data, int height, AVLTreeNode left, AVLTreeNode right) {
        this.data = data;
        this.height = height;
        this.left = left;
        this.right = right;
    }
}
