package com.eurela.project.problem_26;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    //to solve problem limit = 1000
    public static int compute(int limit) {
        return Stream.iterate(1, e -> e + 1)
                .limit(limit)
                .collect(Collectors.toMap(e -> e, Solution::calculateLength))
                .entrySet()
                .stream()
                .max((e1, e2) -> e1.getValue() - e2.getValue())
                .get()
                .getKey();
    }

    private static int calculateLength(Integer n) {
        Map<Integer, Integer> stateToIter = new HashMap<>();
        int state = 1;
        int iter = 0;
        while (!stateToIter.containsKey(state)) {
            stateToIter.put(state, iter);
            state = state * 10 % n;
            iter++;
        }
        return iter - stateToIter.get(state);
    }

}
