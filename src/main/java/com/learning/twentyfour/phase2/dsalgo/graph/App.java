package com.learning.twentyfour.phase2.dsalgo.graph;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
//		Graph graph = new MatrixGraph(6);
		Graph graph = new AdjacencyListGraph(6);
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 5);
		graph.addEdge(2, 3, 2);
		graph.addEdge(2, 4, 4);
		graph.addEdge(3, 5, 2);
		graph.addEdge(4, 5, 3);
		graph.addEdge(5, 6, 1);
		graph.addEdge(4, 6, 2);

		System.out.println(Arrays.toString(graph.dfs(1)));

		PathAwareGraph pathAwareGraph = (PathAwareGraph) graph;
//		int[] shortestPathToAllNodes = pathAwareGraph.findShortestPathToAllNodes(1);
		int[] shortestPathToAllNodes = pathAwareGraph.findShortestPathToAllNodesNonWeighted(1);

		System.out.println(Arrays.toString(shortestPathToAllNodes));
	}
}
