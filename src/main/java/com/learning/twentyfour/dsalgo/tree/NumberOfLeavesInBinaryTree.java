package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfLeavesInBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        System.out.println(new NumberOfLeavesInBinaryTree().numOfLeaves(node1));
    }

    public int numOfLeaves(BinaryTreeNode root){
        if(root == null)
            return 0;
        Deque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()){
            BinaryTreeNode front = queue.remove();
            if (front.left == null && front.right == null){
                count++;
            } else {
                if(front.left != null){
                    queue.add(front.left);
                }
                if (front.right != null){
                    queue.add(front.right);
                }
            }
        }
        return count;
    }
}
