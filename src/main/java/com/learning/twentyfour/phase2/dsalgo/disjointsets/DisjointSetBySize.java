package com.learning.twentyfour.phase2.dsalgo.disjointsets;

public final class DisjointSetBySize extends AbstractDisjointSet {

    public DisjointSetBySize(int size) {
        super(size);
    }

    @Override
    public void union(int u, int v) {
        int uParU = findUPar(u);
        int uParV = findUPar(v);

        if(uParU == uParV) return;

        if(weight[uParU] < weight[uParV]) {
            parent[uParU] = uParV;
            weight[uParV] += weight[uParU];
        } else {
            parent[uParV] = uParU;
            weight[uParU] += weight[uParV];
        }
    }
}
