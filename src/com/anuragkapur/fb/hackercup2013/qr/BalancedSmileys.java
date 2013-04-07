package com.anuragkapur.fb.hackercup2013.qr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Linear running time solution
 * 
 * @author anurag.kapur
 * @status CORRECT
 */
public class BalancedSmileys {

	public boolean isBalancedMessage(String msg) {
		
		boolean isBalanced = true;
		
		int minOpen = 0, maxOpen = 0;
		
		char[] msgChars = msg.toCharArray();
		for (int i = 0; i < msgChars.length; i++) {
			if(msgChars[i] == '(') {
				maxOpen ++;
				if(i > 0) {
					if(msgChars[i-1] != ':')
						minOpen ++;
				}
			}else if(msgChars[i] == ')') {
				minOpen --;
				if(i > 0 && msgChars[i-1] != ':') {
					maxOpen --;
				}
			}
			
			if(minOpen < 0)
				minOpen = 0;
			
			if(maxOpen < 0) {
				isBalanced = false;
				break;
			}
		}
		
		if(minOpen != 0)
			isBalanced = false;
		
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
		File inputFile = new File("src/com/anuragkapur/fb/hackercup2013/qr/balanced_smileys.in");
		String inputFilePath = inputFile.getAbsolutePath();
		
		try {
			// String buffer for storing the output
			StringBuffer output = new StringBuffer();
			
			// Instantiate object to use non static methods
			BalancedSmileysBruteForce bs = new BalancedSmileysBruteForce();
			
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
			File outputFile = new File("src/com/anuragkapur/fb/hackercup2013/qr/balanced_smileys.out");
			String filePath = outputFile.getAbsolutePath();
			bs.writeOutputToFile(output.toString(), filePath);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// File read cleanup
		}
	}
}