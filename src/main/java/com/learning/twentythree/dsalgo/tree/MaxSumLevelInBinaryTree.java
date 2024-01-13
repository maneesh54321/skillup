package com.learning.twentythree.dsalgo.tree;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSumLevelInBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, node8, node9);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        MaxSumLevelInBinaryTree main = new MaxSumLevelInBinaryTree();
        System.out.println(main.findLevelWithMaxSum(node1));
    }

    public int findLevelWithMaxSum(BinaryTreeNode root) {
        Deque<BinaryTreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        while (!q.isEmpty()) {
            BinaryTreeNode curr = q.poll();
            if (curr == null) {
                if (!q.isEmpty()) {
                    maxSum = Math.max(currSum, maxSum);
                    currSum = 0;
                    q.offer(null);
                } else {
                    return Math.max(currSum, maxSum);
                }
            } else {
                if (curr.left != null) {
                    q.offer(curr.left);
                    currSum += curr.left.data;
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                    currSum += curr.right.data;
                }
            }
        }
        return maxSum;
    }


}
