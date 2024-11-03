package com.learning.twentyfour.phase2.dsalgo.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public final class AdjacencyListGraph implements Graph, PathAwareGraph {

	private LinkedList<Edge>[] store;

	public AdjacencyListGraph(int numOfNodes) {
		store = new LinkedList[numOfNodes + 1];
		for (int i = 1; i < store.length; i++) {
			store[i] = new LinkedList<>();
		}
	}

	@Override
	public void addEdge(int u, int v) {
		if ((u > 0 && u < store.length) && (v > 0 && v < store.length)) {
			store[u].add(new Edge(u, v, 1));
			store[v].add(new Edge(v, u, 1));
		}
	}

	@Override
	public void addEdge(int u, int v, int weight) {
		if ((u > 0 && u < store.length) && (v > 0 && v < store.length)) {
			store[u].add(new Edge(u, v, weight));
			store[v].add(new Edge(v, u, weight));
		}
	}

	@Override
	public boolean hasEdge(int u, int v) {
		if ((u > 0 && u < store.length) && (v >= 0 && v < store[u].size()) &&
				(v > 0 && v < store.length) && (u >= 0 && u < store[v].size())) {
			return store[u].stream().anyMatch(edge -> edge.dst() == v);
		}
		return false;
	}

	@Override
	public List<Edge> getIncidentEdges(int source) {
		if (source > 0 && source < store.length) {
			return store[source].stream().toList();
		}
		return Collections.emptyList();
	}

	@Override
	public void deleteEdge(int u, int v) {
		if ((u > 0 && u < store.length) && (v >= 0 && v < store[u].size()) &&
				(v > 0 && v < store.length) && (u >= 0 && u < store[v].size())) {
			store[u].removeIf(edge -> edge.dst() == v);
			store[v].removeIf(edge -> edge.dst() == u);
		}
	}

	@Override
	public int[] findShortestPathToAllNodes(int source) {
		// distance
		var distance = new int[store.length];
		Arrays.fill(distance, Integer.MAX_VALUE);

		var queue = new PriorityQueue<Edge>();

		var srcIncidentEdge = new Edge(-1, source, 0);
		queue.offer(srcIncidentEdge);
		distance[srcIncidentEdge.dst()] = 0;

		// 0 = unexplored, 1 = discovered, 2 = explored
		int[] color = new int[store.length];
		// marking source node as discovered
		color[srcIncidentEdge.dst()] = 1;

		// to trace the path
		var path = new int[store.length];
		path[srcIncidentEdge.dst()] = -1;

		while (!queue.isEmpty()) {
			var minEdge = queue.poll();
			var src = minEdge.dst();
			if (color[src] == 1) { // if discovered
				var u = distance[src];
				var incidentEdges = this.getIncidentEdges(src);
				for (var incidentEdge : incidentEdges) {
					int dst = incidentEdge.dst();
					if (color[dst] != 2) { // if not explored already
						var v = u + incidentEdge.weight();
						var currDistance = distance[dst];
						if (v < currDistance) {
							distance[dst] = v;
							path[dst] = src;
							queue.offer(incidentEdge);
							color[incidentEdge.dst()] = 1;
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
		var distance = 0;
		int[] distances = new int[store.length];

		var queue = new LinkedList<Edge>();
		Edge srcEdge = new Edge(-1, 1, 0);
		queue.offer(srcEdge);
		queue.offer(null);

		// 0 = unexplored, 1 = explored
		var color = new int[store.length];
		color[srcEdge.dst()] = 1;

		while (!queue.isEmpty()) {
			var front = queue.poll();
			if (front == null) {
				if (queue.isEmpty()) {
					break;
				}
				distance++;
				queue.offer(null);
			} else {
				int src = front.dst();
				distances[src] = distance;
				List<Edge> incidentEdges = getIncidentEdges(src);
				for (var incidentEdge : incidentEdges) {
					if (color[incidentEdge.dst()] == 0) {
						queue.offer(incidentEdge);
						color[incidentEdge.dst()] = 1;
					}
				}
			}
		}

		return distances;
	}

	@Override
	public int[] dfs(int source) {
		boolean[] visited = new boolean[store.length];

		int[] result = new int[store.length];

		var stack = new ArrayDeque<Edge>();
		var srcEdge = new Edge(-1, 1, 0);
		stack.push(srcEdge);
		var i = 1;
		result[i++] = srcEdge.dst();
		visited[srcEdge.dst()] = true;

		while (!stack.isEmpty()) {
			var top = stack.peek();
			Edge unvisitedEdge = getUnvisitedEdges(top.dst(), visited);
			if (unvisitedEdge == null) {
				stack.pop();
			} else {
				stack.push(unvisitedEdge);
				visited[unvisitedEdge.dst()] = true;
				result[i++] = unvisitedEdge.dst();
			}
		}
		return result;
	}

	private Edge getUnvisitedEdges(int source, boolean[] visited) {
		return getIncidentEdges(source).stream().filter(edge -> !visited[edge.dst()]).findFirst()
				.orElse(null);
	}

	@Override
	public int[] bfs(int source) {
		return new int[0];
	}
}