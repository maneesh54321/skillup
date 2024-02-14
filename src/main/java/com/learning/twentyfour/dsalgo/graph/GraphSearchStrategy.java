package com.learning.twentyfour.dsalgo.graph;

public interface GraphSearchStrategy {
	boolean findNode(Graph graph, int node);

	void print(Graph graph);
}
