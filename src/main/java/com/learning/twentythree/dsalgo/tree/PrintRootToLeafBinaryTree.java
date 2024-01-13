package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintRootToLeafBinaryTree {
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

        PrintRootToLeafBinaryTree main = new PrintRootToLeafBinaryTree();
        main.printRootToLeaf(node1);
        int[] arr = new int[10];
        main.printRootToLeaf_recursive(node1, arr, 1);
    }

    public void printRootToLeaf(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        Deque<BinaryTreeNode> tempStack = new ArrayDeque<>();

        BinaryTreeNode prev = null;
        BinaryTreeNode curr;

        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if(curr.left == null && curr.right == null){
                    while(!stack.isEmpty()){
                        tempStack.push(stack.pop());
                    }
                    while(!tempStack.isEmpty()){
                        BinaryTreeNode top = tempStack.pop();
                        System.out.print(top.data + " ");
                        stack.push(top);
                    }
                    System.out.println();
                } else if(curr.left != null){
                    stack.push(curr.left);
                } else {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if(curr.right != null){
                    stack.push(curr.right);
                }
            } else {
                stack.pop();
            }
            prev = curr;
        }
    }

    public void printRootToLeaf_recursive(BinaryTreeNode root, int[] path, int pathLen){
        if(root == null){
            return;
        }
        path[pathLen-1] = root.data;
        if(root.left == null && root.right == null){
            printArray(path, pathLen);
            System.out.println();
        }
        pathLen++;
        printRootToLeaf_recursive(root.left, path, pathLen);
        printRootToLeaf_recursive(root.right, path, pathLen);
    }

    public void printArray(int[] arr, int len){
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
