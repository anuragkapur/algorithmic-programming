package com.anuragkapur.fb.interviewstreet.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Status: INCOMPLETE
 * 
 * @author anurag.kapur
 */
public class Solution {
	
	public void process(int start[][], int end[][]) {
		
		// row is analogous to peg and column as position in peg
		
		int totalDiscs = start[0].length;
		for(int i=totalDiscs; i>0; i--) {
			// TODO: Search for disc with radius "i" in "start"
			int currentRow = -1;
			int currentColumn = -1;
			
			// TODO: Search for disc with radius "i" in "end"
			int finalRow = -1;
			int finalColumn = -1;
			
			// Check if disc is in final position, if not, action moves until it is
			if(currentRow == finalRow && currentColumn == finalColumn) {
				// No action, process next disc
				
			}else {
				// Check if disc can be moved from current loc
				if(start[currentRow][currentColumn + 1] == -1) {
					// All cool. Can be moved.
				}else {
					// Make room, avoid using the peg of end position
				}
				
				// Check if final loc is free to add on to
				
				// if yes, all cool, else, make room without using peg the disc is currently in, else you will block it again
				
				// move disc and record the move
			}
			
		}
	}
	
	public static void main(String args[]) {
		try {

			int lineCount = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String inputLine;

			int start[][] = null;
			int end[][] = null;
			int holder[] = null;
			int noOfPegs = -1;
			int noOfDiscs = -1;

			// Process input from STDIN
			while ((inputLine = br.readLine()) != "\n") {
				lineCount++;
				if (lineCount == 1) {
					
					// No of discs and pegs
					StringTokenizer tokenizer = new StringTokenizer(inputLine," ");
					noOfDiscs = Integer.parseInt(tokenizer.nextToken());
					noOfPegs = Integer.parseInt(tokenizer.nextToken());
					
				} else if (lineCount == 2) {
					
					// Initialize arrays
					start = new int[noOfPegs][noOfDiscs];
					holder = new int[noOfDiscs];
					
					// Initialize start array with -1 values for all elements
					for(int i=0; i<noOfPegs; i++) {
						for(int j=0; j<noOfDiscs; j++) {
							start[i][j] = -1;
						}
					}
					
					// Initial configuration 
					StringTokenizer tokenizer = new StringTokenizer(inputLine, " ");
					int discCount = 0;
					while (tokenizer.hasMoreElements()) {
						holder[discCount] = Integer.parseInt(tokenizer.nextToken());
						discCount ++;
					}
					
					for(int i=discCount-1; i>=0; i--) {
						for(int j=0; j<noOfDiscs; j++) {
							if(start[holder[i] - 1] [j] == -1) {
								start[holder[i] - 1] [j] = i + 1;
								break;
							}
						}
					}
					
					//Output inital configuration array for debugging
					/*
					for(int j=0; j<noOfPegs; j++){
						System.out.println("Peg :: " + (j + 1));
						for(int i=0; i<noOfDiscs; i++) {
							System.out.println(start[j][i]);
						}
					}*/					
					
				} else if (lineCount == 3) {

					// Initialize arrays
					end = new int[noOfPegs][noOfDiscs];
					holder = new int[noOfDiscs];

					// Initialize end array with -1 values for all elements
					for(int i=0; i<noOfPegs; i++) {
						for(int j=0; j<noOfDiscs; j++) {
							end[i][j] = -1;
						}
					}					
					
					// Final configuration 
					StringTokenizer tokenizer = new StringTokenizer(inputLine, " ");
					int discCount = 0;
					while (tokenizer.hasMoreElements()) {
						holder[discCount] = Integer.parseInt(tokenizer.nextToken());
						discCount ++;
					}					
					
					for(int i=discCount-1; i>=0; i--) {
						for(int j=0; j<noOfDiscs; j++) {
							if(end[holder[i] - 1][j] == -1) {
								end[holder[i] - 1] [j] = i + 1;
								break;
							}
						}
					}
					
					//Output inital configuration array for debugging
					/*
					for(int j=0; j<noOfPegs; j++){
						System.out.println("Peg :: " + (j + 1));
						for(int i=0; i<noOfDiscs; i++) {
							System.out.println(end[j][i]);
						}
					}*/
					
					// End expecting input from stdin
					break;
				}
			}
			
			Solution solution = new Solution();
			solution.process(start, end);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}