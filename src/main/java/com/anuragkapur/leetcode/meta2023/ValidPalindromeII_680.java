package com.anuragkapur.leetcode.meta2023;

public class ValidPalindromeII_680 {

    /**
     * Runtime Complexity = O(n)
     * Space Complexity = O(n)
     * Leetcode Status: Accepted; Runtime: 5ms; Beats 85.85% of users with Java
     */
    public boolean validPalindrome(String s) {
        char[] chs = s.toCharArray();
        if (isValidPalindrome(chs, 0, chs.length-1)) {
            return true;
        } else {
            int front = 0;
            int back = chs.length-1;
            while (front < back) {
                if (chs[front] != chs[back]) {
                    if (isValidPalindrome(chs, front+1, back)) {
                        return true;
                    } else if (isValidPalindrome(chs, front, back-1)) {
                        return true;
                    } else {
                        return false;
                    }
                }
                front++;
                back--;
            }
        }
        return true;
    }

    private boolean isValidPalindrome(char[] chs, int front, int back) {
        while (front < back) {
            if (chs[front] == chs[back]) {
                front ++;
                back --;
            } else {
                return false;
            }
        }
        return true;
    }
}
