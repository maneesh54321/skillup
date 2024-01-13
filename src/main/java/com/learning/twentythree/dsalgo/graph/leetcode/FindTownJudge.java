package com.learning.twentythree.dsalgo.graph.leetcode;

public class FindTownJudge {
    public static void main(String[] args) {
        FindTownJudge main = new FindTownJudge();

        System.out.println(main.findJudge(2, new int[][]{{1,2}}));
    }

    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n];
        int[] outDegrees = new int[n];

        for (int i = 0; i < trust.length; i++) {
            inDegrees[trust[i][1]-1]++;
            outDegrees[trust[i][0]-1]++;
        }

        for (int i = 0; i < n; i++) {
            if(inDegrees[i] == n-1 && outDegrees[i] == 0){
                return i+1;
            }
        }
        return -1;
    }
}
