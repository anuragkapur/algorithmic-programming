package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * https://adventofcode.com/2021/day/2
 */
public class Day2Dive {

    public static void main(String[] args) throws IOException {
        List<String> lines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day2_dive.in");
        System.out.println(getFinalPosition(lines)); // 1507611
        System.out.println(getFinalPositionWithPart2(lines)); // 1880593125
    }

    private static BigInteger getFinalPosition(List<String> lines) {
        BigInteger horizontal = BigInteger.ZERO;
        BigInteger depth = BigInteger.ZERO;
        for (String line : lines) {
            String[] tokens = line.split("\\s");
            String command = tokens[0];
            int distance = Integer.parseInt(tokens[1]);
            switch (command) {
                case "forward":
                    horizontal = horizontal.add(BigInteger.valueOf(distance));
                    break;
                case "down":
                    depth = depth.add(BigInteger.valueOf(distance));
                    break;
                case "up":
                    depth = depth.subtract(BigInteger.valueOf(distance));
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected command encountered :: " + command);
            }
        }
        return horizontal.multiply(depth);
    }

    private static BigInteger getFinalPositionWithPart2(List<String> lines) {
        BigInteger horizontal = BigInteger.ZERO;
        BigInteger depth = BigInteger.ZERO;
        BigInteger aim = BigInteger.ZERO;
        for (String line : lines) {
            String[] tokens = line.split("\\s");
            String command = tokens[0];
            int distance = Integer.parseInt(tokens[1]);
            switch (command) {
                case "forward":
                    horizontal = horizontal.add(BigInteger.valueOf(distance));
                    depth = depth.add(aim.multiply(BigInteger.valueOf(distance)));
                    break;
                case "down":
                    aim = aim.add(BigInteger.valueOf(distance));
                    break;
                case "up":
                    aim = aim.subtract(BigInteger.valueOf(distance));
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected command encountered :: " + command);
            }
        }
        return horizontal.multiply(depth);
    }
}
