package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CheapestFlightsWithKStops {

    public static void main(String[] args) {
        CheapestFlightsWithKStops main = new CheapestFlightsWithKStops();

        System.out.println(main.findCheapestPriceBellmanFord(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));

        main.minPrice = Integer.MAX_VALUE;

        System.out.println(main.findCheapestPriceBellmanFord(5, new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}}, 0, 2, 2));

        main.minPrice = Integer.MAX_VALUE;

        System.out.println(main.findCheapestPriceBellmanFord(9, new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {3, 7, 1}, {0, 4, 3}, {4, 5, 3}, {5, 7, 3}, {0, 6, 5}, {6, 7, 100}, {7, 8, 1}}, 0, 8, 3));
    }

    int minPrice = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            adjList[flight[0]].add(new Edge(flight[2], flight[1]));
        }

        DFS(adjList, src, dst, k, 0, 0);
        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }

    public int findCheapestPriceBellmanFord(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        prices[src] = 0;

        while (k >= 0) {
            int[] tmp = Arrays.copyOf(prices, n);
            for (int i = 0; i < flights.length; i++) {
                int from = flights[i][0];
                int to = flights[i][1];
                int price = flights[i][2];
                if(prices[from] == Integer.MAX_VALUE){
                    continue;
                }
                tmp[to] = Math.min(prices[from] + price, tmp[to]);
            }
            prices = tmp;
            k--;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

    private void DFS(ArrayList<Edge>[] adjList, int src, int dst, int k, int stops, int price) {
        if (src == dst) minPrice = Math.min(price, minPrice);
        else {
            if (stops <= k) {
                stops++;
                for (Edge flight : adjList[src]) {
                    int nextPrice = flight.price + price;
                    if (nextPrice < minPrice) {
                        DFS(adjList, flight.dst, dst, k, stops, nextPrice);
                    }
                }
            }
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
