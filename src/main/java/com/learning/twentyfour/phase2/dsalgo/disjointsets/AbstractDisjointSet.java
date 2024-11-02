package com.learning.twentyfour.phase2.dsalgo.disjointsets;

public abstract sealed class AbstractDisjointSet implements DisjointSet permits DisjointSetByRank, DisjointSetBySize {

    protected int[] parent;

    protected int[] weight;

    protected AbstractDisjointSet(int size) {
        parent = new int[size+1];
        weight = new int[size+1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int findUPar(int node) {
        int uPar = parent[node];
        if(uPar == node) return uPar;
        return findUPar(uPar);
    }
}
