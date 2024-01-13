package com.learning.twentythree.dsalgo.tree;

import java.util.*;

public class ZigzagTraversal {

    public static void main(String[] args) {
        BinaryTreeNode node11 = new BinaryTreeNode(11, null, null);
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, node11);
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, node8, node9);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node10, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        ZigzagTraversal main = new ZigzagTraversal();

        System.out.println(main.zigzagTraversal(node1));


        main.zigzagTraversal_improved(node1).forEach(integers -> integers.forEach(System.out::println));
    }

    public ArrayList<Integer> zigzagTraversal(BinaryTreeNode root) {
        Deque<BinaryTreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        int level = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            BinaryTreeNode front = q.poll();
            if (front == null) {
                if (level % 2 == 1) {
                    while (!stack.isEmpty())
                        result.add(stack.pop());
                }
                level++;
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                if (level % 2 == 1) {
                    stack.push(front.data);
                } else {
                    result.add(front.data);
                }
                if (front.left != null)
                    q.offer(front.left);
                if (front.right != null)
                    q.offer(front.right);
            }
        }
        return result;
    }

    public List<List<Integer>> zigzagTraversal_improved(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        boolean fromLeft = true;
        List<Integer> list = new ArrayList<>();
        result.add(list);
        while (!q.isEmpty()) {
            BinaryTreeNode front = q.poll();
            if (front == null) {
                if (q.isEmpty()) {
                    break;
                }
                q.offer(null);
                fromLeft = !fromLeft;
                if (fromLeft) {
                    list = new ArrayList<>();
                } else {
                    list = new LinkedList<>();
                }
                result.add(list);
            } else {
                if (fromLeft) {
                    list.add(front.data);
                } else {
                    ((LinkedList) list).addFirst(front.data);
                }
                if (front.left != null) {
                    q.offer(front.left);
                }
                if (front.right != null) {
                    q.offer(front.right);
                }
            }
        }
        return result;
    }
}
