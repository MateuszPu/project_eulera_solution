package com.eurela.project.problem_7;


import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Solution {

    //to solve problem number = 10_001
    public static int compute(int numberOfPrime) {
        return Stream.iterate(2, e -> e + 1)
                .filter(e -> isPrime(e))
                .limit(numberOfPrime)
                .mapToInt(e -> e)
                .max()
                .getAsInt();
    }

    public static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
