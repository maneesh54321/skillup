package com.learning.twentyfour.dsalgo.linkedlist;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carryOver = 0;
		ListNode head = new ListNode(0);
		ListNode curr = head;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carryOver;
			carryOver = sum >= 10 ? 1 : 0;
			curr.next = new ListNode(sum % 10);
			l1 = l1.next;
			l2 = l2.next;
			curr = curr.next;
		}
		ListNode remNodes;
		if (l1 == null) {
			remNodes = l2;
		} else {
			remNodes = l1;
		}
		if (remNodes != null) {
			while (remNodes != null) {
				if (carryOver == 0) {
					curr.next = remNodes;
					break;
				}
				int sum = remNodes.val + carryOver;
				curr.next = new ListNode(sum % 10);
				carryOver = sum >= 10 ? 1 : 0;
				remNodes = remNodes.next;
				curr = curr.next;
			}
		}
		if(carryOver == 1){
			curr.next = new ListNode(1);
		}
		return head.next;
	}
}
