package com.learning.twentythree.dsalgo.tree;

import java.util.Deque;
import java.util.LinkedList;

public class AllNodesSumBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, node8, node9);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        AllNodesSumBinaryTree main = new AllNodesSumBinaryTree();

        System.out.println(main.nodesSum_recursive(node1));
        System.out.println(main.nodesSum(node1));
    }

    public int nodesSum_recursive(BinaryTreeNode root) {
        if (root == null)
            return 0;
        return root.data + nodesSum(root.left) + nodesSum(root.right);
    }

    public int nodesSum(BinaryTreeNode root) {
        if(root == null)
            return 0;
        int sum = 0;
        Deque<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            BinaryTreeNode curr = q.poll();
            sum += curr.data;
            if(curr.left != null)
               q.offer(curr.left);
            if(curr.right != null)
                q.offer(curr.right);
        }
        return sum;
    }
}
