package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxElementInBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(100, node7, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        System.out.println("Max element: "+ new MaxElementInBinaryTree().maxElement(node1));
    }

    public int maxElement(BinaryTreeNode root){
        // Inorder traversal
        int max = Integer.MIN_VALUE;
        BinaryTreeNode curr = root;
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        boolean done = false;
        while (!done){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                if(stack.isEmpty()){
                    done = true;
                } else {
                    BinaryTreeNode top = stack.pop();
                    max = Math.max(max, top.val);
                    System.out.println(top.val);
                    curr = top.right;
                }
            }
        }
        return max;
    }
}
