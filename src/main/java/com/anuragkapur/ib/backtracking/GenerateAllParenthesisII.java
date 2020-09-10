package com.anuragkapur.ib.backtracking;

import java.util.*;

public class GenerateAllParenthesisII {
    List<String> all = new ArrayList<>();
    ArrayList<String> solution = new ArrayList<>();

    /**
     * Solution 2
     * RTC: O(4^n)
     */
    public ArrayList<String> generateParenthesis(int A) {
        generateAllBalanced("", 0, 0, A);
        return solution;
    }

    /**
     * RTC:
     * T(2n) = 2 * T(2n-1)
     * = O(2^2n)
     * = O(4^n)
     */
    private void generateAllBalanced(String combination, int lefts, int rights, int n) {
        if (lefts == n && rights == n) {
            solution.add(combination);
        }
        if (lefts < n) {
            generateAllBalanced(combination+'(', lefts+1, rights, n);
        }
        if (rights < lefts) {
            generateAllBalanced(combination+')', lefts, rights+1, n);
        }
    }

    /**
     * Solution 1
     * RTC: O(4^n) + O(4^n*2n)
     * = O(n*4^n)
     */
    public ArrayList<String> generateParenthesis1(int A) {
        generateAll(0, 2*A, "");
        ArrayList<String> solution = new ArrayList<>();
        for (String str : all) {
            if (isBalanced(str)) {
                solution.add(str);
            }
        }
        Collections.sort(solution);
        return solution;
    }

    /**
     * RTC:
     * T(2n) = 2 * T(2n-1)
     * = O(2^2n)
     * = O(4^n)
     */
    private void generateAll(int length, int max, String combination) {
        if (length == max) {
            all.add(combination);
        } else {
            generateAll(length+1, max, combination+'(');
            generateAll(length+1, max, combination+')');
        }
    }

    /**
     * RTC: O(n)
     */
    private boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chs = str.toCharArray();
        for (int i=0; i<chs.length; i++) {
            switch(chs[i]) {
                case '(': stack.push(chs[i]); break;
                case ')': try {
                    stack.pop();
                    break;
                } catch(EmptyStackException e) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
