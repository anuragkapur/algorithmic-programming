package com.anuragkapur.ctci.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if all chars in a string are unique.
 *
 * @author: anuragkapur
 * @since: 01/05/2014
 */

public class Prob1_1_AreAllCharsUniqueInString {

    /**
     * Adds each character of the string to a Set, one at a time. Since a Set does not allow duplicate entries, we can
     * detect the presence of a duplicate character and break with the result of the computation.
     *
     * Running time: O(n)
     * Space complexity: 2n
     *
     * where n is the number of characters in the string
     *
     * The HashSet used does not add to the big-o run time complexity since it provides constant time performance for
     * inserts.
     *
     * @param str
     * @return
     */
    public static boolean determineIfAllUnique(String str) {
        boolean result = true;

        char charsInString[] = str.toCharArray();
        Set<Character> charSet = new HashSet<>();

        for(char charInString : charsInString) {
            boolean added = charSet.add(charInString);
            if(!added) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        String testString = "qwertyuiop";
        System.out.println("test string :: " + testString + " result :: " + determineIfAllUnique(testString));
    }
}
