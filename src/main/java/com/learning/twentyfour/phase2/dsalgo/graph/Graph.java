package com.learning.twentyfour.phase2.dsalgo.graph;

import java.util.List;

public sealed interface Graph permits AdjacencyListGraph, MatrixGraph {
    void addEdge(int u, int v);
    void addEdge(int u, int v, int weight);
    boolean hasEdge(int u, int v);
    List<Edge> getIncidentEdges(int source);
    void deleteEdge(int u, int v);

    int[] dfs(int source);
    int[] bfs(int source);
}
