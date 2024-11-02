package com.learning.twentyfour.concurrency.tutorial.metrics;

public class MetricsCollector {

	private long count = 0;

	private double average = 0.0;

	public synchronized void addSample(long sample){
		double currentSample = average * count;
		average = 10000000.000;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		count++;
		average = (currentSample + sample) / count;
	}

	public double getAverage(){
		return average;
	}
}
