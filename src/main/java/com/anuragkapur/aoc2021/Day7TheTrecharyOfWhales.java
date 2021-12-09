package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day7TheTrecharyOfWhales {

    public static void main(String[] args) throws IOException {
        List<String> inputLines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day7_thetrecharyofwhales.in");
        List<Integer> nums = Arrays.stream(inputLines.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        computeMinCost(nums, (from, to) -> Math.abs(from - to)); // 336131
        computeMinCost(nums, (from, to) -> {
            int steps = Math.abs(from - to);
            return ((steps*(1+steps))/2);
        }); // 92676646
    }

    private static void computeMinCost(List<Integer> nums, StepCost stepCost) {
        nums.sort(Comparator.naturalOrder());
        int min = nums.get(0);
        int max = nums.get(nums.size()-1);
        int minFuelSpent = Integer.MAX_VALUE;
        for (int i = min; i <= max ; i++) {
            int fuelSpent = 0;
            for (Integer num : nums) {
                int cost = stepCost.apply(i, num);
                fuelSpent += cost;
            }
            if (fuelSpent <= minFuelSpent) {
                minFuelSpent = fuelSpent;
            }
        }
        System.out.println(minFuelSpent);
    }

    @FunctionalInterface
    interface StepCost {
        int apply(int from, int to);
    }
}