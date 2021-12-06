package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://adventofcode.com/2021/day/3
 */
public class Day3BinaryDiagnostic {

    public static void main(String[] args) throws IOException {
        List<String> lines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day3_binarydiagnostic.in");
        part1(lines); // 1307354
        part2(lines); // 482500
    }

    private static void part1(List<String> lines) {
        StringBuilder gammaRateString = new StringBuilder();
        StringBuilder epsilonRateString = new StringBuilder();

        for (int i = 0; i < lines.get(0).length(); i++) {
            int countOfZeros = 0;
            for (String line : lines) {
                char ch = line.charAt(i);
                if (ch == '0') {
                    countOfZeros ++;
                }
            }
            gammaRateString.append(countOfZeros >= (lines.size() / 2) ? "0" : "1");
            epsilonRateString.append(countOfZeros < (lines.size() / 2) ? "0" : "1");
        }

        int gammaRate = Integer.parseInt(gammaRateString.toString(), 2);
        int epsilonRate = Integer.parseInt(epsilonRateString.toString(), 2);

        System.out.println(gammaRate * epsilonRate);
    }

    private static void part2(List<String> lines) {
        int oxygenRating = getRating(lines, getMostCommonBit());
        int co2ScrubberRating = getRating(lines, getLeastCommonBit());

        System.out.println(oxygenRating * co2ScrubberRating);
    }

    private static BitCriteria getLeastCommonBit() {
        // bit '0' is tie-breaker if equal number of '0's and '1's
        return (countOfZeros, listSize) -> countOfZeros <= (listSize / 2) ? '0' : '1';
    }

    private static BitCriteria getMostCommonBit() {
        // bit '1' is tie-breaker if equal number of '0's and '1's
        return (countOfZeros, listSize) -> countOfZeros > (listSize / 2) ? '0' : '1';
    }

    private static int getRating(List<String> lines, BitCriteria bitCriteria) {
        int currentBitIndex = 0;
        while(true) {
            char matchingBit = getBitThatMatchesBitCriteria(lines, currentBitIndex, bitCriteria);
            lines = filterLinesThatMeetCriteria(matchingBit, currentBitIndex, lines);
            if (lines.size() == 1) {
                return Integer.parseInt(lines.get(0), 2);
            }
            currentBitIndex ++;
        }
    }

    private static List<String> filterLinesThatMeetCriteria(char matchingBit, int currentBitIndex, List<String> lines) {
        return lines.stream()
                .filter(line -> line.charAt(currentBitIndex) == matchingBit)
                .collect(Collectors.toList());
    }

    private static char getBitThatMatchesBitCriteria(List<String> lines, int currentBitIndex, BitCriteria bitCriteria) {
        int countOfZeros = 0;
        for (String line : lines) {
            char ch = line.charAt(currentBitIndex);
            if (ch == '0') {
                countOfZeros++;
            }
        }
        return bitCriteria.apply(countOfZeros, lines.size());
    }

    @FunctionalInterface
    interface BitCriteria {
        char apply(int countOfZeros, int listSize);
    }
}
