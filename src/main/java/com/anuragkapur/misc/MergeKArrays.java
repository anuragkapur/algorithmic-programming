package com.anuragkapur.misc;

/**
 * @author: anuragkapur
 * @since: 24/06/14
 */

public class MergeKArrays {

    /**
     * merge 2 sorted arrays
     *
     * @param a
     * @param b
     * @return
     */
    public int[] merge2Arrays(int a[], int b[]) {

        int runnerA = 0;
        int runnerB = 0;
        int result[] = new int[a.length + b.length];
        int runnerR = 0;

        while (runnerR < result.length) {
            if (runnerA == a.length) {
                result[runnerR] = b[runnerB];
                runnerB ++;
            } else if(runnerB == b.length) {
                result[runnerR] = a[runnerA];
                runnerA ++;
            } else {
                if (a[runnerA] < b[runnerB]) {
                    result[runnerR] = a[runnerA];
                    runnerA ++;
                } else {
                    result[runnerR] = b[runnerB];
                    runnerB ++;
                }
            }
            runnerR ++;
        }

        return result;
    }

    /**
     * Assuming K is even, for simplicity
     *
     * @param a
     */
    public int[][] mergeKArrays(int a[][]) {

        int result[][] = new int[a.length/2][];
        int runnerInResult = 0;

        for (int i=0; i<a.length-1; i+=2) {
            result[runnerInResult++] = merge2Arrays(a[i], a[i+1]);
        }

        if (result.length > 1) {
            result = mergeKArrays(result);
        }

        return result;
    }
}
