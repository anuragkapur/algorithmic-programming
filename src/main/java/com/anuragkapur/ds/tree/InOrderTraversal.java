package com.anuragkapur.ds.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class InOrderTraversal {

    private List<Integer> result = new LinkedList<>();

    public void inOrder(TreeNode startingNode) {

        if (startingNode != null) {
            inOrder(startingNode.getLeft());
            result.add(startingNode.getKey());
            System.out.println(startingNode.getKey());
            inOrder(startingNode.getRight());
        }
    }

    public List<Integer> getResult() {
        return result;
    }

    public static void main(String[] args) {
        TreeNode rootNode = TreeFactory.getBalancedBinaryTree();
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inOrder(rootNode);
    }
}
