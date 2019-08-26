package com.anuragkapur.pie.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anuragkapur
 */
public class FirstNonRepeatedChar {

    Map<Integer, Integer> charTracker = new HashMap<>();

    public String find(String str) {

        int i = 0;

        while (i < str.length()) {

            int codePoint = str.codePointAt(i);

            if (charTracker.containsKey(codePoint)) {
                if (charTracker.get(codePoint) == 1) {
                    charTracker.put(codePoint, 2);
                }
                // if more than one repetition, ignore updating. We only care about finding if repetitions are 0, 1
                // or more than 1
            } else {
                charTracker.put(codePoint, 1);
            }

            i += Character.charCount(codePoint);
        }

        i = 0;
        while (i < str.length()) {
            int codePoint = str.codePointAt(i);

            if (charTracker.get(codePoint) == 1) {
                return new String(Character.toChars(codePoint));
            }

            i += Character.charCount(codePoint);
        }

        return null;
    }
}
