package com.anuragkapur.googlecodejam.gcj2015.r1a;

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
public class MushroomMonster {

    private static String inputFileName = "gcj2015/r1a/MusroomMonster-large.in";
    private static String outputFileName = "src/main/resources/MusroomMonster-large.out";
    private static ClassLoader classLoader;

    static {
        classLoader = MushroomMonster.class.getClassLoader();
    }

    private String compute(String line1, String line2) {
        String tokens[] = line2.split("\\s");
        int mushrooms[] = new int[tokens.length];

        for (int i=0; i<mushrooms.length; i++) {
            mushrooms[i] = Integer.parseInt(tokens[i]);
        }

        int m1 = compute1(mushrooms);
        int m2 = compute2(mushrooms);

        return String.valueOf(m1) + " " + String.valueOf(m2);
    }

    private int compute1(final int mushrooms[]) {
        int min = 0;
        for (int i=mushrooms.length-1; i>0; i--) {
            if (mushrooms[i] < mushrooms[i-1]) {
                min += mushrooms[i-1] - mushrooms[i];
            }
        }
        return min;
    }

    private int compute2(final int mushrooms[]) {
        int min = 0;
        int minRate = 0;

        // compute largest drop
        int largestDrop = 0;
        for (int i=mushrooms.length-1; i>0; i--) {
            int drop = 0;
            if (mushrooms[i] < mushrooms[i-1]) {
                drop = mushrooms[i-1] - mushrooms[i];
                if (drop > largestDrop) {
                    largestDrop = drop;
                }
            }
        }

        // min rate
        minRate = largestDrop;

        // min consumption
        for (int i=0; i<mushrooms.length-1; i++) {
            if (mushrooms[i] < minRate) {
                min += mushrooms[i];
            } else {
                min += minRate;
            }
        }

        return min;
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

            // Instantiate object to use non static methods
            MushroomMonster problem1 = new MushroomMonster();

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
            String line1 = null;
            while ((strLine = reader.readLine()) != null) {

                //System.out.println(strLine);

                if (lineNumber == 0) {
                    noOfTestCases = Integer.parseInt(strLine);
                } else {
                    if (lineNumber % 2 == 0) {
                        noOfTestCases ++;
                        activeTestCaseNumber ++;
                        // Now that a test case has been parsed, compute output for
                        // this test case

                        // Invoke algorithm here
                        String solutionToTestCase = problem1.compute(line1, strLine);

                        // Prepare output string
                        //System.out.println(solutionToTestCase);
                        output.append("Case #").append(activeTestCaseNumber).append(": ").append(solutionToTestCase);
                        output.append("\n");
                    } else {
                        line1 = strLine;
                    }

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
