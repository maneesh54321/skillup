package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class IsGraphBipartite {

    public static void main(String[] args) {
        IsGraphBipartite main = new IsGraphBipartite();

//        System.out.println(main.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
//        System.out.println(main.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));

//        [[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]
        System.out.println(main.isBipartite(new int[][]{{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}}));
    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int j = 0; j < graph.length; j++) {
            if(color[j] < 0){
                Deque<Integer> q = new ArrayDeque<>();
                q.offer(j);
                color[j] = 0;
                while (!q.isEmpty()) {
                    Integer front = q.remove();
                    for (int i = 0; i < graph[front].length; i++) {
                        if (color[graph[front][i]] < 0) {
                            color[graph[front][i]] = 1 - color[front];
                            q.offer(graph[front][i]);
                        } else {
                            if (color[graph[front][i]] == color[front]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
