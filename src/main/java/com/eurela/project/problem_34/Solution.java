package com.eurela.project.problem_34;


import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Solution {

	private static final HashMap<Integer, Integer> factorialCache = new HashMap<>();

	public static int compute() {
		return IntStream.rangeClosed(3, 1_000_00)
				.filter(e -> isSumOfFactorial(e))
				.sum();
	}

	private static boolean isSumOfFactorial(int number) {
		int sum1 = Arrays.stream(String.valueOf(number).split("(?)"))
				.mapToInt(e -> getFactorial(Integer.valueOf(e)))
				.sum();
		return number == sum1;
	}

	private static int getFactorial(int i) {
		factorialCache.computeIfAbsent(i, e -> calculateFactorial(i));
		return factorialCache.get(i);
	}

	private static Integer calculateFactorial(int i) {
		return IntStream.rangeClosed(1, i)
				.reduce(1, (e1, e2) -> e1 * e2);
	}
}
