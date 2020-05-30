package com.anuragkapur.googlecodejam.gcj2014.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: anuragkapur
 * @since: 12/04/2014
 */

public class MagicTrick {

    private static String inputFileName = "com.anuragkapur.googlecodejam/gcj2014/qr/gcj2014_qr_magictrick.in";
    private static String outputFileName = "src/main/resources/gcj2014_qr_magictrick.out";
    private static ClassLoader classLoader;

    static {
        classLoader = MagicTrick.class.getClassLoader();
    }

    private static String compute(int answer1, int answer2, List<String> round1Rows, List<String> round2Rows) {

        String answer = null;

        String round1Row = round1Rows.get(answer1 - 1);
        Set<Integer> computationSet = new HashSet<>();
        String round1Nums[] = round1Row.split("\\s");
        for (String round1Num : round1Nums) {
            computationSet.add(Integer.parseInt(round1Num));
        }

        String round2Row = round2Rows.get(answer2 - 1);
        String round2Nums[]  = round2Row.split("\\s");
        int noOfStrikes = 0;
        int computedAnswer = -1;
        for (String round2Num : round2Nums) {
            boolean didAddToSet = computationSet.add(Integer.parseInt(round2Num));
            if (!didAddToSet) {
                noOfStrikes ++;
                computedAnswer = Integer.parseInt(round2Num);
            }
        }
        if (noOfStrikes > 1) {
            answer = "Bad magician!";
        } else if (noOfStrikes == 1) {
            answer = String.valueOf(computedAnswer);
        } else if (noOfStrikes == 0){
            answer = "Volunteer cheated!";
        } else {
            System.out.println(">>>> WARNING!! Not possible. Something has gone wrong <<<<<<<");
        }

        return answer;
    }

    private static void writeOutputToFile(String str) {
        Path file = Paths.get(outputFileName);
        try {
            Files.write(file, str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        if (inputFileName == null) {
            throw new IllegalArgumentException("InputFileName cannot be null");
        }

        try {
            // String buffer for storing the output
            StringBuilder output = new StringBuilder();

            // read and parse input file
            URL fileUrl = classLoader.getResource(inputFileName);
            if (fileUrl == null) {
                System.out.println("File URL null. EXITING!");
                return;
            }
            String filePath = fileUrl.getPath();
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8);
            String strLine;

            int lineNumber = 0;
            int noOfTestCases = -1;
            int activeTestCaseNumber = 0;
            int lineInTestCase = 0;
            int answer1 = -1;
            int answer2 = -1;
            List<String> round1Rows = new ArrayList<>();
            List<String> round2Rows = new ArrayList<>();

            while ((strLine = reader.readLine()) != null) {

                if (lineNumber == 0) {
                    noOfTestCases = Integer.parseInt(strLine);
                    activeTestCaseNumber ++;
                    lineInTestCase ++;
                } else {

                    if (lineInTestCase <= 10) {
                        if (lineInTestCase == 1) {
                            answer1 = Integer.parseInt(strLine);
                        } else if (lineInTestCase == 6) {
                            answer2 = Integer.parseInt(strLine);
                        } else {
                           if (answer2 == -1) {
                               round1Rows.add(strLine);
                           } else {
                               round2Rows.add(strLine);
                           }
                        }
                        lineInTestCase ++;
                    } else {

                        // Now that a test case has been parsed, compute output for
                        // this test case

                        // Invoke algorithm here
                        String solutionToTestCase = compute(answer1, answer2, round1Rows, round2Rows);

                        // Prepare output string
                        System.out.println(solutionToTestCase);
                        output.append("Case #").append(activeTestCaseNumber).append(": ").append(solutionToTestCase);
                        output.append("\n");

                        // Prepare next test case
                        answer1 = Integer.parseInt(strLine);
                        lineInTestCase = 2;
                        answer2 = -1;
                        round1Rows = new ArrayList<>();
                        round2Rows = new ArrayList<>();
                        activeTestCaseNumber ++;
                    }
                }
                lineNumber++;
            }

            // Compute last test case
            String solutionToTestCase = compute(answer1, answer2, round1Rows, round2Rows);
            // Prepare output string
            System.out.println(solutionToTestCase);
            output.append("Case #").append(activeTestCaseNumber).append(": ").append(solutionToTestCase);
            output.append("\n");

            // Pass output string to method to write to file
            writeOutputToFile(output.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
