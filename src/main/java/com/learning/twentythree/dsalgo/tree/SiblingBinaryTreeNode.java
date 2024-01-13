package com.learning.twentythree.dsalgo.tree;

public class SiblingBinaryTreeNode {
    int data;
    SiblingBinaryTreeNode left;
    SiblingBinaryTreeNode right;
    SiblingBinaryTreeNode nextSibling;

    public SiblingBinaryTreeNode(int data, SiblingBinaryTreeNode left, SiblingBinaryTreeNode right, SiblingBinaryTreeNode nextSibling) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.nextSibling = nextSibling;
    }
}
