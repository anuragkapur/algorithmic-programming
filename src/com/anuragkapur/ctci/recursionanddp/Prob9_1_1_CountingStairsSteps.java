package com.anuragkapur.ctci.recursionanddp;

/**
 * @author: anuragkapur
 * @since: 15/06/14
 */

public class Prob9_1_1_CountingStairsSteps {

    /**
     * Bottom-up DP approach
     *
     * @param n
     * @return
     */
    public int count(int n) {

        if(n <= 3) {
            return n;
        } else {
            for(int i=4; i<=n; i++) {

            }
            return -1;
        }
    }
}
