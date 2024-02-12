package com.learning;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GridJump {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        // Case 1
        System.out.println(GridJump.getMinMoves(List.of(List.of(0, 0, 1, 0, 0, 0), List.of(0, 0, 0, 0, 1, 0), List.of(0, 1, 0, 0, 0, 1), List.of(0, 0, 0, 1, 0, 0), List.of(0, 0, 1, 0, 1, 0), List.of(0, 0, 0, 0, 0, 0), List.of(0, 1, 0, 0, 0, 0)), 3));
    }

    public static int getMinMoves(List<List<Integer>> maze, int k) {
        int n = maze.size();
        int m = maze.get(0).size();
        if (maze.get(0).get(0) == 1 || k == 0)
            return -1;
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }
        grid[0][0] = 0;
        LinkedList<Pair> que = new LinkedList<>();
        int move = 0;
        que.add(new Pair(0, 0));
        Pair cur, temp;

        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        int p, q;
        while (!que.isEmpty()) {
            move += 1;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                cur = que.poll();
                grid[cur.x][cur.y] = move;
                for (int j = 0; j < 4; j++) {
                    for (int jump = 1; jump <= k; jump++) {
                        p=cur.x+x[j]*jump;
                        q=cur.y+y[j]*jump;
                        if(p>=0 && p<n && q>=0 && q<m && maze.get(p).get(q)!=1) {
                            que.add(new Pair(p,q));
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return grid[n-1][m-1]==Integer.MAX_VALUE?-1:grid[n-1][m-1];
    }

}

































