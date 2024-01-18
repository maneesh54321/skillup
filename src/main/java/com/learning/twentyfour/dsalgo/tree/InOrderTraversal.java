package com.learning.twentyfour.dsalgo.tree;

import java.util.Deque;
import java.util.LinkedList;

public class InOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

		recursive(node1);
		System.out.println("");
		iterative(node1);
	}

	public static void recursive(BinaryTreeNode root){
		if(root != null){
			recursive(root.left);
			System.out.println(root.val);
			recursive(root.right);
		}
	}

	public static void iterative(BinaryTreeNode root){
		Deque<BinaryTreeNode> stack = new LinkedList<>();
		BinaryTreeNode curr = root;
		stack.push(curr);
		curr = curr.left;
		boolean done = false;
		while (!done) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				if(stack.isEmpty()){
					done = true;
				} else {
					curr = stack.pop();
					System.out.println(curr.val);
					curr = curr.right;
				}
			}
		}
	}
}
