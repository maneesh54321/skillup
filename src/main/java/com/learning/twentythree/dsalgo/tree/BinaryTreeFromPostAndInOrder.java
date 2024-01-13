package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayList;

public class BinaryTreeFromPostAndInOrder {

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

        InOrderTraversal inOrderTraversal = new InOrderTraversal();

        ArrayList<Integer> inOrder = inOrderTraversal.inOrderIterative(node1);

        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();

        ArrayList<Integer> postOrder = postOrderTraversal.postOrderIterative(node1);

        BinaryTreeFromPostAndInOrder main = new BinaryTreeFromPostAndInOrder();

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        System.out.println(levelOrderTraversal.levelOrder(main.buildTree(postOrder, 0, postOrder.size()-1, inOrder, 0, inOrder.size())));
    }

    public BinaryTreeNode buildTree(ArrayList<Integer> postOrder, int postStart, int postEnd, ArrayList<Integer> inOrder, int inStart, int inEnd){
        if(postStart > postEnd || inStart > inEnd) {
            return null;
        }
        int rootData = postOrder.get(postEnd);
        int inOrderIndex = inOrder.indexOf(rootData);
        BinaryTreeNode left = buildTree(postOrder, postStart, postStart + (inOrderIndex-inStart)-1, inOrder, inStart, inOrderIndex-1);
        BinaryTreeNode right = buildTree(postOrder, postStart + (inOrderIndex-inStart), postEnd-1, inOrder, inOrderIndex+1, inEnd);
        return new BinaryTreeNode(rootData, left, right);
    }
}
