package com.learning.twentyfour.dsalgo.linkedlist;

public class OddEvenLinkedList {

	public static void main(String[] args) {

	}

	public static ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		int count = 1;
		ListNode curr = head;
		ListNode oddHead = new ListNode(0);
		ListNode currOdd = oddHead;
		ListNode evenHead = new ListNode(0);
		ListNode currEven = evenHead;
		while (curr!= null){
			if(count%2 == 0){
				currEven.next = curr;
				currEven = currEven.next;
			} else {
				currOdd.next = curr;
				currOdd = currOdd.next;
			}
			curr = curr.next;
			currEven.next = null;
			count++;
		}
		currOdd.next = evenHead.next;
		return oddHead.next;
	}
}
