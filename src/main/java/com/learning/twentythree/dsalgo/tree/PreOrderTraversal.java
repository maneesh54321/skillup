package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PreOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        PreOrderTraversal main = new PreOrderTraversal();
        main.preOrder(node1);
//        main.preOrderIterative(node1).forEach(System.out::print);
        System.out.println(main.preOrderIterative(node1).toString());
    }

    public void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public ArrayList<Integer> preOrderIterative(BinaryTreeNode root) {
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            list.add(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }
}
