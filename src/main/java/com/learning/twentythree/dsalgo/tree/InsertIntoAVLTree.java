package com.learning.twentythree.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class InsertIntoAVLTree {

    public static void main(String[] args) {
        AVLTreeNode node5 = new AVLTreeNode(6, 0, null, null);
        AVLTreeNode node4 = new AVLTreeNode(3, 0, null, null);
        AVLTreeNode node3 = new AVLTreeNode(9, 0, null, null);
        AVLTreeNode node2 = new AVLTreeNode(5, 1, node4, node5);
        AVLTreeNode node1 = new AVLTreeNode(8, 2, node2, node3);

        InsertIntoAVLTree main = new InsertIntoAVLTree();
        AVLTreeNode result = main.insert(node1, 7);

        System.out.println(main.inOrder(result));
    }

    public ArrayList<Integer> inOrder(AVLTreeNode root){
        Deque<AVLTreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        AVLTreeNode currentNode = root;
        boolean done = false;

        while (!done){
            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if(stack.isEmpty()){
                    done  = true;
                } else {
                    AVLTreeNode tmp = stack.pop();
                    currentNode = tmp.right;
                    result.add(tmp.data);
                }
            }
        }
        return result;
    }

    public AVLTreeNode insert(AVLTreeNode root, int data) {
        if (root == null) {
            return new AVLTreeNode(data, 0, null, null);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
            if (Height(root.left) - Height(root.right) == 2) {
                if (data < root.left.data) {
                    root = SingleRotateLeft(root);
                } else {
                    root = DoubleRotationLeft(root);
                }
            }
        } else if(data > root.data){
            root.right = insert(root.right, data);
            if (Height(root.right) - Height(root.left) == 2) {
                if (data > root.right.data) {
                    root = SingleRotateRight(root);
                } else {
                    root = DoubleRotationRight(root);
                }
            }
        }
        root.height = Math.max(Height(root.left), Height(root.right))+1;
        return root;
    }

    private AVLTreeNode DoubleRotationRight(AVLTreeNode X) {
        X.right = SingleRotateLeft(X.right);
        return SingleRotateRight(X);
    }

    private AVLTreeNode DoubleRotationLeft(AVLTreeNode Z) {
        Z.left = SingleRotateRight(Z.left);
        return SingleRotateLeft(Z);
    }

    private AVLTreeNode SingleRotateLeft(AVLTreeNode X) {
        AVLTreeNode W = X.left;
        X.left = W.right;
        W.right = X;
        X.height = Math.max(Height(X.left), Height(X.right)) + 1;
        W.height = Math.max(Height(W.left), X.height)+1;
        return W;
    }

    private AVLTreeNode SingleRotateRight(AVLTreeNode W) {
        AVLTreeNode X = W.right;
        W.right = X.left;
        X.left = W;
        W.height = Math.max(Height(W.left), Height(W.right))+1;
        X.height = Math.max(Height(X.right), W.height) + 1;
        return X;
    }

    public int Height(AVLTreeNode root) {
        if (root == null) {
            return -1;
        } else {
            return root.height;
        }
    }
}
