package aoc.days;

import java.util.HashSet;

public class Day06 extends Day {
    @Override
    int getDay() {
        return 6;
    }

    @Override
    Object solvePart1() {
        String str = getLines().get(0);
        int result = 0;
        for(int i = 0; i < str.length(); i++){
            if (isMarker(str.substring(i, i+4))) {
                return i+4;
            };
        }

        return 0;
    }

    private boolean isMarker(String str){
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return set.size() == str.length();
    }

    @Override
    Object solvePart2() {
        String str = getLines().get(0);
        int result = 0;
        for(int i = 0; i < str.length(); i++){
            if (isMarker(str.substring(i, i+14))) {
                return i+14;
            };
        }

        return 0;
    }


}