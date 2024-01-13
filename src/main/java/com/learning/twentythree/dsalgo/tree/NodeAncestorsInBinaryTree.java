package com.learning.twentythree.dsalgo.tree;

public class NodeAncestorsInBinaryTree {

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

        NodeAncestorsInBinaryTree main = new NodeAncestorsInBinaryTree();

        main.printAncestors(node1, node9);
    }

    public boolean printAncestors(BinaryTreeNode root, BinaryTreeNode node) {
        if(root == null)
            return false;
        if(root == node || printAncestors(root.left, node) || printAncestors(root.right, node)){
            System.out.println(root.data);
            return true;
        }
        return false;
    }
}
