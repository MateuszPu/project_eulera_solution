package com.eurela.project.problem_30;


import java.util.stream.IntStream;

public class Solution {

    //to solver problem power = 5
    public static long compute() {
        return IntStream.iterate(2, a -> a + 1)
                .limit(1_000_000)
                .filter(e -> isPowOfDigitSum(e))
                .sum();
    }

    private static boolean isPowOfDigitSum(Integer numberToCheck) {
        int temp = numberToCheck;
        int sum = 0;
        while (temp != 0) {
            int i = temp % 10;
            sum += Math.pow(i, 5);
            temp /= 10;
        }
        return numberToCheck == sum;
    }

}
