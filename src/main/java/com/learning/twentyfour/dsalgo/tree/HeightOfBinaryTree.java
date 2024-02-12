package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        System.out.println(new HeightOfBinaryTree().heightIterative(node1));
        System.out.println(new HeightOfBinaryTree().heightLOT(node1));
    }

    public int height(BinaryTreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = 0;
        if (root.left != null) {
            leftHeight = 1 + height(root.left);
        }
        int rightHeight = 0;
        if (root.right != null) {
            rightHeight = 1 + height(root.right);
        }

        return Math.max(leftHeight, rightHeight);
    }

    public int heightIterative(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        BinaryTreeNode curr, prev = null;
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        int height = Integer.MIN_VALUE;
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null)
                    stack.push(curr.left);
                else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                if (curr.left == null && curr.right == null) {
                    height = Math.max(height, stack.size());
                }
                stack.pop();
            }
            prev = curr;
        }
        return height;
    }

    public int heightLOT(BinaryTreeNode root) {
        Deque<BinaryTreeNode> queue = new LinkedList<>();
        int height = 0;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            BinaryTreeNode front = queue.remove();
            if (front == null) {
                height++;
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            } else {
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
        }
        return height;
    }
}
