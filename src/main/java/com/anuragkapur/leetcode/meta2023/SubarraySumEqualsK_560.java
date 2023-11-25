package com.anuragkapur.leetcode.meta2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumEqualsK_560 {

    /**
     * Runtime complexity: O(n)
     * Space complexity: O(n)
     * Leetcode Status: Accepted; 17ms; Beats 99.65% of users with Java
     */
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        int count = 0;
        frequencies.put(0, 1);
        for (int i=0; i<prefixSum.length; i++) {
            int lookingFor = prefixSum[i] - k;
            if (frequencies.containsKey(lookingFor)) {
                int x = frequencies.get(lookingFor);
                count += x;
            }
            if (frequencies.containsKey(prefixSum[i])) {
                int x = frequencies.get(prefixSum[i]);
                frequencies.put(prefixSum[i], x+1);
            } else {
                frequencies.put(prefixSum[i], 1);
            }

        }

        return count;
    }

    /**
     * Correct by time limit exceeded
     */
    public int subarraySum2(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        Map<Integer, List<Integer>> frequencies = new HashMap<>();
        for (int i=0; i<prefixSum.length; i++) {
            if (frequencies.containsKey(prefixSum[i])) {
                frequencies.get(prefixSum[i]).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                frequencies.put(prefixSum[i], indices);
            }
        }

        int count = 0;
        for (int i=0; i<prefixSum.length; i++) {
            if (prefixSum[i] == k) {
                count ++;
            }
            int lookingFor = prefixSum[i] - k;
            if (frequencies.containsKey(lookingFor)) {
                List<Integer> indices = frequencies.get(lookingFor);
                for (Integer index : indices) {
                    if (index < i) {
                        count ++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * Runtime complexity: O(n^2)
     * Space complexity: O(1)
     * Leetcode status: Accepted; 1114ms; Beats 23.28% of users with Java
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                count ++;
            }
            for (int j=i+1; j<nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count ++;
                }
            }
        }
        return count;
    }
}
