package com.anuragkapur.fb.hackercup2013.r1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1 {

	static int trick = 1000000007;
	
	public static long nCrCalculator(int n, int r) {
		long answer = 1;
		for (int i = 1; i <= n; i++) {
			if(r+i > n) {
				break;
			}
			answer = ((long)answer * (long)(r+i)) % (long) trick;
			answer = answer / i;
		}
		
		return answer;
	}
	
	public long solution(int n, int k, int[] a) {
		System.out.println("n = " + n + " k = " + k);

		long noOfSets = nCrCalculator(n, k);
		long sum = 0;
		System.out.println("test :: " + noOfSets);
		
		Arrays.sort(a);
		for (int i = a.length - 1; i >= 0; i--) {
			
			long multiplier = nCrCalculator(i, k-1);
			boolean shouldStop = false;
			
			if (multiplier > noOfSets) {
				multiplier = noOfSets;
				shouldStop = true;
			}else {
				noOfSets -= multiplier;
			}
			
			long temp = (long)a[i] * (long)multiplier;
			temp = (long)temp % (long)trick;
			sum += temp;
			
			if (shouldStop) {
				break;
			}
		}
		
		return sum;
	}
	
	public void writeOutputToFile(String output, String filepath) throws IOException {
		FileWriter fstream = new FileWriter(filepath);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(output);
		out.flush();
		out.close();
	}

	public static void main(String[] args) {
		
		String inputFilePath = "/Users/anuragkapur/Tech_Stuff/workspace/personal/Algorithmic-Programming/src/com/anuragkapur/fb/hackercup2013/r1/p1_intput.txt";
		String outputFilePath = "/Users/anuragkapur/Tech_Stuff/workspace/personal/Algorithmic-Programming/src/com/anuragkapur/fb/hackercup2013/r1/p1_output.txt";
		
		try {
			// String buffer for storing the output
			StringBuffer output = new StringBuffer();

			// Instantiate object to use non static methods
			Problem1 pr = new Problem1();

			// read and parse input file
			FileInputStream fstream = new FileInputStream(inputFilePath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			int lineNumber = 0;
			int noOfTestCases = -1;
			int activeTestCaseNumber = 0;
			int n = 0,k = 0;
			while ((strLine = br.readLine()) != null) {

				if (lineNumber == 0) {
					noOfTestCases = Integer.parseInt(strLine);
				}else if (lineNumber % 2 == 1) {
					StringTokenizer tokenizer = new StringTokenizer(strLine, " ");
					n = Integer.parseInt(tokenizer.nextToken());
					k = Integer.parseInt(tokenizer.nextToken());
				}else {
					noOfTestCases++;
					activeTestCaseNumber++;
					
					StringTokenizer tokenizer = new StringTokenizer(strLine, " ");
					int a[] = new int[n];
					for (int i = 0; i < a.length; i++) {
						a[i] = Integer.parseInt(tokenizer.nextToken());
					}
					
					// Invoke algorithm here
					String solutionToTestCase = pr.solution(n, k, a) + "";

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