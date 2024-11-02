package com.learning.twentyfour.phase2.dsalgo.disjointsets;

public final class DisjointSetByRank extends AbstractDisjointSet {

    public DisjointSetByRank(int size) {
        super(size);
    }

    @Override
    public void union(int u, int v) {
        int uParU = findUPar(u);
        int uParV = findUPar(v);

        if(uParU == uParV) return;

        if (weight[uParU] < weight[uParV]) {
            parent[uParU] = uParV;
        } else if (weight[uParV] < weight[uParU]) {
            parent[uParV] = uParU;
        } else {
            parent[uParU] = uParV;
            weight[uParV]++;
        }
    }
}
