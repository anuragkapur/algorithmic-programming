package com.anuragkapur.googlecodejam.gcj2017.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Anurag Kapur
 */
public class BathroomStalls {

    private static String inputFileName = "com.anuragkapur.googlecodejam/gcj2017/qr/C-small-2-attempt0.in";
    private static String outputFileName = "src/main/resources/gcj2017/qr/C-small-2.out";
    private static ClassLoader classLoader;

    static {
        classLoader = BathroomStalls.class.getClassLoader();
    }

    private static void writeOutputToFile(String str) {
        Path file = Paths.get(outputFileName);
        try {
            Files.write(file, str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String compute(int n, int k) throws Exception {

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(n);
        int count = 0;

        while (!queue.isEmpty()) {
            count ++;
            int head = queue.poll();
            int l, r;

            if (head % 2 == 0) {
                r = head / 2;
                l = head / 2 - 1;
            } else {
                l = head / 2;
                r = head / 2;
            }

            if (count == k) {
                return Math.max(l, r) + " " + Math.min(l, r);
            } else {
                if (r > 0) queue.offer(r);
                if (l > 0) queue.offer(l);
            }
        }

        throw new Exception("Algorithm is bonkers!");
    }

    public static void main(String[] args) throws Exception {

        if (inputFileName == null) {
            throw new IllegalArgumentException("InputFileName cannot be null");
        }

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
                    int n = Integer.parseInt(tokens[0]);
                    int k = Integer.parseInt(tokens[1]);
                    String solutionToTestCase = compute(n, k);

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
