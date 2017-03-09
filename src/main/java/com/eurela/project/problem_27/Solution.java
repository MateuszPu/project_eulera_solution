package com.eurela.project.problem_27;


import java.util.stream.LongStream;

public class Solution {

    //n^2 + an + b
    //|a| <=1000 |b| <=1000
    public static int compute() {
        int max = 0;
        int result = 0;
        for (int a = -1000; a <= 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int consecutivePrimes = consecutivePrimes(a, b);
                if (consecutivePrimes > max) {
                    max = consecutivePrimes;
                    result = a * b;
                }

            }
        }
        return result;
    }

    private static int consecutivePrimes(int a, int b) {
        int counter = 0;
        int n = 1;
        while (isPrime(n * n + a * n + b)) {
            counter++;
            n++;
        }
        return counter;
    }

    private static boolean isPrime(long number) {
        if (number < 0) {
            return false;
        }
        return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
