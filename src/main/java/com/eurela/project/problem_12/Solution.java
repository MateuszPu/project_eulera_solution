package com.eurela.project.problem_12;


import java.util.stream.LongStream;

public class Solution {

    //to solve problem lookingNumber = 500
    public static long compute(int lookingNumber) {
        return LongStream.iterate(0, e -> e + 1)
                .map(e -> (e * (e + 1)) / 2)
                .filter(e -> calculateDivisorsNumber(e) > lookingNumber)
                .limit(1)
                .findFirst()
                .getAsLong();
    }

    public static long calculateDivisorsNumber(long number) {
        int sqrt = (int) Math.sqrt(number);
        long count = LongStream.rangeClosed(1, sqrt)
                .filter(e -> number % e == 0)
                .count() * 2;
        if(sqrt * sqrt == number) {
            count--;
        }
        return count;
    }

}
