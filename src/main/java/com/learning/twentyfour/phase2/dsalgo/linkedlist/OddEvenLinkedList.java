package com.learning.twentyfour.phase2.dsalgo.linkedlist;

public class OddEvenLinkedList {
    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode evenListHead = new ListNode();

        ListNode curr = head;
        ListNode even = evenListHead;
        ListNode prev = null;

        while (curr != null && curr.next != null) {
            even.next = curr.next;
            curr.next = curr.next.next;

            even = even.next;
            even.next = null;
            prev = curr;
            curr = curr.next;
        }

        if(curr != null) curr.next = evenListHead.next;
        else prev.next = evenListHead.next;

        return head;
    }
}
