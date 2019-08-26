package com.anuragkapur.ctci.bitmanipulation;

/**
 * @author anuragkapur
 */
public class Prob5_1_InsertMIntoN {

    public int insert(int n, int m, int j, int i) {

        // clear bits j...i in N
        n = clearBits(n, j, i);

        // left shift m by i;
        m = m << i;

        // insert m into cleared n
        return n | m;
    }

    private int clearBits(int num, int j, int i) {
        int ones = (int)Math.pow(2, j-i+1) - 1;
        ones = ones << i;
        int mask = ~ones;
        return num & mask;
    }
}
