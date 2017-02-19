package com.eurela.project.problem_9;


public class Solution {

    //to solve problem adjacentNumber = 13
    public static long compute() {
        for (int a = 1; a <= 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                int powA = a * a;
                int powB = b * b;
                int c = powA + powB;
                int sqrtC = (int) Math.sqrt(c);
                if (a + b + sqrtC == 1000 && sqrtC * sqrtC == c) {
                    return a * b * sqrtC;
                }
            }
        }
        throw new IllegalStateException("not found");
    }

}
