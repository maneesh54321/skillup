package com.learning.twentyfour.phase2.dsalgo;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerToRoman {

	static Map<Integer, String> map1 = Map.of(
			3000, "MMM",
			2000, "MM",
			1000, "M",
			900, "CM",
			800, "DCCC",
			700, "DCC",
			600, "DC",
			500, "D",
			400, "CD",
			300, "CCC"
	);
	static Map<Integer, String> map2 = Map.of(
			200, "CC",
			100, "C",
			90, "XC",
			80, "LXXX",
			70, "LXX",
			60, "LX",
			50, "L",
			40, "XL",
			30, "XXX",
			20, "XX"
	);

	static Map<Integer, String> map3 = Map.of(
			10, "X",
			9, "IX",
			8, "VIII",
			7, "VII",
			6, "VI",
			5, "V",
			4, "IV",
			3, "III",
			2, "II",
			1, "I"
	);

	static Map<Integer, String> map = Stream.concat(
					Stream.concat(map1.entrySet().stream(), map2.entrySet().stream()), map3.entrySet().stream())
			.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

	public static void main(String[] args) {
//		int num = 58;
//		int num = 3749;
		int num = 1994;

		System.out.println(intToRoman(num));
	}

	public static String intToRoman(int num) {

		var result = new StringBuilder();

		int start = 1000;
		while (num > 0) {
			if (num / start > 0) {
				result.append(toRoman((num / start) * start));
				num = num % start;
			}
			start /= 10;
		}

		return result.toString();
	}

	private static String toRoman(int num) {
//		return map.get(num);

		return switch (num) {
			case 900 -> "CM";
			case 400 -> "CD";
			case 90 -> "XC";
			case 40 -> "XL";
			case 9 -> "IX";
			case 4 -> "IV";
			default -> calculateRoman(num);
		};
	}

	private static String calculateRoman(int num) {
//		if(num >= 1000) {
//
//		} else
		return "";
	}

}
