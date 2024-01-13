package com.learning.twentythree.dsalgo.tree;

public class DeleteElementFromBST {

    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, node7, null);
        BinaryTreeNode node6 = new BinaryTreeNode(13, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(16, node6, null);
        BinaryTreeNode node2 = new BinaryTreeNode(6, node4, node9);
        BinaryTreeNode node1 = new BinaryTreeNode(10, node2, node3);

        DeleteElementFromBST main = new DeleteElementFromBST();

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        System.out.println(levelOrderTraversal.levelOrder(node1));

        main.deleteElement(node1, 6);

        System.out.println(levelOrderTraversal.levelOrder(node1));
    }

    public void deleteElement(BinaryTreeNode root, int data) {
        BinaryTreeNode curr = root;
        BinaryTreeNode prev = new BinaryTreeNode(-1, root, null);

        while (curr != null) {
            if (curr.data == data) {
                if(curr.left == null && curr.right == null){
                    if(prev.left == curr){
                        prev.left = null;
                    } else {
                        prev.right = null;
                    }
                } else if(curr.left != null && curr.right != null){
                    BinaryTreeNode predecessor = curr.left;
                    BinaryTreeNode predecessorPrev = curr;
                    while (predecessor.right != null){
                        predecessorPrev = predecessor;
                        predecessor = predecessor.right;
                    }
                    curr.data = predecessor.data;
                    if(predecessor == predecessorPrev.left){
                        predecessorPrev.left = null;
                    } else {
                        predecessorPrev.right = null;
                    }
                } else if (curr.left != null) {
                    if(prev.left == curr){
                        prev.left = curr.left;
                    } else {
                        prev.right = curr.left;
                    }
                } else {
                    if(prev.left == curr){
                        prev.left = curr.right;
                    } else {
                        prev.right = curr.right;
                    }
                }
                break;
            } else {
                prev = curr;
                if (curr.data > data) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
        }
    }
}
