package com.anuragkapur.ds.tree;

/**
 * @author anuragkapur
 */
public class BSTSuccessorAndPredecessor {

    BSTMinAndMax minAndMax = new BSTMinAndMax();

    public TreeNode getSuccessor(TreeNode givenNode) {

        if (givenNode == null) {
            return null;
        }

        if (givenNode.getRight() != null) {
            return minAndMax.getMin(givenNode.getRight());
        } else {
            TreeNode ancestor = givenNode.getParent();
            while (ancestor != null && ancestor.getLeft() != givenNode) {
                givenNode = ancestor;
                ancestor = ancestor.getParent();
            }
            return ancestor;
        }
    }

    public TreeNode getPredecessor(TreeNode givenNode) {

        if (givenNode == null) {
            return null;
        }

        if (givenNode.getLeft() != null) {
            return minAndMax.getMax(givenNode.getLeft());
        } else {
            TreeNode ancestor = givenNode.getParent();
            while (ancestor != null && ancestor.getRight() != givenNode) {
                givenNode = ancestor;
                ancestor = ancestor.getParent();
            }
            return ancestor;
        }
    }
}
