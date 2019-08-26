package com.anuragkapur.ada1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Quick Sort 
 * 
 * @author anuragkapur
 */
public class QuickSort {

	private static int a[] = new int[10000]; 
	private static long comparisonsCount = 0;
	
	/**
	 * Returns first element as pivot
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int chooseFirstElementAsPivot(int start, int end) {
		return start;
	}
	
	/**
	 * Returns the last element as pivot
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int chooseLastElementAsPivot(int start, int end) {
		
		// Move pivot to start index.
		
		int temp = a[start];
		a[start] = a[end];
		a[end] = temp;
		return start;
	}
	
	/**
	 * Returns the median of start, end and mid as pivot
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int chooseMedianOfThreeAsPivot(int start, int end) {
		
		int pivotIndex = -1;
		
		int mid = ((end - start) / 2) + start;
		int b[] = new int[3];
		b[0] = a[start];
		b[1] = a[mid];
		b[2] = a[end];
		
		Arrays.sort(b);
		if (b[1] == a[start]) {
			pivotIndex = start;
		}else if(b[1] == a[mid]) {
			pivotIndex = mid;
		}else {
			pivotIndex = end;
		}
		
		// Move pivot to start index.
		int temp = a[start];
		a[start] = a[pivotIndex];
		a[pivotIndex] = temp;
		
		return start;
	}
	
	/**
	 * Partitions the array about the pivot
	 * 
	 * @param start
	 * @param end
	 * @param pivot
	 */
	public static int partition(int start, int end, int pivotIndex) {
		
		// Update comparisonsCount
		comparisonsCount += (long)end - start;
		
		// Partition
		int i = start;
		int pivot = a[pivotIndex];
		
		for (int j = start; j <= end; j++) {
			if (a[j] < pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		// Put pivot into correct position
		int temp = a[i];
		a[i] = pivot;
		a[pivotIndex] = temp;
		
		return i;
	}

	/**
	 * Quick sort
	 * 
	 * @param start
	 * @param end
	 */
	public static void sort(int start, int end) {
		if (end - start == 1) {
			// Base case, no recursive calls. 2 Element, just sort them.
			if (a[start] > a[end]) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			
			// Increment comparisons count by 1 as there is 1 comparison happening here.
			comparisonsCount ++;
		}else if(end <= start) {
			// Base case, only one element. Nothing to do.
		}
		else {
			int pivotIndex = chooseMedianOfThreeAsPivot(start, end);
			int partitionIndex = partition(start, end, pivotIndex);
			sort(start, partitionIndex - 1);
			sort(partitionIndex + 1, end);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File inputFile = new File("src/com/anuragkapur/ada1/quicksort.in");
		String inputFilePath = inputFile.getAbsolutePath();
		
		// read and parse input file
		try {
			String strLine = "";
			int count = 0;
			FileInputStream fstream = new FileInputStream(inputFilePath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			while ((strLine = br.readLine()) != null) {
				a[count ++] = Integer.parseInt(strLine);
			}
			
			br.close();
			in.close();
			fstream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sort(0, a.length - 1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		System.out.println(comparisonsCount);
	}
}