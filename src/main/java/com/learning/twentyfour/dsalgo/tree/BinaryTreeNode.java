package com.learning.twentyfour.dsalgo.tree;

public class BinaryTreeNode {
	public int val;
	public BinaryTreeNode left, right;

	public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public BinaryTreeNode (int val) {
		this.val = val;
	}
}
