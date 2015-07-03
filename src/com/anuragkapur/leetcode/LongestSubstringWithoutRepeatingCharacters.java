package com.anuragkapur.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author anuragkapur
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> uniqueChars = null;
        int longestLength = 0;
        char chars[] = s.toCharArray();
        int lengthOfCurrentCandidateString = 0;
        for(int i=0; i<chars.length; i++) {
            uniqueChars = new HashSet<>();
            uniqueChars.add(chars[i]);
            lengthOfCurrentCandidateString = 1;
            for(int j=i+1; j<chars.length; j++) {
                if(uniqueChars.add(chars[j])) {
                    lengthOfCurrentCandidateString ++;
                } else {
                    break;
                }
            }
            if(lengthOfCurrentCandidateString > longestLength) {
                longestLength = lengthOfCurrentCandidateString;
            }
        }

        return longestLength;
    }
}
