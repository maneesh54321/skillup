package com.learning.twentythree.dsalgo.graph;

import java.util.*;

public class WeightedGraph {

    private final ArrayList<Vertex> vertices;

    private final int maxCapacity;

    private final int[][] adjMatrix;

    private int vertexCount;

    private final Map<Vertex, Integer> vertexIndexMap;

    private final Set<Edge> edges;

    public WeightedGraph(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.adjMatrix = new int[maxCapacity][maxCapacity];
        this.vertexCount = 0;
        this.vertices = new ArrayList<>();
        this.vertexIndexMap = new HashMap<>();
        this.edges = new HashSet<>();
    }

    public void addVertex(char label) {
        addVertex(new Vertex(label));
    }

    public void addVertex(Vertex vertex) {
        if (vertexCount < maxCapacity) {
            vertexIndexMap.put(vertex, vertexCount);
            this.vertices.add(vertexCount++, vertex);
        }
    }

    public void addEdge(char src, char dst) {
        addEdge(src, dst, 1);
    }

    public void addEdge(char src, char dst, int weight) {
        Edge edge = new Edge(new Vertex(src), new Vertex(dst), weight);
        addEdge(edge);
    }

    public void addEdge(Edge edge) {
        int srcIdx = vertices.indexOf(edge.srcVertex);
        int dstIdx = vertices.indexOf(edge.dstVertex);
        if (srcIdx != -1 && dstIdx != -1) {
            this.edges.add(edge);
            this.adjMatrix[srcIdx][dstIdx] = edge.weight;
        }
    }

    public ArrayList<Edge> getAllEdgesFromVertex(char srcVertexLabel) {
        return getAllEdgesFromVertex(new Vertex(srcVertexLabel));
    }

    public ArrayList<Edge> getAllEdgesFromVertex(Vertex srcVertex) {
        int srcIdx = this.vertices.indexOf(srcVertex);
        var edges = new ArrayList<Edge>();
        if (srcIdx != -1) {
            for (int j = 0; j < vertexCount; j++) {
                if (this.adjMatrix[srcIdx][j] != 0) {
                    edges.add(new Edge(vertices.get(srcIdx), vertices.get(j), this.adjMatrix[srcIdx][j]));
                }
            }
        }
        return edges;
    }

    public Set<Edge> getAllEdges() {
        return edges;
    }

    public Map<Character, Integer> dijkstraShortestPath(char srcLabel) {
        int srcIdx = this.vertices.indexOf(new Vertex(srcLabel));
        int[] distances = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        vertices.get(srcIdx).visited = true;
        distances[srcIdx] = 0;
        ArrayList<Edge> edges = getAllEdgesFromVertex(srcLabel);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge edge : edges) {
            int dstIdx = vertices.indexOf(edge.dstVertex);
            distances[dstIdx] = edge.weight;
            pq.offer(edge);
        }

        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
            minEdge.dstVertex.visited = true;
            ArrayList<Edge> allEdges = getAllEdgesFromVertex(minEdge.dstVertex.label);
            for (Edge edge : allEdges) {
                if (!edge.dstVertex.visited) {
                    int edgeDstIdx = vertices.indexOf(edge.dstVertex);
                    int edgeSrcIdx = vertices.indexOf(edge.srcVertex);
                    distances[edgeDstIdx] = Math.min(distances[edgeDstIdx], edge.weight + distances[edgeSrcIdx]);
                    pq.offer(edge);
                }
            }
        }

        var result = new HashMap<Character, Integer>();
        for (int i = 0; i < vertexCount; i++) {
            result.put(vertices.get(i).label, distances[i]);
        }
        vertices.forEach(vertex -> vertex.visited=false);

        return result;
    }

    public Map<Character, Integer> bellmanFordShortestPath(char srcLabel) {
        var allEdges = new ArrayList<Edge>();
        int[] distances = new int[vertexCount];
        for (Vertex vertex : vertices) {
            allEdges.addAll(getAllEdgesFromVertex(vertex));
            distances[vertexIndexMap.get(vertex)] = Integer.MAX_VALUE;
        }
        distances[vertexIndexMap.get(new Vertex(srcLabel))] = 0;
        for (int i = 0; i < vertexCount - 1; i++) {
            for (Edge edge : allEdges) {
                distances[vertexIndexMap.get(edge.dstVertex)] = Math.min(
                        distances[vertexIndexMap.get(edge.dstVertex)],
                        distances[vertexIndexMap.get(edge.srcVertex)] + edge.weight
                );
            }
        }
        var result = new HashMap<Character, Integer>();
        for (int i = 0; i < vertexCount; i++) {
            result.put(vertices.get(i).label, distances[i]);
        }
        return result;
    }

    public WeightedGraph minSpanningTreePrim() {
        WeightedGraph result = new WeightedGraph(7);
        Edge minEdge = new Edge(null, null, Integer.MAX_VALUE);
        for (Vertex vertex : vertices) {
            Edge vertexMinEdge = getAllEdgesFromVertex(vertex).stream()
                    .reduce((edge1, edge2) -> edge1.weight < edge2.weight ? edge1 : edge2).get();
            minEdge = minEdge.weight < vertexMinEdge.weight ? minEdge : vertexMinEdge;
        }

        var pq = new PriorityQueue<Edge>();

        result.addVertex(minEdge.srcVertex);
        result.addVertex(minEdge.dstVertex);
        result.addEdge(minEdge);
        for (Edge edge : getAllEdgesFromVertex(minEdge.dstVertex)) {
            if(!result.vertices.contains(edge.dstVertex)){
                pq.offer(edge);
            }
        }
        for (Edge edge : getAllEdgesFromVertex(minEdge.srcVertex)) {
            pq.offer(edge);
        }
        while (!pq.isEmpty()) {
            Edge minEdgeInHeap = pq.poll();
            while (!pq.isEmpty() && result.vertices.contains(minEdgeInHeap.dstVertex))
                minEdgeInHeap = pq.poll();
            if(result.vertices.contains(minEdgeInHeap.dstVertex)){
                continue;
            }
            result.addVertex(minEdgeInHeap.dstVertex);
            result.addEdge(minEdgeInHeap);
            for (Edge edge : getAllEdgesFromVertex(minEdgeInHeap.dstVertex)) {
                pq.offer(edge);
            }
        }
        return result;
    }

    public WeightedGraph minSpanningTreeKruskal() {
        WeightedGraph result = new WeightedGraph(7);
        var pq = new PriorityQueue<Edge>();
        for (Vertex vertex : vertices) {
            getAllEdgesFromVertex(vertex).forEach(pq::offer);
        }
        while (!pq.isEmpty()){
            Edge minEdge = pq.poll();
            while (!pq.isEmpty() && result.vertices.contains(minEdge.dstVertex))
                minEdge = pq.poll();
            if(result.vertices.contains(minEdge.dstVertex)){
                continue;
            }
            result.addVertex(minEdge.srcVertex);
            result.addVertex(minEdge.dstVertex);
            result.addEdge(minEdge);
        }
        return result;
    }

    public void printUsingBFS(char srcVertexLabel) {
        Deque<Vertex> q = new ArrayDeque<>();
        Vertex inputVertex = new Vertex(srcVertexLabel);
        int srcIdx = vertices.indexOf(inputVertex);
        Vertex srcVertex = vertices.get(srcIdx);
        q.offer(srcVertex);
        System.out.print(srcVertex.label + " ");
        srcVertex.visited = true;
        while (!q.isEmpty()) {
            Vertex frontVertex = q.poll();
            for (Edge edge : getAllEdgesFromVertex(frontVertex)) {
                if(!edge.dstVertex.visited) {
                    q.offer(edge.dstVertex);
                    System.out.print(edge.dstVertex.label + " ");
                    edge.dstVertex.visited = true;
                }
            }
        }
        vertices.forEach(vertex -> vertex.visited=false);
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5);
        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4

        graph.addEdge('A', 'B', 4);
        graph.addEdge('A', 'C', 1);
        graph.addEdge('B', 'E', 4);
        graph.addEdge('C', 'B', 2);
        graph.addEdge('C', 'D', 4);
        graph.addEdge('D', 'E', 4);

        System.out.println("Graph: Dijkstra shortest path" + graph.dijkstraShortestPath('A'));


        WeightedGraph graph1 = new WeightedGraph(4);
        graph1.addVertex('1'); // 0
        graph1.addVertex('2'); // 1
        graph1.addVertex('3'); // 2
        graph1.addVertex('4'); // 3


        graph1.addEdge('1', '4', 5);
        graph1.addEdge('4', '3', 2);
        graph1.addEdge('3', '2', -10);
        graph1.addEdge('1', '2', 3);
        System.out.println("Graph1: Dijkstra shortest path" + graph1.dijkstraShortestPath('1'));
        System.out.println("Graph1: Bellman ford shortest path" + graph1.bellmanFordShortestPath('1'));


        WeightedGraph graph2 = new WeightedGraph(7);
        graph2.addVertex('1'); // 0
        graph2.addVertex('2'); // 1
        graph2.addVertex('3'); // 2
        graph2.addVertex('4'); // 3
        graph2.addVertex('5'); // 4
        graph2.addVertex('6'); // 5
        graph2.addVertex('7'); // 6

        graph2.addEdge('6', '1', 10);
        graph2.addEdge('1', '6', 10);

        graph2.addEdge('5', '6', 25);
        graph2.addEdge('6', '5', 25);

        graph2.addEdge('1', '2', 28);
        graph2.addEdge('2', '1', 28);

        graph2.addEdge('5', '5', 24);
        graph2.addEdge('7', '7', 24);

        graph2.addEdge('2', '7', 14);
        graph2.addEdge('7', '2', 14);

        graph2.addEdge('4', '5', 22);
        graph2.addEdge('5', '4', 22);

        graph2.addEdge('4', '7', 18);
        graph2.addEdge('7', '4', 18);

        graph2.addEdge('4', '3', 12);
        graph2.addEdge('3', '4', 12);

        graph2.addEdge('2', '3', 16);
        graph2.addEdge('3', '2', 16);

        WeightedGraph primResult = graph2.minSpanningTreePrim();

        System.out.print("Graph2: Prim's algorithm for min spanning tree ");
        primResult.printUsingBFS(primResult.vertices.get(0).label);
        System.out.println();

        WeightedGraph kruskalResult = graph2.minSpanningTreePrim();
        System.out.print("Graph2: Kruskal's algorithm for min spanning tree ");
        kruskalResult.printUsingBFS(kruskalResult.vertices.get(0).label);

    }
}
