package com.learning.twentythree.dsalgo.tree;

public class CheckIfBST {

    public static void main(String[] args) {
        BinaryTreeNode node13 = new BinaryTreeNode(13, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, node7, null);
        BinaryTreeNode node100 = new BinaryTreeNode(100, node7, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node16 = new BinaryTreeNode(16, node13, null);
        BinaryTreeNode node2 = new BinaryTreeNode(6, node4, node9);
        BinaryTreeNode node1 = new BinaryTreeNode(10, node2, node16);

        CheckIfBST main = new CheckIfBST();

        System.out.println(main.checkIfBST(node1)); // true

        // Not a BST now as 100 > root data 10
        node2.right = node100;

        System.out.println(main.checkIfBST(node1)); // true so wrong logic
    }

    public boolean checkIfBST(BinaryTreeNode root){
        if(root == null)
            return true;
        if(root.left!= null && root.left.data > root.data){
            return false;
        }
        if(root.right != null && root.right.data < root.data) {
            return false;
        }
        return checkIfBST(root.left) && checkIfBST(root.right);
    }
}
