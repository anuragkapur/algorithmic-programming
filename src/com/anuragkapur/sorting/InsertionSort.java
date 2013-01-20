/**
 * Sorting algorithms
 */
package com.anuragkapur.sorting;

/**
 * Insertion Sort
 * 
 * @author anurag.kapur
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Array of numbers to sort
		int a[] = {5,1,4,3,8,6,9,10,7,2};
		
		// Insertion sort algo
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			while(j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j --;
			}
			a[j + 1] = key;
		}
		
		// Output the sorted array
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
