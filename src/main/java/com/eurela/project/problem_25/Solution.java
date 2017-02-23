package com.eurela.project.problem_25;


import java.math.BigDecimal;
import java.util.stream.Stream;

public class Solution {

    private static int index = 1;

    //to solve problem numberLength = 1000
    public static int compute(int numberLength) {
        Stream.iterate(new BigDecimal[]{BigDecimal.ONE, BigDecimal.ONE},
                p -> new BigDecimal[]{p[1], getAdd(p)})
                .map(e -> String.valueOf(e[0].toString()))
                .filter(e -> e.length() == numberLength)
                .limit(1)
                .findAny()
                .get();
        return index;
    }

    private static BigDecimal getAdd(BigDecimal[] p) {
        index++;
        return p[0].add(p[1]);
    }

}
