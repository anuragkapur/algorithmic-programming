package com.anuragkapur.ib.strings;

import java.util.HashSet;
import java.util.Set;

public class AmazingSubarrays {

    /**
     * RTC: O(n)
     * Doesn't exclude duplicates, example for input string: ABA, returns 4 ([A, AB, ABA, A])
     *
     * @param A
     * @return
     */
    public int solve(String A) {
        int count = 0;
        for (int i=0; i<A.length(); i++) {
            char ch = Character.toLowerCase(A.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count += (A.length() - i);
            }
        }
        return count % 10003;
    }

    /**
     * Ignore duplicate subarrays
     *
     * @param A
     * @return
     */
    public int solve1(String A) {

        Set<String> amazing = new HashSet<String>();
        for (int i=0; i<A.length(); i++) {
            char ch = Character.toLowerCase(A.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                for (int j=i+1; j<=A.length(); j++) {
                    amazing.add(A.substring(i, j));
                }
            }
        }
        return amazing.size() % 10003;
    }
}
