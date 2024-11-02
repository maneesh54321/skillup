package com.learning.twentyfour.phase2.dsalgo;

public class ZigzagConversion {

	public static void main(String[] args) {
//		String s = "PAYPALISHIRING";
		String s = "ABCD";
		int numRows = 2;

		System.out.println(convert(s, numRows));
	}

	public static String convert(String s, int numRows) {
		if(numRows ==1) return s;
		var rows = new StringBuilder[numRows];

		for (int i = 0; i < rows.length; i++) {
			rows[i] = new StringBuilder();
		}

		boolean straight = true;

		int i = 0;

		int j = 0;

		int k = numRows - 2;

		while (i < s.length()) {
			if (straight) {
				if (j == numRows - 1) {
					rows[j].append(s.charAt(i));
					straight = false;
					j = 0;
				} else {
					rows[j++].append(s.charAt(i));
				}
			} else {
				if (k==0 ){
					straight = true;
					continue;
				} else if (k == 1) {
					rows[k].append(s.charAt(i));
					straight = true;
					k = numRows - 2;
				} else {
					rows[k--].append(s.charAt(i));
				}
			}

			i++;
		}

		var result = new StringBuilder();
		for (StringBuilder row : rows) {
			result.append(row);
		}

		return result.toString();
	}

}
