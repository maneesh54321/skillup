package com.learning.twentythree.dsalgo.tree;

public class LCABinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, node9);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node8, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        LCABinaryTree main = new LCABinaryTree();

        BinaryTreeNode lca = main.LCA(node1, node8, node9);

        System.out.println(lca.data);
    }

    public BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (root == null)
            return null;
        if (node1 == root || node2 == root)
            return root;
        BinaryTreeNode left = LCA(root.left, node1, node2);
        BinaryTreeNode right = LCA(root.right, node1, node2);

        if (left != null && right != null)
            return root;
        else
            return left != null ? left : right;
    }
}
