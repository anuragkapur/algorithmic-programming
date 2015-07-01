package com.anuragkapur.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;

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

    public boolean containtDuplicateAlternate(int [] nums) {
        Set<Integer> allNums = new HashSet<>();
        OptionalInt duplicateCount = Arrays.stream(nums).filter(num -> !allNums.add(num)).findAny();
        return duplicateCount.isPresent();
    }

    public boolean containtDuplicateAlternate2(int [] nums) {
        IntStream distinctNumStream = Arrays.stream(nums).distinct();
        int distinctCount = (int)distinctNumStream.count();

        return (distinctCount != nums.length);
    }
}
