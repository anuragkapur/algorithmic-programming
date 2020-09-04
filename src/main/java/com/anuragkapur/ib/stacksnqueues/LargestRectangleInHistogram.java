package com.anuragkapur.ib.stacksnqueues;

public class LargestRectangleInHistogram {

    /**
     * Adjudged correct, but shouldn't have been?
     * Run time complexity: O(n^2)
     */
    public int largestRectangleArea(int[] A) {
        int largestArea = Integer.MIN_VALUE;
        for (int i=0; i<A.length; i++) {
            int left = i;
            int right = i;
            for (int j=i; j>=0; j--) {
                if (A[j] < A[i]) {
                    break;
                } else {
                    left = j;
                }
            }
            for (int j=i; j<A.length; j++) {
                if (A[j] < A[i]) {
                    break;
                } else {
                    right = j;
                }
            }

            int area = (right - left + 1) * A[i];
            if (area > largestArea) {
                largestArea = area;
            }
        }
        return largestArea;
    }

    /**
     * Partially Correct Answer. Time Limit Exceeded.
     * Run time complexity: O(n^3)
     */
    public int largestRectangleArea1(int[] A) {

        int largestArea = Integer.MIN_VALUE;
        for (int i=0; i<A.length; i++) {
            for (int j=i; j<A.length; j++) {
                int minH = Integer.MAX_VALUE;
                for (int k=i; k<=j; k++) {
                    if (A[k] < minH) {
                        minH = A[k];
                    }
                }
                int area = minH * (j-i+1);
                if (area > largestArea) {
                    largestArea = area;
                }
            }
        }

        return largestArea;
    }
}
