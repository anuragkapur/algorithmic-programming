package com.anuragkapur.leetcode;

import java.util.Arrays;

/**
 * @author anuragkapur
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }

        return false;
    }
}
