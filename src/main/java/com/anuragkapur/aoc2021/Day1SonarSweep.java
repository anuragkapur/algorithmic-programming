package com.anuragkapur.aoc2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day1SonarSweep {

    public static void main(String[] args) throws IOException {
        String inputFileName = "com.anuragkapur.aoc2021/day1sonarsweep.in";
        URL fileUrl = Day1SonarSweep.class.getClassLoader().getResource(inputFileName);
        if (fileUrl == null) {
            System.out.println("File URL null. EXITING!");
            return;
        }
        String filePath = fileUrl.getPath();
        BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8);
        List<Integer> numbers = reader.lines().map(Integer::parseInt).collect(Collectors.toList());
        getCountOfIncreases(numbers);
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
}
