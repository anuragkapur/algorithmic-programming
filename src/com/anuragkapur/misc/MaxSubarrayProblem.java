package com.anuragkapur.misc;

/**
 * A divide and conquer paradigm based algorithm
 * 
 * @author anurag.kapur
 */
public class MaxSubarrayProblem {

	static int numbers[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4 };
	//static int numbers[] = {13, 3, 25, 20, -3, -16, -23, -18, -20, -7, -12,-5, -22, 15, -4};
	// static int numbers[] = {13, -33, 25, 20};

	public static String maxSubarrayCrossingMid(int startIndex, int endIndex, int mid) {

		int runningSum = numbers[mid];
		int maxLeftSum = runningSum;
		int leftIndex = mid;
		int rightIndex = mid + 1;

		// Travel left from mid
		for (int i = mid - 1; i >= startIndex; i--) {
			runningSum += numbers[i];
			if (runningSum >= maxLeftSum) {
				maxLeftSum = runningSum;
				leftIndex = i;
			}
		}

		// Travel right from mid
		runningSum = numbers[mid + 1];
		int maxRightSum = runningSum;
		for (int i = mid + 2; i <= endIndex; i++) {
			runningSum += numbers[i];
			if (runningSum >= maxRightSum) {
				maxRightSum = runningSum;
				rightIndex = i;
			}
		}

		if (maxRightSum >= 0) {
			String subArrayData = leftIndex + "," + rightIndex;
			int sum = maxLeftSum + maxRightSum;
			return sum + "," + subArrayData;
		} else {
			String subArrayData = leftIndex + "," + mid;
			return maxLeftSum + "," + subArrayData;
		}
	}

	public static String maxSubarray(int startIndex, int endIndex) {

		System.out.println("startIndex :: " + startIndex + " endIndex :: " + endIndex);

		if (endIndex == startIndex || endIndex < startIndex) {
			// Recursion base case 2
			return numbers[startIndex] + "," + startIndex + "," + endIndex;
		} else {

			// Recursive case
			int mid = (endIndex + startIndex) / 2;

			// find max subarray recursively in sub problems
			String leftSubArrayData = maxSubarray(startIndex, mid - 1);
			int sumLeft = Integer.parseInt(leftSubArrayData.substring(0,leftSubArrayData.indexOf(",")));
			String rightSubArrayData = maxSubarray(mid + 1, endIndex);
			int sumRight = Integer.parseInt(rightSubArrayData.substring(0,rightSubArrayData.indexOf(",")));

			// find max subarray where subarray contains the mid element (this
			// is like the combine step of the divide and conquer paradigm)
			String midSubArrayData = maxSubarrayCrossingMid(startIndex, endIndex, mid);
			int sumMiddle = Integer.parseInt(midSubArrayData.substring(0, midSubArrayData.indexOf(",")));

			// find which sum is max and return it
			if (sumLeft > sumRight && sumLeft > sumMiddle) {
				return leftSubArrayData;
			} else if (sumRight > sumLeft && sumRight > sumMiddle) {
				return rightSubArrayData;
			} else {
				return midSubArrayData;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(maxSubarray(0, 14));
	}
}