package com.anuragkapur.ctci.arraysandstrings;

/**
 * @author: anuragkapur
 * @since: 07/05/2014
 */

public class Prob1_5_CompressString {


    /**
     * Run time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param str
     * @return
     */
    public static String compressedString(String str) {

        if(str.length() == 0) {
            return str;
        }

        char ch[] = str.toCharArray();
        char current = ch[0];
        int count = 1;
        StringBuffer solution = new StringBuffer();

        for (int i=1; i<ch.length; i++) {
            if(ch[i] == current) {
                count ++;
            } else {
                solution.append(String.valueOf(current));
                solution.append(String.valueOf(count));
                current = ch[i];
                count = 1;

            }
        }

        solution.append(String.valueOf(current));
        solution.append(String.valueOf(count));

        String candidateSolution = solution.toString();
        if(candidateSolution.length() < str.length()) {
            return candidateSolution;
        } else {
            return str;
        }
    }
}
