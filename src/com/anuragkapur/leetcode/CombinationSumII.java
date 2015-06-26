package com.anuragkapur.leetcode;

import java.util.*;

/**
 * @author anuragkapur
 */
public class CombinationSumII {

    Set<List<Integer>> combinations;

    /**
     * Running time: O(n^2)
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length < 1) {
            return null;
        }

        Arrays.sort(candidates);

        combinations = new HashSet<>();
        compute(candidates, 0, target, new ArrayList<>());

        List<List<Integer>> resultList = new ArrayList<>();
        resultList.addAll(combinations);
        return resultList;
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
            compute(candidates, i+1, target-candidates[i], combinationCopy);
        }
    }
}
