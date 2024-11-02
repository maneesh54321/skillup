package com.learning.twentyfour.phase2.dsalgo.disjointsets;

public sealed interface DisjointSet permits AbstractDisjointSet {

    int findUPar(int node);

    void union(int u, int v);
}
