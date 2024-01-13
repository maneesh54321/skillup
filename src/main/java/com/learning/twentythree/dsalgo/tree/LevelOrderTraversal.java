package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        LevelOrderTraversal main = new LevelOrderTraversal();

        System.out.println(main.levelOrder(node1));
    }

    public ArrayList<Integer> levelOrder(BinaryTreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode head = queue.poll();
            result.add(head.data);
            if(head.left != null){
                queue.offer(head.left);
            }
            if(head.right != null){
                queue.offer(head.right);
            }
        }
        return result;
    }
}
