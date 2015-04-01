package com.anuragkapur.ctci;

import com.anuragkapur.ds.tree.TreeFactory;
import com.anuragkapur.ds.tree.TreeNode;

/**
 * @author: anuragkapur
 * @since: 10/05/2014
 */

public class Prob4_6_FindInOrderSuccessor {

    static boolean nodeFound = false;

    public static TreeNode inOrderSuccessor(TreeNode rootNode, TreeNode successorOf) {

        if(rootNode == null)
            return null;

        TreeNode node = inOrderSuccessor(rootNode.getLeft(), successorOf);

        if(node != null)
            return node;

        if(nodeFound) {
            return rootNode;
        }

        if(rootNode.equals(successorOf))
            nodeFound = true;

        node = inOrderSuccessor(rootNode.getRight(), successorOf);
        return node;
    }

    public static void main(String[] args) {
        TreeNode rootNode = TreeFactory.getBinarySearchTree();
        TreeNode nodeToFindSuccessorOf = new TreeNode(5);

        TreeNode resultNode = inOrderSuccessor(rootNode, nodeToFindSuccessorOf);
        System.out.println(resultNode.getKey());
    }
}
