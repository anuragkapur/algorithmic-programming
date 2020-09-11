package com.anuragkapur.ib.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    /**
     * RTC: O(n)
     */
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        if (A.size() < 2) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<A.size(); i++) {
            if (!map.containsKey(A.get(i))) {
                map.put(A.get(i), i);
            }
        }

        for (int i=0; i<A.size(); i++) {
            ArrayList<Integer> answer = new ArrayList<>();
            int num1 = A.get(i);
            int target = B - num1;
            if (map.containsKey(target)) {
                int lowerIndex = map.get(target);
                if (lowerIndex < i) {
                    answer.add(lowerIndex+1);
                    answer.add(i+1);
                    return answer;
                }
            }
        }

        return new ArrayList<>();
    }

    /**
     * Partially Correct Answer. Time Limit Exceeded.
     * RTC: O(n^2)
     */
    public ArrayList<Integer> twoSum1(final List<Integer> A, int B) {
        if (A.size() < 2) {
            return new ArrayList<>();
        }

        for (int i=1; i<A.size(); i++) {
            ArrayList<Integer> answer = new ArrayList<>();
            for (int j=i-1; j>=0; j--) {
                if (A.get(i) + A.get(j) == B) {
                    answer = new ArrayList<>();
                    answer.add(j+1);
                    answer.add(i+1);
                }
            }
            if (answer.size() == 2) {
                return answer;
            }
        }

        return new ArrayList<>();
    }
}
