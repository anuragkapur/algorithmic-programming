package com.anuragkapur.ctci.recursionanddp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: anuragkapur
 * @since: 15/06/14
 */

public class Prob9_4_AllSubsets {

    /**
     * Run time complexity: O(2^n)
     * T(n) = T(n-1) + 2^(n-1)
     *
     * @param set
     * @return
     */
    public List<List<Integer>> computeSubsets(List<Integer> set) {

        if(set == null) {
            return null;
        } else if(set.size() == 0) {
            List<List<Integer>> subsets = new ArrayList<>();
            return subsets;
        } else if(set.size() == 1) {
            List<List<Integer>> subsets = new ArrayList<>();
            List<Integer> subset = new ArrayList<>();
            subset.add(set.get(0));
            subsets.add(subset);
            subsets.add(new ArrayList<Integer>());
            return subsets;
        } else {
            int ejected = set.remove(0);
            List<List<Integer>> subsets1 = computeSubsets(set);
            List<List<Integer>> subsets2 = new ArrayList<>();
            for(List<Integer> subset1 : subsets1) {
                List<Integer> subset2 = new ArrayList<>();
                subset2.addAll(subset1);
                subset2.add(ejected);
                subsets2.add(subset2);
            }
            subsets1.addAll(subsets2);
            return subsets1;
        }
    }

    public List<List<Integer>> subsets(int a[], int start, int end) {

        List<List<Integer>> subsets = new ArrayList<>();

        if(end == start) {
            List<Integer> subset = new ArrayList<>();
            subset.add(a[start]);
            subsets.add(subset);
            subsets.add(new ArrayList<Integer>());
        } else {
            int num = a[start];
            List<List<Integer>> subSubsets = subsets(a, start+1, end);
            subsets.addAll(subSubsets);
            for(List<Integer> subSubset : subSubsets) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(subSubset);
                temp.add(num);
                subsets.add(temp);
            }
        }

        return subsets;
    }
}
