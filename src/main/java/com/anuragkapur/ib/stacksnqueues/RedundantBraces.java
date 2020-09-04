package com.anuragkapur.ib.stacksnqueues;

import java.util.Stack;

public class RedundantBraces {
    public int braces(String A) {
        char[] chars = A.toCharArray();
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while(i < chars.length) {
            char ch = chars[i];
            switch (ch) {
                case '(': stack.push(ch); break;
                case '+': stack.push(ch); break;
                case '-': stack.push(ch); break;
                case '/': stack.push(ch); break;
                case '*': stack.push(ch); break;
                case ')':
                    boolean redundant = true;
                    while (!stack.empty()) {
                        char top = stack.pop();
                        if (top == '+' || top == '-' || top == '/' || top == '*') {
                            redundant = false;
                        }
                        else if (top == '(') {
                            break;
                        }
                    }
                    if (redundant) {
                        return 1;
                    }
                    break;
                default: break;
            }
            i++;
        }

        return 0;
    }
}
