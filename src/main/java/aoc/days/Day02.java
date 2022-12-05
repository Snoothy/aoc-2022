package aoc.days;

import java.util.List;

import aoc.util.AocUtil;

public class Day02 {

    private static final String DAY_INPUT_FILE = "./day02/input.txt";

    private static List<String> input;

    private static void init() throws Exception {
        input = AocUtil.readFileToStrings(DAY_INPUT_FILE);
    }

    public static String solvePart1() throws Exception {
        init();
        int score = 0;

        for (String game : input) {
            String opponent = game.substring(0, 1);
            String player = game.substring(2, 3);
            score += gameScore(opponent, player);
        }
        
        return Integer.toString(score);
    }

    private static int gameScore(String opp, String player){
        int result = 0;

        if (("A".equals(opp) && "X".equals(player)) || ("B".equals(opp) && "Y".equals(player)) || ("C".equals(opp) && "Z".equals(player))){
            result += 3;
        } else if (("A".equals(opp) && "Y".equals(player)) || ("B".equals(opp) && "Z".equals(player)) || ("C".equals(opp) && "X".equals(player))) {
            result += 6;
        }

        switch (player) {
            case "X":
                result += 1;
                break;
            case "Y":
                result += 2;
                break;
                case "Z":
                result += 3;
                break;
            default:
                break;
        }
        System.out.println("game score " + result);
        return result;
    }

    public static String solvePart2() throws Exception {
        init();
        int score = 0;

        for (String game : input) {
            String opponent = game.substring(0, 1);
            String player = game.substring(2, 3);
            score += gameScore2(opponent, player);
        }
        
        return Integer.toString(score);
    }

    private static int gameScore2(String opp, String inplayer){
        int result = 0;
        String player = inplayer;
        if ("X".equals(inplayer)) player = getHandLose(opp);
        if ("Y".equals(inplayer)) player = getHandDraw(opp);
        if ("Z".equals(inplayer)) player = getHandWin(opp);

        System.out.println(opp + " | " + player);
        if (("A".equals(opp) && "X".equals(player)) || ("B".equals(opp) && "Y".equals(player)) || ("C".equals(opp) && "Z".equals(player))){
            result += 3;
        } else if (("A".equals(opp) && "Y".equals(player)) || ("B".equals(opp) && "Z".equals(player)) || ("C".equals(opp) && "X".equals(player))) {
            result += 6;
        }

        switch (player) {
            case "X":
                result += 1;
                break;
            case "Y":
                result += 2;
                break;
                case "Z":
                result += 3;
                break;
            default:
                break;
        }
        System.out.println("game score " + result);
        return result;
    }

    static String getHandDraw(String s ){
        if ("A".equals(s)) return "X";
        if ("B".equals(s)) return "Y";
        return "Z";
    }

    static String getHandWin(String s ){
        if ("A".equals(s)) return "Y";
        if ("B".equals(s)) return "Z";
        return "X";
    }
    static String getHandLose(String s ){
        if ("A".equals(s)) return "Z";
        if ("B".equals(s)) return "X";
        return "Y";
    }
}