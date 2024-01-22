package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class PopulateNextRightPointersInEachNodeII {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3, null, node7);
        Node node2 = new Node(2, node4, node5);
        Node node1 = new Node(1, node2, node3);

        connect(node1);
    }

    public static Node connect(Node root) {
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node prevNode = null;
        while(!queue.isEmpty()) {
            Node front = queue.remove();
            if(front == null) {
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            } else {
                if(front.left != null) {
                    queue.add(front.left);
                }
                if(front.right != null) {
                    queue.add(front.right);
                }
            }
            if(prevNode != null) {
                prevNode.next = front;
            }
            prevNode = front;
        }
        return root;
    }

//    public static Node connectDFS(Node root){
//        if(root != null) {
//            if(root.left!= nul)
//        }
//    }
}
