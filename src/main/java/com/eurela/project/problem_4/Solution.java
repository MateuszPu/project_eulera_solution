package com.eurela.project.problem_4;


import java.util.stream.LongStream;

public class Solution {

    //for solve problem startRange = 100, endRange = 999
    public static Long compute(int startRange, int endRange) {
        return LongStream.iterate(endRange, e -> e - 1)
                .limit(endRange - startRange)
                .map(e -> calculate(startRange, e))
                .max()
                .getAsLong();
    }

    public static Long calculate(long startRange, long endRange) {
        return LongStream.iterate(endRange, e -> e - 1)
                .limit(endRange - startRange)
                .map(e -> e * endRange)
                .filter(Solution::isPalindrome)
                .max().orElse(0L);
    }

    public static boolean isPalindrome(long number) {
        StringBuilder sb = new StringBuilder(String.valueOf(number));
        return sb.reverse().toString().equals(sb.reverse().toString());
    }
}
