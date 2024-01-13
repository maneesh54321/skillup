package com.learning.twentythree.dsalgo.tree;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfLeavesBinaryTree {
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

        NumberOfLeavesBinaryTree main = new NumberOfLeavesBinaryTree();
        System.out.println(main.findNumOfLeavesInBinaryTree(node1));
    }

    public int findNumOfLeavesInBinaryTree(BinaryTreeNode root){
        Deque<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        int count = 0;

        while(!q.isEmpty()){
            BinaryTreeNode currNode = q.poll();
            if(currNode.left == null && currNode.right == null){
                count++;
            } else {
                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                if(currNode.right != null){
                    q.offer(currNode.right);
                }
            }
        }
        return count;
    }
}
