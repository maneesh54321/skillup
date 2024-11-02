package com.learning.twentyfour.phase2.dsalgo.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remainder = 0;

        ListNode result = new ListNode();
        ListNode curr = result;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val+ remainder;
            remainder = sum / 10;
            curr.next = new ListNode(sum % 10);

            curr = curr.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + remainder;
            remainder = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + remainder;
            remainder = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l2 = l2.next;
        }

        if(remainder != 0) {
            curr.next = new ListNode(remainder);
        }

        return result.next;
    }
}
