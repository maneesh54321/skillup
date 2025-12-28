package com.learning.twentysix.twopointers;

public class RemoveNthNode {

	public static ListNode removeNthLastNode(ListNode head, int n) {

		// Replace this placeholder return statement with your code

		ListNode right = new ListNode(-1);
		right.next = head;

		while(n > 0) {
			right = right.next;
			n--;
		}

		ListNode left = new ListNode(-1);
		left.next = head;

		if (right.next == null) {
			return head.next;
		}

		while (right.next != null) {
			left = left.next;
			right = right.next;
		}

		left.next = left.next.next;

		return head;
	}

	public static class ListNode {

		int val;
		ListNode next;

		// Constructor
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
}
