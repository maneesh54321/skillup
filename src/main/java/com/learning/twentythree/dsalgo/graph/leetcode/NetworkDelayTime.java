package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public static void main(String[] args) {
        NetworkDelayTime main = new NetworkDelayTime();

        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        System.out.println(main.networkDelayTime(times, n, k));
    }

    private class DistanceNode implements Comparable<DistanceNode> {

        Integer weight;
        int srcLabel;

        public DistanceNode(int weight, int srcLabel) {
            this.weight = weight;
            this.srcLabel = srcLabel;
        }

        @Override
        public int compareTo(DistanceNode o) {
            return this.weight.compareTo(o.weight);
        }
    }

    private class Edge {

        Integer weight;
        int targetLabel;

        public Edge(Integer weight, int targetLabel) {
            this.weight = weight;
            this.targetLabel = targetLabel;
        }
    }


    public int networkDelayTime(int[][] times, int n, int k) {
//        Creating distance table
        int[] distances = new int[n + 1];

        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[k] = 0;

//        Creating Adjacency List
        ArrayList<Edge>[] adjLists = new ArrayList[n + 1];

        for (int i = 1; i < adjLists.length; i++) {
            adjLists[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            adjLists[time[0]].add(new Edge(time[2], time[1]));
        }
        PriorityQueue<DistanceNode> pq = new PriorityQueue<>();
        DistanceNode initialNode = new DistanceNode(0, k);
        pq.offer(initialNode);

        while (!pq.isEmpty()) {
            DistanceNode minDistanceNode = pq.remove();
            for (Edge edge : adjLists[minDistanceNode.srcLabel]) {
                if (minDistanceNode.weight + edge.weight < distances[edge.targetLabel]) {
                    distances[edge.targetLabel] = minDistanceNode.weight + edge.weight;
                    pq.offer(new DistanceNode(distances[edge.targetLabel], edge.targetLabel));
                }
            }
        }

        int max = -1;

        for (int i = 1; i < distances.length; i++) {
            if(distances[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, distances[i]);
        }

        return max;
    }
}
