package com.anuragkapur.ib.leveljumps;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInArray {

    /**
     * RTC: O(n)
     * SC: O(n)
     *
     * @param A
     * @param B
     * @return
     */
    public int kthsmallest(final List<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for ( int i=0; i < A.size(); i++){
            minHeap.add(A.get(i));
        }

        for (int i =0; i < B-1 ;i++){
            minHeap.poll();
        }
        return minHeap.poll();
    }

    /**
     * Partially Correct Answer. Time Limit Exceeded.
     * RTC: O(n^2)
     * SC: O(1)
     *
     * @param A
     * @param B
     * @return
     */
    public int kthsmallest1(final List<Integer> A, int B) {
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
