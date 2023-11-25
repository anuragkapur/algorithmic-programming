package com.anuragkapur.leetcode.meta2023;

import java.util.Arrays;

class MergeIntervals_56 {

    /**
     * Time complexity: O(n*log(n))
     * Leetcode Status: Accepted; Runtime: 8ms; Beats 91.47% of users with Java
     */
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i=1; i<intervals.length; i++) {
            boolean overlapping = doOverlap(intervals[i], intervals[i-1]);
            if (overlapping) {
                int[] merged = mergeOverlapping(intervals[i], intervals[i-1]);
                // this is important; setting j to null instead of i would yield wrong solution
                // example test case to understand the above: [[3,5],[0,0],[0,2],[1,3]]
                intervals[i-1] = null;
                intervals[i] = merged;
            }
        }

        // count nulls so that size of solution array can be computed
        int count = 0;
        for (int[] interval : intervals) {
            if (interval == null) {
                count++;
            }
        }

        int[][] solution = new int[intervals.length-count][2];
        int solutionIndex = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                solution[solutionIndex++] = interval;
            }
        }

        return solution;
    }

    /**
     * Time complexity: O(n^2)
     * Status: Accepted; but not optimal
     */
    public int[][] merge1(int[][] intervals) {
        for (int i=0; i<intervals.length; i++) {
            for (int j=i+1; j<intervals.length; j++) {
                if (intervals[i] == null) {
                    break;
                }
                boolean overlapping = doOverlap(intervals[i], intervals[j]);
                if (overlapping) {
                    int[] merged = mergeOverlapping(intervals[i], intervals[j]);
                    // this is important; setting j to null instead of i would yield wrong solution
                    // example test case to understand the above: [[3,5],[0,0],[0,2],[1,3]]
                    intervals[i] = null;
                    intervals[j] = merged;
                }
            }
        }

        // count nulls so that size of solution array can be computed
        int count = 0;
        for (int[] interval : intervals) {
            if (interval == null) {
                count++;
            }
        }

        int[][] solution = new int[intervals.length-count][2];
        int solutionIndex = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                solution[solutionIndex++] = interval;
            }
        }

        return solution;
    }

    public boolean doOverlap(int[] interval1, int[] interval2) {
        if (interval1 == null || interval2 == null) {
            return false;
        }

        // TODO: refactor into reusable method to avoid code duplication
        int start1 = interval1[0];
        int end1 = interval1[interval1.length-1];
        int start2 = interval2[0];
        int end2 = interval2[interval2.length-1];

        if (start2 >= start1 && start2 <= end1) {
            return true;
        }

        if (start1 >= start2 && start1 <= end2) {
            return true;
        }

        return false;
    }

    public int[] mergeOverlapping(int[] interval1, int[] interval2) {
        int[] merged = new int[2];

        int start1 = interval1[0];
        int end1 = interval1[interval1.length-1];
        int start2 = interval2[0];
        int end2 = interval2[interval2.length-1];

        if (start1 <= start2) {
            merged[0] = start1;
        } else {
            merged[0] = start2;
        }

        if (end1 >= end2) {
            merged[1] = end1;
        } else {
            merged[1] = end2;
        }

        return merged;
    }
}
