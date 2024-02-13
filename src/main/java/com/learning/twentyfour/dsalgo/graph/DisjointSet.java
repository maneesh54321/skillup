package com.learning.twentyfour.dsalgo.graph;

import java.util.Arrays;

public class DisjointSet {

	int[] parents;
	int[] ranks;

	public DisjointSet(int size) {
		parents = new int[size + 1];
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
		ranks = new int[size + 1];
	}

	public int findUParent(int node){
		if(node == parents[node]){
			return node;
		} else {
			parents[node] = findUParent(parents[node]);
			return parents[node];
		}
	}

	public void unionByRank(int u, int v){
		int ulp_u = findUParent(u);
		int ulp_v = findUParent(v);
		if(ulp_u == ulp_v){
			return;
		} else if (ranks[ulp_u] < ranks[ulp_v]) {
			parents[ulp_u] = ulp_v;
		} else if (ranks[ulp_v] < ranks[ulp_u]) {
			parents[ulp_v] = ulp_u;
		} else {
			parents[ulp_v] = ulp_u;
			ranks[ulp_u]++;
		}
	}
}
