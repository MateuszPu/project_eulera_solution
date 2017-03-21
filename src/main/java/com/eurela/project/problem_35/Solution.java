package com.eurela.project.problem_35;


import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Solution {

	public static long compute() {
		return IntStream.rangeClosed(2, 1_000_000)
				.filter(e -> isPrime(e))
				.filter(e -> isCircularPrime(e))
				.count();
	}

	private static boolean isPrime(long number) {
		return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
				.allMatch(n -> number % n != 0);
	}

	private static boolean isCircularPrime(int number) {
		String stringNumber = String.valueOf(number);

		for (int i = 1; i < stringNumber.length(); i++) {
			if (!isPrime(Integer.valueOf(stringNumber.substring(i) + stringNumber.substring(0, i)))) {
				return false;
			}
		}
		return true;
	}
}
