package com.learning.twentyfour.phase2.dsalgo.btree;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrderTraversal {
	public void traverseRecursive(BinaryTreeNode root){
		if(root == null) return;
		System.out.println(root.val);
		traverseRecursive(root.left);
		traverseRecursive(root.right);
	}

	public void traverseIterative(BinaryTreeNode root){
		if(root == null ) return;

		Deque<BinaryTreeNode> stack = new ArrayDeque<>();

		stack.push(root);

		while (!stack.isEmpty()) {
			BinaryTreeNode top = stack.pop();
			System.out.println(top.val);

			if(top.right != null) stack.push(top.right);
			if(top.left != null) stack.push(top.left);;
		}
	}
}
