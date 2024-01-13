package com.learning.twentythree.dsalgo.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AdjacencyMatrixGraph {
    private boolean adjMatrix[][];

    private Vertex[] vertices;

    private int vertexCount;

    private int maxCapacity;

    public AdjacencyMatrixGraph(int capacity) {
        this.maxCapacity = capacity;
        this.vertexCount = 0;
        adjMatrix = new boolean[maxCapacity][maxCapacity];
        this.vertices = new Vertex[maxCapacity];
    }

    public void addVertex(char label) {
        vertices[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            this.adjMatrix[i][j] = true;
        }
    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            this.adjMatrix[i][j] = false;
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            return adjMatrix[i][j];
        }
        return false;
    }

    public int getUnvisitedAdjacentVertex(int src){
        for (int j = 0; j < vertexCount; j++) {
            if(adjMatrix[src][j] && !vertices[j].visited) {
                return j;
            }
        }
        return -1;
    }

    public boolean checkSimplePath(int s, int d) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int top = stack.peek();
            if (top == d){
                Arrays.stream(vertices).forEach(vertex -> vertex.visited = false);
                return true;
            }
            int next = getUnvisitedAdjacentVertex(top);
            if(next != -1)
                stack.push(next);
            else {
                vertices[stack.pop()].visited = true;
            }

        }
        Arrays.stream(vertices).forEach(vertex -> vertex.visited = false);
        return false;
    }

    public int countSimplePaths(int s, int d) {

        int count = 0;
        if(s == d){
            return 1;
        }
        for (int j = 0; j < vertexCount; j++) {
            if (adjMatrix[s][j]) {
                count += countSimplePaths(j, d);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(7);

        graph.addVertex('A'); //0
        graph.addVertex('B'); //1
        graph.addVertex('C'); //2
        graph.addVertex('D'); //3
        graph.addVertex('E'); //4
        graph.addVertex('F'); //5
        graph.addVertex('G'); //6

        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(6, 4);

        System.out.println(graph.checkSimplePath(0, 4));
        System.out.println(graph.checkSimplePath(0, 6));

        System.out.println(graph.countSimplePaths(0, 4));

    }
}
