package com.learning.twentythree.dsalgo.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (true) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr == null){
                break;
            }
            next = curr.next;
        }
        return prev;
    }

}
