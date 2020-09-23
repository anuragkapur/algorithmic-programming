package com.anuragkapur.ib.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeastCommonAncestor {
    public int lca(TreeNode A, int B, int C) {

        List<Integer> leftPath = dfs(A, new ArrayList<Integer>(), B);
        List<Integer> rightPath = dfs(A, new ArrayList<Integer>(), C);

        if (leftPath == null || rightPath == null) {
            return -1;
        }

        Set<Integer> commonChecker = new HashSet<>();
        commonChecker.addAll(leftPath);
        for (int i=rightPath.size()-1; i>=0; i--) {
            if (!commonChecker.add(rightPath.get(i))) {
                return rightPath.get(i);
            }
        }

        return -1;
    }

    private List<Integer> dfs(TreeNode A, List<Integer> path, int val) {

        path.add(A.val);

        if (A.val == val) {
            return path;
        }

        List<Integer> finalPath = null;

        if (A.left != null) {
            List<Integer> leftPath = new ArrayList<>(path);
            finalPath = dfs(A.left, leftPath, val);
            if (finalPath != null) {
                return finalPath;
            }
        }

        if (A.right != null) {
            List<Integer> rightPath = new ArrayList<>(path);
            finalPath = dfs(A.right, rightPath, val);
            if (finalPath != null) {
                return finalPath;
            }
        }

        return null;
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
