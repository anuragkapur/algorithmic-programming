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

        Deque<Character> operators = new LinkedList<>();
        Deque<Integer> operands = new LinkedList<>();

        char chars[] = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            switch (ch) {
                case '(': {
                    operators.push(ch);
                    break;
                }
                case ')': {
                    char top = operators.pop();
                    while (top != '(' && operators.size() > 0) {
                        int a = operands.pop();
                        int b = operands.pop();
                        if (top == '+') {
                            operands.push(a+b);
                        } else {
                            operands.push(b-a);
                        }
                        top = operators.pop();
                    }
                    break;
                }
                case '+': {
                    char top = operators.peek();
                    while (top != '(' && operators.size() > 0 && operands.size() > 1) {
                        operands.push(eval(operands.pop(), operands.pop(), top));
                        operators.pop();
                        top = operators.peek();
                    }
                    operators.push(ch);
                    break;
                }
                case '-': {
                    char top = operators.peek();
                    while (top != '(' && operators.size() > 0 && operands.size() > 1) {
                        operands.push(eval(operands.pop(), operands.pop(), top));
                        operators.pop();
                        top = operators.peek();
                    }
                    operators.push(ch);
                    break;
                }
                case ' ':
                    // ignore white-spaces
                    break;
                default:
                    // number
                    // add to queue, with special handling of numbers > 9, which have more than 1 digits
                    int countDigits = 1;
                    for (int j = i+1; j < chars.length; j++) {
                        if (Character.isDigit(chars[j])) {
                            countDigits++;
                        } else {
                            break;
                        }
                    }
                    operands.push(Integer.parseInt(new String(chars, i, countDigits)));
                    i += (countDigits - 1);
            }
        }

        return operands.getFirst();
    }

    private int eval(int a, int b, char operator) {

        if (operator == '+') {
            return(b+a);
        } else {
            return(b-a);
        }
    }
}
