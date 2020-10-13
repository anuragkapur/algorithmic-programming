package com.anuragkapur.ib.dynamicprogramming;

import java.util.List;

public class BuySellStocksI {

    /**
     * Correct Answer.
     * RTC: O(n)
     */
    public int maxProfit(final List<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }

        int minPrice = A.get(0);
        int maxProfit = 0;

        for (int i=0; i<A.size(); i++) {
            minPrice = Math.min(minPrice, A.get(i));
            maxProfit = Math.max(maxProfit, A.get(i) - minPrice);
        }

        return maxProfit;
    }

    /**
     * Partially Correct Answer. Time Limit Exceeded.
     * RTC: O(n^2)
     */
    public int maxProfit1(final List<Integer> A) {
        int maxProfit = 0;
        for (int i=0; i<A.size(); i++) {
            for (int j=i+1; j<A.size(); j++) {
                int profit = A.get(j) - A.get(i);
                if (profit > maxProfit)
                    maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
