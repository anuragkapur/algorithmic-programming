package com.anuragkapur.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author anuragkapur
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Running time: O(n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        char chars[] = s.toCharArray();
        Set<Character> uniques = new HashSet<>();
        int start = 0;
        int end = 0;
        int length = 0;

        while (end < chars.length) {
            if (uniques.add(chars[end])) {
                end ++;
            } else {
                int candidateLength = end-start;
                length = Math.max(length, candidateLength);

                // move start until the repeated element is removed
                while (chars[start] != chars[end]) {
                    uniques.remove(chars[start]);
                    start ++;
                }
                start ++;
                end ++;
            }
        }

        return Math.max(length, end-start);
    }
}
