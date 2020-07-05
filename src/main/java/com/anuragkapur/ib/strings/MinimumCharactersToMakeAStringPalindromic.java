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

        // remove longest palindrome suffix
        String newA = null;
        char[] chs = A.toCharArray();
        for (int i=chs.length; i>0; i--) {
            StringBuilder builder = new StringBuilder();
            builder.append(chs, 0, i);
            if (isPalindrome(builder)) {
                newA = A.substring(i);
                break;
            }
        }

        if (newA != null) {
            return newA.length();
        } else {
            return A.length() - 1;
        }
    }

    private boolean isPalindrome(StringBuilder builder) {
        int len = builder.length();
        int midLen = (len % 2 == 0) ? len / 2 - 1 : len / 2;
        for (int i=0; i<=midLen; i++) {
            char a = builder.charAt(i);
            char b = builder.charAt(len-1-i);
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
