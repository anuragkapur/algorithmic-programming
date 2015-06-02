package com.anuragkapur.pie.arraysandstrings;

/**
 * @author anuragkapur
 */
public class IntegerToString {

    public static String convert(int number) {

        StringBuilder builder = new StringBuilder();

        boolean negative = false;
        if (number < 0) {
            negative = true;
            number = -number;
        }

         do {
            int remainder = number % 10;
            number /= 10;
            builder.append(remainder);
        } while (number > 0);

        String reversedNumber = builder.toString();
        char ch[] = new char[reversedNumber.length()];
        int start = 0;
        for (int i = reversedNumber.length()-1; i >= 0 ; i--) {
            ch[start] = reversedNumber.charAt(i);
            start ++;
        }

        String result = new String(ch);
        if (negative)
            result = "-" + result;

        return result;
    }
}
