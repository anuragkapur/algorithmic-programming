package com.anuragkapur.fb.hackercup2013.qr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Status: CORRECT
 * 
 * @author anurag.kapur
 */
public class BeautifulStrings {

	public int maxScoreForString(String str) {
		//Init frequency of chars
		int frequencyOfChars[] = new int[26];
		
		//Case insensitive logic
		str = str.toLowerCase();
		
		//Populate frequencyOfChars based on characters of input string
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z') {
				frequencyOfChars[c - 'a'] ++;
			}
		}
		
		//Calculate string score
		int runningMaxCharScore = 26;
		int maxFrequency = 0;
		int maxFrequencyIndex = 0;
		int stringScore = 0;
		for (int j = 0; j < frequencyOfChars.length; j++) {
			for (int i = 0; i < frequencyOfChars.length; i++) {
				if(frequencyOfChars[i] > maxFrequency) {
					maxFrequency = frequencyOfChars[i];
					maxFrequencyIndex = i;
				}
			}
			
			stringScore += maxFrequency * runningMaxCharScore;
			runningMaxCharScore --;
			frequencyOfChars[maxFrequencyIndex] = 0;
			maxFrequency = 0;
		}
		
		return stringScore;
	}
	
	public void writeOutputToFile(String output, String filepath)
			throws IOException {
		FileWriter fstream = new FileWriter(filepath);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(output);
		out.flush();
		out.close();
	}
	
	/**
	 * @param args
	 */
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
			BeautifulStrings bs = new BeautifulStrings();
			
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
					noOfTestCases ++;
					activeTestCaseNumber ++;
					
					// Invoke algorithm here
					String solutionToTestCase = bs.maxScoreForString(strLine) + ""; 
					
					// Prepare output string
					System.out.println("Case #" + activeTestCaseNumber + ": " + solutionToTestCase);
					output.append("Case #" + activeTestCaseNumber + ": " + solutionToTestCase);
					output.append("\n");
				}
				lineNumber++;
			}
			
			in.close();
			
			// Pass output string to method to write to file
			bs.writeOutputToFile(output.toString(), args[1]);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}