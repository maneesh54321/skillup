package com.learning.twentythree.dsalgo.linkedlist;

import com.learning.twentythree.dsalgo.Utils.IOUtils;

class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList ls = new MyLinkedList();

//        ls.addAtHead(1);
//        ls.addAtTail(3);
        ls.addAtIndex(0,10);
        ls.addAtIndex(0,20);
        ls.addAtIndex(1,30);
        ls.print();
        ls.get(0);
//        ls.deleteAtIndex(0);
//        ls.print();
//        ls.get(0);
//        ls.addAtHead(6);

    }
    int size = 0;
    ListNode head;
    ListNode end;
    ListNode actualHead;

    public MyLinkedList() {
        actualHead = new ListNode(-1, null);
        head = actualHead.next;
        end = head;
    }

    public void print(){
        System.out.println("MyLinkedList:");
        IOUtils.printIntegerLinkedList(this.head);
        System.out.println();
    }

    public int get(int index) {
        if(index >= size){
            return -1;
        }
        ListNode curr = head;
        for(int i=1; i<=index; i++){
            curr = curr.next;
        }
        System.out.println(curr.val);
        return curr.val;
    }

    public void addAtHead(int val) {
        actualHead.next = new ListNode(val, head);
        head = actualHead.next;
        size++;
        if(end==null){
            end = actualHead.next;
        }
    }

    public void addAtTail(int val) {
        if(end == null){
            end = new ListNode(val, null);
            head = end;
            actualHead.next = head;
        } else {
            end.next = new ListNode(val, null);
            end = end.next;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        ListNode prev = actualHead;
        ListNode curr = head;
        for(int i=1; i<=index; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = new ListNode(val, curr);
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index>=size){
            return;
        }
        ListNode prev = actualHead;
        ListNode curr = head;
        for(int i=1; i<=index; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        if(index == 0){
            head = actualHead.next;
            if(size == 1){
                end = actualHead.next;
            }
        }
        if(index == size-1){
            end = prev;
        }
        curr.next = null;
        size--;
    }
}
