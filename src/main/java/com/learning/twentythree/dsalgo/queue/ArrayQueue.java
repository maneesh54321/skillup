package com.learning.twentythree.dsalgo.queue;

public class ArrayQueue {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
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

    int front;
    int rear;

    int capacity;

    int size;

    int[] arr;

    public ArrayQueue(int capacity) {
        rear = capacity-1;
        this.capacity = capacity;
        arr = new int[capacity];
        front = size = 0;
    }

    public boolean enqueue(int value) {
        if(isFull()){
            System.out.println("Queue full!!");
            return false;
        }
        rear = (rear+1)%capacity;
        arr[rear] = value;
        size++;
        System.out.println(value+ " enqueued to the queue!!");
        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue empty!!");
            return Integer.MIN_VALUE;
        } else {
            int value = arr[front % capacity];
            front = (front+1)%capacity;
            size--;
            return value;
        }
    }

    public int front() {
        return arr[front];
    }

    public int rear() {
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = front; i < front+size; i++) {
            System.out.println(arr[i % capacity] + " ");
        }
    }

}
