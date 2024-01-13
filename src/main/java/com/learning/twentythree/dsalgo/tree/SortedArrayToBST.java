package com.learning.twentythree.dsalgo.tree;

public class SortedArrayToBST {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        SortedArrayToBST main = new SortedArrayToBST();

        System.out.println(levelOrderTraversal.levelOrder(main.construct(arr, 0, arr.length-1)));

    }

    private BinaryTreeNode construct(int[] arr, int l, int r){
        if(r < l){
            return null;
        }

        int mid = l + (r-l)/2;

        return new BinaryTreeNode(arr[mid], construct(arr, l, mid-1), construct(arr, mid+1, r));
    }
}
