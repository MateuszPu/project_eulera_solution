package com.eurela.project.problem_19;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.DAYS;

public class Solution {

    public static long compute() {
        //as the first jan was monday so minus day one is sunday
        DayOfWeek dayOfWeek = LocalDate.of(1900, 1, 1).minusDays(1).getDayOfWeek();

        LocalDate start = LocalDate.of(1901, 1, 1);
        LocalDate end = LocalDate.of(2000, 12, 31);
        long daysBetween = DAYS.between(start, end);

        return Stream.iterate(start, e -> e.plusDays(1))
                .limit(daysBetween)
                .filter(e -> e.getDayOfMonth() == 1)
                .filter(e -> e.getDayOfWeek().equals(dayOfWeek))
                .count();
    }
}
