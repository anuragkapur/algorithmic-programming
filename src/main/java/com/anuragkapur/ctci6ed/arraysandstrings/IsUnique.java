package com.anuragkapur.ctci6ed.arraysandstrings;

import java.io.*;
import java.util.*;

class IsUnique {

    /**
     * O(n)
     *
     * @param input
     * @return
     */
    private static boolean isUnique(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string should not be null or empty");
        }

        Set<Character> uniqueCheckSet = new HashSet<>();
        for(char ch : input.toCharArray()) {
            boolean wasNumberAdded = uniqueCheckSet.add(ch);
            if (!wasNumberAdded) {
                return false;
            }
        }

        return true;
    }

    /**
     * O(n^2)
     *
     * @param input
     * @return
     */
    private static boolean isUniqueNoAdditionalDataStructures(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string should not be null or empty");
        }

        char[] chs = input.toCharArray();
        for (int i=0; i<chs.length; i++) {
            char ch = chs[i];
            for (int j=i+1; j<chs.length; j++) {
                if (chs[j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "abc";
        System.out.println(isUnique(input));
        System.out.println(isUniqueNoAdditionalDataStructures(input));
    }
}
