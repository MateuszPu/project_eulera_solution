package com.eurela.project.problem_29;


import java.math.BigDecimal;
import java.util.stream.Stream;

public class Solution {

    public static long compute() {
        return Stream.iterate(2, a -> a + 1)
                .limit(99)
                .flatMap(a -> pow(a))
                .distinct()
                .count();
    }

    private static Stream pow(int a) {
        return Stream.iterate(new BigDecimal(2), b -> b.add(BigDecimal.ONE))
                .limit(99)
                .map(b -> b.pow(a));
    }
}
