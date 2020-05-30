package com.anuragkapur.googlecodejam.gcj2014.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: anuragkapur
 * @since: 12/04/2014
 */

public class CookieClickerAlpha {

    private static String inputFileName = "com.anuragkapur.googlecodejam/gcj2014/qr/gcj2014_qr_cookieclickeralpha_large.in";
    private static String outputFileName = "src/main/resources/gcj2014_qr_cookieclickeralpha_large.out";
    private static ClassLoader classLoader;

    static {
        classLoader = CookieClickerAlpha.class.getClassLoader();
    }

    private static String compute(double c, double f, double x) {

        double rateOfProduction = 2;
        double t1;
        double t2;
        double time = 0;

        while (true) {
            t1 = x / rateOfProduction;
            t2 = (c / rateOfProduction) + (x / (rateOfProduction + f));

            if (t2 < t1) {
                time += c / rateOfProduction;
                rateOfProduction += f;
            } else {
                time += t1;
                break;
            }
        }

        BigDecimal answerDecimal = new BigDecimal(time);
        answerDecimal = answerDecimal.setScale(7, RoundingMode.HALF_UP);

        return answerDecimal.toString();
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
            while ((strLine = reader.readLine()) != null) {

                if (lineNumber == 0) {
                    noOfTestCases = Integer.parseInt(strLine);
                } else {
                    activeTestCaseNumber ++;

                    String tokens[] = strLine.split("\\s");
                    double c = Double.parseDouble(tokens[0]);
                    double f = Double.parseDouble(tokens[1]);
                    double x = Double.parseDouble(tokens[2]);

                    // Invoke algorithm here
                    String solutionToTestCase = compute(c, f, x);

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
