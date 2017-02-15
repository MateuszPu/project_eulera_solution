package com.eurela.project.problem_16;


import java.math.BigDecimal;
import java.util.Arrays;

public class Solution {

    //to solve problem pow = 1_000
    public static int compute(int pow) {
        BigDecimal two = new BigDecimal("2");
        BigDecimal powerOfTwo = two.pow(pow);
        return Arrays.stream(powerOfTwo.toString().split("(?!^)"))
                .mapToInt( e-> Integer.valueOf(e))
                .sum();
    }

}
