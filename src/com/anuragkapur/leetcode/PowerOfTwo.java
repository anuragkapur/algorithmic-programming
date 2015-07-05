package com.anuragkapur.leetcode;

/**
 * @author anuragkapur
 */
public class PowerOfTwo {

    /**
     * Run time complexity: O(1)
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return ((n > 0) && ((n & n-1) == 0));
    }
}
