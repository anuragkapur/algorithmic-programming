package com.anuragkapur.leetcode.meta2023;

public class FindPeakElement_162 {

    /**
     * Runtime Complexity: O(n)
     * Space Complexity: O(1)
     * Leetcode Status: Accepted; Runtime 0ms, Beats 100.00% of users with Java
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (left == right) {
                // single element => peak
                return left;
            } else {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[mid+1]) {
                    right = mid;
                } else {
                    left = mid+1;
                }
            }
        }

        throw new RuntimeException("shouldn't happen unless there is a logical error in algorithm");
    }
}
