package com.anuragkapur.leetcode.fb2021;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeBinaryTree_297 {

    /**
     * Approach 2: Using Depth First  Traversal
     */
    private int i = 1;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursiveSerialize(root, list);
        return list.toString();
    }

    private void recursiveSerialize(TreeNode node, List<Integer> list) {

        if (node == null) {
            list.add(null);
            return;
        }

        list.add(node.val);

        recursiveSerialize(node.left, list);
        recursiveSerialize(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        // string "[" and "]"
        data = data.substring(1);
        data = data.substring(0, data.length()-1);

        // check for string with no nodes
        if (data.indexOf(",") == -1) {
            return null;
        }

        String[] nodeStrs = data.split(",");
        TreeNode root = getNode(nodeStrs[0]);
        recursiveDeserialize(root, nodeStrs);

        return root;
    }

    private void recursiveDeserialize(TreeNode node, String[] nodeStrs) {
        if (i >= nodeStrs.length) {
            return;
        }

        node.left = getNode(nodeStrs[i]);
        i++;
        if (node.left != null)
            recursiveDeserialize(node.left, nodeStrs);

        node.right = getNode(nodeStrs[i]);
        i++;
        if (node.right != null)
            recursiveDeserialize(node.right, nodeStrs);
    }

    /**
     * Approach 1: Using Breadth First  Traversal
     */
    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        List<Integer> list = new ArrayList<>();

        if (root != null)
            q.add(root);

        while (!q.isEmpty()) {
            TreeNode front = q.poll();
            if (front instanceof EmptyTreeNode) {
                list.add(null);
            } else {
                list.add(front.val);
            }
            if (!(front instanceof EmptyTreeNode)) {
                q.add(front.left == null ? new EmptyTreeNode(-1) : front.left);
                q.add(front.right == null ? new EmptyTreeNode(-1) : front.right);
            }
        }

        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if (data.indexOf(",") < 0) {
            return null;
        }

        // string "[" and "]"
        data = data.substring(1);
        data = data.substring(0, data.length() - 1);

        String[] nodes = data.split(",");

        Queue<TreeNode> q = new ArrayDeque<>();
        int i = 0;
        TreeNode root = getNode(nodes[i]);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int leftIndex = i * 2 + 1;
            int rightIndex = i * 2 + 2;
            if (leftIndex < nodes.length) {
                node.left = getNode(nodes[leftIndex]);
                if (node.left != null)
                    q.add(node.left);
            }

            if (rightIndex < nodes.length) {
                node.right = getNode(nodes[rightIndex]);
                if (node.right != null)
                    q.add(node.right);
            }
            i++;
        }

        return root;
    }

    public class EmptyTreeNode extends TreeNode {
        public EmptyTreeNode(int x) {
            super(x);
        }
    }

    private TreeNode getNode(String nodeString) {
        nodeString = nodeString.trim();
        if (nodeString.equals("null")) {
            return null;
        } else {
            int nodeVal = Integer.parseInt(nodeString);
            return new TreeNode(nodeVal);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
