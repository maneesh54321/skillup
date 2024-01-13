package com.learning.twentythree.dsalgo.linkedlist;

import com.learning.twentythree.dsalgo.Utils.IOUtils;

public class DeleteDupesSoredLinkedList {
    public static void main(String[] args) {
//        ListNode n4 = new ListNode(4, null);
        ListNode n3 = new ListNode(2, null);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        IOUtils.printIntegerLinkedList(deleteDuplicates(n1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(Integer.MIN_VALUE);
        result.next = head;
        ListNode last = result;
        ListNode prev = head;
        ListNode curr = head.next;
        boolean duped = false;
        while (curr!=null){
            if(prev.val == curr.val){
                curr = curr.next;
                prev.next = curr;
                duped = true;
            } else if (duped) {
                prev = curr;
                curr = curr.next;
                last.next = prev;
                duped = false;
            } else {
                last = prev;
                prev = curr;
                curr = curr.next;
            }
        }
        if(duped){
            last.next = null;
        }
        return result.next;
    }
}
