package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DeleteElementInBinaryTree {

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

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        DeleteElementInBinaryTree main = new DeleteElementInBinaryTree();
        System.out.println(levelOrderTraversal.levelOrder(node1));

        main.deleteElement(node1, 1);

        System.out.println(levelOrderTraversal.levelOrder(node1));
    }

    public void deleteElement(BinaryTreeNode root, int data) {
        BinaryTreeNode nodeToBeDeleted = null;
        Deque<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        BinaryTreeNode currentNode = null;
        while (!q.isEmpty()) {
            currentNode = q.poll();
            if (data == currentNode.data) {
                nodeToBeDeleted = currentNode;
            }
            if (currentNode.left != null) {
                q.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                q.offer(currentNode.right);
            }
        }
        assert nodeToBeDeleted != null;
        nodeToBeDeleted.data = currentNode.data;
        searchAndDelete(root, currentNode);
    }

    public void searchAndDelete(BinaryTreeNode root, BinaryTreeNode nodeToBeDeleted) {
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        BinaryTreeNode prev = null;
        BinaryTreeNode curr;
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if(curr == nodeToBeDeleted){
                stack.pop();
                BinaryTreeNode parent = stack.pop();
                if (parent.left == curr){
                    parent.left=null;
                } else {
                    parent.right = null;
                }
                break;
            }
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null){
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if(curr.right!=null){
                    stack.push(curr.right);
                }
            } else {
                stack.pop();
            }
            prev = curr;
        }
    }
}
