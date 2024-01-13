package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.Arrays;

public class DisjointSet {

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if(ds.findUlp(3) == ds.findUlp(7)){
            System.out.println("Same!!");
        } else {
            System.out.println("Not Same!!");
        }

        ds.unionBySize(3, 7);

        if(ds.findUlp(3) == ds.findUlp(7)){
            System.out.println("Same!!");
        } else {
            System.out.println("Not Same!!");
        }

        DisjointSet ds2 = new DisjointSet(7);

        ds2.unionByRank(1, 2);
        ds2.unionByRank(2, 3);
        ds2.unionByRank(4, 5);
        ds2.unionByRank(6, 7);
        ds2.unionByRank(5, 6);

        if(ds2.findUlp(3) == ds2.findUlp(7)){
            System.out.println("Same!!");
        } else {
            System.out.println("Not Same!!");
        }

        ds2.unionByRank(3, 7);

        if(ds2.findUlp(3) == ds2.findUlp(7)){
            System.out.println("Same!!");
        } else {
            System.out.println("Not Same!!");
        }
    }

    private final int[] ranks;
    final int[] parents;
    private final int[] sizes;

    public DisjointSet(int size){
        ranks = new int[size+1];
        sizes = new int[size+1];
        parents = new int[size+1];
        Arrays.fill(ranks, 0);
        Arrays.fill(sizes, 1);
        for (int i = 1; i <= size; i++) {
            parents[i] = i;
        }
    }

    public int findUlp(int x){
        if(parents[x] == x){
            return x;
        } else {
            return parents[x] = findUlp(parents[x]);
        }
    }

    public boolean unionByRank(int u, int v){
        int ulp_u = findUlp(u);
        int ulp_v = findUlp(v);
        if(ulp_u == ulp_v){
            return false;
        }
        if (ranks[ulp_u] < ranks[ulp_v]) {
            parents[ulp_u] = ulp_v;
        } else if (ranks[ulp_u] > ranks[ulp_v]) {
            parents[ulp_v] = ulp_u;
        } else {
            parents[ulp_u] = ulp_v;
            ranks[ulp_v]++;
        }
        return true;
    }

    public boolean unionBySize(int u, int v){
        int ulp_u = findUlp(u);
        int ulp_v = findUlp(v);
        if(ulp_u == ulp_v){
            return false;
        }
        if (sizes[ulp_u] < sizes[ulp_v]) {
            parents[ulp_u] = ulp_v;
            sizes[ulp_v] += sizes[ulp_u];
        } else {
            parents[ulp_v] = ulp_u;
            sizes[ulp_u] += sizes[ulp_v];
        }
        return true;
    }
}
