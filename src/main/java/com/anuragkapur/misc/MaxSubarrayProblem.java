package com.anuragkapur.misc;

/**
 * A divide and conquer paradigm based algorithm
 * RTC: O(nlogn)
 * SP: O(1)
 * 
 * @author anurag.kapur
 */
public class MaxSubarrayProblem {

	public MaxSubArray maxSubArray(final int[] A) {
		return maxSubArray(A, 0, A.length-1);
	}

	private MaxSubArray maxSubArray(int[] A, int start, int end) {

		MaxSubArray maxSubArray = new MaxSubArray();

		if (start == end) {
			maxSubArray.start = start;
			maxSubArray.end = end;
			maxSubArray.sum = A[start];
			return maxSubArray;
		}

		if (end - start == 1) {
			MaxOf3 maxOf3 = getMax(A[start], A[end], A[start] + A[end]);
			if (maxOf3.index == 1) {
				maxSubArray.start = start;
				maxSubArray.end = start;
				maxSubArray.sum = A[start];
			} else if (maxOf3.index == 2) {
				maxSubArray.start = end;
				maxSubArray.end = end;
				maxSubArray.sum = A[end];
			} else {
				maxSubArray.start = start;
				maxSubArray.end = end;
				maxSubArray.sum = A[start] + A[end];
			}

			return maxSubArray;
		}

		int mid = start + (end-start)/2;

		MaxSubArray leftMax = maxSubArray(A, start, mid);
		MaxSubArray rightMax = maxSubArray(A, mid+1, end);
		MaxSubArray crossingMax = maxCrossingArray(A, mid, start, end);

		MaxOf3 maxOf3 = getMax(leftMax.sum, rightMax.sum, crossingMax.sum);
		if (maxOf3.index == 1) {
			maxSubArray.start = leftMax.start;
			maxSubArray.end = leftMax.end;
			maxSubArray.sum = leftMax.sum;
		} else if (maxOf3.index == 2) {
			maxSubArray.start = rightMax.start;
			maxSubArray.end = rightMax.end;
			maxSubArray.sum = rightMax.sum;
		} else {
			maxSubArray.start = crossingMax.start;
			maxSubArray.end = crossingMax.end;
			maxSubArray.sum = crossingMax.sum;
		}

		return maxSubArray;
	}

	private MaxSubArray maxCrossingArray(int[] A, int mid, int start, int end) {

		// end - start will always be > 1, i.e atleast 3 elements in subarray

		int leftMaxSum = Integer.MIN_VALUE;
		int sum = 0;
		int left = mid;
		for (int i=mid; i>=start; i--) {
			sum += A[i];
			if (sum > leftMaxSum) {
				leftMaxSum = sum;
				left = i;
			}
		}

		int rightMaxSum = Integer.MIN_VALUE;
		sum = 0;
		int right = mid+1;
		for (int i=mid+1; i<=end; i++) {
			sum += A[i];
			if (sum > rightMaxSum) {
				rightMaxSum = sum;
				right = i;
			}
		}

		MaxSubArray maxSubArray = new MaxSubArray();
		maxSubArray.start = left;
		maxSubArray.end = right;
		maxSubArray.sum = leftMaxSum + rightMaxSum;
		return maxSubArray;
	}

	private MaxOf3 getMax(int a, int b, int c) {
		MaxOf3 maxOf3 = new MaxOf3();
		if (a > b) {
			maxOf3.max = a;
			maxOf3.index = 1;
		} else {
			maxOf3.max = b;
			maxOf3.index = 2;
		}

		if (c > maxOf3.max) {
			maxOf3.max = c;
			maxOf3.index = 3;
		}

		return maxOf3;
	}

	private class MaxSubArray {
		int sum;
		int start;
		int end;
	}

	private class MaxOf3 {
		int max;
		int index;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numbers[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4 };
		// int numbers[] = {13, 3, 25, 20, -3, -16, -23, -18, -20, -7, -12,-5, -22, 15, -4};
		// int numbers[] = {13, -33, 25, 20};
		System.out.println(new MaxSubarrayProblem().maxSubArray(numbers).sum);
	}
}