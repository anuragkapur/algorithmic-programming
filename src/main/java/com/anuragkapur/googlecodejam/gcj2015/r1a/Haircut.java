package com.anuragkapur.googlecodejam.gcj2015.r1a;

import com.sun.tools.javac.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Solution for small input: Correct
 *
 * @author anuragkapur
 */
public class Haircut {

    private static String inputFileName = "gcj2015/r1a/B-small-practice.in";
    private static String outputFileName = "src/main/resources/gcj2015/r1a/B-small-practice.out";
    private static ClassLoader classLoader;

    static {
        classLoader = Haircut.class.getClassLoader();
    }

    private int compute(String line1, String line2) {
        // setup
        int b = Integer.parseInt(line1.split("\\s")[0]);
        int n = Integer.parseInt(line1.split("\\s")[1]);

        String tokens[] = line2.split("\\s");
        int barberTimes[] = new int[tokens.length];
        for (int i=0; i<barberTimes.length; i++) {
            barberTimes[i] = Integer.parseInt(tokens[i]);
        }

        int lcm = getLcm(barberTimes);
        int servedInLcmTime = 0;
        for (int barberTime : barberTimes) {
            servedInLcmTime += lcm / barberTime;
        }

        int x = 1;
        while (servedInLcmTime * x < n) {
            x++;
        }

        int numberServed = servedInLcmTime * (x - 1);
        int minTime = getMin(barberTimes);
        int timeElapsedForBarbers[] = new int[barberTimes.length];
        while (numberServed < n) {
            for (int i = 0; i < barberTimes.length; i++) {
                if (timeElapsedForBarbers[i] == 0) {
                    numberServed ++;
                    if (numberServed == n) {
                        return i+1;
                    }
                } else if (timeElapsedForBarbers[i] == barberTimes[i]) {
                    timeElapsedForBarbers[i] = 0;
                    numberServed ++;
                    if (numberServed == n) {
                        return i+1;
                    }
                }
                timeElapsedForBarbers[i] += minTime;
            }
        }

        return -1;
    }

    private int getMin(int[] barberTimes) {
        return 1;
    }

    private int getMax(int [] barberTimes) {
        int max = barberTimes[0];
        for (int barberTime : barberTimes) {
            if (barberTime > max) {
                max = barberTime;
            }
        }
        return max;
    }

    private int getLcm(int[] barberTimes) {
        int max = getMax(barberTimes);
        while (true) {
            boolean lcm = true;
            for (int barberTime : barberTimes) {
                if (max % barberTime != 0) {
                    lcm = false;
                }
            }
            if (lcm) {
                return max;
            }
            max ++;
        }
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

            // Instantiate object to use non static methods
            Haircut problem = new Haircut();

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
                if (lineNumber == 0) {
                    noOfTestCases = Integer.parseInt(strLine);
                } else {
                    if (lineNumber % 2 == 0) {
                        noOfTestCases ++;
                        activeTestCaseNumber ++;
                        // Now that a test case has been parsed, compute output for
                        // this test case

                        // Invoke algorithm here
                        String solutionToTestCase = String.valueOf(problem.compute(line1, strLine));

                        // Prepare output string
                        System.out.println(activeTestCaseNumber + " :: " + solutionToTestCase);
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