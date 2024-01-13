package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightsWithKStopsDjikstra {

    public static void main(String[] args) {
        CheapestFlightsWithKStopsDjikstra main = new CheapestFlightsWithKStopsDjikstra();

        System.out.println(main.findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));

        System.out.println(main.findCheapestPrice(5, new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}}, 0, 2, 2));

        System.out.println(main.findCheapestPrice(9, new int[][]{{0,1,1}, {1,2,1}, {2,3,1}, {3,7,1}, {0,4,3}, {4,5,3}, {5,7,3}, {0,6,5}, {6,7,100}, {7,8,1}}, 0, 8, 3));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            adjList[flight[0]].add(new Edge(flight[2], flight[1]));
        }

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src] = 0;

        PriorityQueue<PriceNodeWithStops> pq = new PriorityQueue<>();

        pq.offer(new PriceNodeWithStops(src, 0, 0));

        while (!pq.isEmpty()) {
            PriceNodeWithStops minPriceNode = pq.remove();
            if (minPriceNode.node == dst) return minPriceNode.price;
            if (minPriceNode.stopsUntilNow == k) continue;
            int nextStops = minPriceNode.stopsUntilNow + 1;
            for (Edge flight : adjList[minPriceNode.node]) {
                int nextPrice = minPriceNode.price + flight.price;
                if (prices[flight.dst] > nextPrice) {
                    prices[flight.dst] = nextPrice;
                    stops[flight.dst] = nextStops;
                    pq.offer(new PriceNodeWithStops(flight.dst, nextPrice, nextStops));
                } else if (stops[flight.dst] > nextStops) {
                    stops[flight.dst] = nextStops;
                    pq.offer(new PriceNodeWithStops(flight.dst, nextPrice, nextStops));
                }
            }
        }

        return -1;
    }

    private class PriceNodeWithStops implements Comparable<PriceNodeWithStops> {

        private int node;
        private int price;
        private int stopsUntilNow;

        public PriceNodeWithStops(int node, int price, int stopsUntilNow) {
            this.node = node;
            this.price = price;
            this.stopsUntilNow = stopsUntilNow;
        }

        @Override
        public int compareTo(PriceNodeWithStops o) {
            return Integer.compare(price, o.price);
        }
    }

    private class Edge {
        int price;
        int dst;

        public Edge(int price, int dst) {
            this.price = price;
            this.dst = dst;
        }
    }
}
