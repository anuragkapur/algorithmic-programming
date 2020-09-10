package com.anuragkapur.ib.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum {
    ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
    ArrayList<Integer> numbers;

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        // remove duplicates
        numbers = new ArrayList<>(new HashSet<>(A));

        // sort
        Collections.sort(numbers);

        compute(new ArrayList<>(), B, 0);
        return solution;
    }

    private void compute(ArrayList<Integer> candidate, int B, int startIndex) {

        if (B == 0 && candidate.size() > 0) {
            solution.add(candidate);
        } else if (B < 0) {
            // do nothing
        } else {
            for (int i=startIndex; i<numbers.size(); i++) {
                Integer num = numbers.get(i);
                ArrayList<Integer> newCandidate = new ArrayList<>(candidate);
                newCandidate.add(num);
                compute(newCandidate, B-num, i);
            }
        }
    }
}
