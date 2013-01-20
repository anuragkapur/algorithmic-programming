package com.anuragkapur.fb.hackercup2012.qr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * AlphabetSoup Problem. Refer to README for problem statement
 * 
 * Status: CORRECT
 * 
 * @author anurag.kapur
 */
public class AlphabetSoup {
	
	public int soupSuperComputer(String str) {
		
		// 0=H 1=A 2=C 3=K 4=E 5=R (C) 6=U 7=P
		int characterCounts[] = new int[8];
		for (int i = 0; i < characterCounts.length; i++) {
			characterCounts[i] = 0;
		}
		
		// Count number of "HACKERCUP" character in string
		char[] characters = str.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			switch (characters[i]) {
			case 'H':
				characterCounts[0] += 1;
				break;
			case 'A':
				characterCounts[1] += 1;
				break;
			case 'C':
				characterCounts[2] += 1;
				break;
			case 'K':
				characterCounts[3] += 1;
				break;
			case 'E':
				characterCounts[4] += 1;
				break;	
			case 'R':
				characterCounts[5] += 1;
				break;
			case 'U':
				characterCounts[6] += 1;
				break;
			case 'P':
				characterCounts[7] += 1;
				break;
			default:
				break;
			}
		}
		
		// Halve the count of character 'C' as there are 2 of them in "HACKERCUP"
		characterCounts[2] /= 2;
		
		// Find character(s) with minimum count, which is = number of times
		// "HACKERCUP" can be placed side by side = solution fot this test case
		int minimum = characterCounts[0];
		for (int i = 1; i < characterCounts.length; i++) {
			if (characterCounts[i] < minimum) {
				minimum = characterCounts[i];
			}
		}
		
		return minimum;
	}
	
	public void writeOutputToFile(String output, String filepath)
			throws IOException {
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
			AlphabetSoup alphabetSoup = new AlphabetSoup();
			
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
					String solutionToTestCase = alphabetSoup.soupSuperComputer(strLine) + "";
					
					// Prepare output string
					System.out.println(solutionToTestCase);
					output.append("Case #" + activeTestCaseNumber + ": " + solutionToTestCase);
					output.append("\n");
				}
				lineNumber++;
			}
			
			in.close();
			
			// Pass output string to method to write to file
			alphabetSoup.writeOutputToFile(output.toString(), args[1]);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// File read cleanup
		}
	}
}