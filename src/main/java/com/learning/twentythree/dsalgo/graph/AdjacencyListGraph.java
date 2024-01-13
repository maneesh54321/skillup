package com.learning.twentythree.dsalgo.graph;

import com.learning.twentythree.dsalgo.linkedlist.ListNode;

import java.util.*;

public class AdjacencyListGraph {

    private final int vertexCount;

    private final ArrayList<Vertex> vertices;

    private final ListNode[] edges;

    public AdjacencyListGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.vertices = new ArrayList<>(this.vertexCount);
        this.edges = new ListNode[vertexCount];
    }

    public void addVertex(char label){
        this.vertices.add(new Vertex(label));
    }

    public void addEdge(char u, char v) {
        int srcIndex = vertices.indexOf(new Vertex(u));
        int destIndex = vertices.indexOf(new Vertex(v));
        if (srcIndex != -1 && destIndex != -1) {
            ListNode tmp = edges[srcIndex];
            edges[srcIndex] = new ListNode(destIndex, tmp);
            // uncomment below to make this graph undirected
            // tmp = edges[destIndex];
            // edges[destIndex] = new ListNode(srcIndex, tmp);
        }
    }

    public void removeEdge(char u, char v) {
        int srcIndex = vertices.indexOf(new Vertex(u));
        int destIndex = vertices.indexOf(new Vertex(v));
        if (srcIndex != -1 && destIndex != -1) {
            ListNode curr = edges[srcIndex];
            ListNode finalEdgeHead = new ListNode(-1, curr);
            ListNode prev = finalEdgeHead;
            while (curr != null) {
                if (curr.val == destIndex) {
                    prev.next = curr.next;
                    break;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            edges[srcIndex] = finalEdgeHead.next;
        }
    }

    public boolean isEdge(char u, char v) {
        int srcIndex = vertices.indexOf(new Vertex(u));
        int destIndex = vertices.indexOf(new Vertex(v));
        if (srcIndex != -1 && destIndex != -1) {
            ListNode curr = edges[srcIndex];
            while (curr != null) {
                if (curr.val == destIndex)
                    return true;
                curr = curr.next;
            }
        }
        return false;
    }

    public Map<Character, Integer> shortestPath(char u) {
        int srcIndex = vertices.indexOf(new Vertex(u));
        int[] distances = new int[vertexCount];
        Arrays.fill(distances, -1);
        distances[srcIndex] = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(srcIndex);

        while (!queue.isEmpty()) {
            int frontEleIndex = queue.poll();
            ListNode curr  = this.edges[frontEleIndex];
            while (curr!= null){
                if(distances[curr.val] == -1){
                    distances[curr.val] = distances[frontEleIndex]+1;
                    queue.offer(curr.val);
                }
                curr = curr.next;
            }
        }
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < vertexCount; i++) {
            map.put(vertices.get(i).label, distances[i]);
        }

        return map;
    }

    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph(7);
        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        graph.addVertex('F'); // 5
        graph.addVertex('G'); // 6

        graph.addEdge('A', 'D');
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('D', 'F');
        graph.addEdge('D', 'G');
        graph.addEdge('E', 'G');
        graph.addEdge('C', 'A');
        graph.addEdge('C', 'F');

        System.out.println(graph.shortestPath('A'));
    }
}
