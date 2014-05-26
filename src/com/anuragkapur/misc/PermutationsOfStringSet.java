package com.anuragkapur.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: anuragkapur
 * @since: 11/05/2014
 */

public class PermutationsOfStringSet {

    public static List<String> permutations(String stringSets[]) {

        if(stringSets.length == 0) {

            return null;
        } else if(stringSets.length == 1) {

            List<String> permutations = new ArrayList<>(1);
            permutations.add(stringSets[0]);
            return permutations;
        } else {

            List<String> permutations = new ArrayList<>();
            for (int i=0; i<stringSets.length; i++) {

                String base = stringSets[i];

                // create stringSubSets by removing base string
                String stringSubSets[] = new String[stringSets.length-1];
                int indexInSubsSets = 0;
                for (int j=0; j<stringSets.length; j++) {
                    if(i!=j) {
                        stringSubSets[indexInSubsSets] = stringSets[j];
                        indexInSubsSets ++;
                    }
                }

                List<String> subSetsPermutations = permutations(stringSubSets);
                for (String subSetsPermutation : subSetsPermutations) {
                    permutations.add(base + " " + subSetsPermutation);
                }
            }
            return permutations;
        }
    }

    public static void main(String[] args) {

        String question = "a b c";
        List<String> permutations = permutations(question.split(" "));
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
