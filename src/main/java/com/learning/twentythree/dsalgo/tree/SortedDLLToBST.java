package com.learning.twentythree.dsalgo.tree;

public class SortedDLLToBST {

    public static void main(String[] args) {
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, node7, null);
        BinaryTreeNode node6 = new BinaryTreeNode(13, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(16, node6, null);
        BinaryTreeNode node2 = new BinaryTreeNode(6, node4, node9);
        BinaryTreeNode node1 = new BinaryTreeNode(10, node2, node3);

        BSTToSortedDLL bstToDLL = new BSTToSortedDLL();
        BinaryTreeNode head = bstToDLL.convert(node1);

        SortedDLLToBST main = new SortedDLLToBST();
        main.head = head;
        BinaryTreeNode finalTree = main.convert(main.head);

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        System.out.println(levelOrderTraversal.levelOrder(finalTree));
    }

    public BinaryTreeNode convert(BinaryTreeNode head) {
        int len = 0;
        BinaryTreeNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.right;
        }
        return construct( 0, len - 1);
    }

    public BinaryTreeNode convert(BinaryTreeNode head, int l, int r) {
        if (head == null || r < l) {
            return null;
        }
        int mid = l + (r - l) / 2;
        int index = l;
        BinaryTreeNode curr = head;
        while (index != mid) {
            curr = curr.right;
            index++;
        }

        curr.left = convert(head, l, mid - 1);
        curr.right = convert(curr.right, mid + 1, r);

        return curr;

    }

    private BinaryTreeNode head;

    public BinaryTreeNode construct(int l, int r) {
        if (r < l)
            return null;

        int mid = l + (r - l) / 2;

        BinaryTreeNode left = construct( l, mid-1);

        BinaryTreeNode root = new BinaryTreeNode(head.data, left, null);

        if(head.right != null) {
            head = head.right;
            root.right = construct(mid +1, r);
        }

        return root;
    }
}
