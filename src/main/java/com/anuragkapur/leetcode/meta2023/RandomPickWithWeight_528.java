package com.anuragkapur.leetcode.meta2023;

import java.util.Random;

public class RandomPickWithWeight_528 {

    int prevSums[] = null;

    public RandomPickWithWeight_528(int[] w) {
        prevSums = new int[w.length];
        prevSums[0] = w[0];
        for (int i=1; i<w.length; i++) {
            prevSums[i] = prevSums[i-1] + w[i];
        }
    }

    /**
     * Leetcode Status: Weird, accepted with Random logic using Math.random but not using Random.nextInt();
     */
    public int pickIndex() {
        // Random randGenerator = new Random();
        // int random = randGenerator.nextInt(prevSums[prevSums.length-1]+1);
        double random = prevSums[prevSums.length-1] * Math.random();
        int left = 0;
        int right = prevSums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;
            if (prevSums[mid] < random) {
                left = mid+1;
            } else if (prevSums[mid] >= random) {
                right = mid;
            } else {
                throw new RuntimeException("this else condition isn't possible");
            }
        }

        return left;
    }
}
