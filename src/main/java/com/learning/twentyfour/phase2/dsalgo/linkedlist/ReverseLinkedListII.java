package com.learning.twentyfour.phase2.dsalgo.linkedlist;

public class ReverseLinkedListII {

	public static void main(String[] args) {

	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {

		if(left == right) return head;

		ListNode leftNode = null;

		ListNode result = new ListNode();
		result.next = head;
		ListNode curr = head;
		ListNode prev = result;

		int i = 0;
		while (curr != null) {
			if (i == left) {
				leftNode = prev;
				break;
			}
			prev = curr;
			curr = curr.next;
			i++;
		}

		ListNode tail = curr;
		prev = null;
		while (curr != null) {
			if(i == right) {
				leftNode.next = curr;
				tail.next = curr.next;
				curr.next = prev;
				break;
			}
			ListNode tmp = curr.next;
			curr.next = prev;
			curr = tmp;
			prev = curr;
			i++;
		}
		return result.next;
	}
}
