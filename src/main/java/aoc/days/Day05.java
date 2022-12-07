package aoc.days;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day05 extends Day {
    @Override
    int getDay() {
        return 5;
    }


//                        [M] [S] [S]
//                    [M] [N] [L] [T] [Q]
//            [G]     [P] [C] [F] [G] [T]
//            [B]     [J] [D] [P] [V] [F] [F]
//            [D]     [D] [G] [C] [Z] [H] [B] [G]
//            [C] [G] [Q] [L] [N] [D] [M] [D] [Q]
//            [P] [V] [S] [S] [B] [B] [Z] [M] [C]
//            [R] [H] [N] [P] [J] [Q] [B] [C] [F]
//            1   2   3   4   5   6   7   8   9


    private List<LinkedList<Character>> getCargo(){
        ArrayList<LinkedList<Character>> list = new ArrayList<>();

        list.add(getLinkedList("RPCDBG"));
        list.add(getLinkedList("HVG"));
        list.add(getLinkedList("NSQDJPM"));
        list.add(getLinkedList("PSLGDCNM"));
        list.add(getLinkedList("JBNCPFLS"));
        list.add(getLinkedList("QBDZVGTS"));
        list.add(getLinkedList("BZMHFTQ"));
        list.add(getLinkedList("CMDBF"));
        list.add(getLinkedList("FCQG"));

        return list;
    }

    private LinkedList<Character> getLinkedList(String str){
        // create a new LinkedList of characters
        LinkedList<Character> list = new LinkedList<Character>();

        // convert the string to an array of characters
        char[] chars = str.toCharArray();

        // add the elements of the array to the linked list in reverse order
        for (char c : chars) {
            list.addFirst(c);
        }
        return list;
    }

    @Override
    Object solvePart1() {
        List<String> lines = getLines();
        lines = lines.subList(10, lines.size());

        List<LinkedList<Character>> cargo = getCargo();

        for (String line : lines) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(line);

            // Create variables to store the extracted numbers
            int first = 0;
            int second = 0;
            int third = 0;

            // Iterate over the matches and convert them to integers
            int i = 0;
            while (matcher.find()) {
                if (i == 0) {
                    first = Integer.parseInt(matcher.group());
                } else if (i == 1) {
                    second = Integer.parseInt(matcher.group());
                } else if (i == 2) {
                    third = Integer.parseInt(matcher.group());
                }
                i++;
            }

            moveCargo(first, second, third, cargo);
        }


        return "" + cargo.get(0).getFirst() +
                cargo.get(1).getFirst() +
                cargo.get(2).getFirst() +
                cargo.get(3).getFirst() +
                cargo.get(4).getFirst() +
                cargo.get(5).getFirst() +
                cargo.get(6).getFirst() +
                cargo.get(7).getFirst() +
                cargo.get(8).getFirst();
    }

    private void moveCargo(int amount, int from, int to, List<LinkedList<Character>> cargo){
        LinkedList<Character> fromContainer = cargo.get(from - 1);
        LinkedList<Character> toContainer = cargo.get(to - 1);

        for(int i = 0; i <  amount; i++){
            Character first = fromContainer.removeFirst();
            toContainer.addFirst(first);
        }
    }

    private void moveCargoSameOrder(int amount, int from, int to, List<LinkedList<Character>> cargo){
        LinkedList<Character> fromContainer = cargo.get(from - 1);
        LinkedList<Character> toContainer = cargo.get(to - 1);

        LinkedList<Character> holder = new LinkedList<>();
        for(int i = 0; i <  amount; i++){
            holder.addFirst(fromContainer.removeFirst());
        }

        holder.forEach(toContainer::addFirst);
    }

    @Override
    Object solvePart2() {
        List<String> lines = getLines();
        lines = lines.subList(10, lines.size());

        List<LinkedList<Character>> cargo = getCargo();

        for (String line : lines) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(line);

            // Create variables to store the extracted numbers
            int first = 0;
            int second = 0;
            int third = 0;

            // Iterate over the matches and convert them to integers
            int i = 0;
            while (matcher.find()) {
                if (i == 0) {
                    first = Integer.parseInt(matcher.group());
                } else if (i == 1) {
                    second = Integer.parseInt(matcher.group());
                } else if (i == 2) {
                    third = Integer.parseInt(matcher.group());
                }
                i++;
            }

            moveCargoSameOrder(first, second, third, cargo);
        }


        return "" + cargo.get(0).getFirst() +
                cargo.get(1).getFirst() +
                cargo.get(2).getFirst() +
                cargo.get(3).getFirst() +
                cargo.get(4).getFirst() +
                cargo.get(5).getFirst() +
                cargo.get(6).getFirst() +
                cargo.get(7).getFirst() +
                cargo.get(8).getFirst();
    }


}