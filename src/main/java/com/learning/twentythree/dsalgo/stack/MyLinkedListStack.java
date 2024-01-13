package com.learning.twentythree.dsalgo.stack;

import com.learning.twentythree.dsalgo.linkedlist.ListNode;

public class MyLinkedListStack {

    public static void main(String[] args) {
        MyLinkedListStack s = new MyLinkedListStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.print("Elements present in stack :");
        s.print();
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in stack :");
        s.print();
    }
    private ListNode head;

    private int size;

    public MyLinkedListStack() {
        this.head = new ListNode(0, null);
        this.size = 0;
    }

    public boolean push(int value) {
        head.next = new ListNode(value, head.next);
        System.out.println(value + " pushed into stack");
        size++;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int value = this.head.next.val;
            this.head.next = this.head.next.next;
            size--;
            return value;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return Integer.MAX_VALUE;
        } else {
            return this.head.next.val;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        ListNode curr = head.next;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
