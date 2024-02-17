package com.learning.twentyfour.dsalgo.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

	public static void main(String[] args) {
		int[][] graph = {{1,2}, {3}, {3}, {}};
		System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(graph));
	}

	/**
	 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
	 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
	 *
	 * @param graph
	 * @return
	 */
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		int[] path = new int[15];
		path[0] = 0;
		dfs(graph, 0, path, 1, result);
		return result;
	}

	public void dfs(int[][] graph, int source, int[] path, int i, List<List<Integer>> result) {
		for (int j = 0; j < graph[source].length; j++) {
			int node = graph[source][j];
			path[i] = node;
			if(node == graph.length-1){
				addPathToResult(path, i, result);
			}
			dfs(graph, node, path, i+1, result);
		}
	}

	private void addPathToResult(int[] path, int i, List<List<Integer>> result) {
		List<Integer> pathList = new ArrayList<>();
		for (int j = 0; j <= i; j++) {
			pathList.add(path[j]);
		}
		result.add(pathList);
	}

}
