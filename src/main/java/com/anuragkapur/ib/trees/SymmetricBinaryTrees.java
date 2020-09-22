package com.anuragkapur.ib.trees;

public class SymmetricBinaryTrees {
    public int isSymmetric(TreeNode A) {
        return areSymmetric(A.left, A.right);
    }

    private int areSymmetric(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return 1;
        }


        if (node1 == null || node2 == null) {
            return 0;
        }

        if (node1.val != node2.val) {
            return 0;
        }

        int lr = areSymmetric(node1.left, node2.right);
        int rl = areSymmetric(node1.right, node2.left);

        if (lr + rl < 2) {
            return 0;
        } else {
            return 1;
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
