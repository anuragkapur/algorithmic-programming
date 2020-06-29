package com.anuragkapur.leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end-start)/2;
        if (nums[mid] == target) {
            return mid;
        }

        int index = -1;

        // left
        if (containsPivot(nums, start, mid) || nums[mid] > target) {
            index = search(nums, target, start, mid-1);
        }

        if (index != -1) {
            return index;
        }

        // right
        if (containsPivot(nums, mid, end) || nums[mid] < target) {
            index = search(nums, target, mid+1, end);
        }

        return index;
    }

    private boolean containsPivot(int[] nums, int start, int end) {
        return nums[end] <= nums[start];
    }
}
