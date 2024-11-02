package com.learning.twentyfour.phase2.dsalgo.linkedlist;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();

        ListNode curr = result;

        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curr.next = list1;
                curr = curr.next;

                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = curr.next;

                list2 = list2.next;
            }
        }

        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }

        return result.next;

    }
}
