package com.learning.twentyfour.phase2.dsalgo.btree;

import java.util.ArrayDeque;
import java.util.Deque;

public class InOrderTraversal {
	public void traverseRecursive(BinaryTreeNode root){
		if(root == null) return;

		traverseRecursive(root.left);
		System.out.println(root.val);
		traverseRecursive(root.right);
	}

	public void traverseIterative(BinaryTreeNode root){
		BinaryTreeNode curr = root;

		Deque<BinaryTreeNode> stack = new ArrayDeque<>();

		boolean isComplete = false;

		while (!isComplete) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				if(stack.isEmpty()) {
					isComplete = true;
				} else {
					BinaryTreeNode top = stack.pop();
					System.out.println(top.val);
					curr = top.right;
				}
			}
		}
	}
}
