package com.anuragkapur.ib.graphs;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public int[][] levelOrder(TreeNode A) {

        List<List<Integer>> answer = parse(A, new ArrayList<>(), 0);
        int[][] a = new int[answer.size()][];
        for (int i = 0; i < answer.size(); i++) {
            a[i] = new int[answer.get(i).size()];
            for (int j = 0; j < answer.get(i).size(); j++) {
                a[i][j] = answer.get(i).get(j);
            }
        }
        return a;
    }

    private List<List<Integer>> parse(TreeNode a, List<List<Integer>> answer, int level) {
        if (a == null) {
            return answer;
        }

        if (answer.size() == level) {
            answer.add(new ArrayList<>());
        }

        List<Integer> levelList = answer.get(level);
        if (levelList == null) {
            levelList = new ArrayList<>();
            answer.add(levelList);
        }
        levelList.add(a.val);
        parse(a.left, answer, level + 1);
        parse(a.right, answer, level + 1);
        return answer;
    }
}
