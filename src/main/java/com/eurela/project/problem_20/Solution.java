package com.eurela.project.problem_20;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    public static long compute(int number) {
        return Arrays.stream(IntStream.rangeClosed(1, number)
                .mapToObj(BigDecimal::new)
                .reduce(BigDecimal.ONE, BigDecimal::multiply)
                .toString()
                .split("(?!^)"))
                .mapToInt(e -> Integer.valueOf(e))
                .sum();

    }
}
