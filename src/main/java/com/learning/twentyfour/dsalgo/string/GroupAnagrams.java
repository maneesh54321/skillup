package com.learning.twentyfour.dsalgo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(arr);
		System.out.println(result);
	}

	public static List<List<String>> groupAnagrams(String[] arr) {
		List<List<String>> result = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return result;
		}
		if (arr.length == 1) {
			result.add(new ArrayList<>(List.of(arr[0])));
			return result;
		}
		int currGroup = 1;
		int[] groups = new int[arr.length];
		int i = 0;
		while(i < arr.length){
			if (groups[i] == 0) {
				int j = i;
				while (j < arr.length && groups[j] != 0) {
					j++;
				}
				int[] freq = new int[26];
				for (char c : arr[j].toCharArray()) {
					freq[c - 'a']++;
				}
				groups[j] = currGroup;
				j++;
				while (j < arr.length) {
					if (groups[j] == 0) {
						int[] freq1 = new int[26];
						for (char c : arr[j].toCharArray()) {
							freq1[c - 'a']++;
						}
						boolean isAnagram = true;
						for (int k = 0; k < freq.length; k++) {
							if (freq1[k] != freq[k]) {
								isAnagram = false;
								break;
							}
						}
						if (isAnagram) {
							groups[j] = currGroup;
						}
					}
					j++;
				}
				currGroup++;
			}
			i++;
		}
		for (int x = 0; x < groups.length; x++) {
			if (result.isEmpty() || result.size() < groups[x]) {
				result.add(new ArrayList<>());
			}
			result.get(groups[x] - 1).add(arr[x]);
		}
		return result;
	}
}
