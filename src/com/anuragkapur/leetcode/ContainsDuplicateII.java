package com.anuragkapur.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anuragkapur
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> numberIndices = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(j-i > k) {
                    break;
                }
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
