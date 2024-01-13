package com.learning.twentythree.dsalgo.graph;

import java.util.Objects;

public class Edge implements Comparable<Edge>{
    public Vertex srcVertex;
    public Vertex dstVertex;
    public int weight;

    public Edge(Vertex srcVertex, Vertex dstVertex, int weight) {
        this.srcVertex = srcVertex;
        this.dstVertex = dstVertex;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight && srcVertex.equals(edge.srcVertex) && dstVertex.equals(edge.dstVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(srcVertex, dstVertex, weight);
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
