package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathExistsGraph {
    public static void main(String[] args) {

    }

    private class Vertex {
        int label;
        boolean visited;
        List<Vertex> adjVertices = new ArrayList<>();

        public Vertex(int label, boolean visited) {
            this.label = label;
            this.visited = visited;
        }

        public void addAdjVertex(Vertex vertex){
            this.adjVertices.add(vertex);
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) {
            return true;
        }
        if(n == 0 || edges.length == 0){
            return false;
        }
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vertices.add(new Vertex(i, false));
        }

        for (int[] edge: edges){
            vertices.get(edge[0]).addAdjVertex(vertices.get(edge[1]));
            vertices.get(edge[1]).addAdjVertex(vertices.get(edge[0]));
        }

        Deque<Vertex> stack = new ArrayDeque<>();
        stack.push(vertices.get(source));
        vertices.get(source).visited = true;
        while (!stack.isEmpty()) {
            Vertex top = stack.pop();
            for (Vertex adjVertex : top.adjVertices){
                if(!adjVertex.visited) {
                    if(adjVertex.label == destination)
                        return true;
                    adjVertex.visited = true;
                    stack.push(adjVertex);
                }
            }
        }
        return false;
    }

    public boolean validPath_1(int n, int[][] edges, int source, int destination) {

        boolean[][] edgeMat = new boolean[n][n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < edges.length; i++) {
            edgeMat[edges[i][0]][edges[i][1]] = true;
        }

        DFS(edgeMat, source, visited);

        return visited[destination];
    }

    public void DFS(boolean[][] edgeMat, int source, boolean[] visited){
        List<Integer> unvisitedNodes = getUnvisitedNodesFromNode(edgeMat, visited, source);

        for (Integer unvisitedNode : unvisitedNodes) {
            visited[unvisitedNode] = true;
            DFS(edgeMat, unvisitedNode, visited);
        }
    }
    public List<Integer> getUnvisitedNodesFromNode(boolean[][] edgeMat, boolean[] visited, int source){
        List<Integer> unvisitedNodes = new ArrayList<>();
        for (int i = 0; i < edgeMat.length; i++) {
            if(edgeMat[source][i] && !visited[i]){
                unvisitedNodes.add(i);
            }
        }

        return unvisitedNodes;
    }
}
