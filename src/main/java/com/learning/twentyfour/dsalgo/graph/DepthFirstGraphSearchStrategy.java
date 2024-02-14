package com.learning.twentyfour.dsalgo.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class DepthFirstGraphSearchStrategy implements GraphSearchStrategy {

	@Override
	public boolean findNode(Graph graph, int node) {
		Deque<Integer> stack = new ArrayDeque<>();
		int startNode = 1;
		boolean[] visited = new boolean[graph.getVertexCount() + 1];
		visited[startNode] = true;
		stack.push(startNode);
		while (!stack.isEmpty()) {
			Integer top = stack.pop();
			if (top == node) {
				return true;
			}
			for (Integer vertex : graph.getAllConnectedVertices(top)) {
				if (!visited[vertex]) {
					stack.push(vertex);
					visited[vertex] = true;
				}
			}
		}
		return false;
	}

	@Override
	public void print(Graph graph) {
		Deque<Integer> stack = new ArrayDeque<>();
		int startNode = 1;
		boolean[] visited = new boolean[graph.getVertexCount() + 1];
		visited[startNode] = true;
		stack.push(startNode);
		while (!stack.isEmpty()) {
			Integer top = stack.pop();
			System.out.println(top);
			for (Integer vertex : graph.getAllConnectedVertices(top)) {
				if (!visited[vertex]) {
					visited[vertex] = true;
					stack.push(vertex);
				}
			}
		}
	}
}
