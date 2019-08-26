package com.anuragkapur.googlecodejam.gcj2017.qr;

import com.sun.tools.javac.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Anurag Kapur
 */
public class OversizedPancakeFlipper {

    private static String inputFileName = "com.anuragkapur.googlecodejam/gcj2017/qr/A-small-attempt1.in";
    private static String outputFileName = "src/main/resources/gcj2017/qr/A-small.out";
    private static ClassLoader classLoader;

    static {
        classLoader = OversizedPancakeFlipper.class.getClassLoader();
    }

    private static void writeOutputToFile(String str) {
        Path file = Paths.get(outputFileName);
        try {
            Files.write(file, str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convert(String str) {
        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (ch == '-') {
                builder.append("0");
            } else {
                builder.append("1");
            }
        }
        return builder.toString();
    }

    private static String solve(String bitString, int count, int k) {

        if (areAllHappy(bitString)) {
            return String.valueOf(count);
        }

        if (count > bitString.length()) {
            return "IMPOSSIBLE";
        }

        StringBuilder builder = new StringBuilder();
        char[] chars = bitString.toCharArray();
        for (int i=0; i<bitString.length(); i++) {
            if (chars[i] == '0') {
                if ((i + k) > chars.length) {
                    return "IMPOSSIBLE";
                } else {
                    for (int j = i; j < i+k; j++) {
                        builder.append("1");
                    }
                    for (int j = i+k; j < bitString.length(); j++) {
                        builder.append("0");
                    }
                }
            String mask = builder.toString();
            int n = Integer.parseInt(bitString, 2) ^ Integer.parseInt(mask, 2);
            bitString = Integer.toBinaryString(n);
            break;
            } else {
                builder.append("0");
            }
        }

        return solve(bitString, count+1, k);
    }

    private static boolean areAllHappy(String bitString) {

        for (char ch : bitString.toCharArray()) {
            if (ch == '0') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Assert.checkNonNull(inputFileName, "InputFileName cannot be null");

        try {
            // String buffer for storing the output
            StringBuilder output = new StringBuilder();

            // Instantiate object to use non static methods


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

                System.out.println(strLine);

                if (lineNumber == 0) {
                    noOfTestCases = Integer.parseInt(strLine);
                } else {
                    noOfTestCases ++;
                    activeTestCaseNumber ++;
                    // Now that a test case has been parsed, compute output for
                    // this test case

                    // Invoke algorithm here
                    String[] tokens = strLine.split("\\s");
                    String solutionToTestCase = solve(convert(tokens[0]), 0, Integer.parseInt(tokens[1]));

                    // Prepare output string
                    System.out.println(solutionToTestCase);
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
