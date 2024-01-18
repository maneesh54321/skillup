package com.learning.twentyfour.dsalgo.tree;

import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

		iterative(node1);
	}

	public static void iterative(BinaryTreeNode root) {
		Deque<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode curr = queue.remove();
			if (curr != null) {
				System.out.println(curr.val);
				queue.add(curr.left);
				queue.add(curr.right);
			}
		}
	}
}
