package com.eurela.project.problem_1;


import java.util.stream.Stream;

public class Solution {

    public static int compute(int n) {
        return Stream.iterate(0, e -> e+1)
                .limit(n)
                .filter(e -> e % 5 == 0 || e % 3 == 0)
                .mapToInt(e -> e)
                .sum();
    }
}
