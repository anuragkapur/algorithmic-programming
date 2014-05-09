package com.anuragkapur.ctci;

import java.util.Arrays;

/**
 * @author: anuragkapur
 * @since: 07/05/2014
 */

public class Prob1_3_1_AreStringsPermutations {

    public static boolean checkIfPermutations(String str1, String str2) {

        if(str1.length() != str2.length())
            return false;

        char chars1[] = str1.toCharArray();
        char chars2[] = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for(int i=0; i<str1.length(); i++) {
            if(chars1[i] != chars2[i])
                return false;
        }

        return true;
    }
}
