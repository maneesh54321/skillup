package com.learning.twentythree.dsalgo.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class InsertionSortList {

    public static void main(String[] args) {
//        ListNode n8 = new ListNode(23, null);
//        ListNode n7 = new ListNode(4, n8);
//        ListNode n6 = new ListNode(8, n7);
//        ListNode n5 = new ListNode(11, n6);
//        ListNode n4 = new ListNode(1, n5);
//        ListNode n3 = new ListNode(2, n4);
//        ListNode n2 = new ListNode(7, n3);
//        ListNode n1 = new ListNode(6, n2);

        ListNode n3 = new ListNode(3, null);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

//        ListNode sorted = sort1(n1);
//
//        printIntegerLinkedList(sorted);
//
//        sorted = ReverseLinkedList.reverse(sorted);
//
//        printIntegerLinkedList(sorted);

//        ListNode result = ReverseNodeBetween.reverseBetween(n1, 2, 3);
//        printIntegerLinkedList(result);
    }

    static ListNode sort(ListNode A){
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        ListNode currPointer = A;
        ListNode result = new ListNode(Integer.MIN_VALUE);
        result.next = A;
        stack1.add(result);
        while (currPointer != null) {
            if(currPointer.val < stack1.peek().val){
                while(currPointer.val < stack1.peek().val){
                    stack2.push(stack1.pop());
                }
                stack1.peek().next = currPointer;
                stack1.push(currPointer);
                currPointer = currPointer.next;
                stack1.peek().next = stack2.peek();
                while (!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
                stack1.peek().next = currPointer;
            } else {
                stack1.push(currPointer);
                currPointer = currPointer.next;
            }
        }
        return  result.next;
    }

    static ListNode sort1(ListNode A){
        ListNode prev  = null;
        ListNode curr = A;
        ListNode next = A.next;
        while(true) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr == null){
                break;
            }
            next = next.next;
            prev = insertionSort(prev);
        }
        return  prev;
    }

    private static ListNode insertionSort(ListNode head) {
        ListNode result = new ListNode(Integer.MAX_VALUE);
        result.next = head;
        ListNode prev = result;
        while(head.next!=null && head.val < head.next.val){
            prev.next = head.next;
            head.next = head.next.next;
            prev = prev.next;
            prev.next = head;
        }
        return result.next;
    }
}


