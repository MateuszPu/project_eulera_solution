package com.eurela.project.problem_5;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Solution {

    //for solve problem maxNumberToDivided = 20
    public static int compute(int maxNumberToDivided) {
        return Arrays.stream(computePrimesTo(maxNumberToDivided))
                .map(e -> lessThan(e, maxNumberToDivided))
                .reduce(1, Math::multiplyExact);
    }

    public static int lessThan(int number, int maxNumber) {
        return Stream.iterate(1, e -> e + 1)
                .limit(maxNumber)
                .map(e -> (int) Math.pow(number, e))
                .filter(e -> e < maxNumber)
                .max(Integer::compare)
                .get();
    }

    public static int[] computePrimesTo(int maxNumberOfPrime) {
        return IntStream.range(2, maxNumberOfPrime)
                .filter(e -> isPrime(e))
                .toArray();
    }

    public static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

}
