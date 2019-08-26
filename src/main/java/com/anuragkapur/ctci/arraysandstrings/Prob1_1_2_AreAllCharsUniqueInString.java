package com.anuragkapur.ctci.arraysandstrings;

/**
 * @author anuragkapur
 */
public class Prob1_1_2_AreAllCharsUniqueInString {

    /**
     * Variation of Prob1_1_2_AreAllCharsUniqueInString approach. Uses a fixed size boolean array to track the occurance
     * of chars in the string. Assumes ASCII string and hence the size of the tracker array is 256.
     *
     * Run time complexity: O(n)
     * Space complexity: O(1) as irrespective of thr input string, a fixed size (256) boolean array is used
     *
     * @param str
     * @return
     */
    public static boolean allCharsUnique(String str) {

        char charsInString[] = str.toCharArray();
        boolean tracker[] = new boolean[256];

        System.out.println("Test >> " + tracker[0]);

        for (char ch : charsInString) {
            if (tracker[ch]) {
                return false;
            } else {
                tracker[ch] = true;
            }
        }

        return true;
    }
}
