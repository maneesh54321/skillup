package com.learning.twentyfour.dsalgo.graph;

import java.util.Arrays;

public class DisjointSet {

	int[] parent;
	int[] rank;

	int[] size;

	public DisjointSet(int size) {
		parent = new int[size + 1];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		rank = new int[size + 1];
		this.size = new int[size + 1];
		Arrays.fill(this.size, 1);
	}

	public int findUParent(int node){
		if(node == parent[node]){
			return node;
		} else {
			parent[node] = findUParent(parent[node]);
			return parent[node];
		}
	}

	public void unionByRank(int u, int v){
		int ulp_u = findUParent(u);
		int ulp_v = findUParent(v);
		if(ulp_u == ulp_v){
			return;
		}
		if (rank[ulp_u] < rank[ulp_v]) {
			parent[ulp_u] = ulp_v;
		} else if (rank[ulp_v] < rank[ulp_u]) {
			parent[ulp_v] = ulp_u;
		} else {
			parent[ulp_v] = ulp_u;
			rank[ulp_u]++;
		}
	}

	public void unionBySize(int u, int v){
		int ulp_u = findUParent(u);
		int ulp_v = findUParent(v);
		if(ulp_u == ulp_v) return;
		if(size[ulp_u] < size[ulp_v]){
			parent[ulp_u] = ulp_v;
			size[ulp_v] += size[ulp_u];
		} else {
			parent[ulp_v] = ulp_u;
			size[ulp_v] += size[ulp_u];
		}
	}
}
