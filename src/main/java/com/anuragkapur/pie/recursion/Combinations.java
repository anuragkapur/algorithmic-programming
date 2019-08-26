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
        combinationsComputer.combine(0);
        return combinationsComputer.getCombinations();
    }

    private class CombinationsComputer {

        private String input;
        private StringBuilder combination;
        private List<String> combinations;

        public CombinationsComputer(String str) {
            this.combination = new StringBuilder();
            this.input = str;
            this.combinations = new ArrayList<>();
            combinations.add("");
        }

        public void combine(int start) {

            for (int i=start; i<input.length(); i++) {
                combination.append(input.charAt(i));
                combinations.add(combination.toString());
                combine(i+1);
                combination.setLength(combination.length()-1);
            }
        }

        public List<String> getCombinations() {
            return this.combinations;
        }
    }
}
