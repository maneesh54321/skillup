package com.learning.twentythree.dsalgo.tree;

import java.util.HashMap;
import java.util.Map;

public class VerticalSumOfBinaryTree {
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

        VerticalSumOfBinaryTree main = new VerticalSumOfBinaryTree();

        main.verticalSum(node1);
    }

    public void verticalSum(BinaryTreeNode root){
        Map<Integer, Integer> map = new HashMap<>();
        vSum(root, 0, map);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private void vSum(BinaryTreeNode root, int col, Map<Integer, Integer> map) {
        if (root != null) {
            map.put(col, map.getOrDefault(col, 0) + root.data);
            vSum(root.left, col - 1, map);
            vSum(root.right, col + 1, map);
        }
    }
}
