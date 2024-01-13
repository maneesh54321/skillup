package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayList;

public class BinaryTreeFromPreAndInOrder {

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

        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();

        ArrayList<Integer> preOrder = preOrderTraversal.preOrderIterative(node1);

        BinaryTreeFromPreAndInOrder main = new BinaryTreeFromPreAndInOrder();

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        System.out.println(levelOrderTraversal.levelOrder(main.buildTree(preOrder, 0, preOrder.size()-1, inOrder, 0, inOrder.size())));
    }

    public BinaryTreeNode buildTree(ArrayList<Integer> preOrder, int preStart, int preEnd, ArrayList<Integer> inOrder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootData = preOrder.get(preStart);
        int inOrderIndex = inOrder.indexOf(rootData);
        return new BinaryTreeNode(rootData, buildTree(preOrder, preStart+1, preStart + (inOrderIndex-inStart), inOrder, inStart, inOrderIndex-1),
                buildTree(preOrder, preStart + (inOrderIndex-inStart) + 1, preEnd, inOrder, inOrderIndex+1, inEnd));
    }
}
