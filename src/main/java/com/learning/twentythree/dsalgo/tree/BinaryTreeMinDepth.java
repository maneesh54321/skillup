package com.learning.twentythree.dsalgo.tree;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeMinDepth {
    public static void main(String[] args) {
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, node8, node9);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        BinaryTreeMinDepth main = new BinaryTreeMinDepth();
        System.out.println(main.minDepth(node1));

    }

    public int minDepth(BinaryTreeNode root){
        Deque<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int depth = 1;
        while (!q.isEmpty()) {
            BinaryTreeNode curr = q.poll();
            if(curr == null){
                if(!q.isEmpty()){
                    depth++;
                    q.offer(null);
                }
            } else {
                if(curr.left == null && curr.right == null){
                    return depth;
                }

                if(curr.left != null){
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
        }
        return depth;
    }
}
