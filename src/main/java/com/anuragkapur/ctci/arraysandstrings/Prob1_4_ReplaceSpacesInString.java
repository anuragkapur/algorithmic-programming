package com.anuragkapur.ctci.arraysandstrings;

/**
 * @author anuragkapur
 */
public class Prob1_4_ReplaceSpacesInString {

    /**
     * Replaces spaces in a string with %20. Assumes the input string has exactly enough trailing spaces to accommodate
     * new chars introduced when a ' ' is replaced by '%20'. If this assumption is not valid, fairly trivial additional
     * logic can be added.
     *
     * Run time complexity: O(n)
     * Space complexity: O(1) no new data structure used.
     *
     * @param str
     * @return
     */
    public static String replaceSpaces(String str) {

        char ch[] = str.toCharArray();
        boolean trailingSpace = true;
        int tracker = ch.length - 1;

        for (int i=ch.length-1; i>=0; i--) {
            if(ch[i] == ' ') {
                if(!trailingSpace) {
                    ch[tracker --] = '0';
                    ch[tracker --] = '2';
                    ch[tracker --] = '%';
                }
            } else {
                trailingSpace = false;
                ch[tracker --] = ch[i];
            }
        }

        return new String(ch);
    }
}
