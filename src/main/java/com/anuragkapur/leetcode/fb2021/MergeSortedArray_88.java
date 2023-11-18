package com.anuragkapur.leetcode.fb2021;

public class MergeSortedArray_88 {

    /**
     * RTC: O(m+n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // right shift elements in nums1
        for (int i=m+n-1; i>=0; i--) {
            if (i-n >= 0) {
                nums1[i] = nums1[i-n];
            } else {
                break;
            }
        }

        // merge
        int i = 0;
        int i1 = n;
        int i2 = 0;
        while (i < (m+n)) {
            if (i1-n == m) {
                nums1[i++] = nums2[i2++];
            } else if (i2 == n) {
                nums1[i++] = nums1[i1++];
            } else if (nums1[i1] < nums2[i2]){
                nums1[i++] = nums1[i1++];
            } else {
                nums1[i++] = nums2[i2++];
            }
        }
    }

    /**
     * RTC: O((m+n)*n)
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        // right shift elements in nums1 (n) times
        // RTC: O((m+n)*n)
        for (int i=0; i<n; i++)
            rightShift(nums1);

        // merge
        // RTC: O(m+n)
        int i = 0;
        int i1 = n;
        int i2 = 0;
        while (i < (m+n)) {
            if (i1-n == m) {
                nums1[i++] = nums2[i2++];
            } else if (i2 == n) {
                nums1[i++] = nums1[i1++];
            } else if (nums1[i1] < nums2[i2]){
                nums1[i++] = nums1[i1++];
            } else {
                nums1[i++] = nums2[i2++];
            }
        }
    }

    /**
     * RTC: O(m+n)
     */
    private void rightShift(int[] nums1) {
        for (int i=nums1.length-1; i>=1; i--) {
            nums1[i] = nums1[i-1];
        }
    }
}
