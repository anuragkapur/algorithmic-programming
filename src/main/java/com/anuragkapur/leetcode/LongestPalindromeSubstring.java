package com.anuragkapur.leetcode;

/**
 * @author anuragkapur
 */
public class LongestPalindromeSubstring {

    /**
     * Run time complexity: O(n^2) (worst case)
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 1) {
            return s;
        }

        final char chars[] = s.toCharArray();
        int longestLength = 0;
        int longestStart = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i && (j - i + 1) > longestLength; j--) {
                if (isPalindrome(chars, i, j)) {
                    longestStart = i;
                    longestLength = j - i + 1;
                    break;
                }
            }
        }

        return new String(chars, longestStart, longestLength);
    }

    private boolean isPalindrome(final char chars[], int start, int end) {

        if (start > end) {
            throw new IllegalArgumentException("Invalid char array indices provided :: " + start + " , "+ end);
        }

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start ++;
            end --;
        }

        return true;
    }
}
