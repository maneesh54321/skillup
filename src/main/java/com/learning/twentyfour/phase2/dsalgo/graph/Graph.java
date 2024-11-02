package com.learning.twentyfour.phase2.dsalgo.graph;

public sealed interface Graph permits AdjacencyListGraph, MatrixGraph {
    void addEdge(int u, int v);
    boolean hasEdge(int u, int v);
    void deleteEdge(int u, int v);
}
