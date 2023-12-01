package com.anuragkapur.leetcode.meta2023;

import java.util.ArrayList;
import java.util.List;

public class BuildingsWithOceanView_1762 {

    /**
     * Runtime Complexity: O(n)
     * Leetcode Status: Accepted; 2ms; Beats 99.44% of users with Java
     */
    public int[] findBuildings(int[] heights) {
        List<Integer> answerList = new ArrayList<>();
        int currentMaxHeight = 0;
        for (int i=heights.length-1; i>=0; i--) {
            if (heights[i] > currentMaxHeight) {
                answerList.add(i);
                currentMaxHeight = heights[i];
            }
        }

        int[] answer = new int[answerList.size()];
        int j = answerList.size() - 1;
        for (int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(j--);
        }

        return answer;
    }
}
