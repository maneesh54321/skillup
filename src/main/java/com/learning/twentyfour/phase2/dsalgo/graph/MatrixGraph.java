package com.learning.twentyfour.phase2.dsalgo.graph;

public final class MatrixGraph implements Graph {

    private final boolean[][] matrix;

    public MatrixGraph(int numOfNodes) {
        matrix = new boolean[numOfNodes][numOfNodes];
    }

    @Override
    public void addEdge(int u, int v) {
        if((u>=0 && u < matrix.length) && (v >=0 && v < matrix.length)) {
            matrix[u][v] = true;
            matrix[v][u] = true;
        }
    }

    @Override
    public boolean hasEdge(int u, int v) {
        if((u>=0 && u < matrix.length) && (v >=0 && v < matrix.length)) {
            return matrix[u][v] && matrix[v][u];
        }
        return false;
    }

    @Override
    public void deleteEdge(int u, int v) {
        if((u>=0 && u < matrix.length) && (v >=0 && v < matrix.length)) {
            matrix[u][v] = false;
            matrix[v][u] = false;
        }
    }
}
