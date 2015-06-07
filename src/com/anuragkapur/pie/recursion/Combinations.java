package com.anuragkapur.pie.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anuragkapur
 */
public class Combinations {

    public List<String> combine(String str) {
        if (str == null) {
            return null;
        }

        CombinationsComputer combinationsComputer = new CombinationsComputer(str);
        return combinationsComputer.combinations(0, str.length()-1);
    }

    private class CombinationsComputer {

        private String input;

        public CombinationsComputer(String str) {
            this.input = str;
        }

        public List<String> combinations(int start, int end) {

            if (end < start) {
                List<String> combinations = new ArrayList<>(1);
                combinations.add("");
                return combinations;
            } else if (start == end) {
                List<String> combinations = new ArrayList<>(2);
                combinations.add("");
                combinations.add(String.valueOf(input.charAt(start)));
                return combinations;
            } else {
                List<String> combinationsSoFar = combinations(start + 1, end);
                List<String> combinations = new ArrayList<>();
                String prefix = String.valueOf(input.charAt(start));
                for (String combination : combinationsSoFar) {
                    combinations.add(prefix + combination);
                }
                combinations.addAll(combinationsSoFar);
                return combinations;
            }
        }
    }
}
