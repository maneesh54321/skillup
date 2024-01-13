package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LevelOrderTraversalInReverse {

    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        LevelOrderTraversalInReverse main = new LevelOrderTraversalInReverse();
        System.out.println(main.reverseLevelOrder(node1));
    }

    public ArrayList<Integer> reverseLevelOrder(BinaryTreeNode root){
        Deque<BinaryTreeNode> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            BinaryTreeNode tmp = queue.poll();
            stack.push(tmp.data);
            if(tmp.right!=null){
                queue.offer(tmp.right);
            }
            if(tmp.left != null){
                queue.offer(tmp.left);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}
