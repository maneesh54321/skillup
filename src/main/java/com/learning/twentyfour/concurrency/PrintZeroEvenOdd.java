package com.learning.twentyfour.concurrency;

import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {

    private int n;

    private Object lock = new Object();
    private Object lock0 = new Object();

    private boolean oddPrinted = false;
    private boolean evenPrinted = true;

    private boolean zeroPrinted = false;

    public PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock0){
                if(zeroPrinted){
                    lock0.wait();
                }
                printNumber.accept(0);
                zeroPrinted = true;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            synchronized (lock) {
                if(!oddPrinted){
                    lock.wait();
                }
                synchronized (lock0){
                    if(!zeroPrinted){
                        lock0.notify();
                    }
                }
                while (!zeroPrinted) {}
                printNumber.accept(i);
                evenPrinted = true;
                zeroPrinted = false;
                oddPrinted = false;
                lock.notify();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            synchronized (lock) {
                if(!evenPrinted){
                    lock.wait();
                }
                synchronized (lock0){
                    if(!zeroPrinted){
                        lock0.notify();
                    }
                }
                while (!zeroPrinted) {}
                printNumber.accept(i);
                oddPrinted = true;
                zeroPrinted = false;
                evenPrinted = false;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        IntConsumer consumer = System.out::println;

        PrintZeroEvenOdd printZeroEvenOdd = new PrintZeroEvenOdd(5);
        Thread t0 = new Thread(() -> {
            try {
                printZeroEvenOdd.zero(consumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread tOdd = new Thread(() -> {
            try {
                printZeroEvenOdd.odd(consumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread tEven = new Thread(() -> {
            try {
                printZeroEvenOdd.even(consumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t0.start();
        tOdd.start();
        tEven.start();
    }
}
