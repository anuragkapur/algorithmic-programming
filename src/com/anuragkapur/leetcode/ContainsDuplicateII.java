package com.anuragkapur.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anuragkapur
 */
public class ContainsDuplicateII {

    /**
     * Running time: O(n)
     * Space complexity: O(n), uses additional data structure of size n in the worst case
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null) {
            return false;
        }

        Map<Integer, Integer> numberIndices = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(numberIndices.containsKey(nums[i])) {
                int indexOfPreviousOccurrence = numberIndices.get(nums[i]);
                if(i-indexOfPreviousOccurrence <= k) {
                    return true;
                }
            }
            numberIndices.put(nums[i], i);
        }

        return false;
    }
}
