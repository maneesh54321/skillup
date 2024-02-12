package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class SizeOfBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        System.out.println(new SizeOfBinaryTree().size(node1));
    }

    public int size(BinaryTreeNode root) {
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int size = 0;
        while (!stack.isEmpty()) {
            BinaryTreeNode top = stack.pop();
            size++;
            if(top.left != null)
                stack.push(top.left);
            if (top.right != null)
                stack.push(top.right);
        }
        return size;
    }
}
