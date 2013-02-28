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
import java.util.Stack;

/**
 * @author anurag.kapur
 * @status CORRECT
 */
public class BalancedSmileysBruteForce {

	public boolean isBalancedMessage(String msg) {
		
		boolean isBalanced = true;
		int countSmileys = 0;
		
		// cleanup message string
		char[] characters = msg.toCharArray();
		StringBuffer cleanedMessageBuffer = new StringBuffer();
		for (int i = 0; i < characters.length; i++) {
			if(characters[i] == '(') {
				if(i != 0) {
					if(characters[i - 1] == ':') {
						// sad smiley
						cleanedMessageBuffer.append("s");
						countSmileys ++;
					}else {
						cleanedMessageBuffer.append("(");
					}
				}else {
					cleanedMessageBuffer.append("(");
				}
			}else if(characters[i] == ')') {
				if(i != 0) {
					if(characters[i - 1] == ':') {
						// happy smiley
						cleanedMessageBuffer.append("h");
						countSmileys ++;
					}else {
						cleanedMessageBuffer.append(")");
					}
				}else {
					cleanedMessageBuffer.append(")");
				}
			}
		}
		
		//System.out.println(cleanedMessageBuffer.toString());
		
		// try all permutations of of smileys used as a bracket to see if any
		// combination computes to a balanced message
		double maxDecValue= Math.pow(2, countSmileys);
		
		//System.out.println("maxDecValue :: " + maxDecValue);
		
		for (int i = 0; i < maxDecValue; i++) {
			isBalanced = true;
			
			String permuationStr = Integer.toBinaryString(i);
			int paddingLength = countSmileys - permuationStr.length();
			// pad permutation to have a consistent length = noOfBitBinaryCount
			for (int j = 0; j < paddingLength; j++) {
				permuationStr = "0"+permuationStr;
			}
			
			
			int indexInPermutationStr = 0;
			//System.out.println(permuationStr);
			
			// iterate over message and set a smiley to a brace based on permutationStr
			char[] cleanMessageChars = cleanedMessageBuffer.toString().toCharArray();
			for (int j = 0; j < cleanMessageChars.length; j++) {
				//if(indexInPermutationStr < permuationStr.length()) {
					if (cleanMessageChars[j] == 's') {
						String permuationBitStr = permuationStr.substring(indexInPermutationStr,indexInPermutationStr+1);
						int permutationBit = Integer.parseInt(permuationBitStr);
						if (permutationBit == 1) {
							cleanMessageChars[j] = '(';
						}
						indexInPermutationStr++;
					}else if(cleanMessageChars[j] == 'h') {
						String permuationBitStr = permuationStr.substring(indexInPermutationStr,indexInPermutationStr+1);
						int permutationBit = Integer.parseInt(permuationBitStr);
						if (permutationBit == 1) {
							cleanMessageChars[j] = ')';
						}
						indexInPermutationStr++;
					}
				//}
			}
			
			// check if a balanced message found
			Stack<Character> balancer = new Stack<Character>();
			for (int j = 0; j < cleanMessageChars.length; j++) {
				if (cleanMessageChars[j] == '(') {
					balancer.push(new Character('('));
				}else if(cleanMessageChars[j] == ')') {
					if (balancer.empty()) {
						isBalanced = false;
					}else {
						balancer.pop();
					}
				}
			}
			if(!balancer.empty()) {
				isBalanced = false;
			}
			
			if(isBalanced) {
				break;
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