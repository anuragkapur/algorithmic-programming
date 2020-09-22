package com.anuragkapur.ib.trees;

import java.util.List;

public class SortedArrayToBalancedBST {
    public TreeNode sortedArrayToBST(List<Integer> A) {
        return toBST(A, 0, A.size() - 1);
    }

    private TreeNode toBST(List<Integer> A, int start, int end) {

        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(A.get(start));
        }

        int mid = (end - start) / 2 + start;
        TreeNode node = new TreeNode(A.get(mid));
        TreeNode leftRoot = toBST(A, start, mid - 1);
        TreeNode rightRoot = toBST(A, mid + 1, end);
        node.left = leftRoot;
        node.right = rightRoot;
        return node;
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
