package com.learning.twentyfour.dsalgo.linkedlist;

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null) {
			return headB;
		}
		if (headB == null) {
			return headA;
		}
		if(headA == headB){
			return headA;
		}
		ListNode currA = headA;
		while (currA.next != null) {
			currA = currA.next;
		}
		ListNode currB = headB;
		while (currB.next != null) {
			currB = currB.next;
		}
		if(currA != currB){
			return null;
		}
		currA.next = headA;
		ListNode slowPtr = headB;
		ListNode fastPtr = headB;
		while (true) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(fastPtr == slowPtr){
				break;
			}
		}
		slowPtr = headB;
		while (true) {
			if(fastPtr == slowPtr){
				currA.next = null;
				return fastPtr;
			}
			fastPtr = fastPtr.next;
			slowPtr = slowPtr.next;
		}
	}
}
