package com.eurela.project.problem_32;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {

    public static long compute() {
        return IntStream.rangeClosed(1, 10_000)
                .filter(e -> isPandigitalProduct(e))
                .sum();
    }

    public static boolean isPandigitalProduct(int productResult) {
        return IntStream.rangeClosed(1, productResult)
                .filter(e -> productResult % e == 0)
                .anyMatch(e -> isPandigital(e, productResult));
    }

    private static boolean isPandigital(int number, int productResult) {
        String stringNumber = "" + number + productResult + productResult / number;
        Set<String> strings = new HashSet<>(Arrays.asList(stringNumber.split("(?!^)")));
        int sum = strings.stream()
                .mapToInt(Integer::valueOf)
                .sum();
        return sum == 45;
    }
}
