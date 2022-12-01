package aoc.days;

import aoc.util.AocUtil;

public class Day01 {

    private static final String DAY_INPUT_FILE = "./day01/input.txt";

    private static int[] sonar;

    private static void init() throws Exception {
        sonar = AocUtil.readFileToIntArray(DAY_INPUT_FILE);
    }

    public static String solvePart1() throws Exception {
        init();
        int counter = 0;
        int max = 0;
        
        for (int i = 0; i < sonar.length - 1; i++) {
            if (sonar[i] == -1) { 
                if (counter >= max) {
                    max = counter;
                    
                }
                System.out.println(counter);
                counter = 0;
                
            } else {
                counter += sonar[i];
            }

            
        }

        if (counter > max) {
            max = counter;
        }
        
        return Integer.toString(max);
    }

    public static String solvePart2() throws Exception {
        init();
        int counter = 0;
        // Sort output from part 1 and sum highest 3
        return Integer.toString(counter);
    }
}