package com.anuragkapur.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author anuragkapur
 */
public class BasicCalculator {

    public int calculate(String s) {

        if (s == null) {
            return 0;
        }

        s = "(" + s + ")";

        Deque<Character> stack = new LinkedList<>();
        Deque<Integer> queue = new LinkedList<>();

        char chars[] = s.toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            char ch = chars[i];
            switch (ch) {
                case ')':
                    // push char to stack
                    stack.push(ch);
                    break;
                case '(':
                    // keep popping operators from stack until a '(' is encountered
                    char element = stack.pop();
                    while (element != ')' && stack.size() > 0) {
                        int a = queue.removeLast();
                        int b = queue.removeLast();
                        if (element == '+') {
                            queue.addLast(a + b);
                        } else {
                            queue.addLast(a - b);
                        }
                        element = stack.pop();
                    }
                    break;
                case '+':
                    // push char to stack
                    stack.push(ch);
                    break;
                case '-':
                    // push char to stack
                    stack.push(ch);
                    break;
                case ' ':
                    // ignore white-spaces
                    break;
                default:
                    // number
                    // add to queue, with special handling of numbers > 9, which have more than 1 digits
                    int countDigits = 1;
                    for (int j = i - 1; j >= 0; j--) {
                        if (Character.isDigit(chars[j])) {
                            countDigits++;
                        } else {
                            break;
                        }
                    }
                    queue.addLast(Integer.parseInt(new String(chars, i-countDigits+1, countDigits)));
                    i -= (countDigits - 1);
            }
        }

        return queue.getFirst();
    }
}
