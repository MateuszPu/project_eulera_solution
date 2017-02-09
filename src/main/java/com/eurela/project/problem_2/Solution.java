package com.eurela.project.problem_2;


import java.util.stream.Stream;

public class Solution {

    //for solve problem limit = 4_000_000
    public static long compute(long limit) {
        return Stream.iterate(new long[]{1, 2}, p -> new long[]{p[1], p[0] + p[1]})
                .limit(100)
                .filter(e -> e[0] < limit && e[0] > 0)
                .mapToLong(e -> e[0])
                .filter(e -> e % 2 == 0)
                .sum();
    }
}
