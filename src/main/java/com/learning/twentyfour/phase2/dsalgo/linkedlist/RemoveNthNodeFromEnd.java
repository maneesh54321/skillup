package com.learning.twentyfour.phase2.dsalgo.linkedlist;

public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head.next == null && n ==1) return null;

		ListNode result = new ListNode();
		result.next = head;
		ListNode p2 = result;
		ListNode p1 = result;

		ListNode p3 = null;
		int count = 0;

		while(p1.next != null){
			p1 = p1.next;
			count++;
			if(count >= n) {
				p3 = p2;
				p2 = p2.next;
			}
		}

		p3.next = p2.next;

		return result.next;
	}
}
