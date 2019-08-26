package com.anuragkapur.googlecodejam.gcj2014.qr;

import com.sun.tools.javac.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author: anuragkapur
 * @since: 12/04/2014
 */

public class DeceitfulWar {
    private static String inputFileName = "com.anuragkapur.googlecodejam/gcj2014/qr/gcj2014_qr_deceitfulwar_large.in";
    private static String outputFileName = "src/main/resources/gcj2014_qr_deceitfulwar_large.out";
    private static ClassLoader classLoader;

    static {
        classLoader = DeceitfulWar.class.getClassLoader();
    }

    private static String compute(String nBlocksStr, String kBlocksStr, int blocksCount) {
        StringBuilder solutionStringBuilder = new StringBuilder();

        double nBlocks[] = new double[blocksCount];
        double kBlocks[] = new double[blocksCount];
        int index = 0;
        for (String blockToken : nBlocksStr.split("\\s")) {
            nBlocks[index ++] = Double.parseDouble(blockToken);
        }
        index = 0;
        for (String blockToken : kBlocksStr.split("\\s")) {
            kBlocks[index ++] = Double.parseDouble(blockToken);
        }

        Arrays.sort(nBlocks);
        Arrays.sort(kBlocks);
        int minIndexNBlocks = 0;
        int minIndexKBlocks = 0;
        int maxIndexKBlocks = kBlocks.length - 1;
        int nScore = 0;
        // Deceitful War
        while(minIndexNBlocks < nBlocks.length) {
            if (nBlocks[minIndexNBlocks] < kBlocks[minIndexKBlocks]) {
                // K scores
                maxIndexKBlocks --;
            } else {
                // N scores
                nScore ++;
                minIndexKBlocks ++;
            }
            minIndexNBlocks ++;
        }
        solutionStringBuilder.append(String.valueOf(nScore));
        solutionStringBuilder.append(" ");

        // Regular War
        minIndexNBlocks = 0;
        minIndexKBlocks = 0;
        maxIndexKBlocks = kBlocks.length - 1;
        nScore = 0;
        while (minIndexNBlocks < nBlocks.length) {
            double chosenN = nBlocks[minIndexNBlocks];
            boolean didKScore = false;
            while(minIndexKBlocks < kBlocks.length) {
                if (chosenN < kBlocks[minIndexKBlocks]) {
                    // K scores
                    didKScore = true;
                    kBlocks[minIndexKBlocks] = -1;
                    minIndexKBlocks ++;
                    break;
                } else {
                    minIndexKBlocks ++;
                }
            }
            minIndexKBlocks = 0;
            if (!didKScore) {
                nScore ++;
            }
            minIndexNBlocks ++;
        }
        solutionStringBuilder.append(String.valueOf(nScore));

        return solutionStringBuilder.toString();
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
            int testCaseLineNumber = 0;
            String nBlocks = null;
            String kBlocks = null;
            int blocksCount = 0;

            while ((strLine = reader.readLine()) != null) {

                if (lineNumber == 0) {
                    noOfTestCases = Integer.parseInt(strLine);
                } else {
                    testCaseLineNumber ++;
                    if (testCaseLineNumber == 1) {
                        blocksCount = Integer.parseInt(strLine);
                        activeTestCaseNumber ++;
                    } else if(testCaseLineNumber == 2) {
                        nBlocks = strLine;
                    } else {
                        kBlocks = strLine;
                        // Invoke algorithm here
                        String solutionToTestCase = compute(nBlocks, kBlocks, blocksCount);

                        // Prepare output string
                        System.out.println(solutionToTestCase);
                        output.append("Case #").append(activeTestCaseNumber).append(": ").append(solutionToTestCase);
                        output.append("\n");

                        // reset
                        testCaseLineNumber = 0;
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
