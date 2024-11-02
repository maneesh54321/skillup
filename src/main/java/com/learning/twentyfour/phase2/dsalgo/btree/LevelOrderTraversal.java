package com.learning.twentyfour.phase2.dsalgo.btree;

import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderTraversal {

	public void traverseRecursive(BinaryTreeNode root) {

	}

	public void traverseIterative(BinaryTreeNode root) {
		Deque<BinaryTreeNode> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {
			var front = queue.poll();
			if(front == null) {
				if(queue.isEmpty()) break;
				queue.add(null);
			} else {
				System.out.println(front.val);
				if(front.left != null) queue.add(front.left);
				if(front.right != null) queue.add(front.right);
			}
		}
	}
}
