package com.learning.twentythree.dsalgo.stack;

public class MyArrayStack {

    public static void main(String args[])
    {
        MyArrayStack s = new MyArrayStack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.top());
        System.out.print("Elements present in stack :");
        s.print();
    }
    private int[] arr;

    private int MAX_SIZE;

    private int topIndex = -1;

    public MyArrayStack(int maxSize) {
        MAX_SIZE = maxSize;
        this.arr = new int[MAX_SIZE];
    }

    public boolean push(int val){
        if(topIndex+1 >= MAX_SIZE){
            System.out.println("Stack Overflow");
            return false;
        }
        arr[++topIndex] = val;
        System.out.println(val + " pushed into stack");
        return true;
    }

    public int pop(){
        if(topIndex>-1){
            return arr[topIndex--];
        }
        System.out.println("Stack Underflow");
        return 0;
    }

    public int top(){
        if(topIndex>-1){
            return arr[topIndex];
        }
        System.out.println("Stack Underflow");
        return 0;
    }

    public boolean isEmpty(){
        return topIndex < 0;
    }

    public int size(){
        return topIndex+1;
    }

    public void print(){

    }
}
