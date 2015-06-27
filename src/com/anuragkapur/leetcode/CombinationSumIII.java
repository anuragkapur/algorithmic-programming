package com.anuragkapur.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anuragkapur
 */
public class CombinationSumIII {

    private List<List<Integer>> combinations;

    /**
     * Running time: O(k)
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k <= 0 || n <= 0) {
            return null;
        }

        combinations = new ArrayList<>();
        computeCombination(k, n, new ArrayList<>());
        return combinations;
    }

    private void computeCombination(int k, int n, List<Integer> combinationInTheMaking) {
        // recursion base case 1
        if(k == 0) {
            if(n == 0) {
                combinations.add(combinationInTheMaking);
            } else {
                return;
            }
        }

        // recursion base case 1
        if(n == 0) {
            return;
        }

        // recusrsive case
        int largestSoFar = 0;
        if(combinationInTheMaking.size() > 0) {
            largestSoFar = combinationInTheMaking.get(combinationInTheMaking.size()-1);
        }
        for(int i=largestSoFar+1; i<10; i++) {
            List<Integer> combinationInTheMakingCopy = new ArrayList<>();
            combinationInTheMakingCopy.addAll(combinationInTheMaking);
            combinationInTheMakingCopy.add(i);
            computeCombination(k-1, n-i, combinationInTheMakingCopy);
        }

    }
}
