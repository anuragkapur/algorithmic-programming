package com.anuragkapur.fb.hackercup2013.r1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {

	public String solution(String testCase) {
		
		return "";
	}
	
	public void writeOutputToFile(String output, String filepath) throws IOException {
		FileWriter fstream = new FileWriter(filepath);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(output);
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		if (args.length < 2) {
			System.out.println("Not enough command line arguments specified. Need 2 (Input and output file paths)");
			return;
		}

		String inputFilePath = args[0];
		try {
			// String buffer for storing the output
			StringBuffer output = new StringBuffer();

			// Instantiate object to use non static methods
			Problem3 pr = new Problem3();

			// read and parse input file
			FileInputStream fstream = new FileInputStream(inputFilePath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			int lineNumber = 0;
			int noOfTestCases = -1;
			int activeTestCaseNumber = 0;
			while ((strLine = br.readLine()) != null) {

				if (lineNumber == 0) {
					noOfTestCases = Integer.parseInt(strLine);
				} else {
					noOfTestCases++;
					activeTestCaseNumber++;
					
					// Invoke algorithm here
					String solutionToTestCase = pr.solution(strLine) + "";

					// Prepare output string
					System.out.println("Case #" + activeTestCaseNumber + ": " + solutionToTestCase);
					output.append("Case #" + activeTestCaseNumber + ": " + solutionToTestCase);
					output.append("\n");
				}
				lineNumber++;
			}

			in.close();

			// Pass output string to method to write to file
			pr.writeOutputToFile(output.toString(), args[1]);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// File read cleanup
		}
	}
}