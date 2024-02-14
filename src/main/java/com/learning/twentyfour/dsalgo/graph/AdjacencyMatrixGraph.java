package com.learning.twentyfour.dsalgo.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

	private final boolean[][] edgeMatrix;

	private final int vertexCount;

	public AdjacencyMatrixGraph(int vertexCount) {
		this.vertexCount = vertexCount;
		edgeMatrix = new boolean[vertexCount +1][vertexCount +1];
	}

	@Override
	public void addEdge(int u, int v) {
		if(u < 0 || u > vertexCount || v < 0 || v > vertexCount){
			return;
		}
		edgeMatrix[u][v] = true;
		edgeMatrix[v][u] = true;
	}

	@Override
	public void removeEdge(int u, int v) {
		if(u < 0 || u > vertexCount || v < 0 || v > vertexCount){
			return;
		}
		edgeMatrix[u][v] = false;
		edgeMatrix[v][u] = false;
	}

	@Override
	public boolean isEdge(int u, int v) {
		if(u < 0 || u > vertexCount || v < 0 || v > vertexCount){
			return false;
		}
		return edgeMatrix[u][v];
	}

	@Override
	public int getVertexCount() {
		return vertexCount;
	}

	@Override
	public List<Integer> getAllConnectedVertices(Integer vertex) {
		List<Integer> result = new ArrayList<>();
		if(vertex < 0 || vertex > vertexCount) return result;
		for (int i = 1; i <= vertexCount; i++) {
			if(edgeMatrix[vertex][i]){
				result.add(i);
			}
		}
		return result;
	}
}
