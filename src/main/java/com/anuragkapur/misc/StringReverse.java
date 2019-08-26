package com.anuragkapur.misc;

/**
 * @author: anuragkapur
 * @since: 26/05/2014
 */

public class StringReverse {

    public static String reverse(String str) {

        char chars[] = str.toCharArray();
        int lastIndex = chars.length - 1;
        for(int i=0; i<chars.length / 2; i++) {
            char temp = chars[lastIndex - i];
            chars[lastIndex - i] = chars[i];
            chars[i] = temp;
        }

        return new String(chars);
    }
}
