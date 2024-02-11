package com.learning.twentyfour.dsalgo.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort("Aabb"));
	}

	public static String frequencySort(String s) {
		return s.chars().mapToObj(c -> (char) c)
				.reduce(new HashMap<Character, Integer>(), (map, character) -> {
					map.put(character, map.getOrDefault(character, 0) + 1);
					return map;
				}, (m1, m2) -> {
					m1.putAll(m2);
					return m1;
				})
				.entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collector.of(StringBuilder::new, (a, b) -> {
					IntStream.range(0, b.getValue()).forEach(x -> a.append(b.getKey()));
				}, StringBuilder::append)).toString();

	}
}
