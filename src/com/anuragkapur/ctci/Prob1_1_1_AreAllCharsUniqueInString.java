package com.anuragkapur.ctci;

/**
 * Check if all chars in a string are unique without using a new Data Structure
 *
 * @author: anuragkapur
 * @since: 01/05/2014
 */
public class Prob1_1_1_AreAllCharsUniqueInString {

    public static boolean determineIfAllUnique(String str) {
        boolean result = true;

        char charsInString[] = str.toCharArray();

        for(int i=0; i<charsInString.length; i++) {
            for(int j=i+1; j<charsInString.length; j++) {
                if(charsInString[i] == charsInString[j]) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        String testString = "qwertyuiop";
        System.out.println("test string :: " + testString + " result :: " + determineIfAllUnique(testString));

        testString = "abracadabra";
        System.out.println("test string :: " + testString + " result :: " + determineIfAllUnique(testString));

        testString = "qwert1yuiop21";
        System.out.println("test string :: " + testString + " result :: " + determineIfAllUnique(testString));

    }
}
