package com.anuragkapur.ib.stacksnqueues;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMax {

    /**
     * Partially correct, Time Limit Exceeded.
     * RTC: O(nw)
     */
    public int[] slidingMaximum(final int[] A, int B) {

        int[] c = new int[A.length - B + 1];
        Queue<Integer> q = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });

        for (int i=0; i<B; i++) {
            q.add(A[i]);
        }

        int count = 0;
        c[count] = findMax(q);

        for (int i=1; i<c.length; i++) {
            q.poll();
            q.add(A[B+i-1]);
            count ++;
            c[count] = findMax(q);
        }

        return c;
    }

    private int findMax(Queue<Integer> q) {
        return q.peek();
    }
}
