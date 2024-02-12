package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderDataInReverseOrder {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        new LevelOrderDataInReverseOrder().reverseLevelOrder(node1);
    }

    public void reverseLevelOrder(BinaryTreeNode root) {
        Deque<BinaryTreeNode> queue = new ArrayDeque<>();
        List<Integer> result  = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode top = queue.remove();
            result.add(top.val);
            if(top.right!= null){
                queue.add(top.right);
            }
            if(top.left != null){
                queue.add(top.left);
            }
        }
        for (int i = result.size()-1; i >= 0; i--) {
            System.out.println(result.get(i));
        }
    }
}
