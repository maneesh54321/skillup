package com.learning.twentythree.dsalgo.tree;

public class TreeNode {
    int data;
    TreeNode child;
    TreeNode nextSibling;

    public TreeNode(int data, TreeNode child, TreeNode nextSibling) {
        this.data = data;
        this.child = child;
        this.nextSibling = nextSibling;
    }
}
