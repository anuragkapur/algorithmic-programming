package com.anuragkapur.fb.hackercup2020.qr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Alchemy {

    private static final String INPUT_DIR = "src/main/resources/com.anurgakapur.fb.hackercup2020.qr";
    private static final String INPUT_FILE = "alchemy.in";
    private static final String OUTPUT_DIR = "src/main/resources/com.anurgakapur.fb.hackercup2020.qr";
    private static final String OUTPUT_FILE = "alchemy.out";

    public static void main(String[] args) {
        try {
            Alchemy a = new Alchemy();
            List<String> lines = Files.readAllLines(Paths.get(INPUT_DIR, INPUT_FILE));
            StringBuilder builder = new StringBuilder();
            int caseCount = 1;
            for (int i = 2; i < lines.size(); i=i+2) {
                System.out.println(lines.get(i));
                String answer = a.compute(lines.get(i));
                builder.append("Case #").append(caseCount).append(": ").append(answer).append(System.lineSeparator());
                caseCount ++;
            }
            Files.write(Paths.get(OUTPUT_DIR, OUTPUT_FILE), builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String compute(String input) {

        int size = input.length();
        Set<String> combinedStrings = new HashSet<>();
        combinedStrings.add(input);

        while (size > 1) {
            Set<String> toBeProcessed = combinedStrings;
            System.out.println(size + " :: " + toBeProcessed.size());
            combinedStrings = new HashSet<>();
            Set<String> finalCombinedStrings = combinedStrings;
            toBeProcessed.forEach(s -> {
                for (int i = 0; i <= s.length()-3; i++) {
                    String prefix = s.substring(0, i);
                    String suffix = s.substring(i+3);
                    String fused = getFused(s.charAt(i), s.charAt(i+1), s.charAt(i+2));
                    if (fused != null) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(prefix).append(fused).append(suffix);
                        finalCombinedStrings.add(builder.toString());
                    }
                }
            });
            size = size - 2;
            combinedStrings = finalCombinedStrings;
        }

        if (combinedStrings.size() > 0) {
            return "Y";
        } else {
            return "N";
        }
    }

    private String getFused(char ch1, char ch2, char ch3) {
        int countOfAs = 0;
        if (ch1 == 'A') {
            countOfAs ++;
        }
        if (ch2 == 'A') {
            countOfAs ++;
        }
        if (ch3 == 'A') {
            countOfAs ++;
        }

        if (countOfAs == 0 || countOfAs == 3) {
            return null;
        } else if (countOfAs == 1) {
            return "B";
        } else {
            return "A";
        }
    }
}
