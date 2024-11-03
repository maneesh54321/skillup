package com.learning.twentyfour.phase2.dsalgo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public final class MatrixGraph implements Graph, PathAwareGraph {

	private final int[][] matrix;

	public MatrixGraph(int numOfNodes) {
		matrix = new int[numOfNodes + 1][numOfNodes + 1];
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = Integer.MIN_VALUE;
			}
		}
	}

	@Override
	public void addEdge(int u, int v) {
		if ((u > 0 && u < matrix.length) && (v > 0 && v < matrix.length)) {
			matrix[u][v] = 1;
			matrix[v][u] = 1;
		}
	}

	@Override
	public void addEdge(int u, int v, int weight) {
		if ((u > 0 && u < matrix.length) && (v > 0 && v < matrix.length)) {
			matrix[u][v] = weight;
			matrix[v][u] = weight;
		}
	}

	@Override
	public boolean hasEdge(int u, int v) {
		if ((u > 0 && u < matrix.length) && (v > 0 && v < matrix.length)) {
			return matrix[u][v] != Integer.MIN_VALUE && matrix[v][u] != Integer.MIN_VALUE;
		}
		return false;
	}

	@Override
	public List<Edge> getIncidentEdges(int source) {
		var result = new ArrayList<Edge>();

		for (int i = 1; i < matrix.length; i++) {
			if (source != i && matrix[source][i] != Integer.MIN_VALUE) {
				result.add(new Edge(source, i, matrix[source][i]));
			}
		}
		return result;
	}

	@Override
	public void deleteEdge(int u, int v) {
		if ((u > 0 && u < matrix.length) && (v > 0 && v < matrix.length)) {
			matrix[u][v] = Integer.MIN_VALUE;
			matrix[v][u] = Integer.MIN_VALUE;
		}
	}

	@Override
	public int[] dfs(int source) {
		return new int[0];
	}

	@Override
	public int[] bfs(int source) {
		return new int[0];
	}

	@Override
	public int[] findShortestPathToAllNodes(int source) {

		var distance = new int[matrix.length];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;

		var queue = new PriorityQueue<Edge>();
		Edge sourceEdge = new Edge(-1, 1, 0);
		queue.add(sourceEdge);

		int[] color = new int[matrix.length];
		color[sourceEdge.dst()] = 1;

		int[] path = new int[matrix.length];
		path[sourceEdge.dst()] = -1;

		while (!queue.isEmpty()) {
			Edge minWeightEdge = queue.poll();
			int src = minWeightEdge.dst();
			if(color[src] == 1) {
				int u = distance[src];
				var incidentEdges = getIncidentEdges(src);
				for (Edge edge : incidentEdges) {
					int dst = edge.dst();
					if(color[dst] != 2) {
						int pathWeight = edge.weight();
						int currDistance = distance[dst];
						int v = u + pathWeight;
						if (v < currDistance) {
							distance[dst] = v;
							path[dst] = src;
							queue.offer(edge);
							color[dst] = 1;
						}
					}
				}
				color[src] = 2;
			}
		}

		System.out.println(Arrays.toString(path));
		return distance;
	}

	@Override
	public int[] findShortestPathToAllNodesNonWeighted(int source) {
		var shortestPaths = new int[matrix.length];
		Arrays.fill(shortestPaths, -1);

		var queue = new LinkedList<Edge>();
		queue.add(new Edge(-1, 1, 0));
		queue.add(null);

		int distance = 0;

		while (!queue.isEmpty()) {
			var front = queue.poll();
			if(front == null) {
				if(queue.isEmpty()) break;
				distance++;
				queue.add(null);
			} else {
				var dst = front.dst();
				if(shortestPaths[dst] == -1) {
					shortestPaths[dst] = distance;
				}
				var incidentEdges = getIncidentEdges(dst);
				for (Edge incidentEdge: incidentEdges) {
					if(shortestPaths[incidentEdge.dst()] == -1) {
						queue.offer(incidentEdge);
					}
				}
			}
		}

		return shortestPaths;
	}
}
