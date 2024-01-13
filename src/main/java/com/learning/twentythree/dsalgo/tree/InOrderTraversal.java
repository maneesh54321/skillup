package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class InOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        InOrderTraversal main = new InOrderTraversal();
        main.inOrder(node1);
        System.out.println();
        System.out.println(main.inOrderIterative(node1));

        System.out.println(main.inOrderIterative_1(node1));
    }

    public void inOrder(BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public ArrayList<Integer> inOrderIterative_1(BinaryTreeNode root) {
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        BinaryTreeNode currentNode = root;
        boolean done = false;
        while (!done) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    BinaryTreeNode top = stack.pop();
                    result.add(top.data);
                    currentNode = top.right;
                }
            }
        }

        return result;
    }

    public ArrayList<Integer> inOrderIterative(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        BinaryTreeNode prev = null;
        BinaryTreeNode curr;

        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left == null) {
                    result.add(curr.data);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (prev == curr.left) {
                result.add(curr.data);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                stack.pop();
            }
            prev = curr;
        }

        return result;
    }
}
