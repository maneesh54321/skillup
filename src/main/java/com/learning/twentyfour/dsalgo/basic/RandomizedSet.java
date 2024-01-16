package com.learning.twentyfour.dsalgo.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

	private List<Integer>[] table;

	private int hashTableSize;

	private Random random;

	private int totalElements;

	public RandomizedSet() {
		hashTableSize = 16;
		table = new List[hashTableSize];
		for (int i = 0; i < hashTableSize; i++) {
			table[i] = new ArrayList<>();
		}
		random = new Random();
	}

	private int generateHash(int key) {
		return Math.abs(key % hashTableSize);
	}

	public boolean insert(int val) {
		List<Integer> row = table[generateHash(val)];
		for (Integer ele : row) {
			if (ele == val) {
				return false;
			}
		}
		row.add(val);
		totalElements++;
		return true;
	}

	public boolean remove(int val) {
		List<Integer> row = table[generateHash(val)];
		for (int i = 0; i < row.size(); i++) {
			if (row.get(i) == val) {
				row.remove(i);
				totalElements--;
				return true;
			}
		}
		return false;
	}

	public int getRandom() {
		int randomIdx = random.nextInt(1,totalElements + 1);
		int idx = 0;
		while (randomIdx > table[idx].size()) {
			randomIdx -= table[idx++].size();
		}
		return table[idx].get(randomIdx - 1);
	}
}
