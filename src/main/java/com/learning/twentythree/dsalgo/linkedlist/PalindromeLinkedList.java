package com.learning.twentythree.dsalgo.linkedlist;

public class PalindromeLinkedList {

    public static void main(String[] args) {
//        ListNode n4 = new ListNode(2, null);
//        ListNode n3 = new ListNode(1, n4);
        ListNode n2 = new ListNode(1, null);
        ListNode n1 = new ListNode(1, n2);

        System.out.println(lPalin(n1));
    }

    public static int lPalin(ListNode A) {
        if(A==null || A.next==null){
            return 1;
        }
        ListNode midPointer = findMid(A);
        // Reverse the Linked List from midPointer.next
        ListNode prev = null;
        ListNode curr = midPointer.next;
        ListNode next = curr.next;

        while(true) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr == null){
                break;
            }
            next = curr.next;
        }

        midPointer.next = prev;
        ListNode p1 = A;
        ListNode p2 = midPointer.next;
        while (p2!=null){
            if(p1.val != p2.val){
                return 0;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return 1;
    }

    public static ListNode findMid(ListNode A){
        ListNode fastPointer = A;
        ListNode slowPointer = A;
        while(true){
            if(fastPointer.next == null || fastPointer.next.next == null){
                return slowPointer;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
    }
}
