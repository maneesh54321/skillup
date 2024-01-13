package com.learning.twentythree.dsalgo.tree;

public class MirrorBinaryTree {

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

        InOrderTraversal printer = new InOrderTraversal();

        System.out.println(printer.inOrderIterative(node1));

        MirrorBinaryTree main = new MirrorBinaryTree();

        BinaryTreeNode newBT = main.mirror(node1);
        System.out.println(new InOrderTraversal().inOrderIterative(newBT));
        main.mirrorSameBT(node1);
        System.out.println(new InOrderTraversal().inOrderIterative(node1));
    }

    public BinaryTreeNode mirror(BinaryTreeNode root) {
        if (root == null)
            return null;
        return new BinaryTreeNode(root.data, mirror(root.right), mirror(root.left));
    }

    public void mirrorSameBT(BinaryTreeNode root) {
        if (root != null) {
            mirrorSameBT(root.left);
            mirrorSameBT(root.right);
            BinaryTreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }
}
