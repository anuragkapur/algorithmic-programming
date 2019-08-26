package com.anuragkapur.fb.hackercup2013.r1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Status: INCORRECT
 * @author anuragkapur
 */
public class Problem3 {

	public int solution(String testCase) {
		System.out.println("Test case :: " + testCase);
		StringTokenizer tokenizer = new StringTokenizer(testCase, " ");
		int w = Integer.parseInt(tokenizer.nextToken());
		int h = Integer.parseInt(tokenizer.nextToken());
		int p = Integer.parseInt(tokenizer.nextToken());
		int q = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		int x = Integer.parseInt(tokenizer.nextToken());
		int y = Integer.parseInt(tokenizer.nextToken());
		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		int c = Integer.parseInt(tokenizer.nextToken());
		int d = Integer.parseInt(tokenizer.nextToken());
		
		int totalPositions = (w-p+1) * (h-q+1);
		System.out.println("totalPositions :: " + totalPositions);
		
		HashSet<String> duplicateCounter = new HashSet<String>();
		//System.out.println("first dead :: " + x + "," + y);
		int start1 = (x-p+1 < 0) ? 0 : (x-p+1);
		int start2 = (y-q+1 < 0) ? 0 : (y-q+1);
		for(int i=start1; i<=x; i++) {
			for(int j=start2; j<=y; j++) {
				//System.out.println("**");
				int nextX = i + p - 1;
				int nextY = j + q - 1;
				if(nextX < w && nextY < h) {
					if(x >= i && x <= nextX && y >= j && y <= nextY) {
						/*System.out.println(i + "," + j);
						System.out.println(nextX + "," + j);
						System.out.println(i + "," + nextY);
						System.out.println(nextX + "," + nextY);*/
						String temp = i + "," + j + nextX + "," + j + i + "," + nextY + nextX + "," + nextY;
						if (duplicateCounter.add(temp)) {
							totalPositions --;
							if(totalPositions == 0) {
								return 0;
							}
						}
					}
				}
			}
		}
		
		for (int z = 1; z < n; z++) {
			int prevX = x;
			int prevY = y;
			x = ((prevX * a) + (prevY * b) + 1) % w;
			y = ((prevX * c) + (prevY * d) + 1) % h;
			//System.out.println(">>>>>>> " + x + "," + y);
			start1 = (x-p+1 < 0) ? 0 : (x-p+1);
			start2 = (y-q+1 < 0) ? 0 : (y-q+1);			
			for(int i=start1; i<=x; i++) {
				for(int j=start2; j<=y; j++) {
					//System.out.println("**");
					int nextX = i + p - 1;
					int nextY = j + q - 1;
					if(nextX < w && nextY < h) {
						if(j < h && nextY >= 0 && nextY < h) {
							/*System.out.println(i + "," + j);
							System.out.println(nextX + "," + j);
							System.out.println(i + "," + nextY);
							System.out.println(nextX + "," + nextY);*/
							String temp = i + "," + j + nextX + "," + j + i + "," + nextY + nextX + "," + nextY;
							if (duplicateCounter.add(temp)) {
								totalPositions --;
								if(totalPositions == 0) {
									return 0;
								}
							}
						}
					}
				}
			}			
		}
		
		return totalPositions;
	}
	
	public void writeOutputToFile(String output, String filepath) throws IOException {
		FileWriter fstream = new FileWriter(filepath);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(output);
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		String inputFilePath = "/Users/anuragkapur/Tech_Stuff/workspace/personal/Algorithmic-Programming/src/com/anuragkapur/fb/hackercup2013/r1/dead_pixels.txt";
		String outputFilePath = "/Users/anuragkapur/Tech_Stuff/workspace/personal/Algorithmic-Programming/src/com/anuragkapur/fb/hackercup2013/r1/dead_pixels_out.txt";
		
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