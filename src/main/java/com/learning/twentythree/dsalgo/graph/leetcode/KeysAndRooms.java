package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.List;

public class KeysAndRooms {

    public static void main(String[] args) {
        KeysAndRooms main = new KeysAndRooms();

        System.out.println(main.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println(main.canVisitAllRooms(List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(0))));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(rooms, visited, 0);

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int src) {
        visited[src] = true;
        for (Integer key: rooms.get(src)){
            if(!visited[key]){
                dfs(rooms, visited, key);
            }
        }
    }
}
