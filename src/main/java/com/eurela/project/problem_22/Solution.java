package com.eurela.project.problem_22;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    private static final String[] alphabet = {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static long compute() throws IOException, URISyntaxException {
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("p022_names.txt").toURI()))) {
            Object[] sortedNames = stream.flatMap(Pattern.compile(",")::splitAsStream)
                    .map(e -> e.replaceAll("\"", ""))
                    .sorted()
                    .toArray();
            Object[] firstEmpty = {""};

            //we should add at 0 index empty entry as the first name in array should be at index 1 to calculate correctly
            // its and others name value
            String[] sortedNamesWithFirstEmpty = Stream.concat(Arrays.stream(firstEmpty), Arrays.stream(sortedNames))
                                                    .toArray(String[]::new);

            return IntStream.range(1, sortedNamesWithFirstEmpty.length)
                    .map(e -> calculateValueOfName(sortedNamesWithFirstEmpty[e]) * e)
                    .sum();
        }
    }

    public static int calculateValueOfName(String name) {
        String[] letters = name.toLowerCase().split("()?|^");
        return Arrays.stream(letters)
                .mapToInt(e -> Arrays.binarySearch(alphabet, e))
                .sum();
    }
}
