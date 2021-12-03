package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day1SonarSweep {

    public static void main(String[] args) throws IOException {
        List<String> lines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day1_sonarsweep.in");
        List<Integer> numbers = lines.stream().map(Integer::parseInt).collect(Collectors.toList());
        getCountOfIncreases(numbers); //1288
        getCountOfSlidingWindowIncreases(numbers); //1311
    }

    private static void getCountOfIncreases(List<Integer> numbers) {
        int previous = numbers.get(0);
        int count = 0;
        for (int num : numbers) {
            if (num > previous) {
                count ++;
            }
            previous = num;
        }
        System.out.println(count);
    }

    private static void getCountOfSlidingWindowIncreases(List<Integer> numbers) {
        int count = 0;
        for (int i = 0; i < numbers.size() - 3; i++) {
            int window1Sum = numbers.get(i) + numbers.get(i+1) + numbers.get(i+2);
            int window2Sum = numbers.get(i+1) + numbers.get(i+2) + numbers.get(i+3);
            if (window2Sum > window1Sum) {
                count ++;
            }
        }
        System.out.println(count);
    }
}
