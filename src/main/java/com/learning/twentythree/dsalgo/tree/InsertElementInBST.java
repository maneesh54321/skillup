package com.learning.twentythree.dsalgo.tree;

public class InsertElementInBST {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, node7, null);
        BinaryTreeNode node6 = new BinaryTreeNode(13, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(16, node6, null);
        BinaryTreeNode node2 = new BinaryTreeNode(6, node4, node9);
        BinaryTreeNode node1 = new BinaryTreeNode(10, node2, node3);

        InsertElementInBST main = new InsertElementInBST();

        BinaryTreeNode result = main.insertElement(node1, 14);
        BinaryTreeNode result1 = main.insertElementRecursive(node1, 14);
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        System.out.println(levelOrderTraversal.levelOrder(result));
        System.out.println(levelOrderTraversal.levelOrder(result1));
    }

    public BinaryTreeNode insertElement(BinaryTreeNode root, int data) {
        if (root == null) {
            return new BinaryTreeNode(data, null, null);
        }
        BinaryTreeNode curr = root;
        BinaryTreeNode prev = null;
        while (curr != null) {
            if (curr.data == data)
                return root;
            prev = curr;
            if (curr.data < data)
                curr = curr.right;
            else
                curr = curr.left;
        }
        if (data < prev.data)
            prev.left = new BinaryTreeNode(data, null, null);
        else
            prev.right = new BinaryTreeNode(data, null, null);

        return root;
    }

    public BinaryTreeNode insertElementRecursive(BinaryTreeNode root, int data) {
        if (root == null) {
            root = new BinaryTreeNode(data, null, null);
        }
        if (data != root.data) {
            if (data < root.data) {
                if (root.left != null) {
                    insertElementRecursive(root.left, data);
                } else {
                    root.left = new BinaryTreeNode(data, null, null);
                }
            } else {
                if (root.right != null) {
                    insertElementRecursive(root.right, data);
                } else {
                    root.right = new BinaryTreeNode(data, null, null);
                }
            }
        }
        return root;
    }
}
