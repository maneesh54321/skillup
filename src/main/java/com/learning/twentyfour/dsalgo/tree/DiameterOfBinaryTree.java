package com.learning.twentyfour.dsalgo.tree;

public class DiameterOfBinaryTree {

    private int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        System.out.println("Height: " + diameterOfBinaryTree.height(node1));
        System.out.println("Diameter: " + diameterOfBinaryTree.max);
    }

    public int height(BinaryTreeNode root){
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        int dia = left + right;

        if(dia > max){
            max = dia;
        }

        return Math.max(left + 1, right + 1);
    }
}
