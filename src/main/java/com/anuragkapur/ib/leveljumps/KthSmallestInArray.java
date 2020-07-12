package com.anuragkapur.ib.leveljumps;

import java.util.List;

public class KthSmallestInArray {

    /**
     * Partially Correct Answer. Time Limit Exceeded.
     *
     * @param A
     * @param B
     * @return
     */
    public int kthsmallest(final List<Integer> A, int B) {
        int prevSmall = Integer.MIN_VALUE;
        int k = 0;
        for (int i=0; i<A.size(); i++) {
            int small = Integer.MAX_VALUE;
            for (int j=0; j<A.size(); j++) {
                int num = A.get(j);
                if (num < small && num > prevSmall) {
                    small = num;
                }
            }
            prevSmall = small;

            // find number of elements same as prevSmall to cater for duplicate elements
            for (int j=0; j<A.size(); j++) {
                if (A.get(j) == prevSmall) {
                    k++;
                    if (k == B) {
                        return small;
                    }
                }
            }
        }
        return -1;
    }
}
