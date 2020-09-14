package com.anuragkapur.ib.trees;

import java.util.ArrayList;

public class InOrderWithRecursion {
    ArrayList<Integer> answer = new ArrayList<>();

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if (A == null) {
            return answer;
        }

        inorderTraversal(A.left);
        answer.add(A.val);
        inorderTraversal(A.right);

        return answer;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
}
