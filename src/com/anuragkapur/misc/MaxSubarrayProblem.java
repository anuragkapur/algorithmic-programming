package com.anuragkapur.misc;

/**
 * A divide and conquer paradigm based algorithm
 * 
 * @author anurag.kapur
 */
public class MaxSubarrayProblem {

	static int numbers[] = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4};
	//static int numbers[] = {13, -33, 25, 20};
	
	public static int maxSubarrayCrossingMid(int startIndex, int endIndex, int mid) {
		
		int runningSum = numbers[mid];
		int maxLeftSum = runningSum;
		
		// Travel left from mid
		for(int i=mid-1; i>=startIndex; i--) {
			runningSum += numbers[i];
			if (runningSum >= maxLeftSum) {
				maxLeftSum = runningSum;
			}
		}

		// Travel right from mid		
		runningSum = numbers[mid + 1];
		int maxRightSum = runningSum;
		for(int i=mid+2; i<=endIndex; i++) {
			runningSum += numbers[i];
			if (runningSum >= maxRightSum) {
				maxRightSum = runningSum;
			}
		}
		
		if (maxRightSum >= 0) {
			return maxLeftSum + maxRightSum;
		}else {
			return maxLeftSum;
		}
	}
	
	public static int maxSubarray(int startIndex, int endIndex) {
		
		System.out.println("startIndex :: " + startIndex + " endIndex :: " + endIndex);
		
		if(endIndex == startIndex || endIndex < startIndex) {
			// Recursion base case 2
			return numbers[startIndex];
		}else {
			
			// Recursive case
			int mid = (endIndex + startIndex) / 2;
			
			// find max subarray recursively in sub problems
			int sumLeft = maxSubarray(startIndex, mid -1);
			int sumRight = maxSubarray(mid + 1, endIndex);
			
			// find max subarray where subarray contains the mid element (this
			// is like the combine step of the divide and conquer paradigm)
			int sumMiddle = maxSubarrayCrossingMid(startIndex, endIndex, mid);
			
			// find which sum is max and return it
			if(sumLeft > sumRight && sumLeft > sumMiddle) {
				return sumLeft;
			}else if(sumRight > sumLeft && sumRight > sumMiddle) {
				return sumRight;
			}else {
				return sumMiddle;
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