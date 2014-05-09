package com.anuragkapur.ctci;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if all chars in a string are unique
 *
 * @author: anuragkapur
 * @since: 01/05/2014
 */

public class Prob1_1_AreAllCharsUniqueInString {

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
