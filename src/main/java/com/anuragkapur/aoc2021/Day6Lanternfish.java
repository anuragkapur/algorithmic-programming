package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6Lanternfish {

    private static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        List<String> inputLines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day6_lanternfish.in");
        String inputLine = inputLines.get(0);
        String[] inputNumberStrings = inputLine.split(",");

        processInput(inputNumberStrings);
        part1(); // 387413

        // reset
        processInput(inputNumberStrings);
        part2();
    }

    private static void processInput(String[] inputNumberStrings) {
        nums = new ArrayList<>();
        for (String inputNumberString : inputNumberStrings) {
            nums.add(Integer.parseInt(inputNumberString));
        }
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

    private static void part2() {
        Map<Integer, BigInteger> timerToFishCount = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            timerToFishCount.put(i, BigInteger.ZERO);
        }
        for (int num : nums) {
            BigInteger val = timerToFishCount.get(num);
            timerToFishCount.replace(num, val.add(BigInteger.ONE));
        }
        for (int i = 0; i < 256; i++) {
            BigInteger newFishCount = BigInteger.ZERO;
            for (int j = 0; j <= 8; j++) {
                BigInteger val = timerToFishCount.get(j);
                if (j == 0) {
                    newFishCount = newFishCount.add(val);
                } else {
                    timerToFishCount.replace(j-1, val);
                }
                timerToFishCount.replace(j, BigInteger.ZERO);
            }
            timerToFishCount.replace(6, timerToFishCount.get(6).add(newFishCount));
            timerToFishCount.replace(8, newFishCount);
        }
        BigInteger totalFishes = BigInteger.ZERO;
        for (int i = 0; i < 9; i++) {
            totalFishes = totalFishes.add(timerToFishCount.get(i));
        }
        System.out.println(totalFishes);
    }
}
