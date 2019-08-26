package com.anuragkapur.leetcode;

/**
 * @author anuragkapur
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if (s == null || s.length() < 1 || s.length() < numRows) {
            return s;
        }

        if (numRows <= 1) {
            return s;
        }

        char chars[][] = new char[numRows][s.length()];
        char sChars[] = s.toCharArray();
        int rowIndices[] = new int[numRows];
        int currentRow = 0;
        boolean forward = true;

        for (char ch : sChars) {
            chars[currentRow][rowIndices[currentRow]] = ch;
            rowIndices[currentRow]++;

            if (currentRow == numRows - 1) {
                forward = false;
            }

            if (currentRow == 0) {
                forward = true;
            }

            if (forward) {
                currentRow ++;
            } else {
                currentRow --;
            }
        }

        StringBuilder zigzag = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = 0;
            while (chars[i][j] != '\0') {
                zigzag.append(chars[i][j]);
                j++;
            }
        }

        return zigzag.toString();
    }
}
