package com.anuragkapur.leetcode.meta2023;

import java.util.HashMap;
import java.util.Map;

public class DotProduct2SparseVectors_1570 {

    private Map<Integer, Integer> vectorIndexValueMap;

    public DotProduct2SparseVectors_1570(int[] nums) {
        vectorIndexValueMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                vectorIndexValueMap.put(i, nums[i]);
            }
        }
    }

    /**
     * Runtime Complexity: O(n), where n = number of non-zero keys in vec
     * Leetcode Status: Accepted; Runtime 9ms; Beats 52.20% of users with Java
     */
    public int dotProduct(DotProduct2SparseVectors_1570 vec) {
        int answer = 0;
        for (int key : vec.vectorIndexValueMap.keySet()) {
            if (this.vectorIndexValueMap.containsKey(key)) {
                int x = this.vectorIndexValueMap.get(key);
                int y = vec.vectorIndexValueMap.get(key);
                answer += x*y;
            }
        }
        return answer;
    }
}
