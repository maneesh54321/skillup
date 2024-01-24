package com.learning.twentyfour.dsalgo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PseudoPalindromicPaths {
    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
//        List<Integer> list = new ArrayList<>();
        int[] freq = new int[10];
        System.out.println(pseudoPalindromicPaths(node1, freq, 0));
    }

    public static int pseudoPalindromicPaths (BinaryTreeNode root) {
        int[] freq = new int[10];
        return pseudoPalindromicPaths(root, freq, 0);
    }
    public static int pseudoPalindromicPaths (BinaryTreeNode root, int[] freq, int odds) {
        freq[root.val]++;
        if(freq[root.val] % 2 == 0){
            odds--;
        } else {
            odds++;
        }
        if (root.left == null && root.right == null) {
            freq[root.val]--;
            if (odds <= 1) {
                return 1;
            } else {
                return 0;
            }
        }
        int left = 0;
        if (root.left != null) {
            left = pseudoPalindromicPaths(root.left, freq, odds);
        }
        int right = 0;
        if (root.right != null) {
            right = pseudoPalindromicPaths(root.right, freq, odds);
        }
        freq[root.val]--;
        return left + right;
    }

    public static boolean pseudoPalindrome(int[] freq) {
        int numOfOdds = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] % 2 != 0) {
                numOfOdds++;
            }
        }
        return numOfOdds <= 1;
    }
}
