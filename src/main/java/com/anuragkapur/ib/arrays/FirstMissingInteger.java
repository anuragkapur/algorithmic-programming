package com.anuragkapur.ib.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingInteger {

    /**
     * RTC: O(n)
     * SC: O(1)
     *
     * @param A
     * @return
     */
    public int firstMissingPositive(int[] A) {

        for (int i=0; i<A.length; i++) {
            if (A[i] > 0 && A[i] <= A.length) {
                int num = A[i];
                if (num == i+1 || num == A[num-1]) {
                    // number in correct pos, do nothing
                } else {
                    // swap
                    A[i] = A[num-1];
                    A[num-1] = num;
                    // decrement counter to check the new element in ith pos in next iter
                    i--;
                }
            }
        }

        for (int i=0; i<A.length; i++) {
            if (A[i] != i+1) {
                return i+1;
            }
        }

        return A.length+1;
    }

    /**
     * RTC: O(n)
     * SC: O(n)
     *
     * @param A
     * @return
     */
    public int firstMissingPositive1(ArrayList<Integer> A) {

        Set<Integer> b = new HashSet<>();
        for (Integer num : A) {
            b.add(num);
        }

        int i = 1;
        while (true) {
            if (b.add(i)) {
                return i;
            }
            i++;
        }
    }
}
