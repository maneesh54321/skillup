package com.learning.twentythree.dsalgo.queue;

public class LinkedListQueue {

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(8);
        queue.enqueue(9);
        queue.print();
    }
    class QNode {
        int key;
        QNode next;

        public QNode(int key, QNode next) {
            this.key = key;
            this.next = next;
        }
    }

    int size;

    QNode front;
    QNode rear;
    QNode head;

    public LinkedListQueue(){
        head = new QNode(Integer.MIN_VALUE, null);
        front = head.next;
        rear = head.next;
        size = 0;
    }

    public void enqueue(int value){
        if(isEmpty()){
            head.next = new QNode(value, null);
            rear = head.next;
            front = head.next;
        } else {
            rear.next = new QNode(value, null);
            rear = rear.next;
        }
        size++;
        System.out.println(value + " enqueued to the queue!!");
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty!!");
            return Integer.MIN_VALUE;
        } else{
            int value = head.next.key;
            head.next = head.next.next;
            front = head.next;
            size--;
            return value;
        }
    }

    public int front(){
        if(!isEmpty()){
            return front.key;
        }
        return Integer.MIN_VALUE;
    }

    public int rear(){
        if(!isEmpty()){
            return rear.key;
        }
        return Integer.MIN_VALUE;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void print(){
        if(size() > 0){
            QNode curr = head.next;
            System.out.println("Linked List Queue:");
            while(curr != null){
                System.out.print(curr.key + " ");
                curr = curr.next;
            }
        } else {
            System.out.println("Queue is empty!!!");
        }
    }
}
