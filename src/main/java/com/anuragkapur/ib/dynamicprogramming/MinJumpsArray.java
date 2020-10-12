package com.anuragkapur.ib.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinJumpsArray {
    Map<Integer, Integer> memTable = new HashMap<>();

    /**
     * Partially Correct Answer.
     * StackOverflow Error (for large problems, that lead to a lot of recursion, I think)
     */
    public int jump(ArrayList<Integer> A) {
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
