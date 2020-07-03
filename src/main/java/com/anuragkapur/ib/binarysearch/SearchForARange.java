package com.anuragkapur.ib.binarysearch;

public class SearchForARange {

    /**
     * RTC: O(log(n))
     *
     * @param A
     * @param B
     * @return
     */
    public int[] searchRange(final int[] A, int B) {
        return search(A, 0, A.length-1, B);
    }

    private int[] search(int[] a, int s, int e, int b) {

        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        if (s == e) {
            if (a[s] == b) {
                ans[0] = s;
                ans[1] = s;
                return ans;
            } else {
                return ans;
            }
        }
        if (s > e) {
            return ans;
        }

        int mid = s + (e-s)/2;
        if (a[mid] == b) {
            ans[0] = mid;
            ans[1] = mid;
            int[] left = search(a, s, mid-1, b);
            int[] right = search(a, mid+1, e, b);
            if (left[0] >= 0 && left[0] < ans[0]) {
                ans[0] = left[0];
            }
            if (right[1] >= 0 && right[1] > ans[1]) {
                ans[1] = right[1];
            }
            return ans;
        } else if (a[mid] < b) {
            return search(a, mid+1, e, b);
        } else {
            return search(a, s, mid-1, b);
        }
    }
}
