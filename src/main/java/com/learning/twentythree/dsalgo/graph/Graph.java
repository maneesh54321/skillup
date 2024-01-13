package com.learning.twentythree.dsalgo.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Graph {
    Vertex[] vertices;

    int vertexCount = 0;
    int[][] adjMatrix;
    private static final int MAX_VERTICES = 20;

    private final Deque<Integer> stack;

    private final Deque<Integer> queue;

    public Graph() {
        this.vertices = new Vertex[MAX_VERTICES];
        this.adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        stack = new ArrayDeque<>();
        queue = new ArrayDeque<>();
    }

    public void addVertex(char label) {
        this.vertices[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        addEdge(start, end, 1);
    }

    public void addEdge(int start, int end, int weight) {
        this.adjMatrix[start][end] = weight;
        this.adjMatrix[end][start] = weight;
    }

    public void displayVertex(int v) {
        System.out.print(vertices[v].label + " ");
    }

    private int getAdjacentUnvisitedIndex(int topNodeIndex) {
        for (int j = 0; j < vertexCount; j++) {
            if (adjMatrix[topNodeIndex][j] != 0 && !vertices[j].visited) {
                return j;
            }
        }
        return -1;
    }

    public void DFS() {
        if (vertexCount > 0) {
            stack.push(0);
            displayVertex(0);
            vertices[0].visited = true;

            while (!stack.isEmpty()) {
                int topNodeIndex = stack.peek();

                int unvisitedIndex = getAdjacentUnvisitedIndex(topNodeIndex);

                if (unvisitedIndex == -1)
                    stack.pop();
                else {
                    displayVertex(unvisitedIndex);
                    vertices[unvisitedIndex].visited = true;
                    stack.push(unvisitedIndex);
                }
            }

            // reset flags
            for (int j = 0; j < vertexCount; j++) {
                this.vertices[j].visited = false;
            }
        }
    }

    public void BFS() {
        if (vertexCount > 0) {
            queue.add(0);
            displayVertex(0);
            vertices[0].visited = true;
            while (!queue.isEmpty()) {
                int topNodeIndex = queue.poll();
                ArrayList<Integer> unvisitedIndices = getAllAdjacentUnvisitedNodes(topNodeIndex);
                for (int unvisitedIndex : unvisitedIndices) {
                    displayVertex(unvisitedIndex);
                    vertices[unvisitedIndex].visited = true;
                    queue.offer(unvisitedIndex);
                }
            }
            for (int j = 0; j < vertexCount; j++) {
                vertices[j].visited = false;
            }
        }
    }

    private ArrayList<Integer> getAllAdjacentUnvisitedNodes(int nodeIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int j = 0; j < vertexCount; j++) {
            if (this.adjMatrix[nodeIndex][j] == 1 && !vertices[j].visited) {
                result.add(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        graph.addVertex('F'); // 5
        graph.addVertex('G'); // 6
        graph.addVertex('H'); // 7

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(4, 7);

        graph.DFS();
        System.out.println();
        graph.BFS();
    }
}
