package com.eurela.project.problem_14;


import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static final Map<Integer, Integer> CACHE = new HashMap<>();

    public static int compute() {
        return IntStream.rangeClosed(1, 1_000_000)
                .boxed()
                .collect(Collectors.toMap(e -> e, e -> calculateChainLength(e)))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .get()
                .getKey();
    }

    public static int calculateChainLength(int start) {
        int count = 1;
        BigDecimal iterateTemp = new BigDecimal(start);
        while (!iterateTemp.equals(BigDecimal.ONE)) {
            if (CACHE.get(iterateTemp.intValue()) != null) {
                int result = CACHE.get(iterateTemp.intValue()) + count - 1;
                CACHE.put(start, result);
                return result;
            }
            if (iterateTemp.remainder(new BigDecimal(2)) == BigDecimal.ZERO) {
                iterateTemp = iterateTemp.divide(new BigDecimal(2));
                count++;
            } else {
                iterateTemp = iterateTemp.multiply(new BigDecimal(3)).add(BigDecimal.ONE);
                count++;
            }
        }
        CACHE.put(start, count);
        return count;
    }
}
