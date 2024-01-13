package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.*;

public class CloneGraph {

    public Node cloneGraph_BFS(Node node) {
        if (node == null) {
            return null;
        }
        Deque<Node> q = new ArrayDeque<>();
        q.offer(node);

        Map<Integer, Node> graph = new HashMap<>();

        Set<Integer> visited = new HashSet<>();

        while (!q.isEmpty()) {
            Node front = q.poll();
            if (!visited.contains(front.val)) {
                visited.add(front.val);
                Node newNode;
                if (graph.get(front.val) != null) {
                    newNode = graph.get(front.val);
                } else {
                    newNode = new Node(front.val);
                }
                graph.put(front.val, newNode);
                for (Node neighbour : front.neighbors) {
                    Node newNeighbour;
                    if (graph.get(neighbour.val) != null) {
                        newNeighbour = graph.get(neighbour.val);
                    } else {
                        newNeighbour = new Node(neighbour.val);
                        graph.put(neighbour.val, newNeighbour);
                    }
                    newNode.neighbors.add(newNeighbour);
                    q.offer(neighbour);
                }
            }
        }

        return graph.get(node.val);
    }

    public Node cloneGraph_DFS_iterative(Node node) {
        if (node == null) {
            return null;
        }
        Node[] graph = new Node[101];

        boolean[] visited = new boolean[101];

        Deque<Node> stack = new ArrayDeque<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            Node top = stack.pop();
            if (!visited[top.val]) {
                visited[top.val] = true;
                Node newNode;
                if (graph[top.val] == null) {
                    newNode = new Node(top.val);
                    graph[top.val] = newNode;
                } else {
                    newNode = graph[top.val];
                }
                for (Node neighbour : top.neighbors) {
                    Node newNeighbourNode;
                    if (graph[neighbour.val] == null) {
                        newNeighbourNode = new Node(neighbour.val);
                        graph[neighbour.val] = newNeighbourNode;
                    } else {
                        newNeighbourNode = graph[neighbour.val];
                    }
                    newNode.neighbors.add(newNeighbourNode);
                    stack.push(neighbour);
                }
            }
        }
        return graph[node.val];
    }

    public Node cloneNode_DFS(Node node, Node[] visited) {
        if (visited[node.val] == null) {
            Node newNode = new Node(node.val);
            visited[newNode.val] = newNode;
            for (Node neighbour : node.neighbors) {
                newNode.neighbors.add(cloneNode_DFS(neighbour, visited));
            }
            return newNode;
        } else {
            return visited[node.val];
        }
    }




    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
