package com.anuragkapur.ctci6ed.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anuragkapur
 */
public class PalindromePermutation {

    /**
     * Run time complexity: O(n)
     *
     * @param input
     * @return
     */
    public boolean isPalindromePermutation(String input) {

        if (input == null) {
            return false;
        }

        String singleSpace = " ";
        int emptySpaceCodePoint = singleSpace.codePointAt(0);

        input = input.toLowerCase();

        int charCount = input.codePointCount(0, input.length());
        int initialCapacityForNoRehashes = (int)(charCount / 0.75) + 1;
        Map<Integer, Boolean> charCountOdd = new HashMap<>(initialCapacityForNoRehashes);

        for (int i = 0; i < charCount; i++) {

            int codePoint = input.codePointAt(i);

            if (codePoint != emptySpaceCodePoint) {
                if(charCountOdd.containsKey(codePoint)) {
                    Boolean isOdd = charCountOdd.get(codePoint);
                    charCountOdd.put(codePoint, !isOdd);
                } else {
                    charCountOdd.put(codePoint, true);
                }
            }
        }

        int totalOddChars = 0;
        for (Integer codePoint : charCountOdd.keySet()) {
            if (charCountOdd.get(codePoint)) {
                totalOddChars ++;
            }

            if (totalOddChars > 1) {
                return false;
            }
        }

        return true;
    }
}
