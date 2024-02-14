package com.learning.twentyfour.dsalgo.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph implements Graph {

	private static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	private final int vertexCount;

	private ListNode[] edges;

	public AdjacencyListGraph(int vertexCount) {
		this.vertexCount = vertexCount;
		this.edges = new ListNode[vertexCount+1];
	}

	@Override
	public void addEdge(int u, int v) {
		if( u < 0 || u > vertexCount || v < 0 || v > vertexCount) return;
		this.edges[u] = addAtBeginning(this.edges[u], new ListNode(v));
		this.edges[v] = addAtBeginning(this.edges[v], new ListNode(u));
	}

	@Override
	public void removeEdge(int u, int v) {
		if( u < 0 || u > vertexCount || v < 0 || v > vertexCount) return;
		this.edges[u] = deleteNode(this.edges[u], v);
		this.edges[v] = deleteNode(this.edges[v], u);
	}

	@Override
	public boolean isEdge(int u, int v) {
		return findNode(edges[u], v);
	}

	@Override
	public int getVertexCount() {
		return vertexCount;
	}

	@Override
	public List<Integer> getAllConnectedVertices(Integer vertex) {
		List<Integer> result = new ArrayList<>();
		if(vertex < 0 || vertex > vertexCount) return result;
		ListNode head = edges[vertex];
		while (head != null) {
			result.add(head.val);
			head = head.next;
		}
		return result;
	}

	private ListNode addAtBeginning(ListNode head, ListNode node){
		node.next = head;
		return node;
	}

	private boolean findNode(ListNode head, int val){
		while (head != null){
			if(head.val == val)
				return true;
			head = head.next;
		}
		return false;
	}

	private ListNode deleteNode(ListNode head, int valToDelete) {
		ListNode result = new ListNode(-1);
		result.next = head;
		ListNode prev = result;
		while (head != null){
			if(head.val == valToDelete){
				prev.next = head.next;
				head.next = null;
				break;
			}
			head = head.next;
			prev = head;
		}
		return result.next;
	}
}
