package com.learning.twentyfour.dsalgo.tree;

public class CreateMirrorOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        InOrderTraversal inOrderTraversal = new InOrderTraversal();

        BinaryTreeNode newTree = new CreateMirrorOfBinaryTree().createMirror(node1);
        inOrderTraversal.iterative(node1);
        inOrderTraversal.iterative(newTree);
    }

    public BinaryTreeNode createMirror(BinaryTreeNode root) {
        if(root == null)
            return null;
        BinaryTreeNode mirrorRoot = new BinaryTreeNode(root.val);

        mirrorRoot.left = createMirror(root.right);
        mirrorRoot.right = createMirror(root.left);

        return mirrorRoot;
    }
}
