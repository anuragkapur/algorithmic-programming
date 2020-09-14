package com.anuragkapur.ib.trees;

import java.util.ArrayList;

public class PathToGivenNode {

    /**
     * RTC: O(N), where N = number of nodes in tree
     */
    public ArrayList<Integer> solve(TreeNode A, int B) {
        return dfs(new ArrayList<>(), A, B);
    }

    private ArrayList<Integer> dfs(ArrayList<Integer> path, TreeNode node, int B) {
        if (node == null) {
            return null;
        }

        path.add(node.val);

        if (node.val == B) {
            return path;
        } else {
            ArrayList<Integer> newPath = dfs(new ArrayList<>(path), node.left, B);
            if (newPath == null) {
                newPath = dfs(new ArrayList<>(path), node.right, B);
            }
            return newPath;
        }
    }

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
}
