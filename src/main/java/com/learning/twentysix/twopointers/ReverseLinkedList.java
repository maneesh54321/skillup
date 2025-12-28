package com.learning.twentysix.twopointers;

public class ReverseLinkedList {

	public static void main(String[] args) {
		var n6 = new ListNode(6);
		var n5 = new ListNode(5, n6);
		var n4 = new ListNode(4, n5);
		var n3 = new ListNode(3, n4);
		var n2 = new ListNode(2, n3);
		var head = new ListNode(1, n2);

		print(head);

		var rll = reverseLL(head);

		print(rll);
	}

	private static void print(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode prev = null;
		ListNode curr = head;

		while(head != null) {
			head = head.next;
			curr.next = prev;
			prev = curr;
			if(head != null) {
				curr = head;
			}
		}

		return curr;
	}

	public static class ListNode {

		int val;
		ListNode next;

		// Constructor
		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
