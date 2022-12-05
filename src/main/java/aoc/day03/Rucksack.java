package aoc.day03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Rucksack {

    private final String contents;
    List<Character> compartmentOne = new ArrayList<>();
    List<Character> compartmentTwo = new ArrayList<>();

    public Rucksack(String contents){
        this.contents = contents;

        for (char c : contents.toCharArray()) {
            if (compartmentOne.size() < contents.length() / 2){
                compartmentOne.add(c);
            } else {
                compartmentTwo.add(c);
            }
        }
    }

    public static HashSet<Character> getSet(String s){
        HashSet<Character> result = new HashSet<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }
        return result;
    }
    
    public char getSharedItem(){
        HashSet<Character> result = new HashSet<>(compartmentOne);
        result.retainAll(new HashSet<>(compartmentTwo));
        return result.iterator().next();
    }

    public int getPrioritizedValue(){
        return getPrioritizedValue(getSharedItem());
    }

    public static int getPrioritizedValue(char sharedItem){
        if (Character.isUpperCase(sharedItem)){
            return sharedItem - 'A' + 27;
        }
        return sharedItem - 'a' + 1;
    }

}
