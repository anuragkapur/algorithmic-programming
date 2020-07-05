package com.anuragkapur.ib.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MedianOfArrays {

    /**
     * Incorrect
     *
     * @param a
     * @param b
     * @return
     */
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int len = a.size() + b.size();
        int k = len / 2;
        if (len % 2 == 0) {
            int x = findKth(a, b, 0, a.size()-1, 0, b.size()-1, k-1);
            int y = findKth(a, b, 0, a.size()-1, 0, b.size()-1, k);
            return (x + y) / 2.0;
        } else {
            return findKth(a, b, 0, a.size()-1, 0, b.size()-1, k);
        }
    }

    private int findKth(List<Integer> a, List<Integer> b, int s1, int e1, int s2, int e2, int k) {

        if (s1 > e1) {
            return findKth(b, k-a.size());
        } else if (s2 > e2) {
            return findKth(a, k-b.size());
        }

        int m1 = (e1 - s1 == 1) ? s1 + 1 : s1 + (e1-s1) / 2;
        int m2 = (e2 - s2 == 1) ? s2 + 1 : s2 + (e2-s2) / 2;

        if (a.get(m1) < b.get(m2)) {
            if (m1+s2 == k) {
                return Math.min(a.get(m1), b.get(s2));
            } else {
                return findKth(a, b, m1, e1, s2, e2, k);
            }
        } else {
            if (m2+s1 == k) {
                return Math.min(b.get(m2), a.get(s1));
            } else {
                return findKth(a, b, s1, e1, m2, e2, k);
            }
        }
    }

    private int findKth(List<Integer> a, int k) {
        return a.get(k);
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

//        // -50, -41, -40, -19, 5, 21, 28
//        a.add(-50); a.add(-41); a.add(-40); a.add(-19); a.add(5); a.add(21); a.add(28);
//        // -50, -21, -10
//        b.add(-50); b.add(-21); b.add(-10);

        // A : [ -40, -25, 5, 10, 14, 28, 29, 48 ]
        a.add(-40); a.add(-25); a.add(5); a.add(10); a.add(14); a.add(28); a.add(29); a.add(48);
        // B : [ -48, -31, -15, -6, 1, 8 ]
        b.add(-48); b.add(-31); b.add(-15); b.add(-6); b.add(1); b.add(8);


        MedianOfArrays m = new MedianOfArrays();
        System.out.println(m.findMedianSortedArrays(a, b));
    }
}
