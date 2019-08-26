package com.anuragkapur.googlecodejam.gcj2015.qr;

import com.sun.tools.javac.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author anuragkapur
 */
public class StandingOvation {

    private static String inputFileName = "gcj2015/qr/gcj2015_qr_standingovation_large.in";
    private static String outputFileName = "src/main/resources/gcj2015_qr_standingovation_large.out";
    private static ClassLoader classLoader;

    static {
        classLoader = StandingOvation.class.getClassLoader();
    }

    private static String solution(String testCase) {

        String testCaseTokens[] = testCase.split(" ");
        String shynessString = testCaseTokens[1];

        char shynessLevels[] = shynessString.toCharArray();
        int friendsNeeded = 0;
        int currentStanding = 0;
        for (int i=0; i<shynessLevels.length; i++) {
            int countOfShynessLevel = Character.getNumericValue(shynessLevels[i]);
            if (countOfShynessLevel > 0) {
                if (i <= currentStanding) {
                    currentStanding += countOfShynessLevel;
                } else {
                    friendsNeeded += (i - currentStanding);
                    currentStanding += (i - currentStanding);
                    currentStanding += countOfShynessLevel;
                }
            }
        }

        return String.valueOf(friendsNeeded);
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

        Assert.checkNonNull(inputFileName, "InputFileName cannot be null");

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
            while ((strLine = reader.readLine()) != null) {

                //System.out.println(strLine);

                if (lineNumber == 0) {
                    noOfTestCases = Integer.parseInt(strLine);
                } else {
                    noOfTestCases ++;
                    activeTestCaseNumber ++;
                    // Now that a test case has been parsed, compute output for
                    // this test case

                    // Invoke algorithm here
                    String solutionToTestCase = StandingOvation.solution(strLine);

                    // Prepare output string
                    //System.out.println(solutionToTestCase);
                    output.append("Case #").append(activeTestCaseNumber).append(": ").append(solutionToTestCase);
                    output.append("\n");
                }
                lineNumber++;
            }

            // Pass output string to method to write to file
            writeOutputToFile(output.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
