package com.learning.twentyfour.dsalgo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AutoCorrectPrototype {
	public static List<List<String>> getSearchResults(List<String> words, List<String> queries) {
		// Write your code here
		Map<String, List<String>> map = new LinkedHashMap<>();
		for(String query: queries){
			char[] queryArr = query.toCharArray();
			Arrays.sort(queryArr);
			String sortedQuery = new String(queryArr);
			map.put(sortedQuery, new ArrayList<>());

		}
		for(String word : words){
			char[] wordArr = word.toCharArray();
			Arrays.sort(wordArr);
			String sortedQuery = new String(wordArr);
			if(map.containsKey(sortedQuery)){
				map.get(sortedQuery).add(word);
			}
		}
		return map.values().stream().map(list -> {
			Collections.sort(list);
			return list;
		}).collect(Collectors.toList());
	}
}
