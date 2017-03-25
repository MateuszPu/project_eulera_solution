package com.eurela.project.problem_36;


import java.util.stream.IntStream;

public class Solution {

	public static long compute() {
		return IntStream.range(1, 1_000_000)
				.filter(e -> isPalindrom(Integer.toString(e)))
				.filter(e -> isPalindrom(Integer.toBinaryString(e)))
				.sum();
	}

	private static boolean isPalindrom(String number) {
		StringBuilder sb = new StringBuilder(String.valueOf(number)).reverse();
		return number.equals(sb.toString());
	}
}
