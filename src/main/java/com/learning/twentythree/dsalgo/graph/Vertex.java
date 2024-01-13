package com.learning.twentythree.dsalgo.graph;

import java.util.Objects;

public class Vertex {

    public char label;
    public boolean visited;

    public Vertex(char label) {
        this.label = label;
        visited = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return label == vertex.label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
