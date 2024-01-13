package com.learning.twentythree.dsalgo.graph.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSrcToTarget {

    public static void main(String[] args) {
        AllPathsFromSrcToTarget main = new AllPathsFromSrcToTarget();

        System.out.println(main.allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}}));
        System.out.println(main.allPathsSourceTarget(new int[][]{{4,3,1}, {3,2,4}, {3}, {4}, {}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(graph, 0, graph.length-1, result, path);
        return result;
    }

    private void dfs(int[][] graph, int src, int target, List<List<Integer>> result, LinkedList<Integer> path) {
        path.add(src);
        if(src == target){
            result.add(new ArrayList<>(path));
        } else {
            if(graph[src].length != 0){
                for (int i = 0; i < graph[src].length; i++) {
                    dfs(graph, graph[src][i], target, result, path);
                }
            }
        }
        path.removeLast();
    }
}
