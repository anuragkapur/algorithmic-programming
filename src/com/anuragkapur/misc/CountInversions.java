package com.anuragkapur.misc;

/**
 * Count number of split inversions in an array
 * 
 * @author anuragkapur
 */
public class CountInversions {

	static int a[] = {3,5,1,2,4,6};
	
	/**
	 * Assumes the 2 parts of the array are sorted, and merges them. While merging, counts split iversions
	 * 
	 * @param start
	 * @param end
	 * @param leftStart
	 * @param leftEnd
	 * @param rightStart
	 * @param rightEnd
	 * @return
	 */
	public static int countSplitInversionsAndMerge(int start, int end, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		int subArray1[] = new int[leftEnd - leftStart + 1];
		int subArray2[] = new int[rightEnd - rightStart + 1];
		
		int count = 0;
		for (int i = leftStart; i <= leftEnd; i++) {
			subArray1[count++] = a[i];
		}
		count = 0;
		for (int i = rightStart; i <= rightEnd; i++) {
			subArray2[count++] = a[i];
		}
		
		// merge and count inversions
		int leftPointer = 0, rightPointer = 0, inversions = 0;
		for (int i = start; i <= end; i++) {
			if(leftPointer >= subArray1.length) {
				a[i] = subArray2[rightPointer++];
				
			}else if(rightPointer >= subArray2.length) {
				a[i] = subArray1[leftPointer++];
				
			}else if (subArray1[leftPointer] <= subArray2[rightPointer]) {
				a[i] = subArray1[leftPointer++];
				
			}else if(subArray1[leftPointer] > subArray2[rightPointer]) {
				for (int j = leftPointer; j < subArray1.length; j++) {
					System.out.println(subArray1[j] + "," + subArray2[rightPointer]);
				}
				a[i] = subArray2[rightPointer++];
				inversions = inversions + subArray1.length - leftPointer;
			}
		}
		return inversions;
	}
	
	/**
	 * Recursive method to count left and right inversions
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int countInversionsAndSort(int start, int end) {
		System.out.println("start :: " + start + " end :: " + end);
		if(end - start == 1) {
			// two elements in array, just sort them and return if this is an inversion
			if (a[start] > a[end]) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
				return 1;
			}else {
				return 0;
			}
		}else if(end == start) {
			// one element in array, no sorting required, can be a left / right inversion
			return 0;
		}else {
			int leftStart = start;
			int leftEnd = ((end - start) / 2 ) + start;
			int rightStart = ((end - start) / 2 ) + start +1;
			int rightEnd = end;
			int leftInversions = countInversionsAndSort(leftStart, leftEnd);
			int rightInversions = countInversionsAndSort(rightStart, rightEnd);
			int splitInversions = countSplitInversionsAndMerge(start, end, leftStart, leftEnd, rightStart, rightEnd);
			
			return leftInversions + rightInversions + splitInversions;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(countInversionsAndSort(0, a.length-1));
	}
}