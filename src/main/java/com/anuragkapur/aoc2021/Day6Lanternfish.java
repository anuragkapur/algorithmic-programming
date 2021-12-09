package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day6Lanternfish {

    private static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> inputLines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day6_lanternfish.in");
        String inputLine = inputLines.get(0);
        String[] inputNumberStrings = inputLine.split(",");
        for (String inputNumberString : inputNumberStrings) {
            nums.add(Integer.parseInt(inputNumberString));
        }
        part1();
    }

    private static void part1() {
        for (int i = 0; i < 80; i++) {
            int newFishesToAdd = 0;
            for (int j = 0; j < nums.size(); j++) {
                int timer = nums.get(j);
                if (timer == 0) {
                    nums.set(j, 6);
                    newFishesToAdd ++;
                } else {
                    nums.set(j, timer-1);
                }
            }
            for (int j = 0; j < newFishesToAdd; j++) {
                nums.add(8);
            }
        }
        System.out.println(nums.size());
    }
}
