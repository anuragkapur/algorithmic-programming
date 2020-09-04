package com.anuragkapur.ib.stacksnqueues;

import java.util.Stack;

public class EvaluateRPN {
    public int evalRPN(String[] A) {
        Stack<String> stack = new Stack<>();
        for (int i=A.length-1; i>=0; i--) {
            while (canReduce(stack)) {
                popAndComputeOnce(stack);
            }
            switch (A[i]) {
                case "+":
                case "-":
                case "*":
                case "/":
                    stack.push(A[i]);
                    break;
                default:
                    stack.push(A[i]);
            }
        }

        while (canReduce(stack)) {
            popAndComputeOnce(stack);
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean canReduce(Stack<String> stack) {
        if (stack.size() >= 3) {
            String x = stack.pop();
            String y = stack.pop();
            stack.push(y);
            stack.push(x);
            return isOperand(x) && isOperand(y);
        }

        return false;
    }

    private boolean isOperand(String x) {
        return !x.equals("+") &&
                !x.equals("-") &&
                !x.equals("*") &&
                !x.equals("/");
    }

    private void popAndComputeOnce(Stack<String> stack) {
        String x = stack.pop();
        String y = stack.pop();
        String operator = stack.pop();
        String result = compute(x, y, operator);
        stack.push(result);
    }

    private String compute(String x, String y, String operator) {
        int op1 = Integer.parseInt(x);
        int op2 = Integer.parseInt(y);
        int result = 0;
        switch (operator) {
            case "+": result = op1 + op2; break;
            case "-": result = op1 - op2; break;
            case "/": result = op1 / op2; break;
            case "*": result = op1 * op2; break;
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String[] A = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        EvaluateRPN evaluateRPN = new EvaluateRPN();
        evaluateRPN.evalRPN(A);
    }
}
