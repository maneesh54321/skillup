package com.learning.twentyfour.phase2.dsalgo.graph;

public interface PathAwareGraph {

	int[] findShortestPathToAllNodes(int source);
	int[] findShortestPathToAllNodesNonWeighted(int source);

}
