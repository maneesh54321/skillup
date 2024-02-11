//package com.learning.twentyfour.concurrency;
//
//public class PrintInOrder {
//
//	public static void main(String[] args) throws InterruptedException {
//		PrintInOrder printInOrder = new PrintInOrder();
//		Thread t1 = new Thread(() -> {
//			try {
//				printInOrder.first(() -> System.out.println("First"));
//			} catch (InterruptedException e) {
//				throw new RuntimeException(e);
//			}
//		});
//		Thread t2 = new Thread(() -> {
//			try {
//				printInOrder.second(() -> System.out.println("Second"));
//			} catch (InterruptedException e) {
//				throw new RuntimeException(e);
//			}
//		});
//		Thread t3 = new Thread(() -> {
//			try {
//				printInOrder.third(() -> System.out.println("Third"));
//			} catch (InterruptedException e) {
//				throw new RuntimeException(e);
//			}
//		});
//		t1.start();
//		t2.start();
//		t3.start();
//
//		t1.join();
//		t2.join();
//		t3.join();
//	}
//
//		public PrintInOrder() {
//
//		}
//
//		private Object lock1 = new Object();
//		private Object lock2 = new Object();
//		private Object lock3 = new Object();
//
//		public void first(Runnable printFirst) throws InterruptedException {
//
//			// printFirst.run() outputs "first". Do not change or remove this line.
//			synchronized (lock1){
//				synchronized (lock2){
//					printFirst.run();
//					lock2.notify();
//				}
//			}
//		}
//
//		public void second(Runnable printSecond) throws InterruptedException {
//
//			// printSecond.run() outputs "second". Do not change or remove this line.
//			synchronized(lock1){
//				if(!firstDone){
//					lock1.wait();
//				}
//				synchronized(lock2){
//					printSecond.run();
//					lock2.notify();
//				}
//			}
//		}
//
//		public void third(Runnable printThird) throws InterruptedException {
//
//			// printThird.run() outputs "third". Do not change or remove this line.
//			synchronized(lock2){
//				if(!secondDone){
//					lock2.wait();
//				}
//				printThird.run();
//			}
//		}
//}
