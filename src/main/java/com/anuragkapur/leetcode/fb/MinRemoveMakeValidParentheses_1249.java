package com.anuragkapur.leetcode.fb;

public class MinRemoveMakeValidParentheses_1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        int openCount = 0;
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == '(') {
                builder.append(chars[i]);
                openCount ++;
            } else if (chars[i] == ')') {
                if (openCount > 0) {
                    builder.append(chars[i]);
                    openCount --;
                }
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                builder.append(chars[i]);
            }
        }

        if (openCount == 0) {
            return builder.toString();
        }

        chars = builder.toString().toCharArray();
        builder = new StringBuilder();
        for (int i=chars.length-1; i>=0; i--) {
            if (chars[i] == '(' && openCount > 0) {
                openCount --;
            } else {
                builder.append(chars[i]);
            }
        }

        return builder.reverse().toString();
    }
}
