package com.learning;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        // Case1
        System.out.println(Main.getQueryStrings(List.of("sepde", "deul", "dule", "duele"), List.of("speed", "duel")));
    }

    public static List<List<String>> getQueryStrings(List<String> words, List<String> queries) {
        HashMap<String, List<String>> hash = new HashMap<>();
        String sortedString;
        for (String word : words) {
            byte[] bword = word.getBytes();
            Arrays.sort(bword);
            sortedString = new String(bword);
            hash.putIfAbsent(sortedString, new ArrayList<>());
            hash.get(sortedString).add(word);
        }
        List<List<String>> result = new ArrayList<>();
        for (String query : queries) {
            byte[] bquery = query.getBytes();
            Arrays.sort(bquery);
            sortedString = new String(bquery);
            if (hash.containsKey(sortedString)) {
                result.add(hash.get(sortedString));
            }
        }
        return result;
    }
}