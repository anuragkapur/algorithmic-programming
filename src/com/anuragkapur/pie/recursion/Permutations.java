package com.anuragkapur.pie.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anuragkapur
 */
public class Permutations {

    public List<String> getPermutations(String str) {

        if (str == null) {
            return null;
        }

        List<String> permutations = new ArrayList<>();
        if (str.length() == 1) {

            permutations.add(str);
        } else {

            char chars[] = str.toCharArray();
            for (int i = 0; i <chars.length; i++) {

                String prefix = String.valueOf(chars[i]);
                StringBuilder remainder = new StringBuilder();
                for (int j = 0; j <chars.length; j++) {
                    if (j != i) {
                        remainder.append(chars[j]);
                    }
                }

                List<String> subPermutations = getPermutations(remainder.toString());
                for (String subPerm : subPermutations) {
                    permutations.add(prefix+subPerm);
                }
            }
        }


        return permutations;
    }
}
