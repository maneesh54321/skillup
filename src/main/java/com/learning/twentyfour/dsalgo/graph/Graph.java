package com.learning.twentyfour.dsalgo.graph;

import java.util.List;

public interface Graph {
	void addEdge(int u, int v);
	void removeEdge(int u, int v);
	boolean isEdge(int u, int v);

	int getVertexCount();

	List<Integer> getAllConnectedVertices(Integer vertex);
}
