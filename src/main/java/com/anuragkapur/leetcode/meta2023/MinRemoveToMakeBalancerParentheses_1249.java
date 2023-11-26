package com.anuragkapur.leetcode.meta2023;

import java.util.*;

public class MinRemoveToMakeBalancerParentheses_1249 {

    /**
     * Runtime Complexity: O(n)
     * Space Complexity: O(n)
     * Leetcode Status: Accepted; Runtime: 11ms Beats 90.96% of users with Java
     */
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> balancerStack = new ArrayDeque<>();
        char[] chs = s.toCharArray();

        for (int i=0; i<chs.length; i++) {
            if (!isLowerAlpha(chs[i])) {
                if (chs[i] == '(') {
                    balancerStack.push(i);
                } else if (chs[i] == ')') {
                    if (balancerStack.isEmpty()) {
                        chs[i] = '!';
                    } else {
                        balancerStack.pop();
                    }
                }
            }
        }

        while (!balancerStack.isEmpty()) {
            Integer top = balancerStack.pop();
            chs[top] = '!';
        }

        StringBuilder builder = new StringBuilder();
        for (char ch : chs) {
            if (ch != '!') {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    /**
     * Runtime Complexity: O(n)
     * Space Complexity: O(n)
     * Leetcode Status: Accepted; Runtime: 19ms Beats 64.61% of users with Java
     */
    public String minRemoveToMakeValid1(String s) {
        Deque<CharIndexPair> balancerStack = new ArrayDeque<>();
        char[] chs = s.toCharArray();

        for (int i=0; i<chs.length; i++) {
            if (!isLowerAlpha(chs[i])) {
                if (chs[i] == '(') {
                    CharIndexPair ciPair = new CharIndexPair('(', i);
                    balancerStack.push(ciPair);
                } else if (chs[i] == ')') {
                    CharIndexPair newElem = new CharIndexPair(')', i);
                    if (balancerStack.isEmpty()) {
                        balancerStack.push(newElem);
                    } else {
                        CharIndexPair top = balancerStack.peek();
                        if (top.ch == '(') {
                            balancerStack.pop();
                        } else {
                            balancerStack.push(newElem);
                        }
                    }
                }
            }
        }

        Set<Integer> invalidIndices = new HashSet<>();
        while (!balancerStack.isEmpty()) {
            CharIndexPair top = balancerStack.pop();
            invalidIndices.add(top.index);
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<chs.length; i++) {
            if (!invalidIndices.contains(i)) {
                builder.append(chs[i]);
            }
        }
        return builder.toString();
    }

    private boolean isLowerAlpha(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    class CharIndexPair {
        char ch;
        int index;

        CharIndexPair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }
}
