package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static com.learning.twentyfour.dsalgo.array.IOUtils.printArray;

public class PrintRootToLeafBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);


        System.out.println("Iterative:");
        new PrintRootToLeafBinaryTree().rootToLeaf(node1);

        System.out.println("Recursive:");
        new PrintRootToLeafBinaryTree().rootToLeaf(node1, new int[100], 0);
    }

    public void rootToLeaf(BinaryTreeNode root){
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        Deque<BinaryTreeNode> printerStack = new ArrayDeque<>();
        stack.push(root);
        BinaryTreeNode prev = null, curr;
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if(prev == null || prev.left == curr || prev.right == curr) {
                if(curr.left != null){
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null)
                    stack.push(curr.right);
            } else {
                if(stack.peek().left == null && stack.peek().right == null){
                    while (!stack.isEmpty()){
                        printerStack.push(stack.pop());
                    }
                    while (!printerStack.isEmpty()){
                        BinaryTreeNode top = printerStack.pop();
                        System.out.print(top.val + " ");
                        stack.push(top);
                    }
                    System.out.print("\n");
                }
                stack.pop();
            }
            prev = curr;
        }
    }

    public void rootToLeaf(BinaryTreeNode root, int[] data, int i){
        data[i] = root.val;
        if(root.left == null && root.right == null){
            printArray(data, i);
            return;
        }
        if(root.left != null){
            rootToLeaf(root.left, data, i+1);
        }
        if(root.right != null){
            rootToLeaf(root.right, data, i+1);
        }
    }
}
