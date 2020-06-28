package com.anuragkapur.misc;

/**
 * A divide and conquer paradigm based algorithm
 * RTC: O(nlogn)
 * SP: O(1)
 * 
 * @author anurag.kapur
 */
public class MaxSubarrayProblem {

	public int maxSubArray(final int[] A) {
		return maxSubArray(A, 0, A.length-1);
	}

	private int maxSubArray(int[] A, int start, int end) {

		if (start == end) {
			return A[start];
		}

		if (end - start == 1) {
			return getMax(A[start], A[end], A[start] + A[end]);
		}

		int mid = start + (end-start)/2;

		int leftMaxSum = maxSubArray(A, start, mid);
		int rightMaxSum = maxSubArray(A, mid+1, end);
		int crossingMaxSum = maxCrossingArray(A, mid, start, end);

		return getMax(leftMaxSum, rightMaxSum, crossingMaxSum);
	}

	private int maxCrossingArray(int[] A, int mid, int start, int end) {

		// end - start will always be > 1, i.e atleast 3 elements in subarray

		int leftMaxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i=mid; i>=start; i--) {
			sum += A[i];
			if (sum > leftMaxSum) {
				leftMaxSum = sum;
			}
		}

		int rightMaxSum = Integer.MIN_VALUE;
		sum = 0;
		for (int i=mid+1; i<=end; i++) {
			sum += A[i];
			if (sum > rightMaxSum) {
				rightMaxSum = sum;
			}
		}

		return leftMaxSum + rightMaxSum;
	}

	private int getMax(int a, int b, int c) {
		int temp = a > b ? a : b;
		return temp > c ? temp : c;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numbers[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4 };
		// int numbers[] = {13, 3, 25, 20, -3, -16, -23, -18, -20, -7, -12,-5, -22, 15, -4};
		// int numbers[] = {13, -33, 25, 20};
		System.out.println(new MaxSubarrayProblem().maxSubArray(numbers));
	}
}