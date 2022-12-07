package aoc.days;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day04 extends Day {
    @Override
    int getDay() {
        return 4;
    }

    @Override
    Object solvePart1() {
        List<String> lines = getLines();
        return lines.stream().filter(this::doesSetContainEachother).collect(Collectors.toList()).size();
    }

    private boolean doesSetContainEachother(String str) {
        String[] substrings = str.split(",");

        // Create a set for each substring
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Loop through each substring
        for (String substring : substrings) {
            // Check if the substring contains a hyphen character
            int hyphenIndex = substring.indexOf("-");
            if (hyphenIndex >= 0) {
                // Extract the two numbers on either side of the hyphen
                int num1 = Integer.parseInt(substring.substring(0, hyphenIndex));
                int num2 = Integer.parseInt(substring.substring(hyphenIndex + 1));

                // Add the numbers in the range between num1 and num2 to the appropriate set
                if (substring == substrings[0]) {
                    for (int i = num1; i <= num2; i++) {
                        set1.add(i);
                    }
                } else if (substring == substrings[1]) {
                    for (int i = num1; i <= num2; i++) {
                        set2.add(i);
                    }
                }
            }
        }

        return set1.containsAll(set2) || set2.containsAll(set1);
    }

    @Override
    Object solvePart2() {
        List<String> lines = getLines();
        return lines.stream().filter(this::doesSetOverlap).collect(Collectors.toList()).size();
    }

    private boolean doesSetOverlap(String str) {
        String[] substrings = str.split(",");

        // Create a set for each substring
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Loop through each substring
        for (String substring : substrings) {
            // Check if the substring contains a hyphen character
            int hyphenIndex = substring.indexOf("-");
            if (hyphenIndex >= 0) {
                // Extract the two numbers on either side of the hyphen
                int num1 = Integer.parseInt(substring.substring(0, hyphenIndex));
                int num2 = Integer.parseInt(substring.substring(hyphenIndex + 1));

                // Add the numbers in the range between num1 and num2 to the appropriate set
                if (substring == substrings[0]) {
                    for (int i = num1; i <= num2; i++) {
                        set1.add(i);
                    }
                } else if (substring == substrings[1]) {
                    for (int i = num1; i <= num2; i++) {
                        set2.add(i);
                    }
                }
            }
        }

        set1.retainAll(set2);
        return set1.size() > 0;
    }
}