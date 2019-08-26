package com.anuragkapur.ctci.arraysandstrings;

/**
 * @author anuragkapur
 */
public class Prob1_2_ReverseCharsInString {

    public String reverse(String input) {
        if (input == null)
            return null;

        char chars[] = input.toCharArray();
        int forward = 0;
        int backward = chars.length - 1;
        while (forward < backward) {
            char temp = chars[forward];
            chars[forward] = chars[backward];
            chars[backward] = temp;
            forward ++;
            backward --;
        }

        return new String(chars);
    }
}
