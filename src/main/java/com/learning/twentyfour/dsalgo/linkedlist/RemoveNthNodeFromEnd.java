package com.learning.twentyfour.dsalgo.linkedlist;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode curr = head;
		ListNode node = null;
		ListNode prev = null;
		while (curr != null) {
			n--;
			if(n == 0){
				node = head;
			}
			if(n < 0){
				prev = node;
				node = node.next;
			}
			curr = curr.next;
		}
		if(n > 0){
			return head;
		}
		if(n == 0) {
			head = head.next;
			return head;
		}
		prev.next = node.next;
		return head;
	}

}
