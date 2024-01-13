package com.learning.twentythree.dsalgo.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class DAG {
    private static final int MAX_VERTICES = 20;

    private final int[][] adjMatrix;

    private final Vertex[] vertices;

    private final int[] topologicalOrder;

    private final int[] inDegree;

    private int vertexCount;

    public DAG() {
        this.vertexCount = 0;
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        vertices = new Vertex[MAX_VERTICES];
        inDegree = new int[MAX_VERTICES];
        topologicalOrder = new int[MAX_VERTICES];
    }

    public void addVertex(char label) {
        vertices[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int src, int dst) {
        if (src >= 0 && src < vertexCount && dst >= 0 && dst < vertexCount) {
            adjMatrix[src][dst] = 1;
            inDegree[dst] += 1;
        }
    }

    public void removeEdge(int src, int dst) {
        if (src >= 0 && src < vertexCount && dst >= 0 && dst < vertexCount) {
            adjMatrix[src][dst] = 0;
            inDegree[dst] -= 1;
        }
    }

    public void displayVertex(int i) {
        if (i >= 0 && i < vertexCount) {
            System.out.println(vertices[i].label);
        }
    }

    public void topologicalSort(){
        int[] inDegrees = new int[vertexCount];
        int count =0;
        System.arraycopy(this.inDegree, 0, inDegrees, 0, vertexCount);
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < vertexCount; i++) {
            if(inDegrees[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            topologicalOrder[count] = q.poll();
            for (int j = 0; j < vertexCount; j++) {
                if(adjMatrix[topologicalOrder[count]][j] > 0){
                    inDegrees[j] -= 1;
                    if(inDegrees[j] == 0)
                        q.offer(j);
                }
            }
            count++;
        }
    }

    public static void main(String[] args) {
        DAG dag = new DAG();

        dag.addVertex('7'); // 0
        dag.addVertex('5'); // 1
        dag.addVertex('3'); // 2
        dag.addVertex('4'); // 3   //11
        dag.addVertex('8'); // 4
        dag.addVertex('2'); // 5
        dag.addVertex('9'); // 6
        dag.addVertex('1'); // 7   // 10

        dag.addEdge(0, 3);
        dag.addEdge(0, 4);
        dag.addEdge(1, 3);
        dag.addEdge(2, 4);
        dag.addEdge(2, 7);
        dag.addEdge(3, 5);
        dag.addEdge(3, 6);
        dag.addEdge(3, 7);
        dag.addEdge(4, 6);

        dag.topologicalSort();

        for (int i = 0; i < dag.vertexCount; i++) {
            dag.displayVertex(dag.topologicalOrder[i]);
        }
    }
}
