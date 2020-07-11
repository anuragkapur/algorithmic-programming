package com.anuragkapur.ib.strings;

public class MinimumCharactersToMakeAStringPalindromic {

    /**
     * Partially Correct Answer. Expected RTC Limit Exceeded.
     * RTC: O(n^2)
     *
     * @param A
     * @return
     */
    public int solve(String A) {

        if (A.length() <= 1) {
            return 0;
        }

        int pointer = A.length();
        while (pointer > 0) {
            if (isPalindrome(A.substring(0, pointer))) {
                return A.length() - pointer;
            } else {
                pointer --;
            }
        }

        return -1;
    }

    private boolean isPalindrome(String str) {
        int len = str.length();
        int midLen = (len % 2 == 0) ? len / 2 - 1 : len / 2;
        for (int i=0; i<=midLen; i++) {
            char a = str.charAt(i);
            char b = str.charAt(len-1-i);
            if (a != b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumCharactersToMakeAStringPalindromic m = new MinimumCharactersToMakeAStringPalindromic();
        System.out.println(m.solve("aaaaa"));
    }
}
