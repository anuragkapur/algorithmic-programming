package com.anuragkapur.pie.recursion;

/**
 * @author anuragkapur
 */
public class BinarySearch {

    /**
     * Get index of x in array a. If x doesn't exist, return -1
     *
     * @param a
     * @param x
     * @return
     */
    public int binarySearch(int a[], int x) {
        if (a == null || a.length == 0) {
            return -1;
        }
        return binarySearch(a, x, 0, a.length-1);
    }

    private int binarySearch(int[] a, int x, int start, int end) {

        if (end < start) {
            return -1;
        } else if (end == start) {
            return a[start] == x ? start : -1;
        } else {
            int mid = start + ((end - start) / 2);
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                return binarySearch(a, x, mid+1, end);
            } else {
                return binarySearch(a, x, start, mid-1);
            }
        }
    }
}
