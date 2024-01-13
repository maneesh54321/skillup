package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.*;

public class EvaluateDivision {

    public static void main(String[] args) {
        EvaluateDivision main = new EvaluateDivision();
        System.out.println(Arrays.toString(main.calcEquation(List.of(List.of("a", "b"), List.of("b", "c")),
                new double[]{2.0, 3.0},
                List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x")))));

        System.out.println(Arrays.toString(main.calcEquation(List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc","cd")),
                new double[]{1.5,2.5,5.0},
                List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc","cd"), List.of("cd","bc")))));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String srcLabel = equations.get(i).get(0);
            String destLabel = equations.get(i).get(1);
            if (!graph.containsKey(srcLabel)) {
                graph.put(srcLabel, new ArrayList<>());
            }
            if (!graph.containsKey(destLabel)) {
                graph.put(destLabel, new ArrayList<>());
            }

            graph.get(srcLabel).add(new Edge(values[i], destLabel));
            graph.get(destLabel).add(new Edge(1 / values[i], srcLabel));
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String src = query.get(0);
            String dest = query.get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                result[i] = -1.0;
            } else if (src.equals(dest)) {
                result[i] = 1.0;
            } else {
                Map<String, Boolean> visited = new HashMap<>();
                result[i] = dfs(graph, src, dest, 1.0, visited);
            }
        }
        return result;
    }

    public double dfs(Map<String, List<Edge>> graph, String src, String dest, double result, Map<String, Boolean> visited) {
        if(!graph.get(src).isEmpty()){
            visited.put(src, true);
            for (Edge edge : graph.get(src)) {
                if(!visited.containsKey(edge.targetVertex)){
                    if (edge.targetVertex.equals(dest)) {
                        return result * edge.weight;
                    } else {
                        double belowRes = dfs(graph, edge.targetVertex, dest, result * edge.weight, visited);
                        if(belowRes != -1.0) {
                            return belowRes;
                        }
                    }
                }
            }
        }
        return -1.0;
    }

    private static class Edge {
        Double weight;
        String targetVertex;

        public Edge(Double weight, String targetVertex) {
            this.weight = weight;
            this.targetVertex = targetVertex;
        }
    }
}
