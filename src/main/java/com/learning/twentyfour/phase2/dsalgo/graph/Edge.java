package com.learning.twentyfour.phase2.dsalgo.graph;

public record Edge(int src, int dst, int weight) implements Comparable<Edge> {

	@Override
	public int compareTo(Edge o) {
		if(weight == o.weight()) return Integer.compare(src, o.src());
		return Integer.compare(weight, o.weight());
	}
}
