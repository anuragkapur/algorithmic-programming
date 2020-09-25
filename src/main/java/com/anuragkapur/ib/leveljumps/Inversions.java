package com.anuragkapur.ib.leveljumps;

public class Inversions {

    private int inversions = 0;

    /**
     * RTC: O(n log(n))
     */
    public int countInversions(int[] A) {
        mergeSort(A, 0, A.length-1);
        return inversions;
    }

    private int[] mergeSort(int[] A, int start, int end) {

        if (start == end) {
            int[] sorted = new int[1];
            sorted[0] = A[start];
            return sorted;
        }

        int mid = (end - start) / 2 + start;
        int[] left = mergeSort(A, start, mid);
        int[] right = mergeSort(A, mid+1, end);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];

        int mIndex = 0;
        int lIndex = 0;
        int rIndex = 0;
        while (lIndex < left.length && rIndex < right.length) {
            if (left[lIndex] <= right[rIndex]) {
                merged[mIndex] = left[lIndex];
                mIndex ++;
                lIndex ++;
            } else {
                merged[mIndex] = right[rIndex];
                mIndex ++;
                rIndex ++;
                int newInversions = left.length - lIndex;
                inversions += newInversions;
            }
        }

        while (lIndex < left.length) {
            merged[mIndex] = left[lIndex];
            mIndex ++;
            lIndex ++;
        }

        while (rIndex < right.length) {
            merged[mIndex] = right[rIndex];
            mIndex ++;
            rIndex ++;
        }

        return merged;
    }

    /**
     * Time Limit Exceeded. Partially Correct Answer.
     * RTC: O(n^2)
     */
    public int countInversions1(int[] A) {
        int inversions = 0;
        for (int i=0; i<A.length; i++) {
            for (int j=i+1; j<A.length; j++) {
                if (A[j] < A[i]) {
                    inversions ++;
                }
            }
        }
        return inversions;
    }
}
