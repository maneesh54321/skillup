package com.learning.twentyfour.phase2.dsalgo.graph;

import java.util.LinkedList;

public final class AdjacencyListGraph implements Graph {

    private LinkedList<Integer>[] store;

    public AdjacencyListGraph(int numOfNodes) {
        store = new LinkedList[numOfNodes];
    }

    @Override
    public void addEdge(int u, int v) {
        if((u>=0 && u < store[u].size()) && (v >=0 && v < store[v].size())) {
            store[u].add(v);
            store[v].add(u);
        }
    }

    @Override
    public boolean hasEdge(int u, int v) {
        if((u>=0 && u < store[u].size()) && (v >=0 && v < store[v].size())) {
            return store[u].contains(v);
        }
        return false;
    }

    @Override
    public void deleteEdge(int u, int v) {
        if((u>=0 && u < store[u].size()) && (v >=0 && v < store[v].size())) {
            store[u].remove(v);
            store[v].remove(u);
        }
    }
}
