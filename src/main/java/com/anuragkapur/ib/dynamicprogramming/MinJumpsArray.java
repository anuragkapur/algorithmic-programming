package com.anuragkapur.ib.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinJumpsArray {

    /**
     * Partially Correct Answer. Time Limit Exceeded (but no StackOverflow like in jump1)
     */
    public int jump(ArrayList<Integer> A) {

        int[] steps = new int[A.size()];
        for (int i=0; i<A.size(); i++) {
            steps[i] = 50001;
        }
        steps[A.size()-1] = 0;

        for (int i=A.size()-2; i>=0; i--) {
            int maxStep = A.get(i);
            int min = 50001;
            for (int j=i+1; j<=i+maxStep; j++) {
                if (j < A.size()) {
                    int stepSize = steps[j] + 1;
                    if (stepSize < min) {
                        min = stepSize;
                    }
                }
            }
            steps[i] = min;
        }

        if (steps[0] == 50001) {
            return -1;
        } else {
            return steps[0];
        }
    }

    Map<Integer, Integer> memTable = new HashMap<>();

    /**
     * Partially Correct Answer. StackOverflow Error (for large problems, that lead to a lot of recursion, I think)
     */
    public int jump1(ArrayList<Integer> A) {
        return jumps(A, 0);
    }

    private int jumps(ArrayList<Integer> a, int currentIndex) {
        if (memTable.containsKey(currentIndex)) {
            return memTable.get(currentIndex);
        }

        if (a.size() - currentIndex == 1) {
            return 0;
        }

        int maxJumpSize = a.get(currentIndex);
        if (maxJumpSize == 0) {
            return -1;
        }

        int minJumps = Integer.MAX_VALUE;
        for (int i=1; i<=maxJumpSize && (currentIndex+i)<a.size(); i++) {
            int jumps = jumps(a, currentIndex + i);
            if (jumps != -1) {
                jumps += 1;
                if (jumps < minJumps) {
                    minJumps = jumps;
                }
            }
        }
        if (minJumps == Integer.MAX_VALUE) {
            minJumps = -1;
        }

        memTable.put(currentIndex, minJumps);

        return minJumps;
    }
}
