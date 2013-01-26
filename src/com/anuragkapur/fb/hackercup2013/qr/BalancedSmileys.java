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
 * @author anurag.kapur
 *
 */
public class BalancedSmileys {

	public boolean isBalancedMessage(String str) {
		
		boolean isBalanced = true;

		String criticalStrings[] = new String[100];
		for (int i = 0; i < criticalStrings.length; i++) {
			criticalStrings[i] = "puff";
		}
		
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((c >= 'a' && c <= 'z') || c == ' ' || c == ':') {
				// Valid message characters that can be safely ignored
			}else if(c == '(') {
				if(i > 0 && str.charAt(i-1) == ':') {
					// This is sad
					criticalStrings[count ++] = "sad";
				}else {
					// This is (
					criticalStrings[count ++] = "(";
				}
			}else if(c == ')') {
				if(i > 0 && str.charAt(i-1) == ':') {
					//This is happy
					criticalStrings[count ++] = "happy";
				}else {
					//This is )
					criticalStrings[count ++ ] = ")";
				}				
			}else {
				// Invalid character. Game over.
				return false;
			}
		}
		
		for (int i = 0; i < count; i++) {

			if (criticalStrings[i].equals("(")) {
				// Look for ) in forward direction
				boolean matchFound = false;
				for (int j = i+1; j < count; j++) {
					if (criticalStrings[j].equals(")")) {
						// Balance found, now mark both as balanced
						criticalStrings[j] = "puff";
						criticalStrings[i] = "puff";
						matchFound = true;
						break;
					}
				}
				if(!matchFound) {
					// Look for happy in forward direction
					for (int j = i+1; j < count; j++) {
						if (criticalStrings[j].equals("happy")) {
							// Balance found, now mark both as balanced
							criticalStrings[j] = "puff";
							criticalStrings[i] = "puff";
							matchFound = true;
							break;
						}
					}
				}
				if (!matchFound) {
					// If still no match found, Game over!
					return false;
				}
			}else if (criticalStrings[i].equals(")")) {
				// Look for ( in backwards directions
				boolean matchFound = false;
				for (int j = i-1; j >= 0; j--) {
					if (criticalStrings[j].equals("(")) {
						// Balance found, now mark both as balanced
						criticalStrings[j] = "puff";
						criticalStrings[i] = "puff";
						matchFound = true;
						break;						
					}
				}
				if(!matchFound) {
					// Look for sad in backward direction
					for (int j = i-1; j >= 0; j--) {
						if (criticalStrings[j].equals("sad")) {
							// Balance found, now mark both as balanced
							criticalStrings[j] = "puff";
							criticalStrings[i] = "puff";
							matchFound = true;
							break;						
						}
					}
				}
				if(!matchFound) {
					// If still no match found, Game over!
					return false;
				}
			}
		}
		
		return isBalanced;
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
			BalancedSmileys bs = new BalancedSmileys();
			
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
					// Now that a test case has been parsed, compute output for
					// this test case
					
					// Invoke algorithm here
					String solutionToTestCase = bs.isBalancedMessage(strLine) ? "YES" : "NO";
					
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
		} finally {
			// File read cleanup
		}
	}
}