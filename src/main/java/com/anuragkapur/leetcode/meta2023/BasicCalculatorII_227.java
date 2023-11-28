package com.anuragkapur.leetcode.meta2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorII_227 {

    /**
     * Runtime Complexity: O(n)
     * Space Complexity: O(n)
     * Leetcode Status: Accepted; Runtime: 46ms; Beats 8.64% of users with Java
     */
    public int calculate(String s) {
        List<String> inputList = parseInputString(s);
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<inputList.size(); i++) {
            String str = inputList.get(i);
            if (str.equals("-")) {
                stack.push(-1 * Integer.parseInt(inputList.get(i+1)));
                i++;
            } else if (str.equals("*")) {
                stack.push(Integer.parseInt(inputList.get(i+1)) * stack.pop());
                i++;
            } else if (str.equals("/")) {
                stack.push(stack.pop() / Integer.parseInt(inputList.get(i+1)));
                i++;
            } else if (!str.equals("+")){
                stack.push(Integer.parseInt(str));
            } else {
                // + is a no op
            }
        }

        int result = stack.pop();
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    /**
     * Runtime Complexity: O(n)
     */
    private static List<String> parseInputString(String s) {
        char[] chs = s.toCharArray();
        List<String> strs = new ArrayList<>();
        StringBuilder numberStringBuilder = new StringBuilder();
        for (char ch : chs) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (numberStringBuilder.length() > 0) {
                    strs.add(numberStringBuilder.toString());
                    numberStringBuilder = new StringBuilder();
                }
                strs.add(String.valueOf(ch));
            } else if (ch == ' ') {
                if (numberStringBuilder.length() > 0) {
                    strs.add(numberStringBuilder.toString());
                    numberStringBuilder = new StringBuilder();
                }
            } else {
                numberStringBuilder.append(ch);
            }
        }
        if (numberStringBuilder.length() > 0) {
            strs.add(numberStringBuilder.toString());
        }
        return strs;
    }
}
