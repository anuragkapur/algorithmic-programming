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

        int n1 = 1;
        int n2 = 2;
        int n3 = 4;

        if(n < 0) {
            return 0;
        } else if(n <= 2) {
            return n;
        } else if(n == 3) {
            return 4;
        } else {
            int ways = 0;
            for(int i=4; i<=n; i++) {
                ways = n1 + n2 + n3;
                n1 = n2;
                n2 = n3;
                n3 = ways;
            }
            return ways;
        }
    }
}
