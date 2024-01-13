package com.learning.twentythree.dsalgo.tree;

public class FindMinimumInBST {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, node7, null);
        BinaryTreeNode node6 = new BinaryTreeNode(13, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(16, node6, null);
        BinaryTreeNode node2 = new BinaryTreeNode(6, node4, node9);
        BinaryTreeNode node1 = new BinaryTreeNode(10, node2, node3);

        FindMinimumInBST main = new FindMinimumInBST();

        System.out.println(main.findMin(node1).data);
    }

    public BinaryTreeNode findMin(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
