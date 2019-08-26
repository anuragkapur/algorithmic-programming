package com.anuragkapur.pie.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anuragkapur
 */
public class Permutations {

    public List<String> getPermutations(String str) {

        PermutationsComputer permutationsComputer = new PermutationsComputer(str);
        permutationsComputer.permute();
        return permutationsComputer.getPermutations();
    }

    private class PermutationsComputer {

        String input;
        boolean used[];
        StringBuilder permutation;
        List<String> permutations;

        public PermutationsComputer(String str) {
            if (str != null) {
                input = str;
                used = new boolean[str.length()];
                permutation = new StringBuilder();
                permutations = new ArrayList<>();
            }
        }

        public void permute() {

            if (input == null) {
                return;
            }

            if (permutation.length() == input.length()) {
                permutations.add(permutation.toString());
            } else {
                for (int i = 0; i < input.length(); i++) {
                    if (!used[i]) {
                        permutation.append(input.charAt(i));
                        used[i] = true;
                        permute();
                        used[i] = false;
                        permutation.setLength(permutation.length()-1);
                    }
                }
            }
        }

        public List<String> getPermutations() {
            return permutations;
        }
    }
}
