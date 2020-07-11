package com.anuragkapur.ib.strings;

public class AddBinaryStrings {

    public String addBinary(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        char carry = '0';
        StringBuilder answer = new StringBuilder();

        int ap = a.length-1;
        int bp = b.length-1;

        while (ap >= 0 || bp >= 0) {
            char x = '0'; char y = '0';
            if (ap >= 0) {
                x = a[ap];
                ap --;
            }
            if (bp >= 0) {
                y = b[bp];
                bp --;
            }
            char[] bitSum = addThreeBits(x, y, carry);
            carry = bitSum[1];
            answer.append(bitSum[0]);
        }

        if (carry == '1') {
            answer.append(carry);
        }

        return answer.reverse().toString();
    }

    private char[] addThreeBits(char a, char b, char c) {
        char[] answer = new char[2];
        int countOf1s = getCountOf1s(a, b, c);
        if (countOf1s == 0) {
            answer[0] = '0';
            answer[1] = '0';
        } else if (countOf1s == 1) {
            answer[0] = '1';
            answer[1] = '0';
        } else if (countOf1s == 2) {
            answer[0] = '0';
            answer[1] = '1';
        } else {
            answer[0] = '1';
            answer[1] = '1';
        }
        return answer;
    }

    private int getCountOf1s(char a, char b, char c) {
        int count = 0;
        if (a == '1') {
            count ++;
        }
        if (b == '1') {
            count ++;
        }
        if (c == '1') {
            count ++;
        }
        return count;
    }
}
