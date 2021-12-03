package com.anuragkapur.misc;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 */
public class StringDecoder {
    Stack<String> stack = new Stack<>();

    private String decode(String input) {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ']') {
                String str = getIntermediateString();
                String numStr = getNumber();
                String result = "";
                for (int j=0; j<Integer.parseInt(numStr); j++) {
                    result += str;
                }
                stack.push(result);
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

    private String getNumber() {
        String top = stack.pop();
        String result = top;
        while (!stack.isEmpty()) {
            top = stack.peek();
            if (isDigit(top)) {
                result = stack.pop() + result;
            } else {
                break;
            }
        }
        return result;
    }

    private boolean isDigit(String top) {
        if ((top.charAt(0) >= '1' && top.charAt(0) <= '9') || top.charAt(0) == '0') {
            return true;
        }

        return false;
    }

    private String getIntermediateString() {
        String result = "";
        String top = stack.pop();
        while (!top.equals("[")) {
            result = top + result;
            top = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        StringDecoder decoder = new StringDecoder();
        System.out.println(decoder.decode("3[a2[c]]"));
        System.out.println(decoder.decode("3[a]2[bc]"));
    }
}
