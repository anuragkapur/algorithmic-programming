package com.anuragkapur.ib.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderNoRecursion {

    Stack<TreeNode> stack = new Stack<>();

    /**
     * RTC: O(n), where n = number of nodes in tree
     */
    public ArrayList<Integer> inorderTraversal(TreeNode A) {

        ArrayList<Integer> answer = new ArrayList<>();

        addAllLefts(A);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            answer.add(node.val);
            addAllLefts(node.right);
        }

        return answer;
    }

    private void addAllLefts(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
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
