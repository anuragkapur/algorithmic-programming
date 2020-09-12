package com.anuragkapur.ib.leveljumps;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {



    /**
     * Partially Correct Answer. Time Limit Exceeded.
     * RTC: O(n^2)
     */
    public int longestConsecutive1(final List<Integer> A) {
        Set<Integer> nums = new HashSet<>(A);

        int longest = 0;

        for (Integer num : A) {
            int length = 1;
            while (nums.contains(num+1)) {
                length ++;
                num ++;
            }
            if (length > longest) {
                longest = length;
            }
        }

        return longest;
    }
}
