package com.learning.twentythree.dsalgo.tree.leetcode;

import com.learning.twentythree.dsalgo.tree.BinaryTreeNode;

public class StringFromBinaryTree {
    public static void main(String[] args) {

    }

    public String tree2str(BinaryTreeNode root) {
        if(root == null){
            return "";
        }
        if(root.left == null && root.right == null){
            return root.data + "";
        }
        if(root.right == null) {
            return root.data + "(" + tree2str(root.left) + ")";
        } else {
            return root.data + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
        }
    }
}
