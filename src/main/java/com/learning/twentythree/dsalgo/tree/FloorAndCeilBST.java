package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class FloorAndCeilBST {

    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, node7, null);
        BinaryTreeNode node6 = new BinaryTreeNode(13, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(16, node6, null);
        BinaryTreeNode node2 = new BinaryTreeNode(6, node4, node9);
        BinaryTreeNode node1 = new BinaryTreeNode(10, node2, node3);

        FloorAndCeilBST main = new FloorAndCeilBST();

        main.printFloorAndCeil(node1, 3);
    }

    public void printFloorAndCeil(BinaryTreeNode root, int k) {
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();

        BinaryTreeNode currentNode = root;

        boolean done = false;

        BinaryTreeNode prev = null;

        while (!done){
            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (stack.isEmpty()){
                    done = true;
                } else {
                    BinaryTreeNode tmp = stack.pop();
                    if(tmp.data >= k) {
                        System.out.println("Floor: "+ (prev != null? prev.data : "doesn't exist") + " Ceil: " + tmp.data);
                        break;
                    }
                    prev = tmp;
                    currentNode = tmp.right;
                }
            }
        }
        if(done) {
            System.out.println("Floor: "+ (prev != null? prev.data : -1) + " Ceil: doesn't exist");
        }
    }
}
