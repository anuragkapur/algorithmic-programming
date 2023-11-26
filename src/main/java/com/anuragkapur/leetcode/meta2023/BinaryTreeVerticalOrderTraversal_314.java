package com.anuragkapur.leetcode.meta2023;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal_314 {

    /**
     * Runtime Complexity: O(n), where n = number of nodes in the tree
     * Space Complexity: O(n), where n = number of nodes in the tree
     * Leetcode Status: Accepted; Runtime: 2ms, Beats 97.16% of users with Java
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {

        Map<Integer, List<Integer>> indexNodeValMap = new HashMap<>();

        Queue<TreeNodeColumnIndex> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new TreeNodeColumnIndex(root, 0));
        }

        int minIndex = 0;
        int maxIndex = 0;

        while (!queue.isEmpty()) {
            TreeNodeColumnIndex head = queue.poll();

            if (head.columnIndex > maxIndex) {
                maxIndex = head.columnIndex;
            }

            if (head.columnIndex < minIndex) {
                minIndex = head.columnIndex;
            }

            if (indexNodeValMap.containsKey(head.columnIndex)) {
                indexNodeValMap.get(head.columnIndex).add(head.node.val);
            } else {
                List<Integer> vals = new ArrayList<>();
                vals.add(head.node.val);
                indexNodeValMap.put(head.columnIndex, vals);
            }

            if (head.node.left != null) {
                queue.add(new TreeNodeColumnIndex(head.node.left, head.columnIndex-1));
            }
            if (head.node.right != null) {
                queue.add(new TreeNodeColumnIndex(head.node.right, head.columnIndex+1));
            }
        }

        List<List<Integer>> verticalOrderAnswer = new ArrayList<>();

        for (int i=minIndex; i<=maxIndex; i++) {
            if (indexNodeValMap.containsKey(i)) {
                verticalOrderAnswer.add(indexNodeValMap.get(i));
            }
        }

        return verticalOrderAnswer;
    }

    /**
     * Runtime Complexity: O(nlogn), where n = number of nodes in the tree
     * Space Complexity: O(n), where n = number of nodes in the tree
     * Leetcode Status: Accepted; Runtime: 3ms, Beats 48.53% of users with Java
     */
    public List<List<Integer>> verticalOrder1(TreeNode root) {

        Map<Integer, List<Integer>> indexNodeValMap = new HashMap<>();

        Queue<TreeNodeColumnIndex> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new TreeNodeColumnIndex(root, 0));
        }

        // O(n)
        while (!queue.isEmpty()) {
            TreeNodeColumnIndex head = queue.poll();
            if (indexNodeValMap.containsKey(head.columnIndex)) {
                indexNodeValMap.get(head.columnIndex).add(head.node.val);
            } else {
                List<Integer> vals = new ArrayList<>();
                vals.add(head.node.val);
                indexNodeValMap.put(head.columnIndex, vals);
            }

            if (head.node.left != null) {
                queue.add(new TreeNodeColumnIndex(head.node.left, head.columnIndex-1));
            }
            if (head.node.right != null) {
                queue.add(new TreeNodeColumnIndex(head.node.right, head.columnIndex+1));
            }
        }

        List<List<Integer>> verticalOrderAnswer = new ArrayList<>();
        List<Integer> indexNodeValMapKeys = new ArrayList<>(indexNodeValMap.keySet());
        // O(nlogn)
        Collections.sort(indexNodeValMapKeys);

        for (Integer key : indexNodeValMapKeys) {
            verticalOrderAnswer.add(indexNodeValMap.get(key));
        }

        return verticalOrderAnswer;
    }

    class TreeNodeColumnIndex {
        TreeNode node;
        int columnIndex;

        public TreeNodeColumnIndex(TreeNode node, int columnIndex) {
            this.node = node;
            this.columnIndex = columnIndex;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

