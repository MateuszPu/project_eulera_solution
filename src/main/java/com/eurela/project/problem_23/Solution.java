package com.eurela.project.problem_23;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    public static long compute() throws IOException, URISyntaxException {
        int[] abundantNumbers = IntStream.rangeClosed(1, 28123)
                .filter(Solution::isAbundant)
                .toArray();

        return IntStream.rangeClosed(1, 28123)
                .filter(e -> !canBeSumFromTwoAbundant(e, abundantNumbers))
                .sum();
    }

    public static boolean canBeSumFromTwoAbundant(int number, int[] abundantNumbers) {
        for (int i = 0; i < abundantNumbers.length; i++) {
            int diff = number - abundantNumbers[i];
            if(Arrays.binarySearch(abundantNumbers, diff) >=0){
                return true;
            }
            if(diff < 0) {
                return false;
            }
        }
        return false;
    }

    public static boolean isAbundant(int number) {
        return IntStream.rangeClosed(1, number / 2)
                .filter(e -> number % e == 0)
                .sum() > number;
    }
}
