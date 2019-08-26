package com.anuragkapur.misc;

/**
 * Given an array of positive numbers, find the maximum sum of elements such
 * that no two adjacent elements are picked
 * 
 * @author anurag.kapur
 */
public class MaxSumNonConsec {

	public static int maxSum(int a[], int start, int end) {
		int maxSum = 0;

		// Trivial cases
		if (start == end) {
			return a[start];
		} else if (start > end) {
			return 0;
		} else if (end - start == 1) {
			return a[start] > a[end] ? a[start] : a[end];
		} else if (start < 0) {
			return 0;
		} else if (end >= a.length) {
			return 0;
		}
		
		System.out.println("DEBUG >> start :: " + start + " end :: " + end);
		
		// Subproblem solutions, DP
		for (int i = start; i <= end; i++) {
			int possibleMaxSub1 = maxSum(a, i + 2, end);
			int possibleMaxSub2 = maxSum(a, start, i - 2);

			int possibleMax = possibleMaxSub1 + possibleMaxSub2 + a[i];
			if (possibleMax > maxSum) {
				maxSum = possibleMax;
			}
		}

		return maxSum;
	}

	public static void main(String args[]) {
		int a[] = { 8, 6, 11, 10, 11, 10 };
		System.out.println(maxSum(a, 0, a.length - 1));
	}
}