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

		MaxSubArray maxSubArray;

		if (start == end) {
			return new MaxSubArray(start, start, A[start]);
		}

		if (end - start == 1) {
			MaxOf3 maxOf3 = getMax(A[start], A[end], A[start] + A[end]);
			if (maxOf3.index == 1) {
				maxSubArray = new MaxSubArray(start, start, A[start]);
			} else if (maxOf3.index == 2) {
				maxSubArray = new MaxSubArray(end, end, A[end]);
			} else {
				maxSubArray = new MaxSubArray(start, end, A[start]+A[end]);
			}
			return maxSubArray;
		}

		int mid = start + (end-start)/2;

		MaxSubArray leftMax = maxSubArray(A, start, mid);
		MaxSubArray rightMax = maxSubArray(A, mid+1, end);
		MaxSubArray crossingMax = maxCrossingArray(A, mid, start, end);

		MaxOf3 maxOf3 = getMax(leftMax.sum, rightMax.sum, crossingMax.sum);
		if (maxOf3.index == 1) {
			maxSubArray = leftMax;
		} else if (maxOf3.index == 2) {
			maxSubArray = rightMax;
		} else {
			maxSubArray = crossingMax;
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

		return new MaxSubArray(left, right, leftMaxSum + rightMaxSum);
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

		MaxSubArray(int start, int end, int sum) {
			this.sum = sum;
			this.start = start;
			this.end = end;
		}
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