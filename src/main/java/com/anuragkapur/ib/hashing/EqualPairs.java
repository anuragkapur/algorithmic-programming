package com.anuragkapur.ib.hashing;

import java.util.*;

public class EqualPairs {

    /**
     * RTC: O(n^2)
     */
    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        // populate look-up map of pair sums
        Map<Integer, ArrayList<Integer>> map1 = new HashMap<>();
        Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
        for (int i=0; i<A.size(); i++) {
            for (int j=i+1; j<A.size(); j++) {
                int sum = A.get(i) + A.get(j);
                if (!map1.containsKey(sum)) {
                    ArrayList<Integer> indices = new ArrayList<>();
                    indices.add(i);
                    indices.add(j);
                    map1.put(sum, indices);
                } else if (!map2.containsKey(sum)) {
                    int ind1 = map1.get(sum).get(0);
                    int ind2 = map1.get(sum).get(1);
                    int ind3 = i;
                    int ind4 = j;
                    if (areAllIndicesUnique(ind1, ind2, ind3, ind4)) {
                        ArrayList<Integer> indices = new ArrayList<>();
                        indices.add(i);
                        indices.add(j);
                        map2.put(sum, indices);
                    }
                }
            }
        }

        for (int i=0; i<A.size(); i++) {
            for (int j=i+1; j<A.size(); j++) {
                int sum = A.get(i) + A.get(j);
                if (map2.containsKey(sum)) {
                    ArrayList<Integer> indices = new ArrayList<>();
                    indices.add(i);
                    indices.add(j);
                    indices.addAll(map2.get(sum));
                    return indices;
                }
            }
        }

        return new ArrayList<>();
    }

    private boolean areAllIndicesUnique(int ind1, int ind2, int ind3, int ind4) {
        Set<Integer> dupChecker = new HashSet<>();
        dupChecker.add(ind1);
        dupChecker.add(ind2);
        dupChecker.add(ind3);
        dupChecker.add(ind4);
        return dupChecker.size() == 4;
    }
}
