package com.anuragkapur.leetcode.fb;

public class AddStrings_415 {

    /**
     * O(max(n1, n2))
     * where,
     *  n1 = length of string 1
     *  n2 = length of string 2
     */
    public String addStrings(String num1, String num2) {

        StringBuilder ansBuilder = new StringBuilder();

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int p1 = n1.length-1;
        int p2 = n2.length-1;

        int carry = 0;

        while (p1 >= 0 || p2 >= 0) {
            int d1 = 0;
            int d2 = 0;
            if (p1 >= 0) {
                d1 = n1[p1]-'0';
                p1 --;
            }
            if (p2 >= 0) {
                d2 = n2[p2]-'0';
                p2 --;
            }
            int sum = carry + d1 + d2;
            carry = sum / 10;
            int answerDigit = sum % 10;
            ansBuilder.append(answerDigit);
        }

        if (carry > 0) {
            ansBuilder.append(carry);
        }

        return ansBuilder.reverse().toString();
    }
}
