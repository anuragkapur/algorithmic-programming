package com.anuragkapur.leetcode.fb2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VerifyingAlienDictionary_953 {
    private String order;
    private boolean sorted;
    private Map<Character, Integer> dictIndex = new HashMap<>();

    /**
     * RTC: O(nw)
     * where,
     *  n = average word length
     *  w = number of words
     */
    public boolean isAlienSorted(String[] words, String order) {
        this.order = order;
        populateDictIndex();
        sorted = true;
        compute(words, 0);
        return sorted;
    }

    /**
     * RTC: O(n)
     * where,
     *  n = number of characters in dictionary
     */
    private void populateDictIndex() {
        char[] chars = order.toCharArray();
        for (int i=0; i<chars.length; i++) {
            dictIndex.put(chars[i], i);
        }
    }

    /**
     * RTC: O(nw)
     * where,
     *  n = average word length
     *  w = number of words
     */
    private void compute(String[] words, int index) {
        if (!sorted) {
            return;
        }

        // RTC: O(w), where w = number of words
        boolean allWordsConsumed = true;
        for (int i=0; i<words.length; i++) {
            if (index < words[i].length()) {
                allWordsConsumed = false;
                break;
            }
        }

        if (allWordsConsumed) {
            return;
        }

        // RTC: O(w), where w = number of words
        char[] chars = getFirstChars(words, index);

        // RTC: O(w), where w = number of words
        if (areAnyFirstCharsEqual(chars)) {
            if (areFirstCharsInSortedOrder(chars)) {
                compute(words, index+1);
            } else {
                sorted = false;
            }
        } else {
            sorted = areFirstCharsInSortedOrder(chars);
        }

    }

    private char[] getFirstChars(String[] words, int index) {
        char[] chars = new char[words.length];
        for (int i=0; i<words.length; i++) {
            if (index < words[i].length()) {
                chars[i] = words[i].charAt(index);
            } else {
                chars[i] = '\0';
            }
        }
        return chars;
    }

    private boolean areAnyFirstCharsEqual(char[] chars) {
        Set<Character> dupChecker = new HashSet<>();
        for (int i=0; i<chars.length; i++) {
            if (!dupChecker.add(chars[i])) {
                return true;
            }
        }

        return false;
    }

    private boolean areFirstCharsInSortedOrder(char[] chars) {

        char previousChar = chars[0];
        for (int i=1; i<chars.length; i++) {
            char currentChar = chars[i];
            if (!areSorted(previousChar, currentChar)) {
                return false;
            }
            previousChar = currentChar;
        }

        return true;
    }

    private boolean areSorted(char ch1, char ch2) {
        int indexOfCh1 = -1;
        int indexOfCh2 = -1;
        if (dictIndex.containsKey(ch1)) {
            indexOfCh1 = dictIndex.get(ch1);
        }
        if (dictIndex.containsKey(ch2)) {
            indexOfCh2 = dictIndex.get(ch2);
        }
        return indexOfCh1 <= indexOfCh2;
    }
}
