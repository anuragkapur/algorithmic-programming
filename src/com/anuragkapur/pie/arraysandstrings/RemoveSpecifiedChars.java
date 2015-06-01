package com.anuragkapur.pie.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anuragkapur
 */
public class RemoveSpecifiedChars {

    /**
     * Running time: O(n), assuming average case with HashMap lookups completing in O(1)
     * Space complexity: O(n), uses extra data structure
     * @param str
     * @param remove
     * @return
     */
    public static String remove(String str, String remove) {

        Map<Character, Boolean> removeMap = new HashMap<>();
        for (char ch : remove.toCharArray()) {
            removeMap.put(ch, true);
        }

        StringBuilder builder = new StringBuilder();
        for (char ch: str.toCharArray()) {
            if (!removeMap.containsKey(ch)) {
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
