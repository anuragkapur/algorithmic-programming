/**
 * Sorting algorithms
 */
package com.anuragkapur.sorting;

/**
 * Merge Sort
 * 
 * @author anurag.kapur
 */
public class MergeSort {

	/**
	 * Auxiliary merge method. Merges two pre-sorted arrays
	 * 
	 * @param a
	 * @param b
	 * @return merged array
	 */
	public int[] merge(int[] a, int[] b) {
		int lengthOfMergedArray = a.length + b.length;
		int indexInA = 0;
		int indexInB = 0;		
		int merged[] = new int[lengthOfMergedArray];

		for(int i=0; i<merged.length; i++) {
			
			if(indexInA >= a.length) {
				merged[i] = b[indexInB];
				indexInB ++;
			}else if(indexInB >= b.length) {
				merged[i] = a[indexInA];
				indexInA ++;
			}else if(a[indexInA] < b[indexInB]) {
				merged[i] = a[indexInA];
				indexInA ++;
			}else {
				merged[i] = b[indexInB];
				indexInB ++;
			}
		}
		
		return merged;
	}
	
	/**
	 * Recursive mergeSort procedure
	 * 
	 * @param a
	 * @return
	 */
    public int[] mergeSort(int[] a) {
    	
    	if(a.length == 1) {
    		// Array of length 1 is sorted by definition
    		return a;
    	}else {
    		int mid = a.length / 2;
    		int[] subarray1 = new int[mid];
    		int[] subarray2 = new int[a.length - mid];

            System.arraycopy(a, 0, subarray1, 0, mid);
            System.arraycopy(a, mid, subarray2, 0, a.length - mid);
    		
    		int sortedsub1[] = mergeSort(subarray1);
    		int sortedsub2[] = mergeSort(subarray2);

            return merge(sortedsub1, sortedsub2);
    	}
    }
    
    public static void main(String args[]) {
        MergeSort sort = new MergeSort();
        int[] toSort = {5,6,2,3,4,10,7};
        toSort = sort.mergeSort(toSort);
        for(int i=0; i<toSort.length; i++) {
        	System.out.println(toSort[i]);
        }
    }
}