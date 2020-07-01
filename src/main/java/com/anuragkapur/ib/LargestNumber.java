package com.anuragkapur.ib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    /**
     * Correct solution
     * RTC: O(n log(n))
     *
     * @param A
     * @return
     */
    public String largestNumber(final List<Integer> A) {

        Comparator<Integer> descending = (Integer i1, Integer i2) -> {

            String s1 = ""+i1+i2;
            String s2 = ""+i2+i1;

            Long l1 = Long.parseLong(s1);
            Long l2 = Long.parseLong(s2);

            return l1.compareTo(l2)*-1;
        };

        A.sort(descending);

        StringBuilder builder = new StringBuilder();
        boolean leadingZeroAdded = false;
        for (Integer num : A) {
            if (num == 0 && leadingZeroAdded) {
                continue;
            } else if (num == 0 && !leadingZeroAdded) {
                builder.append(num);
                leadingZeroAdded = true;
            } else {
                builder.append(num);
            }
        }

        return builder.toString();
    }

    /**
     * Unknown bug
     *
     * @param A
     * @return
     */
    public String largestNumber1(final List<Integer> A) {

        List<String> nums = new ArrayList<>();
        for (Integer num : A) {
            nums.add(num+"");
        }

        Comparator<String> descending = (String s1, String s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2) * -1;
            }

            String s1Comparator = s1;
            String s2Comparator = s2;

            if (s1.length() < s2.length()) {
                int diff = s2.length() - s1.length();
                StringBuilder builder = new StringBuilder(s1);
                for (int i=0; i<diff; i++) {
                    // first character of s2
                    builder.append(s2.charAt(0));
                }
                s1Comparator = builder.toString();
            } else {
                int diff = s1.length() - s2.length();
                StringBuilder builder = new StringBuilder(s2);
                for (int i=0; i<diff; i++) {
                    // first character of s1
                    builder.append(s1.charAt(0));
                }
                s2Comparator = builder.toString();
            }

            return s1Comparator.compareTo(s2Comparator) * -1;
        };

        nums.sort(descending);

        StringBuilder builder = new StringBuilder();
        boolean leadingZeroAdded = false;
        for (String str : nums) {
            if (str.charAt(0) == '0' && leadingZeroAdded) {
                // do nothing
            } else if (str.charAt(0) == '0' && !leadingZeroAdded) {
                builder.append(str);
                leadingZeroAdded = true;
            } else {
                builder.append(str);
            }
        }

        return builder.toString();
    }
}
