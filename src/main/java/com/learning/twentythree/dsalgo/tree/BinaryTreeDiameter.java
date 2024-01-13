package com.learning.twentythree.dsalgo.tree;

public class BinaryTreeDiameter {

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

        BinaryTreeDiameter main = new BinaryTreeDiameter();
        System.out.println(main.findDiameter(node1));
    }

    public int findDiameter(BinaryTreeNode root){
        if(root == null) {
            return 0;
        }

        // If path passes through root
        int len1 = height(root.left) + height(root.right) + 2;

        // If path doesn't pass through root
        int len2 = Math.max(findDiameter(root.left), findDiameter(root.right));

        return Math.max(len1, len2);
    }

    private int height(BinaryTreeNode root) {
        if(root == null){
            return -1;
        }
        return Math.max(height(root.left), height(root.right))+1;
    }
}
