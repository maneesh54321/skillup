package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

		recursive(node1);
		System.out.println("Iterative:");
		iterative(node1);
	}

	public static void recursive(BinaryTreeNode root){
		if(root != null) {
			recursive(root.left);
			recursive(root.right);
			System.out.println(root.val);
		}
	}

	public static void iterative(BinaryTreeNode root){
		if(root == null){
			return;
		}
		Deque<BinaryTreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		BinaryTreeNode prev = null;
		BinaryTreeNode curr;
		while (!stack.isEmpty()){
			curr = stack.peek();
			if(prev == null || curr == prev.left || curr == prev.right){
				if(curr.left!=null){
					stack.push(curr.left);
				} else if(curr.right != null) {
					stack.push(curr.right);
				}
			} else if (curr.left == prev) {
				if(curr.right != null) {
					stack.push(curr.right);
				}
			} else {
				stack.pop();
				System.out.println(curr.val);
			}
			prev = curr;
		}
	}
}
