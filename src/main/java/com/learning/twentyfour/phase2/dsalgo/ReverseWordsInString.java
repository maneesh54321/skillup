package com.learning.twentyfour.phase2.dsalgo;

public class ReverseWordsInString {

	public static void main(String[] args) {
		var s = "the sky is blue";
//		var s = "   Helow   world";

		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
		if (s.isBlank()) {
			return "";
		}

		s = s.trim();

		if (s.length() == 1) {
			return s;
		}

		char prevChar = s.charAt(s.length() - 1);

		var result = new StringBuilder();

		var currentWord = new StringBuilder();
		currentWord.append(prevChar);

		for (int i = s.length() - 2; i >= 0; i--) {
			char c = s.charAt(i);

			if (prevChar == ' ' && c == ' ') {
				continue;
			}

			if (prevChar != ' ' && c == ' ') {
				result.append(currentWord.reverse()).append(' ');
				currentWord = new StringBuilder();
			} else {
				currentWord.append(c);
			}
			prevChar = c;
		}

		result.append(currentWord.reverse());

		return result.toString();

	}

}
