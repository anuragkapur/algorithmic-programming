package com.anuragkapur.fb.hackercup2020.qr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alchemy {

    private static final String INPUT_DIR = "src/main/resources/com.anurgakapur.fb.hackercup2020.qr";
    private static final String INPUT_FILE = "alchemy_validation_input.txt";
//    private static final String INPUT_FILE = "sample.in";
    private static final String OUTPUT_DIR = "src/main/resources/com.anurgakapur.fb.hackercup2020.qr";
    private static final String OUTPUT_FILE = "alchemy_validation_input.answer";

    private Map<String, String> memoize = new HashMap<>();

    public static void main(String[] args) {
        try {
            Alchemy a = new Alchemy();
            List<String> lines = Files.readAllLines(Paths.get(INPUT_DIR, INPUT_FILE));
            StringBuilder builder = new StringBuilder();
            int caseCount = 1;
            for (int i = 2; i < lines.size(); i=i+2) {
                System.out.println(lines.get(i));
                String answer = a.compute(lines.get(i));
                System.out.println("answer :: " + answer);
                builder.append("Case #").append(caseCount).append(": ").append(answer).append(System.lineSeparator());
                caseCount ++;
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String compute(String s) {
        if (s.length() == 1) {
            return "Y";
        } else {
            List<Boolean> answers = new ArrayList<>();
            for (int i = 0; i <= s.length()-3; i++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(i+1);
                char ch3 = s.charAt(i+2);

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

                String left, combination, right;
                if (countOfAs == 0 || countOfAs == 3) {
                    answers.add(false);
                    continue;
                } else if (countOfAs == 1){
                    combination = "B";
                } else {
                    combination = "A";
                }
                left = s.substring(0, i);
                right = s.substring(i+3);

                String subStr = left+combination+right;
                if (memoize.containsKey(subStr)) {
                    if (memoize.get(subStr).equals("Y")) {
                        answers.add(true);
                        break;
                    } else {
                        answers.add(false);
                        continue;
                    }
                } else {
                    if (compute(subStr).equals("Y")) {
                        memoize.put(subStr, "Y");
                        answers.add(true);
                        break;
                    } else {
                        memoize.put(subStr, "N");
                        answers.add(false);
                    }
                }
            }
            if (answers.contains(true)) {
                return "Y";
            } else {
                return "N";
            }
        }
    }
}
