package com.eurela.project.problem_37;


import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Solution {

	public static long compute() {
		return IntStream.iterate(10, i -> i + 1)
				.filter(e -> isPrimeFromLeft(e))
				.filter(e -> isPrimeFromRight(e))
				.limit(11)
				.sum();
	}

	public static boolean isPrimeFromRight(int number) {
		int temp = number;
		while (temp > 0) {
			if (!isPrime(temp)) {
				return false;
			}
			temp /= 10;
		}
		return true;
	}

	public static boolean isPrimeFromLeft(int number) {
		int n = 10;
		while (number % n != number) {
			if (!isPrime(number % n)) {
				return false;
			}
			n *= 10;
		}
		return isPrime(number);
	}

	public static boolean isPrime(long number) {
		if(number == 1) {
			return false;
		}
		return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
				.allMatch(n -> number % n != 0);
	}
}
