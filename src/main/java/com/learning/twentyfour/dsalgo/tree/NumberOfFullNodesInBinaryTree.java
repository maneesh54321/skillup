package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfFullNodesInBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        System.out.println("No of full nodes: " + new NumberOfFullNodesInBinaryTree().numOfFullNodes(node1));
    }

    public int numOfFullNodes(BinaryTreeNode root) {
        int count = 0;
        BinaryTreeNode curr = root;
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        boolean done = false;
        while (!done) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    BinaryTreeNode top = stack.pop();
                    System.out.println(top.val);
                    if (top.left != null && top.right != null)
                        count++;
                    curr = top.right;
                }
            }
        }
        return count;
    }
}
