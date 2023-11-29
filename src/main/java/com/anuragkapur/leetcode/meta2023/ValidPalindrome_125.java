package com.anuragkapur.leetcode.meta2023;

public class ValidPalindrome_125 {

    /**
     * Runtime Complexity: O(n)
     * Space Complexity: O(n)
     * Leetcode Status: Accepted; Runtime: 5ms; Beats 48.35% of users with Java; Memory: 41.7MB; Beats 82.13% of users
     * with Java
     */
    public boolean isPalindrome(String s) {
        int countAlphaNum = countAlphaNum(s);
        char[] chs = new char[countAlphaNum];
        int current = 0;
        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isLetterOrDigit(currentChar)) {
                chs[current++] = Character.toLowerCase(currentChar);
            }
        }

        int front = 0;
        int back = chs.length - 1;
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

    private int countAlphaNum(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                count ++;
            }
        }
        return count;
    }
}
