package com.anuragkapur.ib.binarysearch;

public class SmallerOrEqualElements {
    public int solve(int[] A, int B) {
        return search(A, 0, A.length-1, B);
    }

    private int search(int[] a, int start, int end, int b) {
        if (start >= end) {
            if (a[start] == b) {
                return findMore(a, start, b);
            } if (a[start] < b) {
                return start+1;
            } else {
                if (start == 0) {
                    return 0;
                } else {
                    return start;
                }

            }
        }

        int mid = start + (end - start)/2;
        if (a[mid] == b) {
            return findMore(a, mid, b);
        } else if (a[mid] < b){
            return search(a, mid+1, end, b);
        } else {
            return search(a, start, mid-1, b);
        }
    }

    private int findMore(int[] a, int start, int b) {
        int i = start;
        for (i=start; i<a.length; i++) {
            if (a[i] != b) {
                break;
            }
        }
        return i;
    }
}
