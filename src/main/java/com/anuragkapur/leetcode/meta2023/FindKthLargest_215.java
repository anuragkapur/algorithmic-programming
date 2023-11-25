package com.anuragkapur.leetcode.meta2023;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargest_215 {

    /**
     * Time Complexity: Worst case: O(n^2); Average case: O(n)
     * Space Complexity: O(n)
     * Leetcode Status: Accepted; Runtime: 311ms; Beats 11.25% of users with Java
     */
    public int findKthLargest(int[] nums, int k) {

        int first = nums[0];
        List<Integer> larger = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if(nums[i] == first) {
                equal.add(nums[i]);
            } else if (nums[i] > first) {
                larger.add(nums[i]);
            } else {
                smaller.add(nums[i]);
            }
        }

        if (k <= larger.size()) {
            // look in larger
            return findKthLargest(convertIntListToArray(larger), k);
        } else {
            k = k - larger.size();
            if (k <= equal.size()) {
                return first;
            } else {
                // look in smaller
                k = k - equal.size();
                return findKthLargest(convertIntListToArray(smaller), k);
            }
        }
    }

    private int[] convertIntListToArray(List<Integer> list) {
        return list.stream().mapToInt(i -> i).toArray();
    }
}
