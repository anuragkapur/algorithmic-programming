package com.anuragkapur.ib.dynamicprogramming;

public class BuySellStocksII {

    /**
     * RTC: O(n)
     */
    public int maxProfit(final int[] A) {

        if (A.length <= 1) {
            return 0;
        }

        int profit = 0;
        int min = A[0];

        for (int i=1; i<A.length; i++) {
            if (A[i] > min) {
                profit += (A[i] - min);
            }
            min = A[i];
        }

        return profit;
    }
}
