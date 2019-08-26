package com.anuragkapur.wgsn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem Statement: https://docs.google.com/file/d/1aLoKxT_9T-wz-TZTebA-
 * WwKbOYUsG04WH6r1_8V9DxOO5aB4v6wGaQXCrRbN/edit
 * 
 * @author anuragkapur
 */
public class DSOperations {

	private static final String DS_FIFO = "FIFO";
	private static final String DS_FILO = "FILO";
	private static final String DS_OP_PRINT = "PRINT";
	private static final String DS_OP_PRINT_SORT = "PRINT SORT";

	/**
	 * Returns an ouput string containing comma seperated numbers as per data
	 * structure type (dsType)
	 * 
	 * @param numbers
	 * @param dsType
	 * @return
	 */
	private static String printNumbers(int numbers[], String dsType) {

		StringBuffer output = new StringBuffer();

		if (dsType.equals(DS_FIFO)) {
			for (int i = 0; i < numbers.length; i++) {
				output.append(numbers[i]);
				if (i != numbers.length - 1) {
					output.append(",");
				}
			}
		} else if (dsType.equals(DS_FILO)) {
			for (int i = numbers.length - 1; i >= 0; i--) {
				output.append(numbers[i]);
				if (i != 0) {
					output.append(",");
				}
			}
		} else {
			output.append("Invalid Data Structure Type Provided. Please choose from FIFO, FILO");
		}

		return output.toString();
	}

	/**
	 * Parses an input string of numbers to an array
	 * 
	 * @param numbersString
	 * @return
	 */
	private static int[] parseNumbers(String numbersString) {
		StringTokenizer tokenizer = new StringTokenizer(numbersString, ",");
		int numbers[] = new int[tokenizer.countTokens()];
		int count = 0;

		while (tokenizer.hasMoreTokens()) {
			try {
				numbers[count++] = Integer.parseInt(tokenizer.nextToken());
			} catch (NumberFormatException nfe) {
				System.out.println("Malformed Input. Please use a comma seperated list of Integers.");
				nfe.printStackTrace();
			}
		}
		return numbers;
	}

	/**
	 * Merge sort auxiliary method. Merges 2 sorted arrays into a single sorted
	 * array
	 * 
	 * @param array1
	 * @param array2
	 * @return
	 */
	private static int[] merge(int array1[], int array2[]) {

		int totalNumbers = array1.length + array2.length;
		int mergedArray[] = new int[totalNumbers];

		int pointerInArray1 = 0, pointerInArray2 = 0;

		for (int i = 0; i < totalNumbers; i++) {
			if (pointerInArray1 >= array1.length) {
				mergedArray[i] = array2[pointerInArray2++];
			} else if (pointerInArray2 >= array2.length) {
				mergedArray[i] = array1[pointerInArray1++];
			} else if (array1[pointerInArray1] < array2[pointerInArray2]) {
				mergedArray[i] = array1[pointerInArray1++];
			} else {
				mergedArray[i] = array2[pointerInArray2++];
			}
		}

		return mergedArray;
	}

	/**
	 * Sorts an array of numbers using merge sort algorithm, with running time
	 * O(n*logn)
	 * 
	 * @param numbers
	 * @return
	 */
	private static int[] mergeSort(int numbers[]) {

		if (numbers.length <= 1) {
			return numbers;
		}

		int mid = numbers.length / 2;
		int subArray1[] = new int[mid];
		int subArray2[] = new int[numbers.length - mid];

		int count = 0;
		for (int i = 0; i < subArray1.length; i++) {
			subArray1[i] = numbers[count++];
		}
		for (int i = 0; i < subArray2.length; i++) {
			subArray2[i] = numbers[count++];
		}

		subArray1 = mergeSort(subArray1);
		subArray2 = mergeSort(subArray2);
		numbers = merge(subArray1, subArray2);

		return numbers;
	}

	/**
	 * Print numbers provided as input as per data structure type
	 * 
	 * @param dsType
	 * @param numbersString
	 * @return
	 */
	public static String print(String dsType, String numbersString) {

		int numbers[] = parseNumbers(numbersString);
		String output = printNumbers(numbers, dsType);

		return output;
	}

	/**
	 * Print sorted version of input as per data structure type
	 * 
	 * @param dsType
	 * @param numbersString
	 * @return
	 */
	public static String printSort(String dsType, String numbersString) {

		int numbers[] = parseNumbers(numbersString);
		numbers = mergeSort(numbers);
		String output = printNumbers(numbers, dsType);

		return output;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InputStreamReader cin = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(cin);

		String numbers = null;
		String dsType = null;
		String operation = null;

		try {
			String line;
			int count = 0;
			System.out.print("INPUT: ");
			while (count++ < 3) {
				line = br.readLine();
				if (count == 1) {
					numbers = line;
				} else if (count == 2) {
					dsType = line;
				} else {
					operation = line;
				}
			}
			br.close();
			cin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (operation.equals(DS_OP_PRINT)) {
			System.out.println(print(dsType, numbers));
		} else if (operation.equals(DS_OP_PRINT_SORT)) {
			System.out.println(printSort(dsType, numbers));
		} else {
			System.out.println("Invalid Data Structure OPERATION Requested. Valid Values: PRINT, PRINT SORT");
		}
	}
}