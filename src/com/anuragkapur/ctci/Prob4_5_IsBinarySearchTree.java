package com.anuragkapur.ctci;

import com.anuragkapur.ds.tree.TreeFactory;
import com.anuragkapur.ds.tree.TreeNode;

/**
 * @author: anuragkapur
 * @since: 10/05/2014
 */

public class Prob4_5_IsBinarySearchTree {

    private static int leftMax = Integer.MIN_VALUE;
    private static int rightMin = Integer.MAX_VALUE;

    public static boolean isBinarySearchTree(TreeNode rootNode) {

        if(rootNode == null) {
            return true;
        }

        TreeNode leftSubTree = rootNode.getLeft();
        TreeNode rightSubTree = rootNode.getRight();

        boolean leftResult = isBinarySearchTree(leftSubTree);
        boolean rightResult = isBinarySearchTree(rightSubTree);

        if (leftSubTree != null)
            leftMax = (leftSubTree.getPayload() > leftMax) ? leftSubTree.getPayload() : leftMax;
        if (rightSubTree != null)
            rightMin = (rightSubTree.getPayload() < rightMin) ? rightSubTree.getPayload() : rightMin;

        return leftResult && rightResult && (rootNode.getPayload() >= leftMax && rootNode.getPayload() <= rightMin);
    }

    public static void main(String[] args) {
        //System.out.println("Expected :: false :: Actual :: " + isBinarySearchTree(TreeFactory.getBalancedBinaryTree()));
        System.out.println("Expected :: true :: Actual :: " + isBinarySearchTree(TreeFactory.getBinarySearchTree()));
        //System.out.println("Expected :: false :: Actual :: " + isBinarySearchTree(TreeFactory.getInvalidBinarySearchTree()));
    }
}
