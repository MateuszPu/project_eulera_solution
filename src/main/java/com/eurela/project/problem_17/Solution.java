package com.eurela.project.problem_17;


import java.util.stream.IntStream;

public class Solution {

    private static final String[] NUMBERS_BELOW_20 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] NUMBER_BELOW_100 = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


    //to solve problem start = 1, end = 1000
    public static int compute(int start, int end) {
         return IntStream.rangeClosed(start, end)
                 .mapToObj(e -> translateToString(e))
                 .mapToInt(e -> e.length())
                 .sum();
    }

    public static String translateToString(int number) {
        if (number == 0) {
            return "";
        }
        if (number < 20) {
            return NUMBERS_BELOW_20[number];
        }
        if (number < 100) {
            return NUMBER_BELOW_100[number / 10] + translateToString(number % 10);
        }
        if (number < 1000) {
            return translateToString(number / 100) + "hundred" + shouldAddAnd(number % 100) + translateToString(number % 100);
        }
        return "onethousand";
    }

    private static String shouldAddAnd(int number) {
        return number == 0 ? "" : "and";
    }

}
