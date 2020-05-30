package com.anuragkapur.googlecodejam.gcj2015.qr;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author anuragkapur
 */
public class InfiniteHouseOfPancakes {


    private static String inputFileName = "gcj2015/qr/B-small-attempt1.in";
    private static String outputFileName = "src/main/resources/B-small-attempt1.out";
    private static ClassLoader classLoader;

    static {
        classLoader = InfiniteHouseOfPancakes.class.getClassLoader();
    }

    private int solution(int d, List<Integer> pancakesOnPlates) {

        // recursion base case
        int maxPlateIndex = getIndexOfMaxInList(pancakesOnPlates);
        int pancakes = pancakesOnPlates.get(maxPlateIndex);
        if(pancakes <= 2) {
            return pancakes;
        }

        List<Integer> copy = createCopyOfList(pancakesOnPlates);

        // split the max
        maxPlateIndex = getIndexOfMaxInList(pancakesOnPlates);
        pancakes = pancakesOnPlates.get(maxPlateIndex);
        if (pancakes % 2 == 0) {
            pancakesOnPlates.set(maxPlateIndex, pancakes / 2);
            pancakesOnPlates.add(pancakes / 2);
        } else {
            pancakesOnPlates.set(maxPlateIndex, (pancakes / 2) + 1);
            pancakesOnPlates.add(pancakes / 2);
        }
        int possibility1 = solution(d, pancakesOnPlates) + 1;

        // take one off everything
        for (int i=0; i<copy.size(); i++) {
            pancakes = copy.get(i);
            copy.set(i, pancakes-1);
        }
        int possibility2 = solution(d, copy) + 1;

        return (possibility1 < possibility2) ? possibility1 : possibility2;
    }

    private List<Integer> createCopyOfList(List<Integer> list) {
        return list.stream().collect(Collectors.toList());
    }

    private int getIndexOfMaxInList(List<Integer> list) {
        int currentMax = list.get(0);
        int maxIndex = 0;
        for (int i=1; i<list.size(); i++) {
            if (list.get(i) > currentMax) {
                currentMax = list.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private List<Integer> getListFromPString(String pString) {
        List<Integer> list = new ArrayList<>();
        String tokens[] = pString.split("\\s");
        for (String token : tokens) {
            list.add(Integer.parseInt(token));
        }
        return list;
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
            InfiniteHouseOfPancakes houseOfPancakes = new InfiniteHouseOfPancakes();

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
            int d = -1;
            String pString = null;

            while ((strLine = reader.readLine()) != null) {

                //System.out.println(strLine);

                if (lineNumber == 0) {
                    noOfTestCases = Integer.parseInt(strLine);
                } else {
                    if (lineNumber % 2 != 0) {
                        d = Integer.parseInt(strLine);
                    } else {
                        noOfTestCases ++;
                        activeTestCaseNumber ++;

                        pString = strLine;
                        // Now that a test case has been parsed, compute output for
                        // this test case

                        // Invoke algorithm here
                        List<Integer> pancakesOnPlates = houseOfPancakes.getListFromPString(pString);
                        System.out.println(pString);
                        String solutionToTestCase = String.valueOf(houseOfPancakes.solution(d, pancakesOnPlates));

                        // Prepare output string
                        System.out.println("Min :: " + solutionToTestCase);
                        System.out.println("");
                        output.append("Case #").append(activeTestCaseNumber).append(": ").append(solutionToTestCase);
                        output.append("\n");
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
