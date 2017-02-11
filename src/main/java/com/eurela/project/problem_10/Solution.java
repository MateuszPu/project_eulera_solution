package com.eurela.project.problem_10;


import java.util.stream.LongStream;

public class Solution {

    //to solve problem maxNumberOfPrime = 2_000_000
    public static long compute(int maxNumberOfPrime) {
        return LongStream.iterate(2, e -> e + 1)
                .limit(maxNumberOfPrime - 1)
                .filter(e -> isPrime(e))
                .sum();
    }

    public static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

}
