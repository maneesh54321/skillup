package com.learning.twentyfour.dsalgo.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DisjointSetTest {

	private static DisjointSet ds;

	static {
		ds = new DisjointSet(7);
	}

	@BeforeAll
	public static void setup(){
		ds.unionByRank(1, 2);
		ds.unionByRank(2, 3);
		ds.unionByRank(4, 5);
		ds.unionByRank(6, 7);
		ds.unionByRank(5, 6);
	}

	@Test
	@DisplayName("Parents of two nodes belonging to different groups should not be same.")
	void testDisjointNodesIfInSameComponent(){
		// Test if 3 and 7 belongs to same component
		Assertions.assertNotEquals(ds.findUParent(3), ds.findUParent(7));
	}

	@Test
	@DisplayName("Parents of two nodes belonging to same group should be same.")
	void testJoinNodesIfInSameComponent(){
		Assertions.assertEquals(ds.findUParent(6), ds.findUParent(4));
	}
}