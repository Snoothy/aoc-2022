package aoc.days;

import aoc.util.AocUtil;

import java.util.List;

public abstract class Day {

    abstract int getDay();

    public void solve(){
        System.out.println();
        System.out.println("=== Solving day " + getDay() + " ===");
        System.out.println(String.format("Part 1: %s", solvePart1()));
        System.out.println(String.format("Part 2: %s", solvePart2()));
    }

    abstract Object solvePart1();
    abstract Object solvePart2();

    protected String getFilename(){
        return String.format("./day%02d/input.txt", getDay());
    }

    protected List<String> getLines(){
        try {
            return AocUtil.readFileToStrings(getFilename());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
