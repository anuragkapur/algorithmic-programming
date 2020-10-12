package com.anuragkapur.ib.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     * RTC: O(n^2)
     * SC: O(n)
     */
    public int lis(final int[] A) {
        int[] lengths = new int[A.length];
        for (int i=0; i<A.length; i++) {
            lengths[i] = 1;
        }

        for (int i=1; i<A.length; i++) {
            for (int j=0; j<i; j++) {
                if (A[j] < A[i]) {
                    lengths[i] = Math.max(lengths[i], lengths[j]+1);
                }
            }
        }

        Arrays.sort(lengths);
        return lengths[A.length-1];
    }
}
