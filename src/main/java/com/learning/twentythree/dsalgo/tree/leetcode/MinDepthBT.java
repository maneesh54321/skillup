package com.learning.twentythree.dsalgo.tree.leetcode;

import com.learning.twentythree.dsalgo.tree.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MinDepthBT {
    public static void main(String[] args) {

    }

    public int minDepth(BinaryTreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<BinaryTreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        int depth = 0;

        while (!q.isEmpty()) {
            BinaryTreeNode top = q.poll();
            if (top == null) {
                depth++;
                if(q.isEmpty()){
                    return depth;
                }
                q.offer(null);
            } else {
                int child = 0;
                if (top.left != null) {
                    q.offer(top.left);
                    child++;
                }
                if (top.right != null) {
                    q.offer(top.right);
                    child++;
                }
                if (child == 0) {
                    return depth+1;
                }
            }
        }

        return depth;
    }
}
