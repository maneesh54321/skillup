package com.learning.twentyfour.phase2.dsalgo.btree;

public class BinaryTreeTraversalApp {

	public static void main(String[] args) {

		BinaryTreeNode node9 = new BinaryTreeNode(9);
		BinaryTreeNode node8 = new BinaryTreeNode(8);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node5 = new BinaryTreeNode(5, node8, node9);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

		BinaryTreeNode root = node1;


		System.out.println("\n################## Pre Order\n");
		var preOrderTraverse = new PreOrderTraversal();
		preOrderTraverse.traverseIterative(root);

		System.out.println("\n################## In Order\n");
		var inOrderTraversal = new InOrderTraversal();
		inOrderTraversal.traverseIterative(root);

		System.out.println("\n################## Post Order\n");
		var postOrderTraversal = new PostOrderTraversal();
		postOrderTraversal.traverseIterative(root);

		System.out.println("\n################## Level Order\n");
		var levelOrderTraversal = new LevelOrderTraversal();
		levelOrderTraversal.traverseIterative(root);

	}
}
