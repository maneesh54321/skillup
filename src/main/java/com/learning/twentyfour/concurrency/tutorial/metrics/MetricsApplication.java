package com.learning.twentyfour.concurrency.tutorial.metrics;

public class MetricsApplication {

	public static void main(String[] args) {
		MetricsCollector metricsCollector = new MetricsCollector();

		BusinessLogic businessLogic1 = new BusinessLogic(metricsCollector);
		BusinessLogic businessLogic2 = new BusinessLogic(metricsCollector);

		MetricsPrinter metricsPrinter = new MetricsPrinter(metricsCollector);

		businessLogic1.start();
		businessLogic2.start();
		metricsPrinter.start();
	}

}
