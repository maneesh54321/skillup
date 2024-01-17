package com.learning.twentyfour.dsalgo.array;

public class UniqueNumberOfOccurrences {

	public static void main(String[] args) {
//		int[] inputArr = {1,2,2,1,1,3};
		int[] inputArr = {1,2};
		System.out.println(uniqueOccurrences(inputArr));
	}

	public static boolean uniqueOccurrences(int[] arr) {
		if(arr.length <=1 ){
			return true;
		}

		int[] occurrences = new int[2001];
		for (int i = 0; i < arr.length; i++) {
			occurrences[arr[i]+1000]++;
		}
		int[] freqs = new int[2001];
		for (int i = 0; i < 2001; i++) {
			int occurence = occurrences[i];
			if(occurence > 0){
				freqs[occurence]++;
				if(freqs[occurence] > 1) {
					return false;
				}
			}
		}
		return true;
	}
}
