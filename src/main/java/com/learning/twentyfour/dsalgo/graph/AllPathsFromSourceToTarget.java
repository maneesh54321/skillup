package com.learning.twentyfour.dsalgo.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
		int n = graph.length;
		int[] color = new int[n];
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);
		color[0] = 2;
		List<List<Integer>> result = new ArrayList<>();
		while (!stack.isEmpty()) {
			Integer top = stack.peek();
			int nextUnvisited = -1;
			for (int i = 0; i < graph[top].length; i++) {
				int node = graph[top][i];
				if(node == n-1){
					result.add(new ArrayList<>(stack));
					result.getLast().add(node);
				}
				if(color[node] == 0){
					nextUnvisited = node;
				}
			}
			if(nextUnvisited == -1){
				color[top] = 1;
				stack.pop();
			} else {
				stack.push(nextUnvisited);
				color[nextUnvisited] = 2;
			}
		}
		return result;
	}
}
