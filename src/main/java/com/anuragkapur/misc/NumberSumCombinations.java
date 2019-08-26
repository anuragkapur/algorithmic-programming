package com.anuragkapur.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a number, print all ways of getting the number as a sum of other numbers.
 * Example, for n=5
 * 1 + 1 + 1 + 1 + 1
 * 1 + 4
 * 2 + 3
 * 1 + 1 + 1 + 2
 * 1 + 1 + 3
 * 5
 * ...etc
 *
 * @author: anuragkapur
 * @since: 26/05/2014
 */

public class NumberSumCombinations {

    /**
     * Currently prints some duplicate combinations as well. Example: 1, 2 and 2, 1
     *
     * @param n
     * @return
     */
    public static List<String> compute(int n) {

        List<String> combinations = new ArrayList<>();

        if(n < 0) {
            System.out.println("number should not be < 0");
        } else if(n == 0) {
            // do nothin
        } else if(n == 1) {
            combinations.add(String.valueOf(1));
        } else {
            for(int i=1; i<=n; i++) {
                List<String> subCombos = compute(n-i);
                for(String subCombo : subCombos) {
                    combinations.add(String.valueOf(i) + ", " + subCombo);
                }
            }
            combinations.add(String.valueOf(n));
        }

        return combinations;
    }

    public static void main(String[] args) {
        List<String> combinations = compute(4);
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
