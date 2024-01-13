package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    public static void main(String[] args) {
        NumberOfProvinces main = new NumberOfProvinces();
        System.out.println(main.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }

    public int findCircleNum(int[][] isConnected) {
        DisjointSet ds = new DisjointSet(isConnected.length);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1){
                    ds.unionByRank(i+1, j+1);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= isConnected.length; i++) {
            set.add(ds.findUlp(i));
        }
        return set.size();
    }

    public int findCircleNum_1(int[][] isConnected) {
        if (isConnected.length == 0) {
            return 0;
        }
        boolean[] visited = new boolean[isConnected.length];

        int numOfProvinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                crawlProvince(isConnected, visited, i+1);
                numOfProvinces++;
            }
        }
//        Deque<Integer> q = new ArrayDeque<>();
//
//        int numOfProvinces = 0;
//
//        for (int i = 1; i <= isConnected.length; i++) {
//            if (!visited[i-1]) {
//                q.offer(i);
//                while (!q.isEmpty()) {
//                    Integer front = q.poll();
//                    visited[front-1] = true;
//                    for (int j = 1; j <= isConnected.length; j++) {
//                        if (isConnected[front - 1][j-1] == 1 && !visited[j-1]) {
//                            q.offer(j);
//                        }
//                    }
//                }
//                numOfProvinces++;
//            }
//        }

        return numOfProvinces;
    }

    public void crawlProvince(int[][] isConnected, boolean[] visited, int src){
        visited[src-1] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if(isConnected[src-1][j] == 1 && !visited[j]){
                crawlProvince(isConnected, visited, j+1);
            }
        }
    }

}
