package com.anuragkapur.ctci.recursionanddp;

/**
 * @author anuragkapur
 */
public class Prob9_3_MagicIndex {

    /**
     * Binary search approach to find magic index
     *
     * Run time complexity: O(log n)
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    public int findMagicIndex(int a[], int start, int end) {

        if (end < start) {
            return -1;
        } else if (end == start && a[start] == start) {
            return start;
        } else if (end == start && a[start] != start) {
            return -1;
        } else {
            int mid = ((end - start) / 2) + start;

            if (a[mid] == mid) {
                return mid;
            } else if (a[mid] < mid){
                // check right half
                return findMagicIndex(a, mid+1, end);
            } else {
                // check left half
                return findMagicIndex(a, start, mid-1);
            }
        }
    }
}
