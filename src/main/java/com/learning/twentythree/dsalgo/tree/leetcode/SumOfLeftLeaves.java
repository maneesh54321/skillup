package com.learning.twentythree.dsalgo.tree.leetcode;

import com.learning.twentythree.dsalgo.tree.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        BinaryTreeNode node5 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(15, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(20, node4, node5);
        BinaryTreeNode node2 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node1 = new BinaryTreeNode(3, node2, node3);

        SumOfLeftLeaves main = new SumOfLeftLeaves();
        System.out.println(main.findSumOfLeftLeaves(node1));
    }

    public int findSumOfLeftLeaves(BinaryTreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        Deque<BinaryTreeNode> stack = new LinkedList<>();
        int sum = 0;

        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode top = stack.pop();
            if (top.right != null) {
                stack.push(top.right);
            }
            BinaryTreeNode curr = top.left;
            while (curr != null) {
                if (curr.left == null && curr.right == null) {
                    sum += curr.data;
                    break;
                }
                if (curr.right != null) {
                    stack.push(curr.right);

                }
                if (curr.left == null) {
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }
        return sum;
    }
}
