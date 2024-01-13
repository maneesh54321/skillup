package com.learning.twentythree.dsalgo.tree;

public class CheckIfMirrorBinaryTree {
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

        CheckIfMirrorBinaryTree main = new CheckIfMirrorBinaryTree();

        MirrorBinaryTree mirrorBinaryTree = new MirrorBinaryTree();
        BinaryTreeNode mirroredBT = mirrorBinaryTree.mirror(node1);

        System.out.println(main.checkIfMirror(node1, mirroredBT));
    }

    public boolean checkIfMirror(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        } else {
            return root1.data == root2.data && checkIfMirror(root1.left, root2.right) && checkIfMirror(root1.right, root2.left);
        }
    }
}
