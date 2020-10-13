package com.anuragkapur.leetcode.fb;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * RTC: O(n)
 * SC: O(n)
 */
public class ProductArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];


        lefts[0] = 1;
        for (int i=1; i<nums.length; i++) {
            lefts[i] = lefts[i-1] * nums[i-1];
        }

        rights[nums.length-1] = 1;
        for (int i=nums.length-2; i>=0; i--) {
            rights[i] = rights[i+1] * nums[i+1];
        }

        int[] answer = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            answer[i] = lefts[i] * rights[i];
        }

        return answer;
    }
}
