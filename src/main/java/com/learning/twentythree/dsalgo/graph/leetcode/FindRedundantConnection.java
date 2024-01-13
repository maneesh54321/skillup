package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.Arrays;

public class FindRedundantConnection {

    public static void main(String[] args) {
        FindRedundantConnection main = new FindRedundantConnection();
        System.out.println(Arrays.toString(main.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
        System.out.println(Arrays.toString(main.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));
    }

    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length);

        for (int[] edge: edges){
            if(!ds.unionByRank(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[0];
    }
}
