package com.anuragkapur.ib.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctSubsequences {

    Map<Character, List<Integer>> occurrences = new HashMap<>();

    /**
     * Partially Correct Answer. Time Limit Exceeded.
     * RTC: O(m*n) with memoization, although the solution below is not memoized.
     * Calculating RTC without memoization seems rather tricky!
     */
    public int numDistinct(String A, String B) {
        populateOccurrencesMap(A);
        return numDistinct(B, 0);
    }

    private int numDistinct(String b, int minIndex) {

        if (b.length() == 0) {
            return 1;
        }

        List<Integer> indexList = occurrences.get(b.charAt(0));
        int distinctCount = 0;
        if (indexList != null) {
            for (Integer index : indexList) {
                if (index >= minIndex) {
                    distinctCount += numDistinct(b.substring(1), index+1);
                    if (distinctCount == 0) {
                        break;
                    }
                }
            }
        }

        return distinctCount;
    }

    /**
     * RTC: O(n)
     */
    private void populateOccurrencesMap(String a) {
        char[] chs = a.toCharArray();
        for (int i=0; i<chs.length; i++) {
            if (occurrences.containsKey(chs[i])) {
                occurrences.get(chs[i]).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                occurrences.put(chs[i], indexList);
            }
        }
    }
}
