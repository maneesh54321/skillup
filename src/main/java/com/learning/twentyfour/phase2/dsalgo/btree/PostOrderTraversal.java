package com.learning.twentyfour.phase2.dsalgo.btree;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostOrderTraversal {

	public void traverseRecursive(BinaryTreeNode root) {
		if (root == null) {
			return;
		}

		traverseRecursive(root.left);
		traverseRecursive(root.right);
		System.out.println(root.val);
	}

	public void traverseIterative(BinaryTreeNode root) {
		if(root == null) return;

		BinaryTreeNode curr, prev = null;

		Deque<BinaryTreeNode> stack = new ArrayDeque<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			curr = stack.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				}
			} else if (curr.left == prev) {
				if(curr.right != null) {
					stack.push(curr.right);
				}
			} else {
				System.out.println(curr.val);
				stack.pop();
			}
			prev = curr;
		}
	}
}
