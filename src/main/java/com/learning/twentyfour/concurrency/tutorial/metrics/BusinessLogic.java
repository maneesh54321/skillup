package com.learning.twentyfour.concurrency.tutorial.metrics;

import java.util.Random;

public class BusinessLogic extends Thread {

	private final Random random;

	private final MetricsCollector metricsCollector;

	public BusinessLogic(MetricsCollector metricsCollector) {
		this.random = new Random();
		this.metricsCollector = metricsCollector;
	}

	@Override
	public void run() {
		while (true) {
			long begin = System.currentTimeMillis();
			try {
				Thread.sleep(random.nextInt(10));
			} catch (InterruptedException e) {
			}
			long end = System.currentTimeMillis();
			metricsCollector.addSample(end - begin);
		}
	}
}
