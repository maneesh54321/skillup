package com.learning.twentyfour.phase2.dsalgo.btree;

public class BinaryTreeNode {
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode(int val) {
		this.val = val;
	}

	public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
