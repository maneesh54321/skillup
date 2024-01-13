package com.learning.twentythree.dsalgo.tree;

public class FindElementInBST {

    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, node7, null);
        BinaryTreeNode node6 = new BinaryTreeNode(13, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(16, node6, null);
        BinaryTreeNode node2 = new BinaryTreeNode(6, node4, node9);
        BinaryTreeNode node1 = new BinaryTreeNode(10, node2, node3);

        FindElementInBST main = new FindElementInBST();

        System.out.println(main.find(node1, node7).data);
        System.out.println(main.findIteratively(node1, node7).data);
    }

    public BinaryTreeNode find(BinaryTreeNode root, BinaryTreeNode node) {
        if(root == null){
            return null;
        }
        if(root == node){
            return root;
        }
        if(node.data > root.data){
            return find(root.right, node);
        } else {
            return find(root.left, node);
        }
    }

    public BinaryTreeNode findIteratively(BinaryTreeNode root, BinaryTreeNode node) {
        while (root != null){
            if(root == node){
                return root;
            }
            if(node.data > root.data){
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
}
