package com.anuragkapur.misc;

import java.util.Stack;

/**
 * @author anuragkapur
 */
public class ReverseMultiplesOf3 {

    /**
     * Running time: O(2n)
     * Space complexity: O(n)
     *
     * @param str
     * @return
     */
    public String reverse(String str) {

        char charsOfStr[] = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        // first iteration to populate stack
        for(char ch : charsOfStr) {
            if(ch >='0' && ch<='9') {
                if(ch % 3 == 0) {
                    stack.push(ch);
                }
            }
        }

        // reverse multiples of 3
        for(int i=0; i<charsOfStr.length; i++) {
            if(charsOfStr[i] >='0' && charsOfStr[i]<='9') {
                if(charsOfStr[i] % 3 == 0) {
                    charsOfStr[i] = stack.pop();
                }
            }
        }

        return new String(charsOfStr);
    }

    /**
     * Running time: O(n)
     * Space complexity: O(1)
     *
     * @param str
     * @return
     */
    public String reverse1(String str) {

        char chars[] = str.toCharArray();
        int forward = 0;
        int backward = chars.length - 1;
        boolean forwardReady = false;
        boolean backwardReady = false;

        while (forward < backward) {

            if (forwardReady && backwardReady) {
                char temp = chars[forward];
                chars[forward] = chars[backward];
                chars[backward] = temp;
                forwardReady = false;
                backwardReady = false;
                forward ++;
                backward --;
                continue;
            }

            if (Character.isDigit(chars[forward]) && Character.getNumericValue(chars[forward]) % 3 == 0) {
                forwardReady = true;
            } else {
                forward ++;
            }

            if (Character.isDigit(chars[backward]) && Character.getNumericValue(chars[backward]) % 3 == 0) {
                backwardReady = true;
            } else {
                backward --;
            }

        }

        return new String(chars);
    }
}
