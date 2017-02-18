package com.eurela.project.problem_21;


import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class Solution {

    public static long compute(int number) {
        LongPredicate sumSameAsInput = e -> calculateSumOfDivisors(e) != e;
        LongPredicate isAmicable = e -> calculateSumOfDivisors(calculateSumOfDivisors(e)) == e;

        return LongStream.rangeClosed(1, number)
                .parallel()
                .filter(sumSameAsInput.and(isAmicable))
                .sum();
    }

    public static long calculateSumOfDivisors(long number) {
        return LongStream.rangeClosed(1, number/2)
                .filter(e -> number % e == 0)
                .sum();
    }
}
