package com.learning.twentysix.twopointers;

public class ReverseWordsInSentence {

	public static void main(String[] args) {

	}

	public static String reverseWords(String sentence) {

		var words = sentence.split(" ");

		var l = 0;
		var r = words.length - 1;

		while (l < r) {
			var tmp = words[l];
			words[l] = words[r];
			words[r] = tmp;
			l++;
			r--;
		}

		return String.join(" ", words);
	}

}
