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
public class TidyNumbers {

    private static String inputFileName = "com.anuragkapur.googlecodejam/template.in";
    private static String outputFileName = "src/main/resources/template.out";
    private static ClassLoader classLoader;

    static {
        classLoader = TidyNumbers.class.getClassLoader();
    }

    private static void writeOutputToFile(String str) {
        Path file = Paths.get(outputFileName);
        try {
            Files.write(file, str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String findLargestTidy(String num) {

        if (isTidy(num))
            return num;

        String[] digits = num.split("");

        for (int i = digits.length-1; i > 0; i--) {

            int r = Integer.parseInt(digits[i]);
            int l = Integer.parseInt(digits[i-1]);

            if (l > r) {
                l = l - 1;
                r = 9;
                digits[i] = String.valueOf(r);
                digits[i-1] = String.valueOf(l);

                for (int j = i+1; j < digits.length; j++) {
                    digits[j] = String.valueOf(9);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String digit : digits) {
            builder.append(digit);
        }
        if (builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    private static boolean isTidy(String num) {
        String[] digits = num.split("");
        boolean tidy = true;
        for (int i = 0; i < digits.length-1; i++) {
            if (Integer.parseInt(digits[i]) > Integer.parseInt(digits[i+1])) {
                tidy = false;
                break;
            }
        }
        return tidy;
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

                //System.out.println(strLine);

                if (lineNumber == 0) {
                    noOfTestCases = Integer.parseInt(strLine);
                } else {
                    noOfTestCases ++;
                    activeTestCaseNumber ++;
                    // Now that a test case has been parsed, compute output for
                    // this test case

                    // Invoke algorithm here
                    String solutionToTestCase = findLargestTidy(strLine);

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
