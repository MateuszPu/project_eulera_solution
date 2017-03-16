package com.eurela.project.problem_33;


import java.math.BigDecimal;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Solution {

	public static double compute() {
		double asDouble = IntStream.rangeClosed(11, 99)
				.filter(e -> e % 10 != 0)
				.filter(e -> calculate(e).isPresent())
				.mapToDouble(e -> calculate(e).getAsDouble())
				.reduce((x, y) -> multiply(x, y))
				.getAsDouble();
		return asDouble;
	}

	private static double multiply(double x, double y) {
		BigDecimal bigDecimal = new BigDecimal(String.valueOf(x));
		BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(y));
		return bigDecimal.multiply(bigDecimal1).doubleValue();
	}

	public static OptionalDouble calculate(int numerator) {
		return IntStream.rangeClosed(numerator + 1, 99)
				.filter(e -> e % 10 != 0)
				.filter(e -> canCancelFraction(numerator, e))
				.mapToDouble(e -> numerator * 1.0 / e)
				.findAny();
	}

	public static boolean canCancelFraction(int numerator, int denominator) {
		double result = numerator * 1.0 / denominator;

		int firstDigitOfNumerator = numerator / 10;
		int secondDigitOfNumerator = numerator % 10;

		int firstNumberOfDenominator = denominator / 10;
		int secondDigitOfDenominator = denominator % 10;

		if (firstDigitOfNumerator == firstNumberOfDenominator) {
			return result == secondDigitOfNumerator * 1.0 / secondDigitOfDenominator;
		}

		if (firstDigitOfNumerator == secondDigitOfDenominator) {
			return result == secondDigitOfNumerator * 1.0 / firstNumberOfDenominator;
		}

		if (secondDigitOfNumerator == firstNumberOfDenominator) {
			return result == firstDigitOfNumerator * 1.0 / secondDigitOfDenominator;
		}

		if (secondDigitOfNumerator == secondDigitOfDenominator) {
			return result == firstDigitOfNumerator * 1.0 / firstNumberOfDenominator;
		}

		return false;
	}
}
