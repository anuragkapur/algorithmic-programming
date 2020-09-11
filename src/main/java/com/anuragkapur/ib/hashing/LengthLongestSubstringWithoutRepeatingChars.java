package com.anuragkapur.ib.hashing;

import java.util.HashSet;
import java.util.Set;

public class LengthLongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String A) {
        char[] chs = A.toCharArray();
        int max = 0;
        for (int i=0; i<chs.length; i++) {
            Set<Character> dupChecker = new HashSet<>();
            dupChecker.add(chs[i]);
            int length = 1;
            for (int j=i+1; j<chs.length; j++) {
                if(dupChecker.add(chs[j])) {
                    length ++;
                } else {
                    break;
                }
            }
            if (length > max) {
                max = length;
            }
        }
        return max;
    }
}
