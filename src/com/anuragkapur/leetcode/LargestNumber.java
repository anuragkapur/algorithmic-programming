package com.anuragkapur.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author anuragkapur
 */
public class LargestNumber {

    /**
     * Run time complexity: O( kn log(n)), where k is the avg length of numbers and n is the no. of numbers
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {

        if (nums == null) {
            return null;
        }

        Comparator<String> comparator = (s1, s2) -> {

            if (s1.equals(s2)) return 0;

            String option1 = s1+s2;
            String option2 = s2+s1;

            char chars1[] = option1.toCharArray();
            char chars2[] = option2.toCharArray();

            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] > chars2[i]) {
                    // option1 gives desired result => s1 > s2 => s1 - s2 should be positive. For reverse order return
                    // -1
                    return -1;
                } else if (chars1[i] < chars2[i]) {
                    return 1;
                }
            }

            return 0;
        };

        StringBuilder builder = new StringBuilder();
        Arrays.stream(nums).mapToObj(String::valueOf).sorted(comparator).forEach(builder::append);
        String intermediateAnswer = builder.toString();

        // strip leading 0's
        builder = new StringBuilder();
        boolean leadingZero = true;
        for (char ch : intermediateAnswer.toCharArray()) {
            if (ch != '0') {
                leadingZero = false;
            }

            if (!leadingZero) {
                builder.append(ch);
            }
        }

        return builder.toString().equals("") ? "0" : builder.toString();
    }
}
