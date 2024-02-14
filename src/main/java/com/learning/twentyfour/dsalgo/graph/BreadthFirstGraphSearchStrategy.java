package com.learning.twentyfour.dsalgo.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class BreadthFirstGraphSearchStrategy implements GraphSearchStrategy{

	@Override
	public boolean findNode(Graph graph, int node) {
		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[graph.getVertexCount()+1];
		int startNode = 1;
		queue.add(startNode);
		visited[startNode] = true;
		while (!queue.isEmpty()){
			Integer front = queue.remove();
			if(front == node){
				return true;
			}
			for(Integer vertex: graph.getAllConnectedVertices(front)){
				if(!visited[vertex]){
					queue.add(vertex);
					visited[vertex] = true;
				}
			}
		}
		return false;
	}

	@Override
	public void print(Graph graph) {
		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[graph.getVertexCount()+1];
		int startNode = 1;
		queue.add(startNode);
		visited[startNode] = true;
		while (!queue.isEmpty()){
			Integer front = queue.remove();
			System.out.println(front);
			for(Integer vertex: graph.getAllConnectedVertices(front)){
				if(!visited[vertex]){
					queue.add(vertex);
					visited[vertex] = true;
				}
			}
		}
	}
}
