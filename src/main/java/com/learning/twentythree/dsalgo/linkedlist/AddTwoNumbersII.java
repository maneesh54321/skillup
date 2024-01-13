package com.learning.twentythree.dsalgo.linkedlist;

import com.learning.twentythree.dsalgo.Utils.IOUtils;

public class AddTwoNumbersII {

    public static void main(String[] args) {
        ListNode l1_4 = new ListNode(3);
        ListNode l1_3 = new ListNode(4, l1_4);
        ListNode l1_2 = new ListNode(2, l1_3);
        ListNode l1_1 = new ListNode(7, l1_2);

        ListNode l2_3 = new ListNode(4);
        ListNode l2_2 = new ListNode(6, l2_3);
        ListNode l2_1 = new ListNode(5, l2_2);

        ListNode result = new AddTwoNumbersII().addTwoNumbers(l1_1, l2_1);

        IOUtils.printIntegerLinkedList(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode result = new ListNode(-1);
        ListNode resultCurr = result;

        int carryOver = 0;

        while (l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int currentSum = num1 + num2 + carryOver;
            carryOver = currentSum / 10;

            resultCurr.next = new ListNode(currentSum % 10);
            resultCurr = resultCurr.next;
        }

        if (carryOver != 0) {
            resultCurr.next = new ListNode(carryOver);
        }

        return reverse(result.next);
    }

    public ListNode reverse(ListNode l1) {
        ListNode curr = l1;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
