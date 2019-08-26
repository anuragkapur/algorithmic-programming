package com.anuragkapur.misc;

/**
 * Compute if given string is a substring of a another string
 *
 * @author: anuragkapur
 * @since: 11/05/2014
 */

public class StringSubString {

    public static boolean isSubString(char[] givenString, char[] parentString) {

        boolean isSubString = true;

        for(int i=0; i<parentString.length; i++) {

            isSubString = true;
            int indexOfGivenString = 0;

            for(int j=i; j<parentString.length; j++) {
                if(givenString[indexOfGivenString] != parentString[j]) {
                    isSubString = false;
                    break;
                }

                indexOfGivenString ++;

                if(indexOfGivenString >= givenString.length)
                    break;
            }

            if(isSubString)
                break;
        }

        return isSubString;
    }


    public static boolean findSubString(char[] subString, char[] parentString) {

        int indexOfSubString = 0;
        int solutionIndex = 0;

        for(int i=0; i<parentString.length; i++) {

            if(subString[indexOfSubString] == parentString[i]) {

                if(indexOfSubString == 0) {
                    solutionIndex = i;
                }
            }else {
                indexOfSubString = 0;
                if(subString[indexOfSubString] == parentString[i]) {
                    if(indexOfSubString == 0) {
                        solutionIndex = i;
                    }
                }
            }

            indexOfSubString ++;

            if(indexOfSubString >= subString.length) {
                break;
            }

        }

        if(indexOfSubString >= subString.length){
            return true;
        }else {
            return false;
        }
    }
}
