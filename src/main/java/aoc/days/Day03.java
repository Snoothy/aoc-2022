package aoc.days;

import aoc.day03.Rucksack;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Day03 extends Day {
    @Override
    int getDay() {
        return 3;
    }

    @Override
    Object solvePart1() {
        List<String> lines = getLines();

        List<Rucksack> rucksacks = lines.stream().map(Rucksack::new).collect(Collectors.toList());
        return rucksacks.stream().map(Rucksack::getPrioritizedValue).reduce(0, (a,b) -> a+b);
    }

    @Override
    Object solvePart2() {
        List<String> lines = getLines();
        int sum = 0;
        for (int i = 0; i < lines.size(); i += 3) {
            HashSet<Character> set = Rucksack.getSet(lines.get(i));
            set.retainAll(Rucksack.getSet(lines.get(i+1)));
            set.retainAll(Rucksack.getSet(lines.get(i+2)));
            sum += Rucksack.getPrioritizedValue(set.iterator().next());
        }

        return sum;
    }


}