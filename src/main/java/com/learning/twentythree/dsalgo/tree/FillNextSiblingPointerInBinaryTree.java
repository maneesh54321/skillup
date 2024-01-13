package com.learning.twentythree.dsalgo.tree;

import java.util.Deque;
import java.util.LinkedList;

public class FillNextSiblingPointerInBinaryTree {

    public static void main(String[] args) {
        SiblingBinaryTreeNode node9 = new SiblingBinaryTreeNode(9, null, null, null);
        SiblingBinaryTreeNode node8 = new SiblingBinaryTreeNode(8, null, null, null);
        SiblingBinaryTreeNode node7 = new SiblingBinaryTreeNode(7, node8, node9, null);
        SiblingBinaryTreeNode node6 = new SiblingBinaryTreeNode(6, null, null, null);
        SiblingBinaryTreeNode node5 = new SiblingBinaryTreeNode(5, null, null, null);
        SiblingBinaryTreeNode node4 = new SiblingBinaryTreeNode(4, null, null, null);
        SiblingBinaryTreeNode node3 = new SiblingBinaryTreeNode(3, node6, node7, null);
        SiblingBinaryTreeNode node2 = new SiblingBinaryTreeNode(2, node4, node5, null);
        SiblingBinaryTreeNode node1 = new SiblingBinaryTreeNode(1, node2, node3, null);

        FillNextSiblingPointerInBinaryTree main = new FillNextSiblingPointerInBinaryTree();

        main.fillNextSibling(node1);

        main.printTree(node1);
    }

    public void printTree(SiblingBinaryTreeNode root) {
        Deque<SiblingBinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            SiblingBinaryTreeNode front = q.poll();
            System.out.println("(" + front.data + ":" + (front.nextSibling != null ? front.nextSibling.data : null) + ")");
            if(front.left!=null)
                q.offer(front.left);
            if(front.right != null)
                q.offer(front.right);
        }
    }

    public void fillNextSibling(SiblingBinaryTreeNode root) {
        Deque<SiblingBinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            SiblingBinaryTreeNode front = q.poll();
            if(front == null){
                if(!q.isEmpty()){
                    q.offer(null);
                }
            } else {
                front.nextSibling = q.peek();
                if (front.left != null) {
                    q.offer(front.left);
                }
                if (front.right != null) {
                    q.offer(front.right);
                }
            }
        }
    }
}
