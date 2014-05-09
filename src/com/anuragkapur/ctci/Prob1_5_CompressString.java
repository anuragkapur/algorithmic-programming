package com.anuragkapur.ctci;

/**
 * @author: anuragkapur
 * @since: 07/05/2014
 */

public class Prob1_5_CompressString {

    // assuming string cannot have a null character
    public static String compressedString(String str) {

        StringBuilder builder = new StringBuilder();

        char ch = (char)0;
        int count = 0;

        for(int i=0; i<str.length(); i++) {
            if(ch != str.charAt(i)) {
                if(ch != (char)0) {
                    builder.append(ch).append(count);
                }
                ch = str.charAt(i);
                count = 1;
            } else {
                count ++;
            }
        }

        if(ch != (char)0)
            builder.append(ch).append(count);

        if (builder.toString().length() == str.length())
            return str;

        return builder.toString();
    }
}
