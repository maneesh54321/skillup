package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class SearchElementInBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        System.out.println(new SearchElementInBinaryTree().search(node1, 5));
        System.out.println(new SearchElementInBinaryTree().search(node1, 100));
    }

    public boolean search(BinaryTreeNode root, int value) {
        BinaryTreeNode prev = null, curr;
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            curr = stack.peek();
            if(prev == null || prev.left == curr){
                if(curr.left!= null){
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if(curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                stack.pop();
                if(curr.val == value)
                    return true;
            }
            prev = curr;
        }
        return false;
    }
}
