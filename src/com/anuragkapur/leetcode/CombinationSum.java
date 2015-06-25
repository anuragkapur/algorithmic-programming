package com.anuragkapur.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anuragkapur
 */
public class CombinationSum {

    List<List<Integer>> combinations;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length < 1) {
            return null;
        }

        Arrays.sort(candidates);

        combinations = new ArrayList<>();
        compute(candidates, 0, target, new ArrayList<>());
        return combinations;
    }

    private void compute(int[] candidates, int startIndex, int target, List<Integer> combination) {

        if(target == 0) {
            // recursion base case
            combinations.add(combination);
        }

        if(target < 0) {
            // recursion base case
            return;
        }

        for(int i=startIndex; i<candidates.length; i++) {
            List<Integer> combinationCopy = new ArrayList<>();
            combinationCopy.addAll(combination);
            combinationCopy.add(candidates[i]);
            compute(candidates, i, target-candidates[i], combinationCopy);
        }
    }
}
