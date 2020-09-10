package com.anuragkapur.ib.backtracking;

import java.util.ArrayList;

public class Permutations {

    /**
     * RTC:
     * T(n) = n * T(n-1)
     * = n * (n-1) * T(n-2)
     * = O(n!)
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        return compute(A);
    }

    private ArrayList<ArrayList<Integer>> compute(ArrayList<Integer> nums) {

        if (nums.size() <= 1) {
            ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
            permutations.add(nums);
            return permutations;
        }

        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
        for (Integer num : nums) {
            ArrayList<Integer> subList = new ArrayList<>(nums);
            subList.remove(num);
            ArrayList<ArrayList<Integer>> subPermutations = compute(subList);
            for (ArrayList<Integer> subPermutation : subPermutations) {
                ArrayList<Integer> permutation = new ArrayList<>();
                permutation.add(num);
                permutation.addAll(subPermutation);
                permutations.add(permutation);
            }
        }
        return permutations;
    }
}
