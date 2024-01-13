package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class ExpressionTreeFromPostfix {

    static class BinaryTreeCharNode {
        public char data;
        public BinaryTreeCharNode left;
        public BinaryTreeCharNode right;

        public BinaryTreeCharNode(char data, BinaryTreeCharNode left, BinaryTreeCharNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        ExpressionTreeFromPostfix main = new ExpressionTreeFromPostfix();
        BinaryTreeCharNode exprTree = main.buildTree(new char[]{'A', 'B', '+', 'C', 'D', '-', '+'}, 7);
        System.out.println(main.levelOrderTraversal(exprTree));
    }

    public ArrayList<Character> levelOrderTraversal(BinaryTreeCharNode root){
        Deque<BinaryTreeCharNode> q = new LinkedList<>();
        ArrayList<Character> result = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()){
            BinaryTreeCharNode front = q.poll();
            result.add(front.data);
            if(front.left != null)
                q.offer(front.left);
            if(front.right != null)
                q.offer(front.right);
        }
        return result;
    }

    public BinaryTreeCharNode buildTree(char[] postfixExpr, int length) {
        Deque<BinaryTreeCharNode> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ele = postfixExpr[i];
            switch (ele) {
                case '/', '*', '+', '-' -> {
                    BinaryTreeCharNode top1 = stack.pop();
                    BinaryTreeCharNode top2 = stack.pop();
                    BinaryTreeCharNode node = new BinaryTreeCharNode(ele, top2, top1);
                    stack.push(node);
                }
                default -> stack.push(new BinaryTreeCharNode(ele, null, null));
            }
        }

        return stack.pop();
    }
}
