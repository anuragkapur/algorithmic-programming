package com.anuragkapur.ctci;

/**
 * @author: anuragkapur
 * @since: 07/05/2014
 */

public class Prob1_3_AreStringsPermutations {

    public static boolean checkIfPermutations(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        char chars1[] = str1.toCharArray();
        char chars2[] = str2.toCharArray();

        for(char ch : chars1) {
            boolean matchFound = false;
            for(int i=0; i<chars2.length; i++) {
                if(chars2[i] == ch) {
                    matchFound = true;
                    // Assuming strings of ASCII characters, and using character with int value 256 as a control
                    // character, not used ever in the input strings.
                    chars2[i] = (char)256;
                    break;
                }
            }
            if(!matchFound)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "bcad";

        System.out.println(checkIfPermutations(str1, str2));
    }
}
