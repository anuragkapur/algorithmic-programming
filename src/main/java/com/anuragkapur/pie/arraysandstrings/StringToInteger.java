package com.anuragkapur.pie.arraysandstrings;

/**
 * @author anuragkapur
 */
public class StringToInteger {

    public static int convert(String str) {

        if (str == null) {
            throw new IllegalArgumentException("string cannot be null");
        }

        boolean negative = str.startsWith("-");
        int length = str.length();

        if (negative)
            length --;

        int start = negative ? 1 : 0;
        int end = negative ? length : length - 1;
        // assuming the number represented by the string is within range of Integer.MIN_VALUE to Integer.MAX_VALUE
        int multiplier = (int)Math.pow(10, (length-1));

        int number = 0;
        char chars[] = str.toCharArray();
        for (int i=start; i<=end; i++) {
            int num = Character.getNumericValue(chars[i]);
            number += num * multiplier;
            multiplier /= 10;
        }

        if (negative)
            number = number * -1;

        return number;
    }
}
