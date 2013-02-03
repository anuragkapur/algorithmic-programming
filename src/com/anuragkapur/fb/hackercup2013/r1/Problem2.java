package com.anuragkapur.fb.hackercup2013.r1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {

	public String solution(int m, String k11, String k22) {
		System.out.println(m + " " + k11 + " " + k22);
		
		char[] k1 = new char[k11.length()];
		char[] k2 = new char[k22.length()];
		
		int l = k11.length() / m;
		
		
		
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

		String inputFilePath = "/Users/anuragkapur/Tech_Stuff/workspace/personal/Algorithmic-Programming/src/com/anuragkapur/fb/hackercup2013/r1/intput.txt";
		String outputFilePath = "/Users/anuragkapur/Tech_Stuff/workspace/personal/Algorithmic-Programming/src/com/anuragkapur/fb/hackercup2013/r1/output.txt";
		
		try {
			// String buffer for storing the output
			StringBuffer output = new StringBuffer();

			// Instantiate object to use non static methods
			Problem2 pr = new Problem2();

			// read and parse input file
			FileInputStream fstream = new FileInputStream(inputFilePath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			int lineNumber = 0;
			int noOfTestCases = -1;
			int activeTestCaseNumber = 0;
			int m = 0;
			String k1 = "", k2 = "";
			while ((strLine = br.readLine()) != null) {

				if (lineNumber == 0) {
					noOfTestCases = Integer.parseInt(strLine);
				} else if(lineNumber % 3 == 1)  {
					m = Integer.parseInt(strLine);
				} else if(lineNumber % 3 == 2) {
					k1 = strLine;
				}else {
					noOfTestCases++;
					activeTestCaseNumber++;
					
					k2 = strLine;
					
					// Invoke algorithm here
					String solutionToTestCase = pr.solution(m, k1, k2) + "";

					// Prepare output string
					System.out.println("Case #" + activeTestCaseNumber + ": " + solutionToTestCase);
					output.append("Case #" + activeTestCaseNumber + ": " + solutionToTestCase);
					output.append("\n");
				}
				lineNumber++;
			}

			in.close();

			// Pass output string to method to write to file
			pr.writeOutputToFile(output.toString(), outputFilePath);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// File read cleanup
		}
	}
}