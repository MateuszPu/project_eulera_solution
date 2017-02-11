package com.eurela.project.problem_6;


import java.util.stream.Stream;

public class Solution {

    //to solve problem number = 100
    public static int compute(int number) {
        return squareOfSum(number) - sumOfSquares(number);
    }

    public static int sumOfSquares(int number) {
        return Stream.iterate(1, e -> e + 1)
                .limit(number)
                .map(e -> (int) Math.pow(e, 2))
                .mapToInt(e -> e)
                .sum();
    }

    public static int squareOfSum(int number) {
        return (int) Math.pow(Stream.iterate(1, e -> e + 1)
                .limit(number)
                .mapToInt(e -> e)
                .sum(), 2);

    }
}
