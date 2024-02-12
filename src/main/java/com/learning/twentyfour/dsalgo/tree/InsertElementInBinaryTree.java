package com.learning.twentyfour.dsalgo.tree;

import java.util.*;

public class InsertElementInBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        new InsertElementInBinaryTree().insertElement(node1, 6);
    }

    public void insertElement(BinaryTreeNode root, int data) {
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode top = stack.pop();
            if(top.left == null){
                top.left = new BinaryTreeNode(data);
                break;
            } else {
                stack.push(top.left);
            }
            if(top.right == null){
                top.right = new BinaryTreeNode(data);
                break;
            } else {
                stack.push(top.right);
            }
        }
    }
}
