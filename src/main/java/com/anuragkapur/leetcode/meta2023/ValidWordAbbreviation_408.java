package com.anuragkapur.leetcode.meta2023;

import java.util.ArrayList;
import java.util.List;

public class ValidWordAbbreviation_408 {
    boolean leadingZero = false;

    /**
     * Runtime Complexity: O(n), n = number of chars in abbreviation
     * Leetcode status: Accepted; Runtime: 2ms; Beats 18.46% of users with Java
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        List<String> listOfAbbrStrings = getListOfCharNumberString(abbr);

        if (leadingZero) {
            return false;
        }

        int i = 0;
        for (String abbrToken : listOfAbbrStrings) {
            if (i >= word.length()) {
                return false;
            }
            if (isChar(abbrToken)) {
                if (abbrToken.equals(word.substring(i, i+1))) {
                    i ++;
                } else {
                    return false;
                }
            } else {
                i += Integer.parseInt(abbrToken);
            }
        }

        if (i != word.length()) {
            return false;
        }

        return true;
    }

    private List<String> getListOfCharNumberString(String abbr) {
        List<String> listOfStrings = new ArrayList<>();
        char[] chars = abbr.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                // Reminder: easy to forget edge condition
                if (builder.length() == 0 && ch == '0') {
                    leadingZero = true;
                }
                builder.append(ch);
            } else {
                if (builder.length() > 0) {
                    listOfStrings.add(builder.toString());
                    builder = new StringBuilder();
                }
                listOfStrings.add(String.valueOf(ch));
            }
        }

        // Reminder: this is easy to forget; don't!
        if (builder.length() > 0) {
            listOfStrings.add(builder.toString());
        }
        return listOfStrings;
    }

    private boolean isChar(String str) {
        char[] chs = str.toCharArray();
        if (chs.length > 1) {
            return false;
        } else {
            if (Character.isDigit(chs[0])) {
                return false;
            }
            return true;
        }
    }
}
