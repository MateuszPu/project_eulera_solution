package com.eurela.project.problem_3;


import java.util.stream.LongStream;

public class Solution {

    //for solve problem limit = 600_851_475_143L
    public static long compute(long number) {
        return LongStream.range(1, (long) (Math.sqrt(number)))
                .filter(e -> number % e == 0)
                .filter(e -> isPrime(e))
                .max()
                .getAsLong();
    }

    public static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
