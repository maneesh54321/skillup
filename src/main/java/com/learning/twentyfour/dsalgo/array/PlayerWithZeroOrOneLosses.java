package com.learning.twentyfour.dsalgo.array;

import java.util.*;

public class PlayerWithZeroOrOneLosses {
    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result;
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] match : matches) {
            if(!map.containsKey(match[0])){
                map.put(match[0], 0);
            }
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }

        result = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).filter(entry -> entry.getValue() <=1).collect(() -> {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
            return list;
        }, (list, entry) -> {
            if(entry.getValue() == 0){
                list.getFirst().add(entry.getKey());
            } else {
                list.get(1).add(entry.getKey());
            }
        }, List::addAll);
//        Collections.sort(result.get(0));
//        Collections.sort(result.get(1));
        return result;
    }
}
