package com.anuragkapur.ctci.recursionanddp;

/**
 * @author: anuragkapur
 * @since: 15/06/14
 */

public class Prob9_1_CountingStairsSteps {

    /**
     * Simple recursive solution. Caching based DP algorithm can be applied to improve performance.
     *
     * Run time complexity      : O(3^n)
     *      with memoization    : O(n) [Refer: http://functionspace.org/articles/32/Fibonacci-series-and-Dynamic-programming]
     *                            or checkout bottom up solution which makes this clearer.
     *
     * @param n
     * @return no. of ways to go up stairs with n steps
     */
    public int count(int n) {

        if(n < 0) {
            return 0;
        } else if(n <= 2) {
            return n;
        } else if(n == 3) {
            return 4;
        } else {
            int ways = count(n-1);
            ways += count(n-2);
            ways += count(n-3);
            return ways;
        }
    }
}
