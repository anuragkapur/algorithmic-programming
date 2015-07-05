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
            return isOneInsertAway(chars2, chars1);
        } else if(chars1.length < chars2.length) {
            return isOneInsertAway(chars1, chars2);
        } else {
            return isOneReplaceAway(chars1, chars2);
        }
    }

    private boolean isOneReplaceAway(char chars1[], char chars2[]) {

        if (chars1.length != chars2.length) {
            throw new IllegalArgumentException("string should be of equal length");
        }

        boolean oneDifferentSeen = false;
        for (int i=0; i<chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                if (oneDifferentSeen) {
                    return false;
                }

                oneDifferentSeen = true;
            }
        }

        return true;
    }

    private boolean isOneInsertAway(char chars1[], char chars2[]) {

        int pointer1 = 0;
        int pointer2 = 0;

        boolean oneDifferenceSeen = false;

        while (pointer1 < chars1.length && pointer2 < chars2.length) {
            if (chars1[pointer1] != chars2[pointer2]) {
                if (oneDifferenceSeen) {
                    return false;
                } else {
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
