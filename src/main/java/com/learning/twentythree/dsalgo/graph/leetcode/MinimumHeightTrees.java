package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.*;

public class MinimumHeightTrees {

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        MinimumHeightTrees main = new MinimumHeightTrees();

        System.out.println(main.findMinHeightTrees(n, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        int[] inDegrees = new int[n];

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            inDegrees[edge[1]]++;
            adjList[edge[1]].add(edge[0]);
            inDegrees[edge[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;

            while (size-- > 0) {
                int top = q.remove();
                for (Integer adjVertex : adjList[top]) {
                    inDegrees[adjVertex]--;
                    if (inDegrees[adjVertex] == 1)
                        q.offer(adjVertex);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.remove());
        }

        return result;
    }
}
