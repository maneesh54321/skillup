package com.learning.twentythree.dsalgo.tree;

public class SumTree {

    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node8 = new TreeNode(8, null, node9);
        TreeNode node7 = new TreeNode(7, null, node8);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node7, node6);
        TreeNode node4 = new TreeNode(4, null, node5);
        TreeNode node3 = new TreeNode(3, null, node4);
        TreeNode node2 = new TreeNode(2, null, node3);
        TreeNode node1 = new TreeNode(1, node2, null);

        SumTree main = new SumTree();

        System.out.println(main.findSum(node1));
    }

    public int findSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        TreeNode curr = root;
        while(curr != null){
            sum += curr.data + findSum(curr.child);
            curr = curr.nextSibling;
        }
        return sum;
    }
}
