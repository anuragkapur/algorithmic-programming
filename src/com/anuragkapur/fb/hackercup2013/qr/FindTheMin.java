package com.anuragkapur.fb.hackercup2013.qr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author anurag.kapur
 * @status CORRECT
 */
public class FindTheMin {

	public int calculateLastElement(int n, int k, int a, int b, int c, int r) {
		System.out.println("Will begin calculations :: " + n + " " + k + " " + a + " " + b + " " + c + " " + r);
		
		int indicesOfFirstKIntegers[] = new int[k];
		for (int i = 0; i < indicesOfFirstKIntegers.length; i++) {
			// Initialize to -1 to say first k integers to start with don't
			// figure in the first k numbers the pseudo-random number generates
			indicesOfFirstKIntegers[i] = -1;
		}
		
		// Go over k elements that the number generator function produces, and
		// fill in array positions 0..k-1 where appropriate
		if(a < k){
			indicesOfFirstKIntegers[a] = 0;
		}
		int previous = a;
		for(int i = 1; i < k; i++) {
			long temp = (long) b * previous;
			temp = (long) temp + c;
			temp = (long) temp % r;
			String tempStr = temp + "";
			int current = Integer.parseInt(tempStr);
			
			// Update indicesOfFirstKIntegers
			if (current < k) {
				indicesOfFirstKIntegers[current]  = i;
			}else {
				// Just ignore it, this value can never be the answer. Answer
				// lies in the set [0,k-1] both numbers inclusive
			}
			
			//current becomes previous for next iteration
			previous = current;
		}
		
		int answer = 0;
		int pointer = k;
		byte secondSetOfK[] = new byte[k];
		boolean answerFound = false;
		
		for (int i = 0; i < k; i++) {
			//System.out.println("Indices of :: " + i);
			
			int index = indicesOfFirstKIntegers[i];
			if (index < 0) {
				for (int j = 0; j < secondSetOfK.length; j++) {
					if(secondSetOfK[j] == 0) {
						// This is a free space, take it.
						 secondSetOfK[j] = 1;
						 pointer = j + k;
						 break;
					}
				}
				indicesOfFirstKIntegers[i] = pointer;
				//System.out.println(" >> " + pointer);
				
				// See if this could be solution
				int nextIndex = pointer;
				while (nextIndex <= n-1) {
					//System.out.println(" >> " + nextIndex);
					if (nextIndex == n-1) {
						answer = i;
						answerFound = true;
						break;
					}else {
						nextIndex = nextIndex + k + 1;
					}
				}
				if (answerFound) {
					break;
				}
			}else {
				// Use index at index + k + 1
				int temp = index + k + 1;
				if(temp - k > k -1) {
					// Array out of bound, so dont do any more calculations.
					continue;
				}
				if (secondSetOfK[temp - k] == 0) {
					// This space is free to be taken.
					indicesOfFirstKIntegers[i] = temp;
					secondSetOfK[temp - k] = 1;
					//System.out.println(" << " + temp + " index = " + index);
				}else {
					// Find the next free space, since this is already taken
					for (int j = temp - k + 1; j < secondSetOfK.length; j++) {
						if (secondSetOfK[j] == 0) {
							// This is a free space, take it
							temp = j + k;
							secondSetOfK[j] = 1;
							indicesOfFirstKIntegers[i] = temp;
							//System.out.println(" << " + temp + " index = " + index);
 							break;
						}
					}
				}

				// See if this could be solution
				int nextIndex = temp;
				while (nextIndex <= n-1) {
					//System.out.println(" << " + nextIndex);
					if (nextIndex == n-1) {
						answer = i;
						answerFound = true;
						break;
					}else {
						nextIndex = nextIndex + k + 1;
					}
				}
				if (answerFound) {
					break;
				}
			}
		}
		
		return answer;
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
			FindTheMin finder = new FindTheMin();
			
			// read and parse input file
			FileInputStream fstream = new FileInputStream(inputFilePath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			int lineNumber = 0;
			int noOfTestCases = -1;
			int activeTestCaseNumber = 0;
			int n = 0, k = 0, a, b, c, r;
			boolean startOfTestCase = true;
			while ((strLine = br.readLine()) != null) {
				
				if (lineNumber == 0) {
					noOfTestCases = Integer.parseInt(strLine);
				} else {
					if (startOfTestCase) {
						noOfTestCases ++;
						activeTestCaseNumber ++;
						StringTokenizer tokenizer = new StringTokenizer(strLine, " ");
						n = Integer.parseInt(tokenizer.nextToken());
						k = Integer.parseInt(tokenizer.nextToken());
						startOfTestCase = false;
					}else {
						startOfTestCase = true;
						StringTokenizer tokenizer = new StringTokenizer(strLine, " ");
						a = Integer.parseInt(tokenizer.nextToken());
						b = Integer.parseInt(tokenizer.nextToken());
						c = Integer.parseInt(tokenizer.nextToken());
						r = Integer.parseInt(tokenizer.nextToken());
						
						// Now that a test case has been parsed, compute output for
						// this test case
						
						// Invoke algorithm here
						String solutionToTestCase = finder.calculateLastElement(n, k, a, b, c, r) + "";
						
						// Prepare output string
						System.out.println("Case #" + activeTestCaseNumber + ": " + solutionToTestCase);
						output.append("Case #" + activeTestCaseNumber + ": " + solutionToTestCase);
						output.append("\n");
					}
				}
				lineNumber++;
			}
			
			in.close();
			
			// Pass output string to method to write to file
			finder.writeOutputToFile(output.toString(), args[1]);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// File read cleanup
		}
	}
}