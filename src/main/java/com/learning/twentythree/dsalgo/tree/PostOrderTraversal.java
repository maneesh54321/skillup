package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PostOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        PostOrderTraversal main = new PostOrderTraversal();
        main.postOrder(node1);

        System.out.println(main.postOrderIterative(node1));
    }

    public void postOrder(BinaryTreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public ArrayList<Integer> postOrderIterative(BinaryTreeNode root) {
        Deque<BinaryTreeNode> stack = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        BinaryTreeNode prev = null;
        BinaryTreeNode curr;
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null){
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if(curr.right != null){
                    stack.push(curr.right);
                }
            } else {
                // Either we are moving from bottom to top through right node OR prev and curr are on same node.
                result.add(stack.pop().data);
            }
            prev = curr;
        }
        return result;
    }
}
