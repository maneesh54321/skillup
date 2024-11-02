package com.learning.twentyfour.concurrency;

public class VolatileTesting {

	public static void main(String[] args) {
		VolatileLong volatileLong = new VolatileLong();

		Runnable incrementer = () -> {
			int n = 10_000;
			while (n >= 0) {
				volatileLong.increment();
				n--;
			}
		};
		Runnable decrementer = () -> {
			int n = 10_000;
			while (n >= 0) {
				volatileLong.decrement();
				n--;
			}
		};

		Thread thread1 = new Thread(incrementer);
		Thread thread2 = new Thread(decrementer);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
			System.out.println(volatileLong.getValue());
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private static class VolatileLong {

		private long value = 0;

		public synchronized void increment () {
			value++;
		}

		public synchronized void decrement () {
			value--;
		}

		public long getValue(){
			return value;
		}
	}
}
