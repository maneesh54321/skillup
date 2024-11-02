package com.learning.twentyfour.phase2.dsalgo.disjointsets;

public class App {

    public static void main(String[] args) {
//        var disjointSet = new DisjointSetByRank(7);
        var disjointSet = new DisjointSetBySize(7);

        disjointSet.union(1, 2);
        disjointSet.union(2, 3);
        disjointSet.union(4, 5);
        disjointSet.union(6, 7);
        System.out.printf("Same Parent? (%d, %d) = %s%n", 1, 3, disjointSet.findUPar(1) == disjointSet.findUPar(3));
        System.out.printf("Same Parent? (%d, %d) = %s%n", 5, 6, disjointSet.findUPar(5) == disjointSet.findUPar(6));

        disjointSet.union(5, 6);
        System.out.printf("Same Parent? (%d, %d) = %s%n", 5, 6, disjointSet.findUPar(5) == disjointSet.findUPar(6));
    }
}
