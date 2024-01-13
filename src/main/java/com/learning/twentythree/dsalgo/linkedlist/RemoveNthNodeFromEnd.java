package com.learning.twentythree.dsalgo.linkedlist;

import com.learning.twentythree.dsalgo.Utils.IOUtils;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
//        ListNode n4 = new ListNode(4, null);
//        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, null);
        ListNode n1 = new ListNode(1, n2);

        IOUtils.printIntegerLinkedList(removeNthFromEnd(n1, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;
        while(curr != null) {
            curr = curr.next;
            length++;
        }
        int m=1;
        if(n<=length){
            m = length - n + 1;
        }
        ListNode result = new ListNode(Integer.MIN_VALUE);
        result.next = head;
        curr = head;
        ListNode prev = result;
        int i = 1;
        while (i<m) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        prev.next = curr.next;

        return result.next;
    }
}
