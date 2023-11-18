package com.anuragkapur.leetcode.fb2021;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {

    /**
     * RTC: O(n)
     * SC: O(n)
     *
     * Algo explanation: https://www.youtube.com/watch?v=HbbYPQc-Oo4
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> sumCounts = new HashMap<>();
        int sum = 0;

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                count ++;
            }

            if (sumCounts.containsKey(sum-k)) {
                int freq = sumCounts.get(sum-k);
                count += freq;
            }

            upsert(sumCounts, sum);
        }
        return count;
    }

    private void upsert(Map<Integer, Integer> sumCounts, int sum) {
        if (sumCounts.containsKey(sum)) {
            int freq = sumCounts.get(sum);
            freq ++;
            sumCounts.put(sum, freq);
        } else {
            sumCounts.put(sum, 1);
        }
    }

    /**
     * RTC: O(n^2)
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i=0; i<=nums.length; i++) {
            int sum = 0;
            for (int j=i; j<nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count ++;
                }
            }
        }
        return count;
    }
}
