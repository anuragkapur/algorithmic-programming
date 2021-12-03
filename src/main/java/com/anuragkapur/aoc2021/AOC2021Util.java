package com.anuragkapur.aoc2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class AOC2021Util {

    public static List<String> getFileLines(String filename) throws IOException {
        URL fileUrl = Day1SonarSweep.class.getClassLoader().getResource(filename);
        if (fileUrl == null) {
            System.out.println("File URL null. EXITING!");
            return null;
        }
        String filePath = fileUrl.getPath();
        BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8);
        return reader.lines().collect(Collectors.toList());
    }
}
