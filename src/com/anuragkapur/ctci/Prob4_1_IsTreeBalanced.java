package com.anuragkapur.ctci;

import com.anuragkapur.ds.tree.TreeFactory;
import com.anuragkapur.ds.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class Prob4_1_IsTreeBalanced {

    public static boolean isTreeBalanced(TreeNode rootNode) {

        // breadth first traversal of tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);

        while(queue.peek() != null) {

            TreeNode currentNode = queue.poll();

            TreeNode leftNode = currentNode.getLeft();
            TreeNode rightNode = currentNode.getRight();

            int leftSubTreeHeight = getHeight(leftNode);
            int rightSubTreeHeight = getHeight(rightNode);

            int heightDifference =  leftSubTreeHeight -  rightSubTreeHeight;

            if(heightDifference > 1 || heightDifference < -1) {
                return false;
            }

            queue.add(leftNode);
            queue.add(rightNode);
        }

        return true;
    }

    private static int getHeight(TreeNode node) {

        if(node == null)
            return -1;

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        return(Math.max(leftHeight, rightHeight) + 1);
    }

    public static void main(String[] args) {
        System.out.println("Expected :: true :: Actual :: " + isTreeBalanced(TreeFactory.getBalancedBinaryTree()));
        System.out.println("Expected :: false :: Actual :: " + isTreeBalanced(TreeFactory.getUnBalancedBinaryTree()));
    }
}
