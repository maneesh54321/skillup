package com.learning.twentythree.dsalgo.stack;

import com.learning.twentythree.dsalgo.Utils.IOUtils;
import com.learning.twentythree.dsalgo.linkedlist.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbersII {

    public static void main(String[] args) {
        ListNode l1_4 = new ListNode(3);
        ListNode l1_3 = new ListNode(4, l1_4);
        ListNode l1_2 = new ListNode(2, l1_3);
        ListNode l1_1 = new ListNode(7, l1_2);

        ListNode l2_3 = new ListNode(4);
        ListNode l2_2 = new ListNode(6, l2_3);
        ListNode l2_1 = new ListNode(5, l2_2);

        ListNode result = new AddTwoNumbersII().addTwoNumbers(l1_1, l2_1);

        IOUtils.printIntegerLinkedList(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> l1Stack = new LinkedList<>();
        Deque<Integer> l2Stack = new LinkedList<>();
        Deque<Integer> resultStack = new LinkedList<>();

        while (l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }

        int carryOver = 0;

        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            int num1 = l1Stack.peek() != null ? l1Stack.pop() : 0;
            int num2 = l2Stack.peek() != null ? l2Stack.pop() : 0;

            int currentSum = num1 + num2 + carryOver;

            carryOver = currentSum / 10;

            resultStack.push(currentSum % 10);
        }

        while (carryOver != 0) {
            resultStack.push(carryOver % 10);
            carryOver = carryOver / 10;
        }

        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while (!resultStack.isEmpty()) {
            curr.next = new ListNode(resultStack.pop());
            curr = curr.next;
        }

        return result.next;
    }
}
