package com.anuragkapur.ctci6ed.arraysandstrings;

/**
 * @author anuragkapur
 */
public class OneAway {

    /**
     * Run time complexity: O(n)
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean areOneAway(String str1, String str2) {

        if (str1 == null || str2 == null) {
            return false;
        }

        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        char chars1[] = str1.toCharArray();
        char chars2[] = str2.toCharArray();

        if (chars1.length > chars2.length) {
            return isOneAway(chars2, chars1);
        } else if(chars1.length < chars2.length) {
            return isOneAway(chars1, chars2);
        } else {
            return isOneAway(chars1, chars2);
        }
    }

    private boolean isOneAway(char chars1[], char chars2[]) {

        int pointer1 = 0;
        int pointer2 = 0;

        boolean oneDifferenceSeen = false;

        while (pointer1 < chars1.length && pointer2 < chars2.length) {
            if (chars1[pointer1] != chars2[pointer2]) {
                if (oneDifferenceSeen) {
                    return false;
                } else {
                    if (chars2.length == chars1.length) {
                        pointer1 ++;
                    }
                    pointer2 ++;
                    oneDifferenceSeen = true;
                }
            } else {
                pointer1 ++;
                pointer2 ++;
            }
        }

        return true;
    }
}
