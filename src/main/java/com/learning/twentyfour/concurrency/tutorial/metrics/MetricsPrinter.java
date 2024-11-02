package com.learning.twentyfour.concurrency.tutorial.metrics;

public class MetricsPrinter extends Thread {

	private final MetricsCollector metricsCollector;

	public MetricsPrinter(MetricsCollector metricsCollector) {
		this.metricsCollector = metricsCollector;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Current average: " + metricsCollector.getAverage());
				Thread.sleep(5);
			} catch (InterruptedException e) {
			}
		}
	}
}
